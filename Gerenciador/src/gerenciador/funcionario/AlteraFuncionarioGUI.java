/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.funcionario;

/**
 *
 * @author Raiane
 */
public class AlteraFuncionarioGUI extends javax.swing.JFrame {

    /**
     * Creates new form AlteraFuncionario
     */
    public AlteraFuncionarioGUI() {
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        paInfAdicionais = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        laExame = new javax.swing.JLabel();
        txCalExame = new javax.swing.JTextField();
        txCalAvaliacao = new javax.swing.JTextField();
        laAvaliacao = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        atxObs1 = new javax.swing.JTextArea();
        laObs1 = new javax.swing.JLabel();
        laSituacao1 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        laDebito1 = new javax.swing.JLabel();
        txDebito1 = new javax.swing.JTextField();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txPai = new javax.swing.JTextField();
        laPai = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        paDados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        getContentPane().add(lblMinimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 40, 15, 15));
        getContentPane().add(lblBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 90, 70, 60));

        edtNome.setBorder(null);
        edtNome.setSelectionColor(new java.awt.Color(0, 153, 0));
        getContentPane().add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 90, 140, 20));

        edtMatricula.setBorder(null);
        edtMatricula.setSelectionColor(new java.awt.Color(0, 153, 0));
        getContentPane().add(edtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 115, 85, 23));

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
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 40, 15, 15));

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 153));

        paInfAdicionais.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        laExame.setText("Validade do Exame Medico");

        laAvaliacao.setText("Validade da Avaliação Fisica");

        atxObs1.setColumns(20);
        atxObs1.setRows(5);
        jScrollPane3.setViewportView(atxObs1);

        laObs1.setText("Observações");

        laSituacao1.setText("Pacote Contratado:");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        laDebito1.setText("Data Vencimento:");

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("  Menor de Idade");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(laExame)
                    .addComponent(txCalExame, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txDebito1)
                            .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(laDebito1)
                            .addComponent(laSituacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox3)))
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txCalAvaliacao)
                    .addComponent(laAvaliacao)
                    .addComponent(laObs1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laExame)
                    .addComponent(laAvaliacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCalExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCalAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(laObs1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(laSituacao1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(laDebito1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txDebito1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3))))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        laPai.setText("Nome Responsavel:");

        jButton1.setText("Pesquisar");

        jButton2.setText("Cadastrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(laPai)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txPai, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(laPai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout paInfAdicionaisLayout = new javax.swing.GroupLayout(paInfAdicionais);
        paInfAdicionais.setLayout(paInfAdicionaisLayout);
        paInfAdicionaisLayout.setHorizontalGroup(
            paInfAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paInfAdicionaisLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(paInfAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paInfAdicionaisLayout.setVerticalGroup(
            paInfAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paInfAdicionaisLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(paInfAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paInfAdicionaisLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paInfAdicionaisLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Informações Adicionais", paInfAdicionais);

        paDados.setBackground(new java.awt.Color(255, 255, 255));
        paDados.setPreferredSize(new java.awt.Dimension(800, 600));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout paDadosLayout = new javax.swing.GroupLayout(paDados);
        paDados.setLayout(paDadosLayout);
        paDadosLayout.setHorizontalGroup(
            paDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        paDadosLayout.setVerticalGroup(
            paDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paDadosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 155, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Cadastrais", paDados);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 840, 610));

        lblPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Pequenas/tela pesquisa.png"))); // NOI18N
        getContentPane().add(lblPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 350, 160));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Fundo/BackgroudAltera.jpg"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblInicioMouseClicked

    private void lblAnteriorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnteriorMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblAnterior);
    }//GEN-LAST:event_lblAnteriorMouseEntered

    private void lblAnteriorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnteriorMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblAnterior);
    }//GEN-LAST:event_lblAnteriorMouseExited

    private void lblEditaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditaMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblEdita);
    }//GEN-LAST:event_lblEditaMouseEntered

    private void lblInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblInicio);
    }//GEN-LAST:event_lblInicioMouseEntered

    private void lblConfirmaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfirmaMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblConfirma);
    }//GEN-LAST:event_lblConfirmaMouseEntered

    private void lblProximoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProximoMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblProximo);
    }//GEN-LAST:event_lblProximoMouseEntered

    private void lblEditaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditaMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblEdita);
    }//GEN-LAST:event_lblEditaMouseExited

    private void lblInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblInicio);
    }//GEN-LAST:event_lblInicioMouseExited

    private void lblConfirmaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfirmaMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblConfirma);
    }//GEN-LAST:event_lblConfirmaMouseExited

    private void lblProximoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProximoMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblProximo);
    }//GEN-LAST:event_lblProximoMouseExited

    private void lblFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFechaMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblFechaMouseClicked

    private void lblMinimizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizaMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblMinimizaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

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
            java.util.logging.Logger.getLogger(AlteraFuncionarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlteraFuncionarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlteraFuncionarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlteraFuncionarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlteraFuncionarioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea atxObs1;
    private javax.swing.JTextField edtMatricula;
    private javax.swing.JTextField edtNome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel laAvaliacao;
    private javax.swing.JLabel laDebito1;
    private javax.swing.JLabel laExame;
    private javax.swing.JLabel laObs1;
    private javax.swing.JLabel laPai;
    private javax.swing.JLabel laSituacao1;
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
    private javax.swing.JPanel paDados;
    private javax.swing.JPanel paInfAdicionais;
    private javax.swing.JTextField txCalAvaliacao;
    private javax.swing.JTextField txCalExame;
    private javax.swing.JTextField txDebito1;
    private javax.swing.JTextField txPai;
    // End of variables declaration//GEN-END:variables
}
