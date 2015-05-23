/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

/**
 *
 * @author Raiane
 */
public class Telefones {

    String foneComercial, foneResidencial, foneCelular;

    public Telefones(String foneComercial, String foneResidencial, String foneCelular) {
        this.foneComercial = foneComercial;
        this.foneResidencial = foneResidencial;
        this.foneCelular = foneCelular;
    }

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
