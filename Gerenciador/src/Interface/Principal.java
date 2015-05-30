/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Raiane
 */
public class Principal extends javax.swing.JFrame {

    String formatohora = "HH:mm:ss";
    SimpleDateFormat horaformatada = new SimpleDateFormat(formatohora);
    String dia, mes, ano;

    public Principal() {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);

        initComponents();

        URL url = this.getClass().getResource("/Imagens/lg 25x25.jpg");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        mes = "" + Calendar.MONTH;
        dia = "" + Calendar.DAY_OF_MONTH;
        ano = "" + Calendar.YEAR;
        laData.setText(" Data.: " + dia + "/" + mes + "/" + ano);
        timer_hora.setDelay(1000);
        timer_hora.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timer_hora = new org.netbeans.examples.lib.timerbean.Timer();
        painelPrincipal = new javax.swing.JPanel();
        painelCentral = new javax.swing.JPanel();
        painelConsulta = new javax.swing.JPanel();
        boPesqFuncionario = new javax.swing.JButton();
        boPesqAluno = new javax.swing.JButton();
        laConsulta = new javax.swing.JLabel();
        painelCadastro = new javax.swing.JPanel();
        boFuncionario = new javax.swing.JButton();
        boAluno = new javax.swing.JButton();
        laCadastro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        painelBarra = new javax.swing.JPanel();
        laHora = new javax.swing.JLabel();
        laData = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        meCadastroAutor = new javax.swing.JRadioButtonMenuItem();
        meConsultarAutor = new javax.swing.JRadioButtonMenuItem();
        meAlteraAutor = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        meCadastroLivro = new javax.swing.JRadioButtonMenuItem();
        meAlteraLivro = new javax.swing.JMenuItem();
        meConsultarLivro = new javax.swing.JRadioButtonMenuItem();
        mnUsuario = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        meExit = new javax.swing.JMenu();

        timer_hora.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer_horaOnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Espaço Corpo");
        setBackground(new java.awt.Color(255, 0, 0));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1024, 700));
        setPreferredSize(new java.awt.Dimension(1024, 700));

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setMaximumSize(new java.awt.Dimension(1024, 700));
        painelPrincipal.setPreferredSize(new java.awt.Dimension(1015, 620));
        painelPrincipal.setRequestFocusEnabled(false);

        painelCentral.setBackground(new java.awt.Color(255, 255, 255));

        painelConsulta.setBackground(new java.awt.Color(255, 255, 255));
        painelConsulta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 5, true));

        boPesqFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/boPesqFuncionnarios.jpg"))); // NOI18N
        boPesqFuncionario.setBorder(null);

        boPesqAluno.setBackground(new java.awt.Color(255, 255, 255));
        boPesqAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/boPesqAluno.jpg"))); // NOI18N
        boPesqAluno.setBorder(null);

        laConsulta.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        laConsulta.setForeground(new java.awt.Color(0, 153, 0));
        laConsulta.setText("Consulta");

        javax.swing.GroupLayout painelConsultaLayout = new javax.swing.GroupLayout(painelConsulta);
        painelConsulta.setLayout(painelConsultaLayout);
        painelConsultaLayout.setHorizontalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(boPesqAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(boPesqFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConsultaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(laConsulta)
                .addGap(72, 72, 72))
        );
        painelConsultaLayout.setVerticalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boPesqAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boPesqFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(laConsulta)
                .addContainerGap())
        );

        painelCadastro.setBackground(new java.awt.Color(255, 255, 255));
        painelCadastro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 5, true));

        boFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/boFuncionario.jpg"))); // NOI18N
        boFuncionario.setBorder(null);
        boFuncionario.setMaximumSize(new java.awt.Dimension(93, 81));
        boFuncionario.setMinimumSize(new java.awt.Dimension(93, 81));
        boFuncionario.setPreferredSize(new java.awt.Dimension(93, 81));

        boAluno.setBackground(new java.awt.Color(255, 255, 255));
        boAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/boAluno.jpg"))); // NOI18N
        boAluno.setBorder(null);
        boAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boAlunoActionPerformed(evt);
            }
        });

        laCadastro.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        laCadastro.setForeground(new java.awt.Color(0, 153, 0));
        laCadastro.setText("Cadastro");

        javax.swing.GroupLayout painelCadastroLayout = new javax.swing.GroupLayout(painelCadastro);
        painelCadastro.setLayout(painelCadastroLayout);
        painelCadastroLayout.setHorizontalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(boFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(laCadastro)
                .addGap(72, 72, 72))
        );
        painelCadastroLayout.setVerticalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(laCadastro)
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logoEC.jpg"))); // NOI18N

        javax.swing.GroupLayout painelCentralLayout = new javax.swing.GroupLayout(painelCentral);
        painelCentral.setLayout(painelCentralLayout);
        painelCentralLayout.setHorizontalGroup(
            painelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCentralLayout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addGroup(painelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCentralLayout.createSequentialGroup()
                        .addComponent(painelConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCentralLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())))
            .addGroup(painelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCentralLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(painelCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(418, Short.MAX_VALUE)))
        );
        painelCentralLayout.setVerticalGroup(
            painelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCentralLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(painelConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(painelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCentralLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(painelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(418, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(painelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelBarra.setBackground(new java.awt.Color(51, 102, 0));

        laHora.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 12)); // NOI18N
        laHora.setForeground(new java.awt.Color(255, 255, 255));
        laHora.setText("Hora");

        laData.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 12)); // NOI18N
        laData.setForeground(new java.awt.Color(255, 255, 255));
        laData.setText("Data");

        javax.swing.GroupLayout painelBarraLayout = new javax.swing.GroupLayout(painelBarra);
        painelBarra.setLayout(painelBarraLayout);
        painelBarraLayout.setHorizontalGroup(
            painelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBarraLayout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(laHora, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(laData, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelBarraLayout.setVerticalGroup(
            painelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBarraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laHora)
                    .addComponent(laData))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        barraMenu.setBackground(new java.awt.Color(51, 102, 0));

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Cadastro");
        jMenu1.add(jSeparator1);

        meCadastroAutor.setText("Cadastrar Autor");
        meCadastroAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/002.png"))); // NOI18N
        meCadastroAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meCadastroAutorActionPerformed(evt);
            }
        });
        jMenu1.add(meCadastroAutor);

        meConsultarAutor.setText("Consultar Autor");
        meConsultarAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/search.png"))); // NOI18N
        meConsultarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meConsultarAutorActionPerformed(evt);
            }
        });
        jMenu1.add(meConsultarAutor);

        meAlteraAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/settings.png"))); // NOI18N
        meAlteraAutor.setText("Alterar Autor");
        meAlteraAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meAlteraAutorActionPerformed(evt);
            }
        });
        jMenu1.add(meAlteraAutor);

        barraMenu.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(255, 255, 255));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Consulta");

        meCadastroLivro.setText("Cadastrar Livro");
        meCadastroLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/vallet.png"))); // NOI18N
        meCadastroLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meCadastroLivroActionPerformed(evt);
            }
        });
        jMenu2.add(meCadastroLivro);

        meAlteraLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/settings.png"))); // NOI18N
        meAlteraLivro.setText("Alterar Livro");
        meAlteraLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meAlteraLivroActionPerformed(evt);
            }
        });
        jMenu2.add(meAlteraLivro);

        meConsultarLivro.setText("Consultar Livro");
        meConsultarLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/search.png"))); // NOI18N
        meConsultarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meConsultarLivroActionPerformed(evt);
            }
        });
        jMenu2.add(meConsultarLivro);

        barraMenu.add(jMenu2);

        mnUsuario.setBackground(new java.awt.Color(255, 255, 255));
        mnUsuario.setForeground(new java.awt.Color(255, 255, 255));
        mnUsuario.setText("Sistema");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user.png"))); // NOI18N
        jMenuItem1.setText("Cadastrar Usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnUsuario.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/settings.png"))); // NOI18N
        jMenuItem2.setText("Alterar Usuario");
        mnUsuario.add(jMenuItem2);

        barraMenu.add(mnUsuario);

        meExit.setBackground(new java.awt.Color(255, 255, 255));
        meExit.setForeground(new java.awt.Color(255, 255, 255));
        meExit.setText("Sair");
        meExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                meExitExit(evt);
            }
        });
        barraMenu.add(meExit);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void boAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boAlunoActionPerformed

        new CadastroAluno2().setVisible(true);
    }//GEN-LAST:event_boAlunoActionPerformed

    private void timer_horaOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer_horaOnTime
        Date le_hora = new Date();
        laHora.setText(" Hora.: " + horaformatada.format(le_hora));

    }//GEN-LAST:event_timer_horaOnTime

    private void meCadastroLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meCadastroLivroActionPerformed

        dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_meCadastroLivroActionPerformed

    private void meConsultarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meConsultarLivroActionPerformed

        dispose();
    }//GEN-LAST:event_meConsultarLivroActionPerformed

    private void meAlteraLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meAlteraLivroActionPerformed

        dispose();
    }//GEN-LAST:event_meAlteraLivroActionPerformed

    private void meCadastroAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meCadastroAutorActionPerformed

        dispose();
    }//GEN-LAST:event_meCadastroAutorActionPerformed

    private void meConsultarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meConsultarAutorActionPerformed

        dispose();
    }//GEN-LAST:event_meConsultarAutorActionPerformed

    private void meAlteraAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meAlteraAutorActionPerformed

        dispose();
    }//GEN-LAST:event_meAlteraAutorActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void meExitExit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meExitExit
        System.exit(0);
    }//GEN-LAST:event_meExitExit

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton boAluno;
    private javax.swing.JButton boFuncionario;
    private javax.swing.JButton boPesqAluno;
    private javax.swing.JButton boPesqFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel laCadastro;
    private javax.swing.JLabel laConsulta;
    private javax.swing.JLabel laData;
    private javax.swing.JLabel laHora;
    private javax.swing.JMenuItem meAlteraAutor;
    private javax.swing.JMenuItem meAlteraLivro;
    private javax.swing.JRadioButtonMenuItem meCadastroAutor;
    private javax.swing.JRadioButtonMenuItem meCadastroLivro;
    private javax.swing.JRadioButtonMenuItem meConsultarAutor;
    private javax.swing.JRadioButtonMenuItem meConsultarLivro;
    private javax.swing.JMenu meExit;
    private javax.swing.JMenu mnUsuario;
    private javax.swing.JPanel painelBarra;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelCentral;
    private javax.swing.JPanel painelConsulta;
    private javax.swing.JPanel painelPrincipal;
    private org.netbeans.examples.lib.timerbean.Timer timer_hora;
    // End of variables declaration//GEN-END:variables
}