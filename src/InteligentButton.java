import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

public class InteligentButton extends Sensor {

	 private Bezirk bezirk;
	
	public InteligentButton(String name, Boolean actualState) {
		super(name,actualState);
		 BezirkMiddleware.initialize();
		 bezirk = BezirkMiddleware.registerZirk("Inteligent Button");
	}
	
	public void sendInteligentButtonUpdate() {
    	//produces some  values since this is a mock
        final Boolean newState = true;
        final String newName = "Inteligent Button";
        final UpdateEvent InteligentButtonUpdateEvent = new UpdateEvent(newName,newState);
        
        //sends the event
        bezirk.sendEvent(InteligentButtonUpdateEvent);
    }
}
