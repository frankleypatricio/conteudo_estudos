/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Frankley
 */
public class Conexão {
    //Variáveis com as configurações para conexão com o banco de dados
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/arquivo_morto";
    private static final String USER = "root";
    private static final String PASS = null; //Windows
    //private static final String PASS = "seemg"; //Linux
    
    //Função que inicia conexão com o banco de dados
    public static Connection getConnection(){
        //Verifica se conexão funcionou ou ocorreu algum erro
        try{
            //Fazendo conexão
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(ClassNotFoundException | SQLException ex){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro de conexão: "+ex, "Connection Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Erro de conexão: ",ex);
        }
    }
    
    //Função que finaliza conexão com banco de dados (con= connection)
    public static void closeConnection(Connection con){
        //Verifica se existe alguma conexão
        if(con != null){
            //Verifica se desconexão funcionou ou ocorreu algum erro
            try{
                //Fecha conexão
                con.close();
            }catch(SQLException ex){
                //Mensagem de erro
                JOptionPane.showMessageDialog(null, "Erro de desconexão: "+ex, "Disconnection Error", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException("Erro de deconexão: ",ex);
            }
        }
    }
    
    /*PreparedStatement: uma forma de você fazer uma inserção no banco mais segura, onde você 
      prepara os parametros para serem inseridos, evitando assim ataques como o sql injection.
                OBS: funciona similar ao comando mysqli_escape_string() do PHP*/
    //Função que finaliza conexão com banco de dados (con= connection, stmt= statement)
    public static void closeConnection(Connection con, PreparedStatement stmt){
        //Fazendo desconexão do Connection
        closeConnection(con);
        
        //Verifica se existe alguma conexão
        if(stmt != null){
            //Verifica se desconexão funcionou ou ocorreu algum erro
            try{
                //Fecha conexão
                stmt.close();
            }catch(SQLException ex){
                //Mensagem de erro
                JOptionPane.showMessageDialog(null, "Erro de desconexão: "+ex, "Disconnection Error", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException("Erro de deconexão: ",ex);
            }
        }
    }
    
    /*ResultSet: é o retorno que o banco deu para o Statement, um conjunto com 
           o resultado do SQL (se não tiver resultado, estará vazio). */
    //Função que finaliza conexão com banco de dados (con= connection, stmt= statement, rs= result set)
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        //Fazendo desconexão do Connection e do PreparedStatement
        closeConnection(con, stmt);
        
        //Verifica se existe alguma conexão
        if(rs != null){
            //Verifica se desconexão funcionou ou ocorreu algum erro
            try{
                //Fecha conexão
                rs.close();
            }catch(SQLException ex){
                //Mensagem de erro
                JOptionPane.showMessageDialog(null, "Erro de desconexão: "+ex, "Disconnection Error", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException("Erro de deconexão: ",ex);
            }
        }
    }
}
