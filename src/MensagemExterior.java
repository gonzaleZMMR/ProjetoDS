
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import calendar.CallendarEvent;



public class MensagemExterior {
	
	private String contactoDestino;
	private String conteudoMensagem;
	private TipoMensagem tipoMensagem;
	
	//para os alertas dos eventos
	 public int timeBeforeAlert ;
	 public int repeatRate;
	 
	public MensagemExterior(String conteudoMensagem, String contactoDestino) {
		this.conteudoMensagem = conteudoMensagem;
		this.contactoDestino = contactoDestino;
	}

	public String getConteudoMensagem() {
		return conteudoMensagem;
	}

	public void setConteudoMensagem(String conteudoMensagem) {
		this.conteudoMensagem = conteudoMensagem;
	}

	public TipoMensagem getTipoMensagem() {
		return tipoMensagem;
	}

	public void setTipoMensagem(TipoMensagem tipoMensagem) {
		this.tipoMensagem = tipoMensagem;
	}
	
	public void sendMessage() {
		System.out.println("Mensagem enviada: " + conteudoMensagem + "\nMetodo de envio: " +  tipoMensagem + "\nContacto destino: "  + contactoDestino);
		Toolkit.getDefaultToolkit().beep();
	}
	
  public void sendPeriodiclyMessageToEvent(CallendarEvent event){
	  
	  //private LocalDateTime startDate = event.getStartDate();
	  	    
	  new Timer().scheduleAtFixedRate(new TimerTask() {		
		  
          @Override
          public void run() {
          	
        	  sendMessage();
          }
          
      }, 0, event.getRepeatRate());	  
  }  
}
