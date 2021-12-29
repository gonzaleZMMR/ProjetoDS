package sensores;

public class InteligentLamp extends Sensor {
	
	private int timeOut;

	public InteligentLamp(String sensorSame, Boolean actualState,int timeOut) {
		super(sensorSame, actualState);
		this.timeOut = timeOut;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

}
