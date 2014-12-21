package app.models
{
	[Bindable]
	[RemoteClass(alias="br.com.dnolive.models.Equipamento")]
	public class Equipamento
	{
		public var id: Number;
		public var nome: String;
		public var ativo: String='S';
		
		public function Equipamento() {
		}
	}
}