/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

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
public class FuncionarioDao {


    private final Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Funcionario funcionario;
    ArrayList funcao, turno,estadoCivil;
   

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

   
}
