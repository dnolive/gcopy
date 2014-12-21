package app.services
{
	import core.controllers.DataService;

	[Bindable]
	public class ServiceOperador extends DataService
	{
		public function ServiceOperador() {
			this.endpoint = ModelLocator.getInstance().RO_ENDPOINT;
			this.destination = 'ServiceOperador';
		}
	}
}