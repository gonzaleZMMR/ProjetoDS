package sensores;
import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import UpdateEvents.UpdateEventOpenDetector;

public class OpenDetector extends Sensor{
	
	private Bezirk bezirk;
	
	long startTime;

	public OpenDetector() {
		super();
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Open Detector");
	}

	public void sendOpenDetectorUpdate() {
    	//produces some  values since this is a mock
        final Boolean newState = true;
        final String newName = "Open Detector";
        final UpdateEventOpenDetector OpenDetectorUpdateEvent = new UpdateEventOpenDetector(newName,newState);
        
        //sends the event
        bezirk.sendEvent(OpenDetectorUpdateEvent);
        startTime = System.currentTimeMillis();
        
        while(System.currentTimeMillis() - startTime < 10000) {
        	continue;
        }
        
        System.err.println("Published Open Detector update: " + OpenDetectorUpdateEvent.toString());
    }
	
	public static void main(String args[]) throws InterruptedException {

		OpenDetector OpenDetectorSensorZirk = new OpenDetector(); 
		OpenDetectorSensorZirk.sendOpenDetectorUpdate();
	 }
}