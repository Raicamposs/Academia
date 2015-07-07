package gerenciador.funcionario;

import gerenciador.administrador.Usuario;
import gerenciador.pessoa.Pessoa;

/*
 * @author Evolute Jackson
 */
public class Funcionario extends Pessoa {

    private int id, situacao;
    private Usuario usario;
    private Funcao funcao;
    private Turno turno;
    private String cnt, observacao, dataEntrada;
    private float salario;
    private boolean usuarioAutorizado;

    /**
     *
     *
     * @param cpf
     * @param rg
     * @param nome
     * @param dataNascimento
     * @param email
     * @param sexo
     * @param cnt
     * @param salario
     */
    public Funcionario(String cpf, String rg, String nome,
            String dataNascimento, String email, char sexo,
            String cnt,
            float salario) {
        super(cpf, rg, nome, dataNascimento, email, sexo);
        usario = new Usuario();
        this.turno = new Turno();
        this.funcao = new Funcao();
        this.cnt = cnt;
        this.salario = salario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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

    public Usuario getUsario() {
        return usario;
    }

    public void setUsario(Usuario usario) {
        this.usario = usario;
    }

    public void setUsuarioAutorizado(boolean usuario) {
        this.usuarioAutorizado = usuario;
    }

    public boolean isUsuarioAutorizado() {
        return usuarioAutorizado;
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

    public Funcao getFuncao() {
        return funcao;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Turno getTurno() {
        return turno;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

}
