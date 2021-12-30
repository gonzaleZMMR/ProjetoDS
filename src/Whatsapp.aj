
public aspect Whatsapp {
	
	after(MensagemExterior mensagem): execution(MensagemExterior+.new(..)) && this(mensagem) {
        //System.out.println("Tipo de mensagem definido como WHATSAPP");
        mensagem.setTipoMensagem(TipoMensagem.WHATSAPP);
    }
}
