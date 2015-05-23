package Matricula;


public class EstadoMatricula {

    /**
     * Método construtor. Você deve utiliza-lo para criar o registro de um novo
     * author .
     *
     * @param estadoMatriculaId id da EstadoMatricula
     * @param estadoMatriculaNome nome da EstadoMatricula
     * @author 
     */
    private int estadoMatriculaId;
    private String estadoMatriculaNome;

    // Declaração do construtor da classe estadoMatricula//
    public EstadoMatricula(int estadoMatriculaId, String estadoMatriculaNome) {

        this.estadoMatriculaId = estadoMatriculaId;
        this.estadoMatriculaNome = estadoMatriculaNome;
    }
// Declaração do construtor da classe estadoMatricula//

    public EstadoMatricula(String estadoMatriculaNome) {

        this.estadoMatriculaNome = estadoMatriculaNome;
    }

    //Declaração do método estadoMatriculaId

    public void setEstadoMatriculaId(int estadoMatriculaId) {
        this.estadoMatriculaId = estadoMatriculaId;
        // Altera a variavel estadoMatriculaId da classe EstadoMatricula para o parametro passado
    }

    //Declaração do método setEstadoMatriculaNome

    public void setEstadoMatriculaNome(String estadoMatriculaNome) {
        this.estadoMatriculaNome = estadoMatriculaNome;
        // Altera a variavel estadoMatriculaNome da classe EstadoMatricula para o parametro passado
    }

    //Declaração do método getEstadoMatriculaId 

    public int getEstadoMatriculaId() {
        return estadoMatriculaId;
        //retorna o Valor da Variavel  estadoMatriculaId
    }

    //Declaração do método getEstadoMatriculaNome

    public String getEstadoMatriculaNome() {
        return estadoMatriculaNome;
        //retorna o Valor da Variavel  estadoMatriculaNome
    }

}
