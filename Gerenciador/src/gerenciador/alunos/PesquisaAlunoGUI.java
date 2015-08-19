/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.alunos;

import gerenciador.conexaoBD.AlunoDao;
import gerenciador.conexaoBD.AulaDao;
import gerenciador.conexaoBD.EnderecoDao;
import gerenciador.conexaoBD.RelatorioDao;
import gerenciador.conexaoBD.ResponsavelDao;
import gerenciador.endereco.BairroGUI;
import gerenciador.endereco.CidadeGUI;
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
public class PesquisaAlunoGUI extends javax.swing.JFrame {

    private AlunoDao conAluno;
    private EnderecoDao conEndereco;
    private RelatorioDao conRelatorio;
    private ResponsavelDao conResponsavel;
    private Iterator iteratorEstado;
    private String formatohora = "HH:mm:ss";
    private int posicao = -2;

    private SimpleDateFormat horaformatada = new SimpleDateFormat(formatohora);
    private Data data = new Data();
    private Aluno aluno;
    private AulaDao conAula;
    private MaskFormatter formatoCpf, formatoRg, formatoDataVencimento, formatoCep, formatoCel, formatoFone, formatoData;

    public PesquisaAlunoGUI() {
        initComponents();
        tmrHora3.setDelay(1000);
        tmrHora3.start();
        lblData.setText(Data.mostraData());
        conAluno = new AlunoDao();
        conAula = new AulaDao();
        conEndereco = new EnderecoDao();
        conResponsavel = new ResponsavelDao();
        conRelatorio = new RelatorioDao();
        setCbmEstadoCivil();
        setCbmAula();
        statusComponentes(false);

    }

    private void preencherTblAluno(String nome, String matricula) {
        try {
            conAluno.preencheTable(tblAluno, nome, matricula);
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void atualizaCampos() throws SQLException {
        int colunaCpf = 2;
        setCbmEstado();
        if (tblAluno.getSelectedRow() != -1) {
            for (int i = 0; i < tblAluno.getColumnCount() - 1; i++) {
                if (tblAluno.getColumnName(i).equalsIgnoreCase("Cpf")) {
                    colunaCpf = i;
                }
            }
            aluno = new Aluno();
            conAluno.selectAuluno(aluno, (String) tblAluno.getValueAt(tblAluno.getSelectedRow(), colunaCpf));
            edtCPF.setText(aluno.getCpf());
            edtIdentidade.setText(aluno.getRG());
            edtNomeAluno.setText(aluno.getNome());
            edtDataNascimento.setText(gerenciador.telas.ultilidades.FormataCampo.formataDataBancoAplicacao(aluno.getDataNascimento()));
            edtEmail.setText(aluno.getEmail());
            edtCel.setText(aluno.getFoneCelular());
            edtTelRes.setText(aluno.getFoneResidencial());
            edtDiaVencimaento.setText(aluno.getVencimento());
            edtObs.setText(aluno.getObservacao());
            edtDataAvaliacao.setText(gerenciador.telas.ultilidades.FormataCampo.formataDataBancoAplicacao(aluno.getDataAvaliacao()));
            edtDataExame.setText(gerenciador.telas.ultilidades.FormataCampo.formataDataBancoAplicacao(aluno.getDataExame()));
            edtCep.setText("" + aluno.getEndereco().getCEP());
            edtComplemento.setText(aluno.getEndereco().getComplemento());
            edtNumero.setText(aluno.getEndereco().getNumero());
            conEndereco.selectEndereco(aluno.getEndereco().getCEP(), aluno);
            if (aluno.getSexo() == 'F') {
                rdbSexoFem.setSelected(true);
            } else {
                rdbSexoMasc.setSelected(true);
            }
            atualizaCbmDadosAluno(aluno);
        }
    }

    private void atualizaCbmDadosAluno(Aluno aluno) {
        cmbEstado.setSelectedItem(aluno.getEndereco().getEstadoNome());
        cmbCidade.setSelectedItem(aluno.getEndereco().getCidadeNome());
        cmbBairro.setSelectedItem(aluno.getEndereco().getBairroNome());
        cmbEndereco.setSelectedItem(aluno.getEndereco().getRua());
    }

    private void statusComponentes(boolean ativo) {
        edtCPF.setEditable(ativo);
        edtIdentidade.setEditable(ativo);
        edtNomeAluno.setEditable(ativo);
        edtDataNascimento.setEditable(ativo);
        edtEmail.setEditable(ativo);
        edtCel.setEditable(ativo);
        edtTelRes.setEditable(ativo);
        edtDiaVencimaento.setEditable(ativo);
        edtObs.setEditable(ativo);
        edtDataAvaliacao.setEditable(ativo);
        edtDataExame.setEditable(ativo);
        edtCep.setEditable(ativo);
        edtComplemento.setEditable(ativo);
        edtNumero.setEditable(ativo);
        cmbEstadoCivil.setEditable(ativo);
        cmbEstado.setEnabled(ativo);
        cmbEndereco.setEnabled(ativo);
        cmbCidade.setEnabled(ativo);
        cmbBairro.setEnabled(ativo);
        cmbPacote1.setEnabled(ativo);
        cmbEstadoCivil.setEnabled(ativo);
        rdbSexoFem.setEnabled(ativo);
        rdbSexoMasc.setEnabled(ativo);
        chbMenorIdade.setEnabled(ativo);
    }

    private void setCbmAula() {
        try {
            cmbPacote1.removeAllItems();
            Iterator iteratorAula = conAula.getArrayAula().iterator();
            while (iteratorAula.hasNext()) {
                String aula = String.valueOf(iteratorAula.next());
                cmbPacote1.addItem(aula);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tmrHora3 = new org.netbeans.examples.lib.timerbean.Timer();
        choGrupSexo = new javax.swing.ButtonGroup();
        frmPesquisa = new javax.swing.JInternalFrame();
        edtMatricula = new javax.swing.JTextField();
        edtNome = new javax.swing.JTextField();
        lblPesquisar = new javax.swing.JLabel();
        lblFundoPesquisa = new javax.swing.JLabel();
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
        edtNomeAluno = new javax.swing.JTextField();
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
        edtDiaVencimaento = new JFormattedTextField(formatoDataVencimento);
        chbMenorIdade = new javax.swing.JCheckBox();
        pnlSexo = new javax.swing.JPanel();
        lblSexo = new javax.swing.JLabel();
        rdbSexoMasc = new javax.swing.JRadioButton();
        rdbSexoFem = new javax.swing.JRadioButton();
        pnlEndereco = new javax.swing.JPanel();
        try {      formatoCep = new MaskFormatter("#####-###");     } catch(Exception erro) {     JOptionPane.showMessageDialog(null,"Não foi possivel setar a mascara para cpf, "+erro); }
        edtCep = new JFormattedTextField(formatoCep);
        edtNumero = new javax.swing.JTextField();
        lblCep = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        cmbBairro = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        cmbCidade = new javax.swing.JComboBox();
        lblCidade = new javax.swing.JLabel();
        btnNovaCidade = new javax.swing.JButton();
        btnNovaBairro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblImprimi = new javax.swing.JLabel();
        lblEdita = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        lblNext = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAluno = new javax.swing.JTable();
        lblFundo = new javax.swing.JLabel();

        tmrHora3.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                tmrHora3OnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        frmPesquisa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        frmPesquisa.setVisible(true);
        frmPesquisa.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edtMatricula.setBorder(null);
        edtMatricula.setSelectionColor(new java.awt.Color(0, 153, 0));
        frmPesquisa.getContentPane().add(edtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 72, 70, 20));

        edtNome.setBorder(null);
        edtNome.setSelectionColor(new java.awt.Color(0, 153, 0));
        frmPesquisa.getContentPane().add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 47, 140, 20));

        lblPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPesquisarMouseClicked(evt);
            }
        });
        frmPesquisa.getContentPane().add(lblPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 60, 50));

        lblFundoPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Pequenas/tela pesquisa sem barra.png"))); // NOI18N
        lblFundoPesquisa.setToolTipText("");
        lblFundoPesquisa.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        frmPesquisa.getContentPane().add(lblFundoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(frmPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 350, 180));

        pnlDados.setBackground(new java.awt.Color(255, 255, 255));
        pnlDados.setPreferredSize(new java.awt.Dimension(800, 600));
        pnlDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlInformacoes.setBackground(new java.awt.Color(255, 255, 255));

        edtTelRes.setSelectionColor(new java.awt.Color(0, 153, 0));

        edtNomeAluno.setSelectionColor(new java.awt.Color(0, 153, 0));

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

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));

        lblEndereco.setText("Endereço");

        cmbEndereco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione ..." }));
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
                .addGap(20, 20, 20)
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblEndereco))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edtComplemento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbEndereco, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInformacoesLayout.createSequentialGroup()
                                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDataNascimento)
                                    .addComponent(lblEmail)
                                    .addComponent(edtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNome))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInformacoesLayout.createSequentialGroup()
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInformacoesLayout.createSequentialGroup()
                                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                        .addComponent(lblTelResidencial)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                        .addComponent(edtTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTelCelular)
                                    .addComponent(edtCel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(edtEmail, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())))
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
                                .addComponent(edtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelCelular)
                    .addComponent(lblTelResidencial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pnlDados.add(pnlInformacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 440));

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

        laSituacao1.setText("Pacote Contratado:");

        cmbPacote1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));

        lblDiaVencimaento.setText("Data Vencimento:");

        edtDiaVencimaento.setSelectionColor(new java.awt.Color(0, 153, 0));

        chbMenorIdade.setBackground(new java.awt.Color(255, 255, 255));
        chbMenorIdade.setText("  Menor de Idade");
        chbMenorIdade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chbMenorIdadeMouseClicked(evt);
            }
        });

        pnlSexo.setBackground(new java.awt.Color(255, 255, 255));

        lblSexo.setText("Sexo");

        rdbSexoMasc.setBackground(new java.awt.Color(255, 255, 255));
        choGrupSexo.add(rdbSexoMasc);
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
        choGrupSexo.add(rdbSexoFem);
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

        pnlEndereco.setBackground(new java.awt.Color(255, 255, 255));

        edtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCepActionPerformed(evt);
            }
        });

        edtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNumeroActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlInformacoesAulasLayout = new javax.swing.GroupLayout(pnlInformacoesAulas);
        pnlInformacoesAulas.setLayout(pnlInformacoesAulasLayout);
        pnlInformacoesAulasLayout.setHorizontalGroup(
            pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblExame)
                            .addComponent(laSituacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPacote1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtDataExame, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(laAvaliacao)
                                    .addComponent(edtDataAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDiaVencimaento)
                                    .addComponent(edtDiaVencimaento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(chbMenorIdade)))
                        .addContainerGap())
                    .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                        .addComponent(pnlEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(laObs1))))
                        .addGap(480, 480, 480))))
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
                    .addComponent(edtDiaVencimaento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(laSituacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbPacote1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbMenorIdade))
                .addGap(18, 18, 18)
                .addGroup(pnlInformacoesAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacoesAulasLayout.createSequentialGroup()
                        .addComponent(pnlSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(laObs1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 73, Short.MAX_VALUE))
                    .addComponent(pnlEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlDados.add(pnlInformacoesAulas, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 550, 410));

        getContentPane().add(pnlDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1030, 460));

        lblInicio.setToolTipText("");
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
        getContentPane().add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 400, 120, 47));

        lblHora.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("...");
        getContentPane().add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 736, 140, 20));

        lblData.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setText("...");
        getContentPane().add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 736, 320, 20));

        lblImprimi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImprimiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblImprimiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblImprimiMouseExited(evt);
            }
        });
        getContentPane().add(lblImprimi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 400, 120, 47));

        lblEdita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEditaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEditaMouseExited(evt);
            }
        });
        getContentPane().add(lblEdita, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 470, 120, 50));

        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackMouseExited(evt);
            }
        });
        getContentPane().add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 550, 130, 50));

        lblNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNextMouseExited(evt);
            }
        });
        getContentPane().add(lblNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 550, 120, 50));

        tblAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "RG", "Data de Nascimento", "Email", "Estado Civil"
            }
        ));
        tblAluno.setSelectionBackground(new java.awt.Color(0, 153, 0));
        tblAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlunoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAluno);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1030, 220));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Fundo/BackgroudAlteraCadastro.jpg"))); // NOI18N
        lblFundo.setToolTipText("");
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblInicioMouseClicked

    private void lblInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblInicio);
    }//GEN-LAST:event_lblInicioMouseEntered

    private void lblImprimiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImprimiMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblImprimi);
    }//GEN-LAST:event_lblImprimiMouseEntered

    private void lblInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblInicio);

    }//GEN-LAST:event_lblInicioMouseExited

    private void lblImprimiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImprimiMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblImprimi);

    }//GEN-LAST:event_lblImprimiMouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            setCbmEstado();
            setCbmAula();
            setCbmEstadoCivil();
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void lblPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPesquisarMouseClicked

        try {
            posicao = tblAluno.getSelectedRow();
            preencherTblAluno(edtNome.getText(), edtMatricula.getText());
            atualizaCampos();
            frmPesquisa.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lblPesquisarMouseClicked

    private void lblImprimiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImprimiMouseClicked
        conRelatorio.relAluno();
    }//GEN-LAST:event_lblImprimiMouseClicked

    private void tmrHora3OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmrHora3OnTime
        Date le_hora = new Date();
        lblHora.setText(horaformatada.format(le_hora));
    }//GEN-LAST:event_tmrHora3OnTime

    private void cmbEnderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbEnderecoFocusGained

    }//GEN-LAST:event_cmbEnderecoFocusGained

    private void cmbEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEnderecoActionPerformed
        try {
            if (cmbEndereco.getSelectedIndex() >= 0) {
                edtCep.setText((String) conEndereco.getCep().get(cmbEndereco.getSelectedIndex()));
            }
        } catch (NullPointerException e) {
        }
    }//GEN-LAST:event_cmbEnderecoActionPerformed

    private void tblAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlunoMouseClicked
        try {
            atualizaCampos();
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblAlunoMouseClicked

    private void lblEditaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditaMouseClicked
        statusComponentes(true);
    }//GEN-LAST:event_lblEditaMouseClicked

    private void btnNovaBairroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovaBairroMouseClicked
        BairroGUI bairro = new BairroGUI();
        bairro.setEstado((String) cmbEstado.getSelectedItem());
        bairro.setVisible(true);
    }//GEN-LAST:event_btnNovaBairroMouseClicked

    private void btnNovaCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovaCidadeMouseClicked
        CidadeGUI cidade = new CidadeGUI();
        cidade.setEstado((String) cmbEstado.getSelectedItem());
        cidade.setVisible(true);
    }//GEN-LAST:event_btnNovaCidadeMouseClicked

    private void cmbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCidadeActionPerformed
        try {
            setCbmBairro();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbCidadeActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        try {
            atualizaCbmEstado();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void cmbBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBairroActionPerformed
        try {
            setCbmEndereco();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbBairroActionPerformed

    private void edtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNumeroActionPerformed

    private void edtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCepActionPerformed

    private void rdbSexoFemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbSexoFemMouseClicked

    }//GEN-LAST:event_rdbSexoFemMouseClicked

    private void rdbSexoMascMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbSexoMascMouseClicked

    }//GEN-LAST:event_rdbSexoMascMouseClicked

    private void chbMenorIdadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbMenorIdadeMouseClicked

    }//GEN-LAST:event_chbMenorIdadeMouseClicked

    private void lblNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseClicked
        try {

            if (posicao < (tblAluno.getRowCount() - 1)) {
                posicao = posicao + 1;
                tblAluno.setRowSelectionInterval(posicao, posicao);

            } else {
                posicao = 0;
                tblAluno.setRowSelectionInterval(posicao, posicao);
            }
            atualizaCampos();
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lblNextMouseClicked

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        try {
            if (posicao > 0) {
                posicao = posicao - 1;
                tblAluno.setRowSelectionInterval(posicao, posicao);
            } else {
                posicao = (tblAluno.getRowCount() - 1);
                tblAluno.setRowSelectionInterval(posicao, posicao);
            }
            atualizaCampos();
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblBackMouseClicked

    private void lblBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblBack);        // TODO add your handling code here:
    }//GEN-LAST:event_lblBackMouseEntered

    private void lblBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblBack);
    }//GEN-LAST:event_lblBackMouseExited

    private void lblNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblNext);
    }//GEN-LAST:event_lblNextMouseEntered

    private void lblNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblNext);
    }//GEN-LAST:event_lblNextMouseExited

    private void lblEditaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditaMouseEntered
        gerenciador.telas.ultilidades.Style.styleBorderEntered(lblEdita);
    }//GEN-LAST:event_lblEditaMouseEntered

    private void lblEditaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditaMouseExited
        gerenciador.telas.ultilidades.Style.styleBorderExited(lblEdita);
    }//GEN-LAST:event_lblEditaMouseExited

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
            java.util.logging.Logger.getLogger(PesquisaAlunoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaAlunoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaAlunoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaAlunoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaAlunoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovaBairro;
    private javax.swing.JButton btnNovaCidade;
    private javax.swing.JCheckBox chbMenorIdade;
    private javax.swing.ButtonGroup choGrupSexo;
    private javax.swing.JComboBox cmbBairro;
    private javax.swing.JComboBox cmbCidade;
    private javax.swing.JComboBox cmbEndereco;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbEstadoCivil;
    private javax.swing.JComboBox cmbPacote1;
    private javax.swing.JTextField edtCPF;
    private javax.swing.JTextField edtCel;
    private javax.swing.JFormattedTextField edtCep;
    private javax.swing.JTextField edtComplemento;
    private javax.swing.JTextField edtDataAvaliacao;
    private javax.swing.JTextField edtDataExame;
    private javax.swing.JFormattedTextField edtDataNascimento;
    private javax.swing.JTextField edtDiaVencimaento;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtIdentidade;
    private javax.swing.JTextField edtMatricula;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtNomeAluno;
    private javax.swing.JTextField edtNumero;
    private javax.swing.JTextArea edtObs;
    private javax.swing.JTextField edtTelRes;
    private javax.swing.JInternalFrame frmPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel laAvaliacao;
    private javax.swing.JLabel laObs1;
    private javax.swing.JLabel laSituacao1;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblDiaVencimaento;
    private javax.swing.JLabel lblEdita;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblExame;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblFundoPesquisa;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblIdentidade;
    private javax.swing.JLabel lblImprimi;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelCelular;
    private javax.swing.JLabel lblTelResidencial;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JPanel pnlEndereco;
    private javax.swing.JPanel pnlInformacoes;
    private javax.swing.JPanel pnlInformacoesAulas;
    private javax.swing.JPanel pnlSexo;
    private javax.swing.JRadioButton rdbSexoFem;
    private javax.swing.JRadioButton rdbSexoMasc;
    private javax.swing.JTable tblAluno;
    private org.netbeans.examples.lib.timerbean.Timer tmrHora3;
    // End of variables declaration//GEN-END:variables
}
