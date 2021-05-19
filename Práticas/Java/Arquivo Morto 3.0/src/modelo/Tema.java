/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Frankley
 */
public class Tema {
    //Construtor vazio
    public Tema(){
    }
    
    //Função que guarda o tema
    public void changeTheme(int tema){
        //Verifica se ocorreu erro ao salvar os dados
        try{
            //Como será salvo o arquivo txt
            FileWriter fl = new FileWriter("theme.txt");
            //Escreve conteúdo
            PrintWriter pt = new PrintWriter(fl);
            //Guarda valor do tema
            pt.println(tema);
            //Envia dados
            pt.flush();
            //Finaliza
            pt.close();
            fl.close();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar tema: "+ex, "Erro ao Salvar Tema", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Função que carrega tema
    public int loadTheme(){
        //Criando variável que irá receber o último tema escolhido antes de fechar o programa
        int tema = 0;
        //Verificando possíveis erros
        try{
            //Criando leitura para o caminho passado
            FileReader file = new FileReader("theme.txt");
            //Lendo arquivo em buffer
            BufferedReader read_file = new BufferedReader(file);
            //Criando variável que guardará a linha lida
            String linha = "";
            //Verificando possíveis erros
            try{
                //Lendo linha e guardando na variável
                linha = read_file.readLine();
                //Se a linha for diferente de null
                if(linha != null){
                    //Tema recebe valor da linha convertido para int
                    tema = Integer.parseInt(linha);
                    
                    //Verifica se tema contém valor inválido
                    if(tema < 0 || tema > 4){
                        tema = 0;
                    }
                }
            }catch(IOException ex){
                Logger.getLogger(Tema.class.getName()).log(Level.SEVERE, null, ex);
            }catch(NumberFormatException ex){
                tema = 0;
            }
        }catch(FileNotFoundException ex){
            Logger.getLogger(Tema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Retornando valor do tema
        return tema;
    }
    
    //Função que guarda o nome do último usuário acessante
    public void saveUserName(String user_name){
        try{
            //Como será salvo o arquivo txt
            FileWriter fl = new FileWriter("lastuseracess.txt");
            //Escreve conteúdo
            PrintWriter pt = new PrintWriter(fl);
            //Guarda valor do tema
            pt.println(user_name);
            //Envia dados
            pt.flush();
            //Finaliza
            pt.close();
            fl.close();
        }catch (IOException ex){
            Logger.getLogger(Tema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Função que carrega tema
    public String loadUserName(){
        //Criando variável que irá receber o último tema escolhido antes de fechar o programa
        String last_user = "";
        //Verificando possíveis erros
        try{
            //Criando leitura para o caminho passado
            FileReader file = new FileReader("lastuseracess.txt");
            //Lendo arquivo em buffer
            BufferedReader read_file = new BufferedReader(file);
            //Criando variável que guardará a linha lida
            String linha = "";
            //Verificando possíveis erros
            try{
                //Lendo linha e guardando na variável
                linha = read_file.readLine();
                //Se a linha for diferente de null
                if(linha != null){
                    //Variável recebendo valor da linha para retornar para o usuário
                    last_user = linha;
                }
            }catch(IOException ex){
                Logger.getLogger(Tema.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(FileNotFoundException ex){
            Logger.getLogger(Tema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Retornando valor do tema
        return last_user;
    }
}
