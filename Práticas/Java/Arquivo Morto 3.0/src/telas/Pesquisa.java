/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

//Variáveis

import controle.AlunoSQL;
import modelo.DadosAluno;
import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;


public class Pesquisa extends javax.swing.JInternalFrame {
    //Manipulador do método buttonFunction()
    String button;
    //ArrayList que guarda os dados salvos do alunos podendo ser usada em outras classes sem necessidade de instanciar a mesma
    public static ArrayList <DadosAluno> lista_alunos;
    //Criando variável de dados do aluno contendo os dados da linha selecionada
    DadosAluno editar = new DadosAluno();
    //Variável para guardar o sexo do aluno
    String sexo = ""; 
    
    private void reloadTable(){
        //Criando um modelo de tabela
        DefaultTableModel modelo = (DefaultTableModel) tabela_lista.getModel();
        //Declarando 0 linhas para o modelo
        modelo.setNumRows(0);

        //Adicionando informações para cada linha da tabela
        for(int i=0;i<lista_alunos.size();i++){
            //Criando objeto que recebe dados a serem inseridos na linha
            Object linha[] = new Object[]{lista_alunos.get(i).getNome(), lista_alunos.get(i).getDatanasc(), lista_alunos.get(i).getCPF(), lista_alunos.get(i).getMatricula()};
            
            //Adicionando linha no modelo da tabela
            modelo.addRow(linha);
        }
        
        //Adicionando modelo na tabela
        tabela_lista.setModel(modelo);
    }
    
    //Criando função para usar nos botões
    private void buttonFunction(String button){
        switch(button){
            case "edit":
                //Desbloqueando campos
                btn_save.setEnabled(true);
                btn_cancel.setEnabled(true);
        
                txt_nome.setEnabled(true);
                txt_resp.setEnabled(true);
                txt_datanasc.setEnabled(true);
                txt_cpf.setEnabled(true);
                combo_id.setEnabled(true);
                txt_id.setEnabled(true);
                //Bloqueando campos
                btn_edit.setEnabled(false);
                break;
            case "cancel/save":
                //Bloqueando campos
                btn_save.setEnabled(false);
                btn_cancel.setEnabled(false);
        
                txt_nome.setEnabled(false);
                txt_resp.setEnabled(false);
                txt_datanasc.setEnabled(false);
                txt_cpf.setEnabled(false);
                combo_id.setEnabled(false);
                txt_id.setEnabled(false);
                //Desbloqueando campos
                btn_edit.setEnabled(true);
                break;
            case "select":
                //Desbloqueando campo
                btn_edit.setEnabled(true);
                break;
            case "reset":
                //Guardando valor int da linha selecionada
                int line_selected = tabela_lista.getSelectedRow();
                //Variável que guarda o numero da opção selecionada da combo box
                int index_id = 0;
                //Criando variável de Departamento contendo os dados da linha selecionada
                DadosAluno editar = lista_alunos.get(line_selected);
                
                //Obtendo id do aluno
                String num_id = editar.getID();
                //Obtendo letra do id
                char char_id = num_id.charAt(0);
                //Removendo letra do id
                num_id = num_id.substring(1);
                
                //Variável para indicar o número da index da combo box
                int i = 0;
                //Laço para encontrar valor da index referente ao caracter do id do aluno
                for(char ch='A';ch<='Z';ch++){
                    //Verificando se o caracter do id do aluno é igual letra atual do laço
                    if(char_id == ch){
                        //Passando o valor de i para a index_id
                        index_id = i;
                        //Finalizando laço
                        break;
                    }
                //Acrecentando +1 na variável i
                i++;
                }
            
                //Adicionando dados nos campos
                txt_nome.setText(editar.getNome());
                txt_resp.setText(editar.getResp());
                txt_datanasc.setText(editar.getDatanasc());
                txt_cpf.setText(editar.getCPF());
                combo_id.setSelectedIndex(index_id);
                txt_id.setText(num_id);
                
                //Bloqueando campos
                btn_save.setEnabled(false);
                btn_cancel.setEnabled(false);
        
                txt_nome.setEnabled(false);
                txt_resp.setEnabled(false);
                txt_datanasc.setEnabled(false);
                txt_cpf.setEnabled(false);
                combo_id.setEnabled(false);
                txt_id.setEnabled(false);
                //Desbloqueando campos
                btn_edit.setEnabled(true);
                break;
        }
    }
    
    public void alterarCores(int tema){
        //Criando variável que guarda as bordas com título
        TitledBorder border1 = BorderFactory.createTitledBorder("Classificar por");
        TitledBorder border2 = BorderFactory.createTitledBorder("Especificar");
        TitledBorder border3 = BorderFactory.createTitledBorder("Dados do Aluno");
        
        switch(tema){
            case 0:
                //Alterando cor de fundo
                this.setBackground(new Color(35,46,67));
                //Alterando cor dos botões e campos
                /* Aba Pesquisar */
                txt_espe.setBackground(new Color(35,46,67));
                btn_pesquisar1.setBackground(new Color(97,212,197));
                btn_pesquisar2.setBackground(new Color(97,212,197));
                combo_classif.setBackground(new Color(97,212,197));
                painel1.setBackground(new Color(35,46,67));
                painel2.setBackground(new Color(35,46,67));
                radio_male.setBackground(new Color(35,46,67));
                radio_female.setBackground(new Color(35,46,67));
                radio_nome.setBackground(new Color(35,46,67));
                radio_cpf.setBackground(new Color(35,46,67));
                sep_espe.setBackground(new Color(255,255,255));
                sep_abas.setBackground(new Color(255,255,255));
                /* Aba Lista de Alunos */
                txt_nome.setBackground(new Color(35,46,67));
                txt_resp.setBackground(new Color(35,46,67));
                txt_datanasc.setBackground(new Color(35,46,67));
                txt_cpf.setBackground(new Color(35,46,67));
                combo_id.setBackground(new Color(97,212,197));
                txt_id.setBackground(new Color(35,46,67));
                txt_matricula.setBackground(new Color(35,46,67));
                painel3.setBackground(new Color(35,46,67));
                btn_sexo.setBackground(new Color(97,212,197));
                btn_save.setBackground(new Color(6,214,162));
                btn_cancel.setBackground(new Color(239,58,58));
                btn_edit.setBackground(new Color(97,212,197));
                btn_fechar.setBackground(new Color(204,16,16));
                sep_nome.setBackground(new Color(255,255,255));
                sep_resp.setBackground(new Color(255,255,255));
                sep_datanasc.setBackground(new Color(255,255,255));
                sep_cpf.setBackground(new Color(255,255,255));
                sep_id.setBackground(new Color(255,255,255));
                sep_matricula.setBackground(new Color(255,255,255));
                //Alterando cor das fontes
                /* Aba Pesquisar */
                lbl_title1.setForeground(new Color(255,255,255));
                txt_espe.setForeground(new Color(255,255,255));
                combo_classif.setForeground(new Color(255,255,255));
                radio_male.setForeground(new Color(255,255,255));
                radio_female.setForeground(new Color(255,255,255));
                radio_nome.setForeground(new Color(255,255,255));
                radio_cpf.setForeground(new Color(255,255,255));
                //Alterando cor da borda
                border1.setTitleColor(new Color(255,255,255));
                //Adicionando borda no painel
                painel1.setBorder(border1);
                //Alterando cor da borda
                border2.setTitleColor(new Color(255,255,255));
                //Adicionando borda no painel
                painel2.setBorder(border1);
                /* Aba Lista de Alunos */
                lbl_title2.setForeground(new Color(255,255,255));
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
                combo_id.setForeground(new Color(255,255,255));
                txt_id.setForeground(new Color(255,255,255));
                txt_matricula.setForeground(new Color(255,255,255));
                btn_save.setForeground(new Color(255,255,255));
                btn_cancel.setForeground(new Color(255,255,255));
                btn_edit.setForeground(new Color(255,255,255));
                btn_fechar.setForeground(new Color(0,0,0));
                //Alterando cor da borda
                border3.setTitleColor(new Color(255,255,255));
                //Adicionando borda no painel
                painel3.setBorder(border1);
                break;
            case 1:
                //Alterando cor de fundo
                this.setBackground(new Color(60,63,65));
                //Alterando cor dos botões e campos
                /* Aba Pesquisar */
                txt_espe.setBackground(new Color(60,63,65));
                btn_pesquisar1.setBackground(new Color(22,122,198));
                btn_pesquisar2.setBackground(new Color(22,122,198));
                combo_classif.setBackground(new Color(22,122,198));
                painel1.setBackground(new Color(60,63,65));
                painel2.setBackground(new Color(60,63,65));
                radio_male.setBackground(new Color(60,63,65));
                radio_female.setBackground(new Color(60,63,65));
                radio_nome.setBackground(new Color(60,63,65));
                radio_cpf.setBackground(new Color(60,63,65));
                sep_espe.setBackground(new Color(22,122,198));
                sep_abas.setBackground(new Color(22,122,198));
                /* Aba Lista de Alunos */
                txt_nome.setBackground(new Color(60,63,65));
                txt_resp.setBackground(new Color(60,63,65));
                txt_datanasc.setBackground(new Color(60,63,65));
                txt_cpf.setBackground(new Color(60,63,65));
                combo_id.setBackground(new Color(22,122,198));
                txt_id.setBackground(new Color(60,63,65));
                txt_matricula.setBackground(new Color(60,63,65));
                painel3.setBackground(new Color(60,63,65));
                btn_sexo.setBackground(new Color(22,122,198));
                btn_save.setBackground(new Color(6,214,162));
                btn_cancel.setBackground(new Color(239,58,58));
                btn_edit.setBackground(new Color(22,122,198));
                btn_fechar.setBackground(new Color(204,16,16));
                sep_nome.setBackground(new Color(22,122,198));
                sep_resp.setBackground(new Color(22,122,198));
                sep_datanasc.setBackground(new Color(22,122,198));
                sep_cpf.setBackground(new Color(22,122,198));
                sep_id.setBackground(new Color(22,122,198));
                sep_matricula.setBackground(new Color(22,122,198));
                //Alterando cor das fontes
                /* Aba Pesquisar */
                lbl_title1.setForeground(new Color(255,69,0));
                txt_espe.setForeground(new Color(255,255,255));
                combo_classif.setForeground(new Color(255,255,255));
                radio_male.setForeground(new Color(255,255,255));
                radio_female.setForeground(new Color(255,255,255));
                radio_nome.setForeground(new Color(255,255,255));
                radio_cpf.setForeground(new Color(255,255,255));
                //Alterando cor da borda
                border1.setTitleColor(new Color(255,69,0));
                //Adicionando borda no painel
                painel1.setBorder(border1);
                //Alterando cor da borda
                border2.setTitleColor(new Color(255,69,0));
                //Adicionando borda no painel
                painel2.setBorder(border1);
                /* Aba Lista de Alunos */
                lbl_title2.setForeground(new Color(255,69,0));
                lbl_nome.setForeground(new Color(255,69,0));
                lbl_resp.setForeground(new Color(255,69,0));
                lbl_datanasc.setForeground(new Color(255,69,0));
                lbl_cpf.setForeground(new Color(255,69,0));
                combo_id.setForeground(new Color(255,255,255));
                lbl_id.setForeground(new Color(255,69,0));
                lbl_matricula.setForeground(new Color(255,69,0));
                txt_nome.setForeground(new Color(255,255,255));
                txt_resp.setForeground(new Color(255,255,255));
                txt_datanasc.setForeground(new Color(255,255,255));
                txt_cpf.setForeground(new Color(255,255,255));
                txt_id.setForeground(new Color(255,255,255));
                txt_matricula.setForeground(new Color(255,255,255));
                btn_save.setForeground(new Color(255,255,255));
                btn_cancel.setForeground(new Color(255,255,255));
                btn_edit.setForeground(new Color(255,255,255));
                btn_fechar.setForeground(new Color(0,0,0));
                //Alterando cor da borda
                border3.setTitleColor(new Color(255,69,0));
                //Adicionando borda no painel
                painel3.setBorder(border1);
                break;
            case 2:
                //Alterando cor de fundo
                this.setBackground(new Color(255,255,255));
                //Alterando cor dos botões e campos
                /* Aba Pesquisar */
                txt_espe.setBackground(new Color(255,255,255));
                btn_pesquisar1.setBackground(new Color(122,138,153));
                btn_pesquisar2.setBackground(new Color(122,138,153));
                combo_classif.setBackground(new Color(122,138,153));
                painel1.setBackground(new Color(255,255,255));
                painel2.setBackground(new Color(255,255,255));
                radio_male.setBackground(new Color(255,255,255));
                radio_female.setBackground(new Color(255,255,255));
                radio_nome.setBackground(new Color(255,255,255));
                radio_cpf.setBackground(new Color(255,255,255));
                sep_espe.setBackground(new Color(0,0,0));
                sep_abas.setBackground(new Color(0,0,0));
                /* Aba Lista de Alunos */
                txt_nome.setBackground(new Color(255,255,255));
                txt_resp.setBackground(new Color(255,255,255));
                txt_datanasc.setBackground(new Color(255,255,255));
                txt_cpf.setBackground(new Color(255,255,255));
                combo_id.setBackground(new Color(122,138,153));
                txt_id.setBackground(new Color(255,255,255));
                txt_matricula.setBackground(new Color(255,255,255));
                painel3.setBackground(new Color(255,255,255));
                btn_sexo.setBackground(new Color(122,138,153));
                btn_save.setBackground(new Color(6,214,162));
                btn_cancel.setBackground(new Color(239,58,58));
                btn_edit.setBackground(new Color(122,138,153));
                btn_fechar.setBackground(new Color(204,16,16));
                sep_nome.setBackground(new Color(0,0,0));
                sep_resp.setBackground(new Color(0,0,0));
                sep_datanasc.setBackground(new Color(0,0,0));
                sep_cpf.setBackground(new Color(0,0,0));
                sep_id.setBackground(new Color(0,0,0));
                sep_matricula.setBackground(new Color(0,0,0));
                //Alterando cor das fontes
                /* Aba Pesquisar */
                lbl_title1.setForeground(new Color(0,0,0));
                txt_espe.setForeground(new Color(0,0,0));
                combo_classif.setForeground(new Color(0,0,0));
                radio_male.setForeground(new Color(0,0,0));
                radio_female.setForeground(new Color(0,0,0));
                radio_nome.setForeground(new Color(0,0,0));
                radio_cpf.setForeground(new Color(0,0,0));
                //Alterando cor da borda
                border1.setTitleColor(new Color(0,0,0));
                //Adicionando borda no painel
                painel1.setBorder(border1);
                //Alterando cor da borda
                border2.setTitleColor(new Color(0,0,0));
                //Adicionando borda no painel
                painel2.setBorder(border1);
                /* Aba Lista de Alunos */
                lbl_title2.setForeground(new Color(0,0,0));
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
                combo_id.setForeground(new Color(0,0,0));
                txt_id.setForeground(new Color(0,0,0));
                txt_matricula.setForeground(new Color(0,0,0));
                btn_save.setForeground(new Color(0,0,0));
                btn_cancel.setForeground(new Color(0,0,0));
                btn_edit.setForeground(new Color(0,0,0));
                btn_fechar.setForeground(new Color(0,0,0));
                //Alterando cor da borda
                border3.setTitleColor(new Color(0,0,0));
                //Adicionando borda no painel
                painel3.setBorder(border1);
                break;
        }
    }
    
    private void verifSexo(){
        //Verificando se cadastro escolhido foi Masculino ou Feminino
        if(sexo.equals("m")){
            //Alterando imagem do botão
            btn_sexo.setIcon(new ImageIcon(getClass().getResource("/imagens/Masculino Miniatura 2.png")));
        }else{ //if(sexo.equals("f"))
            //Alterando imagem do botão
            btn_sexo.setIcon(new ImageIcon(getClass().getResource("/imagens/Feminino Miniatura 2.png")));
        }
    }
    
    public Pesquisa() {
        initComponents();
        //Bloqueando campos
        txt_nome.setEnabled(false);
        txt_resp.setEnabled(false);
        txt_datanasc.setEnabled(false);
        txt_cpf.setEnabled(false);
        combo_id.setEnabled(false);
        txt_id.setEnabled(false);
        btn_save.setEnabled(false);
        btn_cancel.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_sexo.setEnabled(false);
        
        //Alterar cores
        alterarCores(Login.tema);
        
        //Botões pré selecionados
        radio_male.setSelected(true);
        radio_nome.setSelected(true);
        //Adicionando mascara padrão no Campo Formatado
        txt_espe.setFormatterFactory(new DefaultFormatterFactory());
        //Apagando texto já escrito no Campo Formatado
        txt_espe.setText("");
        //Alinhando texto à Esquerda
        txt_espe.setHorizontalAlignment(JTextField.LEADING);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_sexo1 = new javax.swing.ButtonGroup();
        grupo_ordem = new javax.swing.ButtonGroup();
        grupo_espe = new javax.swing.ButtonGroup();
        lbl_title1 = new javax.swing.JLabel();
        painel1 = new javax.swing.JPanel();
        combo_classif = new javax.swing.JComboBox<>();
        btn_pesquisar1 = new javax.swing.JButton();
        radio_male = new javax.swing.JRadioButton();
        radio_female = new javax.swing.JRadioButton();
        painel2 = new javax.swing.JPanel();
        btn_pesquisar2 = new javax.swing.JButton();
        sep_espe = new javax.swing.JSeparator();
        radio_cpf = new javax.swing.JRadioButton();
        radio_nome = new javax.swing.JRadioButton();
        txt_espe = new javax.swing.JFormattedTextField();
        sep_abas = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_lista = new javax.swing.JTable();
        painel3 = new javax.swing.JPanel();
        btn_save = new javax.swing.JButton();
        btn_fechar = new javax.swing.JButton();
        lbl_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        sep_nome = new javax.swing.JSeparator();
        txt_resp = new javax.swing.JTextField();
        lbl_resp = new javax.swing.JLabel();
        sep_resp = new javax.swing.JSeparator();
        lbl_datanasc = new javax.swing.JLabel();
        sep_datanasc = new javax.swing.JSeparator();
        txt_datanasc = new javax.swing.JFormattedTextField();
        lbl_cpf = new javax.swing.JLabel();
        sep_cpf = new javax.swing.JSeparator();
        txt_cpf = new javax.swing.JFormattedTextField();
        lbl_id = new javax.swing.JLabel();
        sep_id = new javax.swing.JSeparator();
        txt_id = new javax.swing.JTextField();
        btn_cancel = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        txt_matricula = new javax.swing.JTextField();
        lbl_matricula = new javax.swing.JLabel();
        sep_matricula = new javax.swing.JSeparator();
        combo_id = new javax.swing.JComboBox<>();
        btn_sexo = new javax.swing.JButton();
        lbl_title2 = new javax.swing.JLabel();

        setTitle("Pesquisar");

        lbl_title1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        lbl_title1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title1.setText("Pesquisar Aluno");

        painel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null), "Classificar por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        painel1.setToolTipText("");

        combo_classif.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        combo_classif.setForeground(new java.awt.Color(255, 255, 255));
        combo_classif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Exibir Todos", "Nome", "Data de Nascimento", "N° de Matrícula" }));

        btn_pesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pesquisar.png"))); // NOI18N
        btn_pesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisar1ActionPerformed(evt);
            }
        });

        grupo_sexo1.add(radio_male);
        radio_male.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        radio_male.setForeground(new java.awt.Color(255, 255, 255));
        radio_male.setText("Masculino");

        grupo_sexo1.add(radio_female);
        radio_female.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        radio_female.setForeground(new java.awt.Color(255, 255, 255));
        radio_female.setText("Feminino");

        javax.swing.GroupLayout painel1Layout = new javax.swing.GroupLayout(painel1);
        painel1.setLayout(painel1Layout);
        painel1Layout.setHorizontalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel1Layout.createSequentialGroup()
                        .addComponent(radio_male)
                        .addGap(18, 18, 18)
                        .addComponent(radio_female))
                    .addGroup(painel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btn_pesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(combo_classif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel1Layout.setVerticalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_male)
                    .addComponent(radio_female))
                .addGap(18, 18, 18)
                .addComponent(combo_classif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_pesquisar1)
                .addGap(31, 31, 31))
        );

        painel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null), "Especificar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        painel2.setToolTipText("");

        btn_pesquisar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pesquisar.png"))); // NOI18N
        btn_pesquisar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisar2ActionPerformed(evt);
            }
        });

        sep_espe.setBackground(new java.awt.Color(255, 255, 255));

        grupo_espe.add(radio_cpf);
        radio_cpf.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        radio_cpf.setForeground(new java.awt.Color(255, 255, 255));
        radio_cpf.setText("CPF");
        radio_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_cpfActionPerformed(evt);
            }
        });

        grupo_espe.add(radio_nome);
        radio_nome.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        radio_nome.setForeground(new java.awt.Color(255, 255, 255));
        radio_nome.setText("Nome");
        radio_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_nomeActionPerformed(evt);
            }
        });

        txt_espe.setBorder(null);
        txt_espe.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txt_espe.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_espe.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N

        javax.swing.GroupLayout painel2Layout = new javax.swing.GroupLayout(painel2);
        painel2.setLayout(painel2Layout);
        painel2Layout.setHorizontalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel2Layout.createSequentialGroup()
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btn_pesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_espe, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sep_espe))))
                .addContainerGap())
            .addGroup(painel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(radio_nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_cpf)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        painel2Layout.setVerticalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_nome)
                    .addComponent(radio_cpf))
                .addGap(18, 18, 18)
                .addComponent(txt_espe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_espe, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btn_pesquisar2)
                .addGap(35, 35, 35))
        );

        sep_abas.setBackground(new java.awt.Color(255, 255, 255));
        sep_abas.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tabela_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Data de Nasc.", "CPF", "N° Matrícula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
            tabela_lista.getColumnModel().getColumn(0).setPreferredWidth(250);
            tabela_lista.getColumnModel().getColumn(1).setResizable(false);
            tabela_lista.getColumnModel().getColumn(2).setResizable(false);
            tabela_lista.getColumnModel().getColumn(3).setResizable(false);
            tabela_lista.getColumnModel().getColumn(3).setPreferredWidth(45);
        }

        painel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null), "Dados do Aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btn_save.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("Salvar");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_fechar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_fechar.setForeground(new java.awt.Color(0, 0, 0));
        btn_fechar.setText("Fechar");
        btn_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fecharActionPerformed(evt);
            }
        });

        lbl_nome.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lbl_nome.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome.setText("Nome");

        txt_nome.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txt_nome.setForeground(new java.awt.Color(255, 255, 255));
        txt_nome.setBorder(null);

        sep_nome.setForeground(new java.awt.Color(255, 255, 255));

        txt_resp.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txt_resp.setForeground(new java.awt.Color(255, 255, 255));
        txt_resp.setBorder(null);

        lbl_resp.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lbl_resp.setForeground(new java.awt.Color(255, 255, 255));
        lbl_resp.setText("Responsável");

        sep_resp.setForeground(new java.awt.Color(255, 255, 255));

        lbl_datanasc.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lbl_datanasc.setForeground(new java.awt.Color(255, 255, 255));
        lbl_datanasc.setText("Data de Nascimento");

        sep_datanasc.setForeground(new java.awt.Color(255, 255, 255));

        txt_datanasc.setBorder(null);
        txt_datanasc.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txt_datanasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_datanasc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_datanasc.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N

        lbl_cpf.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lbl_cpf.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cpf.setText("CPF");

        sep_cpf.setForeground(new java.awt.Color(255, 255, 255));

        txt_cpf.setBorder(null);
        txt_cpf.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpf.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N

        lbl_id.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        lbl_id.setText("ID");

        sep_id.setForeground(new java.awt.Color(255, 255, 255));

        txt_id.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txt_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id.setBorder(null);

        btn_cancel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_edit.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Editar");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        txt_matricula.setEditable(false);
        txt_matricula.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txt_matricula.setForeground(new java.awt.Color(255, 255, 255));
        txt_matricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_matricula.setBorder(null);

        lbl_matricula.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lbl_matricula.setForeground(new java.awt.Color(255, 255, 255));
        lbl_matricula.setText("N° de Matrícula");

        sep_matricula.setForeground(new java.awt.Color(255, 255, 255));

        combo_id.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        combo_id.setForeground(new java.awt.Color(255, 255, 255));
        combo_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));

        btn_sexo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_sexo.setForeground(new java.awt.Color(255, 255, 255));
        btn_sexo.setPreferredSize(new java.awt.Dimension(17, 17));
        btn_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sexoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel3Layout = new javax.swing.GroupLayout(painel3);
        painel3.setLayout(painel3Layout);
        painel3Layout.setHorizontalGroup(
            painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nome)
                    .addComponent(sep_nome)
                    .addComponent(txt_resp)
                    .addComponent(sep_resp)
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel3Layout.createSequentialGroup()
                                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nome)
                                    .addComponent(lbl_resp))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(painel3Layout.createSequentialGroup()
                                .addComponent(btn_edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cancel)
                                .addGap(92, 92, 92)))
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_fechar)
                            .addComponent(btn_sexo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_datanasc)
                            .addComponent(lbl_datanasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sep_datanasc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_cpf)
                                .addComponent(sep_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel3Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(lbl_cpf)))
                        .addGap(18, 18, 18)
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel3Layout.createSequentialGroup()
                                .addComponent(lbl_id)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel3Layout.createSequentialGroup()
                                .addComponent(combo_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_id)
                                    .addComponent(sep_id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_matricula, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel3Layout.createSequentialGroup()
                                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_matricula, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sep_matricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)))))
                .addContainerGap())
        );
        painel3Layout.setVerticalGroup(
            painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel3Layout.createSequentialGroup()
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_nome))
                    .addComponent(btn_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_resp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_resp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_resp, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painel3Layout.createSequentialGroup()
                                    .addComponent(lbl_datanasc)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sep_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel3Layout.createSequentialGroup()
                                    .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_matricula)
                                        .addComponent(lbl_id))
                                    .addGap(8, 8, 8)
                                    .addComponent(txt_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sep_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)))
                            .addComponent(lbl_cpf)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sep_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel3Layout.createSequentialGroup()
                                .addComponent(txt_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sep_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(combo_id, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_fechar)
                    .addComponent(btn_cancel)
                    .addComponent(btn_edit)))
        );

        lbl_title2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        lbl_title2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title2.setText("Lista de Alunos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_title1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(painel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_abas, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                            .addComponent(painel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(lbl_title2)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_abas)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_title1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_title2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        setBounds(-5, -30, 1035, 614);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        //Verificando se o ID é um valor inteiro
        try{
            //Criando variável que recebe o ID para o try-catch verificar se o valor digitado é inteiro ou não
            int id_num = Integer.parseInt(txt_id.getText());
            //Criando variável que recebe o número de matrícula do aluno
            int matricula = Integer.parseInt(txt_matricula.getText());
            
            //Verificando se todos os campos foram preenchidos
            if(!txt_nome.getText().isEmpty() && !txt_resp.getText().isEmpty() && 
               !txt_datanasc.getText().equals("  /  /    ") && !txt_id.getText().isEmpty()){
                
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
                        //Criando variável para juntar a parte alfabética do ID com a parte numérica
                        String id = combo_id.getSelectedItem() + String.valueOf(id_num);
            
                        //Criando variável para armazenar temporariamente os dados digitados pelo usuário
                        DadosAluno aluno = new DadosAluno(txt_nome.getText(),txt_resp.getText(),txt_datanasc.getText(),txt_cpf.getText(), id, sexo, matricula);
                        
                        //Criando variável que fará a conexão com o banco de dados e salvará os dados do usuário no banco
                        AlunoSQL sql = new AlunoSQL();
                
                        //Executando no banco de dados o comando INSERT com os dados do usuário
                        sql.update(aluno);
                        
                        //Verifica se foi passado um CPF
                        if(!txt_cpf.getText().equals("   .   .   -  ")){
                            //Pssando dados para variável editar para recarregar tabela
                            editar = new DadosAluno(txt_nome.getText(),txt_resp.getText(),txt_datanasc.getText(),txt_cpf.getText(), id, sexo, matricula);
                        }else{
                            //Pssando dados para variável editar para recarregar tabela
                            editar = new DadosAluno(txt_nome.getText(),txt_resp.getText(),txt_datanasc.getText(),null, id, sexo, matricula);
                        }
                        
                        //Guardando valor int da linha selecionada
                        int line_selected = tabela_lista.getSelectedRow();
                        
                        //Atualizando dados do aluno no ArrayList da tabela
                        lista_alunos.get(line_selected).setNome(editar.getNome());
                        lista_alunos.get(line_selected).setResp(editar.getResp());
                        lista_alunos.get(line_selected).setDatanasc(editar.getDatanasc());
                        lista_alunos.get(line_selected).setCPF(editar.getCPF());
                        lista_alunos.get(line_selected).setID(editar.getID());
                        lista_alunos.get(line_selected).setSexo(editar.getSexo());
                        
                        //Resetando campos
                        buttonFunction("reset");
                
                        //Recarregando tabela
                        reloadTable();
                    }else{
                        //Mensagem de erro
                        JOptionPane.showMessageDialog(null, "Senha incorreta", "Erro ao Salvar Dados", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }else{
                //Mensagem de erro
                JOptionPane.showMessageDialog(null, "Preencha todos os campos para salvar", "Erro ao Salvar Dados", JOptionPane.ERROR_MESSAGE);
            }   
        }catch(NumberFormatException ex){
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "O ID deve ser um valor inteiro", "Erro  ao Salvar Dados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fecharActionPerformed
        //Fechando a tela atual
        dispose();
    }//GEN-LAST:event_btn_fecharActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        /* Voltando dados dos campos para o padrão da linha selecionada */
        //Guardando valor int da linha selecionada
        int line_selected = tabela_lista.getSelectedRow();
        //Criando variável de Departamento contendo os dados da linha selecionada
        DadosAluno editar = lista_alunos.get(line_selected);
        //Adicionando dados nos campos
        txt_nome.setText(editar.getNome());
        txt_resp.setText(editar.getResp());
        txt_datanasc.setText(editar.getDatanasc());
        txt_cpf.setText(editar.getCPF());
        txt_id.setText(editar.getID());
        txt_matricula.setText(String.valueOf(editar.getMatricula()));
        //Chamando função de habilitação dos botões editar
        buttonFunction("select");
        //Chamando função para bloquear e desbloquear os botões
        buttonFunction("cancel/save");
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        //Chamando função do botão editar
        buttonFunction("edit");
    }//GEN-LAST:event_btn_editActionPerformed

    private void tabela_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_listaMouseClicked
        //Guardando valor int da linha selecionada
        int line_selected = tabela_lista.getSelectedRow();
        //Variável que guarda o numero da opção selecionada da combo box
        int index_id = 0;
        
        //Verificando se linha da tabela selecionada é válida
        if(line_selected >= 0 && line_selected < lista_alunos.size()){
            //Criando variável de Departamento contendo os dados da linha selecionada
            DadosAluno editar = lista_alunos.get(line_selected);
            
            //Obtendo id do aluno
            String num_id = editar.getID();
            //Obtendo letra do id
            char char_id = num_id.charAt(0);
            //Removendo letra do id
            num_id = num_id.substring(1);
            
            //Variável para indicar o número da index da combo box
            int i = 0;
            //Laço para encontrar valor da index referente ao caracter do id do aluno
            for(char ch='A';ch<='Z';ch++){
                //Verificando se o caracter do id do aluno é igual letra atual do laço
                if(char_id == ch){
                    //Passando o valor de i para a index_id
                    index_id = i;
                    //Finalizando laço
                    break;
                }
                //Acrecentando +1 na variável i
                i++;
            }
            
            //Adicionando dados nos campos
            txt_nome.setText(editar.getNome());
            txt_resp.setText(editar.getResp());
            txt_datanasc.setText(editar.getDatanasc());
            txt_cpf.setText(editar.getCPF());
            combo_id.setSelectedIndex(index_id);
            txt_id.setText(num_id);
            txt_matricula.setText(String.valueOf(editar.getMatricula()));
            sexo = editar.getSexo();
            //Alterando imagem do botão referente ao sexo do aluno
            verifSexo();
            //Chamando função de habilitação dos botões editar
            buttonFunction("select");
        }
    }//GEN-LAST:event_tabela_listaMouseClicked

    private void btn_pesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisar1ActionPerformed
        //Variável para verificar o sexo
        int sexo;
        //Variável recebe o valor da classificação selecionada
        int classif = combo_classif.getSelectedIndex();
        
        //Verifica qual sexo foi selecionado
        if(radio_male.isSelected() && !radio_female.isSelected()){
            sexo = 0;
        }else{ //if(!radio_male.isSelected() && radio_female.isSelected())
            sexo = 1;
        }

        //Criando um modelo de tabela
        DefaultTableModel modelo = (DefaultTableModel) tabela_lista.getModel();
        //Declarando 0 linhas para o modelo
        modelo.setNumRows(0);
        
        //Criando variável para carregar dados do usuário
        AlunoSQL alunoSQL = new AlunoSQL();
        
        //Resetando arraylist de usuários
        lista_alunos = new ArrayList();
        
        //Adicionando informações para cada linha da tabela
        for(DadosAluno aluno : alunoSQL.ratingSelect(sexo, classif)){
            //Criando objeto que recebe dados a serem inseridos na linha
            Object linha[] = new Object[]{aluno.getNome(),aluno.getDatanasc(),aluno.getCPF(),aluno.getMatricula()};
            
            //Adicionando usuário na lista de usuários para editar quando selecionar linha
            lista_alunos.add(aluno);
            
            //Adicionando linha no modelo da tabela
            modelo.addRow(linha);
        }
        
        //Adicionando modelo na tabela
        tabela_lista.setModel(modelo);
    }//GEN-LAST:event_btn_pesquisar1ActionPerformed

    private void btn_pesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisar2ActionPerformed
        //Variável para verificar tipo de especificação
        int type;
        //Variável para receber o texto digitado
        String text = "";
        //Verifica qual botão foi selecionado
        if(radio_nome.isSelected() && !radio_cpf.isSelected()){
            //Passando tipo
            type = 0;
            //Passando texto
            text = txt_espe.getText();
        }else{ //if(!radio_nome.isSelected() && radio_cpf.isSelected())
            //Passando tipo
            type = 1;
            //Verificando se escreveu algo
            if(!txt_espe.getText().equals("   .   .   -  ")){
                //Passando texto
                text = txt_espe.getText();
            }
        }

        //Criando um modelo de tabela
        DefaultTableModel modelo = (DefaultTableModel) tabela_lista.getModel();
        //Declarando 0 linhas para o modelo
        modelo.setNumRows(0);
        
        //Criando variável para carregar dados do usuário
        AlunoSQL alunoSQL = new AlunoSQL();
        
        //Resetando arraylist de usuários
        lista_alunos = new ArrayList();
        
        //Adicionando informações para cada linha da tabela
        for(DadosAluno aluno : alunoSQL.searchSelect(text, type)){
            //Criando objeto que recebe dados a serem inseridos na linha
            Object linha[] = new Object[]{aluno.getNome(),aluno.getDatanasc(),aluno.getCPF(),aluno.getMatricula()};
            
            //Adicionando usuário na lista de usuários para editar quando selecionar linha
            lista_alunos.add(aluno);
            
            //Adicionando linha no modelo da tabela
            modelo.addRow(linha);
        }
        
        //Adicionando modelo na tabela
        tabela_lista.setModel(modelo);
    }//GEN-LAST:event_btn_pesquisar2ActionPerformed

    private void radio_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_nomeActionPerformed
        //Adicionando mascara padrão no Campo Formatado
        txt_espe.setFormatterFactory(new DefaultFormatterFactory());
        //Apagando texto já escrito no Campo Formatado
        txt_espe.setText("");
        //Alinhando texto à Esquerda
        txt_espe.setHorizontalAlignment(JTextField.LEADING);
    }//GEN-LAST:event_radio_nomeActionPerformed

    private void radio_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_cpfActionPerformed
        //Criando variável que receberá formato da mascara
        MaskFormatter cpf;
        //Verifica se ocorreu algum erro ao criar a mascara
        try{
            //Variável recebendo novo formato de mascara
            cpf = new MaskFormatter("###.###.###-##");
            //Adicionando a mascara criada no Campo Formatado
            txt_espe.setFormatterFactory(new DefaultFormatterFactory(cpf));
            //Apagando texto já escrito no Campo Formatado
            txt_espe.setText("");
            //Centralizando texto
            txt_espe.setHorizontalAlignment(JTextField.CENTER);
        }catch(ParseException ex){
        }
    }//GEN-LAST:event_radio_cpfActionPerformed

    private void btn_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sexoActionPerformed
        //Verifica sexo atual guardado na variável
        if(sexo.equals("m")){
            //Mudando sexo para feminino
            sexo = "f";
        }else{ //if(sexo.equals("f"))
            //Mudando sexo para masculino
            sexo = "m";
        }
        
        //Alterando imagem do botão referente ao sexo do aluno
        verifSexo();
    }//GEN-LAST:event_btn_sexoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_fechar;
    private javax.swing.JButton btn_pesquisar1;
    private javax.swing.JButton btn_pesquisar2;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_sexo;
    private javax.swing.JComboBox<String> combo_classif;
    private javax.swing.JComboBox<String> combo_id;
    private javax.swing.ButtonGroup grupo_espe;
    private javax.swing.ButtonGroup grupo_ordem;
    private javax.swing.ButtonGroup grupo_sexo1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_cpf;
    private javax.swing.JLabel lbl_datanasc;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_matricula;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_resp;
    private javax.swing.JLabel lbl_title1;
    private javax.swing.JLabel lbl_title2;
    private javax.swing.JPanel painel1;
    private javax.swing.JPanel painel2;
    private javax.swing.JPanel painel3;
    private javax.swing.JRadioButton radio_cpf;
    private javax.swing.JRadioButton radio_female;
    private javax.swing.JRadioButton radio_male;
    private javax.swing.JRadioButton radio_nome;
    private javax.swing.JSeparator sep_abas;
    private javax.swing.JSeparator sep_cpf;
    private javax.swing.JSeparator sep_datanasc;
    private javax.swing.JSeparator sep_espe;
    private javax.swing.JSeparator sep_id;
    private javax.swing.JSeparator sep_matricula;
    private javax.swing.JSeparator sep_nome;
    private javax.swing.JSeparator sep_resp;
    private javax.swing.JTable tabela_lista;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JFormattedTextField txt_datanasc;
    private javax.swing.JFormattedTextField txt_espe;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_matricula;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_resp;
    // End of variables declaration//GEN-END:variables
}
