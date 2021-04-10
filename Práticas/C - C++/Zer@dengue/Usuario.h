#ifndef USUARIO_H_INCLUDED
#define USUARIO_H_INCLUDED

using namespace std;

class Usuario:public Endereco, public Cadastro{

private:
    int64_t CPF;
    string nome;
    string sobrenome;
    Date data_nasc;
    int FK_endereco;
    int FK_cadastro;
    Identificadores* carregar=new Identificadores();
public:
    Usuario();
    ~Usuario();
    Usuario(int64_t CPF, string nome, string sobrenome, Date data_nasc);
    Usuario(int64_t CPF, string nome, string sobrenome, Date data_nasc, int FK_endereco, int FK_cadastro);
    void setEndereco(string cidade, string UF, long int CEP,string rua, int numero, string bairro);
    void setEndereco(int ID_endereco, string cidade, string UF, long int CEP,string rua, int numero, string bairro);
    void setCadastro(string user, string senha, string email, int64_t FK_usuario);
    void setCadastro(int ID_cadastro, string user, string senha, string email, bool admin, int64_t FK_usuario);

    int64_t getCPF();
    void setCPF(int64_t CPF);

    string getNome();
    void setNome(string nome);

    string getSobrenome();
    void setSobrenome(string sobrenome);

    Date getDataNasc();
    short getDia();
    short getMes();
    short getAno();
    void setDataNasc(Date data_nasc);

    int getEnderecoFK();
    void setEnderecoFK(int FK_endereco);

    int getCadastroFK();
    void setCadastroFK(int FK_cadastro);
};


//CONSTRUTOR BÁSICO E DESTRUTOR
Usuario::Usuario(){}
Usuario::~Usuario(){}

//CONSTRUTORES CLASS USUARIO
Usuario::Usuario(int64_t CPF, string nome, string sobrenome, Date data_nasc){
    this->CPF=CPF;
    this->nome=nome;
    this->sobrenome=sobrenome;
    this->data_nasc=data_nasc;
    //Endereco(); //SEI PRA QUE ISSO NÃO...
}
Usuario::Usuario(int64_t CPF, string nome, string sobrenome, Date data_nasc, int FK_endereco, int FK_cadastro){
    this->CPF=CPF;
    this->nome=nome;
    this->sobrenome=sobrenome;
    this->data_nasc=data_nasc;
    this->FK_endereco=FK_endereco;
    this->FK_cadastro=FK_cadastro;
    //Endereco(); //SEI PRA QUE ISSO NÃO...
}

//"CONSTRUTORES" CLASS ENDERECO
void Usuario::setEndereco(string cidade, string UF, long int CEP,string rua, int numero, string bairro){
    this->ID_endereco=carregar->getNextID(1);
    this->cidade=cidade;
    this->UF=UF;
    this->CEP=CEP;
    this->rua=rua;
    this->numero=numero;
    this->bairro=bairro;
}
void Usuario::setEndereco(int ID_endereco, string cidade, string UF, long int CEP,string rua, int numero, string bairro){
    this->ID_endereco=ID_endereco;
    this->cidade=cidade;
    this->UF=UF;
    this->CEP=CEP;
    this->rua=rua;
    this->numero=numero;
    this->bairro=bairro;
}

//"CONSTRUTORES" CLASS CADASTRO
void Usuario::setCadastro(string user, string senha, string email, int64_t FK_usuario){
    this->ID_cadastro=carregar->getNextID(1);
    this->user=user;
    this->senha=senha;
    this->email=email;
    this->admin=false;
    this->FK_usuario=FK_usuario;
}
void Usuario::setCadastro(int ID_cadastro, string user, string senha, string email, bool admin, int64_t FK_usuario){
    this->ID_cadastro=ID_cadastro;
    this->user=user;
    this->senha=senha;
    this->email=email;
    this->admin=admin;
    this->FK_usuario=FK_usuario;
}

//GETTER AND SETTER
int64_t Usuario::getCPF(){
    return this->CPF;
}
void Usuario::setCPF(int64_t CPF){
    this->CPF=CPF;
}

string Usuario::getNome(){
    return this->nome;
}
void Usuario::setNome(string nome){
    this->nome=nome;
}

string Usuario::getSobrenome(){
    return this->sobrenome;
}
void Usuario::setSobrenome(string sobrenome){
    this->sobrenome=sobrenome;
}

Date Usuario::getDataNasc(){
    return this->data_nasc;
}
void Usuario::setDataNasc(Date data_nasc){
    this->data_nasc=data_nasc;
}

short Usuario::getDia(){
    return this->data_nasc.dia;
}
short Usuario::getMes(){
    return this->data_nasc.mes;
}
short Usuario::getAno(){
    return this->data_nasc.ano;
}

int Usuario::getEnderecoFK(){
    return this->FK_endereco;
}
void Usuario::setEnderecoFK(int FK_endereco){
    this->FK_endereco=FK_endereco;
}

int Usuario::getCadastroFK(){
    return this->FK_cadastro;
}
void Usuario::setCadastroFK(int FK_cadastro){
    this->FK_cadastro=FK_cadastro;
}

#endif // USUARIO_H_INCLUDED
