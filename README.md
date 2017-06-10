# desafiosti
Desafio 1 - Descrição da Solução.


O projeto possui três classes:

1- Classe Aluno:
Encapsula todos os atributos do CSV e os métodos de Getters e Setters.
Os atributos são privados para evitar acesso direto, forçando o uso dos Getters e Setters.

2- Classe Mensagem:

Esta classe encapsula todas as mensagens utilizadas pelo sistema. A seguir, uma descrição sobre cada uma delas.
  
  Métodos:
  
  2.1- public static void geraMensagem(int tipoMensagem, Object argumento): gera a mensagem com base no seu tipo. Utiliza o argumento d        dependendo do tipo utilizado.
  
   Convenção Adotada de Tipos de Mensagem:
        0- Boas Vindas;
        1- Matricula Inexistente;
        2- Matricula Inativa;
        3- Sobre SMS.
        4- Finalizando Pedido UFFMAIL
        5- Correção Escolha
        Default: Apenas Imprime o Argumento. Recomenda-se colocar um nº negativo na chamada da função para cair no default.
  
  2.2- public static void escolha(List sugestoes, String nome): imprime a lista de sugestões.
  
  
3- Classe Regras:
  
  Esta classe encapsula as regras para criação de e-mail e sugestões.
  
  Métodos:
  
  3.1 - buscaAluno(String matricula): Busca o registro com base na matrícula.
  
  3.2 - geraSugestoes(String nome): concentra a chamada de funções para criação de sugestões do uffmail, armazenando-as em uma Lista.
  
  3.3 - verificaPreposicao(String palavra): verifica a ocorrência de preposições nos nomes. Ex: Dos, Das, De...
  
  3.4 - sugestaoUm(String nome): Esta regra cria a sugestão do tipo FIRSTNAME_LASTNAME@id.uff.br. Pega o primeiro e o último nome e             coloca entre "_"(underscor). Ex: nome: Patrick Barreto dos Santos --> uffmail: patrick_santos@id.uff.br
  
  3.5 - sugestaoDois(String nome):  Cria a sugestão com a primeira letra do primeiro nome + o segundo sobrenome. Ex: nome: Patrick               Barreto dos Santos --> uffmail: pbarreto@id.uff.br.
  
  3.6 - sugestaoTres(String nome): Cria a sugestão com o nome e primeiro sobrenome. Ex: nome: Patrick Barreto dos Santos --->  uffmail:         patrickbarreto@id.uff.br
  
  3.7 - sugestaoQuatro(String nome): Cria a sugestão com a primeiro nome + as letras iniciais dos dois sobrenomes seguintes.
   
  3.8 - sugestaoCinco(String nome): Cria a sugestão com a letra do primeiro nome + os dois sobrenomes seguintes.
 
************************************************************* 

Sobre o Funcionamento:

O usuário deverá fornecer uma matrícula Ativa para criação do UFF Mail. Caso a matrícula esteja Inativa, a seguinte mensagem será exibida: "Não será possível realizar esta solicitação. Motivo: Matrícula Inativa." Além disso, caso a matrícula não exista, o sistema informará: "Número de matrícula inexistente. Verifique se há erros na digitação e tente novamente."

Se matrícula ativa: o sistema irá criar cinco sugestões de e-mail e o usuário deverá optar por uma delas. Em seguida, o sistema informará que o e-mail será criado em minutos e um SMS será enviado ao usuário com a senha de acesso.


