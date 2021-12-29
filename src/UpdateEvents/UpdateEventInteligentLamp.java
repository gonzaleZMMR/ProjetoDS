package UpdateEvents;

import java.time.LocalDateTime;

import com.bezirk.middleware.messages.Event;

public class UpdateEventInteligentLamp extends Event {
	
	
	private static final long serialVersionUID = 1L;
	private Boolean actualState = true;
	private String sensorName;
	LocalDateTime initialDateTime,endDateTime;
	
	
	public UpdateEventInteligentLamp(String sensorName, Boolean actualState,LocalDateTime initialDateTime,LocalDateTime endDateTime) {
		this.sensorName = sensorName;
		this.actualState = actualState;
		this.initialDateTime = initialDateTime;
		this.endDateTime = endDateTime;
	}


	public Boolean getActualState() {
		return actualState;
	}


	public void setActualState(Boolean actualState) {
		this.actualState = actualState;
	}


	public String getSensorName() {
		return sensorName;
	}


	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}
	
	public String toString() {return String.format("name: " + sensorName +" , " + "actualState: "+actualState);}

}
