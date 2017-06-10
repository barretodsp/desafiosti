/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.List;


/**
 *
 * @author psantos
 */
public class Mensagem {
    /*
    Métodos Existentes:
    - boasVindas();
    - alunoInexistente();
    - alunoeInativo();
    - senhaSMS(string numCelular);
    - pedidoUffMailGerado(String uffmail);
    - escolha(List sugestoes, String nome);
    */
  
    
    public static void geraMensagem(int tipoMensagem, Object argumento){
        /*
        Convenção Adotada de Tipos de Mensagem:
        0- Boas Vindas;
        1- Matricula Inexistente;
        2- Matricula Inativa;
        3- Sobre SMS.
        4- Finalizando Pedido UFFMAIL
        5- Correção Escolha
       
        Default: Imprime o Argumento.
       
        */
        int resultado = 1;
        switch (tipoMensagem) {

            case 0:// Boas Vindas.
                 System.out.println("Olá! Através deste sistema você poderá solicitar seu UFF mail.");
                 System.out.println("Por favor, digite a sua matrícula: ");
                 break;
            
            case 1: // Matricula Inexistente
               System.out.println("Número de matrícula inexistente. Verifique se há erros na digitação e tente novamente.");
               break;
            
            case 2:// Matricula Inativa
                System.out.println("Não será possível realizar esta solicitação. Motivo: Matrícula Inativa.");
                break;

            case 3://SMS
                System.out.println("Um SMS foi enviado para "+argumento+" com a sua senha de acesso.");
                break;

            case 4: // Finalizando Pedido UFFMAIL
                System.out.println("A criação de seu e-mail ("+argumento+") será feita nos próximos minutos.");
                break;
            
            case 5: // Correção Escolha
                System.out.println("Escolha incorreta! Favor, escolher uma opção entre 1 - "+argumento+"." );
                break;
               
            default:// O default é quando eu só quero imprimir o argumento.
              System.out.println(argumento);
        }
    }
    
 public static void escolha(List sugestoes, String nome){
    
        int iterador = 1;
        String[] nm = nome.split(" ");
        System.out.println(nm[0]+", por favor escolha uma das opções abaixo para o seu UFFMail:");
        
        for (Object s: sugestoes) {
            System.out.println(iterador+" - " + s);
            iterador++;
        }
        
        
    }
    
}
