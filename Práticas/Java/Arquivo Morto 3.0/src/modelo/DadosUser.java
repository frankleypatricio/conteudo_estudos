/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Frankley
 */
public class DadosUser {
    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private String status;
    
    //Construtor para edições
    public DadosUser(){
        
    }
    
    //Construtor para cadastro
    public DadosUser(String nome, String email, String cpf, String senha){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.status = "Ativo";
    }

    //Construtor para listagem
    public DadosUser(String nome, String email, String cpf, String senha, String status){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.status = status;
    }
    
    //Construtor para configurações da conta
    public DadosUser(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
