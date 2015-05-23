package Endereco;

public class Cidade {

    /**
     * Método construtor. Você deve utiliza-lo para criar o registro de um novo
     * author .
     *
     * @param cidadeId id da Cidade
     * @param cidadeNome nome da Cidade
     * @author Raiane Campos, Jackson Brambati, Alexandre Ribeiro,Wagner Lemos
     */
    private int cidadeId;
    private String cidadeNome;
    
 
    // Declaração do construtor da classe cidade//
    public Cidade(int cidadeId, String cidadeNome) {

        this.cidadeId = cidadeId;
        this.cidadeNome = cidadeNome;
    }
// Declaração do construtor da classe cidade//

    public Cidade(String cidadeNome) {

        this.cidadeNome = cidadeNome;
    }

    //Declaração do método cidadeId

    public void setCidadeId(int cidadeId) {
        this.cidadeId = cidadeId;
        // Altera a variavel cidadeId da classe Cidade para o parametro passado
    }

    //Declaração do método setCidadeNome

    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
        // Altera a variavel cidadeNome da classe Cidade para o parametro passado
    }

    //Declaração do método getCidadeId 

    public int getCidadeId() {
        return cidadeId;
        //retorna o Valor da Variavel  cidadeId
    }

    //Declaração do método getCidadeNome

    public String getCidadeNome() {
        return cidadeNome;
        //retorna o Valor da Variavel  cidadeNome
    }

}
