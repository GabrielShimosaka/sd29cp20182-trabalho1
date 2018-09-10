package sd29cp.sockets.trabalho1.interfaces;

import java.io.Serializable;

public class msgEmail implements Serializable{
    private String de;
    private String para;
    private String assunto;
    private String mensagem;

    public msgEmail(String de, String para, String assunto, String mensagem) {
        this.de = de;
        this.para = para;
        this.assunto = assunto;
        this.mensagem = mensagem;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    
}
