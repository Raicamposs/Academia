/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.aula;

/**
 *
 * @author Raiane
 */
public class Aula {

    private String nome;
    private int id;
    private float valor;

    public Aula() {
    }

    public Aula(String nome, int id, float valor) {
        this.nome = nome;
        this.id = id;
        this.valor = valor;
    }

    public Aula(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getValor() {
        return valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
