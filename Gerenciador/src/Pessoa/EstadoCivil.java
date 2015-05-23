/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pessoa;

/**
 *
 * @author wagner
 */


public class EstadoCivil {


/** Método construtor. Você deve utiliza-lo para criar  um novo registro de
     * Estado Civil
 *
 * @author wagner
 */
    private int estadoCivilId;
    private String estadoCivilDescricao;
   

 // Declaração do construtor da classe Estado Civil 

public EstadoCivil(String estadoCivilDescricao, int estadoCivilId) {

        this.estadoCivilDescricao = estadoCivilDescricao;
        this.estadoCivilId= estadoCivilId;
}
// Declaração de outro construtor da classe Estado Civil 
    public EstadoCivil(String estadoCivilDescricao) {

        this.estadoCivilDescricao = estadoCivilDescricao;
        
}
  //Declaração do método getBairroNome
    public String getEstadoCivilDescricao() {
        return this.estadoCivilDescricao;
        //retorna o nome do Estado Civil
    }

 //Declaração do método getEstadoCivilId
    public int getEstadoCivilId() {
        return this.estadoCivilId;
        //retorna o Id do Estado Civil
}
 //Declaração do método setestadoCivilDescricao
    public void setEstadoCivilDescricao(String estadoCivilDescricao) {
        this.estadoCivilDescricao = estadoCivilDescricao;
        // Altera o Estado Civil para o parametro passado 
    }

    //Declaração do método setEstadoCivilId
    public void setEstadoCivilId(int estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
        // Altera o Id para o paramtro passado
    }

}
    

