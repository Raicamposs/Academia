/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import gerenciador.responsavel.Responsavel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Raiane
 */
public class ResponsavelDao {

    private final Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Responsavel responsavel;

    public ResponsavelDao() {
        this.connection = new ConnectionFactory().getConnection("academia", "299071", "root");
    }

    public void consultaNome(String nome, Responsavel responsavel) {
        String sql = "call academia.getPessoaNome(?);";
        try {
            // seta os valores
            try ( // prepared statement para inserção
                    PreparedStatement novoStmt = connection.prepareStatement(sql)) {
                // seta os valores

                novoStmt.setString(1, nome + "%");

                rs = novoStmt.executeQuery();
                if (rs.first()) {
                    responsavel.setNome(rs.getString("pes_nome"));
                    responsavel.setEmail(rs.getString("pes_email"));
                    responsavel.setCpf(rs.getString("pes_cpf"));
                    responsavel.setRG(rs.getString("pes_rg"));
                    responsavel.setFoneCelular(rs.getString("tel_num"));

                    if (rs.next()) {
                        if (rs.getString("pes_cpf").equalsIgnoreCase(responsavel.getCpf())) {
                            responsavel.setFoneResidencial(rs.getString("tel_num"));
                        }

                    }
                    novoStmt.close();
                    rs.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum Resultado Encontrado!");
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
