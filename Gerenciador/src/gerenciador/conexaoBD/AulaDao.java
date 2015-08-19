/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import gerenciador.aula.Aula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author wagner
 */
public class AulaDao {

    private final Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;
    private ArrayList arrayAula, arrayProfessor;

    public AulaDao() {
        this.connection = new ConnectionFactory().getConnection("academia", "299071", "root");
    }

    public void insertAula(String nome, double valor) throws SQLException {
        String sql = ("call academia.insertAula(?,?);");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            novoStmt.setString(1, nome);
            novoStmt.setDouble(2, valor);
            novoStmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateAula(Aula aula) throws SQLException {

        String upSql = "call academia.updateAula(?,?,?);";

        // seta os valores
        try {
            PreparedStatement ps = connection.prepareStatement(upSql);
            // seta os valores
            ps.setString(1, aula.getNome());
            ps.setFloat(3, aula.getValor());
            ps.setInt(2, aula.getId());

            // executa
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void realizaSelect() throws SQLException {
        stmt = connection.prepareStatement("SELECT * FROM academia.aula");
        rs = stmt.executeQuery();
    }

    public void consultaID(Aula aula, int i) throws SQLException {

        this.stmt = connection.prepareStatement("SELECT * FROM academia.aula where aul_id = ?");
        this.stmt.setInt(1, i);
        rs = stmt.executeQuery();
        rs.next();
        setAula(aula, rs);
        realizaSelect();

    }

    public void consultaFrist(Aula aula) throws SQLException {
        realizaSelect();
        if (rs.first()) {
            setAula(aula, rs);
        } else {
            JOptionPane.showMessageDialog(null, "Sem Registros!");
        }

    }

    public void consultaNext(Aula aula) throws SQLException {
        if (rs.isLast()) {
            rs.first();
        } else {
            rs.next();
        }
        setAula(aula, rs);

    }

    public void consultaLast(Aula aula) throws SQLException {
        if (!rs.wasNull()) {
            if (rs.isFirst()) {
                rs.last();
            } else {

                rs.previous();
            }
            setAula(aula, rs);
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

    public void consultaNome(String nome, Aula aula) {
        String sql = "SELECT * FROM academia.aula Where aul_nome like ?";
        try {
            // seta os valores
            try ( // prepared statement para inserção
                    PreparedStatement novoStmt = connection.prepareStatement(sql)) {
                // seta os valores

                novoStmt.setString(1, nome + "%");

                rs = novoStmt.executeQuery();
                if (rs.first()) {
                    setAula(aula, rs);
                    novoStmt.close();
                    rs.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum Resultado Encontrado!");
                }
                realizaSelect();
                this.rs = stmt.executeQuery();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void setAula(Aula aula, ResultSet rs) throws SQLException {
        aula.setNome(rs.getString("aul_nome"));
        aula.setValor(rs.getFloat("aul_valor"));
        aula.setId(rs.getInt("aul_id"));

    }

    private void getAula() throws SQLException {
        String sql = ("call academia.getAula();");
        arrayAula = new ArrayList<>();
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            rs = novoStmt.executeQuery();
            
            if (rs.first()) {
                while (rs.next()) {
                    arrayAula.add(rs.getString("aul_nome"));
                }
            }
        } catch (SQLException|NullPointerException e) {
           arrayAula.add("Sem Registros!");
        }

    }

    public ArrayList getArrayAula() throws SQLException {
        getAula();
        return arrayAula;
    }

    private void getProfessor() throws SQLException {
        String sql = ("call academia.getAula();");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            rs = novoStmt.executeQuery();

            if (rs.first()) {
                arrayProfessor = new ArrayList<>();
                while (rs.next()) {
                    arrayProfessor.add(rs.getString("aul_nome"));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList getArrayProfessor() throws SQLException {
        getProfessor();
        return arrayProfessor;
    }

}
