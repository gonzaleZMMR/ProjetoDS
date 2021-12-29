import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MensagemMain {

	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH");  
	   LocalDateTime now = LocalDateTime.now();  
	   System.out.println(dtf.format(now));  
		
		//MensagemExterior mensagem = new MensagemExterior("Tomar comprimido a x horas ", "913651651");
		//mensagem.sendMessage();

	}
}
