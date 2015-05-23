/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alunos;

/**
 *
 * @author Raiane
 */
public class Aluno {

    String nome, email, cpf, identidade, estadoCivil;

    public Aluno(String nome, String email, String cpf, String identidade, String estadoCivil) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.identidade = identidade;
        this.estadoCivil = estadoCivil;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
