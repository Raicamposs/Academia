/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.pessoa;

/**
 *
 * @author wagner
 */
public class EstadoCivil {

    /**
     * Método construtor. Você deve utiliza-lo para criar um novo registro de
     * Estado Civil
     *
     * @author wagner
     */
    private int id;
    private String descricao;

    public EstadoCivil() {
    }

    // Declaração do construtor da classe Estado Civil
    public EstadoCivil(String descricao, int id) {

        this.descricao = descricao;
        this.id = id;
    }
// Declaração de outro construtor da classe Estado Civil 

    public EstadoCivil(String descricao) {

        this.descricao = descricao;

    }

    //Declaração do método getBairroNome
    public String getDescricao() {
        return this.descricao;
        //retorna o nome do Estado Civil
    }

    //Declaração do método getEstadoCivilId
    public int getId() {
        return this.id;
        //retorna o Id do Estado Civil
    }

    //Declaração do método setestadoCivilDescricao
    public void setDescricao(String descricao) {
        this.descricao = descricao;
        // Altera o Estado Civil para o parametro passado 
    }

    //Declaração do método setEstadoCivilId
    public void setId(int id) {
        this.id = id;
        // Altera o Id para o paramtro passado
    }

}
