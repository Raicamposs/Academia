package Matricula;


public class EstadoMensalidade {

    /**
     * Método construtor. Você deve utiliza-lo para criar o registro de um novo
     * author .
     *
     * @param estadoMensalidadeId id da EstadoMensalidade
     * @param estadoMensalidadeNome nome da EstadoMensalidade
     * @author 
     */
    private int estadoMensalidadeId;
    private String estadoMensalidadeNome;

    // Declaração do construtor da classe estadoMensalidade//
    public EstadoMensalidade(int estadoMensalidadeId, String estadoMensalidadeNome) {

        this.estadoMensalidadeId = estadoMensalidadeId;
        this.estadoMensalidadeNome = estadoMensalidadeNome;
    }
// Declaração do construtor da classe estadoMensalidade//

    public EstadoMensalidade(String estadoMensalidadeNome) {

        this.estadoMensalidadeNome = estadoMensalidadeNome;
    }

    //Declaração do método estadoMensalidadeId

    public void setEstadoMensalidadeId(int estadoMensalidadeId) {
        this.estadoMensalidadeId = estadoMensalidadeId;
        // Altera a variavel estadoMensalidadeId da classe EstadoMensalidade para o parametro passado
    }

    //Declaração do método setEstadoMensalidadeNome

    public void setEstadoMensalidadeNome(String estadoMensalidadeNome) {
        this.estadoMensalidadeNome = estadoMensalidadeNome;
        // Altera a variavel estadoMensalidadeNome da classe EstadoMensalidade para o parametro passado
    }

    //Declaração do método getEstadoMensalidadeId 

    public int getEstadoMensalidadeId() {
        return estadoMensalidadeId;
        //retorna o Valor da Variavel  estadoMensalidadeId
    }

    //Declaração do método getEstadoMensalidadeNome

    public String getEstadoMensalidadeNome() {
        return estadoMensalidadeNome;
        //retorna o Valor da Variavel  estadoMensalidadeNome
    }

}
