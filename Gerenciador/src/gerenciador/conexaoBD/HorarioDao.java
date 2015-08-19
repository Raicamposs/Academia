/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.conexaoBD;

import gerenciador.turma.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Raiane
 */
public class HorarioDao {

    public HorarioDao() {
        this.connection = new ConnectionFactory().getConnection("academia", "299071", "root");
    }

    private Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;

    private void realizaSelect() throws SQLException {
        stmt = connection.prepareStatement("SELECT * FROM academia.horario");
        rs = stmt.executeQuery();
    }

    public void consultaFrist(Horario horario) throws SQLException {
        realizaSelect();
        if (rs.first()) {
            setHorario(horario, rs);
        } else {
            JOptionPane.showMessageDialog(null, "Sem Registros!");
        }

    }

    public void consultaNext(Horario horario) throws SQLException {
        if (rs.isLast()) {
            rs.first();
        } else {
            rs.next();
        }
        setHorario(horario, rs);

    }

    public void consultaLast(Horario horario) throws SQLException {
        if (!rs.wasNull()) {
            if (rs.isFirst()) {
                rs.last();
            } else {

                rs.previous();
            }
            setHorario(horario, rs);
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

    private void setHorario(Horario horario, ResultSet rs) throws SQLException {
        horario.setHoraInicial(rs.getTime("hor_inicio"));
        horario.setHoraFinal(rs.getTime("hor_fim"));

    }
}
