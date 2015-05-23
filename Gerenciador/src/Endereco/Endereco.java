/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Endereco;

/**
 *
 * @author Raiane
 */
public class Endereco {

    private String endereco, cep;
//    Bairro bairro;
//    Cidade cidade;
//    Estado uf;
//
//    public Endereco(String endereco, String cep, Bairro bairro, Cidade cidade, Estado uf) {
//
//        this.endereco = endereco;
//        this.cep = cep;
//        this.bairro = bairro;
//        this.cidade = cidade;
//        this.uf = uf;
//
//    }

    public String getEndereco() {
        return endereco;
    }

    public String getCEP() {
        return cep;
    }
//
//    public String getBairro() {
//        return bairro.getNome();
//    }
//
//    public String getCidade() {
//        return cidade.getNome();
//    }
//
//    public String getUf() {
//        return uf.getNome();
//    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCEP(String cep) {
        this.cep = cep;
    }

//    public void setBairro(String bairro) {
//        this.bairro = bairro;
//    }
//
//    public void setCidade(String cidade) {
//        this.cidade = cidade;
//    }
//
//    public void setUf(String uf) {
//        this.uf = uf;
//    }
}
