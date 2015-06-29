/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.endereco;

import gerenciador.aula.CadastroAulaGUI;
import gerenciador.conexaoBD.EnderecoDao;
import java.sql.Array;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wagner
 */
public class BairroGUI extends javax.swing.JFrame {

    private EnderecoDao con;
    private String estado;

    public BairroGUI() {
        initComponents();
        gerenciador.telas.ultilidades.FuncoesJanelas.setIncone(this);
        this.setLocation(500, 300);
        con = new EnderecoDao();
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbCidade = new javax.swing.JComboBox();
        edtNome = new javax.swing.JTextField();
        lblGravar = new javax.swing.JLabel();
        lblFechar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Bairro");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 130, -1));

        edtNome.setBorder(null);
        edtNome.setSelectionColor(new java.awt.Color(0, 153, 0));
        edtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 46, 140, 21));

        lblGravar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGravarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGravarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGravarMouseExited(evt);
            }
        });
        getContentPane().add(lblGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 47, 75, 20));

        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        getContentPane().add(lblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 3, 15, 15));

        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });
        getContentPane().add(lblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 3, 15, 15));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Pequenas/CadastroBairro.png"))); // NOI18N
        lblFundo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeActionPerformed

    private void lblGravarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGravarMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblGravar);
    }//GEN-LAST:event_lblGravarMouseEntered

    private void lblGravarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGravarMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblGravar);
    }//GEN-LAST:event_lblGravarMouseExited

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblFecharMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        this.setExtendedState(BairroGUI.ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void cmbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCidadeActionPerformed

    }//GEN-LAST:event_cmbCidadeActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cmbCidade.removeAllItems();
        Iterator iteratorCidade = null;
        try {
            iteratorCidade = con.getArrayCidade(estado).iterator();
        } catch (SQLException ex) {
            Logger.getLogger(BairroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (iteratorCidade.hasNext()) {
            cmbCidade.addItem(String.valueOf(iteratorCidade.next()));
        }
        try {
            if (con.getArrayCidade(estado).contains("Guarapari")) {
                cmbCidade.setSelectedItem("Guarapari");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BairroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formComponentShown

    private void lblGravarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGravarMouseClicked
        if (!edtNome.getText().isEmpty()) {

            try {
                con.insertBairro(edtNome.getText(), (String) cmbCidade.getSelectedItem());
                cmbCidade.removeAllItems();
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CadastroAulaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Estes campos são obrigatorios!");

        }
    }//GEN-LAST:event_lblGravarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BairroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BairroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BairroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BairroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BairroGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbCidade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblGravar;
    private javax.swing.JLabel lblMinimizar;
    // End of variables declaration//GEN-END:variables
}
