package app.models
{
	[Bindable]
	[RemoteClass(alias="app.models.Equipamento")]
	public class Equipamento
	{
		public var id: Number;
		public var nome: String;
		public var serie: String;
		public var ativo: String='S';
		public var locadora: Locadora;
		
		public function Equipamento() {
		}
	}
}