package sensores;
import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

public class InteligentLamp extends Sensor {
	
	private int timeOut;
	private Bezirk bezirk;

	public InteligentLamp() {
		super();
		this.timeOut = timeOut;
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Inteligent Lamp");
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	
	public void sendInteligentLampUpdate() {
    	//produces some  values since this is a mock
        final Boolean newState = true;
        final String newName = "Inteligent Button";
        final int timeOut = getTimeOut();
        final UpdateEvent InteligentLampUpdateEvent = new UpdateEvent(newName,newState);
        
        //sends the event
        bezirk.sendEvent(InteligentLampUpdateEvent);
        
        System.err.println("Published Inteligent Lamp update: " + InteligentLampUpdateEvent.toString());
    }
	
	public static void main(String args[]) throws InterruptedException {

		InteligentLamp InteligentLampSensorZirk = new InteligentLamp(); 
		InteligentLampSensorZirk.sendInteligentLampUpdate();
	 }
}