/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.funcionario;


import gerenciador.alunos.CadastroAlunoGUI;
import gerenciador.endereco.CidadeGUI;
import gerenciador.endereco.BairroGUI;
import gerenciador.endereco.Cidade;
import gerenciador.conexaoBD.EnderecoDao;
import gerenciador.conexaoBD.FuncionarioDao;
import gerenciador.telas.ultilidades.Data;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
public class CadastroFuncionarioGUI extends javax.swing.JFrame {

    private Turno turno;
    private Funcao funcao;
    private char sexo;
    private EnderecoDao conEndereco;
    private FuncionarioDao conFuncionario;
    private String formatohora = "HH:mm:ss";
    private SimpleDateFormat horaformatada = new SimpleDateFormat(formatohora);
    private Data data = new Data();
    private Funcionario funcionario;
    private Cidade cidade = new Cidade("");
    private Iterator iteratorEstado = null;
    private MaskFormatter formatoCpf, formatoCtps, formatoRg, formatoCep, formatoFone, formatoCel, formatoData;
    private int nivel;
   

    public CadastroFuncionarioGUI() {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);
        initComponents();
        tmrHora.setDelay(1000);
        tmrHora.start();
        lblData.setText(Data.mostraData());
        gerenciador.telas.ultilidades.FuncoesJanelas.setIncone(this);
        pnlCadastrar.setVisible(false);
        conEndereco = new EnderecoDao();
        conFuncionario = new FuncionarioDao();
        edtCep.setEditable(false);
    }

    private void cadastra() throws SQLException {
        if (gerenciador.pessoa.ValidaCpf.validador(edtCpf.getText())) {
            if ((new String(pwfSenha.getPassword())).equals(new String(pwfConfirmaSenha.getPassword()))) {
                funcionario = new Funcionario(gerenciador.telas.ultilidades.FormataCampo.formataDocumentosBanco(edtCpf.getText()),
                        gerenciador.telas.ultilidades.FormataCampo.formataDocumentosBanco(edtIdentidade.getText()), edtNome.getText(),
                        gerenciador.telas.ultilidades.FormataCampo.formataDataBanco(edtDataNascimento.getText()), edtEmail.getText(), sexo,
                        edtCtps.getText(), (Float.parseFloat(edtSalario.getText().replace(",", "."))));
                funcionario.setFoneCelular(edtFoneCel.getText());
                funcionario.setFoneResidencial(edtTelRes.getText());
                funcionario.setObservacao(edtObservacoes.getText());
                funcionario.setDataEntrada(gerenciador.telas.ultilidades.FormataCampo.formataDataBanco(edtDataEntrada.getText()));
                funcionario.setSituacao((cmbSituacaoFuncionario.getSelectedIndex() + 1));
                funcionario.getEndereco().setCEP(Integer.parseInt(edtCep.getText().replace("-", "")));
                funcionario.getEndereco().setRua((String) cmbEndereco.getSelectedItem());
                funcionario.getEndereco().setComplemento(edtComplemento.getText());
                funcionario.getEndereco().setNumero(edtNumero.getText());
                funcionario.getEstadoCivil().setDescricao((String) cmbEstadoCivil.getSelectedItem());
                funcionario.getEstadoCivil().setId((cmbEstadoCivil.getSelectedIndex() + 1));
                funcionario.getTurno().setNome((String) cmbTurno.getSelectedItem());
                funcionario.getTurno().setId((cmbTurno.getSelectedIndex() + 1));
                funcionario.getFuncao().setNome((String) cmbFuncao.getSelectedItem());
                funcionario.getFuncao().setId((cmbFuncao.getSelectedIndex() + 1));
                funcionario.setSituacao((cmbSituacaoFuncionario.getSelectedIndex() + 1));

                if (chbCadastrarUsuario.isSelected() == true) {
                    funcionario.setUsuarioAutorizado(true);
                    funcionario.getUsario().setLogin(edtUsuLogin.getText());
                    funcionario.getUsario().setSenha(new String(pwfSenha.getPassword()));
                    funcionario.getUsario().setNivel(nivel);

                } else {
                    funcionario.setUsuarioAutorizado(false);
                    funcionario.getUsario().setLogin("");
                    funcionario.getUsario().setSenha("");
                    funcionario.getUsario().setNivel(0);

                }

                conFuncionario.insertFuncionario(funcionario);

            } else {
                JOptionPane.showMessageDialog(null, "As senhas não são iguais");
            }
        }

    }

    private void setCbmFuncao() throws SQLException {
        try {
            cmbFuncao.removeAllItems();
            Iterator iteratorFuncao = conFuncionario.getArrayFuncao().iterator();
            while (iteratorFuncao.hasNext()) {
                cmbFuncao.addItem(String.valueOf(iteratorFuncao.next()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroFuncionarioGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setCbmTurno() throws SQLException {
        try {
            cmbTurno.removeAllItems();
            Iterator iteratorTurno = conFuncionario.getArrayTurno().iterator();
            while (iteratorTurno.hasNext()) {
                cmbTurno.addItem(String.valueOf(iteratorTurno.next()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroFuncionarioGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setCbmEstadoCivil() throws SQLException {
        try {
            cmbEstadoCivil.removeAllItems();
            Iterator iteratorEstadoCivil = conFuncionario.getArrayEstadoCivil().iterator();
            while (iteratorEstadoCivil.hasNext()) {
                cmbEstadoCivil.addItem(String.valueOf(iteratorEstadoCivil.next()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroFuncionarioGUI.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoNivelAcesso = new javax.swing.ButtonGroup();
        tmrHora = new org.netbeans.examples.lib.timerbean.Timer();
        lblVoltar = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JTabbedPane();
        pnlDados = new javax.swing.JPanel();
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
        jLabel4 = new javax.swing.JLabel();
        edtNumero = new javax.swing.JTextField();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        try {      formatoRg = new MaskFormatter("#####.###-#");     } catch(Exception erro) {     JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para RG, "+erro); }
        edtIdentidade = new JFormattedTextField(formatoRg);
        jLabel1 = new javax.swing.JLabel();
        lblFoneRes = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        try
        {
            formatoCpf = new MaskFormatter("###.###.###-##");
        }
        catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para cpf, "+erro);
        }
        edtCpf = new JFormattedTextField(formatoCpf);
        try
        {
            formatoCel = new MaskFormatter("(0xx##)#####-####");
        }
        catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para cpf, "+erro);
        }
        edtFoneCel = new JFormattedTextField(formatoCel);
        edtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblDataNasc = new javax.swing.JLabel();
        try {      formatoData = new MaskFormatter("##/##/####");     } catch(Exception erro) {     JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para data, "+erro); }
        edtDataNascimento = new JFormattedTextField(formatoData);
        lblEstadoCivil = new javax.swing.JLabel();
        cmbEstadoCivil = new javax.swing.JComboBox();
        lblFoneCel = new javax.swing.JLabel();
        cmbEndereco = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        edtComplemento = new javax.swing.JTextField();
        pnlSexo = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        sexo_masc = new javax.swing.JRadioButton();
        sexo_fem = new javax.swing.JRadioButton();
        paInfAdicionais = new javax.swing.JPanel();
        pnlDadosCadastrais = new javax.swing.JPanel();
        lblFuncao = new javax.swing.JLabel();
        try {      formatoData = new MaskFormatter("##/##/####");     } catch(Exception erro) {     JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para data, "+erro); }
        edtDataEntrada = new JFormattedTextField(formatoData);
        llblAvaliacao = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        edtObservacoes = new javax.swing.JTextArea();
        lblObservacoes = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        cmbTurno = new javax.swing.JComboBox();
        lblCtps = new javax.swing.JLabel();
        try {      formatoCtps= new MaskFormatter
            ("#######/#####-UU");     } catch(Exception erro) {     JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para ctps, "+erro); }
        edtCtps = new JFormattedTextField(formatoCtps);
        cmbFuncao = new javax.swing.JComboBox();
        lblSalario = new javax.swing.JLabel();
        edtSalario = new javax.swing.JTextField();
        lblSituacoaFuncionario = new javax.swing.JLabel();
        cmbSituacaoFuncionario = new javax.swing.JComboBox();
        btnNovaFuncao = new javax.swing.JButton();
        pnlBorda = new javax.swing.JPanel();
        pnlCadastrar = new javax.swing.JPanel();
        edtUsuLogin = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        pwfSenha = new javax.swing.JPasswordField();
        pwfConfirmaSenha = new javax.swing.JPasswordField();
        lblConfirmarSenha = new javax.swing.JLabel();
        lblNivelAcesso = new javax.swing.JLabel();
        rdbAdministrador = new javax.swing.JRadioButton();
        rdbUsuario = new javax.swing.JRadioButton();
        chbCadastrarUsuario = new javax.swing.JCheckBox();
        lblCadastra = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        tmrHora.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                tmrHoraOnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVoltarMouseClicked(evt);
            }
        });
        getContentPane().add(lblVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 660, 120, 40));

        lblData.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setText("...");
        getContentPane().add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 736, 320, 20));

        lblHora.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("...");
        getContentPane().add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 736, 140, 20));

        pnlPrincipal.setBackground(new java.awt.Color(153, 255, 153));

        pnlDados.setBackground(new java.awt.Color(255, 255, 255));
        pnlDados.setPreferredSize(new java.awt.Dimension(800, 600));

        pnlEndereco.setBackground(new java.awt.Color(255, 255, 255));

        edtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCepActionPerformed(evt);
            }
        });

        lblCep.setText("CEP");

        lblBairro.setText("Bairro");

        cmbBairro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione ...", "Item 2", "Item 3", "Item 4" }));
        cmbBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBairroActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Selecione...", "Item 4" }));
        cmbEstado.setSelectedIndex(6);
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        cmbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione ...", "Item 2", "Item 3", "Item 4" }));
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

        jLabel4.setText("Numero");

        edtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNumeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEnderecoLayout = new javax.swing.GroupLayout(pnlEndereco);
        pnlEndereco.setLayout(pnlEnderecoLayout);
        pnlEnderecoLayout.setHorizontalGroup(
            pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 144, Short.MAX_VALUE)
                            .addComponent(cmbCidade, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovaCidade)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(edtCep, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbBairro, javax.swing.GroupLayout.Alignment.LEADING, 0, 146, Short.MAX_VALUE)
                                    .addComponent(lblBairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCidade, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(lblCep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNovaBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(edtNumero))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );

        pnlEnderecoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNovaBairro, btnNovaCidade});

        pnlEnderecoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbBairro, cmbCidade, cmbEstado});

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
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addComponent(lblBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNovaBairro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCep)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(edtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnlEnderecoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnNovaBairro, btnNovaCidade});

        pnlInformacoes.setBackground(new java.awt.Color(255, 255, 255));

        edtTelRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtTelResActionPerformed(evt);
            }
        });

        edtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNomeActionPerformed(evt);
            }
        });

        jLabel2.setText("Endereço");

        jLabel18.setText("Identidade");

        jLabel1.setText("Nome");

        lblFoneRes.setText("Fone Res.:");

        lblCpf.setText("CPF");

        lblEmail.setText("Email");

        lblDataNasc.setText("Data Nascimento");

        edtDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtDataNascimentoActionPerformed(evt);
            }
        });

        lblEstadoCivil.setText(" Estado Civil");

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione ...", "F", "M" }));

        lblFoneCel.setText("Fone Cel.:");

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

        jLabel3.setText("Complemento");

        javax.swing.GroupLayout pnlInformacoesLayout = new javax.swing.GroupLayout(pnlInformacoes);
        pnlInformacoes.setLayout(pnlInformacoesLayout);
        pnlInformacoesLayout.setHorizontalGroup(
            pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbEndereco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDataNasc)
                                .addComponent(lblEmail)
                                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel18)
                                            .addComponent(edtIdentidade, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                            .addComponent(edtDataNascimento))
                                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(lblCpf))
                                            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(edtCpf)
                                                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lblEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(0, 0, Short.MAX_VALUE))))))
                                    .addComponent(edtEmail)
                                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(edtTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblFoneRes))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(edtFoneCel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblFoneCel)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(308, 308, 308))))
                            .addComponent(edtComplemento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlInformacoesLayout.setVerticalGroup(
            pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtIdentidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                .addComponent(lblCpf)
                                .addGap(26, 26, 26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDataNasc)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFoneRes)
                    .addComponent(lblFoneCel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtFoneCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(edtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlSexo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setText("sexo");

        sexo_masc.setBackground(new java.awt.Color(255, 255, 255));
        sexo_masc.setSelected(true);
        sexo_masc.setText("Masculino");
        sexo_masc.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        sexo_masc.setMargin(new java.awt.Insets(0, 0, 0, 0));
        sexo_masc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sexo_mascMouseClicked(evt);
            }
        });
        sexo_masc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexo_mascActionPerformed(evt);
            }
        });

        sexo_fem.setBackground(new java.awt.Color(255, 255, 255));
        sexo_fem.setText("Feminino");
        sexo_fem.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        sexo_fem.setMargin(new java.awt.Insets(0, 0, 0, 0));
        sexo_fem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sexo_femMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sexo_femMouseEntered(evt);
            }
        });
        sexo_fem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexo_femActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSexoLayout = new javax.swing.GroupLayout(pnlSexo);
        pnlSexo.setLayout(pnlSexoLayout);
        pnlSexoLayout.setHorizontalGroup(
            pnlSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSexoLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(pnlSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(pnlSexoLayout.createSequentialGroup()
                        .addComponent(sexo_masc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sexo_fem)))
                .addGap(18, 18, 18))
        );
        pnlSexoLayout.setVerticalGroup(
            pnlSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSexoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexo_fem)
                    .addComponent(sexo_masc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlDadosLayout = new javax.swing.GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(pnlSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addContainerGap(179, Short.MAX_VALUE))
        );

        pnlPrincipal.addTab("Dados Cadastrais", pnlDados);

        paInfAdicionais.setBackground(new java.awt.Color(255, 255, 255));

        pnlDadosCadastrais.setBackground(new java.awt.Color(255, 255, 255));

        lblFuncao.setText("Função");

        llblAvaliacao.setText("Data de entrada");

        edtObservacoes.setColumns(20);
        edtObservacoes.setRows(5);
        jScrollPane3.setViewportView(edtObservacoes);

        lblObservacoes.setText("Observações");

        lblTurno.setText("Turno");

        cmbTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCtps.setText("CTPS");

        cmbFuncao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSalario.setText("Salário");

        edtSalario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edtSalarioMouseClicked(evt);
            }
        });
        edtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtSalarioActionPerformed(evt);
            }
        });

        lblSituacoaFuncionario.setText("Situação do funcionário");

        cmbSituacaoFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));
        cmbSituacaoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSituacaoFuncionarioActionPerformed(evt);
            }
        });

        btnNovaFuncao.setBackground(new java.awt.Color(0, 153, 0));
        btnNovaFuncao.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaFuncao.setText("Novo");
        btnNovaFuncao.setActionCommand("");
        btnNovaFuncao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNovaFuncaoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDadosCadastraisLayout = new javax.swing.GroupLayout(pnlDadosCadastrais);
        pnlDadosCadastrais.setLayout(pnlDadosCadastraisLayout);
        pnlDadosCadastraisLayout.setHorizontalGroup(
            pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSalario)
                    .addComponent(edtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                        .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbFuncao, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edtCtps, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTurno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCtps, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTurno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovaFuncao)))
                .addGap(82, 82, 82)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(llblAvaliacao)
                    .addComponent(lblObservacoes)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSituacoaFuncionario)
                    .addComponent(cmbSituacaoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosCadastraisLayout.setVerticalGroup(
            pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncao)
                    .addComponent(llblAvaliacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovaFuncao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                        .addComponent(lblSituacoaFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSituacaoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblObservacoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                        .addComponent(lblTurno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCtps)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSalario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnlBorda.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlBordaLayout = new javax.swing.GroupLayout(pnlBorda);
        pnlBorda.setLayout(pnlBordaLayout);
        pnlBordaLayout.setHorizontalGroup(
            pnlBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );
        pnlBordaLayout.setVerticalGroup(
            pnlBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        pnlCadastrar.setBackground(new java.awt.Color(255, 255, 255));

        edtUsuLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtUsuLoginActionPerformed(evt);
            }
        });

        jLabel13.setText("Login");

        lblSenha.setText("Senha");

        lblConfirmarSenha.setText("Confirmar Senha");

        lblNivelAcesso.setText("Nivél de acesso");

        rdbAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        grupoNivelAcesso.add(rdbAdministrador);
        rdbAdministrador.setText("Administrador");
        rdbAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAdministradorActionPerformed(evt);
            }
        });

        rdbUsuario.setBackground(new java.awt.Color(255, 255, 255));
        grupoNivelAcesso.add(rdbUsuario);
        rdbUsuario.setText("Usuário");

        javax.swing.GroupLayout pnlCadastrarLayout = new javax.swing.GroupLayout(pnlCadastrar);
        pnlCadastrar.setLayout(pnlCadastrarLayout);
        pnlCadastrarLayout.setHorizontalGroup(
            pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNivelAcesso)
                    .addComponent(rdbUsuario)
                    .addComponent(rdbAdministrador)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSenha)
                    .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pwfConfirmaSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addComponent(pwfSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblConfirmarSenha)))
                .addGap(35, 35, 35))
        );
        pnlCadastrarLayout.setVerticalGroup(
            pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNivelAcesso)
                    .addComponent(lblConfirmarSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbAdministrador)
                    .addComponent(pwfConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbUsuario)
                .addContainerGap())
        );

        chbCadastrarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        chbCadastrarUsuario.setText("Cadastrar Usuário");
        chbCadastrarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chbCadastrarUsuarioMouseClicked(evt);
            }
        });
        chbCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbCadastrarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paInfAdicionaisLayout = new javax.swing.GroupLayout(paInfAdicionais);
        paInfAdicionais.setLayout(paInfAdicionaisLayout);
        paInfAdicionaisLayout.setHorizontalGroup(
            paInfAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paInfAdicionaisLayout.createSequentialGroup()
                .addGroup(paInfAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paInfAdicionaisLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(pnlDadosCadastrais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paInfAdicionaisLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(chbCadastrarUsuario)
                        .addGap(70, 70, 70)
                        .addComponent(pnlCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBorda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paInfAdicionaisLayout.setVerticalGroup(
            paInfAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paInfAdicionaisLayout.createSequentialGroup()
                .addComponent(pnlDadosCadastrais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(paInfAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paInfAdicionaisLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(pnlBorda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paInfAdicionaisLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(paInfAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbCadastrarUsuario))))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pnlPrincipal.addTab("Informações Adicionais", paInfAdicionais);

        getContentPane().add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 830, 600));

        lblCadastra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadastraMouseClicked(evt);
            }
        });
        getContentPane().add(lblCadastra, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 655, 120, 50));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Fundo/BackgroudCadastroFuncionario.jpg"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCepActionPerformed

    private void edtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeActionPerformed

    private void edtDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDataNascimentoActionPerformed

    private void sexo_mascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexo_mascActionPerformed
        String sexo = "M";
    }//GEN-LAST:event_sexo_mascActionPerformed

    private void sexo_femActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexo_femActionPerformed
        String sexo = "F";
    }//GEN-LAST:event_sexo_femActionPerformed

    private void lblVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblVoltarMouseClicked

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

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

        try {
            setCbmFuncao();
            setCbmEstado();
            setCbmTurno();
            setCbmEstadoCivil();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroFuncionarioGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formComponentShown

    private void edtUsuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtUsuLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtUsuLoginActionPerformed

    private void chbCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbCadastrarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbCadastrarUsuarioActionPerformed

    private void chbCadastrarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbCadastrarUsuarioMouseClicked
        if (chbCadastrarUsuario.isSelected() == true) {
            pnlCadastrar.setVisible(true);

        } else {
            pnlCadastrar.setVisible(false);
        }

    }//GEN-LAST:event_chbCadastrarUsuarioMouseClicked

    private void edtTelResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtTelResActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtTelResActionPerformed

    private void lblCadastraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastraMouseClicked
        try {
            cadastra();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroFuncionarioGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblCadastraMouseClicked

    private void sexo_mascMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sexo_mascMouseClicked
        sexo = ('M');

    }//GEN-LAST:event_sexo_mascMouseClicked

    private void sexo_femMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sexo_femMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sexo_femMouseEntered

    private void sexo_femMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sexo_femMouseClicked
        sexo = ('F');

    }//GEN-LAST:event_sexo_femMouseClicked

    private void btnNovaFuncaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovaFuncaoMouseClicked
        new FuncaoGUI().setVisible(true);
    }//GEN-LAST:event_btnNovaFuncaoMouseClicked

    private void cmbEnderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbEnderecoFocusGained
        try {
            setCbmEndereco();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroFuncionarioGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbEnderecoFocusGained

    private void tmrHoraOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmrHoraOnTime
        Date le_hora = new Date();
        lblHora.setText(horaformatada.format(le_hora));
    }//GEN-LAST:event_tmrHoraOnTime

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

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        try {
            setCbmCidade();
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

    private void edtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNumeroActionPerformed

    private void rdbAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAdministradorActionPerformed
        if (rdbAdministrador.isSelected()) {
            this.nivel = 1;
        } else {
            this.nivel = 2;
        }
    }//GEN-LAST:event_rdbAdministradorActionPerformed

    private void cmbSituacaoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSituacaoFuncionarioActionPerformed

    }//GEN-LAST:event_cmbSituacaoFuncionarioActionPerformed

    private void edtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtSalarioActionPerformed
              // TODO add your handling code here:
    }//GEN-LAST:event_edtSalarioActionPerformed

    private void edtSalarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edtSalarioMouseClicked
     // TODO add your handling code here:
    }//GEN-LAST:event_edtSalarioMouseClicked

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
            java.util.logging.Logger.getLogger(CadastroFuncionarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionarioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovaBairro;
    private javax.swing.JButton btnNovaCidade;
    private javax.swing.JButton btnNovaFuncao;
    private javax.swing.JCheckBox chbCadastrarUsuario;
    private javax.swing.JComboBox cmbBairro;
    private javax.swing.JComboBox cmbCidade;
    private javax.swing.JComboBox cmbEndereco;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbEstadoCivil;
    private javax.swing.JComboBox cmbFuncao;
    private javax.swing.JComboBox cmbSituacaoFuncionario;
    private javax.swing.JComboBox cmbTurno;
    private javax.swing.JFormattedTextField edtCep;
    private javax.swing.JTextField edtComplemento;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtCtps;
    private javax.swing.JTextField edtDataEntrada;
    private javax.swing.JFormattedTextField edtDataNascimento;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtFoneCel;
    private javax.swing.JTextField edtIdentidade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtNumero;
    private javax.swing.JTextArea edtObservacoes;
    private javax.swing.JTextField edtSalario;
    private javax.swing.JTextField edtTelRes;
    private javax.swing.JTextField edtUsuLogin;
    private javax.swing.ButtonGroup grupoNivelAcesso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCadastra;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblCtps;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblFoneCel;
    private javax.swing.JLabel lblFoneRes;
    private javax.swing.JLabel lblFuncao;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblNivelAcesso;
    private javax.swing.JLabel lblObservacoes;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSituacoaFuncionario;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JLabel lblVoltar;
    private javax.swing.JLabel llblAvaliacao;
    private javax.swing.JPanel paInfAdicionais;
    private javax.swing.JPanel pnlBorda;
    private javax.swing.JPanel pnlCadastrar;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JPanel pnlDadosCadastrais;
    private javax.swing.JPanel pnlEndereco;
    private javax.swing.JPanel pnlInformacoes;
    private javax.swing.JTabbedPane pnlPrincipal;
    private javax.swing.JPanel pnlSexo;
    private javax.swing.JPasswordField pwfConfirmaSenha;
    private javax.swing.JPasswordField pwfSenha;
    private javax.swing.JRadioButton rdbAdministrador;
    private javax.swing.JRadioButton rdbUsuario;
    private javax.swing.JRadioButton sexo_fem;
    private javax.swing.JRadioButton sexo_masc;
    private org.netbeans.examples.lib.timerbean.Timer tmrHora;
    // End of variables declaration//GEN-END:variables
}
