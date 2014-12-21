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
		
		protected var cursor:IViewCursor;
		protected var currentItem:Object;
		protected var currentIndex:int;
		protected var filter:Function;
		
		protected var source:String = '';
		protected var endpoint:String = '';
		protected var destination:String = '';
		
		//......................................
		
		public function DataService() {
			this.reset();
			this.sortField = new SortField('id');
		}
		
		public function reset():void {
			this._collection  = null;
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
			(Gateway.getInstance(this.endpoint))
				.setDestination(this.destination)
				.setOperation('getAll')
				.setResponder(this)
				.dispatch();
		}
		
		public function getByID(id:Number):void {
			(Gateway.getInstance(this.endpoint))
				.setDestination(this.destination)
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
				(Gateway.getInstance(this.endpoint))
					.setOperation(this.action==ACTION_SAVE?'save':'delete')
					.setDestination(this.destination)
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
		
		public function set collection(source:IList):void {
			if (this._collection != null) {
				this._collection.removeAll();
			} else {
				this._collection = new ArrayCollection;
			}
			(this._collection as ArrayCollection).addAll(source);
		}
		
		public function get collection():IList {
			return this._collection;
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
			(this._collection as ArrayCollection).filterFunction = this.filter = filterFunction;
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
			Alert.show('falhou');
		}

	}		
}