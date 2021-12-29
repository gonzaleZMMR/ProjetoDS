import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;

import i18n.I18N;
import sensores.UpdateEvent;

public class FornecedorServicos {

	public FornecedorServicos() {
		
		//Inicializar Besirk
        BezirkMiddleware.initialize();
        final Bezirk bezirk = BezirkMiddleware.registerZirk("Fornecedor Servicos Zirk");
        System.err.println("Got Bezirk instance");
   
        //Botao Inteligente
        final EventSet botaoEvent = new EventSet(UpdateEvent.class);        
        botaoEvent.setEventReceiver(new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                //Check if this event is of interest
                if (event instanceof Event) {
                    final UpdateEvent aqUpdate = (UpdateEvent) event;
                    
                    System.err.println("\nReceived botao update: " + aqUpdate.toString());
                                    
                    //do something in response to this event
                    if (aqUpdate.getActualState()) {
                        System.out.println("Pedido de ajuda Requisitado");
                        
                        //Mensagem de para exterior
                        MensagemExterior mensagem = new MensagemExterior("Pedido de ajuda Requisitado ", "913651651");
                		mensagem.sendMessage();
                    }              
                }
            }
        });
        bezirk.subscribe(botaoEvent);
        
        
        //Detertor de Movimento, com luzes automaticas
        final EventSet movimentoEvent = new EventSet(UpdateEvent.class);        
        movimentoEvent.setEventReceiver(new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                //Check if this event is of interest
                if (event instanceof Event) {
                    final UpdateEvent aqUpdate = (UpdateEvent) event;
                    
                    System.err.println("\nMovimento Detetado " + aqUpdate.toString());
                    
                    /*Fazer as coisas do tempo */
                                    
                    //do something in response to this event
                    if (aqUpdate.getActualState()) {
                        System.out.println("Movimento Detetado!");
                        
                        //Mensagem de para exterior
                        MensagemExterior mensagem = new MensagemExterior("Foi Detetado Movimento ", "913651651");
                		mensagem.sendMessage();
                    }                      
                }
            }
        });
        bezirk.subscribe(movimentoEvent);
        
        
        
        
    }
	
	
	
	public static void main(String[] args) {
		new FornecedorServicos();

	}

}
