
public aspect Cego {
	after(FornecedorServicos servicos): execution(FornecedorServicos+.new(..)) && this(servicos) {
        System.out.println("Detatado como cego");
        servicos.setCego();
    }
}
