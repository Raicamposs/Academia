/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.pessoa;

/**
 *
 * @author Raiane
 */
abstract class Telefones {

    protected String foneResidencial, foneCelular;

    public Telefones() {
    }

    public String getFoneCelular() {
        return foneCelular;
    }

    public String getFoneResidencial() {
        return foneResidencial;
    }


    public void setFoneCelular(String foneCelular) {
        this.foneCelular = foneCelular;
    }

    public void setFoneResidencial(String foneResidencial) {
        this.foneResidencial = foneResidencial;
    }

}
