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
        jPanel13 = new javax.swing.JPanel();
        txCep = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        txTelRes = new javax.swing.JTextField();
        txNome = new javax.swing.JTextField();
        txTelCom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txEndereco = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txIdentidade = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txCPF = new javax.swing.JTextField();
        txCel = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txDataNascimento = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        sexo_masc = new javax.swing.JRadioButton();
        sexo_fem = new javax.swing.JRadioButton();
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

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        txCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCepActionPerformed(evt);
            }
        });

        jLabel7.setText("CEP");

        jLabel3.setText("Bairro");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Estado");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Cidade");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(74, 74, 74)))
                    .addComponent(txCep, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(11, 11, 11)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        txNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomeActionPerformed(evt);
            }
        });

        jLabel2.setText("Endereço");

        jLabel18.setText("Identidade");

        jLabel16.setText("Fone Com.:");

        jLabel1.setText("Nome");

        jLabel15.setText("Fone Res.:");

        jLabel19.setText("CPF");

        jLabel17.setText("Fone Cel.:");

        jLabel8.setText("Email");

        jLabel6.setText("Data Nascimento");

        txDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDataNascimentoActionPerformed(evt);
            }
        });

        jLabel12.setText(" Estado Civil");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(txEndereco)
                        .addComponent(jLabel17)
                        .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel18)
                                .addComponent(txIdentidade, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(txDataNascimento))
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(jLabel19))
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(txCPF)))))
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(txTelCom, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel16))))
                        .addComponent(txCel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txEmail)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txIdentidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(26, 26, 26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTelCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setText("sexo");

        sexo_masc.setBackground(new java.awt.Color(255, 255, 255));
        sexo_masc.setSelected(true);
        sexo_masc.setText("Masculino");
        sexo_masc.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        sexo_masc.setMargin(new java.awt.Insets(0, 0, 0, 0));
        sexo_masc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexo_mascActionPerformed(evt);
            }
        });

        sexo_fem.setBackground(new java.awt.Color(255, 255, 255));
        sexo_fem.setText("Feminino");
        sexo_fem.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        sexo_fem.setMargin(new java.awt.Insets(0, 0, 0, 0));
        sexo_fem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexo_femActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(sexo_masc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sexo_fem)))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexo_fem)
                    .addComponent(sexo_masc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paDadosLayout = new javax.swing.GroupLayout(paDados);
        paDados.setLayout(paDadosLayout);
        paDadosLayout.setHorizontalGroup(
            paDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paDadosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );
        paDadosLayout.setVerticalGroup(
            paDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paDadosLayout.createSequentialGroup()
                .addGroup(paDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paDadosLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paDadosLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(177, Short.MAX_VALUE))
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

    private void txCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCepActionPerformed

    private void txNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomeActionPerformed

    private void txDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDataNascimentoActionPerformed

    private void sexo_mascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexo_mascActionPerformed
        String sexo = "M";
    }//GEN-LAST:event_sexo_mascActionPerformed

    private void sexo_femActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexo_femActionPerformed
        String sexo = "F";
    }//GEN-LAST:event_sexo_femActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
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
    private javax.swing.JRadioButton sexo_fem;
    private javax.swing.JRadioButton sexo_masc;
    private javax.swing.JTextField txCPF;
    private javax.swing.JTextField txCalAvaliacao;
    private javax.swing.JTextField txCalExame;
    private javax.swing.JTextField txCel;
    private javax.swing.JFormattedTextField txCep;
    private javax.swing.JFormattedTextField txDataNascimento;
    private javax.swing.JTextField txDebito1;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txEndereco;
    private javax.swing.JTextField txIdentidade;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txPai;
    private javax.swing.JTextField txTelCom;
    private javax.swing.JTextField txTelRes;
    // End of variables declaration//GEN-END:variables
}
