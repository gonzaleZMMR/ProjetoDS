package UpdateEvents;

import com.bezirk.middleware.messages.Event;

public class UpdateEventButton extends Event {
	
	
	private static final long serialVersionUID = 1L;
	private Boolean actualState = true;
	private String sensorName;
	
	
	public UpdateEventButton(String sensorName, Boolean actualState) {
		this.sensorName = sensorName;
		this.actualState = actualState;
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
