import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
	
	private List<Option> options;
	private Map<Option, Action> actions;
	
	public Menu(){
		options = new ArrayList<>();
		actions = new HashMap<>();
	}

	public void addMenuItem(Option o, Action action){
		if(!actions.containsKey(o)) {
			options.add(o);
		}
		actions.put(o, action);
	}
	
	public Option getOption(int i) {
		return options.get(i);
	}
	
	public void execute(int i) {
		Option o = options.get(i);
		actions.get(o).execute();
	}
	
	public boolean isValid(int pos) {
		return pos >= 0 && pos < options.size();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for(Option o : options) {
			sb.append(" " + i + " - " + o.toString() + " ");
			i++;
		}
		return sb.toString();
	}

}
