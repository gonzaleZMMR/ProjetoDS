import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
		System.out.println("Insira o titulo do evento:");
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
		
		String dateString = day + "-" + month + "-" + year + " " + hour + ":00";
		
		System.out.println("Insira o dia do fim do evento:");
		day = bucky.nextInt();
		System.out.println("Insira o mês do fim do evento:");
		month = bucky.nextInt();
		System.out.println("Insira o ano do fim do evento:");
		year = bucky.nextInt();
	}

}
