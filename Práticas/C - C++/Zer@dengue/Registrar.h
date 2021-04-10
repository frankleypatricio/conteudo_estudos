#ifndef REGISTRAR_H_INCLUDED
#define REGISTRAR_H_INCLUDED

using namespace std;

class Registrar{
private:
    ofstream registrar;
    Atualizar* atualizar=new Atualizar();
public:
    Registrar();
    ~Registrar();
    void registrarUsuario(Usuario* usuario);
    void registrarDenuncia(Denuncia* denuncia);
    void registrarRelatorio(Relatorio* relatorio);
    void registarNextID(int next_ID, int type);
};

//CONSTRUTOR E DESTRUTOR
Registrar::Registrar(){}
Registrar::~Registrar(){}

//MÉTODOS DE REGISTRO DE DADOS
void Registrar::registrarUsuario(Usuario* usuario){
    //Abre os txt e registra os dados da classe usuário em seus respectivos txt
    try{
        //Class Usuario
        registrar.open("database//usuarios//usuarios.txt",ios::app);

        registrar << usuario->getCPF() << "-";
        registrar << usuario->getNome() << "-";
        registrar << usuario->getSobrenome() << "-";
        registrar << usuario->getDia() << "-";
        registrar << usuario->getMes() << "-";
        registrar << usuario->getAno() << "-";
        registrar << usuario->getEnderecoFK() << "-";
        registrar << usuario->getCadastroFK() << "\n";

        registrar.close();
        //Class Endereco
        registrar.open("database//usuarios//enderecos.txt",ios::app);

        registrar << usuario->getEnderecoID() << "-";
        registrar << usuario->getCidade() << "-";
        registrar << usuario->getUF() << "-";
        registrar << usuario->getCEP() << "-";
        registrar << usuario->getRua() << "-";
        registrar << usuario->getNumero() << "-";
        registrar << usuario->getBairro() << "\n";

        atualizar->atualizarNextID(1);
        registrar.close();

        //Class cadastro
        registrar.open("database//usuarios//cadastros.txt",ios::app);

        registrar << usuario->getCadastroID() << "-";
        registrar << usuario->getUser() << "-";
        registrar << usuario->getSenha() << "-";
        registrar << usuario->getEmail() << "-";
        registrar << usuario->getAdmin() << "-";
        registrar << usuario->getUsuarioFK() << "\n";

        atualizar->atualizarNextID(0);
        registrar.close();
    }catch(exception& ex){
        cout << "> Erro: Não foi possível realizar cadastro <" << endl;
        cout << ex.what() << endl;
    }
}

void Registrar::registrarDenuncia(Denuncia* denuncia){
    //Abre os txt e registra os dados da classe usuário em seus respectivos txt
    try{
        //Class Denuncia
        registrar.open("database//denuncias//denuncias.txt",ios::app);

        registrar << denuncia->getDenunciaID() << "_";
        registrar << denuncia->getTitulo() << "_";
        registrar << denuncia->getDescricao() << "_";
        registrar << denuncia->getDia() << "_";
        registrar << denuncia->getMes() << "_";
        registrar << denuncia->getAno() << "_";
        registrar << denuncia->getStatus() << "_";
        registrar << denuncia->getEnderecoFK() << "_";
        registrar << denuncia->getUsuarioFK() << "_"; //"_" porque "-" dava comflito enquanto o ID era -1 no relatórioFK
        registrar << denuncia->getRelatorioFK() << "\n";

        atualizar->atualizarNextID(2);
        registrar.close();

        //Class Endereco
        registrar.open("database//denuncias//enderecos.txt",ios::app);

        registrar << denuncia->getEnderecoID() << "-";
        registrar << denuncia->getCidade() << "-";
        registrar << denuncia->getUF() << "-";
        registrar << denuncia->getCEP() << "-";
        registrar << denuncia->getRua() << "-";
        registrar << denuncia->getBairro() << "\n";

        atualizar->atualizarNextID(1);
        registrar.close();
    }catch(exception& ex){
        cout << "> Erro: Não foi possível realizar denúncia <" << endl;
        cout << ex.what() << endl;
    }
}

void Registrar::registrarRelatorio(Relatorio* relatorio){
    //Abre os txt e registra os dados da classe usuário em seus respectivos txt
    try{
        //Class Relatório
        registrar.open("database//denuncias//relatorios.txt",ios::app);

        registrar << relatorio->getRelatorioID() << "-";
        registrar << relatorio->getRelatorio() << "-";
        registrar << relatorio->getDia() << "-";
        registrar << relatorio->getMes() << "-";
        registrar << relatorio->getAno() << "-";
        registrar << relatorio->getAdminFK() << "-";
        registrar << relatorio->getAdminName() << "\n";

        atualizar->atualizarNextID(3);
        registrar.close();
    }catch(exception& ex){
        cout << "> Erro: Não foi possível realizar relatório <" << endl;
        cout << ex.what() << endl;
    }
}

#endif // REGISTRAR_H_INCLUDED
