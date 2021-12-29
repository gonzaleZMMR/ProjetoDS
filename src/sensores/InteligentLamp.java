package sensores;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import UpdateEvents.UpdateEventInteligentLamp;

public class InteligentLamp extends Sensor {
	
	private Bezirk bezirk;
	long startTime;
	
	public InteligentLamp() {
		super();
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Inteligent Lamp");
	}
	
	public void sendMovementDetectorUpdate() {
    	//produces some  values since this is a mock
        Boolean newState = true;
        final String newName = "Inteligent Lamp";
        UpdateEventInteligentLamp InteligentLampUpdateEvent = new UpdateEventInteligentLamp(newName,newState);
        
        //sends the event
        bezirk.sendEvent(InteligentLampUpdateEvent);
        startTime = System.currentTimeMillis();
        
        System.err.println("Published Inteligent Lamp update: " + InteligentLampUpdateEvent.toString());
        
        while(System.currentTimeMillis() - startTime < 10000) {
        	continue;
        }
        
        newState = false;
        //sends new event to turn off the button after 10 seconds
        InteligentLampUpdateEvent = new UpdateEventInteligentLamp(newName,newState);
        bezirk.sendEvent(InteligentLampUpdateEvent);
        System.out.println("Finished after 10 seconds, lamp turned OFF again");
                
        System.err.println("Published Inteligent Lamp update: " + InteligentLampUpdateEvent.toString());
    }

	public long getStartTime() {
		return startTime;
	}
	
	public static void main(String args[]) throws InterruptedException {
		
		InteligentLamp BellDetectorSensorZirk = new InteligentLamp(); 
		BellDetectorSensorZirk.sendMovementDetectorUpdate();
	 }
}
