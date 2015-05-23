
package Funcionario;

public class Turno {
   /**
     * Método construtor. Você deve utiliza-lo para criar o registro de um novo
     * author .
     *
     * @param turnoId id do Turno
     * @param turnoNome nome do Turno
     * @author Raiane Campos, Jackson Brambati, Alexandre Ribeiro,Wagner Lemos
     */
    private int turnoId;
    private String turnoNome;

    // Declaração do construtor da classe turno//
    public Turno(int turnoId, String turnoNome) {

        this.turnoId = turnoId;
        this.turnoNome = turnoNome;
    }
// Declaração do construtor da classe turno//

    public Turno(String turnoNome) {

        this.turnoNome = turnoNome;
    }

    //Declaração do método setTurnoId

    public void setTurnoId(int turnoId) {
        this.turnoId = turnoId;
        // Altera a variavel turnoId da classe turno para o parametro passado
    }

    //Declaração do método setTurnoNome

    public void setTurnoNome(String turnoNome) {
        this.turnoNome = turnoNome;
        // Altera a variavel turnoNome da classe Turno para o parametro passado
    }

    //Declaração do método getTurnoId 

    public int getTurnoId() {
        return turnoId;
        //retorna o Valor da Variavel turnoId
    }

    //Declaração do método getTurnoNome

    public String getTurnoNome() {
        return turnoNome;
        //retorna o Valor da Variavel turnoNome
    }
}
