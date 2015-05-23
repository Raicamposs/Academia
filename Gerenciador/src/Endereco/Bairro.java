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
    private int id;
    private String nome;
   

 // Declaração do construtor da classe Bairro 

public Bairro(String bairroNome, int bairroId) {

        this.nome = bairroNome;
        this.id=bairroId;
}
// Declaração de outro construtor da classe Bairro 
    public Bairro(String nome) {

        this.nome = nome;
        
}
  //Declaração do método getBairroNome
    public String getNome() {
        return this.nome;
        //retorna o nome do bairro
    }

 //Declaração do método getBairroId
    public int getId() {
        return this.id;
        //retorna o Id do bairro
}
 //Declaração do método setBairroNome
    public void setNome(String nome) {
        this.nome = nome;
        // Altera o nome para o parametro passado 
    }

    //Declaração do método setBairroId
    public void setId(int id) {
        this.id = id;
        // Altera o Id para o paramtro passado
    }

}

