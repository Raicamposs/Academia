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
        String sql = ("call academia.insertAluno("
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            novoStmt.setString(1, aluno.getNome());
            novoStmt.setString(2, aluno.getRG());
            novoStmt.setString(3, aluno.getCpf());
            novoStmt.setString(4, aluno.getDataNascimento());
            novoStmt.setString(5, aluno.getEmail());
            novoStmt.setString(6, "" + aluno.getSexo());
            novoStmt.setInt(7, aluno.getEstadoCivil().getId());
            novoStmt.setInt(8, aluno.getEstadoMatricula());
            novoStmt.setString(9, aluno.getDataMatricula());
            novoStmt.setInt(10, Integer.parseInt(aluno.getVencimento()));
            novoStmt.setString(11, aluno.getObservacao());
            novoStmt.setString(12, aluno.getDataExame());
            novoStmt.setString(13, aluno.getDataAvaliacao());
            novoStmt.setInt(14, aluno.getEndereco().getCEP());
            novoStmt.setString(15, aluno.getEndereco().getComplemento());
            novoStmt.setString(16, aluno.getEndereco().getNumero());
            novoStmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @SuppressWarnings("empty-statement")
    public void preencheTable(JTable tblAluno, String nome, String matricula) throws SQLException {
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

    public void selectAuluno(Aluno aluno, String cpf) throws SQLException {
        String sql = ("call academia.getAluno(?);");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            novoStmt.setString(1, cpf);
            novoStmt.execute();
            rs = novoStmt.executeQuery();
            if (rs.first()) {
                aluno.setNome(rs.getString("Nome"));
                aluno.setRG(rs.getString("Rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setDataNascimento(rs.getString("Data_nascimento"));
                aluno.setEmail(rs.getString("email"));
                aluno.setSexo(rs.getString("Sexo").charAt(0));
                aluno.getEstadoCivil().setDescricao(rs.getString("Estado_Civil"));
                aluno.setEstadoMatricula(rs.getInt("Estado_Matricula"));
                aluno.setDataMatricula(rs.getString("Data_Matricula"));
                aluno.setVencimento(rs.getString("Vencimento_Matricula"));
                aluno.setObservacao(rs.getString("Observacao"));
                aluno.setDataExame(rs.getString("Validade_exame"));
                aluno.setDataAvaliacao(rs.getString("Validade_avaliacao"));
                aluno.getEndereco().setCEP(rs.getInt("CEP"));
                aluno.getEndereco().setComplemento(rs.getString("Complemento"));
                aluno.getEndereco().setEstadoNome(rs.getString("Estado"));
                aluno.getEndereco().setCidadeNome(rs.getString("Cidade"));
                aluno.getEndereco().setBairroNome(rs.getString("Bairro"));
                aluno.getEndereco().setRua(rs.getString("Rua"));
                aluno.getEndereco().setNumero(rs.getString("Numero"));
                selectTelefoneAuluno(aluno, rs.getInt("COD"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void selectTelefoneAuluno(Aluno aluno, int id) throws SQLException {
        String sql = ("call academia.getTelefone(?);");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            novoStmt.setInt(1, id);
            novoStmt.execute();
            rs = novoStmt.executeQuery();
            if (rs.first()) {
                aluno.setFoneResidencial(rs.getString("Telefone"));
            }
            if (rs.next()) {
                aluno.setFoneCelular(rs.getString("Telefone"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
