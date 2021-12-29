import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class EventsHandler {

	File events,temporary;
	BufferedReader reader;
	BufferedWriter writer;
	FileWriter eventsToWrite;

	public void createFiles() {

		try {
			
			events = new File("events/events.txt");
			
			if (events.createNewFile()) {
				System.out.println("File created: " + events.getName());
			} 
			else {System.out.println("File already created!");}
			
		} catch (IOException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void writeEvent(String text) throws IOException {
		
		int lastIndex = eventIdChecker();

		try {
			eventsToWrite = new FileWriter("events/events.txt",true);
			eventsToWrite.write(lastIndex+" "+text+"\n");
			eventsToWrite.close();
		} catch (IOException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
		lastIndex = 0;
	}

	public void listEvents() {

		try {
			Scanner reader = new java.util.Scanner(events);
			while(reader.hasNextLine()) {
				System.out.println(reader.nextLine());
			}

			reader.close();
		}catch (FileNotFoundException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public int eventIdChecker() throws IOException {

		int counter =1;

		reader = new BufferedReader(new FileReader("events/events.txt"));

		while (reader.readLine() != null) counter++;
		reader.close();
		return counter;

	}

	public void deleteEvent(int index) throws IOException {
		
		index--;
		if(index <= 0) {System.err.println("Wrong Event number provided!");System.exit(1);}

		temporary = new File("events/temporary.txt");
		temporary.createNewFile();
		reader = new BufferedReader(new FileReader("events/events.txt"));
		writer = new BufferedWriter(new FileWriter("events/temporary.txt"));
		String EventToDelete = Files.readAllLines(Paths.get("events/events.txt")).get(index);
		String currentLine;
		while ((currentLine = reader.readLine()) != null) {

			if(currentLine.equals(EventToDelete)) continue;
			
			System.out.println(currentLine);
			writer.write(currentLine+"\n");
		}
		writer.close();
		reader.close();
		events.delete();
		temporary.renameTo(events);
	}

	public int NumberOfEvents() throws IOException {

		int size = eventIdChecker()-1;
		return size;
	}
}
