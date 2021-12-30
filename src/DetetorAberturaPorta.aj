import sensores.OpenDetector;

public aspect DetetorAberturaPorta {
	after() : execution(void FornecedorServicos.main(..)){
        System.out.println("Detetor de movimentos por aspetos");
        OpenDetector door = new OpenDetector();
        door.sendOpenDetectorUpdate();
    }
}
