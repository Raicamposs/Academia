/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import gerenciador.administrador.Usuario;
import gerenciador.funcionario.Funcionario;
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
public class FuncionarioDao {

    private final Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Funcionario funcionario;
    private ArrayList funcao, turno, estadoCivil;
    private UsuarioDao conUsuario;

    public FuncionarioDao() {
        this.connection = new ConnectionFactory().getConnection("academia", "299071", "root");
    }

    private void getFuncao() throws SQLException {
        String sql = ("call academia.getAllFuncao();");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            rs = novoStmt.executeQuery();

            if (rs.first()) {
                funcao = new ArrayList<>();
                while (rs.next()) {
                    funcao.add(rs.getString("fun_nome"));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList getArrayFuncao() throws SQLException {
        getFuncao();
        return funcao;
    }

    private void getEstadoCivil() throws SQLException {
        String sql = ("call academia.getAllEstadoCivil();");
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

    private void getTurno() throws SQLException {
        String sql = ("call academia.getAllTurno();");
        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            rs = novoStmt.executeQuery();

            if (rs.first()) {
                turno = new ArrayList<>();
                while (rs.next()) {
                    turno.add(rs.getString("tur_nome"));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList getArrayTurno() throws SQLException {
        getTurno();
        return turno;
    }

    public void insertFuncionario(Funcionario funcionario) throws SQLException {
        if (verifcaUsuario(funcionario.getUsario())) {
            String sql = ("call academia.insertFuncionario("
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            try ( // prepared statement para inserção
                    PreparedStatement novoStmt = connection.prepareStatement(sql)) {
                novoStmt.setString(1, funcionario.getNome());
                novoStmt.setBoolean(2, funcionario.isUsuarioAutorizado());
                novoStmt.setString(3, funcionario.getRG());
                novoStmt.setString(4, funcionario.getCpf());
                novoStmt.setString(5, funcionario.getCnt());
                novoStmt.setFloat(6, funcionario.getSalario());
                novoStmt.setString(7, funcionario.getDataNascimento());
                novoStmt.setString(8, funcionario.getEmail());
                novoStmt.setString(9, "" + funcionario.getSexo());
                novoStmt.setInt(10, funcionario.getFuncao().getId());
                novoStmt.setInt(11, funcionario.getTurno().getId());
                novoStmt.setInt(12, funcionario.getSituacao());
                novoStmt.setString(13, funcionario.getDataEntrada());
                novoStmt.setString(14, funcionario.getObservacao());
                novoStmt.setInt(15, funcionario.getEndereco().getCEP());
                novoStmt.setString(16, funcionario.getEndereco().getComplemento());
                novoStmt.setString(17, funcionario.getEndereco().getNumero());
                novoStmt.setString(18, funcionario.getUsario().getLogin());
                novoStmt.setString(19, funcionario.getUsario().getSenha());
                novoStmt.setInt(20, funcionario.getUsario().getNivel());
                novoStmt.setInt(21, funcionario.getEstadoCivil().getId());
                novoStmt.execute();
                if (novoStmt.getUpdateCount() >= 1) {
                    JOptionPane.showMessageDialog(null, "Cadastro Efetuado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Algo deu errado!");

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private boolean verifcaUsuario(Usuario usuario) throws SQLException {
        String sql = "select * from academia.usuario Where usu_login = ?";

        try ( // prepared statement para inserção
                PreparedStatement usuStmt = connection.prepareStatement(sql)) {
            // seta os valores

            usuStmt.setString(1, usuario.getLogin().toUpperCase());
            rs = usuStmt.executeQuery();
            if (rs.first()) {
                if ((rs.getString("usu_login")).equalsIgnoreCase(usuario.getLogin())) {
                    usuStmt.close();
                    JOptionPane.showMessageDialog(null, "Este login já está cadastrado!");
                    return false;
                }
            }
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
