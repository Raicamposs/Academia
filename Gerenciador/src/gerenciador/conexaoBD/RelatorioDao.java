/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Raiane
 */
public class RelatorioDao {

    private final Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;

    public RelatorioDao() {
        this.connection = new ConnectionFactory().getConnection("academia", "299071", "root");
    }

    public void relAluno() {
        String sql = "Select * from vw_pessoa_endereco;";

        try ( // prepared statement para inserção
                PreparedStatement novoStmt = connection.prepareStatement(sql)) {
            // seta os valores
            rs = novoStmt.executeQuery();
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    "\\Relatorio\\RelatorioAluno.jasper\"", new HashMap(), jrRS);
            JasperViewer.viewReport(jasperPrint);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "deu erro =" + erro);
        }
    }

}
