package core.controllers
{
	import app.services.ModelLocator;
	
	import core.controllers.IDataService;
	
	import mx.collections.ArrayCollection;
	import mx.collections.IList;
	import mx.collections.IViewCursor;
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	import mx.rpc.IResponder;
	import mx.rpc.events.ResultEvent;
	
	import spark.collections.Sort;
	import spark.collections.SortField;

	[Bindable]
	public class DataService implements IDataService
	{
		private const ACTION_SAVE:int = 0;
		private const ACTION_REMOVE:int = 1;
		
		private var sort:Sort;
		private var sortField:SortField;
		
		private var action:int = -1;
		private var bean:Object = null;
		
		private var _collection:IList;
		private var _filtered: Boolean;
		
		protected var cursor:IViewCursor;
		protected var currentItem:Object;
		protected var currentIndex:int;
		protected var filter:Function;
		
		private var _source:String = '';
		private var _endpoint:String = '';
		private var _destination:String = '';
		
		//......................................
		
		public function DataService() {
			this.reset();
			this.sortField = new SortField('id');
		}
		
		public function reset():void {
			this._collection  = null;
			this._filtered	  = false;
			this.currentItem  = null;
			this.currentIndex = -1;
			this.sort		  = null;
			this.sortField	  = null;
			this.cursor		  = null;
			this.filter		  = null;
		}
		
		//
		//comandos básicos de acesso remoto
		//
		
		public function getAll():void {
			(Gateway.getInstance(this._endpoint))
				.setDestination(this._destination)
				.setOperation('getAll')
				.setResponder(this)
				.dispatch();
		}
		
		public function getByID(id:Number):void {
			(Gateway.getInstance(this._endpoint))
				.setDestination(this._destination)
				.setResponder(this)
				.setOperation('getByID')
				.setParams(id)
				.dispatch();
		}
		
		public function save(o:Object):void {
			this.bean = o;
			this.action = this.ACTION_SAVE;
			Alert.show('Confirma SALVAR ítem editado?', 
				'ATENÇÃO', Alert.YES+Alert.NO, 
				null, this.onCloseAlert, 
				null, Alert.YES
			);
		}
		
		public function remove(o:Object):void {
			this.bean = o;
			this.action = this.ACTION_REMOVE;
			Alert.show('Confirma EXCLUIR o ítem selecionado?\n\n'+o.toString(), 
				'ATENÇÃO',Alert.YES+Alert.NO, 
				null, this.onCloseAlert,
				null, Alert.NO
			);
		}
		
		//closealert para métodos save e remove
		private function onCloseAlert(event:CloseEvent):void {
			if (event.detail == Alert.YES) {
				(Gateway.getInstance(this._endpoint))
					.setDestination(this.toString())
					.setOperation(this.action==ACTION_SAVE?'save':'delete')
					.setResponder(this)
					.setParams(this.bean)
					.dispatch();
			}
		}
		
		public function gotoItem():void {
			this.cursor = null;
			this.cursor = (this._collection as ArrayCollection).createCursor();
			this.cursor.findFirst(this.currentItem);
		}
		
		//................setters
		
		public function get endpoint(): String {
			return this._endpoint;
		}
		public function set endpoint(endpoint: String): void {
			this._endpoint = endpoint;
		}
		
		public function get destination(): String {
			return this._destination;
		}
		public function set destination(destination: String): void {
			this._destination = destination;
		}
		
		public function get collection():IList {
			return this._collection;
		}
		public function set collection(source:IList):void {
			if (this._collection != null) {
				this._collection.removeAll();
			} else {
				this._collection = new ArrayCollection;
			}
			(this._collection as ArrayCollection).addAll(source);
		}
		
		public function get filtered(): Boolean {
			return this._filtered;
		}
		public function set filtered(filtered: Boolean): void {
			this._filtered = filtered;
			if (this._filtered) {
				(this._collection as ArrayCollection).filterFunction = this.filter;
			} else {
				(this._collection as ArrayCollection).filterFunction = null;
			}
			this.refresh();
		}
		
		public function refresh(): void {
			(this._collection as ArrayCollection).refresh();
		}
		
		public function setSortField(field:String):IDataService {
			this.sortField = null;
			this.sortField = new SortField(field, true);
			//
			this.sort = null;
			this.sort = new Sort();
			this.sort.fields = [this.sortField];
			//
			return this;
		}

		public function setFilter(filterFunction:Function):void {
			this.filter = filterFunction;
		}
		
		//.............getters
		
		public function getIndexOf(field:String, key:*):int {
			if (this._collection)
				for (var i:int = 0; i < this._collection.length; i++) {
					if (this._collection.getItemAt(i)[field] == key) return i;
				}
			return -1;
		}
		
		public function getItemOf(field:String, key:*):Object {
			if (this._collection)
				for (var i:int = 0; i < this._collection.length; i++) {
					var item:Object = this._collection.getItemAt(i);
					if (item[field] == key) return item;
				}				
			return null;
		}
		
		public function getItemIndex():int {
			return this.getIndexOf('id', this.currentItem.id);
		}
		
		public function getCurrentIndex():int {
			this.currentIndex = this.getItemIndex();
			return this.currentIndex;
		}

		public function result(data:Object):void { 
			if (data.result is ArrayCollection) {
				this.collection = data.result as IList;
			} else {
				this.bean = data.result as Object;
			}
		}
		
		public function fault(info: Object): void {
			Alert.show('FALHA NA REQUISIÇÃO.\n\n'+
				'EndPoint: '+this._endpoint+'\n'+
				'Destination: '+this._destination, 
				'Ops!');
		}

		public function toString(): String {
			return this.toString();
		}
		
	}		
}