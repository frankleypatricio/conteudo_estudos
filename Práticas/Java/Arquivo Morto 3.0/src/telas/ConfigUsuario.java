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
import javax.swing.JOptionPane;


public class ConfigUsuario extends javax.swing.JInternalFrame {
    //Variável para saber qual campo foi selecionado
    String campo_select;
    //Variável que guarda a cor dos separadores
    Color sep_color = new Color(255,255,255);
    
    //Criando variável de dados do usuário contendo os dados da linha selecionada
    DadosUser usuario = new DadosUser(Login.username, Login.password);
    //Criando variável para obter o dados do usuário
    UserSQL dados_usuario = new UserSQL();
    
    private void limpar(){
        switch(campo_select){
            case "newemail":
                //Verifica se campo está ativo e limpa o campo se estiver
                if(btn_editemail.isSelected()){
                    txt_newemail.setText("");
                }
                break;
            case "newsenha":
                //Verifica se campo está ativo e limpa o campo se estiver
                if(btn_editsenha.isSelected()){
                    txt_newsenha.setText("");
                }
                break;
            case "atualsenha":
                //Verifica se campo está ativo e limpa o campo se estiver
                if(btn_editemail.isSelected() || btn_editsenha.isSelected()){
                    txt_atualsenha.setText("");
                }
                break;
        }
    }
    
    private void alterarCores(int tema){
        switch(tema){
            case 0: //Blue Metro
                //Alterando cor das variáveis que guardam a cor dos separadores
                sep_color = new Color(255,255,255);
                
                //Alterando cor de fundo
                this.setBackground(new Color(35,46,67));
                //Alterando cor dos botões e campos
                txt_newemail.setBackground(new Color(35,46,67));
                txt_newsenha.setBackground(new Color(35,46,67));
                txt_atualsenha.setBackground(new Color(35,46,67));
                btn_editemail.setBackground(new Color(97,212,197));
                btn_editsenha.setBackground(new Color(97,212,197));
                btn_salvar.setBackground(new Color(6,214,162));
                btn_limpar.setBackground(new Color(97,212,197));
                btn_cancel.setBackground(new Color(204,16,16));
                sep_newemail.setBackground(sep_color);
                sep_newsenha.setBackground(sep_color);
                sep_atualsenha.setBackground(sep_color);
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(255,255,255));
                lbl_newemail.setForeground(new Color(255,255,255));
                lbl_newsenha.setForeground(new Color(255,255,255));
                lbl_atualsenha.setForeground(new Color(255,255,255));
                txt_newemail.setForeground(new Color(255,255,255));
                txt_newsenha.setForeground(new Color(255,255,255));
                txt_atualsenha.setForeground(new Color(255,255,255));
                btn_salvar.setForeground(new Color(255,255,255));
                btn_limpar.setForeground(new Color(255,255,255));
                btn_cancel.setForeground(new Color(0,0,0));
                break;
            case 1: //Dark Metro
                //Alterando cor das variáveis que guardam a cor dos separadores
                sep_color = new Color(22,122,198);
                
                //Alterando cor de fundo
                this.setBackground(new Color(60,63,65));
                //Alterando cor dos botões e campos
                txt_newemail.setBackground(new Color(60,63,65));
                txt_newsenha.setBackground(new Color(60,63,65));
                txt_atualsenha.setBackground(new Color(60,63,65));
                btn_editemail.setBackground(new Color(22,122,198));
                btn_editsenha.setBackground(new Color(22,122,198));
                btn_salvar.setBackground(new Color(6,214,162));
                btn_limpar.setBackground(new Color(22,122,198));
                btn_cancel.setBackground(new Color(204,16,16));
                sep_newemail.setBackground(sep_color);
                sep_newsenha.setBackground(sep_color);
                sep_atualsenha.setBackground(sep_color);
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(255,69,0));
                lbl_newemail.setForeground(new Color(255,69,0));
                lbl_newsenha.setForeground(new Color(255,69,0));
                lbl_atualsenha.setForeground(new Color(255,69,0));
                txt_newemail.setForeground(new Color(255,255,255));
                txt_newsenha.setForeground(new Color(255,255,255));
                txt_atualsenha.setForeground(new Color(255,255,255));
                btn_salvar.setForeground(new Color(255,255,255));
                btn_limpar.setForeground(new Color(255,255,255));
                btn_cancel.setForeground(new Color(0,0,0));
                break;
            case 2: //White Metro
                //Alterando cor das variáveis que guardam a cor dos separadores
                sep_color = new Color(0,0,0);
                
                //Alterando cor de fundo
                this.setBackground(new Color(255,255,255));
                //Alterando cor dos botões e campos
                txt_newemail.setBackground(new Color(255,255,255));
                txt_newsenha.setBackground(new Color(255,255,255));
                txt_atualsenha.setBackground(new Color(255,255,255));
                btn_editemail.setBackground(new Color(122,138,153));
                btn_editsenha.setBackground(new Color(122,138,153));
                btn_salvar.setBackground(new Color(6,214,162));
                btn_limpar.setBackground(new Color(122,138,153));
                btn_cancel.setBackground(new Color(204,16,16));
                sep_newemail.setBackground(sep_color);
                sep_newsenha.setBackground(sep_color);
                sep_atualsenha.setBackground(sep_color);
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(0,0,0));
                lbl_newemail.setForeground(new Color(0,0,0));
                lbl_newsenha.setForeground(new Color(0,0,0));
                lbl_atualsenha.setForeground(new Color(0,0,0));
                txt_newemail.setForeground(new Color(0,0,0));
                txt_newsenha.setForeground(new Color(0,0,0));
                txt_atualsenha.setForeground(new Color(0,0,0));
                btn_salvar.setForeground(new Color(0,0,0));
                btn_limpar.setForeground(new Color(0,0,0));
                btn_cancel.setForeground(new Color(0,0,0));
                break;
        }
    }
    
    private void reloadFields(){
            //Bloquenado campos e botões
            txt_newemail.setEnabled(false);
            txt_newsenha.setEnabled(true);
            txt_atualsenha.setEnabled(false);
            btn_salvar.setEnabled(false);
            //Alterando cor dos separadores
            sep_newemail.setBackground(sep_color);
            sep_newsenha.setBackground(sep_color);
            sep_atualsenha.setBackground(sep_color);
            //Resetando campos
            setEmail();
            txt_newsenha.setText("");
            txt_atualsenha.setText("");
    }
    
    private void setEmail(){
        //Passando para a variável usuário todos os dados do usuário logado para edição
        usuario = dados_usuario.thisSelect(usuario);
        //Definindo no campo novo e-mail o e-mail atual do usuário
        txt_newemail.setText(usuario.getEmail());
    }
    
    public ConfigUsuario() {
        initComponents();
        //Mesclar tecla enter ao botão salvar
        getRootPane().setDefaultButton(btn_salvar);
        
        //Alterar cores
        alterarCores(Login.tema);
        
        //Bloqueando campos e botões
        txt_newemail.setEnabled(false);
        txt_newsenha.setEnabled(false);
        txt_atualsenha.setEnabled(false);
        btn_salvar.setEnabled(false);
        
        //Alterando cores dos separadores, indicando que estão inativos
        sep_newemail.setBackground(new Color(184,207,229));
        sep_newsenha.setBackground(new Color(184,207,229));
        sep_atualsenha.setBackground(new Color(184,207,229));
        
        //Definindo e-mail atual no campo de novo e-mail
        setEmail();
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
        lbl_atualsenha = new javax.swing.JLabel();
        lbl_newsenha = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        sep_atualsenha = new javax.swing.JSeparator();
        sep_newsenha = new javax.swing.JSeparator();
        txt_atualsenha = new javax.swing.JPasswordField();
        txt_newsenha = new javax.swing.JPasswordField();
        lbl_newemail = new javax.swing.JLabel();
        sep_newemail = new javax.swing.JSeparator();
        btn_editsenha = new javax.swing.JToggleButton();
        btn_editemail = new javax.swing.JToggleButton();
        txt_newemail = new javax.swing.JTextField();

        setTitle("Cadastro de Aluno");

        lbl_title.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 54)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Configurações do Usuário");

        lbl_atualsenha.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_atualsenha.setForeground(new java.awt.Color(255, 255, 255));
        lbl_atualsenha.setText("Senha Atual");

        lbl_newsenha.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_newsenha.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newsenha.setText("Nova Senha");

        btn_salvar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btn_salvar.setForeground(new java.awt.Color(255, 255, 255));
        btn_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Salvar.png"))); // NOI18N
        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_limpar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btn_limpar.setForeground(new java.awt.Color(255, 255, 255));
        btn_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Limpar.png"))); // NOI18N
        btn_limpar.setText("Limpar");
        btn_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparActionPerformed(evt);
            }
        });

        btn_cancel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btn_cancel.setForeground(new java.awt.Color(0, 0, 0));
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancelar.png"))); // NOI18N
        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        sep_atualsenha.setBackground(new java.awt.Color(255, 255, 255));

        sep_newsenha.setBackground(new java.awt.Color(255, 255, 255));

        txt_atualsenha.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_atualsenha.setForeground(new java.awt.Color(255, 255, 255));
        txt_atualsenha.setBorder(null);
        txt_atualsenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_atualsenhaMouseClicked(evt);
            }
        });

        txt_newsenha.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_newsenha.setForeground(new java.awt.Color(255, 255, 255));
        txt_newsenha.setBorder(null);
        txt_newsenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_newsenhaMouseClicked(evt);
            }
        });

        lbl_newemail.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_newemail.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newemail.setText("Novo E-Mail");

        sep_newemail.setBackground(new java.awt.Color(255, 255, 255));

        btn_editsenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Editar.png"))); // NOI18N
        btn_editsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editsenhaActionPerformed(evt);
            }
        });

        btn_editemail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Editar.png"))); // NOI18N
        btn_editemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editemailActionPerformed(evt);
            }
        });

        txt_newemail.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_newemail.setBorder(null);
        txt_newemail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_newemailMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btn_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                        .addComponent(btn_limpar)
                        .addGap(166, 166, 166)
                        .addComponent(btn_cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sep_newsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_newsenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_newsenha, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_editsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sep_atualsenha, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                                    .addComponent(lbl_newemail)
                                    .addComponent(sep_newemail, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                                    .addComponent(txt_atualsenha, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                                    .addComponent(lbl_atualsenha)
                                    .addComponent(txt_newemail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_editemail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91)))
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(lbl_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lbl_title)
                .addGap(45, 45, 45)
                .addComponent(lbl_newemail)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_newemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editemail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_newemail, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_newsenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_newsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_newsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(lbl_atualsenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_atualsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_atualsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_limpar)
                    .addComponent(btn_salvar))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setBounds(-5, -30, 1035, 614);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        //Variável recebe número de caracteres que contém na senha
        int senha_size = txt_newsenha.getText().length();
        
        //Verifica se senha digitata tem menos de 8 caracteres ou não
        if(senha_size < 8 && btn_editsenha.isSelected()){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Sua senha deve conter no mínimo 8 caracteres", "Erro ao Realizar Cadastro", JOptionPane.ERROR_MESSAGE);
        }else{
            //Verifica se usuário quer editar o e-mail e a senha e se a confirmação de senha está correta
            if(btn_editemail.isSelected() && btn_editsenha.isSelected() && txt_atualsenha.getText().equals(Login.password)){
                //Verifica se todos os campos estão corretos
                if(txt_newemail.getText().contains("@") && txt_newemail.getText().contains(".com") && !txt_newemail.getText().equals(usuario.getEmail()) && 
                   !txt_newsenha.getText().equals(Login.password) && !txt_newsenha.getText().isEmpty()){
                    //Criando variável para armazenar temporariamente os dados digitados pelo usuário
                    DadosUser user_edit = new DadosUser(usuario.getNome(), txt_newemail.getText(), usuario.getCPF(), txt_newsenha.getText(), usuario.getStatus());
                
                    //Criando variável que fará a conexão com o banco de dados e atualizará os dados do usuário
                    UserSQL sql = new UserSQL();
                
                    //Executando no banco de dados o comando UPDATE com os dados do usuário
                    sql.update(user_edit);
                
                    //Mensagem de sucesso!
                    JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso!!", "Sucesso!!", JOptionPane.INFORMATION_MESSAGE);
                
                    //Atualizando senha atual para confirmações
                    Login.password = txt_newsenha.getText();
                
                    //Recalibrando campos
                    reloadFields();
                }
                //Verifica se e-mail está incorreto
                if(!txt_newemail.getText().contains("@") || !txt_newemail.getText().contains(".com") || txt_newemail.getText().equals(usuario.getEmail())){
                    //Mensagem de erro
                    JOptionPane.showMessageDialog(null, "Digite um E-Mail válido", "Erro ao salvar alterações", JOptionPane.ERROR_MESSAGE);
                }
                //Verifica se senha está incorreta
                if(txt_newsenha.getText().equals(Login.password) || txt_newsenha.getText().isEmpty()){
                    //Mensagem de erro
                    JOptionPane.showMessageDialog(null, "Digite uma senha válida", "Erro ao salvar alterações", JOptionPane.ERROR_MESSAGE);
                }
            }
        
            //Verifica se usuário quer editar apenas o e-mail e se a confirmação de senha está correta
            else if(btn_editemail.isSelected() && !btn_editsenha.isSelected() && txt_atualsenha.getText().equals(Login.password)){
                //Verifica se o campo está correto ou não
                if(txt_newemail.getText().contains("@") && txt_newemail.getText().contains(".com") && !txt_newemail.getText().equals(usuario.getEmail())){
                    //Criando variável para armazenar temporariamente os dados digitados pelo usuário
                    DadosUser user_edit = new DadosUser(usuario.getNome(), txt_newemail.getText(), usuario.getCPF(), usuario.getSenha(), usuario.getStatus());
                
                    //Criando variável que fará a conexão com o banco de dados e atualizará os dados do usuário
                    UserSQL sql = new UserSQL();
                
                    //Executando no banco de dados o comando UPDATE com os dados do usuário
                    sql.update(user_edit);
                
                    //Mensagem de sucesso!
                    JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso!!", "Sucesso!!", JOptionPane.INFORMATION_MESSAGE);
                
                    //Recalibrando campos
                    reloadFields();
                }else{ //if(!txt_newemail.getText().contains("@") || !txt_newemail.getText().contains(".com") || txt_newemail.getText().equals(usuario.getEmail())
                    //Mensagem de erro
                    JOptionPane.showMessageDialog(null, "Digite um E-Mail válido", "Erro ao salvar alterações", JOptionPane.ERROR_MESSAGE);
                }
            }
        
            //Verifica se usuário quer editar apenas a senha e se a confirmação de senha está correta
            else if(!btn_editemail.isSelected() && btn_editsenha.isSelected() && txt_atualsenha.getText().equals(Login.password)){
                //Verifica se o campo está correto ou não
                if(!txt_newsenha.getText().equals(Login.password) && !txt_newsenha.getText().isEmpty()){
                    //Criando variável para armazenar temporariamente os dados digitados pelo usuário
                    DadosUser user_edit = new DadosUser(usuario.getNome(), usuario.getEmail(), usuario.getCPF(), txt_newsenha.getText(), usuario.getStatus());
                
                    //Criando variável que fará a conexão com o banco de dados e atualizará os dados do usuário
                    UserSQL sql = new UserSQL();
                
                    //Executando no banco de dados o comando UPDATE com os dados do usuário
                    sql.update(user_edit);
                
                    //Mensagem de sucesso!
                    JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso!!", "Sucesso!!", JOptionPane.INFORMATION_MESSAGE);
                
                    //Atualizando senha atual para confirmações
                    Login.password = txt_newsenha.getText();
                
                    //Recalibrando campos
                    reloadFields();
                }else{
                    //Mensagem de erro
                    JOptionPane.showMessageDialog(null, "Digite uma senha válida", "Erro ao salvar alterações", JOptionPane.ERROR_MESSAGE);
                }
            }else{ //if(txt_atualsenha.getText().equals(Login.password)
                //Mensagem de erro
                JOptionPane.showMessageDialog(null, "Confirmação de senha não condiz com sua senha atual", "Erro ao salvar alterações", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        //Limpa campo selecionado
        limpar();
    }//GEN-LAST:event_btn_limparActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        //Fechando a tela atual
        dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_editemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editemailActionPerformed
        //Verifica se o botão foi selecionado
        if(btn_editemail.isSelected()){
            //Habilitando campos e botões
            txt_newemail.setEnabled(true);
            txt_atualsenha.setEnabled(true);
            btn_salvar.setEnabled(true);
            //Alterando cor dos separadores
            sep_newemail.setBackground(sep_color);
            sep_atualsenha.setBackground(sep_color);
        }else{
            //Bloquenado campo
            txt_newemail.setEnabled(false);
            //Alterando cor do separador
            sep_newemail.setBackground(new Color(184,207,229));
            //Resetando campo
            txt_newemail.setText(usuario.getEmail());
            //Verifica se o botão de editar senha não está selecionado
            if(!btn_editsenha.isSelected()){
                //Bloquenado campos e botões
                txt_atualsenha.setEnabled(false);
                btn_salvar.setEnabled(false);
                //Alterando cor do separador
                sep_atualsenha.setBackground(new Color(184,207,229));
                //Resetando campo
                txt_atualsenha.setText("");
            }
        }
    }//GEN-LAST:event_btn_editemailActionPerformed

    private void btn_editsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editsenhaActionPerformed
        //Verifica se o botão foi selecionado
        if(btn_editsenha.isSelected()){
            //Habilitando campos e botões
            txt_newsenha.setEnabled(true);
            txt_atualsenha.setEnabled(true);
            btn_salvar.setEnabled(true);
            //Alterando cor dos separadores
            sep_newsenha.setBackground(sep_color);
            sep_atualsenha.setBackground(sep_color);
            //Resetando campo
            txt_newsenha.setText("");
        }else{
            //Bloquenado campo
            txt_newsenha.setEnabled(false);
            //Alterando cor do separador
            sep_newsenha.setBackground(new Color(184,207,229));
            //Resetando campo
            txt_newsenha.setText("");
            //Verifica se o botão de editar senha não está selecionado
            if(!btn_editemail.isSelected()){
                //Bloquenado campos e botões
                txt_atualsenha.setEnabled(false);
                btn_salvar.setEnabled(false);
                //Alterando cor do separador
                sep_atualsenha.setBackground(new Color(184,207,229));
                //Resetando campo
                txt_atualsenha.setText("");
            }
        }
    }//GEN-LAST:event_btn_editsenhaActionPerformed

    private void txt_newemailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_newemailMouseClicked
        //Indica que o campo selecionado foi o do Novo E-Mail
        campo_select = "newemail";
    }//GEN-LAST:event_txt_newemailMouseClicked

    private void txt_newsenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_newsenhaMouseClicked
        //Indica que o campo selecionado foi o da Nova Senha
        campo_select = "newsenha";
    }//GEN-LAST:event_txt_newsenhaMouseClicked

    private void txt_atualsenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_atualsenhaMouseClicked
        //Indica que o campo selecionado foi o da Senha Atual
        campo_select = "atualsenha";
    }//GEN-LAST:event_txt_atualsenhaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JToggleButton btn_editemail;
    private javax.swing.JToggleButton btn_editsenha;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel lbl_atualsenha;
    private javax.swing.JLabel lbl_newemail;
    private javax.swing.JLabel lbl_newsenha;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JSeparator sep_atualsenha;
    private javax.swing.JSeparator sep_newemail;
    private javax.swing.JSeparator sep_newsenha;
    private javax.swing.JPasswordField txt_atualsenha;
    private javax.swing.JTextField txt_newemail;
    private javax.swing.JPasswordField txt_newsenha;
    // End of variables declaration//GEN-END:variables
}
