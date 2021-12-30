public aspect LampadaInteligente {
	after(FornecedorServicos servicos): execution(FornecedorServicos+.new(..)) && this(servicos) {
        System.out.println("Luzes Automaticas ON");
        servicos.setLampadaInteligente();
	}
}
