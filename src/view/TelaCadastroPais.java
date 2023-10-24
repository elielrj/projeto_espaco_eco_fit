/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ITAUTEC
 */
public class TelaCadastroPais extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroPais
     */
    public TelaCadastroPais() {
        initComponents();
        
        jComoBoxStatus.addItem("Sim");
        jComoBoxStatus.addItem("Não");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPainelBotoes = new javax.swing.JPanel();
        novo = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        gravar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        jPanelDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jComoBoxStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulário de Cadastro de ...");
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanelTitulo.setBackground(new java.awt.Color(204, 255, 0));
        jPanelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelTitulo.setPreferredSize(new java.awt.Dimension(533, 75));

        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(51, 0, 153));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("País");
        jLabelTitulo.setPreferredSize(new java.awt.Dimension(533, 50));

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelTitulo, java.awt.BorderLayout.NORTH);

        jPainelBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPainelBotoes.setMinimumSize(new java.awt.Dimension(347, 37));
        jPainelBotoes.setPreferredSize(new java.awt.Dimension(533, 50));

        novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        novo.setText("Novo");
        novo.setPreferredSize(new java.awt.Dimension(90, 30));
        jPainelBotoes.add(novo);

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setEnabled(false);
        cancelar.setIconTextGap(3);
        cancelar.setMaximumSize(new java.awt.Dimension(91, 30));
        cancelar.setMinimumSize(new java.awt.Dimension(91, 24));
        cancelar.setPreferredSize(new java.awt.Dimension(90, 30));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPainelBotoes.add(cancelar);

        gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gravar.png"))); // NOI18N
        gravar.setText("Gravar");
        gravar.setEnabled(false);
        gravar.setPreferredSize(new java.awt.Dimension(90, 30));
        jPainelBotoes.add(gravar);

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.setIconTextGap(3);
        buscar.setPreferredSize(new java.awt.Dimension(90, 30));
        jPainelBotoes.add(buscar);

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.png"))); // NOI18N
        sair.setText("Sair");
        sair.setIconTextGap(3);
        sair.setMaximumSize(new java.awt.Dimension(5, 5));
        sair.setPreferredSize(new java.awt.Dimension(90, 30));
        jPainelBotoes.add(sair);

        getContentPane().add(jPainelBotoes, java.awt.BorderLayout.SOUTH);

        jPanelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelDados.setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setText("Id");

        jLabel2.setText("Nome");

        jLabel3.setText("Name");

        jLabel4.setText("Ativo?");

        jTextFieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdActionPerformed(evt);
            }
        });

        jComoBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComoBoxStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(449, 449, 449))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComoBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(99, 99, 99))))
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComoBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );

        getContentPane().add(jPanelDados, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarActionPerformed

    private void jTextFieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdActionPerformed

    private void jComoBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComoBoxStatusActionPerformed
        //
    }//GEN-LAST:event_jComoBoxStatusActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*jButtonNovoe and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroPais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton gravar;
    private javax.swing.JComboBox<Object> jComoBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPainelBotoes;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JButton novo;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables

    public JButton getBuscar() {
        return buscar;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public JButton getGravar() {
        return gravar;
    }

    public JTextField getjTextFieldId() {
        return jTextFieldId;
    }

    public JTextField getjTextFieldName() {
        return jTextFieldName;
    }

    public JTextField getjTextFieldNome() {
        return jTextFieldNome;
    }

    public JButton getNovo() {
        return novo;
    }

    public JButton getSair() {
        return sair;
    }

    public JComboBox<Object> getjComboBoxStatus() {      
        
        
        
        if(jComoBoxStatus.getSelectedItem() == "Sim"){
             jComoBoxStatus.setSelectedItem(true);
        }else{
            jComoBoxStatus.setSelectedItem(false);
        }
        return jComoBoxStatus;
        
    }

    public JPanel getjPanelDados() {
        return jPanelDados;
    }

  



}
