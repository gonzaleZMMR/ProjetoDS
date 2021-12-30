import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;

import UpdateEvents.UpdateEventBellDetector;
import UpdateEvents.UpdateEventButton;
import UpdateEvents.UpdateEventInteligentLamp;
import UpdateEvents.UpdateEventMovementDetector;
import UpdateEvents.UpdateEventOpenDetector;
import i18n.I18N;
import sensores.InteligentLamp;


public class FornecedorServicos {
	
	boolean luzesAutomaticas = false;
	static boolean userCego = false;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH");  
	
	public void setLuzesAutomaticas() {
		 luzesAutomaticas = true;
	}
	
	public void setCego() {
		userCego = true;
	}

	public FornecedorServicos() {
		
		//Inicializar Besirk
        BezirkMiddleware.initialize();
        final Bezirk bezirk = BezirkMiddleware.registerZirk("Fornecedor Servicos Zirk");
        System.err.println("Got Bezirk instance");
   
        //Botao Inteligente
        final EventSet botaoEvent = new EventSet(UpdateEventButton.class);       
        botaoEvent.setEventReceiver(new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                //Check if this event is of interest
                if (event instanceof Event) {
                    final UpdateEventButton btnUpdate = (UpdateEventButton) event;
                    
                    System.err.println("\nReceived botao update: " + btnUpdate.toString());
                                    
                    //do something in response to this event
                    if (btnUpdate.getActualState()) {
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
        final EventSet movimentoEvent = new EventSet(UpdateEventMovementDetector.class);        
        movimentoEvent.setEventReceiver(new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                //Check if this event is of interest
                if (event instanceof Event) {
                    final UpdateEventMovementDetector movUpdate = (UpdateEventMovementDetector) event;
                    
                    System.err.println("\nMovimento Detetado " + movUpdate.toString());
                    
                    /*Fazer as coisas do tempo */
                                    
                    //do something in response to this event
                    if (movUpdate.getActualState()) {
                        System.out.println("Movimento Detetado!");
                        
                        //Mensagem de para exterior
                        MensagemExterior mensagem = new MensagemExterior("Foi Detetado Movimento ", "913651651");
                		mensagem.sendMessage();
                		
                		if(luzesAutomaticas) {
                			System.out.println("A LIGAR LUZES AUTOMATICAS PORQUE FOI DETETADO MOVIMENTO");
	                			InteligentLamp il = new InteligentLamp(); 
	                			il.sendInteligentLampUpdate();
                		}
                		
                    }                      
                }
            }
        });
        bezirk.subscribe(movimentoEvent);     
    
	
	//Luzes automaticas
    final EventSet luzesEvent = new EventSet(UpdateEventInteligentLamp.class);        
    luzesEvent.setEventReceiver(new EventSet.EventReceiver() {
    	
        @Override
        public void receiveEvent(Event event, ZirkEndPoint sender) {
            //Check if this event is of interest
            if (event instanceof Event) {
                final UpdateEventInteligentLamp luzUpdate = (UpdateEventInteligentLamp) event;
                
                System.err.println("\nLuzes Ligadas" + luzUpdate.toString());
                                
                //do something in response to this event
                if (luzUpdate.getActualState()) {
                	
                	 
                     System.out.println("Luzes so devem acender entre:" + luzUpdate.getInitialDateTime() + "e" + luzUpdate.getInitialDateTime());                                
                    
                    //Mensagem de para exterior
                    MensagemExterior mensagem = new MensagemExterior("As Luzes Ligadas ", "913651651");
            		mensagem.sendMessage();
                }else {
                	 System.out.println("Luzes Apagadas por Timeout!");
                }
            }
        }
    });
    bezirk.subscribe(luzesEvent); 
    
    
    //Abertura Porta
    final EventSet portaEvent = new EventSet(UpdateEventOpenDetector.class);        
    portaEvent.setEventReceiver(new EventSet.EventReceiver() {
    	
        @Override
        public void receiveEvent(Event event, ZirkEndPoint sender) {
            //Check if this event is of interest
            if (event instanceof Event) {
                final UpdateEventOpenDetector doorUpdate = (UpdateEventOpenDetector) event;
                
                System.err.println("\nPorta Aberta" + doorUpdate.toString());
                                
                //do something in response to this event
                if (doorUpdate.getActualState()) {
                    System.out.println("Porta Aberta!");
                    
                    //Mensagem de para exterior
                    MensagemExterior mensagem = new MensagemExterior("A porta foi Aberta ", "913651651");
            		mensagem.sendMessage();
                }
            }
        }
    });
    bezirk.subscribe(portaEvent); 
    
    //Toque Campainha
    final EventSet campainhaEvent = new EventSet(UpdateEventBellDetector.class);        
    campainhaEvent.setEventReceiver(new EventSet.EventReceiver() {
    	
        @Override
        public void receiveEvent(Event event, ZirkEndPoint sender) {
            //Check if this event is of interest
            if (event instanceof Event) {
                final UpdateEventBellDetector bellUpdate = (UpdateEventBellDetector) event;
                
                System.err.println("\nCampainha tocou" + bellUpdate.toString());
                                
                //do something in response to this event
                if (bellUpdate.getActualState()) {
                    System.out.println("Campainha tocou!");
                    
                    //Mensagem de para exterior
                    MensagemExterior mensagem = new MensagemExterior("A Campainha tocou ", "913651651");
            		mensagem.sendMessage();
                }
            }
        }
    });
    bezirk.subscribe(campainhaEvent); 
}
	
	public static void main(String[] args) {
		new FornecedorServicos();
		
		if(userCego) {
			System.out.println("USER É CEGO BAMOS DITAR AS CENAS");
		}
	}

}
