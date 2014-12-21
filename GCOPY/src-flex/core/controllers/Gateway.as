package core.controllers
{
	import mx.controls.Alert;
	import mx.messaging.Channel;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.AbstractOperation;
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	
	public class Gateway
	{
		private var channel:Channel;
		private var channelSet:ChannelSet;
		private var endpoint:String;
		private var destination:String;
		private var source:String;
		private var operation:String;
		private var params:*;
		private var responder:IResponder;
		
		private var onResult:Function;
		private var onFault:Function;
		
		private static var instance:Gateway = null;
		
		public function Gateway(SINGLETON:ghost) {
			//
			if (SINGLETON==null) {
				return;	
			}
			//
			channelSet = new ChannelSet();
			channel = new AMFChannel('my-amf', this.endpoint=SINGLETON.endpoint);
			channelSet.addChannel(channel);
			//
			instance = this;
		}

		/**
		 * Obtém uma instancia da Classe
		 * @author Denerson Nobre
		 * @param endpoint Recebe o endpoint
		 * @return Gateway
		 */
		public static function getInstance(endpoint:String):Gateway {
			if (instance==null) new Gateway(new ghost(endpoint));
			return instance;
		}
		
		/** 
		 * Dispara o evento remoto previamente configurado. 
		 */
		public function dispatch(): void {
			var ro:RemoteObject = new RemoteObject(this.destination);
			ro.showBusyCursor = true; ro.channelSet = channelSet;
			var op:AbstractOperation=ro.getOperation(this.operation);
			var token:AsyncToken=(this.params==null)?op.send():op.send(this.params);
			if (this.responder == null) {
				token.addResponder(new mx.rpc.Responder(this.onResult, this.onFault));
			} else {
				token.addResponder(this.responder);
			}
			
		}

		
		public function setCallBack(onResult:Function, onFault:Function):Gateway {
			this.onResult = (onResult==null) ? _onResult : onResult;
			this.onFault = (onFault==null) ?_onFault : onFault;
			return this;
		}
		
		public function setEndPoint(endpoint:String):Gateway {
			this.endpoint = endpoint;
			return this;
		}
		
		public function setDestination(destination:String):Gateway {
			this.destination = destination;
			return this;
		}
		
		public function setSource(source:String):Gateway {
			this.source = source;
			return this;
		}
		
		public function setOperation(operation:String):Gateway {
			this.operation = operation;
			return this;
		}
		
		public function setParams(params:*):Gateway {
			this.params = params;
			return this;
		}
		
		public function setResponder(responder:IResponder):Gateway {
			this.responder = responder;
			return this;
		}
		
		private function _onResult(result:ResultEvent):void {
			Alert.show('Requisição concluída com sucesso.', 'OK!');
		}
		
		private function _onFault(result:FaultEvent):void {
			Alert.show('Falha na requisição da operação.', 'OPS!');
		}
	
	}
	
}

class ghost {
	public var endpoint:String;
	public function ghost(endpoint:String) {
		this.endpoint = endpoint;
	}
}
