package core;

import java.util.List;

public class Callendar {
	public List<CallendarEvent> listOfEvents;
	
	public Callendar(List<CallendarEvent> listOfEvents) {
		super();
		this.listOfEvents = listOfEvents;
	}

	public List<CallendarEvent> getListOfEvents() {
		return listOfEvents;
	}

	public void setListOfEvents(List<CallendarEvent> listOfEvents) {
		this.listOfEvents = listOfEvents;
	}
	
}
