import static i18n.Messages.INSERT_TITLE;

import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import i18n.I18N;
import i18n.Messages;

public class CallendarMain {

	public static void main(String[] args) throws IOException {
		
		/*
		//System.out.println("MEGALUL");
		EventsHandler eh = new EventsHandler();
		//eh.createFile();
		eh.writeToFile("evento1");
		eh.writeToFile("evento2");
		eh.writeToFile("evento3");
		eh.listEvents();
		System.out.println("Number of events:" +  eh.getFileSize());
		*/
		
		
		//Coisas necessárias para o Callendar
		CallendarEvent ce = new CallendarEvent();
		//Creating scanner for data acceptance
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
		
		/*
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String formattedDateTime = dateTime.format(formatter);

		System.out.println("Data inicial do evento: " + formattedDateTime);
		*/
		//Defines the start date of the event
		ce.setStartDate(dateTime);
		
		System.out.println("Insira o dia do fim do evento:");
		day = bucky.nextInt();
		System.out.println("Insira o mês do fim do evento:");
		month = bucky.nextInt();
		System.out.println("Insira o ano do fim do evento:");
		year = bucky.nextInt();
		
		dateTime = LocalDateTime.of(year,month,day,hour,0);
		
		ce.setEndDate(dateTime);
		
		System.out.println("Defina a periodicidade do evento:");
		
		int periodicity = bucky.nextInt();
		
		ce.setRepeatRate(periodicity);
				
	}

}
