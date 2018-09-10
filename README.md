## Disciplina de Sistemas Distribuídos - Engenharia de Computação - UTFPR - 2018/2
# Trabalho 1

## Visão Geral
O trabalho consiste da implementação de uma aplicação que simule o serviço de correio
eletrônico da Internet. Este serviço prove os serviços SMTP e POP (simulado), permitindo
o envio e o recebimento de e-mails entre as diversas instâncias destes servidores.

### Envio de emails:
Os passos para o envio de um email está apresentado na Figura abaixo e consiste em: (1) a aplicação do usuário deve buscar no servidor DNS (TCP) a localização (IP:Porta) do servidor SMTP do usuário, (2) enviar a mensagem para o servidor STMP do usuário; (3) o servidor SMTP do usuário dever buscar no DNS a localização (IP:Porta) do servidor SMTP de destino; (4) o servidor SMTP do usuário deve enviar a mensagem para o servidor SMTP de destino; (5) servidor SMTP de destino, coloca a mensagem na caixa postal do usuário de destino.
**Observação:** Caso o domı́nio de destino da mensagem seja o mesmo de origem, os passos 3 e 4 não são necessários.


### Recebimento de emails:
Os passos para o recebimento de um email está apresentado na Figura abaixo e consistem em: (1) a aplicação do usuário busca no servidor DNS a localização (IP:Porta) do servidor POP do usuário, (2) solicita ao servidor POP a leitura das mensagens (emails) de sua caixa postal; (3) servidor POP busca na caixa postal do do usuário por novas mensagens, caso existam envia todas para o usuário. O usuário tem a opção de escolher de manter as mensagens no servidor após serem lidas.

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

No lado cliente, ainda deve ser fornecido uma instância de objeto proxy para cada um dos objetos (SMTP e IMAP) para os objetos do lado servidor. 

### Servidor Email
O servidor de email deve ser composto por dois objetos, um que implementa a funcionalidade do SMTP e outro que implementa a funcionalidade do POP. Deve usado as interfaces IMAP e IPOP apresentadas a seguir, para SMTP e POP, respectivamente. 


```java
public interface ISMTP {
//recebe como parmetro um objeto do tipo msgSMTP
//retorno: 0 - indica que o email foi entregue com sucesso na caixa postal do usurio
//
1 - indica que houve erro
public int enviar(msgEmail mensagem);
}

public interface IPOP {
//recebe parmetro o nome do usurio e se deve manter as mensagens no servidor.
//retorno - lista de todos os e-mails da caixa postal do usurio.
public List<msgEmail> ler(String usuario, boolean manterMsgs);
}
```
O servidor de email deve atender a conexões de Sockets TCP e permitir atender vários clientes simultaneamente (multithreads). O servidor de SMTP deve aceitar mensagens do tipo MsgEmail, cuja classe está definida abaixo.


```java
public class MsgEmail {
private String de;
private String para;
private String assunto;
private String mensagem;
}
```
### Servidor DNS
O servidor DNS deve ser usado o mesmo desenvolvido na Prática 3.

### Especificação das mensagens - protocolo de comunicação
As trocas de mensagem entre os componentes deve seguir os seguintes protocolos/formatos:
* Entre cliente e servidor SMTP ou entre servidores SMTP para invocar método enviar:
  – Requisição: MsgEmail (tipo objeto - usar readObject/writeObject);
  – Resposta: 0 ou 1 (tipo int - usar readInt/writeInt);
* Entre cliente e servidor POP para invocar método ler:
  – Requisição: usuário true/false (tipo objeto (String) - usar readObject/writeOb-
ject);
  – Resposta: lista de `MsgEmail` (tipo objeto - usar readObject/writeObject);
  
# Avaliação e Datas de Entrega
* Entregar via Github Classroom, conforme cronograma de entregas abaixo:
  - 13/09/2018 - Commit da versão 0.1
  - 17/09/2018 - Commit da versão 0.2
  - até 24/09/2018 às 13h50min - Commit da versão 1.0 (final) e apresentação em sala
* usar [tags](https://git-scm.com/book/pt-br/v1/Git-Essencial-Tagging) do git para marcar
os commits que representarão cada entrega.
* o trabalho poderá ser feito individualmente ou em dupla;
* dentro do projeto deve haver um arquivo leiame.txt contendo:
  – nome dos integrantes da equipe;
  – informações para compilação e execução do programa (se necessário);
  – bugs conhecidos e não resolvidos.
  
* A avaliação será feita levando em consideração:
  – se atende aos requisitos solicitados;
  – estruturação e clareza do código;
  – avaliação individual de cada participante. Todos os integrantes devem saber responder a qualquer questionamento do professor sobre a implementação de tópicos do trabalho.
  
 [Guia Rápido de Consulta do Git](https://services.github.com/on-demand/downloads/pt_BR/github-git-cheat-sheet.pdf) 



  
  
