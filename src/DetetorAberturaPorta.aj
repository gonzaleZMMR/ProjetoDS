import sensores.OpenDetector;

public aspect DetetorAberturaPorta {
	after() : execution(void FornecedorServicos.main(..)){
        OpenDetector door = new OpenDetector();
        door.sendOpenDetectorUpdate();
    }
}
