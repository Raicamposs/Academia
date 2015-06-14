package gerenciador.funcionario;

import gerenciador.pessoa.Pessoa;



/*
 * @author Evolute Jackson
 */

public class Funcionario extends Pessoa {

    private int id;
    private int funcao;
    private int turno;
    private String cnt;
    private float salario;

    /**
     *
     * @param id
     * @param estadoCivil
     * @param cpf
     * @param rg
     * @param nome
     * @param dataNascimento
     * @param email
     * @param sexo
     * @param turno
     * @param cnt
     * @param funcao
     */
    public Funcionario(int id, int estadoCivil, String cpf, String rg, String nome,
            String dataNascimento, String email, char sexo, Turno turno, String cnt, Funcao funcao) {
        super(id, estadoCivil, cpf, rg, nome, dataNascimento, email, sexo);

        this.id = id;
        this.funcao = funcao.getId();
        this.turno = turno.getId();
        this.cnt = cnt;
        this.salario = salario;
    }


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
