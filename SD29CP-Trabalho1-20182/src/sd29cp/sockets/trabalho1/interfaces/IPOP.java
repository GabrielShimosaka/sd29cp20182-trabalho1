package sd29cp.sockets.trabalho1.interfaces;

import java.util.List;

public interface IPOP {
    //recebe parâmetro o nome do usuário.
    //retorno - lista de todos os e-mails referentes ao usuário.
    public List<msgEmail> ler(String usuario, boolean manterMsgs);
}
