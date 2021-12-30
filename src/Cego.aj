
public aspect Cego {
	after(FornecedorServicos servicos): execution(FornecedorServicos+.new(..)) && this(servicos) {
        System.out.println("Utilizador com Problemas de Visao");
        servicos.setCego();
    }
}
