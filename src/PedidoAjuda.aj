import sensores.InteligentButton;

public aspect PedidoAjuda {
	after() : execution(void FornecedorServicos.main(..)){
        System.out.println("Pedido de ajuda acionado por aspeto");
        InteligentButton btn = new InteligentButton();
        btn.sendInteligentButtonUpdate();
    }
}
