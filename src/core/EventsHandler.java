package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EventsHandler {


	public void createFile() {

		try {
			File events = new File("events/events.txt");
			if (events.createNewFile()) {
				System.out.println("File created: " + events.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void writeToFile(String text) {

		try {
			FileWriter events = new FileWriter("events/events.txt",true);
			events.write(text+"\n");
			
			events.close();
		
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public void readEvents() {
		
		try {
			File eventsToRead = new File("events/events.txt");
			Scanner reader = new java.util.Scanner(eventsToRead);
			while(reader.hasNextLine()) {
				System.out.println("Read from file "+reader.nextLine());
			}
			
			reader.close();
		}catch (FileNotFoundException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
