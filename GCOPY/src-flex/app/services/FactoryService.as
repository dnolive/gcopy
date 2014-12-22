package app.services
{
	import app.services.*;
	
	import core.controllers.IDataService;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;

	public final class FactoryService
	{
		private static var instance: FactoryService = null;
		
		public static const SETOR:Object = {service:ServiceSetor,destination:'ServiceSetor'};
		public static const OPERADOR:Object = {service:ServiceOperador,destination:'ServiceOperador'};
		public static const LOCADORA:Object = {service:ServiceLocadora,destination:'ServiceLocadora'};
		public static const EQUIPAMENTO:Object = {service:ServiceEquipamento,destination:'ServiceEquipamento'};
		public static const EQUIPALOCA:Object = {service:ServiceEquipaloca,destination:'ServiceEquipaloca'};
		public static const CONTRATO:Object = {service:ServiceContrato,destination:'ServiceContrato'};
		public static const MOVIMENTO:Object = {service:ServiceMovimento,destination:'ServiceMovimento'};
		public static const MOVIMITEM:Object = {service:ServiceMovimitem,destination:'ServiceMovimitem'};
		
		//.........................
		
		public function FactoryService(singleton:ghost) {
			FactoryService.instance = this;
		}
		
		public static function get(SERVICE:Object):IDataService {
			if (FactoryService.instance==null) {
				new FactoryService(new ghost());
			}
			var aux: IDataService = new (SERVICE.service)();
			aux.endpoint = ModelLocator.getInstance().RO_ENDPOINT;
			aux.destination = SERVICE.destination;
			return aux;
		}
		
	}
}

internal class ghost {}