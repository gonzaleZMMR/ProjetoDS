package core;

import java.time.LocalDateTime;

public interface CallendarEventInterface {
	//Verify if the date is valid
	boolean isDateValid(LocalDateTime date);
	
	//Verify if the event is valid
	boolean isEventValid(CallendarEvent cEvent);
}
