/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

//import controle.Conexão;
import modelo.DadosUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Frankley
 */
public class UserSQL {
    //Função para cadastrar usuários
    public void insert(DadosUser user){
        //Abrindo conexão
        Connection con = Conexão.getConnection();
        //Preparando conexão
        PreparedStatement stmt = null;
        
        //Verificando possíveis erros
        try{
            //Salvando comando INSERT na variável
            stmt = con.prepareStatement("INSERT INTO usuario (cpf_user,nome_user,email_user,senha_user,status_user)VALUES(?,?,?,?,?)");
            
            /*Guardando na variável os dados salvos na classe DadosUser
            1= posição da descricao no comando INSERT
            p.getCPF()= carrega o CPF salvo na classe DadosUser*/
            stmt.setString(1,user.getCPF());
            stmt.setString(2,user.getNome());
            stmt.setString(3,user.getEmail());
            stmt.setString(4,user.getSenha());
            stmt.setString(5,user.getStatus());
            
            //Executando SQL
            stmt.executeUpdate();
            
            //Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Cadastro realizado com secesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: "+ex, "Register Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //Finalizando conexão
        Conexão.closeConnection(con, stmt);
    }
    
    //Função para listar usuários
    public List<DadosUser> select(){
        //Abrindo conexão
        Connection con = Conexão.getConnection();
        //Preparando conexão
        PreparedStatement stmt = null;
        //Criando resultado
        ResultSet rs = null;
        //Criando lista de usuários
        List<DadosUser> usuarios = new ArrayList();
        
        //Verificando possíveis erros
        try{
            //Salvando comando SELECT na variável
            stmt = con.prepareStatement("SELECT * FROM usuario");
            //Executando SQL e guardando resultado na variável rs
            rs = stmt.executeQuery();
            
            //Laço que adicionará um usuário na lista enquanto o resultado tiver um próximo usuário
            while(rs.next()){
                //Criando variável para guardar dados do usuário
                DadosUser user = new DadosUser(
                        //Passando dados do banco para o construtor
                        rs.getString("nome_user"),
                        rs.getString("email_user"),
                        rs.getString("cpf_user"),
                        rs.getString("senha_user"),
                        rs.getString("status_user")
                );
                
                //Adicionando usuário na lista de usuários
                usuarios.add(user);
            }
            
        }catch(SQLException ex){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários: "+ex, "List Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Finalizando conexão
            Conexão.closeConnection(con, stmt);
        }
        
        //Retornando lista de usuários
        return usuarios;
    }
    
    //Função para selecionar o usuário logado
    public DadosUser thisSelect(DadosUser user){
        //Abrindo conexão
        Connection con = Conexão.getConnection();
        //Preparando conexão
        PreparedStatement stmt = null;
        //Criando resultado
        ResultSet rs = null;
        //Criando variável que receberá os dados do usuário
        DadosUser usuario = new DadosUser();
        
        //Verificando possíveis erros
        try{
            //Salvando comando SELECT na variável
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE nome_user = ?");
            //Guardando na variável o nome do usuário passado
            stmt.setString(1,user.getNome());
            //Executando SQL e guardando resultado na variável rs
            rs = stmt.executeQuery();
            
            //Se rs tiver um próximo item, sendo que no momento está na posição null
            if(rs.next()){
                //Passando dados para a variável que retornará os dados
                usuario = new DadosUser(
                    //Passando dados do banco para o construtor
                    rs.getString("nome_user"),
                    rs.getString("email_user"),
                    rs.getString("cpf_user"),
                    rs.getString("senha_user"),
                    rs.getString("status_user")
                );
            }
            
        }catch(SQLException ex){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados do usuário: "+ex, "Load Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Finalizando conexão
            Conexão.closeConnection(con, stmt);
        }
        
        //Retornando dados do usuários
        return usuario;
    }
    
    //Função que verifica os dados do Login
    public int selectCheckLogin(String user, String senha){
        //Abrindo conexão
        Connection con = Conexão.getConnection();
        //Preparando conexão
        PreparedStatement stmt = null;
        //Criando resultado
        ResultSet rs = null;
        
        //Variável que retorna resultado da checagem
        int check_result = 0; //0 = Conta não existe; 1 = Conta existe; 2 = Conta inativa; 3 = Erro no banco de dados
        
        //Verificando possíveis erros
        try{
            //Salvando comando SELECT na variável
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE nome_user = ? and senha_user = ?");
            //Guardando na variável o usuário e senha passados
            stmt.setString(1,user);
            stmt.setString(2,senha);
            //Executando SQL e guardando resultado na variável rs
            rs = stmt.executeQuery();
            
            //Se rs tiver um próximo item, sendo que no momento está na posição null
            if(rs.next()){
                //Criando váriavel que recebe o status do usuário
                String check_status = rs.getString("status_user");
                
                //Verifica se usuário está ativo, se sim define 2 para a variável check_result
                if(check_status.equals("Ativo")){
                    check_result = 1;
                }else{ //if(check_status.equals("Inativo")")
                    check_result = 2;
                }
            }
        }catch(SQLException ex){
            check_result = 3;
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao verificar Login: "+ex, "Check Login Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Finalizando conexão
            Conexão.closeConnection(con, stmt, rs);
        }
        
        //Retornando resultado
        return check_result;
    }
    
    //Função que atualiza dados do usuário
    public void update(DadosUser user){
        //Abrindo conexão
        Connection con = Conexão.getConnection();
        //Preparando conexão
        PreparedStatement stmt = null;
        
        //Verificando possíveis erros
        try{
            //Salvando comando INSERT na variável
            stmt = con.prepareStatement("UPDATE usuario SET nome_user = ?, email_user = ?, senha_user = ?, status_user = ? WHERE cpf_user = ?");
            
            /*Guardando na variável os dados salvos na classe DadosUser
            1= posição da descricao no comando INSERT
            p.getCPF()= carrega o CPF salvo na classe DadosUser*/
            stmt.setString(1,user.getNome());
            stmt.setString(2,user.getEmail());
            stmt.setString(3,user.getSenha());
            stmt.setString(4,user.getStatus());
            stmt.setString(5,user.getCPF());
            
            //Executando SQL
            stmt.executeUpdate();
            
            //Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados do usuário: "+ex, "Update Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //Finalizando conexão
        Conexão.closeConnection(con, stmt);
    }
}
