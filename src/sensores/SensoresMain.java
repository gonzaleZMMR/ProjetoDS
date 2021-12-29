package sensores;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import i18n.I18N;

public class SensoresMain extends Sensor{
	
	public static void main(String args[]) throws InterruptedException {

		OpenDetector OpenDetectorSensorZirk = new OpenDetector(); 
		OpenDetectorSensorZirk.sendOpenDetectorUpdate();
	 }

}