/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.telas;

/**
 *
 * @author J4CkS0N
 */
public class ConfirmaGUI extends javax.swing.JFrame {

    /**
     * Creates new form ConfirmaGUI
     */
    public ConfirmaGUI() {
        initComponents();
        this.setLocation(500, 300);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConfirmar = new javax.swing.JLabel();
        lblCancelar = new javax.swing.JLabel();
        lblFechar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lblConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 81, 55, 55));
        getContentPane().add(lblCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 84, 55, 50));

        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        getContentPane().add(lblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 15, 15));

        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });
        getContentPane().add(lblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 0, 15, 15));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Pequenas/tela confirma.png"))); // NOI18N
        lblFundo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFundoMouseClicked(evt);
            }
        });
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
      this.dispose();
    }//GEN-LAST:event_lblFecharMouseClicked

    private void lblFundoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFundoMouseClicked

    }//GEN-LAST:event_lblFundoMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
     this.setExtendedState(ConfirmaGUI.ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

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
            java.util.logging.Logger.getLogger(ConfirmaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblMinimizar;
    // End of variables declaration//GEN-END:variables
}