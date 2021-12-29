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
			temporary = new File("events/temporary.txt");
			
			if (!events.exists() && !temporary.exists()) {
				events.createNewFile();
				temporary.createNewFile();
				System.out.println("File created: " + events.getName());
				System.out.println("File created: " + temporary.getName());
			} 
			else if(events.exists() && !temporary.exists()){
				temporary.createNewFile();
				System.out.println("File Events already exists.");
				System.out.println("File created: " + temporary.getName());
			}
			else if(!events.exists() && temporary.exists()){
				System.out.println("File Temporary already exists.");
				events.createNewFile();
				System.out.println("File created: " + events.getName());
			}
			
			else {System.out.println("Both files already created!");}
			
		} catch (IOException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void writeEvent(String text) throws IOException {

		int lastIndex = AssignNumberTOfEvents();

		try {
			eventsToWrite = new FileWriter("events/events.txt",true);
			eventsToWrite.write(lastIndex+" "+text+"\n");
			eventsToWrite.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
		lastIndex = 0;
	}

	public void listEvents() {

		try {
			//File eventsToRead = new File("events/events.txt");
			//Scanner reader = new java.util.Scanner(eventsToRead);
			Scanner reader = new java.util.Scanner(events);
			while(reader.hasNextLine()) {
				System.out.println("Read from file "+reader.nextLine());
			}

			reader.close();
		}catch (FileNotFoundException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public int AssignNumberTOfEvents() throws IOException {

		int counter =1;

		reader = new BufferedReader(new FileReader("events/events.txt"));

		while (reader.readLine() != null) counter++;
		reader.close();
		return counter;

	}

	public void deleteEvent(int index) throws IOException {

		reader = new BufferedReader(new FileReader("events/events.txt"));
		writer = new BufferedWriter(new FileWriter("events/temporary.txt"));
		String EventToDelete = Files.readAllLines(Paths.get("events/events.txt")).get(index);
		String currentLine;
		while ((currentLine = reader.readLine()) != null) {

			if(currentLine.equals(EventToDelete)) continue;

			writer.write(currentLine);
		}

		reader.close();
	}

	public int NumberOfEvents() throws IOException {

		int size = AssignNumberTOfEvents()-1;
		return size;
	}
}
