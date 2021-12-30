package sensores;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import UpdateEvents.UpdateEventBellDetector;

public class BellDetector extends Sensor {
	
	private Bezirk bezirk;

	public BellDetector(){
		super();
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Bell Detector");
	}
	
	public void sendBellDetectorUpdate() {
    	//produces some  values since this is a mock
        final Boolean newState = true;
        final String newName = "Bell Detetctor";
        final UpdateEventBellDetector BellDetectorUpdateEvent = new UpdateEventBellDetector(newName,newState);
        
        //sends the event
        bezirk.sendEvent(BellDetectorUpdateEvent);
        
        System.err.println("Published Bell Detector update: " + BellDetectorUpdateEvent.toString());
    }
	
	public static void main(String args[]) throws InterruptedException {

		BellDetector Bell = new BellDetector(); 
		Bell.sendBellDetectorUpdate();
	 }
}