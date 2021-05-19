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
public class DadosAluno {
    //Dados a serem salvos
    private String nome;
    private String resp;
    private String datanasc;
    private String cpf;
    private String id;
    private String sexo;
    private int matricula;
    
    //Construtor vazio
    public DadosAluno() {
    }

    //Construtor para cadastro
    public DadosAluno(String nome, String resp, String datanasc, String cpf, String id, String sexo) {
        this.nome = nome;
        this.resp = resp;
        this.datanasc = datanasc;
        this.cpf = cpf;
        this.id = id;
        this.sexo = sexo;
        this.matricula = matricula;
    }
    
    //Construtor para listagem
    public DadosAluno(String nome, String resp, String datanasc, String cpf, String id, String sexo, int matricula) {
        this.nome = nome;
        this.resp = resp;
        this.datanasc = datanasc;
        this.cpf = cpf;
        this.id = id;
        this.sexo = sexo;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
