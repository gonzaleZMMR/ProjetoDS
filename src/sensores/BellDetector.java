package sensores;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import i18n.I18N;

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
        final UpdateEvent BellDetectorUpdateEvent = new UpdateEvent(newName,newState);
        
        //sends the event
        bezirk.sendEvent(BellDetectorUpdateEvent);
        
        System.err.println("Published Bell Detector update: " + BellDetectorUpdateEvent.toString());
    }
	
	public static void main(String args[]) throws InterruptedException {

		BellDetector BellDetectorSensorZirk = new BellDetector(); 
		BellDetectorSensorZirk.sendBellDetectorUpdate();
	 }
}