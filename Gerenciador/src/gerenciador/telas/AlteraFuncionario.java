/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.telas;

/**
 *
 * @author Raiane
 */
public class AlteraFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form AlteraFuncionario
     */
    public AlteraFuncionario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnterior = new javax.swing.JLabel();
        lblEdita = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        lblMinimiza = new javax.swing.JLabel();
        lblBusca = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        edtMatricula = new javax.swing.JTextField();
        lblConfirma = new javax.swing.JLabel();
        lblProximo = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblPesquisa = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAnteriorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAnteriorMouseExited(evt);
            }
        });
        getContentPane().add(lblAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 655, 117, 47));

        lblEdita.setToolTipText("");
        lblEdita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEditaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEditaMouseExited(evt);
            }
        });
        getContentPane().add(lblEdita, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 655, 117, 47));

        lblInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblInicioMouseExited(evt);
            }
        });
        getContentPane().add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 655, 117, 47));

        lblMinimiza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizaMouseClicked(evt);
            }
        });
        getContentPane().add(lblMinimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 186, 15, 15));
        getContentPane().add(lblBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 230, 70, 60));

        edtNome.setBorder(null);
        edtNome.setSelectionColor(new java.awt.Color(0, 153, 0));
        getContentPane().add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 228, 150, 23));

        edtMatricula.setBorder(null);
        edtMatricula.setSelectionColor(new java.awt.Color(0, 153, 0));
        getContentPane().add(edtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 255, 85, 23));

        lblConfirma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblConfirmaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblConfirmaMouseExited(evt);
            }
        });
        getContentPane().add(lblConfirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 655, 117, 47));

        lblProximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblProximoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblProximoMouseExited(evt);
            }
        });
        getContentPane().add(lblProximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 651, 117, 47));

        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("...");
        getContentPane().add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 730, 200, 30));

        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setText("...");
        getContentPane().add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 730, 220, 30));

        lblFecha.setToolTipText("");
        lblFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFechaMouseClicked(evt);
            }
        });
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 185, 15, 15));

        lblPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Pequenas/tela pesquisa.png"))); // NOI18N
        getContentPane().add(lblPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 350, 160));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Fundo/BackgroudAltera.jpg"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblInicioMouseClicked

    private void lblAnteriorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnteriorMouseEntered
        Ultilidades.Style.styleBorderEntered(lblAnterior);
    }//GEN-LAST:event_lblAnteriorMouseEntered

    private void lblAnteriorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnteriorMouseExited
        Ultilidades.Style.styleBorderExited(lblAnterior);
    }//GEN-LAST:event_lblAnteriorMouseExited

    private void lblEditaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditaMouseEntered
        Ultilidades.Style.styleBorderEntered(lblEdita);
    }//GEN-LAST:event_lblEditaMouseEntered

    private void lblInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioMouseEntered
        Ultilidades.Style.styleBorderEntered(lblInicio);
    }//GEN-LAST:event_lblInicioMouseEntered

    private void lblConfirmaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfirmaMouseEntered
        Ultilidades.Style.styleBorderEntered(lblConfirma);
    }//GEN-LAST:event_lblConfirmaMouseEntered

    private void lblProximoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProximoMouseEntered
        Ultilidades.Style.styleBorderEntered(lblProximo);
    }//GEN-LAST:event_lblProximoMouseEntered

    private void lblEditaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditaMouseExited
        Ultilidades.Style.styleBorderExited(lblEdita);
    }//GEN-LAST:event_lblEditaMouseExited

    private void lblInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioMouseExited
        Ultilidades.Style.styleBorderExited(lblInicio);
    }//GEN-LAST:event_lblInicioMouseExited

    private void lblConfirmaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfirmaMouseExited
        Ultilidades.Style.styleBorderExited(lblConfirma);
    }//GEN-LAST:event_lblConfirmaMouseExited

    private void lblProximoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProximoMouseExited
        Ultilidades.Style.styleBorderExited(lblProximo);
    }//GEN-LAST:event_lblProximoMouseExited

    private void lblFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFechaMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblFechaMouseClicked

    private void lblMinimizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizaMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblMinimizaMouseClicked

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
            java.util.logging.Logger.getLogger(AlteraFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlteraFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlteraFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlteraFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlteraFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edtMatricula;
    private javax.swing.JTextField edtNome;
    private javax.swing.JLabel lblAnterior;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JLabel lblConfirma;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEdita;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblMinimiza;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JLabel lblProximo;
    // End of variables declaration//GEN-END:variables
}
