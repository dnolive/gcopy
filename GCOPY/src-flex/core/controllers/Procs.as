package core.controllers
{
	import flash.display.DisplayObject;
	
	import mx.collections.IList;
	import mx.core.Application;
	import mx.formatters.DateFormatter;
	import mx.managers.PopUpManager;
	
	import spark.components.TitleWindow;
	
	public final class Procs
	{
		/**
		 * Procurar um elemento em uma coleção e devolver o seu índice.
		 * Será pesquisado um valor em um atributo especificado.
		 * 
		 * @param (collection) A coleção de elementos a ser pesquisada.
		 * @param (field) O atributo de um objeto da coleção
		 * @param (key) A chave(elemento) a procurar.
		 * 
		 * @return (int) O índice do elemento na coleção.
		 */
		public static function getIndexOf(collection:IList, field:String, key:*):int
		{
			if (collection)
			for (var i:int = 0; i < collection.length; i++)	{
				if (collection.getItemAt(i)[field] == key) return i;		
			}
			return -1;
		}
		
		/**
		 * Procurar um elemento em uma coleção e devolver o seu objeto.
		 * Será pesquisado um valor em um atributo especificado.
		 * 
		 * @param (collection) A coleção de elementos a ser pesquisada.
		 * @param (field) O atributo de um objeto da coleção
		 * @param (key) A chave(elemento) a procurar.
		 * 
		 * @return (Object) O objeto do elemento na coleção.
		 */
		public static function getItemOf(collection:IList, field:String, key:*):Object
		{
			if (collection)
			for each (var item:Object in collection) {
				if (item[field] == key) return item;		
			}
			return null;
		}
		
		/**
		 * Acrescentar zeros à esquerda de um numero passado como String.
		 * 
		 * @param (num) O número a ser modificado.
		 * @param (len) O tamanho esperado do numero que retornará;
		 * 
		 * @return (String) String que corresponde ao resultado esperado.
		 */
		public static function zeroLeft(num:String, len:uint):String
		{
			var result:String = '';
			len = Math.abs(num.length - len);
			for (var i:uint = 0; i < len; i++) result += '0'; 	
			return result += num; 
		}
	
		//....................................................................................

		public static function strToDate(date:String):Date
		{
			var result:Date = null;
			if (date != '') 
			{
				var dia:String = date.substr(0, 2);
				var mes:String = date.substr(3, 2);
				var ano:String = date.substr(6, 10);
				result = new Date(int(ano), int(mes)-1, int(dia));
			}
			return result;
		}

		public static function getDay(date:Date):String
		{
			var result:String = '';
			if (date != null) 
			{
				var data:String = dateToStr(date); 
				result = data.substr(0, 2);
			}
			return result;
		}

		public static function getMonth(date:Date):String
		{
			var result:String = '';
			if (date != null) 
			{
				var data:String = dateToStr(date); 
				result = data.substr(3, 2);
			}
			return result;
		}

		public static function getYear(date:Date):String
		{
			var result:String = '';
			if (date != null) 
			{
				var data:String = dateToStr(date); 
				result = data.substr(6, 10);
			}
			return result;
		}

		public static function dateToStr(data:Date, format:String = 'DD/MM/YYYY'):String
		{
			if ( ! data ) return '';
			//
			var formatter:DateFormatter = new DateFormatter();
			formatter.formatString = format;
			return formatter.format(data);
		}
		
		/*public static function popUp(popup:Class, parent:DisplayObject = null, 
			data:* = null,  modal:Boolean = true, center:Boolean = true):void
		{
			parent = parent ? parent : Application.application as DisplayObject;
			//
			var pop:TitleWindow = new popup;	
			pop.data = data;
			//
			PopUpManager.addPopUp(pop, parent, modal);
			//
			if (center) PopUpManager.centerPopUp(pop);
		} */
	}
}