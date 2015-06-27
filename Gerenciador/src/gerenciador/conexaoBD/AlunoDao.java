/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import gerenciador.alunos.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raiane
 */
public class AlunoDao {

    private final Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Aluno aluno;
    ArrayList aula, estadoCivil;
    private Object[] alunos;

    public AlunoDao() {
        this.connection = new ConnectionFactory().getConnection("academia", "299071", "root");
    }

    private void getAula() throws SQLException {
        String sql = ("call academia.getAula();");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            rs = novoStmt.executeQuery();

            if (rs.first()) {
                aula = new ArrayList<>();
                while (rs.next()) {
                    aula.add(rs.getString("aul_nome"));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList getArrayAula() throws SQLException {
        getAula();
        return aula;
    }

    private void getEstadoCivil() throws SQLException {
        String sql = ("call academia.getEstadoCivil();");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            rs = novoStmt.executeQuery();

            if (rs.first()) {
                estadoCivil = new ArrayList<>();
                while (rs.next()) {
                    estadoCivil.add(rs.getString("ec_descricao"));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList getArrayEstadoCivil() throws SQLException {
        getEstadoCivil();
        return estadoCivil;
    }

    public void insertAuluno(Aluno aluno) throws SQLException {
        String sql = ("call academia.insertAluno(?,?,?,?,?,?);");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            novoStmt.setString(1, aluno.getEmail());
            novoStmt.setString(2, aluno.getRG());
            novoStmt.setString(3, aluno.getDataNascimento());
            novoStmt.setString(4, aluno.getDataNascimento());
            novoStmt.setString(5, aluno.getEmail());
            novoStmt.setString(6, "" + aluno.getSexo());
// novoStmt.setInt(7, aluno.get);
// novoStmt.setString(1, id int,
// novoStmt.setString(1, pes_id int,
//// novoStmt.setString(1,em_id int, in data_matricula date,
// novoStmt.setString(1, dia_venc_mensal int,
// novoStmt.setString(1, observacoes varchar(200),
// novoStmt.setString(1, validade_exame date,
// novoStmt.setString(1,validade_avaliacao date,
// novoStmt.setString(1, rua_cep int,
// novoStmt.setString(1,complemento varchar(100),
// novoStmt.setString(1, num  varchar(8))

            novoStmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getAlunos(JTable tblAluno, String nome, String matricula) throws SQLException {
        String sql = ("call academia.getPessoaNomeORCpf(?,?);");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            novoStmt.setString(1, nome + "%");
            novoStmt.setString(2, matricula + "%");
            rs = novoStmt.executeQuery();

            tblAluno.getColumnModel().getColumn(0).setPreferredWidth(50);
            for (int i = 1; i < 6; i++) {
                tblAluno.getColumnModel().getColumn(i).setPreferredWidth(20);
            }

            if (rs.first()) {

                DefaultTableModel modelo = (DefaultTableModel) tblAluno.getModel();
                modelo.setNumRows(0);
                modelo.addRow(new Object[]{
                    rs.getString("Nome"),
                    rs.getString("Cpf"),
                    rs.getString("Rg"),
                    rs.getString("Data_nascimento"),
                    rs.getString("Email"),
                    rs.getString("Estado_Civil")
                });
                while (rs.next()) {
                    modelo.addRow(new Object[]{
                        rs.getString("Nome"),
                        rs.getString("Cpf"),
                        rs.getString("Rg"),
                        rs.getString("Data_nascimento"),
                        rs.getString("Email"),
                        rs.getString("Estado_Civil")
                    }
                    );
                };

            };

        }

    }
}
