#ifndef RELATORIO_H_INCLUDED
#define RELATORIO_H_INCLUDED

using namespace std;

class Relatorio{

private:
    int ID_relatorio;
    string relatorio;
    Date data_relatorio;
    int64_t FK_admin;
    string admin_name;
    Identificadores* carregar=new Identificadores();

public:
    Relatorio();
    Relatorio(string relatorio, Date data_relatorio, int64_t FK_admin, string admin_name);
    Relatorio(int ID_relatorio, string relatorio, Date data_relatorio, int64_t FK_admin, string admin_name);

    int getRelatorioID();
    void setRelatorioID(int ID_relatorio);

    string getRelatorio();
    void setRelatorio(string relatorio);

    Date getDataRelatorio();
    short getDia();
    short getMes();
    short getAno();
    void setDataRelatorio(Date data_relatorio);

    int64_t getAdminFK();
    void setAdminFK(int64_t FK_admin);

    string getAdminName();
    void setAdminName(string admin_name);
};

//CONSTRUTORES
Relatorio::Relatorio(){}

Relatorio::Relatorio(string relatorio, Date data_relatorio, int64_t FK_admin, string admin_name){
    this->ID_relatorio=carregar->getNextID(3);
    this->relatorio=relatorio;
    this->data_relatorio=data_relatorio;
    this->FK_admin=FK_admin;
    this->admin_name=admin_name;
}
Relatorio::Relatorio(int ID_relatorio, string relatorio, Date data_relatorio, int64_t FK_admin, string admin_name){
    this->ID_relatorio=ID_relatorio;
    this->relatorio=relatorio;
    this->data_relatorio=data_relatorio;
    this->FK_admin=FK_admin;
    this->admin_name=admin_name;
}

//GETTER AND SETTER
int Relatorio::getRelatorioID(){
    return this->ID_relatorio;
}
void Relatorio::setRelatorioID(int ID_relatorio){
    this->ID_relatorio=ID_relatorio;
}

string Relatorio::getRelatorio(){
    return this->relatorio;
}
void Relatorio::setRelatorio(string relatorio){
    this->relatorio=relatorio;
}

Date Relatorio::getDataRelatorio(){
    return this->data_relatorio;
}
void Relatorio::setDataRelatorio(Date data_relatorio){
    this->data_relatorio=data_relatorio;
}

short Relatorio::getDia(){
    return this->data_relatorio.dia;
}
short Relatorio::getMes(){
    return this->data_relatorio.mes;
}
short Relatorio::getAno(){
    return this->data_relatorio.ano;
}

int64_t Relatorio::getAdminFK(){
    return this->FK_admin;
}
void Relatorio::setAdminFK(int64_t FK_admin){
    this->FK_admin=FK_admin;
}

string Relatorio::getAdminName(){
    return this->admin_name;
}
void Relatorio::setAdminName(string admin_name){
    this->admin_name=admin_name;
}

#endif // RELATORIO_H_INCLUDED
