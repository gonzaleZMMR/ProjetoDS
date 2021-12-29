import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import i18n.I18N;
import i18n.Messages;

public class Action {

	private String s;
	
	public Action (String s) {
		this.s = s;
	}
	
	public void execute() {
		Calendar c = new Calendar();
		ArrayList<CallendarEvent> listevents = new ArrayList<CallendarEvent>();
		// TODO Auto-generated method stub~
		System.out.println("ok fez: " + s);
		
		switch(s) {
		case "view": 
			//Empty arraylist
			listevents = new ArrayList<CallendarEvent>();
			listevents = c.loadToCalendar();
			break;
		case "add":
			//Empty arraylist
			listevents = new ArrayList<CallendarEvent>();
			listevents = c.loadToCalendar();
			CallendarEvent ce = new CallendarEvent();
			Scanner bucky = new Scanner(System.in );
			System.out.println(I18N.getString(Messages.INSERT_TITLE));
			String eventTitle = bucky.next();
			//Defines the callendar start message
			ce.setCallendarMessage(eventTitle);
			//printing data
			System.out.println("Insira o dia do inicio do evento:");
			int day = bucky.nextInt();
			System.out.println("Insira o mês do inicio do evento:");
			int month = bucky.nextInt();
			System.out.println("Insira o ano do inicio do evento:");
			int year = bucky.nextInt();
			System.out.println("Insira a hora de inicio do evento:");
			int hour = bucky.nextInt();
			LocalDateTime dateTime = LocalDateTime.of(year,month,day,hour,0);
			ce.setStartDate(dateTime);
			System.out.println("Insira o dia do fim do evento:");
			day = bucky.nextInt();
			System.out.println("Insira o mês do fim do evento:");
			month = bucky.nextInt();
			System.out.println("Insira o ano do fim do evento:");
			year = bucky.nextInt();
			System.out.println("Insira a hora de inicio do evento:");
			hour = bucky.nextInt();
			dateTime = LocalDateTime.of(year,month,day,hour,0);
			ce.setEndDate(dateTime);
			System.out.println("Defina a periodicidade do evento:");
			int periodicity = bucky.nextInt();
			ce.setRepeatRate(periodicity);
			System.out.println("tempo antes:");
			int timeBeforeAlert = bucky.nextInt();
			ce.setTimeBeforeAlert(timeBeforeAlert);
			try {
				c.addToCalendarAndSave(listevents,ce);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
}
