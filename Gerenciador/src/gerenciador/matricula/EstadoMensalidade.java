package gerenciador.matricula;

public class EstadoMensalidade {

    /**
     * Método construtor. Você deve utiliza-lo para criar o registro de um novo
     * EstadoMensalidade do aluno.
     *
     * @param estadoMensalidadeId id da EstadoMensalidade
     * @param estadoMensalidadeNome nome da EstadoMensalidade
     * @author G4Developers
     */
    private int estadoMensalidadeId;
    private String estadoMensalidadeNome;

    // Declaração do construtor da classe estadoMensalidade//
    public EstadoMensalidade(int estadoMensalidadeId,
            String estadoMensalidadeNome) {

        this.estadoMensalidadeId = estadoMensalidadeId;
        this.estadoMensalidadeNome = estadoMensalidadeNome;

    }
// Declaração do construtor da classe estadoMensalidade//

    public EstadoMensalidade(String estadoMensalidadeNome) {

        this.estadoMensalidadeNome = estadoMensalidadeNome;
    }

    //Seta o Id do EstadoMensalidade
    //@param um int contendo o a id do EstadoMensalidade
    public void setEstadoMensalidadeId(int estadoMensalidadeId) {
        this.estadoMensalidadeId = estadoMensalidadeId;

    }

    //Seta o nome do EstadoMensalidade
    //@param um string contendo o a nome do EstadoMensalidade
    public void setEstadoMensalidadeNome(String estadoMensalidadeNome) {
        this.estadoMensalidadeNome = estadoMensalidadeNome;
    }

    //Declaração do método getEstadoMensalidadeId 
    public int getEstadoMensalidadeId() {
        return estadoMensalidadeId;
        //retorna o Valor da Variavel  estadoMensalidadeId
    }

    //Declaração do método getEstadoMensalidadeNome
    public String getEstadoMensalidadeNome() {
        return estadoMensalidadeNome;
        //retorna o nome do  estadoMensalidadeNome
        //@return uma String contendo o nome EstadoMensalidade
    }

}
