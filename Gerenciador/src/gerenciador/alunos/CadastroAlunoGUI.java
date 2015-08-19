/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.alunos;

import gerenciador.conexaoBD.EnderecoDao;
import gerenciador.conexaoBD.AlunoDao;
import gerenciador.conexaoBD.AulaDao;
import gerenciador.conexaoBD.ResponsavelDao;
import gerenciador.endereco.BairroGUI;
import gerenciador.endereco.CidadeGUI;
import gerenciador.responsavel.CadastroResponsavelGUI;
import gerenciador.responsavel.Responsavel;
import gerenciador.telas.ultilidades.Data;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Raiane
 */
public class CadastroAlunoGUI extends javax.swing.JFrame {

    private EnderecoDao conEndereco;
    private AlunoDao conAluno;
    private ResponsavelDao conResponsavel;
    private Aluno aluno;
    private String formatohora = "HH:mm:ss";
    private SimpleDateFormat horaformatada = new SimpleDateFormat(formatohora);
    private Data data = new Data();
    private Responsavel responsavel;
    private Iterator iteratorEstado;
    private AulaDao conAula;
    private char sexo;
    private MaskFormatter formatoCpf, formatoRg, formatoDataVencimento, formatoCep, formatoCel, formatoFone, formatoData;

    public CadastroAlunoGUI() {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);
        initComponents();
        tmrHora.setDelay(1000);
        tmrHora.start();
        lblData.setText(Data.mostraData());
        gerenciador.telas.ultilidades.FuncoesJanelas.setIncone(this);
        edtNome.grabFocus();
        conAluno = new AlunoDao();
        conAula = new AulaDao();
        conEndereco = new EnderecoDao();
        conResponsavel = new ResponsavelDao();
        pnlResponsavel.setVisible(false);
        pnlDadosResponsavel.setVisible(false);
        edtCep.setEditable(false);

    }

    private void cadastra() {
        if (gerenciador.pessoa.ValidaCpf.validador(edtCPF.getText())) {

            aluno = new Aluno(gerenciador.telas.ultilidades.FormataCampo.formataDocumentosBanco(edtCPF.getText()),
                    gerenciador.telas.ultilidades.FormataCampo.formataDocumentosBanco(edtIdentidade.getText()), edtNome.getText(),
                    gerenciador.telas.ultilidades.FormataCampo.formataDataBanco(edtDataNascimento.getText()), edtEmail.getText(), sexo);
            aluno.setFoneCelular(edtCel.getText());
            aluno.setFoneResidencial(edtTelRes.getText());
            aluno.setVencimento(edtDiaVencimento.getText());
            aluno.setObservacao(edtObs.getText());
            aluno.setDataAvaliacao(gerenciador.telas.ultilidades.FormataCampo.formataDataBanco(edtDataAvaliacao.getText()));
            aluno.setDataExame(gerenciador.telas.ultilidades.FormataCampo.formataDataBanco(edtDataExame.getText()));
            aluno.getEndereco().setCEP(Integer.parseInt(edtCep.getText().replace("-", "")));
            aluno.getEndereco().setRua((String) cmbEndereco.getSelectedItem());
            aluno.getEndereco().setComplemento(edtComplemento.getText());
            aluno.getEndereco().setNumero(edtNumero.getText());
            aluno.getEstadoCivil().setDescricao((String) cmbEstadoCivil.getSelectedItem());
            aluno.getEstadoCivil().setId((cmbEstadoCivil.getSelectedIndex() + 1));
            aluno.setDataMatricula(gerenciador.telas.ultilidades.FormataCampo.formataDataBanco(lblData.getText()));
        }

    }

    private void setPanelResponsavel() {
        responsavel = new Responsavel("", "", "", "");
        conResponsavel.consultaNome(edtResponsavel.getText(), responsavel);
        lblSetNomeResponsavel.setText(responsavel.getNome());
        lblSetCpfResponsavel.setText(responsavel.getCpf());
        lblSetRG.setText(responsavel.getRG());
        lblSetTelResponsavel1.setText(responsavel.getFoneCelular());
        lblSetTelResponsavel2.setText(responsavel.getFoneResidencial());
        System.out.println("" + edtResponsavel.getText());
    }

    private void setCbmAula() {
        try {
            cmbPacote1.removeAllItems();
            cmbPacote2.removeAllItems();
            Iterator iteratorAula = conAula.getArrayAula().iterator();
            while (iteratorAula.hasNext()) {
                String aula = String.valueOf(iteratorAula.next());
                cmbPacote1.addItem(aula);
                cmbPacote2.addItem(aula);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setCbmEndereco() throws SQLException {
        cmbEndereco.removeAllItems();
        try {
            Iterator iteratorEndereco = conEndereco.getArrayRua((String) cmbBairro.getSelectedItem()).iterator();
            while (iteratorEndereco.hasNext()) {
                cmbEndereco.addItem(String.valueOf(iteratorEndereco.next()));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BairroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setCbmCidade() throws SQLException {
        cmbCidade.removeAllItems();
        cmbBairro.removeAllItems();
        cmbEndereco.removeAllItems();
        Iterator iteratorCidade = null;
        try {
            iteratorCidade = conEndereco.getArrayCidade((String) cmbEstado.getSelectedItem()).iterator();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (iteratorCidade.hasNext()) {
            cmbCidade.addItem(String.valueOf(iteratorCidade.next()));
        }
        if (conEndereco.getArrayCidade((String) cmbEstado.getSelectedItem()).contains("Guarapari")) {
            cmbCidade.setSelectedItem("Guarapari");
        }
        setCbmBairro();
    }

    private void setCbmBairro() throws SQLException {
        cmbBairro.removeAllItems();
        cmbEndereco.removeAllItems();
        Iterator iteratorBairro;

        try {
            iteratorBairro = conEndereco.getArrayBairro((String) cmbCidade.getSelectedItem()).iterator();
            if (iteratorBairro.hasNext()) {
                while (iteratorBairro.hasNext()) {
                    cmbBairro.addItem(String.valueOf(iteratorBairro.next()));
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, e);
        }
        setCbmEndereco();
    }

    private void setCbmEstado() throws SQLException {

        cmbEstado.removeAllItems();
        cmbCidade.removeAllItems();
        cmbBairro.removeAllItems();
        cmbEndereco.removeAllItems();
        try {
            iteratorEstado = conEndereco.getArrayEstados().iterator();
        } catch (SQLException ex) {
            Logger.getLogger(BairroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (iteratorEstado.hasNext()) {
            cmbEstado.addItem(String.valueOf(iteratorEstado.next()));
        }
        if (conEndereco.getArrayEstados().contains("Espírito Santo")) {
            cmbEstado.setSelectedItem("Espírito Santo");
        }
        setCbmCidade();
    }

    private void atualizaCbmEstado() throws SQLException {
        cmbCidade.removeAllItems();
        cmbBairro.removeAllItems();
        cmbEndereco.removeAllItems();
        setCbmCidade();
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
        tmrHora = new org.netbeans.examples.lib.timerbean.Timer();
        lblCadastra = new javax.swing.JLabel();
        lblVoltar = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblNovo = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JTabbedPane();
        pnlDados = new javax.swing.JPanel();
        pnlInformacoes = new javax.swing.JPanel();
        try
        {
            formatoFone = new MaskFormatter("(0xx##)####-####");
        }
        catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para cpf, "+erro);
        }
        edtTelRes = new JFormattedTextField(formatoFone);
        edtNome = new javax.swing.JTextField();
        lblIdentidade = new javax.swing.JLabel();
        try {      formatoRg = new MaskFormatter("#####.###-#");     } catch(Exception erro) {     JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para RG, "+erro); }
        edtIdentidade = new JFormattedTextField(formatoRg);
        lblNome = new javax.swing.JLabel();
        lblTelResidencial = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        try
        {
            formatoCpf = new MaskFormatter("###.###.###-##");
        }
        catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para cpf, "+erro);
        }
        edtCPF = new JFormattedTextField(formatoCpf);
        try {      formatoCel = new MaskFormatter
            ("(0xx##)#####-####");     } catch(Exception erro) {     JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para cpf, "+erro); }
        edtCel = new JFormattedTextField(formatoCel);
        lblTelCelular = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblDataNascimento = new javax.swing.JLabel();
        try {      formatoData = new MaskFormatter("##/##/####");     } catch(Exception erro) {     JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para data, "+erro); }
        edtDataNascimento = new JFormattedTextField(formatoData);
        lblEstadoCivil = new javax.swing.JLabel();
        cmbEstadoCivil = new javax.swing.JComboBox();
        lblEndereco = new javax.swing.JLabel();
        cmbEndereco = new javax.swing.JComboBox();
        edtComplemento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pnlSexo = new javax.swing.JPanel();
        lblSexo = new javax.swing.JLabel();
        rdbSexoMasc = new javax.swing.JRadioButton();
        rdbSexoFem = new javax.swing.JRadioButton();
        pnlEndereco = new javax.swing.JPanel();
        try {      formatoCep = new MaskFormatter("#####-###");     } catch(Exception erro) {     JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para cpf, "+erro); }
        edtCep = new JFormattedTextField(formatoCep);
        lblCep = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        cmbBairro = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        cmbCidade = new javax.swing.JComboBox();
        lblCidade = new javax.swing.JLabel();
        btnNovaCidade = new javax.swing.JButton();
        btnNovaBairro = new javax.swing.JButton();
        edtNumero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pnlInfAdicionais = new javax.swing.JPanel();
        pnlInformacoesAulas = new javax.swing.JPanel();
        lblExame = new javax.swing.JLabel();
        try {      formatoData = new MaskFormatter("##/##/####");     } catch(Exception erro) {     JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para data, "+erro); }
        edtDataExame = new JFormattedTextField(formatoData);
        try {      formatoData = new MaskFormatter("##/##/####");     } catch(Exception erro) {     JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para data, "+erro); }
        edtDataAvaliacao = new JFormattedTextField(formatoData);
        laAvaliacao = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        edtObs = new javax.swing.JTextArea();
        laObs1 = new javax.swing.JLabel();
        laSituacao1 = new javax.swing.JLabel();
        cmbPacote1 = new javax.swing.JComboBox();
        lblDiaVencimaento = new javax.swing.JLabel();
        try {     formatoDataVencimento = new MaskFormatter("##");    
        } catch(Exception erro) {     JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para data, "+erro); }
        edtDiaVencimento = new JFormattedTextField(formatoDataVencimento);
        chbMenorIdade = new javax.swing.JCheckBox();
        laSituacao2 = new javax.swing.JLabel();
        cmbPacote2 = new javax.swing.JComboBox();
        pnlResponsavel = new javax.swing.JPanel();
        lblResponsavel = new javax.swing.JLabel();
        edtResponsavel = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        pnlDadosResponsavel = new javax.swing.JPanel();
        lblNomeResponsavel = new javax.swing.JLabel();
        lblSetNomeResponsavel = new javax.swing.JLabel();
        lblCpfResponsavel = new javax.swing.JLabel();
        lblSetCpfResponsavel = new javax.swing.JLabel();
        lblTelefoneResponsavel = new javax.swing.JLabel();
        lblSetTelResponsavel1 = new javax.swing.JLabel();
        lblSetTelResponsavel2 = new javax.swing.JLabel();
        lblRG = new javax.swing.JLabel();
        lblSetRG = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        tmrHora.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                tmrHoraOnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCadastra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadastraMouseClicked(evt);
            }
        });
        getContentPane().add(lblCadastra, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 660, 120, 42));

        lblVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVoltarMouseClicked(evt);
            }
        });
        getContentPane().add(lblVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 658, 120, 42));

        lblData.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setText("...");
        getContentPane().add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 736, 320, 20));

        lblHora.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("...");
        getContentPane().add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 736, 140, 20));
        getContentPane().add(lblNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 652, 120, 50));

        pnlPrincipal.setBackground(new java.awt.Color(153, 255, 153));

        pnlDados.setBackground(new java.awt.Color(255, 255, 255));
        pnlDados.setPreferredSize(new java.awt.Dimension(800, 600));
        pnlDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlInformacoes.setBackground(new java.awt.Color(255, 255, 255));

        edtTelRes.setSelectionColor(new java.awt.Color(0, 153, 0));

        edtNome.setSelectionColor(new java.awt.Color(0, 153, 0));

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

        lblEndereco.setText("Endereço");

        cmbEndereco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione ...", "Item 2", "Item 3", "Item 4" }));
        cmbEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbEnderecoFocusGained(evt);
            }
        });
        cmbEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEnderecoActionPerformed(evt);
            }
        });

        jLabel2.setText("Complemento");

        javax.swing.GroupLayout pnlInformacoesLayout = new javax.swing.GroupLayout(pnlInformacoes);
        pnlInformacoes.setLayout(pnlInformacoesLayout);
        pnlInformacoesLayout.setHorizontalGroup(
            pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNome))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEndereco)
                            .addComponent(cmbEndereco, 0, 373, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(edtComplemento, javax.swing.GroupLayout.Alignment.TRAILING))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createSequentialGroup()
                        .addComponent(lblTelResidencial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addComponent(lblTelCelular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEndereco)
                .addGap(6, 6, 6)
                .addComponent(cmbEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        pnlEndereco.setBackground(new java.awt.Color(255, 255, 255));

        edtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCepActionPerformed(evt);
            }
        });

        lblCep.setText("CEP");

        lblBairro.setText("Bairro");

        cmbBairro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        cmbBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBairroActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        cmbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        cmbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCidadeActionPerformed(evt);
            }
        });

        lblCidade.setText("Cidade");

        btnNovaCidade.setBackground(new java.awt.Color(0, 153, 0));
        btnNovaCidade.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaCidade.setText("Novo");
        btnNovaCidade.setActionCommand("");
        btnNovaCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNovaCidadeMouseClicked(evt);
            }
        });

        btnNovaBairro.setBackground(new java.awt.Color(0, 153, 0));
        btnNovaBairro.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaBairro.setText("Novo");
        btnNovaBairro.setActionCommand("");
        btnNovaBairro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNovaBairroMouseClicked(evt);
            }
        });

        edtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNumeroActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero");

        javax.swing.GroupLayout pnlEnderecoLayout = new javax.swing.GroupLayout(pnlEndereco);
        pnlEndereco.setLayout(pnlEnderecoLayout);
        pnlEnderecoLayout.setHorizontalGroup(
            pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEnderecoLayout.createSequentialGroup()
                                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(lblCidade))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEnderecoLayout.createSequentialGroup()
                                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbBairro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEnderecoLayout.createSequentialGroup()
                                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(edtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblCep))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlEnderecoLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 24, Short.MAX_VALUE))
                                            .addComponent(edtNumero))))
                                .addGap(13, 13, 13)))
                        .addComponent(btnNovaBairro))
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbEstado, 0, 200, Short.MAX_VALUE)
                            .addComponent(cmbCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNovaCidade)))
                .addContainerGap())
        );
        pnlEnderecoLayout.setVerticalGroup(
            pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEnderecoLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(11, 11, 11)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovaCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBairro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovaBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCep)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pnlDados.add(pnlEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 290, 240));

        pnlPrincipal.addTab("Dados Cadastrais", pnlDados);

        pnlInfAdicionais.setBackground(new java.awt.Color(255, 255, 255));
        pnlInfAdicionais.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlInformacoesAulas.setBackground(new java.awt.Color(255, 255, 255));

        lblExame.setText("Validade do Exame Medico");

        edtDataExame.setSelectionColor(new java.awt.Color(0, 153, 0));

        edtDataAvaliacao.setSelectionColor(new java.awt.Color(0, 153, 0));

        laAvaliacao.setText("Validade da Avaliação Fisica");

        edtObs.setColumns(20);
        edtObs.setRows(5);
        edtObs.setSelectionColor(new java.awt.Color(0, 153, 0));
        jScrollPane3.setViewportView(edtObs);

        laObs1.setText("Observações");

        laSituacao1.setText("1 - Pacote Contratado:");

        cmbPacote1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblDiaVencimaento.setText("Data Vencimento:");

        edtDiaVencimento.setSelectionColor(new java.awt.Color(0, 153, 0));

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
                                .addComponent(edtDataExame, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblExame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cmbPacote1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(laAvaliacao)
                                    .addComponent(edtDataAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDiaVencimaento)
                                    .addComponent(edtDiaVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(lblDiaVencimaento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtDataExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtDataAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtDiaVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        edtResponsavel.setSelectionColor(new java.awt.Color(0, 153, 0));

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
                            .addComponent(edtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 21, Short.MAX_VALUE))))
        );

        pnlResponsavelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastrar, btnPesquisar});

        pnlResponsavelLayout.setVerticalGroup(
            pnlResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResponsavelLayout.createSequentialGroup()
                .addComponent(lblResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(edtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnPesquisar))
                .addGap(22, 22, 22))
        );

        pnlInfAdicionais.add(pnlResponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        pnlDadosResponsavel.setBackground(new java.awt.Color(255, 255, 255));

        lblNomeResponsavel.setForeground(new java.awt.Color(0, 153, 0));
        lblNomeResponsavel.setText("Nome:");

        lblSetNomeResponsavel.setText("...");

        lblCpfResponsavel.setForeground(new java.awt.Color(0, 153, 0));
        lblCpfResponsavel.setText("CPF");

        lblSetCpfResponsavel.setText("...");

        lblTelefoneResponsavel.setForeground(new java.awt.Color(0, 153, 0));
        lblTelefoneResponsavel.setText("Telefone");

        lblSetTelResponsavel1.setText("...");

        lblSetTelResponsavel2.setText("...");

        lblRG.setForeground(new java.awt.Color(0, 153, 0));
        lblRG.setText("RG");

        lblSetRG.setText("...");

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
                            .addComponent(lblCpfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSetCpfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefoneResponsavel)
                            .addComponent(lblRG)
                            .addComponent(lblSetRG))
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
                .addComponent(lblCpfResponsavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSetCpfResponsavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSetRG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefoneResponsavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSetTelResponsavel1)
                    .addComponent(lblSetTelResponsavel2))
                .addGap(30, 30, 30))
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
        try {
            setCbmEstado();
            setCbmAula();
            setCbmEstadoCivil();
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formWindowActivated

    private void btnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseClicked
        setPanelResponsavel();
        pnlDadosResponsavel.setVisible(true);
    }//GEN-LAST:event_btnPesquisarMouseClicked

    private void rdbSexoMascMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbSexoMascMouseClicked
        sexo = ('M');

    }//GEN-LAST:event_rdbSexoMascMouseClicked

    private void rdbSexoFemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbSexoFemMouseClicked
        sexo = ('F');

    }//GEN-LAST:event_rdbSexoFemMouseClicked

    private void chbMenorIdadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbMenorIdadeMouseClicked
        if (chbMenorIdade.isSelected() == true) {
            pnlResponsavel.setVisible(true);
        } else {
            pnlResponsavel.setVisible(false);
            pnlDadosResponsavel.setVisible(false);
        }
    }//GEN-LAST:event_chbMenorIdadeMouseClicked

    private void btnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseClicked
        new CadastroResponsavelGUI().setVisible(true);
    }//GEN-LAST:event_btnCadastrarMouseClicked

    private void edtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCepActionPerformed

    private void btnNovaCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovaCidadeMouseClicked
        CidadeGUI cidade = new CidadeGUI();
        cidade.setEstado((String) cmbEstado.getSelectedItem());
        cidade.setVisible(true);
    }//GEN-LAST:event_btnNovaCidadeMouseClicked

    private void btnNovaBairroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovaBairroMouseClicked
        BairroGUI bairro = new BairroGUI();
        bairro.setEstado((String) cmbEstado.getSelectedItem());
        bairro.setVisible(true);

    }//GEN-LAST:event_btnNovaBairroMouseClicked

    private void cmbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCidadeActionPerformed
        try {
            setCbmBairro();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbCidadeActionPerformed

    private void cmbBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBairroActionPerformed
        try {
            setCbmEndereco();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbBairroActionPerformed

    private void cmbEnderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbEnderecoFocusGained

    }//GEN-LAST:event_cmbEnderecoFocusGained

    private void tmrHoraOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmrHoraOnTime
        Date le_hora = new Date();
        lblHora.setText(horaformatada.format(le_hora));
    }//GEN-LAST:event_tmrHoraOnTime

    private void edtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNumeroActionPerformed

    private void lblCadastraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastraMouseClicked
        try {
            cadastra();
            conAluno.insertAuluno(aluno);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lblCadastraMouseClicked

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        try {
            atualizaCbmEstado();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void cmbEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEnderecoActionPerformed
        try {
            if (cmbEndereco.getSelectedIndex() >= 0) {
                edtCep.setText((String) conEndereco.getCep().get(cmbEndereco.getSelectedIndex()));
            }
        } catch (NullPointerException e) {
        }
    }//GEN-LAST:event_cmbEnderecoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

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
    private javax.swing.JButton btnNovaBairro;
    private javax.swing.JButton btnNovaCidade;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JCheckBox chbMenorIdade;
    private javax.swing.JComboBox cmbBairro;
    private javax.swing.JComboBox cmbCidade;
    private javax.swing.JComboBox cmbEndereco;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbEstadoCivil;
    private javax.swing.JComboBox cmbPacote1;
    private javax.swing.JComboBox cmbPacote2;
    private javax.swing.JTextField edtCPF;
    private javax.swing.JTextField edtCel;
    private javax.swing.JFormattedTextField edtCep;
    private javax.swing.JTextField edtComplemento;
    private javax.swing.JTextField edtDataAvaliacao;
    private javax.swing.JTextField edtDataExame;
    private javax.swing.JFormattedTextField edtDataNascimento;
    private javax.swing.JTextField edtDiaVencimento;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtIdentidade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtNumero;
    private javax.swing.JTextArea edtObs;
    private javax.swing.JTextField edtResponsavel;
    private javax.swing.JTextField edtTelRes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel laAvaliacao;
    private javax.swing.JLabel laObs1;
    private javax.swing.JLabel laSituacao1;
    private javax.swing.JLabel laSituacao2;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCadastra;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCpfResponsavel;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblDiaVencimaento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblExame;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblIdentidade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeResponsavel;
    private javax.swing.JLabel lblNovo;
    private javax.swing.JLabel lblRG;
    private javax.swing.JLabel lblResponsavel;
    private javax.swing.JLabel lblSetCpfResponsavel;
    private javax.swing.JLabel lblSetNomeResponsavel;
    private javax.swing.JLabel lblSetRG;
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
    private org.netbeans.examples.lib.timerbean.Timer tmrHora;
    // End of variables declaration//GEN-END:variables
}
