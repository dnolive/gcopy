package app.services
{
	import core.controllers.DataService;

	public class ServiceSetor extends DataService
	{
		public function ServiceSetor() {
			this.endpoint = ModelLocator.getInstance().RO_ENDPOINT;
			this.destination = 'ServiceSetor';
		}
	}
}