package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

	public void writeToFile(String text) throws IOException {

			int lastIndex = numberOfEvents();
			
		try {
			FileWriter events = new FileWriter("events/events.txt",true);
			events.write(lastIndex+" "+text+"\n");
			events.close();
			System.out.println("Successfully wrote to the file.");
			//setline_counter(line_counter++);
		} catch (IOException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
		lastIndex = 0;
	}

	public void listEvents() {

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

	public int numberOfEvents() throws IOException {

		int counter =1;

		BufferedReader reader = new BufferedReader(new FileReader("events/events.txt"));

		while (reader.readLine() != null) counter++;
		reader.close();
		return counter;

	}
	
	public int getFileSize() throws IOException {
		
		int size = numberOfEvents()-1;
		
		return size;
	}
}
