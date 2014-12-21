package app.services
{
	import app.services.*;
	
	import core.controllers.IDataService;
	
	import mx.collections.ArrayCollection;

	public class FactoryService
	{
		private static var instance: FactoryService = null;
		
		public static const SETOR:Class = ServiceSetor;
		public static const OPERADOR:Class = ServiceOperador;
		public static const LOCADORA:Class = ServiceLocadora;
		public static const EQUIPAMENTO:Class = ServiceEquipamento;
		public static const EQUIPALOCA:Class = ServiceEquipaloca;
		public static const CONTRATO:Class = ServiceContrato;
		public static const MOVIMENTO:Class = ServiceMovimento;
		public static const MOVIMITEM:Class = ServiceMovimitem;
		
		//.........................
		
		public function FactoryService(singleton:ghost) {
			FactoryService.instance = this;
		}
		
		public static function get(service:Class):IDataService {
			if (FactoryService.instance==null) {
				new FactoryService(new ghost());
			}
			return new service();
		}
		
	}
}

internal class ghost {}