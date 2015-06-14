/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.telas;

import gerenciador.conexaoBD.UsuarioDao;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Timer;

/**
 *
 * @author Raiane
 */
public class CarregamentoGUI extends javax.swing.JFrame {

    private Timer tempo;
    private ActionListener al;
    private UsuarioDao con;

    public CarregamentoGUI() {

        con = new UsuarioDao();

//        URL url = this.getClass().getResource("/Imagens/lg 25x25.jpg");
//        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
//        this.setIconImage(imagemTitulo);
        this.setLocation(450, 150);

        tempo = new Timer(1, al);

        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (barraProgress.getValue() < 25) {
                    barraProgress.setValue(barraProgress.getValue() + 1);
                    laCarregamento.setText("Olá " + con.getNamelUsuarioLogado() + " ...");
                } else if (barraProgress.getValue() < 50) {
                    barraProgress.setValue(barraProgress.getValue() + 1);
                    laCarregamento.setText("Conectando ao Banco...");
                } else if (barraProgress.getValue() < 75) {
                    barraProgress.setValue(barraProgress.getValue() + 1);
                    laCarregamento.setText("Carregando Dados...");
                } else if (barraProgress.getValue() < 100) {
                    barraProgress.setValue(barraProgress.getValue() + 1);
                    laCarregamento.setText("Iniciando Aplicacão ...");
                } else {
                    tempo.stop();
                    mostrar();
                }

            }

            private void mostrar() {
                new PrincipalGUI().setVisible(true);
                dispose();
            }

        };
        tempo = new Timer(20, al);
        initComponents();
        tempo.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        barraProgress = new javax.swing.JProgressBar();
        laCarregamento = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 0));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraProgress.setBackground(new java.awt.Color(255, 255, 255));
        barraProgress.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(barraProgress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 430, 20));

        laCarregamento.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 12)); // NOI18N
        laCarregamento.setForeground(new java.awt.Color(255, 255, 255));
        laCarregamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        laCarregamento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(laCarregamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 430, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Pequenas/BackgroudCarregamento472x415.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CarregamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarregamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarregamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarregamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarregamentoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel laCarregamento;
    // End of variables declaration//GEN-END:variables
}
