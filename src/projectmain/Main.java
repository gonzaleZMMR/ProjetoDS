package projectmain;

import core.EventsHandler;

public class Main {

	public static void main(String[] args) {
		//System.out.println("MEGALUL");
		EventsHandler eh = new EventsHandler();
		eh.createFile();
		eh.writeToFile("hahaha");
		eh.writeToFile("hehehe");
		eh.writeToFile("hihihi");
		eh.writeToFile("hohoho");
		eh.writeToFile("huhuhu");
		eh.readEvents();
	}

}
