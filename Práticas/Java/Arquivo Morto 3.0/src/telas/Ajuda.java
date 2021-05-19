/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Frankley
 */
public class Ajuda extends javax.swing.JFrame {

    /*public void alterarCores(){
        //Alterando cor de fundo
        getContentPane().setBackground(new Color(35,46,67));
        //Alterando cor dos botões
        btn_cad1.setBackground(new Color(97,212,197));
        btn_cad2.setBackground(new Color(97,212,197));
        
        btn_cont1.setBackground(new Color(97,212,197));
        btn_cont2.setBackground(new Color(97,212,197));
        
        btn_alun1.setBackground(new Color(97,212,197));
        btn_alun2.setBackground(new Color(97,212,197));
        btn_alun3.setBackground(new Color(97,212,197));
    }*/
    
    private void alterarCores(int tema){
        switch(tema){
            case 0:
                //Alterando cor de fundo
                getContentPane().setBackground(new Color(35,46,67));
                //Alterando cor dos botões
                btn_cad1.setBackground(new Color(97,212,197));
                btn_cad2.setBackground(new Color(97,212,197));
                btn_cont1.setBackground(new Color(97,212,197));
                btn_cont2.setBackground(new Color(97,212,197));
                btn_alun1.setBackground(new Color(97,212,197));
                btn_alun2.setBackground(new Color(97,212,197));
                btn_alun3.setBackground(new Color(97,212,197));
                btn_tema.setBackground(new Color(97,212,197));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(255,255,255));
                lbl_cad.setForeground(new Color(6,214,162));
                lbl_cont.setForeground(new Color(6,214,162));
                lbl_alun.setForeground(new Color(6,214,162));
                lbl_tema.setForeground(new Color(6,214,162));
                btn_cad1.setForeground(new Color(255,255,255));
                btn_cad2.setForeground(new Color(255,255,255));
                btn_cont1.setForeground(new Color(255,255,255));
                btn_cont2.setForeground(new Color(255,255,255));
                btn_alun1.setForeground(new Color(255,255,255));
                btn_alun2.setForeground(new Color(255,255,255));
                btn_alun3.setForeground(new Color(255,255,255));
                btn_tema.setForeground(new Color(255,255,255));
                break;
            case 1:
                //Alterando cor de fundo
                getContentPane().setBackground(new Color(60,63,65));
                //Alterando cor dos botões
                btn_cad1.setBackground(new Color(22,122,198));
                btn_cad2.setBackground(new Color(22,122,198));
                btn_cont1.setBackground(new Color(22,122,198));
                btn_cont2.setBackground(new Color(22,122,198));
                btn_alun1.setBackground(new Color(22,122,198));
                btn_alun2.setBackground(new Color(22,122,198));
                btn_alun3.setBackground(new Color(22,122,198));
                btn_tema.setBackground(new Color(22,122,198));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(255,69,0));
                lbl_cad.setForeground(new Color(6,214,162));
                lbl_cont.setForeground(new Color(6,214,162));
                lbl_alun.setForeground(new Color(6,214,162));
                lbl_tema.setForeground(new Color(6,214,162));
                btn_cad1.setForeground(new Color(255,255,255));
                btn_cad2.setForeground(new Color(255,255,255));
                btn_cont1.setForeground(new Color(255,255,255));
                btn_cont2.setForeground(new Color(255,255,255));
                btn_alun1.setForeground(new Color(255,255,255));
                btn_alun2.setForeground(new Color(255,255,255));
                btn_alun3.setForeground(new Color(255,255,255));
                btn_tema.setForeground(new Color(255,255,255));
                break;
            case 2:
                //Alterando cor de fundo
                getContentPane().setBackground(new Color(255,255,255));
                //Alterando cor dos botões
                btn_cad1.setBackground(new Color(122,138,153));
                btn_cad2.setBackground(new Color(122,138,153));
                btn_cont1.setBackground(new Color(122,138,153));
                btn_cont2.setBackground(new Color(122,138,153));
                btn_alun1.setBackground(new Color(122,138,153));
                btn_alun2.setBackground(new Color(122,138,153));
                btn_alun3.setBackground(new Color(122,138,153));
                btn_tema.setBackground(new Color(122,138,153));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(0,0,0));
                lbl_cad.setForeground(new Color(6,214,162));
                lbl_cont.setForeground(new Color(6,214,162));
                lbl_alun.setForeground(new Color(6,214,162));
                lbl_tema.setForeground(new Color(6,214,162));
                btn_cad1.setForeground(new Color(0,0,0));
                btn_cad2.setForeground(new Color(0,0,0));
                btn_cont1.setForeground(new Color(0,0,0));
                btn_cont2.setForeground(new Color(0,0,0));
                btn_alun1.setForeground(new Color(0,0,0));
                btn_alun2.setForeground(new Color(0,0,0));
                btn_alun3.setForeground(new Color(0,0,0));
                btn_tema.setForeground(new Color(0,0,0));
                break;
        }
    }
    
    public Ajuda() {
        initComponents();
        setLocationRelativeTo(null);
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

        btn_7 = new javax.swing.JButton();
        lbl_title = new javax.swing.JLabel();
        btn_cad1 = new javax.swing.JButton();
        btn_cad2 = new javax.swing.JButton();
        lbl_cad = new javax.swing.JLabel();
        btn_cont1 = new javax.swing.JButton();
        lbl_cont = new javax.swing.JLabel();
        btn_cont2 = new javax.swing.JButton();
        lbl_alun = new javax.swing.JLabel();
        btn_alun1 = new javax.swing.JButton();
        btn_alun2 = new javax.swing.JButton();
        btn_alun3 = new javax.swing.JButton();
        lbl_tema = new javax.swing.JLabel();
        btn_tema = new javax.swing.JButton();

        btn_7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_7.setForeground(new java.awt.Color(255, 255, 255));
        btn_7.setText("Como Alterar Dados");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajuda");
        setResizable(false);

        lbl_title.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Ajuda");

        btn_cad1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_cad1.setForeground(new java.awt.Color(255, 255, 255));
        btn_cad1.setText("Como Cadastrar um Novo Usuário");
        btn_cad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cad1ActionPerformed(evt);
            }
        });

        btn_cad2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_cad2.setForeground(new java.awt.Color(255, 255, 255));
        btn_cad2.setText("Como Cadastrar um Novo Aluno");
        btn_cad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cad2ActionPerformed(evt);
            }
        });

        lbl_cad.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 28)); // NOI18N
        lbl_cad.setForeground(new java.awt.Color(6, 214, 162));
        lbl_cad.setText("Cadastro");

        btn_cont1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_cont1.setForeground(new java.awt.Color(255, 255, 255));
        btn_cont1.setText("Como Alterar Dados do Usuário");
        btn_cont1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cont1ActionPerformed(evt);
            }
        });

        lbl_cont.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 28)); // NOI18N
        lbl_cont.setForeground(new java.awt.Color(6, 214, 162));
        lbl_cont.setText("Conta");

        btn_cont2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_cont2.setForeground(new java.awt.Color(255, 255, 255));
        btn_cont2.setText("Como Ativar e Inativar Usuários");
        btn_cont2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cont2ActionPerformed(evt);
            }
        });

        lbl_alun.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 28)); // NOI18N
        lbl_alun.setForeground(new java.awt.Color(6, 214, 162));
        lbl_alun.setText("Alunos");

        btn_alun1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_alun1.setForeground(new java.awt.Color(255, 255, 255));
        btn_alun1.setText("Como Listar Alunos");
        btn_alun1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alun1ActionPerformed(evt);
            }
        });

        btn_alun2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_alun2.setForeground(new java.awt.Color(255, 255, 255));
        btn_alun2.setText("Como Pesquisar Alunos");
        btn_alun2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alun2ActionPerformed(evt);
            }
        });

        btn_alun3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_alun3.setForeground(new java.awt.Color(255, 255, 255));
        btn_alun3.setText("Como Visualizar e Editar Dados dos Alunos");
        btn_alun3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alun3ActionPerformed(evt);
            }
        });

        lbl_tema.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 28)); // NOI18N
        lbl_tema.setForeground(new java.awt.Color(6, 214, 162));
        lbl_tema.setText("Aparência");

        btn_tema.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_tema.setForeground(new java.awt.Color(255, 255, 255));
        btn_tema.setText("Como Alterar Tema");
        btn_tema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_temaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(lbl_tema)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(lbl_cad))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(lbl_cont))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(lbl_title))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(lbl_alun)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cont2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cont1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cad2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_alun1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                            .addComponent(btn_alun2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_alun3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_tema, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title)
                .addGap(29, 29, 29)
                .addComponent(lbl_cad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cad1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cad2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_cont)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cont1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cont2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_alun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_alun1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_alun2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_alun3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_tema)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_tema)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cad1ActionPerformed
        //Exibindo texto de ajuda
        JOptionPane.showMessageDialog(null, "1- Certifique de estar logado na conta Administradora;\n" +
                                            "2- Na tela principal, vá em \"Opções do Usuário, Cadastrar Usuário;\n" +
                                            "3- Preencha todos os campos corretamente. Os campos marcados com \" * \"(Asterisco) são obrigatórios;\n" +
                                            "4- Clique em \"Salvar\" e confirme a senha do usuário.\n\n" + 
                                            "Obs: Utilize o botão \"Limpar\" para resetar o campo pré-selecionado;\n" +
                                            "          Sua senha deve conter no mínimo 8 caracteres;\n" +
                                            "          Utilize o botão \"Novo\" para resetar todos os campos e iniciar um novo cadastro;\n" +
                                            "          Utilize o botão \"Cancelar\" para cancelar cadastro e fechar a tela atual.",
                                            "Como Cadastrar um Novo Usuário", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_cad1ActionPerformed

    private void btn_cad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cad2ActionPerformed
        //Exibindo texto de ajuda
        JOptionPane.showMessageDialog(null, "1- Pode ser cadastrado por qualquer usuário logado;\n" +
                                            "2- Na tela principal, vá em \"Cadastrar Aluno\" e escolha sua preferência;\n" +
                                            "3- Preencha todos os campos corretamente. Os campos marcados com \" * \"(Asterisco) são obrigatórios;\n" +
                                            "4- Clique em \"Salvar\" para efetuar o cadastro do aluno.\n\n" +
                                            "Obs: Utilize o botão \"Alternar Sexo\", localizado no lado direito no topo da tela, para alternar o sexo de masculino para feminino e vice-versa;\n" +
                                            "          Utilize o botão \"Limpar\" para resetar o campo pré-selecionado;\n" +
                                            "          Utilize o botão \"Novo\" para resetar todos os campos e iniciar um novo cadastro;\n" +
                                            "          Utilize o botão \"Cancelar\" para cancelar cadastro e fechar a tela atual.",
                                            "Como Cadastrar um Novo Aluno", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_cad2ActionPerformed

    private void btn_cont1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cont1ActionPerformed
        //Exibindo texto de ajuda
        JOptionPane.showMessageDialog(null, "1- Na tela principal, vá em \"Cadastrar Aluno, Configurações do Usuário\";\n" +
                                            "2- Caso queira editar o e-mail ou a senha, clique no botão \"Editar\", localizado na frente dos campos \"Novo E-Mail\" e \"Nova Senha\";\n" +
                                            "3- Preencha os campos corretamente com o novo e-mail ou a nova senha;\n" +
                                            "4- Digite sua senha atual no campo \"Senha Atual\" para confirmar se és mesmo o usuário dessa conta;\n" +
                                            "5- Clique em \"Salvar\" para salvar as alterações.\n\n" +
                                            "Obs: Utilize o botão \"Alternar Sexo\" (no lado direito no topo da tela) para alternar\n" +
                                            "          o sexo de masculino para feminino e vice-versa;\n" +
                                            "          Utilize o botão \"Limpar\" para resetar o campo pré-selecionado;\n" +
                                            "          Utilize o botão \"Cancelar\" para cancelar a edição e fechar a tela atual.",
                                            "Como Alterar Dados do Usuário", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_cont1ActionPerformed

    private void btn_cont2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cont2ActionPerformed
        //Exibindo texto de ajuda
        JOptionPane.showMessageDialog(null, "1- Certifique de estar logado na conta Administradora;\n" +
                                            "2- Na tela principal, vá em \"Opções do Usuário, Gerenciar Usuários\";\n" +
                                            "3- Na tabela, irá aparecer todos os usuários cadastrados e seus respectivos dados;\n" +
                                            "4- Para ativar ou inativar um usuário, clique no botão abaixo da tabela, onde estará escrito \"Ativar\" ou \"Inativar\";\n" +
                                            "5- Confirme a senha do usuário para salvar.\n\n" +
                                            "Obs: Utilize o botão \"Cancelar\" para cancelar o gerenciamento e fechar a tela atual.",
                                            "Como Ativar e Inativar Usuários", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_cont2ActionPerformed

    private void btn_alun1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alun1ActionPerformed
        //Exibindo texto de ajuda
        JOptionPane.showMessageDialog(null, "1- Na tela principal, vá em \"Pesquisar Aluno, Pesquisar\";\n" +
                                            "2- Abaixo de \"Pesquisar Aluno\", na aba \"Classificar por\", marque o sexo preferencial;\n" +
                                            "3- Ainda na aba \"Classificar por\", selecione na caixa de combinação a ordem que quer que seja listados;\n" +
                                            "4- Para efetuar a pesquisa, clique no botão \"Pesquisar\" abaixo das caixas de combinação.",
                                            "Como Listar Alunos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_alun1ActionPerformed

    private void btn_alun2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alun2ActionPerformed
        //Exibindo texto de ajuda
        JOptionPane.showMessageDialog(null, "1- Na tela principal, vá em \"Pesquisar Aluno, Pesquisar\";\n" +
                                            "2- Abaixo de \"Pesquisar Aluno\", na aba \"Especificar\", marque se quer especificar nome ou cpf;\n" +
                                            "3- Após marcar a preferência, digite no campo de texto localizado abaixo das mesmas, o nome do aluno ou o cpf.\n" +
                                            "4- Para efetuar a pesquisa, clique no botão \"Pesquisar\" abaixo do campo de texto.\n\n" +
                                            "Obs: Para pesquisar alunos que não tenham CPF, efetue a pesquisa sem passar nenhum valor no campo.",
                                            "Como Pesquisar Alunos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_alun2ActionPerformed

    private void btn_alun3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alun3ActionPerformed
        //Exibindo texto de ajuda
        JOptionPane.showMessageDialog(null, "1- Na tela principal, vá em \"Pesquisar Aluno, Pesquisar\";\n" +
                                            "2- Certifique-se de ter realizado a pesquisa para que apareça os alunos na tabela;\n" +
                                            "3- Para visualizar os dados, vá abaixo de \"Lista de Alunos\", na tabela, selecione o aluno desejado;\n" +
                                            "4- Irá aparecer na aba \"Dados do Aluno\" abaixo da tabela os dados do aluno selecionado;\n" +
                                            "5- Para editar os dados, clique no botão \"Editar\".\n" +
                                            "6- Altere as informações dos campos desejados, clique em \"Salvar\" e confirme a senha do usuário.\n\n" +
                                            "Obs: Utilize o botão \"Cancelar\" para cancelar a edição dos dados do aluno.\n" +
                                            "          Utilize o botão \"Fechar\" para finalizar tela atual.",
                                            "Como Visualizar e Editar Dados dos Alunos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_alun3ActionPerformed

    private void btn_temaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_temaActionPerformed
        //Exibindo texto de ajuda
        JOptionPane.showMessageDialog(null, "Método 1- Na tela de login, selecione na combo box no lado superior esquerdo o tema desejado.\n" +
                                            "Método 2- Na tela principal, em \"Tema\" e selecione o tema desejado.",
                                            "Como Alterar Tema", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_temaActionPerformed

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
            java.util.logging.Logger.getLogger(Ajuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ajuda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_alun1;
    private javax.swing.JButton btn_alun2;
    private javax.swing.JButton btn_alun3;
    private javax.swing.JButton btn_cad1;
    private javax.swing.JButton btn_cad2;
    private javax.swing.JButton btn_cont1;
    private javax.swing.JButton btn_cont2;
    private javax.swing.JButton btn_tema;
    private javax.swing.JLabel lbl_alun;
    private javax.swing.JLabel lbl_cad;
    private javax.swing.JLabel lbl_cont;
    private javax.swing.JLabel lbl_tema;
    private javax.swing.JLabel lbl_title;
    // End of variables declaration//GEN-END:variables
}
