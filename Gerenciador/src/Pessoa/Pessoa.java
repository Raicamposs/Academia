/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

/**
 *
 * @author wagner
 */
public class Pessoa {

    private int id;
    private EstadoCivil estadoCivil;
    private String cpf;
    private String rg;
    private String nome;
    private String dataNascimento;
    private String email;
    private char sexo;

    // Declaração do construtor da classe Pessoa
    public Pessoa(int id, EstadoCivil estadoCivil, String cpf, String rg, String nome, String dataNascimento, String email, char sexo) {

        this.id = id;
        this.estadoCivil = estadoCivil;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.sexo = sexo;
    }
         //Declaração do método get

    public int getId() {
        return this.id;
    }

    public String getcpf() {
        return this.cpf;
    }

    public String getrg() {
        return this.rg;
    }

    public String getnome() {
        return this.nome;

    }

    public String getdataNascimento() {
        return this.dataNascimento;
    }

    public String getemail() {
        return this.email;

    }

    public char getsexo() {
        return this.sexo;
    }

    public int setId() {
        return this.id;
    }

    public String setcpf() {
        return this.cpf;
    }

    public String setrg() {
        return this.rg;
    }

    public String setnome() {
        return this.nome;

    }

    public String setdataNascimento() {
        return this.dataNascimento;
    }

    public String setemail() {
        return this.email;

    }

    public char setsexo() {
        return this.sexo;
    }
}
