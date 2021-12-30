
public aspect Calendario {
	after(Menu menu): initialization(Menu.new()) && target(menu) {
		//Possible options:
		//See every event in the calendar
		Option view = new Option("Ver");
		menu.addMenuItem(view, new Action("view"));
		//Add a new event to the calendar
		Option add = new Option("Adicionar novo evento");
		menu.addMenuItem(add, new Action("add"));
		//Delete an event from the calendar
		Option delete = new Option("Apagar evento do calendário");
		menu.addMenuItem(delete, new Action("delete"));
	}
}
