
package gerenciador.turma;

public class DiasSemana {
 /**
     * Método construtor. Você deve utiliza-lo para criar o registro de um novo
     * @param diaId id do DiasSemana
     * @param diaNome nome do DiasSemana
     * Raiane Campos, Jackson Brambati, Alexandre Ribeiro,Wagner Lemos
     */
    private int id;
    private String nome;

    // Declaração do construtor da classe DiasSemana//
    public DiasSemana(int id, String nome) {

        this.id = id;
        this.nome = nome;
    }
// Declaração do construtor da classe DiasSemana//

    public DiasSemana(String nome) {

        this.nome = nome;
    }

    //Declaração do método setdiasemanaId

    public void id(int id) {
        this.id = id;
        // Altera a variavel diasemanaId da classe DiasSemana para o parametro passado
    }

    //Declaração do método setdiaNome

    public void nome(String nome) {
        this.nome = nome;
        // Altera a variavel diasemanaNome da classe DiasSemana para o parametro passado
    }

    //Declaração do método getdiasemanaId 

    public int id() {
        return id;
        //retorna o Valor da Variavel diaId
    }

    //Declaração do método getdiasemanaNome

    public String nome() {
        return nome;
        //retorna o Valor da Variavel diaNome
    } 
}