//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Edson Ricardo Czarneski
//******************************************************
package com.edsonrczarneski.telas;

import java.sql.*;
import com.edsonrczarneski.dal.ModuloConexao;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//importanto recursos da biblioteca rs2xml.jar
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Edson Ricardo Czarneski
 */
public class TelaExcluir extends javax.swing.JInternalFrame {

    //Usando variável de conexão DAL
    Connection conexao = null;
    //Criando variáveis especiais para BD
    PreparedStatement pst = null;
    ResultSet rst = null;

    /**
     * Creates new form TelaExcluir
     */
    public TelaExcluir() {
        initComponents();
        //Estabelecendo conexao com o BD
        conexao = ModuloConexao.conector();
        //Sobrescrevendo cor de fundo
        Color corFundo = new Color(201, 218, 255);
        getContentPane().setBackground(corFundo);

    }

    //metodo para pesquisa disciplinas com filtro
    private void pesquisaDisciplinas() {
        String sql = "SELECT * FROM modulos WHERE disciplina LIKE ?";
        try {
            pst = conexao.prepareStatement(sql);
            //passando conteudo da caixa de diálogo para o ?
            //ATENCAO para o "%" que está concatenado com a string sql      
            pst.setString(1, txtModDisciplina.getText() + "%");
            rst = pst.executeQuery();
            //Usando a biblioteca rs2xml.jar
            tblDisciplinas.setModel(DbUtils.resultSetToTableModel(rst));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Metodo para setar os campos do formulario com conteudo do BD
    private void setarCampos() {
        int setar = tblDisciplinas.getSelectedRow();
        txtId.setText(tblDisciplinas.getModel().getValueAt(setar, 0).toString());
        txtDisciplina.setText(tblDisciplinas.getModel().getValueAt(setar, 1).toString());
        txtCurso.setText(tblDisciplinas.getModel().getValueAt(setar, 3).toString());
        txtHorario.setText(tblDisciplinas.getModel().getValueAt(setar, 2).toString());
        txtVagas.setText(tblDisciplinas.getModel().getValueAt(setar, 4).toString());        
        cboPeriodo.setSelectedItem(tblDisciplinas.getModel().getValueAt(setar, 5).toString());
        
    }

    //Metodo para alterar dados da disciplina
    private void modificarDados() {
        String sql = "UPDATE modulos set disciplina=?,horario=?,curso=?,vagas=?,periodo=? where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtDisciplina.getText());
            pst.setString(2, txtHorario.getText());
            pst.setString(3, txtCurso.getText());
            pst.setString(4, txtVagas.getText());
            pst.setString(5, cboPeriodo.getSelectedItem().toString());
            pst.setString(6, txtId.getText());
            //Validando dados do formulário
            if ((txtDisciplina.getText().isEmpty()) || (txtHorario.getText().isEmpty()) || (txtCurso.getText().isEmpty()) || (txtVagas.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
            } else {
                int modificar = pst.executeUpdate();
                if (modificar > 0) {
                    JOptionPane.showMessageDialog(null, "Informações da Disciplina alterado com sucesso!");
                    txtDisciplina.setText(null);
                    txtHorario.setText(null);
                    txtCurso.setText(null);
                    txtVagas.setText(null);
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Excluindo dados do BD
    private void remover() {
        //Confirmando a remocao da disciplina

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza de que quer remover esta disciplina?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM modulos WHERE id=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtId.getText());
                int deletado = pst.executeUpdate();
                if (deletado > 0) {
                    JOptionPane.showMessageDialog(null, "Disciplina deletada com sucesso!");
                    txtDisciplina.setText(null);
                    txtHorario.setText(null);
                    txtCurso.setText(null);
                    txtVagas.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

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

        txtModDisciplina = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisciplinas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtDisciplina = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHorario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtVagas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        cboPeriodo = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Modificar/Excluir");
        setPreferredSize(new java.awt.Dimension(589, 450));

        txtModDisciplina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModDisciplinaKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edsonrczarneski/icones/lupa.png"))); // NOI18N

        tblDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDisciplinasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDisciplinas);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Disciplina*");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Curso*");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Carga Horária*");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Vagas*");

        txtVagas.setMinimumSize(new java.awt.Dimension(6, 24));
        txtVagas.setPreferredSize(new java.awt.Dimension(6, 24));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Periodo*");

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edsonrczarneski/icones/folder-update-icon.png"))); // NOI18N
        btnModificar.setToolTipText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edsonrczarneski/icones/delet_icon.png"))); // NOI18N
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Nº");

        txtId.setEnabled(false);

        cboPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "V", "N" }));
        cboPeriodo.setMinimumSize(new java.awt.Dimension(33, 24));
        cboPeriodo.setPreferredSize(new java.awt.Dimension(33, 24));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Legenda Período:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("M - Matutino");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("V - Vespertino");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("N - Noturno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtModDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtVagas, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnModificar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluir)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtHorario)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cboPeriodo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDisciplina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHorario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addComponent(txtCurso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(cboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVagas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        setBounds(0, 0, 589, 450);
    }// </editor-fold>//GEN-END:initComponents
    //Evento do tipo "Enquanto estiver digitando"
    private void txtModDisciplinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModDisciplinaKeyReleased
        pesquisaDisciplinas();
    }//GEN-LAST:event_txtModDisciplinaKeyReleased
    //Evento para setar os campos da tabela 
    private void tblDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDisciplinasMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblDisciplinasMouseClicked
    //Chamando metodo para alterar disciplina
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarDados();
    }//GEN-LAST:event_btnModificarActionPerformed
    //Chamando método para remover disciplinas
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        remover();
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cboPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDisciplinas;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtDisciplina;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtModDisciplina;
    private javax.swing.JTextField txtVagas;
    // End of variables declaration//GEN-END:variables
}
