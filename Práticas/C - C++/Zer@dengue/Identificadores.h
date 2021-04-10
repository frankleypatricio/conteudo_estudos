#ifndef IDENTIFICADORES_H_INCLUDED
#define IDENTIFICADORES_H_INCLUDED

using namespace std;

class Identificadores{
private:
    ifstream carregar; //Carregar dados do txt
    ofstream criar; //Registrar dados no txt
    string linha; //Vari�vel para receber a linha lida no txt (s� aceita tipo string o getline())
    char dados[100]; //Vari�vel para usar no strtok() para separar os dados (ir� receber os dados da vari�vel "linha")
    char* dado; //Vari�vel que ir� receber cada um dos dados cortados pelo strtok(), para depois salvar no vector
public:
    Identificadores();
    void setNextID();
    vector <int> carregarNextID();
    int getNextID(int type);
};

//Construtor
Identificadores::Identificadores(){}

//M�todos de carregamento dos IDs
void Identificadores::setNextID(){
    //Caso seja a primeira vez que usa o programa, seta os IDs padr�es
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
        //cout << "> Erro: N�o foi poss�vel abrir o arquivo \"id.txt\" <" << endl;
        setNextID();
        for(int i=0;i<4;i++){
            next_IDs.push_back(-1);
        }
    }
    carregar.close();
    return next_IDs;
}

int Identificadores::getNextID(int type){ //0-Cadastro | 1-Endere�o | 2-Den�ncia | 3-Relat�rio |
    //Retorna pr�ximo ID da classe passada no type (� um auto-increment manual)
    vector <int> IDs=carregarNextID();
    return ++IDs[type];
}

#endif // IDENTIFICADORES_H_INCLUDED
