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
import i18n.Messages;
import sensores.BellDetector;
import sensores.InteligentLamp;

import static i18n.Messages.*;





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
        writeOrSpeak(I18N.getString(BEZIRK_INSTANCE));
   
        //Botao Inteligente
        final EventSet botaoEvent = new EventSet(UpdateEventButton.class);       
        botaoEvent.setEventReceiver(new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                //Check if this event is of interest
                if (event instanceof Event) {
                    final UpdateEventButton btnUpdate = (UpdateEventButton) event;
                    
                    writeOrSpeak(I18N.getString(BOTAO_UPDATE) + btnUpdate.toString());
                    
                                    
                    //do something in response to this event
                    if (btnUpdate.getActualState()) {
                        
                        writeOrSpeak(I18N.getString(PEDIDO_AJUDA));
                        
                        //Mensagem de para exterior
                        MensagemExterior mensagem = new MensagemExterior(I18N.getString(PEDIDO_AJUDA), "913651651");
                		mensagem.sendMessage();
                		
                		if(lampadaInteligente){
                			  writeOrSpeak(I18N.getString(ACENDER_LUZ));
                			  
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
                        
                        writeOrSpeak(I18N.getString(LIGAR_MOVIMENTO));
                        
                       if(now.isAfter(movUpdate.getInitialDateTime()) && now.isBefore(movUpdate.getEndDateTime())) {                   	
                    	    //Mensagem de para exterior
                            MensagemExterior mensagem = new MensagemExterior(I18N.getString(LIGAR_MOVIMENTO), "913651651");
                   			mensagem.sendMessage();
                       }
                              	
                		if(lampadaInteligente && (now.isAfter(movUpdate.getInitialDateTimeLuzes()) && now.isBefore(movUpdate.getEndDateTimeLuzes()))){
                				System.out.println(I18N.getString(LIGAR_MOVIMENTO));
	                			InteligentLamp il = new InteligentLamp(); 
	                			il.sendInteligentLampUpdate();
                		}else {
                			System.out.println(I18N.getString(LUZ_AVISO));
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
                
                System.err.println(I18N.getString(LUZ_LIGADA) + luzUpdate.toString());
                                
                //do something in response to this event
                if (luzUpdate.getActualState()) {
                	                	                                                                     
                    //Mensagem de para exterior
                    MensagemExterior mensagem = new MensagemExterior(I18N.getString(LUZ_LIGADA), "913651651");
            		mensagem.sendMessage();
                }else {
                	 System.out.println(I18N.getString(LUZ_TIMEOUT));
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
                System.err.println(I18N.getString(PORTA_ABERTA) + doorUpdate.toString());
                                
                //do something in response to this event
                if (doorUpdate.getActualState()) {
                    System.out.println(I18N.getString(PORTA_ABERTA));
                    
            		if(campainhaInteligente && (now.isAfter(doorUpdate.getInitialDateTime()) && now.isBefore(doorUpdate.getEndDateTime()))){
            			
        				System.out.println(I18N.getString(TOQUE_CAMPAINHA));
        				BellDetector Bell = new BellDetector(); 
        				Bell.sendBellDetectorUpdate();
        				
        				//Mensagem de para exterior
                        MensagemExterior mensagem = new MensagemExterior(I18N.getString(PORTA_ABRIU), "913651651");
                		mensagem.sendMessage();
            			
	        		}else {
	        			System.out.println(I18N.getString(CAMPAINHA_HORA));
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
                
                System.err.println(I18N.getString(CAMPAINHA_TOQUE) + bellUpdate.toString());
                                
                //do something in response to this event
                if (bellUpdate.getActualState()) {
                    System.out.println(I18N.getString(CAMPAINHA_TOQUE));
                    
                    //Mensagem de para exterior
                    MensagemExterior mensagem = new MensagemExterior(I18N.getString(CAMPAINHA_TOQUE), "913651651");
            		mensagem.sendMessage();
                }
            }
        }
    });
    bezirk.subscribe(campainhaEvent); 
}
	
	public static void main(String[] args) {
		new FornecedorServicos();
	}

}
