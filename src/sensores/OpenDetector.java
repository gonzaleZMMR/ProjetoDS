package sensores;
import java.time.LocalDateTime;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import UpdateEvents.UpdateEventOpenDetector;

public class OpenDetector extends Sensor{
	
	private Bezirk bezirk;
	
	long startTime;
	LocalDateTime initialDateTime, endDateTime;

	public OpenDetector() {
		super();
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Open Detector");
	}

	public void sendOpenDetectorUpdate() {
    	//produces some  values since this is a mock
        final Boolean newState = true;
        final String newName = "Open Detector";
               
        initialDateTime = LocalDateTime.of(2021,12,30,10,0);
		endDateTime = LocalDateTime.of(2021,12,30,23,45);
       
        final UpdateEventOpenDetector OpenDetectorUpdateEvent = new UpdateEventOpenDetector(newName,newState, initialDateTime, endDateTime);
        
        //sends the event
        bezirk.sendEvent(OpenDetectorUpdateEvent);
        startTime = System.currentTimeMillis();
        
        while(System.currentTimeMillis() - startTime < 10000) {
        	continue;
        }
        
        System.err.println("\nO tempo maximo de porta aberta foi ultrupassado! Cuidado!");
    }
	
	public static void main(String args[]) throws InterruptedException {

		OpenDetector OpenDetectorSensorZirk = new OpenDetector(); 
		OpenDetectorSensorZirk.sendOpenDetectorUpdate();
	 }
}