/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.administrador;

/**
 *
 * @author Raiane
 */
public class Usuario {

    private String name;
    private int codigo;
    private String senha;
    private String login;
    private int nivel;
 

    public Usuario() {
    }

    public Usuario(String name, String login, String senha, int nivel) {

        this.name = name;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
    }

    public Usuario(String name, int nivel) {

        this.name = name;
        this.nivel = nivel;
    }

 

    public void setCod(int novo) {
        this.codigo = novo;
    }

    public int getCod() {
        return this.codigo;
    }

    public String getNome() {
        return this.name;
    }

    public void setNome(String novo) {
        this.name = novo;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String novo) {
        this.senha = novo;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
