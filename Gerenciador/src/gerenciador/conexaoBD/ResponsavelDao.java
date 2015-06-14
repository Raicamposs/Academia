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
}
