/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.responsavel;

import gerenciador.conexaoBD.ResponsavelDao;

/**
 *
 * @author Raiane
 */
public class CadastroResponsavelGUI extends javax.swing.JFrame {

    ResponsavelDao con;
    Responsavel responsavel;

    public CadastroResponsavelGUI() {
        initComponents();
        gerenciador.telas.ultilidades.FuncoesJanelas.setIncone(this);
        this.setLocation(400, 200);
        con = new ResponsavelDao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInformacoes = new javax.swing.JPanel();
        edtTelRes = new javax.swing.JTextField();
        edtNome = new javax.swing.JTextField();
        lblIdentidade = new javax.swing.JLabel();
        edtIdentidade = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblTelResidencial = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        edtCPF = new javax.swing.JTextField();
        edtCel = new javax.swing.JTextField();
        lblTelCelular = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblSalvar = new javax.swing.JLabel();
        lblCancela = new javax.swing.JLabel();
        lblFechar = new javax.swing.JLabel();
        lblMinimiza = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlInformacoes.setBackground(new java.awt.Color(255, 255, 255));

        lblIdentidade.setText("Identidade");

        lblNome.setText("Nome");

        lblTelResidencial.setText("Fone Res.:");

        lblCPF.setText("CPF");

        lblTelCelular.setText("Fone Cel.:");

        lblEmail.setText("Email");

        javax.swing.GroupLayout pnlInformacoesLayout = new javax.swing.GroupLayout(pnlInformacoes);
        pnlInformacoes.setLayout(pnlInformacoesLayout);
        pnlInformacoesLayout.setHorizontalGroup(
            pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelResidencial))
                        .addGap(10, 10, 10)
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                .addComponent(lblTelCelular)
                                .addGap(116, 116, 116))
                            .addComponent(edtCel, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIdentidade)
                                    .addComponent(edtIdentidade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(lblCPF))
                                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(edtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblNome)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)
                            .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlInformacoesLayout.setVerticalGroup(
            pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addComponent(lblIdentidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtIdentidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(edtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addComponent(lblCPF)
                        .addGap(26, 26, 26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createSequentialGroup()
                        .addComponent(lblTelResidencial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createSequentialGroup()
                        .addComponent(lblTelCelular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
        );

        getContentPane().add(pnlInformacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 380, 270));

        lblSalvar.setToolTipText("Salvar");
        lblSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalvarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSalvarMouseExited(evt);
            }
        });
        getContentPane().add(lblSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 204, 80, 40));

        lblCancela.setToolTipText("Cancelar");
        lblCancela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCancelaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCancelaMouseExited(evt);
            }
        });
        getContentPane().add(lblCancela, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 80, 40));

        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        getContentPane().add(lblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 30, 20));

        lblMinimiza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizaMouseClicked(evt);
            }
        });
        getContentPane().add(lblMinimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 30, 20));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Pequenas/CadastroResponsavel.jpg"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblFecharMouseClicked

    private void lblMinimizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizaMouseClicked
        this.setExtendedState(CadastroResponsavelGUI.ICONIFIED);
    }//GEN-LAST:event_lblMinimizaMouseClicked

    private void lblSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalvarMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblSalvar);
    }//GEN-LAST:event_lblSalvarMouseEntered

    private void lblCancelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelaMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblCancela);
    }//GEN-LAST:event_lblCancelaMouseEntered

    private void lblSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalvarMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblSalvar);
    }//GEN-LAST:event_lblSalvarMouseExited

    private void lblCancelaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelaMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblCancela);
    }//GEN-LAST:event_lblCancelaMouseExited

    private void lblCancelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelaMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblCancelaMouseClicked

    private void lblSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalvarMouseClicked
        responsavel = new Responsavel(edtCPF.getText(), edtIdentidade.getText(),
                edtNome.getText(), edtEmail.getText());
        responsavel.setFoneCelular(edtCel.getText());
        responsavel.setFoneResidencial(edtTelRes.getText());
    }//GEN-LAST:event_lblSalvarMouseClicked

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
            java.util.logging.Logger.getLogger(CadastroResponsavelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroResponsavelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroResponsavelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroResponsavelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroResponsavelGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edtCPF;
    private javax.swing.JTextField edtCel;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtIdentidade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtTelRes;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCancela;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblIdentidade;
    private javax.swing.JLabel lblMinimiza;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalvar;
    private javax.swing.JLabel lblTelCelular;
    private javax.swing.JLabel lblTelResidencial;
    private javax.swing.JPanel pnlInformacoes;
    // End of variables declaration//GEN-END:variables
}
