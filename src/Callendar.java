import java.util.List;

public class Callendar{
	
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
	
}
