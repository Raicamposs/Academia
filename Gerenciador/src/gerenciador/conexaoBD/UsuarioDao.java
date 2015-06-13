/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import gerenciador.administrador.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
        this.nameLogado = nome;
        this.nivelLogado = nivel;
    }

    public int getNivelUsuarioLogado() {
        return this.nivelLogado;
    }

    public String getNamelUsuarioLogado() {
        return this.nameLogado;
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
                    setUsuarioLogado(rs.getString("name"), rs.getInt("nivel_acesso"));
                    novoStmt.close();
                    return true;
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private boolean verifcaUsuario(Usuario usuario) {
        String sql = "{call WhereLike(?,?)}";
        try {
            // seta os valores
            try ( // prepared statement para inserção
                    PreparedStatement stmt = connection.prepareStatement(sql)) {
                // seta os valores

                stmt.setString(1, usuario.getNome().toUpperCase());

                rs = stmt.executeQuery();
                if (!rs.wasNull()) {
                    if (rs.getString("name").equalsIgnoreCase(usuario.getNome())) {
                        stmt.close();
                        JOptionPane.showMessageDialog(null, "O usuario já está cadastrado!");
                        return false;
                    }
                } else {
                    stmt.setString(1, "login");
                    stmt.setString(2, usuario.getLogin());
                    rs = stmt.executeQuery();
                    if (!rs.wasNull()) {
                        stmt.close();
                        JOptionPane.showMessageDialog(null, "Este login já está cadastrado!");
                        return false;

                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;

    }

    public Boolean adicionaUsuario(Usuario usuario) {

        if (verifcaUsuario(usuario)) {
            String sql = "{call insertUsuario(?,?,?)}";

            try {
                // seta os valores
                try ( // prepared statement para inserção
                        PreparedStatement novoStmt = connection.prepareStatement(sql)) {
                    // seta os valores
                    novoStmt.setString(1, usuario.getNome().toUpperCase());
                    novoStmt.setString(2, usuario.getSenha());
                    novoStmt.setString(3, usuario.getLogin());

                    // executa
                    novoStmt.execute();
                    JOptionPane.showMessageDialog(null, "Cadastro Efetuado!");
                    novoStmt.close();
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return false;
        }
    }

}
