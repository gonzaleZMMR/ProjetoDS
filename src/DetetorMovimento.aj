import sensores.MovementDetector;

public aspect DetetorMovimento {
	after() : execution(void FornecedorServicos.main(..)){
        System.out.println("Detetor de movimentos por aspetos");
        MovementDetector md = new MovementDetector();
        md.sendMovementDetectorUpdate();
    }
}
