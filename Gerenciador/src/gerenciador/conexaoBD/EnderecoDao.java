/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import gerenciador.endereco.Endereco;
import gerenciador.endereco.Bairro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Raiane
 */
public class EnderecoDao {

    // a conexão com o banco de dados
    private final Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Endereco endereco;
    ArrayList cidades, estados;

    public EnderecoDao() {
        this.connection = new ConnectionFactory().getConnection("academia", "299071", "root");
    }

    public void adicionaBairro(Bairro bairro) {

        String sql = "call academia.insertBairro(?, ?);";

        try {
            // seta os valores
            try ( // prepared statement para inserção
                    PreparedStatement novoStmt = connection.prepareStatement(sql)) {
                // seta os valores
                novoStmt.setString(1, bairro.getBairroNome());
                novoStmt.setInt(2, bairro.getCidadeId());

                // executa
                novoStmt.execute();
                JOptionPane.showMessageDialog(null, "Cadastro Efetuado!");
                novoStmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setBairro(Bairro bairro, ResultSet rs) throws SQLException {
        bairro.setBairroNome(rs.getString("nome"));
        bairro.setBairroId(rs.getInt("id"));
    }

    public void consultaBairro(int idCidade, Bairro bairro) {
        String sql = "call academia.getBairro(?);";
        try {
            // seta os valores
            try ( // prepared statement para inserção
                    PreparedStatement novoStmt = connection.prepareStatement(sql)) {
                // seta os valores

                novoStmt.setInt(1, idCidade);

                rs = novoStmt.executeQuery();
                if (rs.first()) {
                    setBairro(bairro, rs);
                    novoStmt.close();
                    rs.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum Resultado Encontrado!");
                }

                this.rs = stmt.executeQuery();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void selectCidade(String uf) throws SQLException {
        String sql = ("call academia.getCidade(?);");
        try {
            // seta os valores
            try ( // prepared statement para inserção
                    PreparedStatement novoStmt = connection.prepareStatement(sql)) {
                // seta os valores
                novoStmt.setString(1, uf);
                // executa

                rs = novoStmt.executeQuery();

                if (rs.first()) {
                    cidades = new ArrayList<>();
                    while (rs.next()) {
                        cidades.add(rs.getString("cid_nome"));

                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList getCidades(String uf) throws SQLException {
        selectCidade(uf);

        return cidades;
    }

    public void selectEstado() throws SQLException {
        String sql = ("call academia.getEstado;");
        try {
            // seta os valores
            try ( // prepared statement para inserção
                    PreparedStatement novoStmt = connection.prepareStatement(sql)) {
                rs = novoStmt.executeQuery();

                if (rs.first()) {
                    estados = new ArrayList<>();
                    while (rs.next()) {
                        estados.add(rs.getString("est_uf"));

                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getCidadesUf(String uf) throws SQLException {
        String sql = ("call academia.getCidade(?);");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            // seta os valores
            novoStmt.setString(1, uf);
            // executa

            rs = novoStmt.executeQuery();

            if (rs.first()) {
                cidades = new ArrayList<>();
                while (rs.next()) {
                    cidades.add(rs.getString("cid_nome"));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList getCidade(String uf) throws SQLException {
        selectCidade(uf);
        return cidades;
    }

    public ArrayList getEstados() throws SQLException {
        selectEstado();
        return estados;
    }

    public void closeConection() throws SQLException {
        try {
            if (!rs.isClosed()) {
                rs.close();
                stmt.close();
                connection.close();
            } else {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
