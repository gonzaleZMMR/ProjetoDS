import java.io.IOException;

import java.time.LocalDateTime;
import java.util.Scanner;

import i18n.I18N;
import i18n.Messages;

public class CallendarMain{

	public static void main(String[] args) throws IOException {
		
		//Create scanner
		Scanner sc = new Scanner(System.in);

		Menu menu = new Menu();
		Option exit = new Option("exit");
		menu.addMenuItem(exit, new Action("Sair"));
		int optionNum;
		Option option;
		do {
			System.out.println(menu);
			optionNum = readOption(menu, sc);
			option = menu.getOption(optionNum);
			menu.execute(optionNum);
		} while(!option.equals(exit));
				
	}

	private static int readOption(Menu menu, Scanner sc) {
		int value;
		do {
			System.out.println("Option? ");
			value = sc.nextInt(); 
			if (!menu.isValid(value))
				System.out.println("Value not valid.");			
		} while(!menu.isValid(value));
		return value;
	}

}
