/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import gerenciador.aula.Aula;
import gerenciador.funcionario.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author wagner
 */
public class AulaDao {

    private final Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Aula aula;

    public AulaDao() {
        this.connection = new ConnectionFactory().getConnection("academia", "299071", "root");
    }

    public void insertAula(String nome, double valor) throws SQLException {
        String sql = ("call academia.insertAula(?,?);");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            novoStmt.setString(1, nome);
            novoStmt.setDouble(2, valor);
            novoStmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
