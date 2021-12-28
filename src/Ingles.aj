
public aspect Ingles {
	before() : execution(* *.main(..)) {
		//I18N.setInstance(new I18N("en","US"));
		System.err.println("Language changed to english.");
	}
}