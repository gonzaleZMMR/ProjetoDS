public class Sensor {

	private String sensorName;
	private Boolean actualState = false;
	
	
	public Sensor(String sensorName, Boolean actualState) {
		this.sensorName = sensorName;
		this.actualState = actualState;
	}
	
	public Sensor() {}
	
	
	public void changeState() {
		
		if(getActualState() == false) {
			setActualState(true);
		} 
		else{setActualState(false);}
	}
		
	public String getSensorName() {
		return sensorName;
	}
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}
	public Boolean getActualState() {
		return actualState;
	}
	public void setActualState(Boolean actualState) {
		this.actualState = actualState;
	}
}
