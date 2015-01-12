package app.models
{
	[Bindable]
	[RemoteClass(alias="br.com.dnolive.models.Movimitem")]
	public class Movimitem
	{
		public var id: Number;
		public var movimento: Movimento;
		public var equipamento: Equipaloca;
		public var setor: Setor;
		public var leituraAnterior: int;
		public var leituraAtual: int;
		
		public function Movimitem() {
		}
	}
}