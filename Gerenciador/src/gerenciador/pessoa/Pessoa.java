/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.pessoa;

/**
 *
 * @author wagner
 */
public abstract class Pessoa extends Telefones {

    private int estadoCivil;
    private String cpf;
    private String rg;
    private String nome;
    private String dataNascimento;
    private String email;
    private char sexo;

    // Declaração do construtor da classe Pessoa
    public Pessoa(String cpf, String rg, String nome,
            String email) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.email = email;
    }

    // Declaração do construtor da classe Pessoa
    public Pessoa(int estadoCivil, String cpf, String rg, String nome,
            String dataNascimento, String email, char sexo) {

        this.estadoCivil = estadoCivil;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.sexo = sexo;
        EstadoCivil novo = new EstadoCivil(estadoCivil);
    }
    //Declaração do método get

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRG(String rg) {
        this.rg = rg;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSexo() {
        return this.sexo;
    }

 

    public String getCpf() {
        return this.cpf;
    }

    public String getRG() {
        return this.rg;
    }

    public String getNome() {
        return this.nome;

    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public String getEmail() {
        return this.email;

    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

}
