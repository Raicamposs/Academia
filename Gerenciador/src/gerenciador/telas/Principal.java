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
import Ultilidades.Data;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;

/**
 *
 * @author Raiane
 */
public class Principal extends javax.swing.JFrame {

    String formatohora = "HH:mm:ss";
    SimpleDateFormat horaformatada = new SimpleDateFormat(formatohora);
    Data data = new Data();

    String[] botaoSelect = new String[20];

    /**
     * Creates new form Principal
     */
    public Principal() {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);
        initComponents();
//        URL url = this.getClass().getResource("/Imagens/Logo/lg 25x25.jpg");
//        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
//        this.setIconImage(imagemTitulo);
        disabledSelect();
        timerHora.setDelay(1000);
        timerHora.start();
        laData.setText(Data.mostraData());

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
        mouseSai(laMenuConsulAlter);
        mouseSai(laMenuCadastro);
        mouseSai(laMenuAniversariantes);
        mouseSai(laMenu);

        disabledSelect();
    }

    private void disabledSelect() {
        laConsulAlter.setVisible(false);
        laCadastro.setVisible(false);
        laAniversariantes.setVisible(false);
        laFrequencia.setVisible(false);
    }

    private void enabledSelect() {
        laConsulAlter.setVisible(true);
        laCadastro.setVisible(true);
        laAniversariantes.setVisible(true);
        laFrequencia.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timerHora = new org.netbeans.examples.lib.timerbean.Timer();
        jPanel1 = new javax.swing.JPanel();
        lblConsultaFuncionario = new javax.swing.JLabel();
        lblConsultaAluno = new javax.swing.JLabel();
        laFacebbok = new javax.swing.JLabel();
        laData = new javax.swing.JLabel();
        laHora = new javax.swing.JLabel();
        laCadAluno = new javax.swing.JLabel();
        laEmail = new javax.swing.JLabel();
        laCadFuncionario = new javax.swing.JLabel();
        laSelectTurma = new javax.swing.JLabel();
        laSelectFuncionario = new javax.swing.JLabel();
        laSelectAula = new javax.swing.JLabel();
        laSelectAluno = new javax.swing.JLabel();
        laMenuCadastro = new javax.swing.JLabel();
        laCadastro = new javax.swing.JLabel();
        laMenuConsulAlter = new javax.swing.JLabel();
        laConsulAlter = new javax.swing.JLabel();
        lblFrequencia = new javax.swing.JLabel();
        laMenuAniversariantes = new javax.swing.JLabel();
        laAniversariantes = new javax.swing.JLabel();
        laMenuFrequencia = new javax.swing.JLabel();
        laFrequencia = new javax.swing.JLabel();
        laBoMenu = new javax.swing.JLabel();
        laMenu = new javax.swing.JLabel();
        laBackgroud = new javax.swing.JLabel();

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

        laFacebbok.setToolTipText("Acessar  Facebook");
        laFacebbok.setRequestFocusEnabled(false);
        laFacebbok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laFacebbokMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laFacebbokMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laFacebbokMouseExited(evt);
            }
        });
        jPanel1.add(laFacebbok, new org.netbeans.lib.awtextra.AbsoluteConstraints(984, 533, 170, 140));

        laData.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        laData.setForeground(new java.awt.Color(255, 255, 255));
        laData.setText("jLabel1");
        jPanel1.add(laData, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 736, 320, 20));

        laHora.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        laHora.setForeground(new java.awt.Color(255, 255, 255));
        laHora.setText("jLabel1");
        jPanel1.add(laHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 736, 140, 20));

        laCadAluno.setToolTipText("Cadastro Aluno");
        laCadAluno.setRequestFocusEnabled(false);
        laCadAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laCadAlunoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laCadAlunoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laCadAlunoMouseExited(evt);
            }
        });
        jPanel1.add(laCadAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(988, 40, 155, 145));

        laEmail.setToolTipText("Acesar Email");
        laEmail.setRequestFocusEnabled(false);
        laEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laEmailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laEmailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laEmailMouseExited(evt);
            }
        });
        jPanel1.add(laEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1203, 530, 160, 140));

        laCadFuncionario.setToolTipText("Cadastro Funcionário");
        laCadFuncionario.setRequestFocusEnabled(false);
        laCadFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laCadFuncionarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laCadFuncionarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laCadFuncionarioMouseExited(evt);
            }
        });
        jPanel1.add(laCadFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 40, 150, 140));

        laSelectTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laSelectTurmaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laSelectTurmaMouseExited(evt);
            }
        });
        jPanel1.add(laSelectTurma, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 458, 165, 25));
        jPanel1.add(laSelectFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 392, 165, 25));
        jPanel1.add(laSelectAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 425, 165, 25));
        jPanel1.add(laSelectAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 165, 25));

        laMenuCadastro.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        laMenuCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laMenuCadastroMouseExited(evt);
            }
        });
        jPanel1.add(laMenuCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 200, 200));

        laCadastro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        laCadastro.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        laCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laCadastroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laCadastroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laCadastroMouseExited(evt);
            }
        });
        jPanel1.add(laCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 358, 190, 50));

        laMenuConsulAlter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laMenuConsulAlterMouseExited(evt);
            }
        });
        jPanel1.add(laMenuConsulAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 200, 190));

        laConsulAlter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        laConsulAlter.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        laConsulAlter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laConsulAlterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laConsulAlterMouseExited(evt);
            }
        });
        jPanel1.add(laConsulAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 418, 190, 50));

        lblFrequencia.setText("jLabel1");
        jPanel1.add(lblFrequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 370, 170, 140));

        laMenuAniversariantes.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        laMenuAniversariantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laMenuAniversariantesMouseExited(evt);
            }
        });
        jPanel1.add(laMenuAniversariantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 200, 120));

        laAniversariantes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        laAniversariantes.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        laAniversariantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laAniversariantesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laAniversariantesMouseExited(evt);
            }
        });
        jPanel1.add(laAniversariantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 478, 180, 50));
        jPanel1.add(laMenuFrequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, 200, 160));

        laFrequencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        laFrequencia.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        laFrequencia.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        laFrequencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laFrequenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laFrequenciaMouseExited(evt);
            }
        });
        jPanel1.add(laFrequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 540, 190, 50));

        laBoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes/boMenu.png"))); // NOI18N
        laBoMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laBoMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laBoMenuMouseEntered(evt);
            }
        });
        jPanel1.add(laBoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 70, 60));

        laMenu.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        laMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laMenuMouseExited(evt);
            }
        });
        jPanel1.add(laMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 200, 390));

        laBackgroud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Telas Fundo/Fundo.jpg"))); // NOI18N
        laBackgroud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laBackgroudMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laBackgroudMouseEntered(evt);
            }
        });
        jPanel1.add(laBackgroud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void laCadAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laCadAlunoMouseClicked
        new CadastroAluno().setVisible(true);

    }//GEN-LAST:event_laCadAlunoMouseClicked

    private void laFacebbokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laFacebbokMouseClicked
        try {
            Desktop.getDesktop().browse(new URI(
                    "http://www.facebook.com"));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_laFacebbokMouseClicked

    private void laEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laEmailMouseClicked
        try {
            Desktop.getDesktop().browse(new URI(
                    "http://www.hotmail.com"));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_laEmailMouseClicked

    private void laBackgroudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laBackgroudMouseClicked
        fechaMenu();
    }//GEN-LAST:event_laBackgroudMouseClicked

    private void laCadFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laCadFuncionarioMouseClicked
        new CadastroFuncionario().setVisible(true);
    }//GEN-LAST:event_laCadFuncionarioMouseClicked

    private void laCadFuncionarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laCadFuncionarioMouseEntered
        mouseEntra(laCadFuncionario, "/Imagens/botões selecionados/selectCadFunc.png");
    }//GEN-LAST:event_laCadFuncionarioMouseEntered

    private void laCadFuncionarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laCadFuncionarioMouseExited
        mouseSai(laCadFuncionario);
    }//GEN-LAST:event_laCadFuncionarioMouseExited

    private void laCadAlunoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laCadAlunoMouseEntered
        mouseEntra(laCadAluno, "/Imagens/botões selecionados/selectCadAlu.png");

    }//GEN-LAST:event_laCadAlunoMouseEntered

    private void laCadAlunoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laCadAlunoMouseExited
        mouseSai(laCadAluno);
    }//GEN-LAST:event_laCadAlunoMouseExited

    private void laFacebbokMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laFacebbokMouseEntered
        mouseEntra(laFacebbok, "/Imagens/botões selecionados/selectFacebook.png");
    }//GEN-LAST:event_laFacebbokMouseEntered

    private void laFacebbokMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laFacebbokMouseExited
        mouseSai(laFacebbok);
    }//GEN-LAST:event_laFacebbokMouseExited

    private void laEmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laEmailMouseEntered
        mouseEntra(laEmail, "/Imagens/botões selecionados/selectEmail.png");
    }//GEN-LAST:event_laEmailMouseEntered

    private void laEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laEmailMouseExited
        mouseSai(laEmail);
    }//GEN-LAST:event_laEmailMouseExited

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.setExtendedState(Login.ICONIFIED);
        }
    }//GEN-LAST:event_formKeyPressed

    private void laMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laMenuMouseEntered

    }//GEN-LAST:event_laMenuMouseEntered

    private void laMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laMenuMouseExited

    }//GEN-LAST:event_laMenuMouseExited

    private void laBoMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laBoMenuMouseEntered
        enabledSelect();
        mouseEntra(laMenu, "/Imagens/Menu Lateral/menu.png");
    }//GEN-LAST:event_laBoMenuMouseEntered

    private void laBackgroudMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laBackgroudMouseEntered

    }//GEN-LAST:event_laBackgroudMouseEntered

    private void laMenuCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laMenuCadastroMouseExited
        mouseSai(laMenuCadastro);
    }//GEN-LAST:event_laMenuCadastroMouseExited

    private void laCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laCadastroMouseClicked

    }//GEN-LAST:event_laCadastroMouseClicked

    private void laCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laCadastroMouseEntered

        mouseSai(laMenuConsulAlter);
        mouseSai(laMenuAniversariantes);
        mouseEntra(laCadastro, "/Imagens/botões selecionados/selectBoCadastro.png");
        mouseEntra(laMenuCadastro, "/Imagens/Menu Lateral/menuCadastro.png");

    }//GEN-LAST:event_laCadastroMouseEntered

    private void laConsulAlterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laConsulAlterMouseEntered

        mouseSai(laMenuCadastro);
        mouseSai(laMenuAniversariantes);
        mouseEntra(laConsulAlter, "/Imagens/botões selecionados/selectBoConsulAlter.png");
        mouseEntra(laMenuConsulAlter, "/Imagens/Menu Lateral/menuCadastro.png");

    }//GEN-LAST:event_laConsulAlterMouseEntered

    private void laMenuConsulAlterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laMenuConsulAlterMouseExited
        mouseSai(laMenuConsulAlter);
    }//GEN-LAST:event_laMenuConsulAlterMouseExited

    private void laAniversariantesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laAniversariantesMouseEntered

        mouseSai(laMenuConsulAlter);
        mouseSai(laMenuCadastro);
        mouseEntra(laAniversariantes, "/Imagens/botões selecionados/selectBoAniversariantes.png");
        mouseEntra(laMenuAniversariantes, "/Imagens/Menu Lateral/menuAniversariantes.png");

    }//GEN-LAST:event_laAniversariantesMouseEntered

    private void laAniversariantesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laAniversariantesMouseExited
        mouseSai(laAniversariantes);
    }//GEN-LAST:event_laAniversariantesMouseExited

    private void laBoMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laBoMenuMouseClicked
        fechaMenu();
    }//GEN-LAST:event_laBoMenuMouseClicked

    private void laMenuAniversariantesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laMenuAniversariantesMouseExited
        mouseSai(laMenuAniversariantes);
    }//GEN-LAST:event_laMenuAniversariantesMouseExited

    private void laFrequenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laFrequenciaMouseEntered

        mouseSai(laMenuConsulAlter);
        mouseSai(laMenuCadastro);
        mouseSai(laMenuAniversariantes);
        mouseEntra(laFrequencia, "/Imagens/botões selecionados/selectBoFrequencia.png");

    }//GEN-LAST:event_laFrequenciaMouseEntered

    private void laFrequenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laFrequenciaMouseExited
        mouseSai(laFrequencia);
    }//GEN-LAST:event_laFrequenciaMouseExited

    private void laConsulAlterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laConsulAlterMouseExited
        mouseSai(laConsulAlter);
    }//GEN-LAST:event_laConsulAlterMouseExited

    private void laCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laCadastroMouseExited
        mouseSai(laCadastro);
    }//GEN-LAST:event_laCadastroMouseExited

    private void timerHoraOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerHoraOnTime
        Date le_hora = new Date();
        laHora.setText(horaformatada.format(le_hora));
    }//GEN-LAST:event_timerHoraOnTime

    private void laSelectTurmaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laSelectTurmaMouseEntered
        mouseEntra(laSelectTurma, ("" + botaoSelect[5]));
    }//GEN-LAST:event_laSelectTurmaMouseEntered

    private void laSelectTurmaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laSelectTurmaMouseExited
        mouseSai(laSelectTurma);
    }//GEN-LAST:event_laSelectTurmaMouseExited

    private void lblConsultaAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsultaAlunoMouseClicked
new AlteraAluno().setVisible(true);
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
        new AlteraFuncionario().setVisible(true);
    }//GEN-LAST:event_lblConsultaFuncionarioMouseClicked

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel laAniversariantes;
    private javax.swing.JLabel laBackgroud;
    private javax.swing.JLabel laBoMenu;
    private javax.swing.JLabel laCadAluno;
    private javax.swing.JLabel laCadFuncionario;
    private javax.swing.JLabel laCadastro;
    private javax.swing.JLabel laConsulAlter;
    private javax.swing.JLabel laData;
    private javax.swing.JLabel laEmail;
    private javax.swing.JLabel laFacebbok;
    private javax.swing.JLabel laFrequencia;
    private javax.swing.JLabel laHora;
    private javax.swing.JLabel laMenu;
    private javax.swing.JLabel laMenuAniversariantes;
    private javax.swing.JLabel laMenuCadastro;
    private javax.swing.JLabel laMenuConsulAlter;
    private javax.swing.JLabel laMenuFrequencia;
    private javax.swing.JLabel laSelectAluno;
    private javax.swing.JLabel laSelectAula;
    private javax.swing.JLabel laSelectFuncionario;
    private javax.swing.JLabel laSelectTurma;
    private javax.swing.JLabel lblConsultaAluno;
    private javax.swing.JLabel lblConsultaFuncionario;
    private javax.swing.JLabel lblFrequencia;
    private org.netbeans.examples.lib.timerbean.Timer timerHora;
    // End of variables declaration//GEN-END:variables
}
