#ifndef ATUALIZAR_H_INCLUDED
#define ATUALIZAR_H_INCLUDED

using namespace std;

class Atualizar{
private:
    ofstream atualizar; //
    Carregar* carregar=new Carregar();
    int ID_vec; //Serve para salvar a posição no vector de usuários do usuário no qual vão ser atualizados os dados
public:
    Atualizar();
    void atualizarNextID(int type);
    void atualizarUsuario(Usuario* usuario, int type);
    void atualizarDenuncia(Denuncia* denuncia);
    /* 1- TESTAR PRA VER SE PRECISAR DE UM CONSTRUTOR PARA USAR MÉTODOS DA CLASSE
    */
};

//CONSTRUTOR
Atualizar::Atualizar(){}

//MÉTODOS DE ATUALIZAÇÃO DE DADOS
void Atualizar::atualizarNextID(int type){ //type: 0-Cadastro | 1-Endereço | 2-Denúncia | 3-Relatório |
    //Atualiza o próximo ID no txt da classe passada no type
    Identificadores* carregar=new Identificadores();
    vector <int> IDs=carregar->carregarNextID();

    IDs[type]++;
    atualizar.open("database//id.txt");
    for(int i=0;i<4;i++){
        if(i!=3)atualizar << IDs[i] << "_"; //"_" porque "-" dava comflito enquanto o ID era -1
        else atualizar << IDs[i];
    }
    atualizar.close();
}

void Atualizar::atualizarUsuario(Usuario* usuario, int type){ //type: 0- Usuário | 1- Endereço | 2- Cadastro |
    //Carregando lista de usuários salvas no txt e procurando o usuário passado na função
    vector <Usuario*> usuarios=carregar->carregarUsuarios();

    for(int i=0;i<usuarios.size();i++){
        if(usuarios[i]->getCPF() == usuario->getCPF()){
            ID_vec=i;
            break;
        }
    }

    usuarios[ID_vec]=usuario;
    //Atualiza dados do usuário dependendo do tipo passado no type
    switch(type){
    case 0: //Class Usuario
        atualizar.open("database//usuarios//usuarios.txt");
        try{
            for(int i=0;i<usuarios.size();i++){
                atualizar << usuarios[i]->getCPF() << "-";
                atualizar << usuarios[i]->getNome() << "-";
                atualizar << usuarios[i]->getSobrenome() << "-";
                atualizar << usuarios[i]->getDia() << "-";
                atualizar << usuarios[i]->getMes() << "-";
                atualizar << usuarios[i]->getAno() << "-";
                atualizar << usuarios[i]->getEnderecoFK() << "-";
                atualizar << usuarios[i]->getCadastroFK() << "\n";
            }
        }catch(exception& ex){
            cout << "> Erro: Não foi possível atualizar os dados <" << endl;
            cout << ex.what() << endl;
        }
        break;
    case 1: //Class Endereco
        atualizar.open("database//usuarios//enderecos.txt");
        try{
            for(int i=0;i<usuarios.size();i++){
                atualizar << usuarios[i]->getEnderecoID() << "-";
                atualizar << usuarios[i]->getCidade() << "-";
                atualizar << usuarios[i]->getUF() << "-";
                atualizar << usuarios[i]->getCEP() << "-";
                atualizar << usuarios[i]->getRua() << "-";
                atualizar << usuarios[i]->getNumero() << "-";
                atualizar << usuarios[i]->getBairro() << "\n";
            }
        }catch(exception& ex){
            cout << "> Erro: Não foi possível atualizar os dados <" << endl;
            cout << ex.what() << endl;
        }
        break;
    case 2: //Class Cadastro
        atualizar.open("database//usuarios//cadastros.txt");
        try{
            for(int i=0;i<usuarios.size();i++){
                atualizar << usuarios[i]->getCadastroID() << "-";
                atualizar << usuarios[i]->getUser() << "-";
                atualizar << usuarios[i]->getSenha() << "-";
                atualizar << usuarios[i]->getEmail() << "-";
                atualizar << usuarios[i]->getAdmin() << "-";
                atualizar << usuario->getUsuarioFK() << "\n";
            }
        }catch(exception& ex){
            cout << "> Erro: Não foi possível atualizar os dados <" << endl;
            cout << ex.what() << endl;
        }
        break;
    }
    atualizar.close();
}

void Atualizar::atualizarDenuncia(Denuncia* denuncia){
    vector <Denuncia*> denuncias=carregar->carregarDenuncia(false);

    for(int i=0;i<denuncias.size();i++){
        if(denuncias[i]->getDenunciaID() == denuncia->getDenunciaID()){
            ID_vec=i;
            break;
        }
    }
    denuncias[ID_vec]=denuncia;

    atualizar.open("database//denuncias//denuncias.txt");
    try{
        for(int i=0;i<denuncias.size();i++){
            atualizar << denuncias[i]->getDenunciaID() << "_";
            atualizar << denuncias[i]->getTitulo() << "_";
            atualizar << denuncias[i]->getDescricao() << "_";
            atualizar << denuncias[i]->getDia() << "_";
            atualizar << denuncias[i]->getMes() << "_";
            atualizar << denuncias[i]->getAno() << "_";
            atualizar << denuncias[i]->getStatus() << "_";
            atualizar << denuncias[i]->getEnderecoFK() << "_";
            atualizar << denuncias[i]->getUsuarioFK() << "_";
            atualizar << denuncias[i]->getRelatorioFK() << "\n";
        }
    }catch(exception& ex){
        cout << "> Erro: Não foi possível atualizar os dados <" << endl;
        cout << ex.what() << endl;
    }
}

#endif // ATUALIZAR_H_INCLUDED
