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

    protected String foneComercial, foneResidencial, foneCelular;

   

    public String getFoneComercial() {
        return foneComercial;
    }

    public String getFoneCelular() {
        return foneCelular;
    }

    public String getFoneResidencial() {
        return foneResidencial;
    }

    public void setFoneComercial(String foneComercial) {
        this.foneComercial = foneComercial;
    }

    public void setFoneCelular(String foneCelular) {
        this.foneCelular = foneCelular;
    }

    public void setFoneResidencial(String foneResidencial) {
        this.foneResidencial = foneResidencial;
    }

}
