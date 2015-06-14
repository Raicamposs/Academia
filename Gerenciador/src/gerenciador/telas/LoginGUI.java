/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.telas;

import gerenciador.conexaoBD.UsuarioDao;
import gerenciador.administrador.Usuario;
import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Raiane
 */
public class LoginGUI extends javax.swing.JFrame {

    private int contTentativa = 0;
    private UsuarioDao con;
    private Usuario user;

    public LoginGUI() {
        initComponents();
        con = new UsuarioDao();
        gerenciador.telas.ultilidades.FuncoesJanelas.setIncone(this);
        this.setLocation(500, 300);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        laAcessar = new javax.swing.JLabel();
        laLimpar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblFechar = new javax.swing.JLabel();
        txUsuario = new javax.swing.JTextField();
        txSenha = new javax.swing.JPasswordField();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        laAcessar.setNextFocusableComponent(txSenha);
        laAcessar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laAcessarMouseClicked(evt);
            }
        });
        getContentPane().add(laAcessar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 43, 70, 25));

        laLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laLimparMouseClicked(evt);
            }
        });
        getContentPane().add(laLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 95, 70, 25));

        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });
        getContentPane().add(lblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 6, 10, 10));

        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        getContentPane().add(lblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 6, 10, 10));

        txUsuario.setBorder(null);
        txUsuario.setSelectionColor(new java.awt.Color(0, 153, 0));
        txUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(txUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 46, 100, 20));

        txSenha.setBorder(null);
        txSenha.setSelectionColor(new java.awt.Color(0, 103, 0));
        txSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(txSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 98, 100, 20));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Pequenas/LoginNovo.png"))); // NOI18N
        lblFundo.setLabelFor(this);
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblFecharMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        this.setExtendedState(LoginGUI.ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void laAcessarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laAcessarMouseClicked
        if (txUsuario.getText().equals("") || new String(txSenha.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "Os campos não podem ser vazios");
        } else {
            if (contTentativa <= 1) {
                if (con.compara(txUsuario.getText(), new String(txSenha.getPassword()))) {
                    if (con.getNivelUsuarioLogado() == 0) {
                        new CarregamentoGUI().setVisible(true);
                        dispose();
                    } else {
                        new CarregamentoGUI().setVisible(true);
                        dispose();
                    }
                } else {
                    contTentativa++;
                    if (contTentativa == 1) {
                        JOptionPane.showMessageDialog(null, "Senha Incorreta!\n Você só tem mais uma chance");
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha Incorreta Novamente!\n Usuário Inabilitado para usar o Sistema");
                        dispose();
                    }
                }
            }

        }
    }//GEN-LAST:event_laAcessarMouseClicked

    private void laLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laLimparMouseClicked
        txSenha.setText("");
    }//GEN-LAST:event_laLimparMouseClicked

    private void txUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txSenha.requestFocus();
        }
    }//GEN-LAST:event_txUsuarioKeyPressed

    private void txSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            laAcessarMouseClicked(null);

        }
    }//GEN-LAST:event_txSenhaKeyPressed

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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel laAcessar;
    private javax.swing.JLabel laLimpar;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JPasswordField txSenha;
    private javax.swing.JTextField txUsuario;
    // End of variables declaration//GEN-END:variables
}
