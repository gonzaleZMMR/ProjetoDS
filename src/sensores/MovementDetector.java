package sensores;

import java.time.LocalDateTime;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import UpdateEvents.UpdateEventInteligentLamp;
import UpdateEvents.UpdateEventMovementDetector;


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
        final UpdateEventMovementDetector MovementDetectorUpdateEvent = new UpdateEventMovementDetector(newName,newState);
        
        LocalDateTime initialDateTime = LocalDateTime.of(2021,12,29,18,0);
		LocalDateTime endDateTime = LocalDateTime.of(2021,12,29,19,0);
        LocalDateTime now = LocalDateTime.now();

        //sends the event
        bezirk.sendEvent(MovementDetectorUpdateEvent);
        
        if(now.isAfter(initialDateTime) && now.isBefore(endDateTime)) {
        	
        	final UpdateEventInteligentLamp InteligentLampUpdateEvent = new UpdateEventInteligentLamp(newName,newState,initialDateTime,endDateTime);
        	bezirk.sendEvent(InteligentLampUpdateEvent);
        }
        
        //System.err.println("Published Movement Detector update: " + MovementDetectorUpdateEvent.toString());
    }

}