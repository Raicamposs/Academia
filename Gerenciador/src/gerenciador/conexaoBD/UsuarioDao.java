/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Raiane
 */
public class UsuarioDao {

    private final Connection connection;
    private ResultSet rs;
    private static String nameLogado;
    private static int nivelLogado;

    public UsuarioDao() {
        this.connection = new ConnectionFactory().getConnection("academia", "299071", "root");
    }

    public void setUsuarioLogado(String nome, int nivel) {
        nameLogado = nome;

    }

    public int getNivelUsuarioLogado() {
        return nivelLogado;
    }

    public String getNamelUsuarioLogado() {
        return nameLogado;
    }

    public boolean compara(String usuario, String senha) {
        String sql = "{call ComparaUsuario(?,?)}";
        try {
            // seta os valores
            try ( // prepared statement para inserção
                    PreparedStatement novoStmt = connection.prepareStatement(sql)) {
                // seta os valores
                novoStmt.setString(1, usuario);
                novoStmt.setString(2, senha);

                rs = novoStmt.executeQuery();
                if (rs.first()) {
                    if (rs.getString("login").equalsIgnoreCase(usuario) && rs.getString("senha").equalsIgnoreCase(senha)) {
                        setUsuarioLogado(
                                rs.getString("nome"),
                                rs.getInt("nivel_acesso"));
                        novoStmt.close();
                        return true;
                    } else {
                        return false;
                    }
                }

            }
        } catch (SQLException | RuntimeException e) {

        }
        return false;
    }

}
