/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Raiane
 */
public class ConnectionFactory {

    public Connection getConnection(String banco, String senha, String usuario) {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/" + banco, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }

  


}
