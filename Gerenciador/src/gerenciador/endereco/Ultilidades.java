/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.endereco;

import gerenciador.alunos.CadastroAlunoGUI;
import gerenciador.conexaoBD.AlunoDao;
import gerenciador.conexaoBD.EnderecoDao;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Raiane
 */
public abstract class Ultilidades {

    public static void setCbmAula(AlunoDao conAluno, JComboBox cmbPacote1, JComboBox cmbPacote2) {
        try {
            cmbPacote1.removeAllItems();
            cmbPacote2.removeAllItems();
            Iterator iteratorAula = conAluno.getArrayAula().iterator();
            while (iteratorAula.hasNext()) {
                String aula = String.valueOf(iteratorAula.next());
                cmbPacote1.addItem(aula);
                cmbPacote2.addItem(aula);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setCbmEndereco(EnderecoDao conEndereco, JComboBox cmbBairro, JComboBox cmbEndereco) throws SQLException {
        cmbEndereco.removeAllItems();
        try {
            Iterator iteratorEndereco = conEndereco.getArrayRua((String) cmbBairro.getSelectedItem()).iterator();
            while (iteratorEndereco.hasNext()) {
                cmbEndereco.addItem(String.valueOf(iteratorEndereco.next()));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BairroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void setCbmCidade(EnderecoDao conEndereco, JComboBox cmbEstado, JComboBox cmbCidade, JComboBox cmbBairro, JComboBox cmbEndereco) throws SQLException {
        cmbCidade.removeAllItems();
        cmbBairro.removeAllItems();
        cmbEndereco.removeAllItems();
        Iterator iteratorCidade = null;
        try {
            iteratorCidade = conEndereco.getArrayCidade((String) cmbEstado.getSelectedItem()).iterator();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (iteratorCidade.hasNext()) {
            cmbCidade.addItem(String.valueOf(iteratorCidade.next()));
        }
        if (conEndereco.getArrayCidade((String) cmbEstado.getSelectedItem()).contains("Guarapari")) {
            cmbCidade.setSelectedItem("Guarapari");
        }
        setCbmBairro(conEndereco, cmbCidade, cmbBairro, cmbEndereco);
    }

    public static void setCbmBairro(EnderecoDao conEndereco, JComboBox cmbCidade, JComboBox cmbBairro, JComboBox cmbEndereco) throws SQLException {
        cmbBairro.removeAllItems();
        cmbEndereco.removeAllItems();
        Iterator iteratorBairro;

        try {
            iteratorBairro = conEndereco.getArrayBairro((String) cmbCidade.getSelectedItem()).iterator();
            if (iteratorBairro.hasNext()) {
                while (iteratorBairro.hasNext()) {
                    cmbBairro.addItem(String.valueOf(iteratorBairro.next()));
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, e);
        }
        setCbmEndereco(conEndereco, cmbBairro, cmbEndereco);
    }

    public static void setCbmEstado(EnderecoDao conEndereco, JComboBox cmbEstado, JComboBox cmbCidade, JComboBox cmbBairro, JComboBox cmbEndereco) throws SQLException {
        Iterator iteratorEstado = null;
        cmbEstado.removeAllItems();
        cmbCidade.removeAllItems();
        cmbBairro.removeAllItems();
        cmbEndereco.removeAllItems();
        try {
            iteratorEstado = conEndereco.getArrayEstados().iterator();
        } catch (SQLException ex) {
            Logger.getLogger(BairroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (iteratorEstado.hasNext()) {
            cmbEstado.addItem(String.valueOf(iteratorEstado.next()));
        }
        if (conEndereco.getArrayEstados().contains("Espírito Santo")) {
            cmbEstado.setSelectedItem("Espírito Santo");
        }
        setCbmCidade(conEndereco, cmbEstado, cmbCidade, cmbBairro, cmbEndereco);
    }

    public static void atualizaCbmEstado(JComboBox cmbCidade, JComboBox cmbBairro, JComboBox cmbEndereco) throws SQLException {
        cmbCidade.removeAllItems();
        cmbBairro.removeAllItems();
        cmbEndereco.removeAllItems();
        setCbmCidade(null, cmbCidade, cmbCidade, cmbBairro, cmbEndereco);
    }

    public static void setCbmEstadoCivil(AlunoDao conAluno, JComboBox cmbEstadoCivil) {
        try {
            cmbEstadoCivil.removeAllItems();
            Iterator iteratorEstadoCivil = conAluno.getArrayEstadoCivil().iterator();
            while (iteratorEstadoCivil.hasNext()) {
                cmbEstadoCivil.addItem(iteratorEstadoCivil.next());
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
