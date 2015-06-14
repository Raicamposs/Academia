/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.alunos;

import gerenciador.conexaoBD.EnderecoDao;
import gerenciador.conexaoBD.AlunoDao;
import gerenciador.endereco.BairroGUI;
import gerenciador.responsavel.CadastroResponsavelGUI;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raiane
 */
public class CadastroAlunoGUI extends javax.swing.JFrame {

    private EnderecoDao conEndereco;
    private AlunoDao conAluno;
    Aluno aluno;
    Iterator iteratorEstado;
    private char sexo;

    public CadastroAlunoGUI() {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);
        initComponents();
        gerenciador.telas.ultilidades.FuncoesJanelas.setIncone(this);
        edtNome.grabFocus();
        conAluno = new AlunoDao();
        conEndereco = new EnderecoDao();
        pnlResponsavel.setVisible(false);
        pnlDadosResponsavel.setVisible(false);

    }

    private void setCbmAula() {
        try {
            cmbPacote1.removeAllItems();
            cmbPacote2.removeAllItems();
            Iterator iteratorAula = conAluno.getArrayAula().iterator();
            while (iteratorAula.hasNext()) {
                String aula = String.valueOf(iteratorAula.next());
                cmbPacote1.addItem(aula);
                cmbPacote2.addItem(aula);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setCbmCidade() {
        cmbCidade.removeAllItems();
        Iterator iteratorCidade = null;
        try {
            iteratorCidade = conEndereco.getCidades((String) cmbEstado.getSelectedItem()).iterator();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (iteratorCidade.hasNext()) {
            cmbCidade.addItem(String.valueOf(iteratorCidade.next()));
        }

    }

    private void setCbmEstado() {
        cmbEstado.removeAllItems();
        try {
            iteratorEstado = conEndereco.getEstados().iterator();
        } catch (SQLException ex) {
            Logger.getLogger(BairroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (iteratorEstado.hasNext()) {
            cmbEstado.addItem(String.valueOf(iteratorEstado.next()));
        }
        cmbEstado.setSelectedIndex(6);
    }

    private void setCbmEstadoCivil() {
        try {
            cmbEstadoCivil.removeAllItems();
            Iterator iteratorEstadoCivil = conAluno.getArrayEstadoCivil().iterator();
            while (iteratorEstadoCivil.hasNext()) {
                cmbEstadoCivil.addItem(iteratorEstadoCivil.next());
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbdGrupoSexo = new javax.swing.ButtonGroup();
        lblCadastra = new javax.swing.JLabel();
        lblVoltar = new javax.swing.JLabel();
        lblNovo = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JTabbedPane();
        pnlDados = new javax.swing.JPanel();
        pnlEndereco = new javax.swing.JPanel();
        edtCep = new javax.swing.JFormattedTextField();
        lblCep = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        cmbBairro = new javax.swing.JComboBox();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        cmbCidade = new javax.swing.JComboBox();
        lblCidade = new javax.swing.JLabel();
        pnlInformacoes = new javax.swing.JPanel();
        edtTelRes = new javax.swing.JTextField();
        edtNome = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        edtEndereco = new javax.swing.JTextField();
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
        lblDataNascimento = new javax.swing.JLabel();
        edtDataNascimento = new javax.swing.JFormattedTextField();
        lblEstadoCivil = new javax.swing.JLabel();
        cmbEstadoCivil = new javax.swing.JComboBox();
        pnlSexo = new javax.swing.JPanel();
        lblSexo = new javax.swing.JLabel();
        rdbSexoMasc = new javax.swing.JRadioButton();
        rdbSexoFem = new javax.swing.JRadioButton();
        pnlInfAdicionais = new javax.swing.JPanel();
        pnlInformacoesAulas = new javax.swing.JPanel();
        lblExame = new javax.swing.JLabel();
        txCalExame = new javax.swing.JTextField();
        txCalAvaliacao = new javax.swing.JTextField();
        laAvaliacao = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        edtObs = new javax.swing.JTextArea();
        laObs1 = new javax.swing.JLabel();
        laSituacao1 = new javax.swing.JLabel();
        cmbPacote1 = new javax.swing.JComboBox();
        laDebito1 = new javax.swing.JLabel();
        txDebito1 = new javax.swing.JTextField();
        chbMenorIdade = new javax.swing.JCheckBox();
        laSituacao2 = new javax.swing.JLabel();
        cmbPacote2 = new javax.swing.JComboBox();
        pnlResponsavel = new javax.swing.JPanel();
        lblResponsavel = new javax.swing.JLabel();
        edResponsavel = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        pnlDadosResponsavel = new javax.swing.JPanel();
        lblNomeResponsavel = new javax.swing.JLabel();
        lblSetNomeResponsavel = new javax.swing.JLabel();
        lblCefResponsavel = new javax.swing.JLabel();
        lblSetCefResponsavel = new javax.swing.JLabel();
        lblTelefoneResponsavel = new javax.swing.JLabel();
        lblSetTelResponsavel1 = new javax.swing.JLabel();
        lblSetTelResponsavel2 = new javax.swing.JLabel();
        lblMatriculadoResponsavel = new javax.swing.JLabel();
        lblSetMatriculadoResponsavel = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lblCadastra, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 660, 120, 42));

        lblVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVoltarMouseClicked(evt);
            }
        });
        getContentPane().add(lblVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 658, 120, 42));
        getContentPane().add(lblNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 652, 120, 50));

        pnlPrincipal.setBackground(new java.awt.Color(153, 255, 153));

        pnlDados.setBackground(new java.awt.Color(255, 255, 255));
        pnlDados.setPreferredSize(new java.awt.Dimension(800, 600));
        pnlDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlEndereco.setBackground(new java.awt.Color(255, 255, 255));

        edtCep.setSelectionColor(new java.awt.Color(0, 153, 0));

        lblCep.setText("CEP");

        lblBairro.setText("Bairro");

        cmbBairro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblEstado.setText("Estado");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCidade.setText("Cidade");

        javax.swing.GroupLayout pnlEnderecoLayout = new javax.swing.GroupLayout(pnlEndereco);
        pnlEndereco.setLayout(pnlEnderecoLayout);
        pnlEnderecoLayout.setHorizontalGroup(
            pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCep)
                    .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbBairro, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlEnderecoLayout.createSequentialGroup()
                            .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEstado)
                                .addComponent(lblCidade)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(74, 74, 74)))
                    .addComponent(edtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEnderecoLayout.setVerticalGroup(
            pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEnderecoLayout.createSequentialGroup()
                .addComponent(lblEstado)
                .addGap(11, 11, 11)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBairro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pnlDados.add(pnlEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 230, 270));

        pnlInformacoes.setBackground(new java.awt.Color(255, 255, 255));

        edtTelRes.setSelectionColor(new java.awt.Color(0, 153, 0));

        edtNome.setSelectionColor(new java.awt.Color(0, 153, 0));

        lblEndereco.setText("Endereço");

        edtEndereco.setSelectionColor(new java.awt.Color(0, 153, 0));

        lblIdentidade.setText("Identidade");

        edtIdentidade.setSelectionColor(new java.awt.Color(0, 153, 0));

        lblNome.setText("Nome");

        lblTelResidencial.setText("Fone Res.:");

        lblCPF.setText("CPF");

        edtCPF.setSelectionColor(new java.awt.Color(0, 153, 0));

        edtCel.setSelectionColor(new java.awt.Color(0, 153, 0));

        lblTelCelular.setText("Fone Cel.:");

        edtEmail.setSelectionColor(new java.awt.Color(0, 153, 0));

        lblEmail.setText("Email");

        lblDataNascimento.setText("Data Nascimento");

        edtDataNascimento.setSelectionColor(new java.awt.Color(0, 153, 0));

        lblEstadoCivil.setText(" Estado Civil");

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlInformacoesLayout = new javax.swing.GroupLayout(pnlInformacoes);
        pnlInformacoes.setLayout(pnlInformacoesLayout);
        pnlInformacoesLayout.setHorizontalGroup(
            pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtEndereco)
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIdentidade)
                            .addComponent(edtIdentidade, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(edtDataNascimento))
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblCPF)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                        .addComponent(lblEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(edtCPF)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelResidencial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTelCelular)
                            .addComponent(edtCel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(edtEmail)
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataNascimento)
                            .addComponent(lblEmail)
                            .addComponent(lblEndereco)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlInformacoesLayout.setVerticalGroup(
            pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblIdentidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtIdentidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                .addComponent(lblCPF)
                                .addGap(26, 26, 26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDataNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addComponent(lblEstadoCivil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createSequentialGroup()
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTelResidencial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createSequentialGroup()
                        .addComponent(lblTelCelular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );

        pnlDados.add(pnlInformacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 45, -1, -1));

        pnlSexo.setBackground(new java.awt.Color(255, 255, 255));

        lblSexo.setText("Sexo");

        rdbSexoMasc.setBackground(new java.awt.Color(255, 255, 255));
        rbdGrupoSexo.add(rdbSexoMasc);
        rdbSexoMasc.setSelected(true);
        rdbSexoMasc.setText("Masculino");
        rdbSexoMasc.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdbSexoMasc.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rdbSexoMasc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbSexoMascMouseClicked(evt);
            }
        });

        rdbSexoFem.setBackground(new java.awt.Color(255, 255, 255));
        rbdGrupoSexo.add(rdbSexoFem);
        rdbSexoFem.setText("Feminino");
        rdbSexoFem.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdbSexoFem.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rdbSexoFem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbSexoFemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlSexoLayout = new javax.swing.GroupLayout(pnlSexo);
        pnlSexo.setLayout(pnlSexoLayout);
        pnlSexoLayout.setHorizontalGroup(
            pnlSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSexoLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(pnlSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSexo)
                    .addGroup(pnlSexoLayout.createSequentialGroup()
                        .addComponent(rdbSexoMasc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbSexoFem)))
                .addGap(18, 18, 18))
        );
        pnlSexoLayout.setVerticalGroup(
            pnlSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSexoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblSexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbSexoFem)
                    .addComponent(rdbSexoMasc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDados.add(pnlSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, 52));

        pnlPrincipal.addTab("Dados Cadastrais", pnlDados);

        pnlInfAdicionais.setBackground(new java.awt.Color(255, 255, 255));
        pnlInfAdicionais.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlInformacoesAulas.setBackground(new java.awt.Color(255, 255, 255));

        lblExame.setText("Validade do Exame Medico");

        txCalExame.setSelectionColor(new java.awt.Color(0, 153, 0));

        txCalAvaliacao.setSelectionColor(new java.awt.Color(0, 153, 0));

        laAvaliacao.setText("Validade da Avaliação Fisica");

        edtObs.setColumns(20);
        edtObs.setRows(5);
        edtObs.setSelectionColor(new java.awt.Color(0, 153, 0));
        jScrollPane3.setViewportView(edtObs);

        laObs1.setText("Observações");

        laSituacao1.setText("1 - Pacote Contratado:");

        cmbPacote1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        laDebito1.setText("Data Vencimento:");

        txDebito1.setSelectionColor(new java.awt.Color(0, 153, 0));

        chbMenorIdade.setBackground(new java.awt.Color(255, 255, 255));
        chbMenorIdade.setText("  Menor de Idade");
        chbMenorIdade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chbMenorIdadeMouseClicked(evt);
            }
        });

        laSituacao2.setText("2 - Pacote Contratado:");

        cmbPacote2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlInformacoesAulasLayout = new javax.swing.GroupLayout(pnlInformacoesAulas);
        pnlInformacoesAulas.setLayout(pnlInformacoesAulasLayout);
        pnlInformacoesAulasLayout.setHorizontalGroup(
            pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(laSituacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txCalExame, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblExame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cmbPacote1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(laAvaliacao)
                                    .addComponent(txCalAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(laDebito1)
                                    .addComponent(txDebito1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(laSituacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPacote2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(laObs1)
                    .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chbMenorIdade)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnlInformacoesAulasLayout.setVerticalGroup(
            pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExame)
                    .addComponent(laAvaliacao)
                    .addComponent(laDebito1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCalExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCalAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDebito1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                        .addComponent(laSituacao1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPacote1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesAulasLayout.createSequentialGroup()
                        .addComponent(laSituacao2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPacote2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(laObs1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbMenorIdade)))
        );

        pnlInfAdicionais.add(pnlInformacoesAulas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        pnlResponsavel.setBackground(new java.awt.Color(255, 255, 255));

        lblResponsavel.setText("Nome Responsavel:");

        edResponsavel.setSelectionColor(new java.awt.Color(0, 153, 0));

        btnPesquisar.setBackground(new java.awt.Color(0, 102, 0));
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisarMouseClicked(evt);
            }
        });

        btnCadastrar.setBackground(new java.awt.Color(0, 102, 0));
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlResponsavelLayout = new javax.swing.GroupLayout(pnlResponsavel);
        pnlResponsavel.setLayout(pnlResponsavelLayout);
        pnlResponsavelLayout.setHorizontalGroup(
            pnlResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResponsavelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResponsavelLayout.createSequentialGroup()
                        .addComponent(lblResponsavel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlResponsavelLayout.createSequentialGroup()
                        .addGroup(pnlResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlResponsavelLayout.createSequentialGroup()
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 21, Short.MAX_VALUE))))
        );

        pnlResponsavelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastrar, btnPesquisar});

        pnlResponsavelLayout.setVerticalGroup(
            pnlResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResponsavelLayout.createSequentialGroup()
                .addComponent(lblResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(edResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnPesquisar))
                .addGap(22, 22, 22))
        );

        pnlInfAdicionais.add(pnlResponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        pnlDadosResponsavel.setBackground(new java.awt.Color(255, 255, 255));

        lblNomeResponsavel.setText("Nome:");

        lblSetNomeResponsavel.setText("...");

        lblCefResponsavel.setText("CPF");

        lblSetCefResponsavel.setText("...");

        lblTelefoneResponsavel.setText("Telefone");

        lblSetTelResponsavel1.setText("...");

        lblSetTelResponsavel2.setText("...");

        lblMatriculadoResponsavel.setText("Matriculado");

        lblSetMatriculadoResponsavel.setText("...");

        javax.swing.GroupLayout pnlDadosResponsavelLayout = new javax.swing.GroupLayout(pnlDadosResponsavel);
        pnlDadosResponsavel.setLayout(pnlDadosResponsavelLayout);
        pnlDadosResponsavelLayout.setHorizontalGroup(
            pnlDadosResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosResponsavelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosResponsavelLayout.createSequentialGroup()
                        .addComponent(lblSetTelResponsavel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSetTelResponsavel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDadosResponsavelLayout.createSequentialGroup()
                        .addGroup(pnlDadosResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSetNomeResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCefResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSetCefResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefoneResponsavel)
                            .addComponent(lblMatriculadoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSetMatriculadoResponsavel))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDadosResponsavelLayout.setVerticalGroup(
            pnlDadosResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosResponsavelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeResponsavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSetNomeResponsavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCefResponsavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSetCefResponsavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefoneResponsavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSetTelResponsavel1)
                    .addComponent(lblSetTelResponsavel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMatriculadoResponsavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSetMatriculadoResponsavel)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pnlInfAdicionais.add(pnlDadosResponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, -1, -1));

        pnlPrincipal.addTab("Informações Adicionais", pnlInfAdicionais);

        getContentPane().add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 830, 600));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Fundo/BackgroudCadastro.jpg"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblVoltarMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setCbmAula();
        setCbmEstadoCivil();
        setCbmEstado();
    }//GEN-LAST:event_formWindowActivated

    private void btnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseClicked
        pnlDadosResponsavel.setVisible(true);
    }//GEN-LAST:event_btnPesquisarMouseClicked

    private void rdbSexoMascMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbSexoMascMouseClicked
        sexo = ('M');

    }//GEN-LAST:event_rdbSexoMascMouseClicked

    private void rdbSexoFemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbSexoFemMouseClicked
        sexo = ('F');

    }//GEN-LAST:event_rdbSexoFemMouseClicked

    private void chbMenorIdadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbMenorIdadeMouseClicked
       if(chbMenorIdade.isSelected() == true){
           pnlResponsavel.setVisible(true);
       }else{
        pnlResponsavel.setVisible(false);
        pnlDadosResponsavel.setVisible(false);
       }
    }//GEN-LAST:event_chbMenorIdadeMouseClicked

    private void btnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseClicked
        new CadastroResponsavelGUI().setVisible(true);
    }//GEN-LAST:event_btnCadastrarMouseClicked

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
            java.util.logging.Logger.getLogger(CadastroAlunoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAlunoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAlunoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAlunoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAlunoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JCheckBox chbMenorIdade;
    private javax.swing.JComboBox cmbBairro;
    private javax.swing.JComboBox cmbCidade;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbEstadoCivil;
    private javax.swing.JComboBox cmbPacote1;
    private javax.swing.JComboBox cmbPacote2;
    private javax.swing.JTextField edResponsavel;
    private javax.swing.JTextField edtCPF;
    private javax.swing.JTextField edtCel;
    private javax.swing.JFormattedTextField edtCep;
    private javax.swing.JFormattedTextField edtDataNascimento;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtEndereco;
    private javax.swing.JTextField edtIdentidade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextArea edtObs;
    private javax.swing.JTextField edtTelRes;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel laAvaliacao;
    private javax.swing.JLabel laDebito1;
    private javax.swing.JLabel laObs1;
    private javax.swing.JLabel laSituacao1;
    private javax.swing.JLabel laSituacao2;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCadastra;
    private javax.swing.JLabel lblCefResponsavel;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblExame;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblIdentidade;
    private javax.swing.JLabel lblMatriculadoResponsavel;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeResponsavel;
    private javax.swing.JLabel lblNovo;
    private javax.swing.JLabel lblResponsavel;
    private javax.swing.JLabel lblSetCefResponsavel;
    private javax.swing.JLabel lblSetMatriculadoResponsavel;
    private javax.swing.JLabel lblSetNomeResponsavel;
    private javax.swing.JLabel lblSetTelResponsavel1;
    private javax.swing.JLabel lblSetTelResponsavel2;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelCelular;
    private javax.swing.JLabel lblTelResidencial;
    private javax.swing.JLabel lblTelefoneResponsavel;
    private javax.swing.JLabel lblVoltar;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JPanel pnlDadosResponsavel;
    private javax.swing.JPanel pnlEndereco;
    private javax.swing.JPanel pnlInfAdicionais;
    private javax.swing.JPanel pnlInformacoes;
    private javax.swing.JPanel pnlInformacoesAulas;
    private javax.swing.JTabbedPane pnlPrincipal;
    private javax.swing.JPanel pnlResponsavel;
    private javax.swing.JPanel pnlSexo;
    private javax.swing.ButtonGroup rbdGrupoSexo;
    private javax.swing.JRadioButton rdbSexoFem;
    private javax.swing.JRadioButton rdbSexoMasc;
    private javax.swing.JTextField txCalAvaliacao;
    private javax.swing.JTextField txCalExame;
    private javax.swing.JTextField txDebito1;
    // End of variables declaration//GEN-END:variables
}
