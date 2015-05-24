
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
    private int id;
    private String nome;

    // Declaração do construtor da classe turno//
    public Turno(int id, String nome) {

        this.id = id;
        this.nome = nome;
    }
// Declaração do construtor da classe turno//

    public Turno(String nome) {

        this.nome = nome;
    }

    //Declaração do método setTurnoId

    public void setId(int id) {
        this.id = id;
        // Altera a variavel turnoId da classe turno para o parametro passado
    }

    //Declaração do método setTurnoNome

    public void setNome(String nome) {
        this.nome = nome;
        // Altera a variavel turnoNome da classe Turno para o parametro passado
    }

    //Declaração do método getTurnoId 

    public int getId() {
        return id;
        //retorna o Valor da Variavel turnoId
    }

    //Declaração do método getTurnoNome

    public String getNome() {
        return nome;
        //retorna o Valor da Variavel turnoNome
    }
}
