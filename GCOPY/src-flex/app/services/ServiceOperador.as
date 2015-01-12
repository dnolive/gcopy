package app.services
{
	import app.models.Operador;
	
	import core.controllers.DataService;
	import core.controllers.Gateway;
	
	import mx.controls.Alert;

	[Bindable]
	public class ServiceOperador extends DataService
	{
		private var helper: ModelLocator = ModelLocator.getInstance();
		
		public function login(operador: Operador): void {
			(new Gateway(this.endpoint))
				.setDestination(this.destination)
				.setCallBack(this.onLoginSuccess,this.onLoginFault)
				.setOperation('login')
				.setParams(operador)
				.dispatch();
		}
		
		public function logout(operador: Operador): void {
			
		}
		
		public function onLoginSuccess(data: Object): void {
			this.helper.currentUser = data.result as Operador;
		}
		
		public function onLoginFault(data: Object): void {
			Alert.show('Usuário ou senha Inválidos!', 'ERRO');
		}
		
	}
}