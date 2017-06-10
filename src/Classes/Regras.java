/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author psantos
 */
public class Regras {
    
    /* Alguns comentários Gerais: 
    Métodos existentes:
        - buscaAluno(String matricula);
        - geraSugestoes(String nome);
        - verificaPreposicao(String palavra);
        - sugestaoUm(String nome);
        - sugestaoDois(String nome);
        - sugestaoTres(String nome);
        - sugestaoQuatro(String nome);
        - sugestaoCinco(String nome);
 
    1- Não esquecer de registrar o novo método de sugestão de email ao método geraSugestoes;
    
    */
    
public static Aluno buscaAluno(String matricula) throws FileNotFoundException, IOException{
    /*
    Busca um aluno na base de dados atraves da matricula.
    */

        BufferedReader br = new BufferedReader(new FileReader("./entrada.csv"));
        String registro;
        int achei = 1 ;
        String[] linha = null;
        Aluno aluno = null;
        registro = br.readLine();// passa da primeira linha (cabeçalho) do csv.
        registro=null;
        
        while (((registro = br.readLine()) != null) && (achei == 1)){

                linha = registro.split(",");
             
        if(linha[1].equals(matricula))
            achei = 0;
        
        }
        if(achei == 0){
            aluno = new Aluno();
            aluno.setNome(linha[0]);
            aluno.setMatricula(linha[1]);
            aluno.setTelefone(linha[2]);
            aluno.setEmail(linha[3]);
            aluno.setUffmail(linha[4]);
            aluno.setStatus(linha[5]);
            
        }
        br.close();
        return aluno;
        
    }

public static int verificaPreposicao(String palavra){
    /*
    Verifica se a palavra fornecida é uma preposição ou não.
    */   
        int resultado = 1;
        switch (palavra) {

            case "dos":
                break;

            case "das":
                break;

            case "da":
                break;

            case "do":
                break;

            case "de": 
                break;

            default:
              resultado = 0;

        }
       return resultado; 
        
    }
   
public static String sugestaoUm(String nome){
     /*
    Método: sugestaoUm(String nome)
    
    Esta regra cria a sugestão do tipo FIRSTNAME_LASTNAME@id.uff.br 
    Pega o primeiro e o último nome e coloca entre "_";
    Ex: nome: Patrick Barreto dos Santos
    uffmail: patrick_santos@id.uff.br
    */  
    
    
    String[] s = nome.split(" ");
    int tam = s.length;
       
        String email = s[0]+"_"+s[tam-1]+"@id.uff.br";
        
      
        return email.toLowerCase();
    }
   
public static String sugestaoDois(String nome){
     /*
    Método: sugestaoDois(String nome)
    
    Cria a sugestão com a primeira letra do primeiro nome +
    o segundo sobrenome. 
    Ex: nome: Patrick Barreto dos Santos
    uffmail: pbarreto@id.uff.br
                            
    */  
    
    
        String email;
        String[] s = nome.split(" ");
        String letra = s[0].substring(0, 1);
        
        int r = Regras.verificaPreposicao(s[1]);
        if (r == 0)
            email = letra+s[1]+"@id.uff.br";
        else
            email = letra+s[2]+"@id.uff.br";
     
     
        return email.toLowerCase();
    }

public static String sugestaoTres(String nome){
    
 /*
    Método: sugestaoTrês(String nome)
    
    Cria a sugestão com o nome e primeiro sobrenome.
    Ex: nome: Patrick Barreto dos Santos
    uffmail: patrickbarreto@id.uff.br
                            
    */    
        String email;
        String[] s = nome.split(" ");
        
        int r = Regras.verificaPreposicao(s[1]);
        if (r == 0)
            email = s[0]+s[1]+"@id.uff.br";
        else
            email = s[0]+s[2]+"@id.uff.br";
     
     
        return email.toLowerCase();
        
    }

public static String sugestaoQuatro(String nome){
    
/*
    
    Método: sugestaoQuatro(String nome)
    
    Cria a sugestão com a primeiro nome mais as letras iniciais dos dois sobrenomes seguintes.
    1 - Caso: 
    Ex: Maria da Silva dos Reis.
    uffmail: mariasr@id.uff.br
            
    2 - Caso:
    Ex: Maria da Silva Reis.
    uffmail: mariasr@id.uff.br
    
    3 - Caso:
    Ex: Maria Silva Reis.
    uffmail: mariasr@id.uff.br
    
    4 - Caso:
    Ex: Maria da Silva.
    uffmail: mariads@id.uff.br
    
    */
    
        String email = null;
        String[] s = nome.split(" ");
        int r = Regras.verificaPreposicao(s[1]);
        // Maria da Silva 1
        //Maria Silva Santos 0
        // Maria Silva 0
        
        if ((r == 1) && (s.length > 3)){ // Nome com mais de 3 palavras e com preposição
            int r2 = Regras.verificaPreposicao(s[3]);
            if(r2 == 1){ // Maria(0) da(1) Silva(2) dos(3) Reis(4).
                String letra1 = s[2].substring(0, 1);
                String letra2 = s[4].substring(0, 1);
                email = s[0]+letra1+letra2+"@id.uff.br";
            }else{ // Maria(0) da(1) Silva(2) Reis(3)
                String letra1 = s[2].substring(0, 1);
                String letra2 = s[3].substring(0, 1);
                email = s[0]+letra1+letra2+"@id.uff.br";
            }
        }else if (s.length == 3){  // Maria da Silva ou Maria Silva Reis.
            String letra1 = s[1].substring(0, 1);
            String letra2 = s[2].substring(0, 1);
            email = s[0]+letra1+letra2+"@id.uff.br";
        }
        
        return email.toLowerCase();
    }

public static String sugestaoCinco(String nome){
     /*
    Método: sugestaoCinco(String nome)
    
    Cria a sugestão com a letra do primeiro nome mais os dois sobrenomes seguintes.
    1 - Caso: 
    Ex: Maria da Silva dos Reis.
    uffmail: msilvareis@id.uff.br
            
    2 - Caso:
    Ex: Maria da Silva Reis.
    uffmail: msilvareis@id.uff.br
    
    3 - Caso:
    Ex: Maria Silva Reis.
    uffmail: msilvareis@id.uff.br
    
    4 - Caso:
    Ex: Maria da Silva.
    uffmail: mdosreis@id.uff.br
    
    */    
       
        String email = null;
        String[] s = nome.split(" ");
        String letraNome = s[0].substring(0, 1);
                
        int r = Regras.verificaPreposicao(s[1]);
        // Maria da Silva 1
        //Maria Silva Santos 0
        // Maria Silva 0
        
        if ((r == 1) && (s.length > 3)){ // Nome com mais de 3 palavras e com preposição
            int r2 = Regras.verificaPreposicao(s[3]);
            if(r2 == 1) // Maria(0) da(1) Silva(2) dos(3) Reis(4).
                email = letraNome+s[2]+s[4]+"@id.uff.br";
            else // Maria(0) da(1) Silva(2) Reis(3)
                email = letraNome+s[2]+s[3]+"@id.uff.br";
            
        }else if (s.length == 3)  // Maria da Silva ou Maria Silva Reis.
            email = letraNome+s[1]+s[2]+"@id.uff.br";
               
        return email.toLowerCase();
        
    }
    
public static List geraSugestoes(String nome){
        
      //Tipo Lista escolhido porque gera maior flexibilidade quanto ao nº de sugestões fornecidas;
        List<String> sugestoes = new ArrayList<String>();
        
        sugestoes.add(Regras.sugestaoUm(nome));
        sugestoes.add(Regras.sugestaoDois(nome));
        sugestoes.add(Regras.sugestaoTres(nome));
        sugestoes.add(Regras.sugestaoQuatro(nome));
        sugestoes.add(Regras.sugestaoCinco(nome));
        return sugestoes;
    }
    
}
