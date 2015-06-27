/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import gerenciador.endereco.Endereco;
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
    ArrayList cidades, estados, bairro, rua;

    public EnderecoDao() {
        this.connection = new ConnectionFactory().getConnection("academia", "299071", "root");
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
                        estados.add(rs.getString("est_nome"));

                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList getArrayEstados() throws SQLException {
        selectEstado();
        return estados;
    }

    public void getCidades(String uf) throws SQLException {
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
            } else {

                cidades.add("Sem Registros");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList getArrayCidade(String uf) throws SQLException {
        getCidades(uf);
        return cidades;
    }

    public void getBairro(String cidade) throws SQLException {
        String sql = ("call academia.getBairro(?)");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            // seta os valores
            novoStmt.setString(1, cidade);
            // executa

            rs = novoStmt.executeQuery();

            if (rs.first()) {
                bairro = new ArrayList<>();
                while (rs.next()) {
                    bairro.add(rs.getString("bai_nome"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList getArrayBairro(String cidade) throws SQLException {
        getBairro(cidade);
        return bairro;
    }

    public void getRua(String bairro) throws SQLException {
        String sql = ("call academia.getRua(?)");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            // seta os valores
            novoStmt.setString(1, bairro + "%");
            // executa

            rs = novoStmt.executeQuery();

            if (rs.first()) {
                rua = new ArrayList<>();
                while (rs.next()) {
                    rua.add(rs.getString("rua_nome"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList getArrayRua(String bairro) throws SQLException {
        getBairro(bairro);
        return rua;
    }

    public void insertBairro(String nome, String cidade) throws SQLException {
        String sql = ("call academia.insertBairro(?,?);");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            novoStmt.setString(1, nome);
            novoStmt.setString(2, cidade);
            novoStmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void insertCidade(String nome, String estado) throws SQLException {
        String sql = ("call academia.insertCidade(?,?);");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            novoStmt.setString(1, nome);
            novoStmt.setString(2, estado);
            novoStmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
