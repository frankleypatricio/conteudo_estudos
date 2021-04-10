#ifndef IDENTIFICADORES_H_INCLUDED
#define IDENTIFICADORES_H_INCLUDED

using namespace std;

class Identificadores{
private:
    ifstream carregar; //Carregar dados do txt
    ofstream criar; //Registrar dados no txt
    string linha; //Variável para receber a linha lida no txt (só aceita tipo string o getline())
    char dados[100]; //Variável para usar no strtok() para separar os dados (irá receber os dados da variável "linha")
    char* dado; //Variável que irá receber cada um dos dados cortados pelo strtok(), para depois salvar no vector
public:
    Identificadores();
    void setNextID();
    vector <int> carregarNextID();
    int getNextID(int type);
};

//Construtor
Identificadores::Identificadores(){}

//Métodos de carregamento dos IDs
void Identificadores::setNextID(){
    //Caso seja a primeira vez que usa o programa, seta os IDs padrões
    criar.open("database//id.txt");
    criar << -1 << "_" << -1 << "_" << -1 << "_" << -1; //"_" porque "-" dava comflito enquanto o ID era -1
    criar.close();
}

vector <int> Identificadores::carregarNextID(){
    //Carrega os IDs do txt, os separa e salva em um vector
    vector <int> next_IDs;
    carregar.open("database//id.txt");
    if(carregar.is_open()){
        getline(carregar,linha);
        strcpy(dados,linha.c_str());
        dado=strtok(dados,"_"); //"_" porque "-" dava comflito enquanto o ID era -1
        while(dado != NULL){
            next_IDs.push_back(atoi(dado));
            dado=strtok(NULL,"_"); //"_" porque "-" dava comflito enquanto o ID era -1
        }
    }else{
        //cout << "> Erro: Não foi possível abrir o arquivo \"id.txt\" <" << endl;
        setNextID();
        for(int i=0;i<4;i++){
            next_IDs.push_back(-1);
        }
    }
    carregar.close();
    return next_IDs;
}

int Identificadores::getNextID(int type){ //0-Cadastro | 1-Endereço | 2-Denúncia | 3-Relatório |
    //Retorna próximo ID da classe passada no type (é um auto-increment manual)
    vector <int> IDs=carregarNextID();
    return ++IDs[type];
}

#endif // IDENTIFICADORES_H_INCLUDED
