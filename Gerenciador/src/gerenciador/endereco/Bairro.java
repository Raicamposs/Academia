/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.endereco;

public class Bairro extends Cidade {

    /**
     * Método construtor. Você deve utiliza-lo para criar o registro de um novo
     * Bairro
     *
     * @author wagner
     */
    private int id;
    private String nome;


    public Bairro(int bairroId, int cidadeId, String estadoUf) {
        super(cidadeId, estadoUf);
        this.id = bairroId;
    }

    public Bairro(int id, String bairroNome, int cidadeId, String estadoUf) {
        super(cidadeId, estadoUf);
        this.nome = bairroNome;
        this.id = id;
    }

    //Declaração do método getBairroNome
    public String getBairroNome() {
        return this.nome;
        //retorna o nome do bairro
    }

    //Declaração do método getBairroId
    public int getBairroId() {
        return this.id;
        //retorna o Id do bairro
    }

    //Declaração do método setBairroNome
    public void setBairroNome(String nome) {
        this.nome = nome;
        // Altera o nome para o parametro passado 
    }

    //Declaração do método setBairroId
    public void setBairroId(int id) {
        this.id = id;
        // Altera o Id para o paramtro passado
    }

}
