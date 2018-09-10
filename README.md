## Disciplina de Sistemas Distribuídos - Engenharia de Computação - UTFPR - 2018/2
# Trabalho 1

## Visão Geral
O trabalho consiste da implementação de uma aplicação que simule o serviço de correio
eletrônico da Internet. Este serviço prove os serviços SMTP e POP (simulado), permitindo
o envio e o recebimento de e-mails entre as diversas instâncias destes servidores.

O funcionamento dos serviços está apresentado na Figura 1. 

### Envio de emails:
Os passos para o envio de um email são: (1) a aplicação do usuário deve buscar no servidor DNS (TCP) a localização (IP:Porta) do servidor SMTP do usuário, (2) enviar a mensagem para o servidor STMP do usuário; (3) o servidor SMTP do usuário dever buscar no DNS a localização (IP:Porta) do servidor SMTP de destino; (4) o servidor SMTP do usuário deve enviar a mensagem para o servidor SMTP de destino; (5) servidor SMTP de destino, coloca a mensagem na caixa postal do usuário de destino.
**Observação:** Caso o domı́nio de destino da mensagem seja o mesmo de origem, os passos 3 e 4 não são necessários.

### Recebimento de emails:
Os passos para o recebimento de um email são: (1) a aplicação do usuário busca no servidor DNS a localização (IP:Porta) do servidor POP do usuário, (2) solicita ao servidor POP a leitura das mensagens (emails) de sua caixa postal; (3) servidor POP busca na caixa postal do do usuário por novas mensagens, caso existam envia todas para o usuário. O usuário tem a opção de escolher de manter as mensagens no servidor após serem lidas.

## Especificação do Trabalho
A aplicação distribuı́da a ser desenvolvida deve ser composta por três módulos: Cliente, Servidor
IMAP/POP e Servidor de DNS, conforme mostra a Figura 2.

### Cliente
Deve prover uma interface (texto ou gráfica) que permita escolher entre o envio e o recebimento de emails:
* **Envio:** 
    - Deve solicitar: emissor, destinatário, assunto e corpo do e-mail.
    - Deve indicar se o e-mail foi enviado com sucesso ou não.
* **Recepção:**
    - Deve solicitar: nome do usuário e se deve manter as mensagens no servidor.
    - Os e-mails recebidos devem ser apresentados na tela.

### Servidor Email
O servidor de email deve ser composto por dois objetos, um que implementa a funcionalidade do SMTP e outro que implementa a funcionalidade do POP. Deve usado as interfaces apresentadas nas Listagens 1 e 2, para SMTP e POP, respectivamente. O servidor de email deve atender a conexões de Sockets TCP. O servidor de SMTP aceita mensagens do tipo MsgEmail, cuja classe está definida na Listagem 3.

```
java
public interface ISMTP {
//recebe como parmetro um objeto do tipo msgSMTP
//retorno: 0 - indica que o email foi entregue com sucesso na caixa postal do usurio
//
1 - indica que houve erro
public int enviar(msgEmail mensagem);
}
```


```
java
public interface IPOP {
//recebe parmetro o nome do usurio e se deve manter as mensagens no servidor.
//retorno - lista de todos os e-mails da caixa postal do usurio.
public List<msgEmail> ler(String usuario, boolean manterMsgs);
}
```

```
java
public class MsgEmail {
private String de;
private String para;
private String assunto;
private String mensagem;
}
```



