import i18n.I18N;

public aspect Portugues {
	before() : execution(* *.main(..)) {
		I18N.setInstance(new I18N("pt","PT"));
		System.err.println("Linguagem mudada para portugues");
	}
}
