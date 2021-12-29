package sensores;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

public class MovementDetector extends Sensor {
	
	private Bezirk bezirk;
	
	public MovementDetector() {
		super();
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Movement Detector");
	}
	
	public void sendMovementDetectorUpdate() {
    	//produces some  values since this is a mock
        final Boolean newState = true;
        final String newName = "Movement Detector";
        final UpdateEvent MovementDetectorUpdateEvent = new UpdateEvent(newName,newState);
        
        //sends the event
        bezirk.sendEvent(MovementDetectorUpdateEvent);
        
        System.err.println("Published Movement Detector update: " + MovementDetectorUpdateEvent.toString());
    }
	
	public static void main(String args[]) throws InterruptedException {

		MovementDetector MovementDetectorSensorZirk = new MovementDetector(); 
		MovementDetectorSensorZirk.sendMovementDetectorUpdate();
	 }
}