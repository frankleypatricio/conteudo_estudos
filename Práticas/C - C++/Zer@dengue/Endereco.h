#ifndef ENDERECO_H_INCLUDED
#define ENDERECO_H_INCLUDED

using namespace std;

class Endereco{
protected:
    Endereco();

    int ID_endereco;
    string cidade;
    string UF;
    long int CEP;
    string rua;
    int numero;
    string bairro;
public:
    int getEnderecoID();
    void setEnderecoID(int ID_endereco);

    string getCidade();
    void setCidade(string cidade);

    string getUF();
    void setUF(string UF);

    long int getCEP();
    void setCEP(long int CEP);

    string getRua();
    void setRua(string rua);

    int getNumero();
    void setNumero(int numero);

    string getBairro();
    void setBairro(string bairro);
};

//CONSTRUTOR
Endereco::Endereco(){};

//GETTER AND SETTER
int Endereco::getEnderecoID(){
    return this->ID_endereco;
}
void Endereco::setEnderecoID(int ID_endereco){
    this->ID_endereco=ID_endereco;
}

string Endereco::getCidade(){
    return this->cidade;
}
void Endereco::setCidade(string cidade){
    this->cidade=cidade;
}

string Endereco::getUF(){
    return this->UF;
}
void Endereco::setUF(string UF){
    this->UF=UF;
}

long int Endereco::getCEP(){
    return this->CEP;
}
void Endereco::setCEP(long int CEP){
    this->CEP=CEP;
}

string Endereco::getRua(){
    return this->rua;
}
void Endereco::setRua(string rua){
    this->rua=rua;
}

int Endereco::getNumero(){
    return this->numero;
}
void Endereco::setNumero(int numero){
    this->numero=numero;
}

string Endereco::getBairro(){
    return this->bairro;
}
void Endereco::setBairro(string bairro){
    this->bairro=bairro;
}

#endif // ENDERECO_H_INCLUDED
