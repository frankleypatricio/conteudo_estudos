/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import modelo.Tema;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicMenuBarUI;
import static telas.Login.tema;

/**
 *
 * @author Frankley
 */
public class Main extends javax.swing.JFrame {

    /* Variáveis */
    //Criando objeto que recebem as classes
    CadastroAluno cadastroaluno;
    Pesquisa pesquisar;
    CadastroUsuario newuser;
    Gerenciar gerenciar;
    ConfigUsuario configuser;
    Ajuda ajuda;
    //Criando identificador se escolheu cadastro Masculino ou Feminino
    public static int sexo;
    
    private void close(){
        //Fechando telas
        cadastroaluno.dispose();
        pesquisar.dispose();
        newuser.dispose();
        gerenciar.dispose();
        configuser.dispose();
    }
    
    private void alterarCores(int tema){
        switch(tema){
            case 0: //Blue Metro
                //Alterando cores das fontes
                /* Menus */
                menu_useroption.setForeground(new Color(255,255,255));
                menu_cadastro.setForeground(new Color(255,255,255));
                menu_pesquisa.setForeground(new Color(255,255,255));
                menu_info.setForeground(new Color(255,255,255));
                menu_tema.setForeground(new Color(35,46,67));
                /* itens */
                item_newuser.setForeground(new Color(255,255,255));
                item_gereuser.setForeground(new Color(255,255,255));
                item_configuser.setForeground(new Color(255,255,255));
                item_cadastroM.setForeground(new Color(255,255,255));
                item_cadastroF.setForeground(new Color(255,255,255));
                item_pesquisa.setForeground(new Color(255,255,255));
                item_sobre.setForeground(new Color(255,255,255));
                item_ajuda.setForeground(new Color(255,255,255));
                item_bluemetro.setForeground(new Color(255,255,255));
                item_darkmetro.setForeground(new Color(255,255,255));
                item_whitemetro.setForeground(new Color(255,255,255));
                //Alterando cor de fundo
                lbl_fundo.setIcon(new ImageIcon(getClass().getResource("/imagens/Desktop Blue Metro.png")));
                break;
            case 1: //Dark Metro
                //Alterando cores das fontes
                /* Menus */
                menu_useroption.setForeground(new Color(255,255,255));
                menu_cadastro.setForeground(new Color(255,255,255));
                menu_pesquisa.setForeground(new Color(255,255,255));
                menu_info.setForeground(new Color(255,255,255));
                menu_tema.setForeground(new Color(60,63,65));
                /* itens */
                item_newuser.setForeground(new Color(255,255,255));
                item_gereuser.setForeground(new Color(255,255,255));
                item_configuser.setForeground(new Color(255,255,255));
                item_cadastroM.setForeground(new Color(255,255,255));
                item_cadastroF.setForeground(new Color(255,255,255));
                item_pesquisa.setForeground(new Color(255,255,255));
                item_sobre.setForeground(new Color(255,255,255));
                item_ajuda.setForeground(new Color(255,255,255));
                item_bluemetro.setForeground(new Color(255,255,255));
                item_darkmetro.setForeground(new Color(255,255,255));
                item_whitemetro.setForeground(new Color(255,255,255));
                //Alterando cor de fundo
                lbl_fundo.setIcon(new ImageIcon(getClass().getResource("/imagens/Desktop Dark Metro.png")));
                break;
            case 2: //White Metro
                //Alterando cores das fontes
                /* Menus */
                menu_useroption.setForeground(new Color(0,0,0));
                menu_cadastro.setForeground(new Color(0,0,0));
                menu_pesquisa.setForeground(new Color(0,0,0));
                menu_info.setForeground(new Color(0,0,0));
                menu_tema.setForeground(new Color(255,255,255));
                /* itens */
                item_newuser.setForeground(new Color(0,0,0));
                item_gereuser.setForeground(new Color(0,0,0));
                item_configuser.setForeground(new Color(0,0,0));
                item_cadastroM.setForeground(new Color(0,0,0));
                item_cadastroF.setForeground(new Color(0,0,0));
                item_pesquisa.setForeground(new Color(0,0,0));
                item_sobre.setForeground(new Color(0,0,0));
                item_ajuda.setForeground(new Color(0,0,0));
                item_bluemetro.setForeground(new Color(0,0,0));
                item_darkmetro.setForeground(new Color(0,0,0));
                item_whitemetro.setForeground(new Color(0,0,0));
                //Alterando cor de fundo
                lbl_fundo.setIcon(new ImageIcon(getClass().getResource("/imagens/Desktop White Metro.png")));
                break;
        }
    }
    
    private void blockMenuItems(){
        //Verificando qual tema está definido
        switch (Login.tema) {
            case 0:
                //Bloqueando item de seleção do tema
                item_bluemetro.setEnabled(false);
                break;
            case 1:
                //Bloqueando item de seleção do tema
                item_darkmetro.setEnabled(false);
                break;
            case 2:
                //Bloqueando item de seleção do tema
                item_whitemetro.setEnabled(false);
                break;
        }
        
        //Verificando se usuário logado é o administrador
        if(Login.username.equals("admin")){
            //Todas as funções disponíveis
        }else{ //if(!Login.username.equals("admin"))
            //Bloqueando item de cadastro e gerenciamento de usuários
            item_newuser.setEnabled(false);
            item_gereuser.setEnabled(false);
        }
    }
    
    private void saveTheme(){
        //Criando variável tema para salvar tema escolhido para quando abrir programa novamente, já iniciar com ele
        Tema save_tema = new Tema();
        //Salvando tema escolhido
        save_tema.changeTheme(Login.tema);
    }
    
    public Main() {
        initComponents();
        //Centralizar Tela
        this.setLocationRelativeTo(null);
        
        //Criando novo ArrayList para a lista de alunos
        Pesquisa.lista_alunos = new ArrayList();
        
        //Alterando cores
        alterarCores(Login.tema);
        
        //Bloqueando itens do menu
        blockMenuItems();
        
        //Passando novos objetos para as variáveis para não ocorrer erro no método close() e nem no reloadTable()
        cadastroaluno = new CadastroAluno();
        pesquisar = new Pesquisa();
        newuser = new CadastroUsuario();
        gerenciar = new Gerenciar();
        configuser = new ConfigUsuario();
        ajuda = new Ajuda();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        lbl_fundo = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menu_useroption = new javax.swing.JMenu();
        item_newuser = new javax.swing.JMenuItem();
        item_gereuser = new javax.swing.JMenuItem();
        item_configuser = new javax.swing.JMenuItem();
        item_sair = new javax.swing.JMenuItem();
        menu_cadastro = new javax.swing.JMenu();
        item_cadastroM = new javax.swing.JMenuItem();
        item_cadastroF = new javax.swing.JMenuItem();
        menu_pesquisa = new javax.swing.JMenu();
        item_pesquisa = new javax.swing.JMenuItem();
        menu_info = new javax.swing.JMenu();
        item_ajuda = new javax.swing.JMenuItem();
        item_sobre = new javax.swing.JMenuItem();
        menu_tema = new javax.swing.JMenu();
        item_bluemetro = new javax.swing.JMenuItem();
        item_darkmetro = new javax.swing.JMenuItem();
        item_whitemetro = new javax.swing.JMenuItem();
        menu_fechar = new javax.swing.JMenu();
        item_fechar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arquivo Morto - Main");
        setResizable(false);

        desktop.setForeground(new java.awt.Color(0, 0, 0));

        desktop.setLayer(lbl_fundo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );

        menu.setOpaque(true);
        menu.setUI(new BasicMenuBarUI(){
            public void paint(Graphics g, JComponent c){
                if(Login.tema == 0){ //Blue Metro
                    g.setColor(new Color(97,212,197));
                }else if(Login.tema == 1){ //Dark Metro
                    g.setColor(new Color(22,122,198));
                }else{ //if(Login.tema == 2) //White Metro
                    g.setColor(new Color(122,138,153));
                }
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });
        if(Login.tema == 0){ //Blue Metro
            //Cor dos Menus
            menu_useroption.setOpaque(true);
            menu_useroption.setBackground(new Color(97,212,197));
            menu.setOpaque(true);
            menu.setBackground(new Color(97,212,197));
            menu_info.setOpaque(true);
            menu_info.setBackground(new Color(97,212,197));
            menu_fechar.setOpaque(true);
            menu_fechar.setBackground(new Color(97,212,197));
            menu_tema.setBackground(new Color(97,212,197));
            //Cor dos Itens
            item_newuser.setOpaque(true);
            item_newuser.setBackground(new Color(97,212,197));
            item_gereuser.setOpaque(true);
            item_gereuser.setBackground(new Color(97,212,197));
            item_configuser.setOpaque(true);
            item_configuser.setBackground(new Color(97,212,197));
            item_sair.setOpaque(true);
            item_sair.setBackground(new Color(97,212,197));
            item_cadastroM.setOpaque(true);
            item_cadastroM.setBackground(new Color(97,212,197));
            item_cadastroF.setOpaque(true);
            item_cadastroF.setBackground(new Color(97,212,197));
            item_sobre.setOpaque(true);
            item_sobre.setBackground(new Color(97,212,197));
            item_ajuda.setOpaque(true);
            item_ajuda.setBackground(new Color(97,212,197));
            item_pesquisa.setOpaque(true);
            item_pesquisa.setBackground(new Color(97,212,197));
            item_fechar.setOpaque(true);
            item_fechar.setBackground(new Color(97,212,197));
            item_bluemetro.setBackground(new Color(97,212,197));
            item_darkmetro.setBackground(new Color(97,212,197));
            item_whitemetro.setBackground(new Color(97,212,197));
        }else if(Login.tema == 1){ //Dark Metro
            //Cor dos Menus
            menu_useroption.setOpaque(true);
            menu_useroption.setBackground(new Color(22,122,198));
            menu.setOpaque(true);
            menu.setBackground(new Color(22,122,198));
            menu_info.setOpaque(true);
            menu_info.setBackground(new Color(22,122,198));
            menu_fechar.setOpaque(true);
            menu_fechar.setBackground(new Color(22,122,198));
            //Cor dos Itens
            item_newuser.setOpaque(true);
            item_newuser.setBackground(new Color(22,122,198));
            item_gereuser.setOpaque(true);
            item_gereuser.setBackground(new Color(22,122,198));
            item_configuser.setOpaque(true);
            item_configuser.setBackground(new Color(22,122,198));
            item_sair.setOpaque(true);
            item_sair.setBackground(new Color(22,122,198));
            item_cadastroM.setOpaque(true);
            item_cadastroM.setBackground(new Color(22,122,198));
            item_cadastroF.setOpaque(true);
            item_cadastroF.setBackground(new Color(22,122,198));
            item_sobre.setOpaque(true);
            item_sobre.setBackground(new Color(22,122,198));
            item_ajuda.setOpaque(true);
            item_ajuda.setBackground(new Color(22,122,198));
            item_pesquisa.setOpaque(true);
            item_pesquisa.setBackground(new Color(22,122,198));
            item_fechar.setOpaque(true);
            item_fechar.setBackground(new Color(22,122,198));
            item_bluemetro.setBackground(new Color(22,122,198));
            item_darkmetro.setBackground(new Color(22,122,198));
            item_whitemetro.setBackground(new Color(22,122,198));
        }else{ //if(Login.tema == 2) //White Metro
            //Cor dos Menus
            menu_useroption.setOpaque(true);
            menu_useroption.setBackground(new Color(122,138,153));
            menu.setOpaque(true);
            menu.setBackground(new Color(122,138,153));
            menu_info.setOpaque(true);
            menu_info.setBackground(new Color(122,138,153));
            menu_fechar.setOpaque(true);
            menu_fechar.setBackground(new Color(122,138,153));
            //Cor dos Itens
            item_newuser.setOpaque(true);
            item_newuser.setBackground(new Color(122,138,153));
            item_gereuser.setOpaque(true);
            item_gereuser.setBackground(new Color(122,138,153));
            item_configuser.setOpaque(true);
            item_configuser.setBackground(new Color(122,138,153));
            item_sair.setOpaque(true);
            item_sair.setBackground(new Color(122,138,153));
            item_cadastroM.setOpaque(true);
            item_cadastroM.setBackground(new Color(122,138,153));
            item_cadastroF.setOpaque(true);
            item_cadastroF.setBackground(new Color(122,138,153));
            item_sobre.setOpaque(true);
            item_sobre.setBackground(new Color(122,138,153));
            item_ajuda.setOpaque(true);
            item_ajuda.setBackground(new Color(122,138,153));
            item_pesquisa.setOpaque(true);
            item_pesquisa.setBackground(new Color(122,138,153));
            item_fechar.setOpaque(true);
            item_fechar.setBackground(new Color(122,138,153));
            item_bluemetro.setBackground(new Color(122,138,153));
            item_darkmetro.setBackground(new Color(122,138,153));
            item_whitemetro.setBackground(new Color(122,138,153));
        }

        menu_useroption.setForeground(new java.awt.Color(255, 255, 255));
        menu_useroption.setText("Opções do Usuário");
        menu_useroption.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        item_newuser.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_newuser.setForeground(new java.awt.Color(255, 255, 255));
        item_newuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Novo Usuário.png"))); // NOI18N
        item_newuser.setText("Cadastrar Usuário");
        item_newuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_newuserActionPerformed(evt);
            }
        });
        menu_useroption.add(item_newuser);

        item_gereuser.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_gereuser.setForeground(new java.awt.Color(255, 255, 255));
        item_gereuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Gerenciar.png"))); // NOI18N
        item_gereuser.setText("Gerenciar Usuários");
        item_gereuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_gereuserActionPerformed(evt);
            }
        });
        menu_useroption.add(item_gereuser);

        item_configuser.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_configuser.setForeground(new java.awt.Color(255, 255, 255));
        item_configuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Alterar Senha.png"))); // NOI18N
        item_configuser.setText("Configurações do Usuário");
        item_configuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_configuserActionPerformed(evt);
            }
        });
        menu_useroption.add(item_configuser);

        item_sair.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_sair.setForeground(new java.awt.Color(204, 16, 16));
        item_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sair.png"))); // NOI18N
        item_sair.setText("Sair");
        item_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_sairActionPerformed(evt);
            }
        });
        menu_useroption.add(item_sair);

        menu.add(menu_useroption);

        menu_cadastro.setForeground(new java.awt.Color(255, 255, 255));
        menu_cadastro.setText("Cadastrar Aluno");
        menu_cadastro.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        item_cadastroM.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_cadastroM.setForeground(new java.awt.Color(255, 255, 255));
        item_cadastroM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cadastrar Aluno.png"))); // NOI18N
        item_cadastroM.setText("Masculino");
        item_cadastroM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_cadastroMActionPerformed(evt);
            }
        });
        menu_cadastro.add(item_cadastroM);

        item_cadastroF.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_cadastroF.setForeground(new java.awt.Color(255, 255, 255));
        item_cadastroF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cadastrar Aluna.png"))); // NOI18N
        item_cadastroF.setText("Feminino");
        item_cadastroF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_cadastroFActionPerformed(evt);
            }
        });
        menu_cadastro.add(item_cadastroF);

        menu.add(menu_cadastro);

        menu_pesquisa.setForeground(new java.awt.Color(255, 255, 255));
        menu_pesquisa.setText("Pesquisar Aluno");
        menu_pesquisa.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        item_pesquisa.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_pesquisa.setForeground(new java.awt.Color(255, 255, 255));
        item_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pesquisar Miniatura.png"))); // NOI18N
        item_pesquisa.setText("Pesquisar");
        item_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_pesquisaActionPerformed(evt);
            }
        });
        menu_pesquisa.add(item_pesquisa);

        menu.add(menu_pesquisa);

        menu_info.setForeground(new java.awt.Color(255, 255, 255));
        menu_info.setText("Informações");
        menu_info.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        item_ajuda.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_ajuda.setForeground(new java.awt.Color(255, 255, 255));
        item_ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Ajuda.png"))); // NOI18N
        item_ajuda.setText("Ajuda");
        item_ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_ajudaActionPerformed(evt);
            }
        });
        menu_info.add(item_ajuda);

        item_sobre.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_sobre.setForeground(new java.awt.Color(255, 255, 255));
        item_sobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sobre.png"))); // NOI18N
        item_sobre.setText("Sobre");
        item_sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_sobreActionPerformed(evt);
            }
        });
        menu_info.add(item_sobre);

        menu.add(menu_info);

        menu_tema.setForeground(new java.awt.Color(255, 255, 255));
        menu_tema.setText("Tema");
        menu_tema.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        item_bluemetro.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_bluemetro.setForeground(new java.awt.Color(255, 255, 255));
        item_bluemetro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Blue Metro Miniatura.PNG"))); // NOI18N
        item_bluemetro.setText("Blue Metro");
        item_bluemetro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_bluemetroActionPerformed(evt);
            }
        });
        menu_tema.add(item_bluemetro);

        item_darkmetro.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_darkmetro.setForeground(new java.awt.Color(255, 255, 255));
        item_darkmetro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Dark Metro Miniatura.PNG"))); // NOI18N
        item_darkmetro.setText("Dark Metro");
        item_darkmetro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_darkmetroActionPerformed(evt);
            }
        });
        menu_tema.add(item_darkmetro);

        item_whitemetro.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_whitemetro.setForeground(new java.awt.Color(255, 255, 255));
        item_whitemetro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/White Metro Miniatura.PNG"))); // NOI18N
        item_whitemetro.setText("White Metro");
        item_whitemetro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_whitemetroActionPerformed(evt);
            }
        });
        menu_tema.add(item_whitemetro);

        menu.add(menu_tema);

        menu_fechar.setForeground(new java.awt.Color(204, 16, 16));
        menu_fechar.setText("Fechar Programa");
        menu_fechar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        item_fechar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        item_fechar.setForeground(new java.awt.Color(204, 16, 16));
        item_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/X.png"))); // NOI18N
        item_fechar.setText("Fechar");
        item_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_fecharActionPerformed(evt);
            }
        });
        menu_fechar.add(item_fechar);

        menu.add(menu_fechar);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void item_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_sairActionPerformed
        //Criando caixa de confirmação
        switch(JOptionPane.showConfirmDialog(null, "Desejas realmente sair da conta atual?")){
            case 0: //Sim
                //Fechando Janela
                this.dispose();
                //Reabrindo Tela de Login
                new Login().setVisible(true);
                break;
            case 1: //Não
                break;
            case 2: //Cancelar
                break;
        }
    }//GEN-LAST:event_item_sairActionPerformed

    private void item_cadastroMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_cadastroMActionPerformed
        //Fechando classes abertas no Desktop
        close();
        //Indicando à tela que foi escolhido Cadastro Masculino
        sexo = 0;
        //Adicionando classes ao Desktop
        cadastroaluno = new CadastroAluno();
        desktop.add(cadastroaluno);
        cadastroaluno.setVisible(true);
    }//GEN-LAST:event_item_cadastroMActionPerformed

    private void item_cadastroFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_cadastroFActionPerformed
        //Fechando classes abertas no Desktop
        close();
        //Indicando à tela que foi escolhido Cadastro Feminino
        sexo = 1;
        //Adicionando classes ao Desktop
        cadastroaluno = new CadastroAluno();
        desktop.add(cadastroaluno);
        cadastroaluno.setVisible(true);
    }//GEN-LAST:event_item_cadastroFActionPerformed

    private void item_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_pesquisaActionPerformed
        //Fechando classes abertas no Desktop
        close();
        //Adicionando classes ao Desktop
        pesquisar = new Pesquisa();
        desktop.add(pesquisar);
        pesquisar.setVisible(true);
    }//GEN-LAST:event_item_pesquisaActionPerformed

    private void item_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_fecharActionPerformed
        //Criando caixa de confirmação
        switch(JOptionPane.showConfirmDialog(null, "Desejas realmente finalizar o programa?")){
            case 0: //Sim
                //Finalizando Programa
                System.exit(0);
                break;
            case 1: //Não
                break;
            case 2: //Cancelar
                break;
        }
    }//GEN-LAST:event_item_fecharActionPerformed

    private void item_newuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_newuserActionPerformed
        //Fechando classes abertas no Desktop
        close();
        //Adicionando classes ao Desktop
        newuser = new CadastroUsuario();
        desktop.add(newuser);
        newuser.setVisible(true);
    }//GEN-LAST:event_item_newuserActionPerformed

    private void item_gereuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_gereuserActionPerformed
        //Fechando classes abertas no Desktop
        close();
        //Adicionando classes ao Desktop
        gerenciar = new Gerenciar();
        desktop.add(gerenciar);
        gerenciar.setVisible(true);
    }//GEN-LAST:event_item_gereuserActionPerformed

    private void item_configuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_configuserActionPerformed
        //Fechando classes abertas no Desktop
        close();
        //Adicionando classes ao Desktop
        configuser = new ConfigUsuario();
        desktop.add(configuser);
        configuser.setVisible(true);
    }//GEN-LAST:event_item_configuserActionPerformed

    private void item_sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_sobreActionPerformed
        //Exibindo texto sobre o programa
        JOptionPane.showMessageDialog(null, "Arquivo Morto Copyright©2017\n" +
                                            "E.E. Moacyr de Mattos\n" +
                                            "Versão: 3.0\n\n" +
                                            "Desenvolvedores\n" +
                                            "Adelaide\n" +
                                            "Anna\n" +
                                            "Clério\n" +
                                            "Frankley\n" +
                                            "Irene", "Sobre", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_item_sobreActionPerformed

    private void item_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_ajudaActionPerformed
        //Criando variável que recebe a classe Ajuda
        ajuda = new Ajuda();
        //Visibializando a classe Ajuda
        ajuda.setVisible(true);
    }//GEN-LAST:event_item_ajudaActionPerformed

    private void item_bluemetroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_bluemetroActionPerformed
        //Alterando valor da variável teme
        Login.tema = 0;
        
        //Salvando tema
        saveTheme();
        
        //Atualizando tema
        ajuda.dispose();
        this.dispose();
        new Main().setVisible(true);
    }//GEN-LAST:event_item_bluemetroActionPerformed

    private void item_darkmetroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_darkmetroActionPerformed
        //Alterando valor da variável teme
        Login.tema = 1;
        
        //Salvando tema
        saveTheme();
        
        //Atualizando tema
        this.dispose();
        new Main().setVisible(true);
    }//GEN-LAST:event_item_darkmetroActionPerformed

    private void item_whitemetroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_whitemetroActionPerformed
        //Alterando valor da variável teme
        Login.tema = 2;
        
        //Salvando tema
        saveTheme();
        
        //Atualizando tema
        this.dispose();
        new Main().setVisible(true);
    }//GEN-LAST:event_item_whitemetroActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem item_ajuda;
    private javax.swing.JMenuItem item_bluemetro;
    private javax.swing.JMenuItem item_cadastroF;
    private javax.swing.JMenuItem item_cadastroM;
    private javax.swing.JMenuItem item_configuser;
    private javax.swing.JMenuItem item_darkmetro;
    private javax.swing.JMenuItem item_fechar;
    private javax.swing.JMenuItem item_gereuser;
    private javax.swing.JMenuItem item_newuser;
    private javax.swing.JMenuItem item_pesquisa;
    private javax.swing.JMenuItem item_sair;
    private javax.swing.JMenuItem item_sobre;
    private javax.swing.JMenuItem item_whitemetro;
    private javax.swing.JLabel lbl_fundo;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menu_cadastro;
    private javax.swing.JMenu menu_fechar;
    private javax.swing.JMenu menu_info;
    private javax.swing.JMenu menu_pesquisa;
    private javax.swing.JMenu menu_tema;
    private javax.swing.JMenu menu_useroption;
    // End of variables declaration//GEN-END:variables
}
