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

            String matricula = JOptionPane.showInputDialog("Digite a sua matrícula:");
            System.out.println(matricula);
            	
            Aluno aluno = Regras.validaAluno(matricula);
            //criar regra para validar status e se o aluno já possui uffmail;
            //comentar o código;
            
            List sugestoes = Regras.geraSugestoes(aluno.getNome());
            
            Mensagem.escolha(sugestoes, aluno.getNome());
            
            Scanner sc = new Scanner(System.in);
            int escolha = Integer.parseInt(sc.nextLine());
            
            Mensagem.pedidoUffMailGerado((String) sugestoes.get(escolha-1));
            Mensagem.senhaSMS(aluno.getTelefone());
            

    }
}
