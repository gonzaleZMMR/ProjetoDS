package sensores;

import java.time.LocalDateTime;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import UpdateEvents.UpdateEventMovementDetector;


public class MovementDetector extends Sensor {
	
	private Bezirk bezirk;
	LocalDateTime initialDateTime, endDateTime,initialDateTimeLuzes, endDateTimeLuzes;
	
	public MovementDetector() {
		super();
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Movement Detector");
	}

	public void sendMovementDetectorUpdate() {
    	//produces some  values since this is a mock
        final Boolean newState = true;
        final String newName = "Movement Detector";
        
        //horario de envio de mensagem
        initialDateTime = LocalDateTime.of(2021,12,30,10,0);
		endDateTime = LocalDateTime.of(2021,12,30,20,0);
		
		//horario de acender as luzes
		initialDateTimeLuzes = LocalDateTime.of(2021,12,30,18,0);
		endDateTimeLuzes = LocalDateTime.of(2021,12,30,23,50);
		
        final UpdateEventMovementDetector MovementDetectorUpdateEvent = new UpdateEventMovementDetector(newName,newState,initialDateTime,endDateTime,initialDateTimeLuzes,endDateTimeLuzes);
        
        //sends the event
        bezirk.sendEvent(MovementDetectorUpdateEvent);
        
        //System.err.println("Published Movement Detector update: " + MovementDetectorUpdateEvent.toString());
    }
	
	public LocalDateTime getInitialDateTime() {
		return initialDateTime;
	}

	public void setInitialDateTime(LocalDateTime initialDateTime) {
		this.initialDateTime = initialDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

}