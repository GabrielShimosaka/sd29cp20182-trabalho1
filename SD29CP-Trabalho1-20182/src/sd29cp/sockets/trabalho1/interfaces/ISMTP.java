package sd29cp.sockets.trabalho1.interfaces;

public interface ISMTP {
    //enviar - invocado pela aplicação cliente
    //recebe como parâmetro um objeto do tipo msgSMTP
    //retorno: 0 - indica que o email foi entregue com sucesso na caixa postal do usuário
    //         1 - indica que houve erro
    public int enviar(msgEmail msg);
}
