package i18n;

public aspect pt_PT {
	before() : execution(* *.main(..)) {
		I18N.setInstance(new I18N("pt","PT"));
		System.err.println("Este produto fala portugu�s");
	}
}