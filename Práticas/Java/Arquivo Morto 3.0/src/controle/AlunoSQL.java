/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.DadosAluno;
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
public class AlunoSQL {
    //Função para cadastrar alunos
    public void insert(DadosAluno aluno){
        //Abrindo conexão
        Connection con = Conexão.getConnection();
        //Preparando conexão
        PreparedStatement stmt = null;
        
        try{
            //Salvando comando INSERT na variável
            stmt = con.prepareStatement("INSERT INTO aluno (nome_aluno,resp_aluno,datanasc_aluno,cpf_aluno,id_aluno,sexo_aluno)VALUES(?,?,?,?,?,?)");
            
            //Variáveis que guardam o dia, mês e ano para conversão
            String dia = aluno.getDatanasc().substring(0,2);
            String mes = aluno.getDatanasc().substring(3,5);
            String ano = aluno.getDatanasc().substring(6);
            
            //Guarda data para formato do MySQL
            String data = ano+"-"+mes+"-"+dia;
            
            //Passando pra variável os dados salvos na classe DadosAluno
            stmt.setString(1,aluno.getNome());
            stmt.setString(2,aluno.getResp());
            stmt.setString(3,data);
            //Verifica se foi passado um CPF
            if(!aluno.getCPF().equals("   .   .   -  ")){
                stmt.setString(4,aluno.getCPF());
            }else{
                stmt.setString(4,null);
            }
            stmt.setString(5,aluno.getID());
            stmt.setString(6,aluno.getSexo());
            
            //Executando SQL (no caso, o comando INSERT)
            stmt.execute();
            
            //Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Cadastro realizado com secesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: "+ex, "Register Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Função para selecionar último número de matrícula já cadastrado + 1
    public int selectMatricula(){
        //Abrindo conexão
        Connection con = Conexão.getConnection();
        //Preparando conexão
        PreparedStatement stmt = null;
        //Criando resultado
        ResultSet rs = null;
        //Criando lista de usuários
        
        //Variável que guardará o último número de matrícula cadastrado
        int matricula = 1;
        
        try{
            //Salvando comando SELECT na variável
            stmt = con.prepareStatement("SELECT matricula_aluno FROM aluno ORDER BY matricula_aluno");
            //Executando SQL e guardando resultado na variável rs
            rs = stmt.executeQuery();
            
            //Laço que adicionará um usuário na lista enquanto o resultado tiver um próximo aluno
            while(rs.next()){
                //Variável recebe número de matrícula + 1
                matricula = rs.getInt("matricula_aluno") + 1;
            }
        }catch(SQLException ex){
            //Passando 0 para número de matrícula
            matricula = 0;
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao obter número de matrícula a ser cadastrado: "+ex, "Get Registration Number Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //Retornando número de matrícula a ser cadastrado
        return matricula;
    }
    
    //Função para selecionar alunos especificados
    public List<DadosAluno> searchSelect(String espe_text, int espe_type){
        //Abrindo conexão
        Connection con = Conexão.getConnection();
        //Preparando conexão
        PreparedStatement stmt = null;
        //Criando resultado
        ResultSet rs = null;
        //Criando lista de usuários
        List<DadosAluno> alunos = new ArrayList();
        //Criando variável para verificar se encontrou algum resultado
        int result = 0;
        
        //Verificando possíveis erros
        try{
            //Verifica qual foi a especificação
            if(espe_type == 0){ //Nome
                //Salvando comando SELECT na variável
                stmt = con.prepareStatement("SELECT * FROM aluno");
            }else{ //if(espe_type == 1) //CPF
                //Verifica se foi passado um CPF
                if(!espe_text.equals("   .   .   -  ")){
                    //Salvando comando SELECT na variável
                    stmt = con.prepareStatement("SELECT * FROM aluno WHERE cpf_aluno IS NULL");
                }else{ //if(espe_text.equals("   .   .   -  "))
                    //Salvando comando SELECT na variável
                    stmt = con.prepareStatement("SELECT * FROM aluno WHERE cpf_aluno = ?");
                    //Guardando na variável especificações passados
                    stmt.setString(4,espe_text);
                }
            }
            //Executando SQL e guardando resultado na variável rs
            rs = stmt.executeQuery();
            
            //Verifica qual foi a especificação
            if(espe_type == 0){ //Nome
                //Laço que adicionará um usuário na lista enquanto o resultado tiver um próximo aluno
                while(rs.next()){
                    //Verifica se nome contém o texto especificado e se o texto especificado não está vazio
                    if(rs.getString("nome_aluno").contains(espe_text) && !espe_text.isEmpty() && !espe_text.equals(" ") && !espe_text.isEmpty() && !espe_text.equals("  ")){
                        //Variáveis que guardam o dia, mês e ano para conversão
                        String ano = rs.getString("datanasc_aluno").substring(0,4);
                        String mes = rs.getString("datanasc_aluno").substring(5,7);
                        String dia = rs.getString("datanasc_aluno").substring(8);
            
                        //Guarda data para formato para exibição
                        String data = dia+"/"+mes+"/"+ano;
                        
                        //Criando variável para guardar dados do aluno
                        DadosAluno aluno = new DadosAluno(
                            //Passando dados do banco para o construtor
                            rs.getString("nome_aluno"),
                            rs.getString("resp_aluno"),
                            data,
                            rs.getString("cpf_aluno"),
                            rs.getString("id_aluno"),
                            rs.getString("sexo_aluno"),
                            rs.getInt("matricula_aluno")
                        );
                
                        //Adicionando usuário na lista de alunos
                        alunos.add(aluno);
                        
                        //Aumentando contagem de resultados
                        result++;
                    }
                }
            }else{ //if(espe_type == 1) //CPF
                    //Laço que adicionará um usuário na lista enquanto o resultado tiver um próximo aluno
                    while(rs.next()){
                        //Variáveis que guardam o dia, mês e ano para conversão
                        String ano = rs.getString("datanasc_aluno").substring(0,4);
                        String mes = rs.getString("datanasc_aluno").substring(5,7);
                        String dia = rs.getString("datanasc_aluno").substring(8);
            
                        //Guarda data para formato para exibição
                        String data = dia+"/"+mes+"/"+ano;
                        
                        //Criando variável para guardar dados do aluno
                        DadosAluno aluno = new DadosAluno(
                            //Passando dados do banco para o construtor
                            rs.getString("nome_aluno"),
                            rs.getString("resp_aluno"),
                            data,
                            rs.getString("cpf_aluno"),
                            rs.getString("id_aluno"),
                            rs.getString("sexo_aluno"),
                            rs.getInt("matricula_aluno")
                        );
                
                        //Adicionando usuário na lista de alunos
                        alunos.add(aluno);
                        
                        //Aumentando contagem de resultados
                        result++;
                    }
            }
            
            //Verifica se algum aluno foi encontrado
            if(result != 0){
                //Verifica se 1 ou mais resultados foram encontrados
                if(result > 1){
                    //Mensagem de resultado
                    JOptionPane.showMessageDialog(null, "Foram encontrados "+result+" alunos", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                }else{ //if(result <= 1)
                    //Mensagem de resultado
                    JOptionPane.showMessageDialog(null, "Foi encontrado 1 aluno", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{ //if(result == 0)
                //Mensagem de resultado
                JOptionPane.showMessageDialog(null, "Nenhum aluno foi encontrado", "Search Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException ex){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários: "+ex, "List Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Finalizando conexão
            Conexão.closeConnection(con, stmt);
        }
        
        //Retornando lista de usuários
        return alunos;
    }
    
    //Função para selecionar alunos por classificação
    public List<DadosAluno> ratingSelect(int sexo_aluno, int classif){
        //Abrindo conexão
        Connection con = Conexão.getConnection();
        //Preparando conexão
        PreparedStatement stmt = null;
        //Criando resultado
        ResultSet rs = null;
        //Criando lista de usuários
        List<DadosAluno> alunos = new ArrayList();
        //Criando variáveis para guardar o sexo, campo e ordem de seleção dos campos
        String sexo = "";
        String campo = "";
        
        //Verificando possíveis erros
        try{
            //Verifica referente a qual campo será ordenado
            switch(classif){
                case 1: //Nome
                    campo = "nome_aluno";
                    break;
                case 2: //Data de Nascimento
                    campo = "datanasc_aluno";
                    break;
                case 3: //N° de Matrícula
                    campo = "matricula_aluno";
                    break;
                default: //Exibir Todos
                    //Mantem vazio
                    break;
            }
            
            //Verifica qual o sexo especificado
            if(sexo_aluno == 0){
                sexo = "m";
            }else{ //if(sexo_aluno == 1)
                sexo = "f";
            }
            
            //Verifica se escolheu exibir todos os alunos ou pediu para classificar
            if(classif == 0){
                //Salvando comando SELECT na variável
                stmt = con.prepareStatement("SELECT * FROM aluno ORDER BY matricula_aluno");
            }else{ //if(classif != 0)
                //Salvando comando SELECT na variável
                stmt = con.prepareStatement("SELECT * FROM aluno WHERE sexo_aluno = ? ORDER BY ?");
                //Guardando na variável especificações passados
                stmt.setString(1,sexo);
                stmt.setString(2,campo);
            }
            //Executando SQL e guardando resultado na variável rs
            rs = stmt.executeQuery();
            
            //Laço que adicionará um usuário na lista enquanto o resultado tiver um próximo usuário
            while(rs.next()){
                //Variáveis que guardam o dia, mês e ano para conversão
                String ano = rs.getString("datanasc_aluno").substring(0,4);
                String mes = rs.getString("datanasc_aluno").substring(5,7);
                String dia = rs.getString("datanasc_aluno").substring(8);
            
                //Guarda data para formato para exibição
                String data = dia+"/"+mes+"/"+ano;
                        
                //Criando variável para guardar dados do aluno
                DadosAluno aluno = new DadosAluno(
                    //Passando dados do banco para o construtor
                    rs.getString("nome_aluno"),
                    rs.getString("resp_aluno"),
                    data,
                    rs.getString("cpf_aluno"),
                    rs.getString("id_aluno"),
                    rs.getString("sexo_aluno"),
                    rs.getInt("matricula_aluno")
                );
                
                //Adicionando usuário na lista de alunos
                alunos.add(aluno);
            }
        }catch(SQLException ex){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários: "+ex, "List Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Finalizando conexão
            Conexão.closeConnection(con, stmt);
        }
        
        //Retornando lista de usuários
        return alunos;
    }
    
    //Função que atualiza dados do aluno
    public void update(DadosAluno aluno){
        //Abrindo conexão
        Connection con = Conexão.getConnection();
        //Preparando conexão
        PreparedStatement stmt = null;
        
        try{
            //Salvando comando INSERT na variável
            stmt = con.prepareStatement("UPDATE aluno SET nome_aluno = ?, resp_aluno = ?, datanasc_aluno = ?, cpf_aluno = ?, id_aluno = ?, sexo_aluno = ? WHERE matricula_aluno = ?");
            //Variáveis que guardam o dia, mês e ano para conversão
            String dia = aluno.getDatanasc().substring(0,2);
            String mes = aluno.getDatanasc().substring(3,5);
            String ano = aluno.getDatanasc().substring(6);
            
            //Guarda data para formato do MySQL
            String data = ano+"-"+mes+"-"+dia;
            
            //Passando pra variável os dados salvos na classe DadosAluno
            stmt.setString(1,aluno.getNome());
            stmt.setString(2,aluno.getResp());
            stmt.setString(3,data);
            //Verifica se foi passado um CPF
            if(!aluno.getCPF().equals("   .   .   -  ")){
                stmt.setString(4,aluno.getCPF());
            }else{
                stmt.setString(4,null);
            }
            stmt.setString(5,aluno.getID());
            stmt.setString(6,aluno.getSexo());
            stmt.setInt(7,aluno.getMatricula());
            
            //Executando SQL (no caso, o comando INSERT)
            stmt.execute();
            //Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados do aluno: "+ex, "Update Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
