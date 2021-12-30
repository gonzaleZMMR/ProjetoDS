package UpdateEvents;

import java.time.LocalDateTime;

import com.bezirk.middleware.messages.Event;

public class UpdateEventMovementDetector extends Event {
	
	
	private static final long serialVersionUID = 1L;
	private Boolean actualState = true;
	private String sensorName;
	LocalDateTime initialDateTime, endDateTime,now;
	
	
	public UpdateEventMovementDetector(String sensorName, Boolean actualState,LocalDateTime initialDateTime,LocalDateTime endDateTime) {
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
	
	public LocalDateTime getInitialDateTime() {
		return initialDateTime;
	}


	public void setInitialDateTime(LocalDateTime initialDateTime) {
		this.initialDateTime = initialDateTime;
	}


	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}


	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}


	public String toString() {return String.format("name: " + sensorName +" , " + "actualState: "+actualState);}

}
