package Endereco;

public class Estado {

    /**
     * Método construtor. Você deve utiliza-lo para criar o registro de um novo
     * author.
     *
     * @param estadoId id do Estado
     * @param estadoNome nome do Estado
     * @author
     */
    private int estadoId;
    private String estadoNome;
    private String estadoUf;

    // Declaração do construtor da classe estado//
    public Estado(int estadoId, String estadoNome, String estadoUf) {

        this.estadoId = estadoId;
        this.estadoNome = estadoNome;
        this.estadoUf = estadoUf;
    }
// Declaração do construtor da classe estado//

    public Estado(String estadoNome, String estadoUf) {

        this.estadoNome = estadoNome;
        this.estadoUf = estadoUf;
    }

    public Estado(String estadoUf) {
        this.estadoUf = estadoUf;
    }

   
    //Declaração do método getEstadoId 
    public int getEstadoId() {
        return estadoId;
        //retorna o Valor da Variavel  estadoId
    }

    //Declaração do método getEstadoNome
    public String getEstadoNome() {
        return estadoNome;
        //retorna o Valor da Variavel  estadoNome

    }

    //Declaração do método getEstadoUf
    public String getEstadoUf() {
        return estadoUf;
        //retorna o Valor da Variavel  estadoUf

    }

}
