/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

//Importação das Bibliotecas usadas

import controle.AlunoSQL;
import modelo.DadosAluno;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class CadastroAluno extends javax.swing.JInternalFrame {
    //Variável que seleciona o próximo número a ser cadastrado
    AlunoSQL get_matricula = new AlunoSQL();
    int matricula = 1;
    //Variável que guarda o sexo do aluno
    String sexo = "";
    
    //Variável para saber qual campo foi selecionado
    String campo_select;
    
    private void clear(){
        //Coloca no campo um texto vazio
        txt_nome.setText("");
        txt_resp.setText("");
        txt_datanasc.setText("");
        txt_cpf.setText("");
        txt_id.setText("");
        txt_matricula.setText(String.valueOf(matricula));
        //Declara que o item selecionado é A(representado por 0)
        combo_id.setSelectedIndex(0);
    }
    
    private void verifSexo(){
        //Verificando se cadastro escolhido foi Masculino ou Feminino
        if(Main.sexo == 0){
            //Alterando imagem do botão
            btn_altsex.setIcon(new ImageIcon(getClass().getResource("/imagens/Masculino.png")));
            //Alterando valor da variável sexo
            sexo = "m";
        }else{
            //Alterando imagem do botão
            btn_altsex.setIcon(new ImageIcon(getClass().getResource("/imagens/Feminino.png")));
            //Alterando valor da variável sexo
            sexo = "f";
        }
    }
    
    public void alterarCores(int tema){
        switch(tema){
            case 0: //Blue Metro
                //Alterando cor de fundo
                this.setBackground(new Color(35,46,67));
                //Alterando cor dos botões e campos
                txt_nome.setBackground(new Color(35,46,67));
                txt_resp.setBackground(new Color(35,46,67));
                txt_datanasc.setBackground(new Color(35,46,67));
                txt_cpf.setBackground(new Color(35,46,67));
                txt_id.setBackground(new Color(35,46,67));
                txt_matricula.setBackground(new Color(35,46,67));
                combo_id.setBackground(new Color(97,212,197));
                btn_salvar.setBackground(new Color(6,214,162));
                btn_limpar.setBackground(new Color(97,212,197));
                btn_novo.setBackground(new Color(97,212,197));
                btn_cancel.setBackground(new Color(204,16,16));
                btn_altsex.setBackground(new Color(97,212,197));
                sep_nome.setBackground(new Color(255,255,255));
                sep_resp.setBackground(new Color(255,255,255));
                sep_datanasc.setBackground(new Color(255,255,255));
                sep_cpf.setBackground(new Color(255,255,255));
                sep_id.setBackground(new Color(255,255,255));
                sep_matricula.setBackground(new Color(255,255,255));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(255,255,255));
                lbl_nome.setForeground(new Color(255,255,255));
                lbl_resp.setForeground(new Color(255,255,255));
                lbl_datanasc.setForeground(new Color(255,255,255));
                lbl_cpf.setForeground(new Color(255,255,255));
                lbl_id.setForeground(new Color(255,255,255));
                lbl_matricula.setForeground(new Color(255,255,255));
                txt_nome.setForeground(new Color(255,255,255));
                txt_resp.setForeground(new Color(255,255,255));
                txt_datanasc.setForeground(new Color(255,255,255));
                txt_cpf.setForeground(new Color(255,255,255));
                txt_id.setForeground(new Color(255,255,255));
                txt_matricula.setForeground(new Color(255,255,255));
                combo_id.setForeground(new Color(255,255,255));
                break;
            case 1: //Dark Metro
                //Alterando cor de fundo
                this.setBackground(new Color(60,63,65));
                //Alterando cor dos botões e campos
                txt_nome.setBackground(new Color(60,63,65));
                txt_resp.setBackground(new Color(60,63,65));
                txt_datanasc.setBackground(new Color(60,63,65));
                txt_cpf.setBackground(new Color(60,63,65));
                txt_id.setBackground(new Color(60,63,65));
                txt_matricula.setBackground(new Color(60,63,65));
                combo_id.setBackground(new Color(22,122,198));
                btn_salvar.setBackground(new Color(6,214,162));
                btn_limpar.setBackground(new Color(22,122,198));
                btn_novo.setBackground(new Color(22,122,198));
                btn_cancel.setBackground(new Color(204,16,16));
                btn_altsex.setBackground(new Color(22,122,198));
                sep_nome.setBackground(new Color(22,122,198));
                sep_resp.setBackground(new Color(22,122,198));
                sep_datanasc.setBackground(new Color(22,122,198));
                sep_cpf.setBackground(new Color(22,122,198));
                sep_id.setBackground(new Color(22,122,198));
                sep_matricula.setBackground(new Color(22,122,198));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(255,69,0));
                lbl_nome.setForeground(new Color(255,69,0));
                lbl_resp.setForeground(new Color(255,69,0));
                lbl_datanasc.setForeground(new Color(255,69,0));
                lbl_cpf.setForeground(new Color(255,69,0));
                lbl_id.setForeground(new Color(255,69,0));
                lbl_matricula.setForeground(new Color(255,69,0));
                txt_nome.setForeground(new Color(255,255,255));
                txt_resp.setForeground(new Color(255,255,255));
                txt_datanasc.setForeground(new Color(255,255,255));
                txt_cpf.setForeground(new Color(255,255,255));
                txt_id.setForeground(new Color(255,255,255));
                txt_matricula.setForeground(new Color(255,255,255));
                combo_id.setForeground(new Color(255,255,255));
                break;
            case 2: //White Metro
                //Alterando cor de fundo
                this.setBackground(new Color(255,255,255));
                //Alterando cor dos botões e campos
                txt_nome.setBackground(new Color(255,255,255));
                txt_resp.setBackground(new Color(255,255,255));
                txt_datanasc.setBackground(new Color(255,255,255));
                txt_cpf.setBackground(new Color(255,255,255));
                txt_id.setBackground(new Color(255,255,255));
                txt_matricula.setBackground(new Color(255,255,255));
                combo_id.setBackground(new Color(122,138,153));
                btn_salvar.setBackground(new Color(6,214,162));
                btn_limpar.setBackground(new Color(122,138,153));
                btn_novo.setBackground(new Color(122,138,153));
                btn_cancel.setBackground(new Color(204,16,16));
                btn_altsex.setBackground(new Color(122,138,153));
                sep_nome.setBackground(new Color(0,0,0));
                sep_resp.setBackground(new Color(0,0,0));
                sep_datanasc.setBackground(new Color(0,0,0));
                sep_cpf.setBackground(new Color(0,0,0));
                sep_id.setBackground(new Color(0,0,0));
                sep_matricula.setBackground(new Color(0,0,0));
                //Alterando cor das fontes
                lbl_title.setForeground(new Color(0,0,0));
                lbl_nome.setForeground(new Color(0,0,0));
                lbl_resp.setForeground(new Color(0,0,0));
                lbl_datanasc.setForeground(new Color(0,0,0));
                lbl_cpf.setForeground(new Color(0,0,0));
                lbl_id.setForeground(new Color(0,0,0));
                lbl_matricula.setForeground(new Color(0,0,0));
                txt_nome.setForeground(new Color(0,0,0));
                txt_resp.setForeground(new Color(0,0,0));
                txt_datanasc.setForeground(new Color(0,0,0));
                txt_cpf.setForeground(new Color(0,0,0));
                txt_id.setForeground(new Color(0,0,0));
                txt_matricula.setForeground(new Color(0,0,0));
                combo_id.setForeground(new Color(0,0,0));
                break;
        }
    }
    
    public void setMatricula(){
        //Guardando na variável o valor da matrícula a ser cadastrado
        matricula = get_matricula.selectMatricula();
    }
    
    public CadastroAluno() {
        initComponents();
        //Mesclar tecla enter ao botão salvar
        getRootPane().setDefaultButton(btn_salvar);
        
        //Alterar cores
        alterarCores(Login.tema);
                
        //Verificando se cadastro escolhido foi Masculino ou Feminino
        verifSexo();
        
        //Valores instantâneos
        setMatricula();
        txt_matricula.setText(String.valueOf(matricula));
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
        txt_resp = new javax.swing.JTextField();
        lbl_resp = new javax.swing.JLabel();
        lbl_datanasc = new javax.swing.JLabel();
        txt_datanasc = new javax.swing.JFormattedTextField();
        lbl_cpf = new javax.swing.JLabel();
        txt_cpf = new javax.swing.JFormattedTextField();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        combo_id = new javax.swing.JComboBox<>();
        btn_salvar = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();
        btn_novo = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        sep_datanasc = new javax.swing.JSeparator();
        sep_cpf = new javax.swing.JSeparator();
        sep_resp = new javax.swing.JSeparator();
        sep_nome = new javax.swing.JSeparator();
        sep_id = new javax.swing.JSeparator();
        btn_altsex = new javax.swing.JToggleButton();
        sep_matricula = new javax.swing.JSeparator();
        txt_matricula = new javax.swing.JTextField();
        lbl_matricula = new javax.swing.JLabel();

        setTitle("Cadastro de Aluno");

        lbl_title.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 54)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Cadastrar Aluno");

        lbl_nome.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_nome.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome.setText("Nome do Aluno(a)*");

        txt_nome.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_nome.setForeground(new java.awt.Color(255, 255, 255));
        txt_nome.setBorder(null);
        txt_nome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_nomeMouseClicked(evt);
            }
        });

        txt_resp.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_resp.setForeground(new java.awt.Color(255, 255, 255));
        txt_resp.setBorder(null);
        txt_resp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_respMouseClicked(evt);
            }
        });

        lbl_resp.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_resp.setForeground(new java.awt.Color(255, 255, 255));
        lbl_resp.setText("Nome do Responsável*");

        lbl_datanasc.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_datanasc.setForeground(new java.awt.Color(255, 255, 255));
        lbl_datanasc.setText("Data de Nascimento*");

        txt_datanasc.setBorder(null);
        txt_datanasc.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txt_datanasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_datanasc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_datanasc.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_datanasc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_datanascMouseClicked(evt);
            }
        });

        lbl_cpf.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_cpf.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cpf.setText("CPF");

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

        lbl_id.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        lbl_id.setText("ID*");

        txt_id.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id.setBorder(null);
        txt_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_idMouseClicked(evt);
            }
        });

        combo_id.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        combo_id.setForeground(new java.awt.Color(255, 255, 255));
        combo_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));

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

        sep_datanasc.setBackground(new java.awt.Color(255, 255, 255));

        sep_cpf.setBackground(new java.awt.Color(255, 255, 255));

        sep_resp.setBackground(new java.awt.Color(255, 255, 255));

        sep_nome.setBackground(new java.awt.Color(255, 255, 255));

        sep_id.setBackground(new java.awt.Color(255, 255, 255));

        btn_altsex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_altsexActionPerformed(evt);
            }
        });

        sep_matricula.setBackground(new java.awt.Color(255, 255, 255));

        txt_matricula.setEditable(false);
        txt_matricula.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txt_matricula.setForeground(new java.awt.Color(255, 255, 255));
        txt_matricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_matricula.setBorder(null);

        lbl_matricula.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbl_matricula.setForeground(new java.awt.Color(255, 255, 255));
        lbl_matricula.setText("N° de Matrícula");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sep_resp))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_resp))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lbl_datanasc)
                                        .addGap(156, 156, 156)
                                        .addComponent(lbl_cpf))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sep_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(107, 107, 107)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sep_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(lbl_id))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(combo_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(sep_id, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nome)
                                    .addComponent(lbl_resp))
                                .addGap(0, 740, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_matricula)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sep_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(lbl_title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_altsex, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_limpar)
                        .addGap(6, 6, 6)
                        .addComponent(btn_novo)
                        .addGap(228, 228, 228)
                        .addComponent(btn_cancel))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sep_nome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_nome))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lbl_title))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btn_altsex, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(98, 98, 98)
                .addComponent(lbl_nome)
                .addGap(6, 6, 6)
                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(sep_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbl_resp)
                .addGap(6, 6, 6)
                .addComponent(txt_resp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(sep_resp, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_datanasc)
                                .addComponent(lbl_cpf))
                            .addComponent(lbl_matricula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sep_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sep_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(sep_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_salvar)
                            .addComponent(btn_limpar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_novo)
                                .addComponent(btn_cancel))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(combo_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(sep_id, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        setBounds(-5, -30, 1035, 614);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        //Verificando se o ID é um valor inteiro
        try{
            //Criando variável que recebe o ID para o try-catch verificar se o valor digitado é inteiro ou não
            int id_num = Integer.parseInt(txt_id.getText());
            
            //Verificando se todos os campos foram preenchidos
            if(!txt_nome.getText().isEmpty() && !txt_resp.getText().isEmpty() && 
               !txt_datanasc.getText().equals("  /  /    ") && !txt_id.getText().isEmpty()){
                
                //Criando variável para juntar a parte alfabética do ID com a parte numérica
                String id = combo_id.getSelectedItem() + String.valueOf(id_num);
            
                //Criando variável para armazenar temporariamente os dados digitados pelo usuário
                DadosAluno aluno = new DadosAluno(txt_nome.getText(),txt_resp.getText(),txt_datanasc.getText(),txt_cpf.getText(), id, sexo);
                
                //Criando variável que fará a conexão com o banco de dados e salvará os dados do usuário no banco
                AlunoSQL sql = new AlunoSQL();
                
                //Executando no banco de dados o comando INSERT com os dados do usuário
                sql.insert(aluno);
                
                //Atualizando número da matrícula
                setMatricula();
                
                //Resetando campos
                clear();
            }else{
                //Mensagem de erro
                JOptionPane.showMessageDialog(null, "Preencha todos os campos para salvar", "Erro ao Realizar Cadastro", JOptionPane.ERROR_MESSAGE);
            }   
        }catch(NumberFormatException ex){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "O ID deve ser um valor inteiro", "Erro ao Realizar Cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        //Limpando campo selecionado
        switch(campo_select){
            case "nome":
                txt_nome.setText("");
                break;
            case "resp":
                txt_resp.setText("");
                break;
            case "data":
                txt_datanasc.setText("");
                break;
            case "cpf":
                txt_cpf.setText("");
                break;
            case "id":
                txt_id.setText("");
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

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        //Verificando se há nos campos algum dado já informado
        if(txt_nome.getText().isEmpty() && txt_resp.getText().isEmpty() && 
           txt_datanasc.getText().equals("  /  /    ") && txt_cpf.getText().equals("   .   .   -  ") && txt_id.getText().isEmpty()){
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

    private void btn_altsexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_altsexActionPerformed
        //Verifica se sexo atual está no masculino ou feminino
        if(Main.sexo == 0){
            //Alterando valor de sexo
            Main.sexo = 1;
            //Chamando função para alterar imagem do botão
            verifSexo();
        }else{
            //Alterando valor de sexo
            Main.sexo = 0;
            //Chamando função para alterar imagem do botão
            verifSexo();
        }
    }//GEN-LAST:event_btn_altsexActionPerformed

    private void txt_nomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nomeMouseClicked
        //Indica que o campo selecionado foi o de Nome
        campo_select = "nome";
    }//GEN-LAST:event_txt_nomeMouseClicked

    private void txt_respMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_respMouseClicked
        //Indica que o campo selecionado foi o do Responsável
        campo_select = "resp";
    }//GEN-LAST:event_txt_respMouseClicked

    private void txt_datanascMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_datanascMouseClicked
        //Indica que o campo selecionado foi o da Data de Nascimento
        campo_select = "data";
    }//GEN-LAST:event_txt_datanascMouseClicked

    private void txt_cpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cpfMouseClicked
        //Indica que o campo selecionado foi o do CPF
        campo_select = "cpf";
    }//GEN-LAST:event_txt_cpfMouseClicked

    private void txt_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_idMouseClicked
        //Indica que o campo selecionado foi o do ID
        campo_select = "id";
    }//GEN-LAST:event_txt_idMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_altsex;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JComboBox<String> combo_id;
    private javax.swing.JLabel lbl_cpf;
    private javax.swing.JLabel lbl_datanasc;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_matricula;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_resp;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JSeparator sep_cpf;
    private javax.swing.JSeparator sep_datanasc;
    private javax.swing.JSeparator sep_id;
    private javax.swing.JSeparator sep_matricula;
    private javax.swing.JSeparator sep_nome;
    private javax.swing.JSeparator sep_resp;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JFormattedTextField txt_datanasc;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_matricula;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_resp;
    // End of variables declaration//GEN-END:variables
}
