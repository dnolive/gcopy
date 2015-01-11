package app.models
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.dnolive.models.Movimento")]
	public class Movimento
	{
		public var id: Number;
		public var nome: String;
		public var ativo: String='S';
		public var locadora: Locadora;
		public var contrato: Contrato;
		public var operador: Operador;
		public var data: Date=new Date;
		public var referencia: Date=new Date;
		public var leiturista: String;
		public var valorCopia: Number;
		public var quantCopia: int;
		public var totalCopia: Number;
		public var status: String='A';
		public var itensMovimento:ArrayCollection=new ArrayCollection;
		
		public function Movimento() {
		}
	}
}