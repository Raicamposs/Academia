package gerenciador.funcionario;


public class Funcao {

    /**
     * Método construtor. Você deve utiliza-lo para criar o registro de um nova
     * Funcao .
     *
     * @param id id da Funcao
     * @param nome nome da Funcao
     * @author 
     */
    private int id;
    private String nome;

    // Declaração do construtor da classe funcao//
    public Funcao(int id, String nome) {

        this.id = id;
        this.nome = nome;
    }
// Declaração do construtor da classe funcao//

    public Funcao(String nome) {

        this.nome = nome;
    }

    //Declaração do método funcaoId

    public void setId(int id) {
        this.id = id;
        // Altera a variavel funcaoId da classe Funcao para o parametro passado
    }

    //Declaração do método setFuncaoNome

    public void setNome(String nome) {
        this.nome = nome;
        // Altera a variavel funcaoNome da classe Funcao para o parametro passado
    }

    //Declaração do método getFuncaoId 

    public int getId() {
        return id;
        //retorna o Valor da Variavel  funcaoId
    }

    //Declaração do método getFuncaoNome

    public String getNome() {
        return nome;
        //retorna o Valor da Variavel  funcaoNome
    }

}
