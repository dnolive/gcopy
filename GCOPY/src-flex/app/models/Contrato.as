package app.models
{
	[Bindable]
	[RemoteClass(alias="app.models.Contrato")]
	public class Contrato
	{
		public var locadora: Locadora;
		public var dataInicio: Date;
		public var dataTermino: Date;
		public var valorCopia: Number;
		public var ativo: String='S';
		
		public function Contrato() {
		}
	}
}