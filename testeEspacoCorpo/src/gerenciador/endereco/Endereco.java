/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.endereco;

/**
 *
 * @author Raiane
 */
public class Endereco extends Bairro {

    private String endereco, cep;
    private int id;

    public Endereco(String endereco, String cep, int id, int bairroId, int cidadeId, String estadoUf) {
        super(bairroId, cidadeId, estadoUf);
        this.endereco = endereco;
        this.cep = cep;
        this.id = id;
    }

    public Endereco(int id, String endereco, String cep, int bairroId, int cidadeId, String estadoUf) {
        super(bairroId, cidadeId, estadoUf);
        this.endereco = endereco;
        this.cep = cep;
        this.id = id;

    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getCEP() {
        return this.cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCEP(String cep) {
        this.cep = cep;
    }

}
