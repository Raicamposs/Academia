package gerenciador.matricula;


public class EstadoMatricula {

    /**
     * Método construtor. Você deve utiliza-lo para criar o registro de um novo
     * EstadoMatricula do aluno.
     *
     * @param estadoMatriculaId id da EstadoMatricula
     * @param estadoMatriculaNome nome da EstadoMatricula
     * @author G4Developers
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

    //Seta o Id do EstadoMatricula 
//    @Param Um inteiro contendo o Id do estadoMatricula

    public void setEstadoMatriculaId(int estadoMatriculaId) {
        this.estadoMatriculaId = estadoMatriculaId;
        
    }

     //Seta o  Nome  do EstadoMatricula 
//    @Param Uma String contendo o Nome do estadoMatricula

    public void setEstadoMatriculaNome(String estadoMatriculaNome) {
        this.estadoMatriculaNome = estadoMatriculaNome;
       
    }

    //Retorna o Id  do EstadoMatricula 
//    @return Uma String contendo o Id do estadoMatricula

    public int getEstadoMatriculaId() {
        return estadoMatriculaId;
      
    }

     //Retorna o  Nome  do EstadoMatricula 
//    @return Uma String contendo o Nome do estadoMatricula

    public String getEstadoMatriculaNome() {
        return estadoMatriculaNome;
       
    }

}
