package app.models
{
	[Bindable]
	[RemoteClass(alias="br.com.dnolive.models.Equipaloca")]
	public class Equipaloca
	{
		public var equipamento: Equipamento;
		public var locadora: Locadora;
		public var serie: String;
		public var ativo: String='S';
		
		public function Equipaloca() {
		}
	}
}