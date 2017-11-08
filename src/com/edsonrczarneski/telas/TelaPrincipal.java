//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Edson Ricardo Czarneski
//******************************************************
package com.edsonrczarneski.telas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicMenuBarUI;

/**
 *
 * @author Edson Ricardo Czarneski
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        setIcon();
        //Alterando a cor do fundo
        Color corFundo = new Color(201, 218, 255);
        getContentPane().setBackground(corFundo);
        //Alterando cores do menu
        menu.setOpaque(true);
        menu.setUI(new BasicMenuBarUI() {
            public void paint(Graphics g, JComponent c) {

                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });

        menu.setOpaque(true);
        menu.setBackground(Color.CYAN);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        desktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menCad = new javax.swing.JMenu();
        menCadDis = new javax.swing.JMenuItem();
        menExcDis = new javax.swing.JMenuItem();
        menSis = new javax.swing.JMenu();
        menSisSob = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Colégio Variável - Lista de Disciplinas");
        setBackground(new java.awt.Color(255, 255, 153));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        desktop.setPreferredSize(new java.awt.Dimension(589, 450));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Depto: Secretaria");

        lblData.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(102, 102, 102));
        lblData.setText("Data");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edsonrczarneski/icones/logo_escola.png"))); // NOI18N

        menu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menCad.setBackground(new java.awt.Color(255, 255, 153));
        menCad.setForeground(new java.awt.Color(204, 204, 204));
        menCad.setText("Disciplinas");
        menCad.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        menCadDis.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menCadDis.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        menCadDis.setForeground(new java.awt.Color(0, 0, 204));
        menCadDis.setText("Cadastrar");
        menCadDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadDisActionPerformed(evt);
            }
        });
        menCad.add(menCadDis);

        menExcDis.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        menExcDis.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        menExcDis.setForeground(new java.awt.Color(0, 0, 204));
        menExcDis.setText("Modificar/Excluir");
        menExcDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menExcDisActionPerformed(evt);
            }
        });
        menCad.add(menExcDis);

        menu.add(menCad);

        menSis.setForeground(new java.awt.Color(204, 204, 204));
        menSis.setText("Sistema");

        menSisSob.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        menSisSob.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        menSisSob.setForeground(new java.awt.Color(0, 0, 204));
        menSisSob.setText("Sobre");
        menSisSob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menSisSobActionPerformed(evt);
            }
        });
        menSis.add(menSisSob);

        menu.add(menSis);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblData))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(57, 57, 57))
        );

        setSize(new java.awt.Dimension(802, 550));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menSisSobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menSisSobActionPerformed
        // Chamando a tela Sobre
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_menSisSobActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Colocando a data atual do sistema na tela inicial
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void menCadDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadDisActionPerformed
        // Chamando tela de cadastro de disciplinas
        TelaCadastro cadastro = new TelaCadastro();
        cadastro.setVisible(true);
        desktop.add(cadastro);

    }//GEN-LAST:event_menCadDisActionPerformed

    private void menExcDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menExcDisActionPerformed
        // Chamando tela de exclusao ou modificacao
        TelaExcluir excluir = new TelaExcluir();
        excluir.setVisible(true);
        desktop.add(excluir);
    }//GEN-LAST:event_menExcDisActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblData;
    private javax.swing.JMenu menCad;
    private javax.swing.JMenuItem menCadDis;
    private javax.swing.JMenuItem menExcDis;
    private javax.swing.JMenu menSis;
    private javax.swing.JMenuItem menSisSob;
    private javax.swing.JMenuBar menu;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/edsonrczarneski/icones/logo_escola_favicon.png")));
    }
}
