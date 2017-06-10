/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafiostimail;

import Classes.Aluno;
import Classes.Mensagem;
import Classes.Regras;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author psantos
 */
public class DesafioStiMail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
            Mensagem.boasVindas();

            String matricula = JOptionPane.showInputDialog("Por favor, digite a sua matrícula:");
            System.out.println(matricula);
            	
            Aluno aluno = Regras.buscaAluno(matricula);

            if(aluno !=null){ // caso o aluno exista, verifica o seu Statius.
                if(aluno.getStatus().equals("Ativo")){ // Se ativo

                    List sugestoes = Regras.geraSugestoes(aluno.getNome());
                  
                    Mensagem.escolha(sugestoes, aluno.getNome());
                    
                    Scanner sc = new Scanner(System.in);
                    int escolha = Integer.parseInt(sc.nextLine());
                    
                    // Este while trata a escolha do nº de opção.
                    while((escolha < 1) || (escolha > sugestoes.size()) ){
                        Mensagem.correcaoEscolha(sugestoes.size());
                        escolha = Integer.parseInt(sc.nextLine());
                    }
                    
                    Mensagem.pedidoUffMailGerado((String) sugestoes.get(escolha-1));
                    Mensagem.senhaSMS(aluno.getTelefone());
                
                }else                   // Se inativo
                    Mensagem.alunoInativo();
            
            }else // Caso a matrícula não existe.
                Mensagem.alunoInexistente();
    }

}