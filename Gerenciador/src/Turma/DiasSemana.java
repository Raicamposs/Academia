
package Turma;

public class DiasSemana {
 /**
     * Método construtor. Você deve utiliza-lo para criar o registro de um novo
     * author .
     *
     * @param diaId id do DiasSemana
     * @param diaNome nome do DiasSemana
     * @author Raiane Campos, Jackson Brambati, Alexandre Ribeiro,Wagner Lemos
     */
    private int diasemanaId;
    private String diasemanaNome;

    // Declaração do construtor da classe DiasSemana//
    public DiasSemana(int diasemanaId, String diasemanaNome) {

        this.diasemanaId = diasemanaId;
        this.diasemanaNome = diasemanaNome;
    }
// Declaração do construtor da classe DiasSemana//

    public DiasSemana(String diasemanaNome) {

        this.diasemanaNome = diasemanaNome;
    }

    //Declaração do método setdiasemanaId

    public void setdiasemanaId(int diasemanaId) {
        this.diasemanaId = diasemanaId;
        // Altera a variavel diasemanaId da classe DiasSemana para o parametro passado
    }

    //Declaração do método setdiaNome

    public void setdiasemanaNome(String diasemanaNome) {
        this.diasemanaNome = diasemanaNome;
        // Altera a variavel diasemanaNome da classe DiasSemana para o parametro passado
    }

    //Declaração do método getdiasemanaId 

    public int getdiasemanaId() {
        return diasemanaId;
        //retorna o Valor da Variavel diaId
    }

    //Declaração do método getdiasemanaNome

    public String getdiasemanaNome() {
        return diasemanaNome;
        //retorna o Valor da Variavel diaNome
    }
}