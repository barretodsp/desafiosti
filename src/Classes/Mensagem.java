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
    
  public static void boasVindas(){
    
        System.out.println("Olá! Através deste sistema você poderá solicitar seu UFF mail.");
        System.out.println("Por favor, digite a sua matrícula: ");
        
    }
  
    public static void alunoInexistente(){
    
        System.out.println("Número de matrícula inexistente. Verifique se há erros na digitação e tente novamente.");
    }
  
    public static void alunoInativo(){
    
        System.out.println("Não será possível realizar esta solicitação. Motivo: Matrícula Inativa.");
    }
   
    public static void senhaSMS(String numCelular){
        System.out.println("Um SMS foi enviado para "+numCelular+" com a sua senha de acesso.");
        
    }
    
    public static void pedidoUffMailGerado(String uffmail){
        
        System.out.println("A criação de seu e-mail ("+uffmail+") será feita nos próximos minutos.");
    }
    public static void correcaoEscolha(int numEscolhas){
        
        System.out.println("Escolha incorreta! Favor, escolher uma opção entre 1 - "+numEscolhas+"." );
    }
    
    public static void escolha(List sugestoes, String nome){
    
        int iterador = 1;
        System.out.println("Laura, por favor escolha uma das opções abaixo para o seu UFFMail:");
        
        for (Object s: sugestoes) {
            System.out.println(iterador+" - " + s);
            iterador++;
        }
        
        
    }
    
}
