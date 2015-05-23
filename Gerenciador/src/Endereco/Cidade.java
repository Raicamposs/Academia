package Endereco;

public class Cidade {

    /**
     * Método construtor. Você deve utiliza-lo para criar o registro de uma nova Cidade .
     * @param cidadeId id da Cidade
     * @param cidadeNome nome da Cidade
     * Raiane Campos, Jackson Brambati, Alexandre Ribeiro,Wagner Lemos
     */
    private int id;
    private String nome;
    
 
    // Declaração do construtor da classe cidade//
    public Cidade(int id, String nome) {

        this.id = id;
        this.nome = nome;
    }
// Declaração do construtor da classe cidade//

    public Cidade(String nome) {

        this.nome = nome;
    }

    //Declaração do método cidadeId

    public void setId(int id) {
        this.id = id;
        // Altera a variavel cidadeId da classe Cidade para o parametro passado
    }

    //Declaração do método setCidadeNome

    public void setNome(String nome) {
        this.nome = nome;
        // Altera a variavel cidadeNome da classe Cidade para o parametro passado
    }

    //Declaração do método getCidadeId 

    public int getId() {
        return id;
        //retorna o Valor da Variavel  cidadeId
    }

    //Declaração do método getCidadeNome

    public String getNome() {
        return nome;
        //retorna o Valor da Variavel  cidadeNome
    }

}
