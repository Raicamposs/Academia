/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.aula;

import gerenciador.conexaoBD.AulaDao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 *
 * @author Raiane
 */
public class AlteraAulaGUI extends javax.swing.JFrame {

    private final Aula aula = new Aula();
    private final AulaDao con = new AulaDao();

    public AlteraAulaGUI() {
        initComponents();

    }

    private void setLambel() {
        edtNome.setText(aula.getNome());
        edtCodigo.setText("" + aula.getId());
        edtValor.setText(("R$ " + aula.getValor()).replace(".", ","));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        edtCodigo = new javax.swing.JTextField();
        edtNome = new javax.swing.JTextField();
        edtValor = new javax.swing.JTextField();
        pnlBotoes = new javax.swing.JPanel();
        boVolta = new javax.swing.JButton();
        boAltera = new javax.swing.JButton();
        boConfirma = new javax.swing.JButton();
        boHome = new javax.swing.JButton();
        boNext = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Autor");
        setLocation(new java.awt.Point(300, 200));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(406, 367));

        pnlPrincipal.setBackground(new java.awt.Color(102, 102, 102));
        pnlPrincipal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlPrincipalAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblNome.setForeground(new java.awt.Color(51, 255, 0));
        lblNome.setText("Nome:");

        lblValor.setForeground(new java.awt.Color(51, 255, 0));
        lblValor.setText("Valor:");

        lblCodigo.setForeground(new java.awt.Color(51, 255, 0));
        lblCodigo.setText("Codigo:");

        pnlBotoes.setBackground(new java.awt.Color(102, 102, 102));
        pnlBotoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));

        boVolta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/055.png"))); // NOI18N
        boVolta.setToolTipText("");
        boVolta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boVoltaActionPerformed(evt);
            }
        });

        boAltera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes/pen.png"))); // NOI18N
        boAltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boAlteraActionPerformed(evt);
            }
        });

        boConfirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/023.png"))); // NOI18N
        boConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boConfirmaActionPerformed(evt);
            }
        });

        boHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/046.png"))); // NOI18N
        boHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boHomeActionPerformed(evt);
            }
        });

        boNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/056.png"))); // NOI18N
        boNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boVolta)
                .addGap(18, 18, 18)
                .addComponent(boAltera)
                .addGap(18, 18, 18)
                .addComponent(boConfirma)
                .addGap(18, 18, 18)
                .addComponent(boHome)
                .addGap(18, 18, 18)
                .addComponent(boNext)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlBotoesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {boAltera, boVolta});

        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boVolta)
                    .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(boAltera)
                        .addComponent(boConfirma)
                        .addComponent(boHome)
                        .addComponent(boNext)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBotoesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {boAltera, boVolta});

        btnPesquisar.setBackground(new java.awt.Color(0, 153, 0));
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigo)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(edtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(8, 8, 8)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(lblValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    private void pnlPrincipalAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlPrincipalAncestorAdded
        edtNome.setFocusable(true);
        edtValor.setEditable(false);
        boAltera.setEnabled(false);
        boNext.setEnabled(false);
        boVolta.setEnabled(false);
        boConfirma.setEnabled(false);
    }//GEN-LAST:event_pnlPrincipalAncestorAdded

    private void boAlteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boAlteraActionPerformed

        edtValor.setEditable(true);
        edtNome.setEditable(true);
        boConfirma.setEnabled(true);


    }//GEN-LAST:event_boAlteraActionPerformed

    private void boConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boConfirmaActionPerformed

        try {
            aula.setNome(edtNome.getText());
            aula.setValor(Float.parseFloat((edtValor.getText().replace(",", ".")).replace("R$ ", "")));
            con.updateAula(aula);

            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(AlteraAulaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_boConfirmaActionPerformed

    private void boHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boHomeActionPerformed

        dispose();

    }//GEN-LAST:event_boHomeActionPerformed

    private void boNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boNextActionPerformed
        try {
            con.consultaNext(aula);
            setLambel();
        } catch (SQLException ex) {
            dispose();

        }
    }//GEN-LAST:event_boNextActionPerformed

    private void boVoltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boVoltaActionPerformed
        try {
            con.consultaLast(aula);
            setLambel();
        } catch (SQLException ex) {
            dispose();

        }
    }//GEN-LAST:event_boVoltaActionPerformed

    private void btnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseClicked

        if (!edtCodigo.getText().equals("")) {
            if (isNumber(edtCodigo.getText())) {

                boAltera.setEnabled(true);
                boNext.setEnabled(true);
                boVolta.setEnabled(true);
                edtCodigo.setEditable(false);
                edtNome.setEditable(false);
                btnPesquisar.setEnabled(false);

                try {
                    int id = Integer.parseInt(edtCodigo.getText());
                    con.consultaID(aula, id);
                    setLambel();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro na execução:" + ex);
                    edtCodigo.setText("");
                    System.exit(0);
                }
            } else {
                edtCodigo.setText("");
                JOptionPane.showMessageDialog(null, "Aula nâo Cadastrada!");
            }

        } else if (!edtNome.getText().equals("")) {

            boAltera.setEnabled(true);
            boNext.setEnabled(true);
            boVolta.setEnabled(true);
            edtCodigo.setEditable(false);
            edtNome.setEditable(false);
            btnPesquisar.setEnabled(false);

            con.consultaNome(edtNome.getText(), aula);
            setLambel();

        } else {
            JOptionPane.showMessageDialog(null, "Insira um Argumento Valido!");
            edtCodigo.setText("");
        }

    }//GEN-LAST:event_btnPesquisarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlteraAulaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boAltera;
    private javax.swing.JButton boConfirma;
    private javax.swing.JButton boHome;
    private javax.swing.JButton boNext;
    private javax.swing.JButton boVolta;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JTextField edtCodigo;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtValor;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
