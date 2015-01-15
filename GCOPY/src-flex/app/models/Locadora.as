package app.models
{
	[Bindable]
	[RemoteClass(alias="app.models.Locadora")]
	public class Locadora
	{
		public var id: Number;
		public var nome: String;
		public var ativo: String='S';
		
		public function Locadora() {
		}
	}
}