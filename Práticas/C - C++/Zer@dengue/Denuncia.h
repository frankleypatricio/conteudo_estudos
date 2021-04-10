#ifndef DENUNCIA_H_INCLUDED
#define DENUNCIA_H_INCLUDED

using namespace std;

class Denuncia:public Endereco{

private:
    int ID_denuncia;
    string titulo;
    string descricao;
    Date data_denuncia;
    Status status;
    int FK_endereco;
    int64_t FK_usuario;
    int FK_relatorio;
    Identificadores* carregar=new Identificadores();
public:
    Denuncia(string titulo, string descricao, Date data_denuncia, int64_t FK_usuario);
    Denuncia(int ID_denuncia, string titulo, string descricao, Date data_denuncia, Status status, int FK_endereco, int64_t FK_usuario, int FK_relatorio);
    void setEndereco(string cidade, string UF, long int CEP,string rua, string bairro);
    void setEndereco(int ID_endereco, string cidade, string UF, long int CEP,string rua, string bairro);

    int getDenunciaID();
    void setDenunciaID(int ID_denuncia);

    string getTitulo();
    void setTitulo(string titulo);

    string getDescricao();
    void setDescricao(string descricao);

    Date getDataDenuncia();
    short getDia();
    short getMes();
    short getAno();
    void setDataDenuncia(Date data_denuncia);

    Status getStatus();
    void setStatus(Status status);

    int getEnderecoFK();
    void setEnderecoFK(int FK_endereco);

    int64_t getUsuarioFK();
    void setUsuarioFK(int64_t FK_usuario);

    int getRelatorioFK();
    void setRelatorioFK(int FK_relatorio);
};

//CONSTRUTORES CLASS DENUNCIA
Denuncia::Denuncia(string titulo, string descricao, Date data_denuncia, int64_t FK_usuario){
    this->ID_denuncia=carregar->getNextID(2);
    this->titulo=titulo;
    this->descricao=descricao;
    this->data_denuncia=data_denuncia;
    this->status=Aguardando;
    this->FK_usuario=FK_usuario;
    this->FK_relatorio=-1;
}
Denuncia::Denuncia(int ID_denuncia, string titulo, string descricao, Date data_denuncia, Status status, int FK_endereco, int64_t FK_usuario, int FK_relatorio){
    this->ID_denuncia=ID_denuncia;
    this->titulo=titulo;
    this->descricao=descricao;
    this->data_denuncia=data_denuncia;
    this->status=status;
    this->FK_endereco=FK_endereco;
    this->FK_usuario=FK_usuario;
    this->FK_relatorio=FK_relatorio;
}

//CONSTRUTORES CLASS ENDERECO
void Denuncia::setEndereco(string cidade, string UF, long int CEP, string rua, string bairro){
    this->ID_endereco=carregar->getNextID(1);
    this->cidade=cidade;
    this->UF=UF;
    this->CEP=CEP;
    this->rua=rua;
    this->bairro=bairro;
}
void Denuncia::setEndereco(int ID_endereco, string cidade, string UF, long int CEP, string rua, string bairro){
    this->ID_endereco=ID_endereco;
    this->cidade=cidade;
    this->UF=UF;
    this->CEP=CEP;
    this->rua=rua;
    this->bairro=bairro;
}

//GETTER AND SETTER
int Denuncia::getDenunciaID(){
    return this->ID_denuncia;
}
void Denuncia::setDenunciaID(int ID_denuncia){
    this->ID_denuncia=ID_denuncia;
}

string Denuncia::getTitulo(){
    return this->titulo;
}
void Denuncia::setTitulo(string titulo){
    this->titulo=titulo;
}

string Denuncia::getDescricao(){
    return this->descricao;
}
void Denuncia::setDescricao(string descricao){
    this->descricao=descricao;
}

Date Denuncia::getDataDenuncia(){
    return this->data_denuncia;
}
void Denuncia::setDataDenuncia(Date data_denuncia){
    this->data_denuncia=data_denuncia;
}

short Denuncia::getDia(){
    return this->data_denuncia.dia;
}
short Denuncia::getMes(){
    return this->data_denuncia.mes;
}
short Denuncia::getAno(){
    return this->data_denuncia.ano;
}

Status Denuncia::getStatus(){
    return this->status;
}
void Denuncia::setStatus(Status status){
    this->status=status;
}

int Denuncia::getEnderecoFK(){
    return this->FK_endereco;
}
void Denuncia::setEnderecoFK(int FK_endereco){
    this->FK_endereco=FK_endereco;
}

int64_t Denuncia::getUsuarioFK(){
    return this->FK_usuario;
}
void Denuncia::setUsuarioFK(int64_t FK_usuario){
    this->FK_usuario=FK_usuario;
}

int Denuncia::getRelatorioFK(){
    return this->FK_relatorio;
}
void Denuncia::setRelatorioFK(int FK_relatorio){
    this->FK_relatorio=FK_relatorio;
}

#endif // DENUNCIA_H_INCLUDED
