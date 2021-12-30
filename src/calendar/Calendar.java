package calendar;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class Calendar implements Serializable{
	
	//Adds a new event to the calendar and subsequently to the file
	public void addToCalendarAndSave(ArrayList<CallendarEvent> listOfEvents, CallendarEvent ce) throws Exception {
		//Verifies if the arraylist already contains the calendar event
		listOfEvents.add(ce);
		
		System.out.println("size" + listOfEvents.size());
		
		//New file and object output streams
		FileOutputStream fout = new FileOutputStream("events/events.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		
		//Write into file
		oos.writeObject(listOfEvents);

		//Close object and file output stream
		oos.close();
		fout.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<CallendarEvent> loadToCalendar() {
		
		ArrayList<CallendarEvent> c = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream("events/events.ser");
			ObjectInputStream ois=new ObjectInputStream(fis);
			
			c = (ArrayList<CallendarEvent>) ois.readObject();  
			
			//Close object and file output stream
			fis.close();
			ois.close();
		} catch (Exception e) {
		}
		
		return c;
	}
	
	public void removeFromCalendar(ArrayList<CallendarEvent> listOfEvents, CallendarEvent ce) throws Exception {
		//Loads the events to the calendar
		listOfEvents = loadToCalendar();
		//
		listOfEvents.remove(ce);
		//New file and object output streams
		FileOutputStream fout = new FileOutputStream("events/events.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
				
		//Write into file
		oos.writeObject(listOfEvents);

		//Close object and file output stream
		oos.close();
		fout.close();
	}
	
}
