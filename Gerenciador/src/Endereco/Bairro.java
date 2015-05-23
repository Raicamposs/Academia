/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Endereco;
public class Bairro{
/** Método construtor. Você deve utiliza-lo para criar o registro de um novo
     * Bairro
 *
 * @author wagner
 */
    private int bairroId;
    private String bairroNome;
   

 // Declaração do construtor da classe Bairro 

public Bairro(String bairroNome, int bairroId) {

        this.bairroNome = bairroNome;
        this.bairroId=bairroId;
}
// Declaração de outro construtor da classe Bairro 
    public Bairro(String bairroNome) {

        this.bairroNome = bairroNome;
        
}
  //Declaração do método getBairroNome
    public String getBairroNome() {
        return this.bairroNome;
        //retorna o nome do bairro
    }

 //Declaração do método getBairroId
    public int getBairroId() {
        return this.bairroId;
        //retorna o Id do bairro
}
 //Declaração do método setBairroNome
    public void setBairroNome(String bairroNome) {
        this.bairroNome = bairroNome;
        // Altera o nome para o parametro passado 
    }

    //Declaração do método setBairroId
    public void setBairroId(int bairroId) {
        this.bairroId = bairroId;
        // Altera o Id para o paramtro passado
    }

}

