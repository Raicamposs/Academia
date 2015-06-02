/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.telas;

import com.sun.glass.events.KeyEvent;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import gerenciador.telas.ultilidades.Data;
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

    String[] botaoSelect = new String[20];

    /**
     * Creates new form Principal
     */
    public PrincipalGUI() {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);
        initComponents();
//        URL url = this.getClass().getResource("/Imagens/Logo/lg 25x25.jpg");
//        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
//        this.setIconImage(imagemTitulo);
        disabledSelect();
        timerHora.setDelay(1000);
        timerHora.start();
        lblData.setText(Data.mostraData());

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timerHora = new org.netbeans.examples.lib.timerbean.Timer();
        jPanel1 = new javax.swing.JPanel();
        lblConsultaFuncionario = new javax.swing.JLabel();
        lblConsultaAluno = new javax.swing.JLabel();
        lblFacebbok = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblCadAluno = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblCadFuncionario = new javax.swing.JLabel();
        lblSelectTurma = new javax.swing.JLabel();
        lblSelectFuncionario = new javax.swing.JLabel();
        lblSelectAula = new javax.swing.JLabel();
        lblSelectAluno = new javax.swing.JLabel();
        lblSelecPagamento = new javax.swing.JLabel();
        lblAniversariantes = new javax.swing.JLabel();
        lblMenuCadastro = new javax.swing.JLabel();
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

        timerHora.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timerHoraOnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(lblConsultaFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 220, 160, 140));

        lblConsultaAluno.setToolTipText("Cadastro Aluno");
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
        jPanel1.add(lblConsultaAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(985, 215, 155, 145));

        lblFacebbok.setToolTipText("Acessar  Facebook");
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
        jPanel1.add(lblFacebbok, new org.netbeans.lib.awtextra.AbsoluteConstraints(984, 533, 170, 140));

        lblData.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setText("jLabel1");
        jPanel1.add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 736, 320, 20));

        lblHora.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("jLabel1");
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 736, 140, 20));

        lblCadAluno.setToolTipText("Cadastro Aluno");
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
        jPanel1.add(lblCadAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(988, 40, 155, 145));

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
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1203, 530, 160, 140));

        lblCadFuncionario.setToolTipText("Cadastro Funcionário");
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
        jPanel1.add(lblCadFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 40, 150, 140));

        lblSelectTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectTurmaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectTurmaMouseExited(evt);
            }
        });
        jPanel1.add(lblSelectTurma, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 458, 165, 25));

        lblSelectFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectFuncionarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectFuncionarioMouseExited(evt);
            }
        });
        jPanel1.add(lblSelectFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 392, 165, 25));

        lblSelectAula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectAulaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectAulaMouseExited(evt);
            }
        });
        jPanel1.add(lblSelectAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 425, 165, 25));

        lblSelectAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectAlunoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectAlunoMouseExited(evt);
            }
        });
        jPanel1.add(lblSelectAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 165, 25));

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
        jPanel1.add(lblSelecPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 599, 180, 50));

        lblAniversariantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAniversariantesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAniversariantesMouseExited(evt);
            }
        });
        jPanel1.add(lblAniversariantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1197, 368, 170, 140));

        lblMenuCadastro.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblMenuCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMenuCadastroMouseExited(evt);
            }
        });
        jPanel1.add(lblMenuCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 190, 200));

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
        jPanel1.add(lblCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 358, 190, 50));

        lblMenuConsulAlter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMenuConsulAlterMouseExited(evt);
            }
        });
        jPanel1.add(lblMenuConsulAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 200, 190));

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
        jPanel1.add(lblConsulAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 418, 190, 50));

        lblFrequencia.setToolTipText("");
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
        jPanel1.add(lblFrequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(987, 370, 160, 130));

        lblMenuAniversariantes.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblMenuAniversariantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMenuAniversariantesMouseExited(evt);
            }
        });
        jPanel1.add(lblMenuAniversariantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 200, 120));

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
        jPanel1.add(lblSelectAniversariantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 478, 180, 50));
        jPanel1.add(lblMenuFrequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, 200, 160));

        lblSelecFrequencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSelecFrequencia.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblSelecFrequencia.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        lblSelecFrequencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelecFrequenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelecFrequenciaMouseExited(evt);
            }
        });
        jPanel1.add(lblSelecFrequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 540, 190, 50));

        lblBoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes/boMenu.png"))); // NOI18N
        lblBoMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBoMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBoMenuMouseEntered(evt);
            }
        });
        jPanel1.add(lblBoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 60, 60));

        lblMenu.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMenuMouseExited(evt);
            }
        });
        jPanel1.add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 200, 390));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Fundo/Fundo.jpg"))); // NOI18N
        lblFundo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFundoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFundoMouseEntered(evt);
            }
        });
        jPanel1.add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCadAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadAlunoMouseClicked
        new CadastroAlunoGUI().setVisible(true);

    }//GEN-LAST:event_lblCadAlunoMouseClicked

    private void lblFacebbokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFacebbokMouseClicked
        try {
            Desktop.getDesktop().browse(new URI(
                    "http://www.facebook.com"));
        } catch (IOException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblFacebbokMouseClicked

    private void lblEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmailMouseClicked
        try {
            Desktop.getDesktop().browse(new URI(
                    "http://www.hotmail.com"));
        } catch (IOException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblEmailMouseClicked

    private void lblFundoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFundoMouseClicked
        fechaMenu();
    }//GEN-LAST:event_lblFundoMouseClicked

    private void lblCadFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadFuncionarioMouseClicked
        new CadastroFuncionarioGUI().setVisible(true);
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

    private void lblMenuCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuCadastroMouseExited
        mouseSai(lblMenuCadastro);
    }//GEN-LAST:event_lblMenuCadastroMouseExited

    private void lblCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastroMouseClicked

    }//GEN-LAST:event_lblCadastroMouseClicked

    private void lblCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastroMouseEntered

        mouseSai(lblMenuConsulAlter);
        mouseSai(lblMenuAniversariantes);
        mouseEntra(lblCadastro, "/Imagens/botões selecionados/selectBoCadastro.png");
        mouseEntra(lblMenuCadastro, "/Imagens/Menu Lateral/menuCadastro.png");

    }//GEN-LAST:event_lblCadastroMouseEntered

    private void lblConsulAlterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsulAlterMouseEntered

        mouseSai(lblMenuCadastro);
        mouseSai(lblMenuAniversariantes);
        mouseEntra(lblConsulAlter, "/Imagens/botões selecionados/selectBoConsulAlter.png");
        mouseEntra(lblMenuConsulAlter, "/Imagens/Menu Lateral/menuCadastro.png");

    }//GEN-LAST:event_lblConsulAlterMouseEntered

    private void lblMenuConsulAlterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuConsulAlterMouseExited
        mouseSai(lblMenuConsulAlter);
    }//GEN-LAST:event_lblMenuConsulAlterMouseExited

    private void lblSelectAniversariantesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAniversariantesMouseEntered

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

    private void lblMenuAniversariantesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuAniversariantesMouseExited
        mouseSai(lblMenuAniversariantes);
    }//GEN-LAST:event_lblMenuAniversariantesMouseExited

    private void lblSelecFrequenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelecFrequenciaMouseEntered

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

    private void timerHoraOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerHoraOnTime
        Date le_hora = new Date();
        lblHora.setText(horaformatada.format(le_hora));
    }//GEN-LAST:event_timerHoraOnTime

    private void lblSelectTurmaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectTurmaMouseEntered
        mouseEntra(lblSelectTurma, "/Imagens/botões selecionados/selectTurma.png");
    }//GEN-LAST:event_lblSelectTurmaMouseEntered

    private void lblSelectTurmaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectTurmaMouseExited
        mouseSai(lblSelectTurma);
    }//GEN-LAST:event_lblSelectTurmaMouseExited

    private void lblConsultaAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsultaAlunoMouseClicked
        new AlteraAlunoGUI().setVisible(true);
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
        mouseEntra(lblSelecPagamento, "/Imagens/botões selecionados/selectBoPagamento.png");
    }//GEN-LAST:event_lblSelecPagamentoMouseEntered

    private void lblSelecPagamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelecPagamentoMouseExited
        mouseSai(lblSelecPagamento);
    }//GEN-LAST:event_lblSelecPagamentoMouseExited

    private void lblSelecPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelecPagamentoMouseClicked

    }//GEN-LAST:event_lblSelecPagamentoMouseClicked

    private void lblFrequenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFrequenciaMouseClicked
        new FrequenciaGUI().setVisible(true);
    }//GEN-LAST:event_lblFrequenciaMouseClicked

    private void lblSelectAlunoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAlunoMouseEntered
        mouseEntra(lblSelectAluno, "/Imagens/botões selecionados/selectAluno.png");
    }//GEN-LAST:event_lblSelectAlunoMouseEntered

    private void lblSelectAlunoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAlunoMouseExited
        mouseSai(lblSelectAluno);
    }//GEN-LAST:event_lblSelectAlunoMouseExited

    private void lblSelectFuncionarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectFuncionarioMouseExited
        mouseSai(lblSelectFuncionario);
    }//GEN-LAST:event_lblSelectFuncionarioMouseExited

    private void lblSelectFuncionarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectFuncionarioMouseEntered
        mouseEntra(lblSelectAluno, "/Imagens/botões selecionados/selectFuncionario.png");
    }//GEN-LAST:event_lblSelectFuncionarioMouseEntered

    private void lblSelectAulaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAulaMouseEntered
        mouseEntra(lblSelectAula, "/Imagens/botões selecionados/selectAula.png");
    }//GEN-LAST:event_lblSelectAulaMouseEntered

    private void lblSelectAulaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectAulaMouseExited
        mouseSai(lblSelectAula);
    }//GEN-LAST:event_lblSelectAulaMouseExited

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
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JLabel lblFrequencia;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblMenuAniversariantes;
    private javax.swing.JLabel lblMenuCadastro;
    private javax.swing.JLabel lblMenuConsulAlter;
    private javax.swing.JLabel lblMenuFrequencia;
    private javax.swing.JLabel lblSelecFrequencia;
    private javax.swing.JLabel lblSelecPagamento;
    private javax.swing.JLabel lblSelectAluno;
    private javax.swing.JLabel lblSelectAniversariantes;
    private javax.swing.JLabel lblSelectAula;
    private javax.swing.JLabel lblSelectFuncionario;
    private javax.swing.JLabel lblSelectTurma;
    private org.netbeans.examples.lib.timerbean.Timer timerHora;
    // End of variables declaration//GEN-END:variables
}
