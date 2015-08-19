/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Raiane
 */
public class FrequenciaDao {

    private final Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;
    private ArrayList arrayAula, arrayProfessor;

    public FrequenciaDao() {
        this.connection = new ConnectionFactory().getConnection("academia", "299071", "root");
    }

    public void insertFrequencia(String matricula) throws SQLException {

        int numMatricula = Integer.parseInt(matricula);
        String sql = ("call academia.InsertFrequencia(?);");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            novoStmt.setInt(1, numMatricula);

            novoStmt.execute();
            JOptionPane.showMessageDialog(null, "A frequencia de \n" + nome(numMatricula) + "\nfoi registrada!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private String nome(int matricula) throws SQLException {

        String sql = ("SELECT pes_nome FROM pessoa where pes_id = ?;");
        try (PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            novoStmt.setInt(1, matricula);
            novoStmt.execute();
            rs = novoStmt.executeQuery();
            if (rs.first()) {
                String nome = rs.getString("pes_nome");
                return nome;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "invalido!";
    }
}
