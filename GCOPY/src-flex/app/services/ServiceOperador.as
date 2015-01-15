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
				.setCallBack(this.onLoginSuccess,this.onLoginFault)
				.setDestination(this.destination)
				.setOperation('login')
				.setParams(operador)
				.dispatch();
		}
		
		public function logout(operador: Operador): void {
			this.helper.currentUser = null;
		}
		
		public function onLoginSuccess(data: Object): void {
			this.helper.currentUser = data.result as Operador;
		}
		
		public function onLoginFault(info: Object): void {
			Alert.show('Usuário ou Senha Inválidos!');
		}
		
	}
}