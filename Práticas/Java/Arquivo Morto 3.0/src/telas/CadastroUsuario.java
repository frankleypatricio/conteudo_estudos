/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

//Importação das Bibliotecas usadas

import modelo.DadosUser;
import controle.UserSQL;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class CadastroUsuario extends javax.swing.JInternalFrame {
    /*Variáveis*/
    
    //Variável para saber qual campo foi selecionado
    String campo_select;
    
    private void clear(){
        //Coloca no campo um texto vazio
        txt_nome.setText("");
        txt_email.setText("");
        txt_senha.setText("");
        txt_repsenha.setText("");
        txt_cpf.setText("");
    }
    
    private void alterarCores(int tema){
        switch(tema){
            case 0: //Blue Metro
                //Alterando cor de fundo
                this.setBackground(new Color(35,46,67));
                //Alterando cor dos botões e campos
                txt_nome.setBackground(new Color(35,46,67));
                txt_email.setBackground(new Color(35,46,67));
                txt_senha.setBackground(new Color(35,46,67));
                txt_repsenha.setBackground(new Color(35,46,67));
                txt_cpf.setBackground(new Color(35,46,67));
                btn_salvar.setBackground(new Color(6,214,162));
                btn_limpar.setBackground(new Color(97,212,197));
                btn_novo.setBackground(new Color(97,212,197));
                btn_cancel.setBackground(new Color(204,16,16));
                sep_nome.setBackground(new Color(255,255,255));
                sep_email.setBackground(new Color(255,255,255));
                sep_cpf.setBackground(new Color(255,255,255));
                sep_senha.setBackground(new Color(255,255,255));
                sep_repsenha.setBackground(new Color(255,255,255));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(255,255,255));
                lbl_nome.setForeground(new Color(255,255,255));
                lbl_email.setForeground(new Color(255,255,255));
                lbl_senha.setForeground(new Color(255,255,255));
                lbl_repsenha.setForeground(new Color(255,255,255));
                lbl_cpf.setForeground(new Color(255,255,255));
                txt_nome.setForeground(new Color(255,255,255));
                txt_email.setForeground(new Color(255,255,255));
                txt_senha.setForeground(new Color(255,255,255));
                txt_repsenha.setForeground(new Color(255,255,255));
                txt_cpf.setForeground(new Color(255,255,255));
                btn_salvar.setForeground(new Color(255,255,255));
                btn_limpar.setForeground(new Color(255,255,255));
                btn_novo.setForeground(new Color(255,255,255));
                btn_cancel.setForeground(new Color(0,0,0));
                break;
            case 1: //Dark Metro
                //Alterando cor de fundo
                this.setBackground(new Color(60,63,65));
                //Alterando cor dos botões e campos
                txt_nome.setBackground(new Color(60,63,65));
                txt_email.setBackground(new Color(60,63,65));
                txt_senha.setBackground(new Color(60,63,65));
                txt_repsenha.setBackground(new Color(60,63,65));
                txt_cpf.setBackground(new Color(60,63,65));
                btn_salvar.setBackground(new Color(6,214,162));
                btn_limpar.setBackground(new Color(22,122,198));
                btn_novo.setBackground(new Color(22,122,198));
                btn_cancel.setBackground(new Color(204,16,16));
                sep_nome.setBackground(new Color(22,122,198));
                sep_email.setBackground(new Color(22,122,198));
                sep_cpf.setBackground(new Color(22,122,198));
                sep_senha.setBackground(new Color(22,122,198));
                sep_repsenha.setBackground(new Color(22,122,198));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(255,69,0));
                lbl_nome.setForeground(new Color(255,69,0));
                lbl_email.setForeground(new Color(255,69,0));
                lbl_senha.setForeground(new Color(255,69,0));
                lbl_repsenha.setForeground(new Color(255,69,0));
                lbl_cpf.setForeground(new Color(255,69,0));
                txt_nome.setForeground(new Color(255,255,255));
                txt_email.setForeground(new Color(255,255,255));
                txt_senha.setForeground(new Color(255,255,255));
                txt_repsenha.setForeground(new Color(255,255,255));
                txt_cpf.setForeground(new Color(255,255,255));
                btn_salvar.setForeground(new Color(255,255,255));
                btn_limpar.setForeground(new Color(255,255,255));
                btn_novo.setForeground(new Color(255,255,255));
                btn_cancel.setForeground(new Color(0,0,0));
                break;
            case 2: //White Metro
                //Alterando cor de fundo
                this.setBackground(new Color(255,255,255));
                //Alterando cor dos botões e campos
                txt_nome.setBackground(new Color(255,255,255));
                txt_email.setBackground(new Color(255,255,255));
                txt_senha.setBackground(new Color(255,255,255));
                txt_repsenha.setBackground(new Color(255,255,255));
                txt_cpf.setBackground(new Color(255,255,255));
                btn_salvar.setBackground(new Color(6,214,162));
                btn_limpar.setBackground(new Color(122,138,153));
                btn_novo.setBackground(new Color(122,138,153));
                btn_cancel.setBackground(new Color(204,16,16));
                sep_nome.setBackground(new Color(0,0,0));
                sep_email.setBackground(new Color(0,0,0));
                sep_cpf.setBackground(new Color(0,0,0));
                sep_senha.setBackground(new Color(0,0,0));
                sep_repsenha.setBackground(new Color(0,0,0));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(0,0,0));
                lbl_nome.setForeground(new Color(0,0,0));
                lbl_email.setForeground(new Color(0,0,0));
                lbl_senha.setForeground(new Color(0,0,0));
                lbl_repsenha.setForeground(new Color(0,0,0));
                lbl_cpf.setForeground(new Color(0,0,0));
                txt_nome.setForeground(new Color(0,0,0));
                txt_email.setForeground(new Color(0,0,0));
                txt_senha.setForeground(new Color(0,0,0));
                txt_repsenha.setForeground(new Color(0,0,0));
                txt_cpf.setForeground(new Color(0,0,0));
                btn_salvar.setForeground(new Color(0,0,0));
                btn_limpar.setForeground(new Color(0,0,0));
                btn_novo.setForeground(new Color(0,0,0));
                btn_cancel.setForeground(new Color(0,0,0));
                break;
        }
    }
    
    public CadastroUsuario() {
        initComponents();
        //Mesclar tecla enter ao botão salvar
        getRootPane().setDefaultButton(btn_salvar);
        
        //Alterando cores
        alterarCores(Login.tema);
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
        lbl_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        lbl_cpf = new javax.swing.JLabel();
        txt_cpf = new javax.swing.JFormattedTextField();
        btn_salvar = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();
        btn_novo = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        sep_cpf = new javax.swing.JSeparator();
        sep_email = new javax.swing.JSeparator();
        sep_nome = new javax.swing.JSeparator();
        lbl_senha = new javax.swing.JLabel();
        sep_senha = new javax.swing.JSeparator();
        txt_senha = new javax.swing.JPasswordField();
        sep_repsenha = new javax.swing.JSeparator();
        txt_repsenha = new javax.swing.JPasswordField();
        lbl_repsenha = new javax.swing.JLabel();

        setTitle("Cadastro de Aluno");

        lbl_title.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 54)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Cadastrar Usuário");

        lbl_nome.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_nome.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome.setText("Nome de Usuário*");

        txt_nome.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_nome.setForeground(new java.awt.Color(255, 255, 255));
        txt_nome.setBorder(null);
        txt_nome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_nomeMouseClicked(evt);
            }
        });

        txt_email.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setBorder(null);
        txt_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_emailMouseClicked(evt);
            }
        });

        lbl_email.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_email.setText("E-Mail*");

        lbl_cpf.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_cpf.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cpf.setText("CPF*");

        txt_cpf.setBorder(null);
        txt_cpf.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpf.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_cpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_cpfMouseClicked(evt);
            }
        });

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

        btn_novo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btn_novo.setForeground(new java.awt.Color(255, 255, 255));
        btn_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Novo.png"))); // NOI18N
        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
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

        sep_cpf.setBackground(new java.awt.Color(255, 255, 255));

        sep_email.setBackground(new java.awt.Color(255, 255, 255));

        sep_nome.setBackground(new java.awt.Color(255, 255, 255));

        lbl_senha.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_senha.setForeground(new java.awt.Color(255, 255, 255));
        lbl_senha.setText("Senha*");

        sep_senha.setBackground(new java.awt.Color(255, 255, 255));

        txt_senha.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_senha.setForeground(new java.awt.Color(255, 255, 255));
        txt_senha.setBorder(null);
        txt_senha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_senhaMouseClicked(evt);
            }
        });

        sep_repsenha.setBackground(new java.awt.Color(255, 255, 255));

        txt_repsenha.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_repsenha.setForeground(new java.awt.Color(255, 255, 255));
        txt_repsenha.setBorder(null);
        txt_repsenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_repsenhaMouseClicked(evt);
            }
        });

        lbl_repsenha.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_repsenha.setForeground(new java.awt.Color(255, 255, 255));
        lbl_repsenha.setText("Repita sua Senha*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sep_email, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                        .addComponent(btn_limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_novo)
                        .addGap(214, 214, 214)
                        .addComponent(btn_cancel))
                    .addComponent(txt_nome)
                    .addComponent(sep_nome)
                    .addComponent(txt_email)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_email)
                            .addComponent(lbl_nome))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(lbl_cpf))
                            .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sep_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sep_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_senha))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sep_repsenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_repsenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_repsenha))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_title)
                .addGap(270, 270, 270))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lbl_title)
                .addGap(70, 70, 70)
                .addComponent(lbl_nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbl_email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(sep_email, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_cpf)
                        .addComponent(lbl_senha))
                    .addComponent(lbl_repsenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_repsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sep_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sep_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sep_repsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_novo)
                    .addComponent(btn_limpar)
                    .addComponent(btn_salvar))
                .addGap(15, 15, 15))
        );

        setBounds(-5, -30, 1035, 614);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        //Verificando se há nos campos algum dado já informado
        if(txt_nome.getText().isEmpty() && txt_email.getText().isEmpty() && 
           txt_cpf.getText().equals("   .   .   -  ") && txt_senha.getText().isEmpty() && txt_repsenha.getText().isEmpty()){
            //Fechando a tela atual
            dispose();
        }else{
            //Criando caixa de confirmação
            switch(JOptionPane.showConfirmDialog(null, "Desejas realmente fizalizar esta tela?\n    (Os dados atuais serão perdidos)")){
                case 0: //Sim
                    //Fechando a tela atual
                    dispose();
                    break;
                case 1: //Não
                    break;
                case 2: //Cancelar
                    break;
            }
        }
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        //Variável recebe número de caracteres que contém na senha
        int senha_size = txt_senha.getText().length();
        
        //Verifica se senha digitata tem menos de 8 caracteres ou não
        if(senha_size < 8){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Sua senha deve conter no mínimo 8 caracteres", "Erro ao Realizar Cadastro", JOptionPane.ERROR_MESSAGE);
        }else{
            //Verificando se todos os campos foram preenchidos
            if(!txt_nome.getText().isEmpty() && !txt_email.getText().isEmpty() && txt_email.getText().contains("@") && txt_email.getText().contains(".com")
               & !txt_cpf.getText().equals("   .   .   -  ") && !txt_senha.getText().isEmpty() && !txt_repsenha.getText().isEmpty()){
            
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
                        //Verifica se a confirmação da senha é igual a senha escolhida
                        if(txt_repsenha.getText().equals(txt_senha.getText())){
                            //Criando variável para armazenar temporariamente os dados digitados pelo usuário
                            DadosUser usuario = new DadosUser(txt_nome.getText(),txt_email.getText(),txt_cpf.getText(),txt_senha.getText());
                
                            //Criando variável que fará a conexão com o banco de dados e salvará os dados do usuário no banco
                            UserSQL sql = new UserSQL();
                
                            //Executando no banco de dados o comando INSERT com os dados do usuário
                            sql.insert(usuario);

                            //Resetando campos
                            clear();
                        }else{
                            JOptionPane.showMessageDialog(null, "A senha de confirmação não condiz com a senha escolhida", "Erro ao Realizar Cadastro", JOptionPane.ERROR_MESSAGE);
                        }
                
                    }else{
                        //Mensagem de erro
                        JOptionPane.showMessageDialog(null, "Senha incorreta", "Erro ao Salvar Dados", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }else{
                //Mensagem de erro
                JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente para salvar", "Erro ao Realizar Cadastro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        //Limpando campo selecionado
        switch(campo_select){
            case "nome":
                txt_nome.setText("");
                break;
            case "email":
                txt_email.setText("");
                break;
            case "cpf":
                txt_cpf.setText("");
                break;
            case "senha":
                txt_senha.setText("");
                break;
            case "repsenha":
                txt_repsenha.setText("");
                break;
        }
    }//GEN-LAST:event_btn_limparActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        //Criando caixa de confirmação
        switch(JOptionPane.showConfirmDialog(null, "Desejas realmente iniciar um novo cadastro?\n            (Os dados atuais serão perdidos)")){
            case 0: //Sim
                //Função que reseta o conteúdo de todos os campos
                clear();
                break;
            case 1: //Não
                break;
            case 2: //Cancelar
                break;
        }
    }//GEN-LAST:event_btn_novoActionPerformed

    private void txt_nomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nomeMouseClicked
        //Indica que o campo selecionado foi o de Nome
        campo_select = "nome";
    }//GEN-LAST:event_txt_nomeMouseClicked

    private void txt_emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_emailMouseClicked
        //Indica que o campo selecionado foi o de E-Mail
        campo_select = "email";
    }//GEN-LAST:event_txt_emailMouseClicked

    private void txt_cpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cpfMouseClicked
        //Indica que o campo selecionado foi o de CPF
        campo_select = "cpf";
    }//GEN-LAST:event_txt_cpfMouseClicked

    private void txt_senhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_senhaMouseClicked
        //Indica que o campo selecionado foi o de Senha
        campo_select = "senha";
    }//GEN-LAST:event_txt_senhaMouseClicked

    private void txt_repsenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_repsenhaMouseClicked
        //Indica que o campo selecionado foi o de Repita sua Senha
        campo_select = "repsenha";
    }//GEN-LAST:event_txt_repsenhaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel lbl_cpf;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_repsenha;
    private javax.swing.JLabel lbl_senha;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JSeparator sep_cpf;
    private javax.swing.JSeparator sep_email;
    private javax.swing.JSeparator sep_nome;
    private javax.swing.JSeparator sep_repsenha;
    private javax.swing.JSeparator sep_senha;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JPasswordField txt_repsenha;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables
}
