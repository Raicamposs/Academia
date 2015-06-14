/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.endereco;

/**
 *
 * @author wagner
 */
public class Rua {
     
    private int ruaCep;
    private String ruaNome;
 

    // Declaração do construtor da classe rua//
    public Rua(int ruaCep, String ruaNome) {

        this.ruaCep = ruaCep;
        this.ruaNome = ruaNome;
        
    }
 public int getRuaCep() {
        return this.ruaCep;
    }

    public String getRuaNome() {
        return this.ruaNome;
    }

    public void setRuaCep(int ruaCep) {
        this.ruaCep = ruaCep;
    }

    public void setRuaNome(String ruaNome) {
        this.ruaNome = ruaNome;
    }

}

    

