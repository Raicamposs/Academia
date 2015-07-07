package gerenciador.endereco;

public class Cidade extends Estado {

    /**
     * Método construtor. Você deve utiliza-lo para criar o registro de uma nova
     * Cidade .
     *
     * @param cidadeId id da Cidade
     * @param cidadeNome nome da Cidade Raiane Campos, Jackson Brambati,
     * Alexandre Ribeiro,Wagner Lemos
     */
    private int id;
    private String nome;

    public Cidade() {
    }

    public Cidade(String estadoNome) {
        super(estadoNome);
    }

    public Cidade(int cidadeId, String estadoUf) {
        super(estadoUf);
        this.id = cidadeId;
    }

    // Declaração do construtor da classe cidade//
    public Cidade(String cidadeNome, String estadoNome) {
        super(estadoNome);
        this.nome = cidadeNome;
     
    }

    //Declaração do método cidadeId
    public void setCidadeId(int id) {
        this.id = id;
        // Altera a variavel cidadeId da classe Cidade para o parametro passado
    }

    //Declaração do método setCidadeNome
    public void setCidadeNome(String nome) {
        this.nome = nome;
        // Altera a variavel cidadeNome da classe Cidade para o parametro passado
    }

    //Declaração do método getCidadeId 
    public int getCidadeId() {
        return id;
        //retorna o Valor da Variavel  cidadeId
    }

    //Declaração do método getCidadeNome
    public String getCidadeNome() {
        return nome;
        //retorna o Valor da Variavel  cidadeNome
    }

}
