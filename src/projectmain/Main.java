package projectmain;

import java.io.IOException;

import core.EventsHandler;

public class Main {

	public static void main(String[] args) throws IOException {
		//System.out.println("MEGALUL");
		EventsHandler eh = new EventsHandler();
		//eh.createFile();
		eh.writeToFile("evento1");
		eh.writeToFile("evento2");
		eh.writeToFile("evento3");
		eh.listEvents();
		System.out.println("Number of events:" +  eh.getFileSize());
	}

}
