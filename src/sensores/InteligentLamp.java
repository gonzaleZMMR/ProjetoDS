package sensores;
import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

public class InteligentLamp extends Sensor {
	
<<<<<<< HEAD
	private Bezirk bezirk;
	long startTime;
	
	public InteligentLamp() {
		super();
=======
	private int timeOut;
	private Bezirk bezirk;

	public InteligentLamp() {
		super();
		this.timeOut = timeOut;
>>>>>>> 2ae46959692d4af24ed2d5450a9ad5997e9ef74f
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Inteligent Lamp");
	}
	
	public void sendMovementDetectorUpdate() {
    	//produces some  values since this is a mock
        Boolean newState = true;
        final String newName = "Inteligent Lamp";
        UpdateEvent InteligentLampUpdateEvent = new UpdateEvent(newName,newState);
        
        //sends the event
        bezirk.sendEvent(InteligentLampUpdateEvent);
        startTime = System.currentTimeMillis();
        
        System.err.println("Published Inteligent Lamp update: " + InteligentLampUpdateEvent.toString());
        
        while(System.currentTimeMillis() - startTime < 10000) {
        	continue;
        }
        
        newState = false;
        //sends new event to turn off the button after 10 seconds
        InteligentLampUpdateEvent = new UpdateEvent(newName,newState);
        bezirk.sendEvent(InteligentLampUpdateEvent);
        System.out.println("Finished after 10 seconds, lamp turned OFF again");
                
        System.err.println("Published Inteligent Lamp update: " + InteligentLampUpdateEvent.toString());
    }

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
<<<<<<< HEAD
}
=======
	
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
>>>>>>> 2ae46959692d4af24ed2d5450a9ad5997e9ef74f
