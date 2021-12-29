
public aspect SMS {
	
	after(MensagemExterior mensagem): execution(MensagemExterior+.new(..)) && this(mensagem) {
        System.out.println("Tipo de mensagem definido como SMS");
        mensagem.setTipoMensagem(TipoMensagem.SMS);
    }
	
}
