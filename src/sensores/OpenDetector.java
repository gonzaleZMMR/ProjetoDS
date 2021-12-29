package sensores;
import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

public class OpenDetector extends Sensor{
	
	private Bezirk bezirk;

	public OpenDetector() {
		super();
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Open Detector");
	}

	public void sendOpenDetectorUpdate() {
    	//produces some  values since this is a mock
        final Boolean newState = true;
        final String newName = "Open Detector";
        final UpdateEvent OpenDetectorUpdateEvent = new UpdateEvent(newName,newState);
        
        //sends the event
        bezirk.sendEvent(OpenDetectorUpdateEvent);
        
        System.err.println("Published Open Detector update: " + OpenDetectorUpdateEvent.toString());
    }
	
	public static void main(String args[]) throws InterruptedException {

		OpenDetector OpenDetectorSensorZirk = new OpenDetector(); 
		OpenDetectorSensorZirk.sendOpenDetectorUpdate();
	 }
}