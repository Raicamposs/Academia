/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.endereco;

import gerenciador.aula.CadastroAulaGUI;
import gerenciador.conexaoBD.EnderecoDao;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raiane
 */
public class CidadeGUI extends javax.swing.JFrame {

    private EnderecoDao con;
    private String estado;

    public CidadeGUI() {
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

        cmbEstado = new javax.swing.JComboBox();
        lblGravar = new javax.swing.JLabel();
        lblFechar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Cidade");
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 130, -1));

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
        getContentPane().add(lblGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 46, 70, 22));

        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        getContentPane().add(lblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 4, 15, 15));

        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });
        getContentPane().add(lblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 4, 15, 15));

        edtNome.setBorder(null);
        edtNome.setSelectionColor(new java.awt.Color(0, 153, 0));
        getContentPane().add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 45, 147, 24));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Pequenas/CadastroCidade.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked

        this.dispose();

    }//GEN-LAST:event_lblFecharMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        this.setExtendedState(BairroGUI.ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblGravarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGravarMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblGravar);
    }//GEN-LAST:event_lblGravarMouseEntered

    private void lblGravarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGravarMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblGravar);
    }//GEN-LAST:event_lblGravarMouseExited

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cmbEstado.removeAllItems();
        Iterator iteratorCidade = null;
        try {
            iteratorCidade = con.getArrayEstados().iterator();

            while (iteratorCidade.hasNext()) {
                cmbEstado.addItem(String.valueOf(iteratorCidade.next()));
            }
            if (con.getArrayEstados().contains(estado)) {
                cmbEstado.setSelectedItem(estado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BairroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void lblGravarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGravarMouseClicked
        if (!edtNome.getText().isEmpty()) {

            try {
                con.insertCidade(edtNome.getText(), (String) cmbEstado.getSelectedItem());
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
            java.util.logging.Logger.getLogger(CidadeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CidadeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CidadeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CidadeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CidadeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JTextField edtNome;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblGravar;
    private javax.swing.JLabel lblMinimizar;
    // End of variables declaration//GEN-END:variables
}
