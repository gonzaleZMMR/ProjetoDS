
public aspect PeriodoLuzesAutomaticas {
	after(FornecedorServicos servicos): execution(FornecedorServicos+.new(..)) && this(servicos) {
        System.out.println("Luzes Automaticas ON");
        servicos.setLuzesAutomaticas();
    }
}
