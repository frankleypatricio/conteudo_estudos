#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

#define SIZE 20
#define NULL ((void *)0)

typedef struct fila{
    int ID[SIZE];
    int frente;
    int tras;
    int contador;
} Fila;

Fila* criarFila(Fila* denuncia);
Fila* inserirItem(Fila* denuncia, int id_denuncia);
Fila* removerItem(Fila* denuncia);
Fila* orgazinarFila(Fila* denuncia);
int filaVazia(Fila* denuncia);
int filaExiste(Fila* denuncia);
void tamanhoFila(Fila* denuncia);
void sequenciaFila(Fila* denuncia);

void testar(Fila* denuncia);

int main(){
    setlocale(LC_ALL, "Portuguese");

    int opcao;
    int inserir;
    Fila* denuncias=NULL;

    do{
        printf("< Op��es >\n");
        printf("/ 0- Criar Fila / 1- Inserir Item / 2- Remover Item / 3- Fila Vazia? /\n/ 4- Tamanho da Fila / 5- Sequ�ncia Armazenada / 6- Sair /\n: ");
        scanf("%d", &opcao);

        switch(opcao){
        case 0:
            denuncias=criarFila(denuncias);
            break;
        case 1:
            printf("Digite o ID da den�ncia: ");
            scanf("%d", &inserir);
            denuncias=inserirItem(denuncias,inserir);
            break;
        case 2:
            denuncias=removerItem(denuncias);
            break;
        case 3:
            if(filaVazia(denuncias)){
                printf("A fila est� vazia");
            }else{
                printf("A fila n�o est� vazia");
            }
            break;
        case 4:
            tamanhoFila(denuncias);
            break;
        case 5:
            sequenciaFila(denuncias);
            break;
        case 6:
            printf("Finalizado\n");
            break;
        case 7:
            system("cls");
            break;
        default:
            printf("Op��o n�o reconhecida\n");
            break;
        }

        testar(denuncias);
        system("pause");
        system("cls");
    }while(opcao != 6);

    exit(0);
}

int filaExiste(Fila* denuncia){
    return denuncia != NULL;
}

Fila* criarFila(Fila* denuncia){
    if(!filaExiste(denuncia)){
        denuncia=(Fila*)malloc(sizeof(Fila));
        denuncia->contador=0;
        denuncia->frente=-1;
        denuncia->tras=0;
        printf("\nFila criada com sucesso!\n");
    }else{
        printf("\nErro: A fila j� foi criada\n");
    }
    return denuncia;
}

int filaVazia(Fila* denuncia){
    if(filaExiste(denuncia)){
        return denuncia->contador == 0;
    }else{
        return 0;
    }
}

Fila* inserirItem(Fila* denuncia, int id_denuncia){
    if(filaExiste(denuncia)){
        if(denuncia->contador >= SIZE){
            printf("\nErro: N�o foi poss�vel inserir um novo item, pois a fila est� cheia\n");
        }else{
            denuncia->ID[denuncia->tras++]=id_denuncia; //TESTAR ESSAS PARADA DE ++ E -- NO FINAL DAS VARS
            denuncia->frente=0;
            denuncia->contador++;
            printf("\nItem %d inserido com sucesso!\n",id_denuncia);
        }
    }else{
        printf("\nErro: A fila ainda n�o foi criada\n");
    }
    return denuncia;
}

Fila* removerItem(Fila* denuncia){
    if(filaExiste(denuncia) && !filaVazia(denuncia)){
        int remover=denuncia->ID[denuncia->frente];
        int escolha;

        printf("\nQuer mesmo remover o item %d da fila? (0= Sim/1= N�o)\n: ",remover);
        scanf("%d", &escolha);

        if(escolha == 0){
            denuncia->ID[denuncia->frente]=NULL;
            denuncia->tras--;
            denuncia->contador--;
            denuncia=orgazinarFila(denuncia);
            printf("\nItem %d removido com sucesso!\n",remover);
            if(filaVazia(denuncia)){ //SE A FILA ESTIVER VAZIA, O ITEM NA FRENTE SE TORNA -1, OU SEJA, NENHUM
                denuncia->frente--;
            }
        }else{
            printf("\nRemo��o do item %d cancelada\n",remover);
        }
    }else{
        printf("\nA fila est� vazia ou ainda n�o foi criada\n");
    }
    return denuncia;
}

Fila* orgazinarFila(Fila* denuncia){
    for(int i=0;i<denuncia->contador;i++){
        denuncia->ID[i]=denuncia->ID[i+1]; //VERIFICAR SE ISSO N�O EST� ATRIBUINDO VALOR AO i -TESTAR FORMAS DE INCREMENTO-
    }
    return denuncia;
}

void tamanhoFila(Fila* denuncia){
    if(filaExiste(denuncia)){
        printf("A fila cont�m %d itens",denuncia->contador);
    }else{
        printf("\nErro: A fila ainda n�o foi criada\n");
    }
}

void sequenciaFila(Fila* denuncia){
    if(filaExiste(denuncia) && !filaVazia(denuncia)){
        printf("\nSequ�ncia armazenada: -");
        for(int i=0;i<denuncia->contador;i++){
            printf("%d-",denuncia->ID[i]);
        }
    }else{
        printf("\nA fila est� vazia ou ainda n�o foi criada\n");
    }
}

void testar(Fila* denuncia){
    if(filaExiste(denuncia)){
        printf("\n--------TESTES--------\n");
        printf("Frente: %d \n",denuncia->frente);
        printf("Tr�s: %d \n",denuncia->tras);
        printf("Contador: %d",denuncia->contador);
        printf("\n--------TESTES--------\n");
    }
}
