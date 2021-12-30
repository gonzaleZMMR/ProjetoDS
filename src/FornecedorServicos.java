import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import UpdateEvents.UpdateEventBellDetector;
import UpdateEvents.UpdateEventButton;
import UpdateEvents.UpdateEventInteligentLamp;
import UpdateEvents.UpdateEventMovementDetector;
import UpdateEvents.UpdateEventOpenDetector;
import i18n.I18N;
import sensores.BellDetector;
import sensores.InteligentLamp;


public class FornecedorServicos {
	
	boolean lampadaInteligente = false;
	boolean campainhaInteligente = false;
	static boolean userCego = false;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH");  
	
	public void setLampadaInteligente() {
		 lampadaInteligente = true;
	}
	
	public void setCampainhaPorta() {
		campainhaInteligente = true;
	}
	
	public void setCego() {
		userCego = true;
	}
	
	public static void writeOrSpeak(String string) {
		if(userCego == false) {
			System.out.println(string);
		}else {
			//vai falar
			Voice voice;//Creating object of Voice class
			voice = VoiceManager.getInstance().getVoice("kevin");//Getting voice
			
			if (voice != null) {
	            voice.allocate();//Allocating Voice
	        }try{
			
			voice.setRate(150);//Setting the rate of the voice
            voice.setPitch(180);//Setting the Pitch of the voice
            voice.setVolume(4);//Setting the volume of the voice
	        	        
	        voice.speak(string);//Calling speak() method     
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }
		 }
	}

	public FornecedorServicos() {
		
		//Inicializar Besirk
        BezirkMiddleware.initialize();
        final Bezirk bezirk = BezirkMiddleware.registerZirk("Fornecedor Servicos Zirk");
        System.err.println("Got Bezirk instance \n");
   
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
                        
                        writeOrSpeak("Asking for Help");
                        
                        //Mensagem de para exterior
                        MensagemExterior mensagem = new MensagemExterior("Pedido de ajuda Requisitado ", "913651651");
                		mensagem.sendMessage();
                		
                		if(lampadaInteligente){
                			  System.out.println("\nA acender luzez ...");
                			InteligentLamp il = new InteligentLamp(); 
                			il.sendInteligentLampUpdate();
                		}
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
                                      
                    LocalDateTime now = LocalDateTime.now();  
                                        
                    //do something in response to this event
                   if (movUpdate.getActualState()) {
                        System.out.println("Movimento Detetado!");
                        
                       if(now.isAfter(movUpdate.getInitialDateTime()) && now.isBefore(movUpdate.getEndDateTime())) {                   	
                    	    //Mensagem de para exterior
                            MensagemExterior mensagem = new MensagemExterior("Foi Detetado Movimento ", "913651651");
                   			mensagem.sendMessage();
                       }
                              	
                		if(lampadaInteligente && (now.isAfter(movUpdate.getInitialDateTimeLuzes()) && now.isBefore(movUpdate.getEndDateTimeLuzes()))){
                				System.out.println("\nA acender luzes ...");
	                			InteligentLamp il = new InteligentLamp(); 
	                			il.sendInteligentLampUpdate();
                		}else {
                			System.out.println("Ainda nao esta na hora acender as luzes!");
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
                
                System.err.println("\nLuzes Ligadas " + luzUpdate.toString());
                                
                //do something in response to this event
                if (luzUpdate.getActualState()) {
                	                	                                                                     
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
                
                LocalDateTime now = LocalDateTime.now();
                System.err.println("\nPorta Aberta" + doorUpdate.toString());
                                
                //do something in response to this event
                if (doorUpdate.getActualState()) {
                    System.out.println("Porta Aberta!");
                    
            		if(campainhaInteligente && (now.isAfter(doorUpdate.getInitialDateTime()) && now.isBefore(doorUpdate.getEndDateTime()))){
            			
        				System.out.println("\nA tocar campainha ...");
        				BellDetector Bell = new BellDetector(); 
        				Bell.sendBellDetectorUpdate();
        				
        				//Mensagem de para exterior
                        MensagemExterior mensagem = new MensagemExterior("A porta foi Aberta ", "913651651");
                		mensagem.sendMessage();
            			
	        		}else {
	        			System.out.println("Ainda nao esta na hora de tocar a campainha!");
	        		}                                       
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
