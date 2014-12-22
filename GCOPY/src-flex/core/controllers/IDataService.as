package core.controllers
{
	import mx.collections.IList;
	import mx.rpc.IResponder;
	
	public interface IDataService extends IResponder
	{
		function reset():void;
		function gotoItem():void;
		function refresh(): void;
		
		//
		//comandos básicos de acesso remoto
		//
		
		function getAll():void;
		
		function getByID(id:Number):void;
		
		function save(o:Object):void;
		
		function remove(o:Object):void;
		
		//................getters && setters
		
		function get endpoint(): String;
		function set endpoint(endpoint: String): void;
		
		function get destination(): String;
		function set destination(destination: String): void;
		
		function get collection():IList;
		function set collection(source:IList):void;
		
		function get filtered(): Boolean;
		function set filtered(filtered: Boolean): void;
		
		function getIndexOf(field:String, key:*):int;
		
		function getItemOf(field:String, key:*):Object;
		
		function getItemIndex():int;
		
		function getCurrentIndex():int;
		
		function setSortField(field:String):IDataService;
		
		function setFilter(filterFunction:Function):void;
		
		function toString(): String;
		
	}
}