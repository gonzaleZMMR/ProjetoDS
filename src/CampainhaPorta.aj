
public aspect CampainhaPorta {
	after(FornecedorServicos servicos): execution(FornecedorServicos+.new(..)) && this(servicos) {
        System.out.println("Toque de Campainha ON");
        servicos.setCampainhaPorta();
	}
}
