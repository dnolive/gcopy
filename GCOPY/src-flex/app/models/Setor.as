package app.models
{
	[Bindable]
	[RemoteClass(alias="br.com.dnolive.models.Setor")]
	public class Setor
	{
		public var id: Number;
		public var nome: String;
		public var ativo: String='S';
		
		public function Setor() {
		}
	}
}