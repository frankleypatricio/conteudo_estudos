/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

//Variáveis

import modelo.DadosUser;
import controle.UserSQL;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;

public class Gerenciar extends javax.swing.JInternalFrame {
    
    //Criando variável de lista para guardar usuários cadastrados
    ArrayList<DadosUser> lista_users = new ArrayList();
    
    //Criando variável de dados do usuário contendo os dados da linha selecionada
    DadosUser editar = new DadosUser();
    
    private void alterarCores(int tema){
        switch(tema){
            case 0: //Blue Metro
                //Alterando cor de fundo
                this.setBackground(new Color(35,46,67));
                //Alterando cor dos botões e campos
                btn_edit.setBackground(new Color(97,212,197));
                btn_cancel.setBackground(new Color(204,16,16));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(255,255,255));
                btn_edit.setForeground(new Color(255,255,255));
                btn_cancel.setForeground(new Color(0,0,0));
                break;
            case 1: //Dark Metro
                //Alterando cor de fundo
                this.setBackground(new Color(60,63,65));
                //Alterando cor dos botões e campos
                btn_edit.setBackground(new Color(22,122,198));
                btn_cancel.setBackground(new Color(204,16,16));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(255,69,0));
                btn_edit.setForeground(new Color(255,255,255));
                btn_cancel.setForeground(new Color(0,0,0));
                break;
            case 2: //White Metro
                //Alterando cor de fundo
                this.setBackground(new Color(255,255,255));
                //Alterando cor dos botões e campos
                btn_edit.setBackground(new Color(122,138,153));
                btn_cancel.setBackground(new Color(204,16,16));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(0,0,0));
                btn_edit.setForeground(new Color(0,0,0));
                btn_cancel.setForeground(new Color(0,0,0));
                break;
        }
    }
    
    public void reloadTable(){
        //Criando um modelo de tabela
        DefaultTableModel modelo = (DefaultTableModel) tabela_lista.getModel();
        //Declarando 0 linhas para o modelo
        modelo.setNumRows(0);
        
        //Criando variável para carregar dados do usuário
        UserSQL userSQL = new UserSQL();
        
        //Resetando arraylist de usuários
        lista_users = new ArrayList();
        
        //Adicionando informações para cada linha da tabela
        for(DadosUser user : userSQL.select()){
            //Criando objeto que recebe dados a serem inseridos na linha
            Object linha[] = new Object[]{user.getNome(),user.getEmail(),user.getCPF(),user.getStatus()};
            
            //Adicionando usuário na lista de usuários para editar quando selecionar linha
            lista_users.add(user);
            
            //Adicionando linha no modelo da tabela
            modelo.addRow(linha);
        }
        
        //Adicionando modelo na tabela
        tabela_lista.setModel(modelo);
    }
    
    public Gerenciar() {
        initComponents();
        
        //Definindo texto inicial do botão editar e desabilitando o mesmo
        btn_edit.setText("Editar");
        btn_edit.setEnabled(false);
        
        //Alterando cores
        alterarCores(Login.tema);
        
        //Recarregando tabela
        reloadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_title = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_lista = new javax.swing.JTable();
        btn_edit = new javax.swing.JButton();

        setTitle("Cadastro de Aluno");

        lbl_title.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 54)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Gerenciamento de Usuários");

        btn_cancel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btn_cancel.setForeground(new java.awt.Color(0, 0, 0));
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancelar.png"))); // NOI18N
        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        tabela_lista.setForeground(new java.awt.Color(0, 0, 0));
        tabela_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuário", "E-Mail", "CPF", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_lista.getTableHeader().setReorderingAllowed(false);
        tabela_lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_listaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_lista);
        if (tabela_lista.getColumnModel().getColumnCount() > 0) {
            tabela_lista.getColumnModel().getColumn(0).setResizable(false);
            tabela_lista.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabela_lista.getColumnModel().getColumn(1).setResizable(false);
            tabela_lista.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabela_lista.getColumnModel().getColumn(2).setResizable(false);
            tabela_lista.getColumnModel().getColumn(3).setResizable(false);
            tabela_lista.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        btn_edit.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Inativar");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 153, Short.MAX_VALUE)
                .addComponent(lbl_title)
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(btn_edit)
                        .addGap(32, 32, 32)
                        .addComponent(btn_cancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_edit)
                    .addComponent(btn_cancel))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        setBounds(-5, -30, 1035, 614);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        //Fechando tela atual
        dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void tabela_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_listaMouseClicked
        //Criando variável que recebe a linha selecionada
        int line_selected = tabela_lista.getSelectedRow();
        
        //Verificando se linha da tabela selecionada é válida
        if(line_selected >= 0 && line_selected < lista_users.size()){
            //variável recebendo os dados da linha selecionada
            editar = lista_users.get(line_selected);
            
            //Alterando texto do botão conforme os dados do usuário
            if(!editar.getNome().equals("admin") && editar.getStatus().equals("Ativo")){
                btn_edit.setText("Inativar");
                //habilitando botão
                btn_edit.setEnabled(true);
            }else if(!editar.getNome().equals("admin") && editar.getStatus().equals("Inativo")){
                btn_edit.setText("Ativar");
                //habilitando botão
                btn_edit.setEnabled(true);
            }else{ //if(editar.getNome().equals("admin"))
                btn_edit.setText("Editar");
                //habilitando botão
                btn_edit.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tabela_listaMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        //Criando campo de senha
        JPasswordField pf = new JPasswordField();
        //Alinhando texto do campo ao centro
        pf.setHorizontalAlignment(JPasswordField.CENTER);
                
        //Variável recebe resultado da caixa de confirmação (envia quand oaperta o botão ok ou cancel)
        int confirm = JOptionPane.showConfirmDialog(null, pf, "Digite sua senha de usuário", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            //Verifica se apertou botão ok
            if(confirm == JOptionPane.OK_OPTION){
                //Variável recebe senha digitada no campo de senha
                String pass = pf.getText();
                    
                //Verifica se senha digitada corresponde a senha de usuário
                if(pass.equals(Login.password)){
                    //Criando variável que receberar alteração do Status
                    String new_status = "";
        
                    //Verifica Status do usuário selecionado
                    if(editar.getStatus().equals("Ativo")){
                        new_status = "Inativo";
                    }else{ //if(editar.getStatus().equals("Inativo"))
                        new_status = "Ativo";
                    }
        
                    //Criando variável para armazenar temporariamente os dados digitados pelo usuário
                    DadosUser usuario = new DadosUser(editar.getNome(), editar.getEmail(), editar.getCPF(), editar.getSenha(), new_status);
                
                    //Criando variável que fará a conexão com o banco de dados e atualizará os dados do usuário
                    UserSQL sql = new UserSQL();
                
                    //Executando no banco de dados o comando UPDATE com os dados do usuário
                    sql.update(usuario);
        
                    //Atualizando tabela
                    reloadTable();
        
                    //Redefinindo texto e bloqueando botão
                    btn_edit.setText("Editar");
                    btn_edit.setEnabled(false);
                }else{
                    //Mensagem de erro
                    JOptionPane.showMessageDialog(null, "Senha incorreta", "Erro ao Salvar Dados", JOptionPane.ERROR_MESSAGE);
                }
            }
    }//GEN-LAST:event_btn_editActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_edit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JTable tabela_lista;
    // End of variables declaration//GEN-END:variables
}
