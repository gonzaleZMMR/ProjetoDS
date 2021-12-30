import i18n.I18N;
import i18n.Messages;

public aspect Calendario {
	after(Menu menu): initialization(Menu.new()) && target(menu) {
		//Possible options:
		//See every event in the calendar
		Option view = new Option(I18N.getString(Messages.VER_EVENTOS));
		menu.addMenuItem(view, new Action("view"));
		//Add a new event to the calendar
		Option add = new Option(I18N.getString(Messages.ADICIONAR_EVENTO));
		menu.addMenuItem(add, new Action("add"));
	}
}
