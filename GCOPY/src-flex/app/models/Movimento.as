package app.models
{
	[Bindable]
	[RemoteClass(alias="br.com.dnolive.models.Movimento")]
	public class Movimento
	{
		public var id: Number;
		public var nome: String;
		public var ativo: String='S';
		
		public function Movimento() {
		}
	}
}