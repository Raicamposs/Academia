/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.telas;

import gerenciador.funcionario.AlteraFuncionarioGUI;
import gerenciador.funcionario.CadastroFuncionarioGUI;
import gerenciador.alunos.CadastroAlunoGUI;
import gerenciador.alunos.AlteraAlunoGUI;
import com.sun.glass.events.KeyEvent;
import gerenciador.aula.CadastroAulaGUI;
import java.awt.Cursor;
import java.util.Date;
import javax.swing.ImageIcon;
import gerenciador.telas.ultilidades.Data;
import gerenciador.turma.CadastroTurmaGUI;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;

/**
 *
 * @author Raiane
 */
public class PrincipalGUI extends javax.swing.JFrame {

    String formatohora = "HH:mm:ss";
    SimpleDateFormat horaformatada = new SimpleDateFormat(formatohora);
    Data data = new Data();

    /**
     * Creates new form Principal
     */
    public PrincipalGUI() {

        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);
        initComponents();
        tmrHora.setDelay(1000);
        tmrHora.start();
        lblData.setText(Data.mostraData());
        disabledSelect();
        disableMenuSelectCadastro();
        disableMenuSelectConsulAlter();
        disableMenuAniversariante();
        // print(jPanel1.getGraphics());

    }

    private void mouseEntra(JLabel label, String url) {
        setCursor(Cursor.HAND_CURSOR);
        viewLogo(label, url);

    }

    private void mouseSai(JLabel label) {
        setCursor(Cursor.DEFAULT_CURSOR);
        label.setIcon(null);
    }

    private void viewLogo(JLabel label, String url) {
        try {
            ImageIcon logo = (new javax.swing.ImageIcon(getClass().getResource(url)));
            label.setIcon(logo);
        } catch (NullPointerException x) {
        }

    }

    private void fechaMenu() {
        mouseSai(lblMenuConsulAlter);
        mouseSai(lblMenuCadastro);
        mouseSai(lblMenuAniversariantes);
        mouseSai(lblMenu);
        disabledSelect();
        disableMenuSelectCadastro();
        disableMenuSelectConsulAlter();
        disableMenuAniversariante();
    }

    private void disabledSelect() {
        lblConsulAlter.setVisible(false);
        lblCadastro.setVisible(false);
        lblSelectAniversariantes.setVisible(false);
        lblSelecFrequencia.setVisible(false);
        lblSelecPagamento.setVisible(false);

    }

    private void enabledSelect() {
        lblConsulAlter.setVisible(true);
        lblCadastro.setVisible(true);
        lblSelectAniversariantes.setVisible(true);
        lblSelecFrequencia.setVisible(true);
        lblSelecPagamento.setVisible(true);

    }

    private void enabledMenuSelectCadastro() {
        lblSelectAlunoCadastro.setVisible(true);
        lblSelectAulaCadastro.setVisible(true);
        lblSelectFuncionarioCadastro.setVisible(true);
        lblSelectTurmaCadastro.setVisible(true);

    }

    private void disableMenuSelectCadastro() {
        lblSelectAlunoCadastro.setVisible(false);
        lblSelectAulaCadastro.setVisible(false);
        lblSelectFuncionarioCadastro.setVisible(false);
        lblSelectTurmaCadastro.setVisible(false);

    }

    private void enabledMenuSelectConsulAlter() {
        lblSelectAlunoConsulAlter.setVisible(true);
        lblSelectAulaConsulAlter.setVisible(true);
        lblSelectFuncionarioConsulAlter.setVisible(true);
        lblSelectTurmaConsulAlter.setVisible(true);

    }

    private void disableMenuSelectConsulAlter() {
        lblSelectAlunoConsulAlter.setVisible(false);
        lblSelectAulaConsulAlter.setVisible(false);
        lblSelectFuncionarioConsulAlter.setVisible(false);
        lblSelectTurmaConsulAlter.setVisible(false);

    }

    private void disableMenuAniversariante() {
        lblSelectMes.setVisible(false);
        lblSelectDia.setVisible(false);

    }

    private void enableMenuAniversariante() {
        lblSelectMes.setVisible(true);
        lblSelectDia.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tmrHora = new org.netbeans.examples.lib.timerbean.Timer();
        pnlPrincipal = new javax.swing.JPanel();
        lblSelectDia = new javax.swing.JLabel();
        lblSelectMes = new javax.swing.JLabel();
        lblSelectFuncionarioCadastro = new javax.swing.JLabel();
        lblSelectAulaCadastro = new javax.swing.JLabel();
        lblSelectAlunoCadastro = new javax.swing.JLabel();
        lblSelectTurmaCadastro = new javax.swing.JLabel();
        lblSelectAulaConsulAlter = new javax.swing.JLabel();
        lblSelectAlunoConsulAlter = new javax.swing.JLabel();
        lblSelectTurmaConsulAlter = new javax.swing.JLabel();
        lblSelectFuncionarioConsulAlter = new javax.swing.JLabel();
        lblConsultaFuncionario = new javax.swing.JLabel();
        lblConsultaAluno = new javax.swing.JLabel();
        lblFacebbok = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblCadAluno = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblCadFuncionario = new javax.swing.JLabel();
        lblSelecPagamento = new javax.swing.JLabel();
        lblMenuCadastro = new javax.swing.JLabel();
        lblAniversariantes = new javax.swing.JLabel();
        lblFechar = new javax.swing.JLabel();
        lblMinimiza = new javax.swing.JLabel();
        lblCadastro = new javax.swing.JLabel();
        lblMenuConsulAlter = new javax.swing.JLabel();
        lblConsulAlter = new javax.swing.JLabel();
        lblFrequencia = new javax.swing.JLabel();
        lblMenuAniversariantes = new javax.swing.JLabel();
        lblSelectAniversariantes = new javax.swing.JLabel();
        lblMenuFrequencia = new javax.swing.JLabel();
        lblSelecFrequencia = new javax.swing.JLabel();
        lblBoMenu = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        tmrHora.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                tmrHoraOnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSelectDia.setPreferredSize(new java.awt.Dimension(34, 15));
        lblSelectDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectDiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectDiaMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelectDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 175, 25));

        lblSelectMes.setPreferredSize(new java.awt.Dimension(34, 15));
        lblSelectMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectMesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectMesMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelectMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 542, 175, 25));

        lblSelectFuncionarioCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectFuncionarioCadastroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectFuncionarioCadastroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectFuncionarioCadastroMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelectFuncionarioCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 392, 165, 25));

        lblSelectAulaCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectAulaCadastroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectAulaCadastroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectAulaCadastroMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelectAulaCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 425, 165, 25));

        lblSelectAlunoCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectAlunoCadastroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectAlunoCadastroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectAlunoCadastroMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelectAlunoCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 165, 25));

        lblSelectTurmaCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectTurmaCadastroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectTurmaCadastroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectTurmaCadastroMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelectTurmaCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 458, 165, 25));

        lblSelectAulaConsulAlter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectAulaConsulAlterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectAulaConsulAlterMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelectAulaConsulAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 512, 165, 25));

        lblSelectAlunoConsulAlter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectAlunoConsulAlterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectAlunoConsulAlterMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelectAlunoConsulAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 448, 165, 25));

        lblSelectTurmaConsulAlter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectTurmaConsulAlterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectTurmaConsulAlterMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelectTurmaConsulAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 545, 165, 25));

        lblSelectFuncionarioConsulAlter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectFuncionarioConsulAlterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectFuncionarioConsulAlterMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelectFuncionarioConsulAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 165, 25));

        lblConsultaFuncionario.setToolTipText("Pesquisar Funcionário");
        lblConsultaFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConsultaFuncionarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblConsultaFuncionarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblConsultaFuncionarioMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblConsultaFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 220, 160, 140));

        lblConsultaAluno.setToolTipText("Pesquisar Aluno");
        lblConsultaAluno.setRequestFocusEnabled(false);
        lblConsultaAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConsultaAlunoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblConsultaAlunoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblConsultaAlunoMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblConsultaAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(985, 215, 155, 145));

        lblFacebbok.setToolTipText("Acessar Facebook");
        lblFacebbok.setRequestFocusEnabled(false);
        lblFacebbok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFacebbokMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFacebbokMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblFacebbokMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblFacebbok, new org.netbeans.lib.awtextra.AbsoluteConstraints(984, 533, 170, 140));

        lblData.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setText("...");
        pnlPrincipal.add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 736, 320, 20));

        lblHora.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("...");
        pnlPrincipal.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 736, 140, 20));

        lblCadAluno.setToolTipText("Cadastrar Aluno");
        lblCadAluno.setRequestFocusEnabled(false);
        lblCadAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadAlunoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCadAlunoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCadAlunoMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblCadAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(988, 40, 155, 145));

        lblEmail.setToolTipText("Acesar Email");
        lblEmail.setRequestFocusEnabled(false);
        lblEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEmailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEmailMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1203, 530, 160, 140));

        lblCadFuncionario.setToolTipText("Cadastrar Funcionário");
        lblCadFuncionario.setRequestFocusEnabled(false);
        lblCadFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadFuncionarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCadFuncionarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCadFuncionarioMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblCadFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 40, 150, 140));

        lblSelecPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelecPagamentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelecPagamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelecPagamentoMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelecPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 599, 180, 50));

        lblMenuCadastro.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlPrincipal.add(lblMenuCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 190, 200));

        lblAniversariantes.setToolTipText("Aniversáriantes");
        lblAniversariantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAniversariantesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAniversariantesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAniversariantesMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblAniversariantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1197, 368, 170, 140));

        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        pnlPrincipal.add(lblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1345, 5, 15, 15));

        lblMinimiza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizaMouseClicked(evt);
            }
        });
        pnlPrincipal.add(lblMinimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 5, 15, 15));

        lblCadastro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCadastro.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        lblCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadastroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCadastroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCadastroMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 358, 190, 50));
        pnlPrincipal.add(lblMenuConsulAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 190, 190));

        lblConsulAlter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblConsulAlter.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        lblConsulAlter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblConsulAlterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblConsulAlterMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblConsulAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 418, 190, 50));

        lblFrequencia.setToolTipText("Adicionar Frequência");
        lblFrequencia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblFrequencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFrequenciaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFrequenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblFrequenciaMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblFrequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(987, 370, 160, 130));

        lblMenuAniversariantes.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlPrincipal.add(lblMenuAniversariantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 200, 120));

        lblSelectAniversariantes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSelectAniversariantes.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        lblSelectAniversariantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectAniversariantesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectAniversariantesMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelectAniversariantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 478, 180, 50));
        pnlPrincipal.add(lblMenuFrequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, 200, 160));

        lblSelecFrequencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSelecFrequencia.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblSelecFrequencia.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        lblSelecFrequencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelecFrequenciaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelecFrequenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelecFrequenciaMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblSelecFrequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 540, 190, 50));

        lblBoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes/boMenu.png"))); // NOI18N
        lblBoMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBoMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBoMenuMouseEntered(evt);
            }
        });
        pnlPrincipal.add(lblBoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 60, 60));

        lblMenu.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMenuMouseExited(evt);
            }
        });
        pnlPrincipal.add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 200, 390));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Fundo/Fundo.jpg"))); // NOI18N
        lblFundo.setToolTipText("");
        lblFundo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFundoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFundoMouseEntered(evt);
            }
        });
        pnlPrincipal.add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCadAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadAlunoMouseClicked
        new CadastroAlunoGUI().setVisible(true);
        fechaMenu();

    }//GEN-LAST:event_lblCadAlunoMouseClicked

    private void lblFacebbokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFacebbokMouseClicked
        gerenciador.telas.ultilidades.FuncoesJanelas.navegador("http://www.facebook.com", this);
        fechaMenu();
    }//GEN-LAST:event_lblFacebbokMouseClicked

    private void lblEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmailMouseClicked
        gerenciador.telas.ultilidades.FuncoesJanelas.navegador("http://www.hotmail.com", this);
        fechaMenu();

    }//GEN-LAST:event_lblEmailMouseClicked

    private void lblFundoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFundoMouseClicked
        fechaMenu();
    }//GEN-LAST:event_lblFundoMouseClicked

    private void lblCadFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadFuncionarioMouseClicked
        new CadastroFuncionarioGUI().setVisible(true);
        fechaMenu();
    }//GEN-LAST:event_lblCadFuncionarioMouseClicked

    private void lblCadFuncionarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadFuncionarioMouseEntered
        mouseEntra(lblCadFuncionario, "/Imagens/botões selecionados/selectCadFunc.png");
    }//GEN-LAST:event_lblCadFuncionarioMouseEntered

    private void lblCadFuncionarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadFuncionarioMouseExited
        mouseSai(lblCadFuncionario);
    }//GEN-LAST:event_lblCadFuncionarioMouseExited

    private void lblCadAlunoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadAlunoMouseEntered
        mouseEntra(lblCadAluno, "/Imagens/botões selecionados/selectCadAlu.png");

    }//GEN-LAST:event_lblCadAlunoMouseEntered

    private void lblCadAlunoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadAlunoMouseExited
        mouseSai(lblCadAluno);
    }//GEN-LAST:event_lblCadAlunoMouseExited

    private void lblFacebbokMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFacebbokMouseEntered
        mouseEntra(lblFacebbok, "/Imagens/botões selecionados/selectFacebook.png");
    }//GEN-LAST:event_lblFacebbokMouseEntered

    private void lblFacebbokMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFacebbokMouseExited
        mouseSai(lblFacebbok);
    }//GEN-LAST:event_lblFacebbokMouseExited

    private void lblEmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmailMouseEntered
        mouseEntra(lblEmail, "/Imagens/botões selecionados/selectEmail.png");
    }//GEN-LAST:event_lblEmailMouseEntered

    private void lblEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmailMouseExited
        mouseSai(lblEmail);
    }//GEN-LAST:event_lblEmailMouseExited

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.setExtendedState(LoginGUI.ICONIFIED);
        }
    }//GEN-LAST:event_formKeyPressed

    private void lblMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseEntered

    }//GEN-LAST:event_lblMenuMouseEntered

    private void lblMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseExited

    }//GEN-LAST:event_lblMenuMouseExited

    private void lblBoMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBoMenuMouseEntered
        enabledSelect();
        mouseEntra(lblMenu, "/Imagens/Menu Lateral/menu2.png");
    }//GEN-LAST:event_lblBoMenuMouseEntered

    private void lblFundoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFundoMouseEntered

    }//GEN-LAST:event_lblFundoMouseEntered

    private void lblCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastroMouseClicked

    }//GEN-LAST:event_lblCadastroMouseClicked

    private void lblCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastroMouseEntered
        enabledMenuSelectCadastro();
        disableMenuSelectConsulAlter();
        disableMenuAniversariante();
        mouseSai(lblMenuConsulAlter);
        mouseSai(lblMenuAniversariantes);
        mouseEntra(lblCadastro, "/Imagens/botões selecionados/selectBoCadastro.png");
        mouseEntra(lblMenuCadastro, "/Imagens/Menu Lateral/menuCadastro.png");


    }//GEN-LAST:event_lblCadastroMouseEntered

    private void lblConsulAlterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsulAlterMouseEntered
        disableMenuSelectCadastro();
        disableMenuAniversariante();
        enabledMenuSelectConsulAlter();
        mouseSai(lblMenuCadastro);
        mouseSai(lblMenuAniversariantes);
        mouseEntra(lblConsulAlter, "/Imagens/botões selecionados/selectBoConsulAlter.png");
        mouseEntra(lblMenuConsulAlter, "/Imagens/Menu Lateral/menuCadastro.png");

    }//GEN-LAST:event_lblConsulAlterMouseEntered

    private void lblSelectAniversariantesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAniversariantesMouseEntered
        disableMenuSelectCadastro();
        disableMenuSelectConsulAlter();
        enableMenuAniversariante();
        mouseSai(lblMenuConsulAlter);
        mouseSai(lblMenuCadastro);
        mouseEntra(lblSelectAniversariantes, "/Imagens/botões selecionados/selectBoAniversariantes.png");
        mouseEntra(lblMenuAniversariantes, "/Imagens/Menu Lateral/menuAniversariantes.png");

    }//GEN-LAST:event_lblSelectAniversariantesMouseEntered

    private void lblSelectAniversariantesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAniversariantesMouseExited
        mouseSai(lblSelectAniversariantes);
    }//GEN-LAST:event_lblSelectAniversariantesMouseExited

    private void lblBoMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBoMenuMouseClicked
        fechaMenu();
    }//GEN-LAST:event_lblBoMenuMouseClicked

    private void lblSelecFrequenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelecFrequenciaMouseEntered
        disableMenuSelectCadastro();
        disableMenuAniversariante();
        mouseSai(lblMenuConsulAlter);
        mouseSai(lblMenuCadastro);
        mouseSai(lblMenuAniversariantes);
        mouseEntra(lblSelecFrequencia, "/Imagens/botões selecionados/selectBoFrequencia.png");

    }//GEN-LAST:event_lblSelecFrequenciaMouseEntered

    private void lblSelecFrequenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelecFrequenciaMouseExited
        mouseSai(lblSelecFrequencia);
    }//GEN-LAST:event_lblSelecFrequenciaMouseExited

    private void lblConsulAlterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsulAlterMouseExited
        mouseSai(lblConsulAlter);
    }//GEN-LAST:event_lblConsulAlterMouseExited

    private void lblCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastroMouseExited
        mouseSai(lblCadastro);
    }//GEN-LAST:event_lblCadastroMouseExited

    private void lblConsultaAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsultaAlunoMouseClicked
        new AlteraAlunoGUI().setVisible(true);
        fechaMenu();
    }//GEN-LAST:event_lblConsultaAlunoMouseClicked

    private void lblConsultaAlunoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsultaAlunoMouseEntered
        mouseEntra(lblConsultaAluno, "/Imagens/botões selecionados/selectPesAlu.png");
    }//GEN-LAST:event_lblConsultaAlunoMouseEntered

    private void lblConsultaAlunoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsultaAlunoMouseExited
        mouseSai(lblConsultaAluno);
    }//GEN-LAST:event_lblConsultaAlunoMouseExited

    private void lblConsultaFuncionarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsultaFuncionarioMouseEntered
        mouseEntra(lblConsultaFuncionario, "/Imagens/botões selecionados/selectPesFun.png");
    }//GEN-LAST:event_lblConsultaFuncionarioMouseEntered

    private void lblConsultaFuncionarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsultaFuncionarioMouseExited
        mouseSai(lblConsultaFuncionario);
    }//GEN-LAST:event_lblConsultaFuncionarioMouseExited

    private void lblConsultaFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsultaFuncionarioMouseClicked
        new AlteraFuncionarioGUI().setVisible(true);
        fechaMenu();
    }//GEN-LAST:event_lblConsultaFuncionarioMouseClicked

    private void lblFrequenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFrequenciaMouseEntered
        mouseEntra(lblFrequencia, "/Imagens/botões selecionados/selectPresenca.png");
    }//GEN-LAST:event_lblFrequenciaMouseEntered

    private void lblFrequenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFrequenciaMouseExited
        mouseSai(lblFrequencia);
    }//GEN-LAST:event_lblFrequenciaMouseExited

    private void lblAniversariantesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAniversariantesMouseEntered
        mouseEntra(lblAniversariantes, "/Imagens/botões selecionados/selectAniversariante.png");
    }//GEN-LAST:event_lblAniversariantesMouseEntered

    private void lblAniversariantesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAniversariantesMouseExited
        mouseSai(lblAniversariantes);
    }//GEN-LAST:event_lblAniversariantesMouseExited

    private void lblSelecPagamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelecPagamentoMouseEntered
        disableMenuSelectCadastro();
        mouseEntra(lblSelecPagamento, "/Imagens/botões selecionados/selectBoPagamento.png");
    }//GEN-LAST:event_lblSelecPagamentoMouseEntered

    private void lblSelecPagamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelecPagamentoMouseExited
        mouseSai(lblSelecPagamento);
    }//GEN-LAST:event_lblSelecPagamentoMouseExited

    private void lblSelecPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelecPagamentoMouseClicked

    }//GEN-LAST:event_lblSelecPagamentoMouseClicked

    private void lblFrequenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFrequenciaMouseClicked
        new FrequenciaGUI().setVisible(true);
        fechaMenu();
    }//GEN-LAST:event_lblFrequenciaMouseClicked

    private void lblSelectAlunoCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAlunoCadastroMouseEntered
        mouseEntra(lblSelectAlunoCadastro, "/Imagens/botões selecionados/selectAluno.png");

    }//GEN-LAST:event_lblSelectAlunoCadastroMouseEntered

    private void lblSelectFuncionarioCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectFuncionarioCadastroMouseEntered
        mouseEntra(lblSelectFuncionarioCadastro, "/Imagens/botões selecionados/selectFuncionario.png");
    }//GEN-LAST:event_lblSelectFuncionarioCadastroMouseEntered

    private void lblSelectAulaCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAulaCadastroMouseEntered
        mouseEntra(lblSelectAulaCadastro, "/Imagens/botões selecionados/selectAula.png");
    }//GEN-LAST:event_lblSelectAulaCadastroMouseEntered

    private void lblSelectTurmaCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectTurmaCadastroMouseEntered
        mouseEntra(lblSelectTurmaCadastro, "/Imagens/botões selecionados/selectTurma.png");
    }//GEN-LAST:event_lblSelectTurmaCadastroMouseEntered

    private void lblSelectAlunoCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAlunoCadastroMouseExited
        mouseSai(lblSelectAlunoCadastro);
    }//GEN-LAST:event_lblSelectAlunoCadastroMouseExited

    private void lblSelectFuncionarioCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectFuncionarioCadastroMouseExited
        mouseSai(lblSelectFuncionarioCadastro);
    }//GEN-LAST:event_lblSelectFuncionarioCadastroMouseExited

    private void lblSelectAulaCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAulaCadastroMouseExited
        mouseSai(lblSelectAulaCadastro);
    }//GEN-LAST:event_lblSelectAulaCadastroMouseExited

    private void lblSelectTurmaCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectTurmaCadastroMouseExited
        mouseSai(lblSelectTurmaCadastro);
    }//GEN-LAST:event_lblSelectTurmaCadastroMouseExited

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblFecharMouseClicked

    private void lblMinimizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizaMouseClicked
        this.setExtendedState(LoginGUI.ICONIFIED);
    }//GEN-LAST:event_lblMinimizaMouseClicked

    private void lblSelectAulaConsulAlterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAulaConsulAlterMouseEntered
        mouseEntra(lblSelectAulaConsulAlter, "/Imagens/botões selecionados/selectAula.png");
    }//GEN-LAST:event_lblSelectAulaConsulAlterMouseEntered

    private void lblSelectAulaConsulAlterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAulaConsulAlterMouseExited
        mouseSai(lblSelectAulaConsulAlter);
    }//GEN-LAST:event_lblSelectAulaConsulAlterMouseExited

    private void lblSelectAlunoConsulAlterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAlunoConsulAlterMouseEntered
        mouseEntra(lblSelectAlunoConsulAlter, "/Imagens/botões selecionados/selectAluno.png");
    }//GEN-LAST:event_lblSelectAlunoConsulAlterMouseEntered

    private void lblSelectAlunoConsulAlterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAlunoConsulAlterMouseExited
        mouseSai(lblSelectAlunoConsulAlter);
    }//GEN-LAST:event_lblSelectAlunoConsulAlterMouseExited

    private void lblSelectTurmaConsulAlterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectTurmaConsulAlterMouseEntered
        mouseEntra(lblSelectTurmaConsulAlter, "/Imagens/botões selecionados/selectTurma.png");
    }//GEN-LAST:event_lblSelectTurmaConsulAlterMouseEntered

    private void lblSelectTurmaConsulAlterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectTurmaConsulAlterMouseExited
        mouseSai(lblSelectTurmaConsulAlter);
    }//GEN-LAST:event_lblSelectTurmaConsulAlterMouseExited

    private void lblSelectFuncionarioConsulAlterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectFuncionarioConsulAlterMouseEntered
        mouseEntra(lblSelectFuncionarioConsulAlter, "/Imagens/botões selecionados/selectFuncionario.png");
    }//GEN-LAST:event_lblSelectFuncionarioConsulAlterMouseEntered

    private void lblSelectFuncionarioConsulAlterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectFuncionarioConsulAlterMouseExited
        mouseSai(lblSelectFuncionarioConsulAlter);
    }//GEN-LAST:event_lblSelectFuncionarioConsulAlterMouseExited

    private void timerHoraOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerOnTime

    }//GEN-LAST:event_timerOnTime

    private void tmrHoraOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmrHoraOnTime
        Date le_hora = new Date();
        lblHora.setText(horaformatada.format(le_hora));
    }//GEN-LAST:event_tmrHoraOnTime

    private void lblSelectDiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectDiaMouseEntered
        mouseEntra(lblSelectDia, "/Imagens/botões selecionados/selectDia.png");
    }//GEN-LAST:event_lblSelectDiaMouseEntered

    private void lblSelectMesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectMesMouseEntered
        mouseEntra(lblSelectMes, "/Imagens/botões selecionados/selectMes.png");
    }//GEN-LAST:event_lblSelectMesMouseEntered

    private void lblSelectMesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectMesMouseExited
        mouseSai(lblSelectMes);
    }//GEN-LAST:event_lblSelectMesMouseExited

    private void lblSelectDiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectDiaMouseExited
        mouseSai(lblSelectDia);
    }//GEN-LAST:event_lblSelectDiaMouseExited

    private void lblSelecFrequenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelecFrequenciaMouseClicked
        new FrequenciaGUI().setVisible(true);
        fechaMenu();
    }//GEN-LAST:event_lblSelecFrequenciaMouseClicked

    private void lblSelectAulaCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAulaCadastroMouseClicked
        new CadastroAulaGUI().setVisible(true);
        fechaMenu();
    }//GEN-LAST:event_lblSelectAulaCadastroMouseClicked

    private void lblSelectAlunoCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAlunoCadastroMouseClicked
        new CadastroAlunoGUI().setVisible(true);
        fechaMenu();
    }//GEN-LAST:event_lblSelectAlunoCadastroMouseClicked

    private void lblSelectTurmaCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectTurmaCadastroMouseClicked
        new CadastroTurmaGUI().setVisible(true);
        fechaMenu();
    }//GEN-LAST:event_lblSelectTurmaCadastroMouseClicked

    private void lblSelectFuncionarioCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectFuncionarioCadastroMouseClicked
        new CadastroFuncionarioGUI().setVisible(true);
        fechaMenu();
    }//GEN-LAST:event_lblSelectFuncionarioCadastroMouseClicked

    private void lblAniversariantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAniversariantesMouseClicked
        fechaMenu();
    }//GEN-LAST:event_lblAniversariantesMouseClicked

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
            java.util.logging.Logger.getLogger(PrincipalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAniversariantes;
    private javax.swing.JLabel lblBoMenu;
    private javax.swing.JLabel lblCadAluno;
    private javax.swing.JLabel lblCadFuncionario;
    private javax.swing.JLabel lblCadastro;
    private javax.swing.JLabel lblConsulAlter;
    private javax.swing.JLabel lblConsultaAluno;
    private javax.swing.JLabel lblConsultaFuncionario;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFacebbok;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JLabel lblFrequencia;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblMenuAniversariantes;
    private javax.swing.JLabel lblMenuCadastro;
    private javax.swing.JLabel lblMenuConsulAlter;
    private javax.swing.JLabel lblMenuFrequencia;
    private javax.swing.JLabel lblMinimiza;
    private javax.swing.JLabel lblSelecFrequencia;
    private javax.swing.JLabel lblSelecPagamento;
    private javax.swing.JLabel lblSelectAlunoCadastro;
    private javax.swing.JLabel lblSelectAlunoConsulAlter;
    private javax.swing.JLabel lblSelectAniversariantes;
    private javax.swing.JLabel lblSelectAulaCadastro;
    private javax.swing.JLabel lblSelectAulaConsulAlter;
    private javax.swing.JLabel lblSelectDia;
    private javax.swing.JLabel lblSelectFuncionarioCadastro;
    private javax.swing.JLabel lblSelectFuncionarioConsulAlter;
    private javax.swing.JLabel lblSelectMes;
    private javax.swing.JLabel lblSelectTurmaCadastro;
    private javax.swing.JLabel lblSelectTurmaConsulAlter;
    private javax.swing.JPanel pnlPrincipal;
    private org.netbeans.examples.lib.timerbean.Timer tmrHora;
    // End of variables declaration//GEN-END:variables
}
