#ifndef CADASTRO_H_INCLUDED
#define CADASTRO_H_INCLUDED

using namespace std;

class Cadastro{
protected:
    Cadastro();

    int ID_cadastro;
    string user;
    string senha;
    string email;
    bool admin; //Se o usuário é um administrador ou não (false por padrão)
    int64_t FK_usuario;

public:
    int getCadastroID();
    void setCadastroID(int ID_cadastro);

    string getUser();
    void setUser(string user);

    string getSenha();
    void setSenha(string senha);

    string getEmail();
    void setEmail(string email);

    bool getAdmin(); //TALVEZ PRIVATE
    void setAdmin(bool admin);

    int64_t getUsuarioFK();
    void setUsuarioFK(int64_t FK_usuario);
};

//CONSTRUTOR
Cadastro::Cadastro(){}

//GETTER AND SETTER
int Cadastro::getCadastroID(){
    return this->ID_cadastro;
}
void Cadastro::setCadastroID(int ID_cadastro){
    this->ID_cadastro=ID_cadastro;
}

string Cadastro::getUser(){
    return this->user;
}
void Cadastro::setUser(string user){
    this->user=user;
}

string Cadastro::getSenha(){
    return this->senha;
}
void Cadastro::setSenha(string senha){
    this->senha=senha;
}

string Cadastro::getEmail(){
    return this->email;
}
void Cadastro::setEmail(string email){
    this->email=email;
}

bool Cadastro::getAdmin(){
    return this->admin;
}
void Cadastro::setAdmin(bool admin){
    this->admin=admin;
}

int64_t Cadastro::getUsuarioFK(){
    return this->FK_usuario;
}
void Cadastro::setUsuarioFK(int64_t FK_usuario){
    this->FK_usuario=FK_usuario;
}

#endif // CADASTRO_H_INCLUDED
