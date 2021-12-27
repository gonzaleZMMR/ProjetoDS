package core;

import java.time.LocalDateTime;

public interface CallendarInterface {
	//Creation of the event
	String createEvent(CallendarEvent cEvent);
	
	//Delete event
	String deleteEvent(CallendarEvent cEvent);	
}