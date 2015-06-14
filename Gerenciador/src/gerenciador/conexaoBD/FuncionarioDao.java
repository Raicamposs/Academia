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
    ArrayList  estadoCivil;

    public FuncionarioDao() {
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

}
   

