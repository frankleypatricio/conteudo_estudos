#ifndef CARREGAR_H_INCLUDED
#define CARREGAR_H_INCLUDED

using namespace std;

class Carregar{
public:
    vector <char*> proto; //Aqui pelo menos ele funciona direito... ¯\_(ツ)_/¯
    //Construtor
    Carregar();
    ~Carregar();
    //Carregar e verificar dados
    bool verificarCadastro(string usuario, string senha);
    int64_t getCPF();

    //Carregar e salvar dados
    Usuario* carregarUsuario(int64_t cpf); //Isso é para facilitar na hora de carregar os dados do usuário, após o login ter sido um sucesso, salva o cpf do usuário para carregar todos os dados depois
    vector <Usuario*> carregarUsuarios();
    vector <Denuncia*> carregarDenuncia(int64_t cpf); //CARREGAR DENÚNCIAS DO USUÁRIO (user)
    vector <Denuncia*> carregarDenuncia(bool ignore); //CARREGAR TODAS AS DENÚNCIAS (admin)
    Relatorio* carregarRelatorio(int FK_relatorio);
private:
    ifstream carregar; //Carregar dados do txt
    string linha; //Variável para receber a linha lida no txt (só aceita tipo string o getline())
    char dados[100]; //Variável para usar no strtok() para separar os dados (irá receber os dados da variável "linha")
    char* dado; //Variável que irá receber cada um dos dados cortados pelo strtok(), para depois salvar no vector
    //vector <char*> proto; //Tava dando treta ficar aqui...
    Date data; //Variável para guardar data depois de carregada do txt
    bool jump, done, falha; //jump: Usado em algumas funções para pular leituras inúteis / done= Usado em algumas funções para dizer que achou os dados buscados / falha= Usado em algumas funções para dizer que não encontrou os dados no txt ou nem conseguiu abrir
    int ID_vec; //Variável para guardar posição do vector do usuário/denúncia passada na função
    int64_t cpf; //Variável para carregar dados do usuário após Login, caso retorne verdadeiro
    char* pEnd; //Variável para usar no strtoll(), onde seu valor é auto definito ao converter um str pra um número (salva 1 para ir convertendo 1 por 1)
    //char to64[100]; //Variável substituta da string para usar no strtoll() para converter string para int x64
    int64_t int64; //Variável para guardar o int em x64
};

//CONSTRUTOR E DESTRUTOR
Carregar::Carregar(){}
Carregar::~Carregar(){}

//MÉTODOS DE VERIFICAÇÃO DE DADOS
bool Carregar::verificarCadastro(string usuario, string senha){
        bool result=false;
        vector <char*> verificar;
        carregar.open("database//usuarios//cadastros.txt");
        //Abre o txt e verifica se usuário e senha existem em alguma das linhas
        if(carregar.is_open()){
            while(getline(carregar,linha)){
                strcpy(dados, linha.c_str());
                dado=strtok(dados,"-");
                int i=0;
                while(dado != NULL){
                    verificar.push_back(dado);
                    dado=strtok(NULL,"-");
                }
                //Verifica se nome e senha existem na linha lida
                if(verificar[1]==usuario && verificar[2]==senha && result==false){
                    result=true;
                    this->cpf=strtoll(verificar[5],&pEnd,10);
                    break;
                }
                verificar.clear();
                if(result==true)break;
            }
        }else{
            cout << "> Erro: Não foi possível abrir o arquivo \"cadastros.txt\" <" << endl;
        }
        carregar.close();
        return result;
}
int64_t Carregar::getCPF(){
    return this->cpf;
}

//MÉTODOS DE CARREGAMENTO DE DADOS
Usuario* Carregar::carregarUsuario(int64_t cpf){
    Usuario* usuario;
    int fk_endereco;
    int fk_cadastro;
    done=false;

    //Class usuario
    carregar.open("database//usuarios//usuarios.txt");
    if(carregar.is_open()){
        while(getline(carregar,linha)){ //Obetendo linha de dados
            strcpy(dados, linha.c_str()); //Convertendo string para char para poder usar no strtoak()
            dado=strtok(dados,"-"); //Cortando string ao encontrar um "-" e salvando na var dado
            while(dado != NULL){
                proto.push_back(dado); //Tascando dado no vetor de protótipo pra depois mandar tudo pra classe
                dado=strtok(NULL,"-");
                int64=strtoll(proto[0],&pEnd,10); //Convertendo char* para int x64
                if(int64==cpf && done==false)done=true;
                if(int64!=cpf && done==false){proto.clear(); break;} //REVISA ISSO DEPOIS...
            }
            if(done==true){
                //VERIFICAR SE A ORDEM QUE SALVOU NO .txt ESTÁ IGUAL O DA CLASSE
                data.dia=atoi(proto[3]); //Convertendo dado pra valor númerico
                data.mes=atoi(proto[4]);
                data.ano=atoi(proto[5]);
                int64=strtoll(proto[0],&pEnd,10); //Convertendo char* para int x64
                usuario=new Usuario(int64,proto[1],proto[2],data,atoi(proto[6]),atoi(proto[7]));
                fk_endereco=atoi(proto[6]);
                fk_cadastro=atoi(proto[7]);
                proto.clear(); //Limpando memória do vector (o item continua lá, mas ao usar push_back() substitui ele)
                done=false;
                carregar.close();
                break;
            }
            proto.clear();
        }
    }else{
        cout << "> Erro: Não foi possível abrir o arquivo \"usuarios.txt\" <" << endl;
    }

    //Class Endereco
    carregar.open("database//usuarios//enderecos.txt");
    if(carregar.is_open()){
        while(getline(carregar,linha)){
            strcpy(dados, linha.c_str());
            dado=strtok(dados,"-");
            while(dado != NULL){
                proto.push_back(dado);
                dado=strtok(NULL,"-");
                if(atoi(proto[0])==fk_endereco && done==false)done=true;
                if(atoi(proto[0])!=fk_endereco && done==false){proto.clear(); break;}
            }
            if(done==true){
                usuario->setEndereco(atoi(proto[0]),proto[1],proto[2],atoi(proto[3]),proto[4],atoi(proto[5]),proto[6]);
                proto.clear();
                done=false;
                carregar.close();
                break;
            }
            proto.clear();
        }
    }else{
        cout << "> Erro: Não foi possível abrir o arquivo \"enderecos.txt\" <" << endl;
    }

    //Class Cadastro
    carregar.open("database//usuarios//cadastros.txt");
    if(carregar.is_open()){
        while(getline(carregar,linha)){
            strcpy(dados, linha.c_str());
            dado=strtok(dados,"-");
            while(dado != NULL){
                proto.push_back(dado);
                dado=strtok(NULL,"-");
                if(atoi(proto[0])==fk_cadastro && done==false)done=true;
                if(atoi(proto[0])!=fk_cadastro && done==false){proto.clear(); break;}
            }
            if(done==true){
                /*if(proto[5]=="1")admin=false;
                else admin=true; //Convertendo o verificador de admin pra bool*/
                int64=strtoll(proto[5],&pEnd,10); //Convertendo char* para int x64
                usuario->setCadastro(atoi(proto[0]),proto[1],proto[2],proto[3],atoi(proto[4]),int64); //Bool recebe int também
                proto.clear();
                done=false;
                carregar.close();
                break;
            }
            proto.clear();
        }
    }else{
        cout << "> Erro: Não foi possível abrir o arquivo \"cadastros.txt\" <" << endl;
    }
    return usuario;
}

vector <Usuario*> Carregar::carregarUsuarios(){
    vector <Usuario*> usuarios;
    Usuario* usuario;
    int fk_endereco;
    int fk_cadastro;
    jump=true; done=false;

    //Class usuario
    carregar.open("database//usuarios//usuarios.txt");
    if(carregar.is_open()){
        while(getline(carregar,linha)){
            strcpy(dados, linha.c_str());
            dado=strtok(dados,"-");
            while(dado != NULL){
                proto.push_back(dado);
                dado=strtok(NULL,"-");
            }
            data.dia=atoi(proto[3]);
            data.mes=atoi(proto[4]);
            data.ano=atoi(proto[5]);
            int64=strtoll(proto[0],&pEnd,10); //Convertendo char* para int x64
            usuario=new Usuario(int64,proto[1],proto[2],data,atoi(proto[6]),atoi(proto[7]));
            fk_endereco=atoi(proto[6]);
            fk_cadastro=atoi(proto[7]);
            usuarios.push_back(usuario);
            proto.clear();
        }
        carregar.close();
    }else{
        cout << "> Erro: Não foi possível abrir o arquivo \"usuarios.txt\" <" << endl;
    }

    //Class Endereco
    carregar.open("database//usuarios//enderecos.txt");
    if(carregar.is_open()){
        while(getline(carregar,linha)){
            strcpy(dados, linha.c_str());
            dado=strtok(dados,"-");
            while(dado != NULL){
                proto.push_back(dado);
                dado=strtok(NULL,"-");

                if(done==false){
                    for(int i=0;i<usuarios.size();i++){
                        if(atoi(proto[0])==usuarios[i]->getEnderecoFK()){
                            jump=false;
                            done=true;
                            ID_vec=i;
                            break;
                        }else{
                            jump=true;
                        }
                    }
                }
                if(jump==true){proto.clear(); break;}
            }
            if(jump==false && done==true){
                usuarios[ID_vec]->setEndereco(atoi(proto[0]),proto[1],proto[2],atoi(proto[3]),proto[4],atoi(proto[5]),proto[6]);
                proto.clear();
                jump=true;
                done=false;
            }
            proto.clear();
        }
        proto.clear();
        carregar.close();
    }else{
        cout << "> Erro: Não foi possível abrir o arquivo \"enderecos.txt\" <" << endl;
    }

    //Class Cadastro
    carregar.open("database//usuarios//cadastros.txt");
    if(carregar.is_open()){
        while(getline(carregar,linha)){
            strcpy(dados, linha.c_str());
            dado=strtok(dados,"-");
            while(dado != NULL){
                proto.push_back(dado);
                dado=strtok(NULL,"-");

                if(done==false){
                    for(int i=0;i<usuarios.size();i++){
                        if(atoi(proto[0])==usuarios[i]->getEnderecoFK()){
                            jump=false;
                            done=true;
                            ID_vec=i;
                            break;
                        }else{
                            jump=true;
                        }
                    }
                }
                if(jump==true){proto.clear(); break;}
            }
            if(jump==false && done==true){
                int64=strtoll(proto[5],&pEnd,10); //Convertendo char* para int x64
                usuarios[ID_vec]->setCadastro(atoi(proto[0]),proto[1],proto[2],proto[3],atoi(proto[4]),int64); //Bool recebe int também
                proto.clear();
                jump=true;
                done=false;
            }
            proto.clear();
        }
        proto.clear();
        carregar.close();
    }else{
        cout << "> Erro: Não foi possível abrir o arquivo \"cadastros.txt\" <" << endl;
    }
    return usuarios;
}

vector <Denuncia*> Carregar::carregarDenuncia(int64_t cpf){
    Denuncia* denuncia;
    vector <Denuncia*> denuncias;
    int ID_vec;
    Status status;
    jump=true; done=false; falha=false;
    //Class Denuncia
    carregar.open("database//denuncias//denuncias.txt");
    if(carregar.is_open()){
        while(getline(carregar,linha)){
            char dados2[linha.size()]; //Dados especial para denúncias (porque pode variar muito o tamanho da string, setamos o tamanho aqui)
            strcpy(dados2,linha.c_str());
            dado=strtok(dados2,"_");
            while(dado != NULL){
                proto.push_back(dado);
                dado=strtok(NULL,"_");
            }
            int64=strtoll(proto[8],&pEnd,10); //Convertendo char* para int x64
            if(int64==cpf && done==false)done=true;
            if(int64!=cpf && done==false){proto.clear(); break;}
            if(done==true){
                data.dia=atoi(proto[3]); //Convertendo dado pra valor númerico
                data.mes=atoi(proto[4]);
                data.ano=atoi(proto[5]);

                if(atoi(proto[6])==0)status=Aguardando; //Convertendo dados pro enum Status
                else if(atoi(proto[6])==1)status=Em_Analise;
                else if(atoi(proto[6])==2)status=Inconsistente;
                else status=Resolvido; //if(atoi(proto[6])==3)
                int64=strtoll(proto[8],&pEnd,10); //Convertendo char* para int x64
                denuncia=new Denuncia(atoi(proto[0]),proto[1],proto[2],data,status,atoi(proto[7]),int64,atoi(proto[9]));
                denuncias.push_back(denuncia);
                done=false;
            }
            proto.clear();
        }
        proto.clear();
        carregar.close();
    }else{
        cout << "> Erro: Não foi possível abrir o arquivo \"denuncias.txt\" <" << endl;
        falha=true;
    }

    //Class Endereco
    carregar.open("database//denuncias//enderecos.txt");
    if(carregar.is_open()){
        while(getline(carregar,linha)){
            strcpy(dados,linha.c_str());
            dado=strtok(dados,"-");
            while(dado!=NULL){
                proto.push_back(dado);
                dado=strtok(NULL,"-");
                if(done==false){
                    for(int i=0;i<denuncias.size();i++){
                        if(atoi(proto[0])==denuncias[i]->getEnderecoFK()){
                            jump=false;
                            done=true;
                            ID_vec=i;
                            break;
                        }else{
                            jump=true;
                        }
                    }
                }
                if(jump==true){proto.clear(); break;}
            }
            if(jump==false && done==true){
                denuncias[ID_vec]->setEndereco(atoi(proto[0]),proto[1],proto[2],atoi(proto[3]),proto[4],proto[5]);
                //proto.clear();
                jump=true;
                done=false;
            }
            proto.clear();
        }
        //proto.clear();
        carregar.close();
    }else{
        cout << "> Erro: Não foi possível abrir o arquivo \"enderecos.txt\" <" << endl;
        falha=true;
    }
    if(falha==true)denuncias.clear();
    return denuncias;
}

vector <Denuncia*> Carregar::carregarDenuncia(bool ignore){ //True- Carregar não analisados (Admin) / False- Carregar todos (Atualizar)
    Denuncia* denuncia;
    vector <Denuncia*> denuncias;
    Status status;
    jump=true; done=false; falha=false;


    //Class Denuncia
    carregar.open("database//denuncias//denuncias.txt");
    if(carregar.is_open()){
        while(getline(carregar,linha)){
            char dados2[linha.size()]; //Dados especial para denúncias (porque pode variar muito o tamanho da string, setamos o tamanho aqui)
            strcpy(dados2,linha.c_str());
            dado=strtok(dados2,"_");
            while(dado != NULL){
                proto.push_back(dado);
                dado=strtok(NULL,"_");
            }
            if(atoi(proto[9])==-1 || ignore==false){
                data.dia=atoi(proto[3]); //Convertendo dado pra valor númerico
                data.mes=atoi(proto[4]);
                data.ano=atoi(proto[5]);

                if(atoi(proto[6])==0)status=Aguardando; //Convertendo dados pro enum Status
                else if(atoi(proto[6])==1)status=Em_Analise;
                else if(atoi(proto[6])==2)status=Inconsistente;
                else status=Resolvido; //if(atoi(proto[6])==3)
                int64=strtoll(proto[8],&pEnd,10); //Convertendo char* para int x64
                denuncia=new Denuncia(atoi(proto[0]),proto[1],proto[2],data,status,atoi(proto[7]),int64,atoi(proto[9]));
                denuncias.push_back(denuncia);
            }
            proto.clear();
        }
        //proto.clear();
        carregar.close();
    }else{
        cout << "> Erro: Não foi possível abrir o arquivo \"denuncias.txt\" <" << endl;
        falha=true;
    }

    //Class Endereco
    carregar.open("database//denuncias//enderecos.txt");
    if(carregar.is_open()){
        while(getline(carregar,linha)){
            strcpy(dados,linha.c_str());
            dado=strtok(dados,"-");
            while(dado!=NULL){
                proto.push_back(dado);
                dado=strtok(NULL,"-");
                if(done==false){
                    for(int i=0;i<denuncias.size();i++){
                        if(atoi(proto[0])==denuncias[i]->getEnderecoFK()){
                            jump=false;
                            done=true;
                            ID_vec=i;
                            break;
                        }else{
                            jump=true;
                        }
                    }
                }
                if(jump==true){proto.clear(); break;}
            }
            if(jump==false && done==true){
                denuncias[ID_vec]->setEndereco(atoi(proto[0]),proto[1],proto[2],atoi(proto[3]),proto[4],proto[5]);
                jump=true;
                done=false;
            }
            proto.clear();
        }
        proto.clear();
        carregar.close();
    }else{
        cout << "> Erro: Não foi possível abrir o arquivo \"enderecos.txt\" <" << endl;
        falha=true;
    }
    if(falha==true)denuncias.clear();
    return denuncias;
}

Relatorio* Carregar::carregarRelatorio(int FK_relatorio){
    Relatorio* relatorio;
    done=false; falha=false;

    carregar.open("database//denuncias//relatorios.txt");
    if(carregar.is_open()){
        while(getline(carregar,linha)){
            char dados2[linha.size()]; //Dados especial para relatórios (porque pode variar muito o tamanho da string, setamos o tamanho aqui)
            strcpy(dados2,linha.c_str());
            dado=strtok(dados2,"-");
            while(dado != NULL){
                proto.push_back(dado);
                dado=strtok(NULL,"-");
                if(FK_relatorio==atoi(proto[0]) && done==false)done=true;
                if(FK_relatorio!=atoi(proto[0]) && done==false){proto.clear(); break;}
            }
            if(done==true){
                data.dia=atoi(proto[2]); //Convertendo dado pra valor númerico
                data.mes=atoi(proto[3]);
                data.ano=atoi(proto[4]);
                int64=strtoll(proto[5],&pEnd,10);
                relatorio=new Relatorio(atoi(proto[0]),proto[1],data,int64,proto[6]);
                done=false;
                break;
            }
            proto.clear();
        }
        proto.clear();
        carregar.close();
    }else{
        cout << "> Erro: Não foi possível abrir o arquivo \"relatorios.txt\" <" << endl;
        falha=true;
    }
    if(falha==true)delete relatorio;
    return relatorio;
}

#endif // CARREGAR_H_INCLUDED
