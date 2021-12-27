package core;

import java.util.List;

public class Callendar implements CallendarInterface {
	
	//List of events
	public List<CallendarEvent> listOfEvents;
	
	public Callendar(List<CallendarEvent> listOfEvents) {
		this.listOfEvents = listOfEvents;
	}

	public List<CallendarEvent> getListOfEvents() {
		return listOfEvents;
	}

	public void setListOfEvents(List<CallendarEvent> listOfEvents) {
		this.listOfEvents = listOfEvents;
	}

	@Override
	public String createEvent(CallendarEvent cEvent) {
		return null;
	}

	@Override
	public String deleteEvent(CallendarEvent cEvent) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
