package Funcionario;

import Pessoa.Pessoa;

/*
 * @author Evolute Jackson
 */

public class Funcionario {

    private int id;
    private Funcao funcao;
    private Pessoa pessoa;
    private Turno turno;
    private String cnt;
    private float salario;

    // Declaração do construtor da classe Funcionario//
    public Funcionario(int Id, Funcao funcao, Pessoa pessoa, Turno turno, String cnt, float salario) {

        this.id = Id;
        this.funcao = funcao;
        this.pessoa = pessoa;
        this.turno = turno;
        this.cnt = cnt;
        this.salario = salario;
    }
    //Declaração do método setId

    public void setId(int Id) {
        this.id = Id;
        // Altera a variavel Id da classe Funcao para o parametro passado
    }

    //Declaração do método Id 
    public int getId() {
        return id;
        //retorna o Valor da Variavel  Id
    }

    //Declaração do método setcnt
    public void setCnt(String cnt) {
        this.cnt = cnt;
        // Altera a variavel cnt da classe Funcao para o parametro passado
    }

    //Declaração do método cnt 
    public String getCnt() {
        return cnt;
        //retorna o Valor da Variavel  cnt
    }

    //Declaração do método salario
    public void setSalario(float salario) {
        this.salario = salario;
        // Altera a variavel salario da classe Funcao para o parametro passado
    }

    //Declaração do método cnt 
    public float getSalario() {
        return salario;
        //retorna o Valor da Variavel  salario
    }

}
