/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import modelo.Tema;
import controle.UserSQL;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Frankley
 */
public class Login extends javax.swing.JFrame {

    /* Variáveis */
    //Variável que guarda o tema definido
    static int tema;
    //Variável que guarda o nome de usuário do último que acessou
    String last_user;
    
    //Variáveis que guardam o nome e senha do usuário que logou no momento
    static String username;
    static String password;
    
    /*private void alterarCores(){
        //Alterando cor de fundo
        getContentPane().setBackground(new Color(35,46,67));
        //Alterando cor dos botões e campos
        txt_user.setBackground(new Color(35,46,67));
        txt_senha.setBackground(new Color(35,46,67));
        btn_entrar.setBackground(new Color(97,212,197));
        btn_limpar.setBackground(new Color(97,212,197));
        btn_exit.setBackground(new Color(204,16,16));
    }*/
    
    public void alterarCores(int tema){
        switch(tema){
            case 0: //Blue Metro
                //Alterando cor de fundo
                getContentPane().setBackground(new Color(35,46,67));
                //Alterando cor dos botões e campos
                txt_user.setBackground(new Color(35,46,67));
                txt_senha.setBackground(new Color(35,46,67));
                btn_entrar.setBackground(new Color(97,212,197));
                btn_limpar.setBackground(new Color(97,212,197));
                btn_exit.setBackground(new Color(204,16,16));
                sep_user.setBackground(new Color(255,255,255));
                sep_senha.setBackground(new Color(255,255,255));
                combo_tema.setBackground(new Color(97,212,197));
                //Alterando cor de fontes
                lbl_title.setForeground(new Color(255,255,255));
                lbl_login.setForeground(new Color(255,255,255));
                lbl_versao.setForeground(new Color(255,255,255));
                lbl_user.setForeground(new Color(255,255,255));
                lbl_senha.setForeground(new Color(255,255,255));
                lbl_tema.setForeground(new Color(255,255,255));
                txt_user.setForeground(new Color(255,255,255));
                txt_senha.setForeground(new Color(255,255,255));
                btn_entrar.setForeground(new Color(255,255,255));
                //Alterando ícones
                lbl_icon.setIcon(new ImageIcon(getClass().getResource("/imagens/Usuários Blue Metro.png")));
                break;
            case 1: //Dark Metro
                //Alterando cor de fundo
                getContentPane().setBackground(new Color(60,63,65));
                //Alterando cor dos botões e campos
                txt_user.setBackground(new Color(60,63,65));
                txt_senha.setBackground(new Color(60,63,65));
                btn_entrar.setBackground(new Color(22,122,198));
                btn_limpar.setBackground(new Color(22,122,198));
                btn_exit.setBackground(new Color(204,16,16));
                sep_user.setBackground(new Color(22,122,198));
                sep_senha.setBackground(new Color(22,122,198));
                combo_tema.setBackground(new Color(22,122,198));
                //Alterando cor de fontes
                lbl_title.setForeground(new Color(255,69,0));
                lbl_login.setForeground(new Color(255,69,0));
                lbl_versao.setForeground(new Color(255,69,0));
                lbl_user.setForeground(new Color(255,69,0));
                lbl_senha.setForeground(new Color(255,69,0));
                lbl_tema.setForeground(new Color(255,69,0));
                txt_user.setForeground(new Color(255,255,255));
                txt_senha.setForeground(new Color(255,255,255));
                btn_entrar.setForeground(new Color(255,255,255));
                //Alterando ícones
                lbl_icon.setIcon(new ImageIcon(getClass().getResource("/imagens/Usuários Dark Metro.png")));
                break;
            case 2: //White Metro
                //Alterando cor de fundo
                getContentPane().setBackground(new Color(255,255,255));
                //Alterando cor dos botões e campos
                txt_user.setBackground(new Color(255,255,255));
                txt_senha.setBackground(new Color(255,255,255));
                btn_entrar.setBackground(new Color(122,138,153));
                btn_limpar.setBackground(new Color(122,138,153));
                btn_exit.setBackground(new Color(204,16,16));
                sep_user.setBackground(new Color(0,0,0));
                sep_senha.setBackground(new Color(0,0,0));
                combo_tema.setBackground(new Color(122,138,153));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(0,0,0));
                lbl_login.setForeground(new Color(0,0,0));
                lbl_versao.setForeground(new Color(0,0,0));
                lbl_user.setForeground(new Color(0,0,0));
                lbl_senha.setForeground(new Color(0,0,0));
                lbl_tema.setForeground(new Color(0,0,0));
                txt_user.setForeground(new Color(0,0,0));
                txt_senha.setForeground(new Color(0,0,0));
                btn_entrar.setForeground(new Color(0,0,0));
                //Alterando ícones
                lbl_icon.setIcon(new ImageIcon(getClass().getResource("/imagens/Usuários White Metro.png")));
                break;
        }
    }
    
    public Login() {
        initComponents();
        //Centraizar Tela
        this.setLocationRelativeTo(null);
        
        //Mesclar tecla enter ao botão entrar
        getRootPane().setDefaultButton(btn_entrar);
        
        //Carregando tema
        Tema load_tema = new Tema();
        tema = load_tema.loadTheme();
        
        //Carregando nome do último usuário acessante
        Tema load_last_user = new Tema();
        last_user = load_last_user.loadUserName();
        //Inserindo nome no campo "usuário"
        txt_user.setText(last_user);
        
        //Alterar cores
        alterarCores(tema);
        
        //Definindo valor inicial da combo_tema referente ao tema definido
        combo_tema.setSelectedIndex(tema);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_versao = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_senha = new javax.swing.JPasswordField();
        lbl_user = new javax.swing.JLabel();
        lbl_senha = new javax.swing.JLabel();
        btn_entrar = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();
        sep_user = new javax.swing.JSeparator();
        sep_senha = new javax.swing.JSeparator();
        lbl_login = new javax.swing.JLabel();
        lbl_icon = new javax.swing.JLabel();
        lbl_title = new javax.swing.JLabel();
        combo_tema = new javax.swing.JComboBox<>();
        lbl_tema = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arquivo Morto - Login");
        setResizable(false);

        lbl_versao.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lbl_versao.setForeground(new java.awt.Color(255, 255, 255));
        lbl_versao.setText("3.0");

        txt_user.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        txt_user.setForeground(new java.awt.Color(255, 255, 255));
        txt_user.setBorder(null);

        txt_senha.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        txt_senha.setForeground(new java.awt.Color(255, 255, 255));
        txt_senha.setBorder(null);

        lbl_user.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(255, 255, 255));
        lbl_user.setText("Usuário");

        lbl_senha.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        lbl_senha.setForeground(new java.awt.Color(255, 255, 255));
        lbl_senha.setText("Senha");

        btn_entrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        btn_entrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_entrar.setText("Entrar");
        btn_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrarActionPerformed(evt);
            }
        });

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fechar.png"))); // NOI18N
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        btn_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Limpar.png"))); // NOI18N
        btn_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparActionPerformed(evt);
            }
        });

        sep_user.setBackground(new java.awt.Color(255, 255, 255));

        sep_senha.setBackground(new java.awt.Color(255, 255, 255));

        lbl_login.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        lbl_login.setForeground(new java.awt.Color(255, 255, 255));
        lbl_login.setText("Login");

        lbl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Usuários.png"))); // NOI18N

        lbl_title.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Arquivo Morto");

        combo_tema.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        combo_tema.setForeground(new java.awt.Color(255, 255, 255));
        combo_tema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blue Metro", "Dark Metro", "White Metro" }));
        combo_tema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_temaActionPerformed(evt);
            }
        });

        lbl_tema.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lbl_tema.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tema.setText("Tema");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbl_icon))
                    .addComponent(lbl_versao))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btn_entrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbl_login))
                            .addComponent(lbl_user)
                            .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sep_user, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sep_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_senha)
                                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 7, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_tema)
                        .addGap(35, 35, 35))
                    .addComponent(combo_tema, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addComponent(lbl_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_title)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_tema)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_tema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lbl_icon))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_login)
                                .addGap(14, 14, 14)
                                .addComponent(lbl_user)
                                .addGap(6, 6, 6)
                                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(sep_user, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_senha)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(6, 6, 6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_limpar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(sep_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_entrar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_versao))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        //Criando caixa de confirmação
        switch(JOptionPane.showConfirmDialog(null, "Desejas realmente finalizar o programa?")){
            case 0: //Sim
                System.exit(0);
                break;
            case 1: //Não
                break;
            case 2: //Cancelar
                break;
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        //Limpando campos
        txt_user.setText("");
        txt_senha.setText("");
    }//GEN-LAST:event_btn_limparActionPerformed

    private void btn_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrarActionPerformed
        //Verifica se campos estão vazios ou não
        if(!txt_user.getText().isEmpty() && !txt_senha.getText().isEmpty()){
            //Criando variável para verificar Login do usuário
            UserSQL check_user = new UserSQL();
            //Variável recebendo resultado da verificação de Login
            int check_result = check_user.selectCheckLogin(txt_user.getText(), txt_senha.getText());
            //Verificando se usuário e senha existem
            switch(check_result){
                case 0:
                    //Mensagem de erro
                    JOptionPane.showMessageDialog(null, "   Falha ao efetuar Login...\nUsuário ou senha incorretos", "Erro!!", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1:
                    //Mensagem de sucesso!!
                    JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!!", "Sucesso!!", JOptionPane.INFORMATION_MESSAGE);
                    
                    //Guardando nome e senha do usuário para verificações na tela principal
                    username = txt_user.getText();
                    password = txt_senha.getText();
            
                    //Guardando nome de usuário do acessante
                    last_user = txt_user.getText();
                    //Criando variável tema para salvar o nome do usuário para quando abrir programa novamente, já iniciar com ele inserido no campo "usuário"
                    Tema save_last_user = new Tema();
                    //Salvando nome do usuário
                    save_last_user.saveUserName(last_user);
            
                    //Fechando tela atual
                    this.dispose();
                    //Abrindo tela Main
                    new Main().setVisible(true);
                    break;
                case 2:
                    //Mensagem de erro
                    JOptionPane.showMessageDialog(null, "Esse usuário se encontra Inativo no momento", "Erro!!", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    //Erro de conexão com o bando de dados
                    break;
            }
        }else{ //if(txt_user.getText().isEmpty() && txt_senha.getText().isEmpty())
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Preencha todos os campos para efetuar o Login", "Erro!!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_entrarActionPerformed

    private void combo_temaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_temaActionPerformed
        //Variável tema recebendo valor selecionado na combo box
        tema = combo_tema.getSelectedIndex();
        
        //Criando variável tema para salvar tema escolhido para quando abrir programa novamente, já iniciar com ele
        Tema change_tema = new Tema();
        //Salvando tema escolhido
        change_tema.changeTheme(tema);
        
        //Alterando cores
        alterarCores(tema);
    }//GEN-LAST:event_combo_temaActionPerformed

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
                if ("Dracula".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JComboBox<String> combo_tema;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JLabel lbl_login;
    private javax.swing.JLabel lbl_senha;
    private javax.swing.JLabel lbl_tema;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JLabel lbl_versao;
    private javax.swing.JSeparator sep_senha;
    private javax.swing.JSeparator sep_user;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
