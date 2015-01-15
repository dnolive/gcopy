package app.services
{
	import app.models.*;
	
	import core.controllers.*;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	import spark.components.BorderContainer;
	import spark.components.TitleWindow;

	[Bindable]
	public class ModelLocator
	{
		private static var instance:ModelLocator;
		
		/*....................................
		* DEFINIÇÃO DAS VARIÁVEIS DE USO GERAL
		*...................................*/
		
		[Embed(source='assets/images/confirmation_32.png')]
		public const icoConfirmation:Class;
		
		[Embed(source='assets/images/information_32.png')]
		public const icoInformation:Class;
		
		[Embed(source='assets/images/success_32.png')]
		public const icoSuccess:Class;
		
		[Embed(source='assets/images/stop_32.png')]
		public const icoStop:Class;
		
		[Embed(source='assets/images/alert_32.png')]
		public const icoAlert:Class;
		
		[Embed(source='assets/images/error_32.png')]
		public const icoError:Class;
		
		/*
		* Constantes para configuração de calendários
		*/
		
		public const CHAR_WEEK_DAYS:Array = [
			'D','S','T','Q','Q','S','S'
		];
		
		public const ABREV_WEEK_DAYS:Array = [
			'Dom','Seg','Ter','Qua','Qui','Sex','Sab'
		];
		
		public const WEEK_DAYS:Array = [
			'Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'
		];
		
		public const YEAR_MONTHS:Array = [
			'Janeiro','Fevereiro','Março','Abril','Maio','Junho',
			'Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'
		];
		
		public const FORMAT_DATE:String = 'DD/MM/YYYY';
		
		/*
		* Variáveis e constantes para controle dos estados da tela principal.
		*/
		
		public const RO_ENDPOINT:String = 'http://localhost:8400/gcopy/messagebroker/amf';
		
		public const STATE_LOGON:String  = 'logon';
		public const STATE_LOGOFF:String = 'logoff';
		
		//contém o container dos modulos.
		public var desktop:BorderContainer;
		//contém o formulário de login.
		public var formLogin:TitleWindow;
		//contém o accordion selecionado
		public var currentSelectedMenu:int;
		//controla o modulo atual em execução
		public var currentModule:Class;
		//controla o estado atual do operador
		public var currentState:String = STATE_LOGOFF; 
		//
		public var _serviceFactory:FactoryService;
		
		//contém o usuário corrente logado
		private var _currentUser:Operador; 
		
		//construtor da classe
		public function ModelLocator(singleton:ghost) {

			//faz configurações diversas na instanciação da classe
			
			Alert.yesLabel 	  = 'Sim';
			Alert.noLabel	  = 'Não';
			Alert.cancelLabel = 'Cancelar';
			Alert.okLabel 	  = 'OK';
			
			//fim das configurações
			instance = this;
		}
		
		public function get currentUser(): Operador {
			return this._currentUser;
		}
		
		public function set currentUser(user: Operador): void {
			this._currentUser = user;
			if (this._currentUser==null) {
				this.currentState = STATE_LOGOFF;
			} else {
				this.currentState = STATE_LOGON;
			}
		}
		
		//instanciador da classe
		public static function getInstance():ModelLocator {
			if (instance == null) new ModelLocator(new ghost);
			return instance;
		}
		
		/*.............................................
		* DEFINIÇÃO DE VARIÁVEIS ESPECÍFICAS DO SISTEMA
		*............................................*/
		
		/*/serviços de dados  
		public var serviceSetor:DataService;
		public var serviceOperador:DataService;
		public var serviceEquipamento:DataService;
		public var serviceEquipaloca:DataService;
		public var serviceMovimento:DataService;
		public var serviceMovimitem:DataService;
		public var serviceLocadora:DataService;
		public var serviceContrato:DataService;

		public function getService(service:Class):DataService {
			return FactoryService.get(service);
		}
		/*/
	}
}

class ghost {}