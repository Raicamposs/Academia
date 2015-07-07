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

    private String rua,numero, complemento;
    private int  cep;

    public Endereco() {
    }


    public Endereco(String endereco, int cep, int bairroId, int cidadeId, String estadoUf) {
        super(bairroId, cidadeId, estadoUf);
        this.rua = endereco;
        this.cep = cep;
    }

    public Endereco(String bairro, String cidade, String estado, String endereco, int cep) {
        super(bairro, cidade, estado);
        this.rua = endereco;
        this.cep = cep;
    }

    public Endereco(int id, String endereco, int cep, int bairroId, int cidadeId, String estadoUf) {
        super(bairroId, cidadeId, estadoUf);
        this.rua = endereco;
        this.cep = cep;

    }

    public String getRua() {
        return this.rua;
    }

    public int getCEP() {
        return this.cep;
    }

    public void setRua(String endereco) {
        this.rua = endereco;
    }

    public void setCEP(int cep) {
        this.cep = cep;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getNumero() {
        return numero;
    }

}
