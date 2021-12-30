import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import calendar.Calendar;
import calendar.CallendarEvent;
import i18n.I18N;
import i18n.Messages;

public class Action {
	
	

	private String s;
	
	public Action (String s) {
		this.s = s;
	}
	
	public void execute() {
		switch(s) {
		case "view": 
			viewData();
			break;
		case "add":
			addData();
			break;
		}
	}
	
	public void viewData() {
		//Create an arraylist of calendar events and create a calendar object
		Calendar c = new Calendar();
		ArrayList<CallendarEvent> listevents = new ArrayList<CallendarEvent>();
		listevents = new ArrayList<CallendarEvent>();
		listevents = c.loadToCalendar();
		
		for (CallendarEvent callendarEvent : listevents) {
			System.out.println(callendarEvent);
		}
	}

	public void addData() {
		//Create an arraylist of calendar events and create a calendar object
		Calendar c = new Calendar();
		ArrayList<CallendarEvent> listevents = new ArrayList<CallendarEvent>();
		//Empty arraylist
		listevents = c.loadToCalendar();
		CallendarEvent ce = new CallendarEvent();
		Scanner bucky = new Scanner(System.in );
		System.out.println(I18N.getString(Messages.INSERT_TITLE));
		String eventTitle = bucky.next();
		//Defines the callendar start message
		ce.setCallendarMessage(eventTitle);
		//printing data
		System.out.println(I18N.getString(Messages.INSERT_DIA_INICIO));
		int day = bucky.nextInt();
		System.out.println(I18N.getString(Messages.INSERT_MES_INICIO));
		int month = bucky.nextInt();
		System.out.println(I18N.getString(Messages.INSERT_ANO_INICIO));
		int year = bucky.nextInt();
		System.out.println(I18N.getString(Messages.INSERT_HORA_INICIO));
		int hour = bucky.nextInt();
		LocalDateTime dateTime = LocalDateTime.of(2021, 12, 30, 18, 0, 0, 0);
		ce.setStartDate(dateTime);
		System.out.println(I18N.getString(Messages.INSERT_DIA_FIM));
		day = bucky.nextInt();
		System.out.println(I18N.getString(Messages.INSERT_MES_FIM));
		month = bucky.nextInt();
		System.out.println(I18N.getString(Messages.INSERT_ANO_FIM));
		year = bucky.nextInt();
		System.out.println(I18N.getString(Messages.INSERT_HORA_FIM));
		hour = bucky.nextInt();
		dateTime = LocalDateTime.of(2021, 12, 30, 18, 0, 0, 0);
		ce.setEndDate(dateTime);
		System.out.println(I18N.getString(Messages.PERIODICIDADE));
		int periodicity = bucky.nextInt();
		ce.setRepeatRate(periodicity);
		System.out.println(I18N.getString(Messages.TEMPO_ANTES));
		int timeBeforeAlert = bucky.nextInt();
		ce.setTimeBeforeAlert(timeBeforeAlert);
		System.out.println(I18N.getString(Messages.TELEFONE));
		String phonenumber = bucky.next();
		ce.setPhoneNumber(phonenumber);
		try {
			c.addToCalendarAndSave(listevents,ce);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
