package app.models
{
	[Bindable]
	[RemoteClass(alias="br.com.dnolive.models.Operador")]
	public class Operador
	{
		public var id: Number;
		public var nome: String;
		public var login: String;
		public var senha: String;
		public var ativo: String;
		
		public function Operador()
		{
		}
		
		public function toString(): String {
			return 'id: '+id+'\n'+
				'nome: '+nome+'\n'+ 
				'login: '+login+'\n'+ 
				'senha: '+senha+'\n';
		}
	}
}