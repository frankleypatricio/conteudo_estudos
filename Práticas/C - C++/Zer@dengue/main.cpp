//Bibliotecas
#include <iostream> //Operações de entrada e saída de C++
#include <locale.h> //Alterar língua de exibição do programa
#include <queue> //Biblioteca da fila
#include <fstream> //Manipular arquivos de texto
#include <cstdio> //Operações de entrada e saída de C (versão atualizada do C++)
#include <cstring> //Manipular strings (versão atualizada do C++)
#include <stdexcept> //Biblioteca do exception do try catch
#include <map> //Biblioteca do map

//Variáveis Personalizadas
struct Date {short dia; short mes; short ano;}; //Struct para datas
enum Status {Aguardando, Em_Analise, Inconsistente, Resolvido}; //Enum pada o status da denúncia

//Classes
#include "Identificadores.h"
#include "Endereco.h"
#include "Cadastro.h"
#include "Usuario.h"
#include "Denuncia.h"
#include "Relatorio.h"
#include "Carregar.h"
#include "Atualizar.h"
#include "Registrar.h"

//Variáveis Globais
queue <Denuncia*> fila; //Fila para guardar as denúncias a serem analisadas
int option=-1; //Variável para salvar as opções escolhidas pelo usuário
char confirm;//Variável para
bool acesso=false;//Variável para definir o acesso do usuário ao sistema
Registrar* registrar;//Variável para registrar dados
Carregar* carregar;//Variável para carregar dados
Atualizar* atualizar;//Variável para atualizar dados
Usuario* usuario;//Variável para guardar dados do usuário quando logado
map <Status,string> status; //Mapa para cada valor do enumerador Status

using namespace std;

//Protótipos de Funções
void cadastrarUsuario();
void verificarUsuario();
queue <Denuncia*> carregarFila();
void realizarDenuncia();
void realizarRelatorio(Denuncia* denuncia);
void acompanharDenuncia();
void configurarConta();
void operarDenuncias();
void listarUsuarios();

void exibirLogo(){
    cout << "\t\t\t\t\t******************************" << endl;
    cout << "\t\t\t\t\t*         Zer@Dengue         *" << endl;
    cout << "\t\t\t\t\t* > Todos Contra a Dengue! < *" << endl;
    cout << "\t\t\t\t\t******************************\n"<< endl;
}

void setStatusMap(){ //Mapeia as strings relativas ao valor de cada status (os nomes dos status não são strings, por isso ao exibi-los sai 0,1,2 e 3, por isso precisa do map)
    status[Aguardando]="Aguardando";
    status[Em_Analise]="Em Análise";
    status[Inconsistente]="Inconsistente";
    status[Resolvido]="Resolvido";
}

void checkData(){ //Verifica se as pastas existem, se não, as cria
    if(system("cd database")){ //Por algum motivo colocar o não "!", não roda o if, mas se não colocar roda...
        system("mkdir database");
    }
    if(system("cd database\\usuarios")){
        system("mkdir database\\usuarios");
    }
    if(system("cd database\\denuncias")){
        system("mkdir database\\denuncias");
    }
    system("cls");
}

int main(){
    setlocale(LC_ALL,"Portuguese");
    system("chcp 1252 > nul");
    checkData();
    setStatusMap();

    //Variáveis locais do main
    string tipo_user; //Tipo do usuário para aparecer no menu se é usuário comum ou administrador

    //Tela inicial (login / cadastro)
    inicio:
    do{
        exibirLogo();
        cout << "*-----------------------------------------------------------------------*" << endl;
        cout << "| Menu: / 1- Entrar com Usuário / 2- Cadastrar Novo Usuário / 0- Fechar |" << endl;
        cout << "*-----------------------------------------------------------------------*" << endl;
        cout << "> "; cin >> option;

        switch(option){
        case 1:
            verificarUsuario();
            break;
        case 2:
            cadastrarUsuario();
            break;
        case 0:
            cout << "*--------------------------*" << endl;
            cout << "| Fechar o programa? (s/n) |" << endl;
            cout << "*--------------------------*" << endl;
            cout << "> "; cin >> confirm;
            if(confirm!='s' && confirm!='S')option=-1;
            break;
        default:
            cout << "*-----------------------------*" << endl;
            cout << "| Erro: Opção não reconhecida |" << endl;
            cout << "*-----------------------------*" << endl;
            break;
        }
        if(option!=0 && acesso==false){system("pause");system("cls");}

        if(acesso==true && option!=0){
            system("cls");
            if(usuario->getAdmin()==true)fila=carregarFila();
            //Tela seguinte (conta do usuário)
            do{
                exibirLogo();
                option=-1;
                if(usuario->getAdmin()==false){
                    cout << "*--------->" << endl;
                    cout << "| Usuário: " << usuario->getNome() << " " << usuario->getSobrenome() << endl;
                    cout << "| *---------------------------------------------------------------------*" << endl;
                    cout << "| Menu: / 1- Realizar Nova Denúncia / 3- Configurações da Conta         |" << endl;
                    cout << "|       / 2- Acompanhar Denúncias   / 4- Finalizar Seção / 0- Fechar    |" << endl;
                    cout << "*-----------------------------------------------------------------------*" << endl;
                }else{ //usuario->getAdmin==true
                    cout << "*--------->" << endl;
                    cout << "| Administrador: " << usuario->getNome() << " " << usuario->getSobrenome() << endl;
                    cout << "| *---------------------------------------------------------------------*" << endl;
                    cout << "| Menu: / 1- Operar Denúncias / 3- Configurações da Conta               |" << endl;
                    cout << "|       / 2- Listar Cadastros / 4- Finalizar Seção / 0- Fechar          |" << endl;
                    cout << "*-----------------------------------------------------------------------*" << endl;
                }
                cout << "> "; cin >> option;

                switch(option){
                case 1:
                    if(usuario->getAdmin()==false)realizarDenuncia(); //Usuário
                    else operarDenuncias(); //Administrador
                    break;
                case 2:
                    if(usuario->getAdmin()==false)acompanharDenuncia(); //Usuário
                    else listarUsuarios(); //Administrador
                    break;
                case 3:
                    configurarConta();
                    break;
                case 4:
                    cout << "*-------------------------*" << endl;
                    cout << "| Finalizar seção? (s/n)  |" << endl;
                    cout << "*-------------------------*" << endl;
                    cout << "> "; cin >> confirm;
                    if(confirm=='s' || confirm=='S'){
                        option=-1;
                        confirm='n';
                        acesso=false;
                        delete usuario;
                        system("cls");
                        goto inicio;
                    }
                    break;
                case 0:
                    cout << "*--------------------------*" << endl;
                    cout << "| Fechar o programa? (s/n) |" << endl;
                    cout << "*--------------------------*" << endl;
                    cout << "> "; cin >> confirm;
                    if(confirm!='s' && confirm!='S')option=-1;
                    break;
                default:
                    cout << "*-----------------------------*" << endl;
                    cout << "| Erro: Opção não reconhecida |" << endl;
                    cout << "*-----------------------------*" << endl;
                    break;
                }
                if(option!=0){
                    system("pause");
                    system("cls");
                }
            }while(option != 0);
        }
    }while(option != 0);
    exit(0);
}

void cadastrarUsuario(){
    //Variáveis dos dados pessoais
    int64_t cpf;
    string nome;
    string sobrenome;
    Date data_nasc;

    //Variáveis do endereço
    string cidade;
    string UF;
    long int CEP;
    string rua;
    int numero;
    string bairro;

    //Variáveis do login
    string user;
    string senha;
    string email;

    cout << "\n/-------------------\\" << endl;
    cout << "| Cadastrar Usuário |" << endl;
    cout << "---------------------\n" << endl;

    cout << "*-------------------------------------------------------------------*" << endl;
    cout << "| Preencha seus dados corretamente, e verifique antes de prosseguir |" << endl;
    cout << "*-------------------------------------------------------------------*" << endl;

    cout << "*----------------*" << endl;
    cout << "| Dados Pessoais |" << endl;
    cout << "*----------------*" << endl;

    cout << "> Primeiro Nome: ";
    fflush(stdin);
    getline(cin,nome);
    cout << "> Sobrenome: ";
    fflush(stdin);
    getline(cin,sobrenome);
    cout << "> Data de Nascimento <" << endl;
    cout << "- Dia: ";
    cin >> data_nasc.dia;
    cout << "- Mês: ";
    cin >> data_nasc.mes;
    cout << "- Ano: ";
    cin >> data_nasc.ano;
    cout << "> CPF: ";
    cin >> cpf;

    cout << "*----------*" << endl;
    cout << "| Endereço |" << endl;
    cout << "*----------*" << endl;

    cout << "> Cidade: ";
    cin >> cidade;
    cout << "> UF: ";
    cin >> UF;
    cout << "> Rua: ";
    cin >> rua;
    cout << "> Número: ";
    cin >> numero;
    cout << "> Bairro: ";
    cin >> bairro;
    cout << "> CEP: ";
    cin >> CEP;

    cout << "*----------------*" << endl;
    cout << "| Dados de Login |" << endl;
    cout << "*----------------*" << endl;

    cout << "> Nome de Usuário: ";
    cin >> user;
    cout << "> Senha: ";
    cin >> senha;
    cout << "> E-Mail: ";
    cin >> email;

    Usuario* cadastrar=new Usuario(cpf, nome, sobrenome, data_nasc);
    cadastrar->setEndereco(cidade, UF, CEP, rua, numero, bairro);
    cadastrar->setCadastro(user, senha, email, cpf);
    cadastrar->setEnderecoFK(cadastrar->getEnderecoID());
    cadastrar->setCadastroFK(cadastrar->getCadastroID());

    registrar=new Registrar();
    registrar->registrarUsuario(cadastrar);
    delete cadastrar; //Descontruindo classe para liberar memória
    delete registrar;

    cout << "*---------------------*" << endl;
    cout << "| Cadastro concluído! |" << endl;
    cout << "*---------------------*" << endl;
}

void verificarUsuario(){
    string user;
    string senha;

    do{
        cout << "*------------------------------------------*" << endl;
        cout << "| Digite o seu nome de usuário e sua senha |" << endl;
        cout << "|         (Digite 0 para cancelar)         |" << endl;
        cout << "*------------------------------------------*" << endl;

        cout << "> Usuário: ";
        cin >> user;
        if(user=="0")break;
        cout << "> Senha: ";
        cin >> senha;

        carregar=new Carregar();

        if(carregar->verificarCadastro(user, senha)==true){
            acesso=true;
            usuario=carregar->carregarUsuario(carregar->getCPF());
        }else{
            cout << "*-------------------------------------*" << endl;
            cout << "|  Não foi possível realizar o Login  |" << endl;
            cout << "| (Usuário ou senha estão incorretos) |" << endl;
            cout << "*-------------------------------------*" << endl;
            system("pause");
        }
        system("cls");
        if(acesso==false)exibirLogo();
    }while(acesso==false);
    delete carregar;
}

queue <Denuncia*> carregarFila(){
    queue <Denuncia*> carregar_fila;
    carregar=new Carregar();
    vector <Denuncia*> denuncias=carregar->carregarDenuncia(true);
    for(int i=0;i<denuncias.size();i++){
        carregar_fila.push(denuncias[i]);
    }
    delete carregar;
    return carregar_fila;
}

void realizarDenuncia(){
    //Variáveis dos dados da denúncia
    string titulo;
    string descricao;
    Date data_denuncia;

    //Variáveis do endereço da denúncia
    string cidade;
    string UF;
    long int CEP;
    string rua;
    string bairro;

    cout << "\n/------------------------\\" << endl;
    cout << "| Realizar Nova Denúncia |" << endl;
    cout << "--------------------------\n" << endl;

    cout << "*----------------------------------------------------------------*" << endl;
    cout << "| Preencha os dados corretamente, e verifique antes de prosseguir |" << endl;
    cout << "*----------------------------------------------------------------*" << endl;

    cout << "*-------------------*" << endl;
    cout << "| Dados da Denúncia |" << endl;
    cout << "*-------------------*" << endl;

    cout << "> Título: ";
    fflush(stdin);
    getline(cin,titulo);
    cout << "> Descrição: ";
    fflush(stdin);
    getline(cin,descricao);
    cout << "> Data da Denúncia <" << endl;
    cout << "- Dia: ";
    cin >> data_denuncia.dia;
    cout << "- Mês: ";
    cin >> data_denuncia.mes;
    cout << "- Ano: ";
    cin >> data_denuncia.ano;

    cout << "*----------*" << endl;
    cout << "| Endereço |" << endl;
    cout << "*----------*" << endl;

    cout << "> Cidade: ";
    fflush(stdin);
    getline(cin,cidade);
    cout << "> UF: ";
    cin >> UF;
    cout << "> Rua: ";
    fflush(stdin);
    getline(cin,rua);
    cout << "> Bairro: ";
    fflush(stdin);
    getline(cin,bairro);
    cout << "> CEP: ";
    cin >> CEP;

    Denuncia* cadastrar=new Denuncia(titulo, descricao, data_denuncia, usuario->getCPF());
    cadastrar->setEndereco(cidade, UF, CEP, rua, bairro);
    cadastrar->setEnderecoFK(cadastrar->getEnderecoID());

    registrar=new Registrar();
    registrar->registrarDenuncia(cadastrar);
    delete cadastrar; //Descontruindo classe para liberar memória
    delete registrar;

    cout << "*---------------------*" << endl;
    cout << "| Denúncia realizada! |" << endl;
    cout << "*---------------------*" << endl;
}

void realizarRelatorio(Denuncia* denuncia){
    string relatorio;
    Date data_denuncia;
    string admin_name=usuario->getNome()+" "+usuario->getSobrenome();
    int veredito;

    cout << "\n/------------------\\" << endl;
    cout << "| Emitir Relatório |" << endl;
    cout << "--------------------\n" << endl;

    cout << "*----------------------------------------------------------------*" << endl;
    cout << "| Preencha os dados corretamente, e verifique antes de prosseguir |" << endl;
    cout << "*----------------------------------------------------------------*" << endl;

    cout << "*--------------------*" << endl;
    cout << "| Dados do Relatório |" << endl;
    cout << "*--------------------*" << endl;

    cout << "> Relatório: ";
    fflush(stdin);
    getline(cin,relatorio);
    cout << "> Data da Denúncia <" << endl;
    cout << "- Dia: ";
    cin >> data_denuncia.dia;
    cout << "- Mês: ";
    cin >> data_denuncia.mes;
    cout << "- Ano: ";
    cin >> data_denuncia.ano;
    cout << "> Essa denúncia foi Resolvida(0) ou se deu Inconsistente(1): ";
    cin >> veredito;
    if(veredito!=0 && veredito!=1)veredito=0;

    Relatorio* cadastrar=new Relatorio(relatorio, data_denuncia, usuario->getCPF(), admin_name);

    registrar=new Registrar();
    registrar->registrarRelatorio(cadastrar);

    atualizar=new Atualizar();
    if(veredito==0)denuncia->setStatus(Resolvido);
    else denuncia->setStatus(Inconsistente);
    denuncia->setRelatorioFK(cadastrar->getRelatorioID());
    atualizar->atualizarDenuncia(denuncia);

    delete cadastrar; //Descontruindo classe para liberar memória
    delete registrar;
    delete atualizar;

    cout << "*--------------------*" << endl;
    cout << "| Relatório Emitido! |" << endl;
    cout << "*--------------------*" << endl;
}

void acompanharDenuncia(){
    string data;
    string endereco;
    carregar=new Carregar();
    vector <Denuncia*> denuncias=carregar->carregarDenuncia(usuario->getCPF());
    Relatorio* relatorio=new Relatorio();
    string relatorio_status;

    if(denuncias.size()>0){
        option=-1;
        do{
            cout << "\n/----------------------\\" << endl;
            cout << "| Denúncias Realizadas |" << endl;
            cout << "------------------------" << endl;

            for(int i=0;i<denuncias.size();i++){
                data=to_string(denuncias[i]->getDia())+"/"+to_string(denuncias[i]->getMes())+"/"+to_string(denuncias[i]->getAno());
                endereco="Rua "+denuncias[i]->getRua()+", Bairro "+denuncias[i]->getBairro()+", "+denuncias[i]->getCidade()+"-"+denuncias[i]->getUF();

                if(denuncias[i]->getRelatorioFK()!=-1)relatorio_status="Emitido";
                else relatorio_status="Aguardando análise";

                cout << "*---------------->" << endl;
                cout << "| Denúncia de N° : " << i << " / Título: " << denuncias[i]->getTitulo() << endl;
                cout << "| Descrição: " << denuncias[i]->getDescricao() << endl;
                cout << "| Endereço: " << endereco << " / CEP: " << denuncias[i]->getCEP() << endl;
                cout << "| Data: " << data << " / Status: " << status[denuncias[i]->getStatus()] << " / Relatório: " << relatorio_status << endl;
                cout << "*---------------->" << endl;
            }

            cout << "*--------------------------------------------------------------------------*" << endl;
            cout << "| Digite o número da denúncia para ver o relatório emitido ou -1 para sair |" << endl;
            cout << "*--------------------------------------------------------------------------*" << endl;
            cout << "> "; cin >> option;

            if(option>-1 && option<denuncias.size()){
                if(denuncias[option]->getRelatorioFK()!=-1){
                    carregar=new Carregar();
                    relatorio=carregar->carregarRelatorio(denuncias[option]->getRelatorioFK());
                    data=to_string(relatorio->getDia())+"/"+to_string(relatorio->getMes())+"/"+to_string(relatorio->getAno());
                    cout << "*---------------->" << endl;
                    cout << "| Relatório da Denúncia de N° " << option << endl;
                    cout << "| Relatório: " << relatorio->getRelatorio() << endl;
                    cout << "| Data: " << data << " / Emitido por: " << relatorio->getAdminName() << endl;
                    cout << "*----------------------------------->" << endl;
                    delete relatorio;
                }else{
                    cout << "*-----------------------------------------------------*" << endl;
                    cout << "| Erro: Essa denúncia ainda não tem relatório emitido |" << endl;
                    cout << "*-----------------------------------------------------*" << endl;
                }
            }
            if(option!=-1){
                system("pause");
                system("cls");
                exibirLogo();
            }
        }while(option!=-1);
        delete carregar;
    }else{
        cout << "*-------------------------------------*" << endl;
        cout << "| Você ainda não fez nenhuma denúncia |" << endl;
        cout << "*-------------------------------------*" << endl;
        system("pause");
        system("cls");
    }
}

void configurarConta(){
    string data, tipo_user;
    int edit1; //Variável para editar tipos int
    string edit2; //Variável para editar tipos string
    Date edit3; //Variável para editar tipos Date
    int edited_U=0, edited_E=0, edited_C=0; //Variável para saber quais classes foram editadas (U-Usuario, E-Endereco, C-Cadastro)
    Usuario* editar=new Usuario();
    *editar=*usuario;
    option=-1;
    do{ cout <<"User: "<<usuario->getNome()<<" / Edit: "<<editar->getNome()<< endl;
        cout << "\n/------------------------\\" << endl;
        cout << "| Configurações da Conta |" << endl;
        cout << "--------------------------\n" << endl;

        if(usuario->getAdmin()==0)tipo_user="Usuário";
        else tipo_user="Administrador";
        data=to_string(usuario->getDia())+"/"+to_string(usuario->getMes())+"/"+to_string(usuario->getAno());
        cout << "*----------------*" << endl;
        cout << "| Dados Pessoais |" << endl;
        cout << "| Nome(1): " << usuario->getNome() << " / Sobrenome(2): " << usuario->getSobrenome() << " / Tipo de Cadastro: " << tipo_user << endl;
        cout << "| CPF: " << usuario->getCPF() << " / Data de Nasc.(3): " << data << endl;
        cout << "*------------------------------>" << endl;
        cout << "*----------*" << endl;
        cout << "| Endereço |" << endl;
        cout << "| Rua(4): " << usuario->getRua() << " / N°(5): " << usuario->getNumero() << " / CEP(6): " << usuario->getCEP() << endl;
        cout << "| Bairro(7): " << usuario->getBairro() << " / Cidade(8): " << usuario->getCidade() << " / UF(9): " << usuario->getUF() << endl;
        cout << "*------------------------------>" << endl;
        cout << "*----------*" << endl;
        cout << "| Cadastro |" << endl;
        cout << "| Nome de Usuário(10): " << usuario->getUser() << " / Senha(11): " << usuario->getSenha() << endl;
        cout << "| E-Mail(12): " << usuario->getEmail() << endl;
        cout << "*------------------------------>" << endl;

        cout << "*-----------------------------------------------*" << endl;
        cout << "| Digite o número de edição ou 0 para finalizar |" << endl;
        cout << "*-----------------------------------------------*" << endl;
        cout << "> "; cin >> option;

        switch(option){
        case 1:
            edited_U=1;
            cout << "> Novo Nome: ";
            cin >> edit2;
            editar->setNome(edit2);
            break;
        case 2:
            edited_U=1;
            cout << "> Novo Sobrenome: ";
            cin >> edit2;
            editar->setSobrenome(edit2);
            break;
        case 3:
            edited_U=1;
            cout << "> Nova Data de Nascimento <\n";
            cout << "- Dia: ";
            cin >> edit3.dia;
            cout << "- Mês: ";
            cin >> edit3.mes;
            cout << "- Ano: ";
            cin >> edit3.ano;
            editar->setDataNasc(edit3);
            break;
        case 4:
            edited_E=1;
            cout << "> Nova Rua: ";
            cin >> edit2;
            editar->setRua(edit2);
            break;
        case 5:
            edited_E=1;
            cout << "> Novo Número: ";
            cin >> edit1;
            editar->setNumero(edit1);
            break;
        case 6:
            edited_E=1;
            cout << "> Novo CEP: ";
            cin >> edit1;
            editar->setCEP(edit1);
            break;
        case 7:
            edited_E=1;
            cout << "> Novo Bairro: ";
            cin >> edit2;
            editar->setBairro(edit2);
            break;
        case 8:
            edited_E=1;
            cout << "> Nova Cidade: ";
            cin >> edit2;
            editar->setCidade(edit2);
            break;
        case 9:
            edited_E=1;
            cout << "> Novo UF: ";
            cin >> edit2;
            editar->setUF(edit2);
            break;
        case 10:
            edited_C=1;
            cout << "> Novo Nome de Usuário: ";
            cin >> edit2;
            editar->setUser(edit2);
            break;
        case 11:
            edited_C=1;
            cout << "> Nova Senha: ";
            cin >> edit2;
            editar->setSenha(edit2);
            break;
        case 12:
            edited_C=1;
            cout << "> Novo E-Mail: ";
            cin >> edit2;
            editar->setEmail(edit2);
            break;
        case 0:
            break;
        default:
            cout << "*-----------------------------*" << endl;
            cout << "| Erro: Opção não reconhecida |" << endl;
            cout << "*-----------------------------*" << endl;
            break;
        }
        cout << "*---------------------------*" << endl;
        cout << "| Continuar editando? (s/n) |" << endl;
        cout << "*---------------------------*" << endl;
        cout << "> "; cin >> confirm;
        if(confirm!='s' && confirm!='S'){
            cout << "*--------------------------*" << endl;
            cout << "| Salvar alterações? (s/n) |" << endl;
            cout << "*--------------------------*" << endl;
            cout << "> "; cin >> confirm;
            if(confirm=='s' || confirm=='S'){
                atualizar=new Atualizar();
                if(edited_U==1)atualizar->atualizarUsuario(editar,0);
                if(edited_E==1)atualizar->atualizarUsuario(editar,1);
                if(edited_C==1)atualizar->atualizarUsuario(editar,2);
                *usuario=*editar;
                cout << "*--------------------------------*" << endl;
                cout << "| Dados atualizados com sucesso! |" << endl;
                cout << "*--------------------------------*" << endl;
                option=0;
            }else{
                cout << "*------------------------*" << endl;
                cout << "|  Atualização cancelada |" << endl;
                cout << "| (Dados serão mantidos) |" << endl;
                cout << "*------------------------*" << endl;
                option=0;
            }
        }
        if(option!=0){
            system("cls");
            exibirLogo();
        }
    }while(option != 0);
    delete atualizar;
    delete editar;
    option=-1;
}

void operarDenuncias(){
    string data;
    string endereco;

    if(fila.size()>0){
        data=to_string(fila.front()->getDia())+"/"+to_string(fila.front()->getMes())+"/"+to_string(fila.front()->getAno());
        endereco="Rua "+fila.front()->getRua()+", N°"+to_string(fila.front()->getNumero())+", Bairro "+", "+fila.front()->getCidade()+"-"+fila.front()->getUF();
        do{
            cout << "\n/------------------\\" << endl;
            cout << "| Operar Denúncias |" << endl;
            cout << "--------------------" << endl;

            cout << "*------------------*" << endl;
            cout << "| Próxima denúncia |" << endl;
            cout << "| ID: " << fila.front()->getDenunciaID() << " / Título: " << fila.front()->getTitulo() << endl;
            //cout << "| Autor: " <<  << " / CPF do Autor: " << << endl; <- Colocar autor aqui futuramente
            cout << "| Descrição: " << fila.front()->getDescricao() << endl;
            cout << "| Endereço: " << endereco << " / CEP: " << fila.front()->getCEP() << endl;
            cout << "| Data: " << data << " / Status: " << status[fila.front()->getStatus()] << endl;
            cout << "*------------------------------------->" << endl;

            cout << "*------------------------------------------------------------------------*" << endl;
            cout << "| Opções: / 1- Definir como Em Análise / 2- Emitir Relatório / 0- Voltar |" << endl;
            cout << "*------------------------------------------------------------------------*" << endl;

            cout << "> "; cin >> option;

                    switch(option){
                    case 1:
                        if(fila.front()->getStatus()==Aguardando){
                            fila.front()->setStatus(Em_Analise);
                            atualizar=new Atualizar();
                            atualizar->atualizarDenuncia(fila.front());
                            delete atualizar;
                            cout << "*---------------------------------*" << endl;
                            cout << "| Denúncia movida para em análise |" << endl;
                            cout << "*---------------------------------*" << endl;
                        }else{
                            cout << "*-----------------------------------------*" << endl;
                            cout << "| Erro: Esta denúncia já está sob análise |" << endl;
                            cout << "*-----------------------------------------*" << endl;
                        }
                        break;
                    case 2:
                        realizarRelatorio(fila.front());
                        fila.pop();
                        if(fila.size()==0)option=0;
                        break;
                    case 0:
                        break;
                    default:
                        cout << "*-----------------------------*" << endl;
                        cout << "| Erro: Opção não reconhecida |" << endl;
                        cout << "*-----------------------------*" << endl;
                        break;
                    }
                    if(option!=0){
                        system("pause");
                        system("cls");
                        exibirLogo();
                    }
        }while(option != 0);
    }else{
        cout << "*---------------------------------------------*" << endl;
        cout << "| Não há denúncias aguardando análise na fila |" << endl;
        cout << "*---------------------------------------------*" << endl;
    }
    option=-1;
}

void listarUsuarios(){
    carregar=new Carregar();
    vector <Usuario*> usuarios=carregar->carregarUsuarios();
    string nome, cidade, tipo_user;

    option=-1;
    do{
        cout << "\n/-------------------\\" << endl;
        cout << "| Lista de Usuários |" << endl;
        cout << "---------------------\n" << endl;

        for(int i=0;i<usuarios.size();i++){
            nome=usuarios[i]->getNome()+" "+usuarios[i]->getSobrenome();
            cidade=usuarios[i]->getCidade()+"-"+usuarios[i]->getUF();
            if(usuarios[i]->getAdmin()==false)tipo_user="Usuário";
            else tipo_user="Administrador";

            cout << "*----------------->" << endl;
            cout << "| ID: " <<i<< " | Nome: " <<nome<< " | CPF: " <<usuarios[i]->getCPF()<< " | Cidade: " <<cidade<< " | Tipo de Cadastro: " <<tipo_user<< endl;
            cout << "*------------------------------------>" << endl;
        }

        cout << "*----------------------------------------------*" << endl;
        cout << "| Para mudar algum Usuário para Administrador, |" << endl;
        cout << "|   digite o ID do usuário ou -1 para sair     |" << endl;
        cout << "*----------------------------------------------*" << endl;
        cout << "> "; cin >> option;

        if(option>-1 && option<usuarios.size()){
            if(usuarios[option]->getAdmin()!=true){
                atualizar=new Atualizar();
                usuarios[option]->setAdmin(true);
                atualizar->atualizarUsuario(usuarios[option],2);
                delete atualizar;
                option=-1;
                cout << "*-----------------------*" << endl;
                cout << "| Alterado com sucesso! |" << endl;
                cout << "*-----------------------*" << endl;
                break;
            }else{
                cout << "*----------------------------------------------*" << endl;
                cout << "| Erro: Esse cadastro já é de um administrador |" << endl;
                cout << "*----------------------------------------------*" << endl;
            }
        }
        if(option!=0){
            system("pause");
            system("cls");
            exibirLogo();
        }
    }while(option!=-1);
    delete carregar;
}
