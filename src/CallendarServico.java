import java.time.LocalDateTime;
import java.util.ArrayList;

import calendar.Calendar;
import calendar.CallendarEvent;

public class CallendarServico{

	static ArrayList<CallendarEvent> calendarioeventos = new ArrayList<>();
	static Calendar c = new Calendar();
	
	public static void main(String[] args) {
		System.out.println("running....");
		
		while(true) {
			calendarioeventos = c.loadToCalendar();
			
			for (CallendarEvent callendarEvent : calendarioeventos) {
				LocalDateTime now = LocalDateTime.now();
				LocalDateTime initialTime = callendarEvent.getStartDate();
				LocalDateTime endTime = callendarEvent.getEndDate();
				
							
				//System.out.println(finishTime);

				//verificar o seguinte:
				// - repeat rate (de quanto em quanto tempo devo repetir? (caso n queira, colocar a 0))
				// - quanto tempo antes quero que a mensagem seja mandada
				if(now.compareTo(initialTime) == 0) {
					MensagemExterior me = new MensagemExterior(callendarEvent.getCallendarMessage(), callendarEvent.getPhoneNumber());
					me.sendMessage();
				}
			}
		}  
	}

}
