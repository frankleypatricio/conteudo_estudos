using System;
class Program{
    static void Main(){
        int aula;
        Console.Write("Aula N°: ");
        aula = int.Parse(Console.ReadLine());
        aulas(aula);

        //Console.ReadKey();
    }
    static void aulas(int aula){
        switch(aula){
            case 9:
            /* ----- Aula 09: Operações de Bitwise ----- */   
            int num=20;
            Console.WriteLine("num= "+num);
            num=num<<3; // O operador bitwise " << " dobra o valor de num na quantidade de vezes definida (no caso, o " 3 ")
            Console.WriteLine("num<<3= "+num);
            num=num>>3; // O operador bitwise " >> " corta o valor pela metade na quantidade de vezes definida (no caso, o " 1 ")
            Console.WriteLine("num>>1= "+num);
            break;
/*-------------------------------------------------------------------*/
            case 11:
            /* ----- Aula 11: Conversões de tipos (typecast) ----- */   
            //Conversão inplícita
            int n1=10;
            float n2=n1; //Exemplo de conversão inplícita, onde o tipo float suporta um tipo int
            Console.WriteLine("n1= "+n1+" / n2= "+n2);

            //Conversão explícita
            float n3=10.5f;
            //int n4=n3; << Exemplo de não conversão inplícita, onde o tipo int não suporta um tipo float
            int n4=(int)n3; //Usando o typecast para fazer uma conversão explícita, onde 10.5 vira 10, removendo os decimais
            Console.WriteLine("n3= "+n3+" / n4= "+n4);

            //Conversões de variáveis muito diferentes (não sei o termo certo)
            string n5="1";
            int n6=int.Parse(n5); //1 Forma: Converte n5 em um tipo int
            Console.WriteLine("n5= "+n5+" / n6= "+n6);

            double n7=12.50; //Usei double porque o float não salva o 0 no final...
            string n8=Convert.ToString(n7); //2 Forma: Converte n7 em um tipo string
            //Obs:    ^^^^^^ não existe um "string.Parse()"... Talvez só tenha pra números...
            Console.WriteLine("n7= {0:c} / n8= {1:c}", n7,n8); //Ao converter pra string, perdeu o 0...
            //Obs:                             ^^^^^ Detalhe pro não funcionamento do " :c " em strings...
            break;
/*-------------------------------------------------------------------*/
            case 16:
            /* ----- Aula 16: Goto ----- */   
            aula16: //Criando uma label para o goto identificar
            int num16=0;
            char sair='s';

            Console.WriteLine(": ");
            num16=int.Parse(Console.ReadLine());
            Console.WriteLine("num: "+num16);

            Console.WriteLine("Sair? s/n");
            sair=char.Parse(Console.ReadLine());
            if(sair == 'n'){
                goto aula16; //Retorna a label delcarada com o nome passado
            }
            
            break;
/*-------------------------------------------------------------------*/
            case 17:
            /* ----- Aula 17: Array / Vetor ----- */   
            int[] array1=new int[2]; //Declara um array de int como 2 posições (0 e 1)
            array1[0]=1; //Atribuindo valor à posição 0
            array1[1]=2; //Atribuindo valor à posição 1

            int[] array2=new int[3]{0,1,2}; //Declarando um array já passando os valores de suas posições

            int[] array3={0,1,2,4}; //Declarando um array já passando os valores de suas posições, porém seu tamanho é definido pelo número de valores passados

            for(int i=0;i<array1.Length;i++){
                Console.WriteLine("Volta N°:"+i+" / Array1: "+array1[i]);
            }
            for(int i=0;i<array2.Length;i++){
                Console.WriteLine("Volta N°:"+i+" / Array2: "+array2[i]);
            }
            for(int i=0;i<array3.Length;i++){
                Console.WriteLine("Volta N°:"+i+" / Array3: "+array3[i]);
            }
            break;
/*-------------------------------------------------------------------*/
            case 18:
            /* ----- Aula 18: Matrizes / Vetores ----- */   
            //                Linha / Coluna
            int[,] matriz1=new int[3,3]; //Declara uma matriz de int como 2 posições (0 e 1) (ATENÇÃO PRA " , " DENTRO DOS " [] ", QUE É O QUE DEFINE QUE É MATRIZ "[,]")
            //             [0]              [1]             [2]
            /*[0]*/ matriz1[0,0]=10; matriz1[0,1]=40; matriz1[0,2]=70;
            /*[1]*/ matriz1[1,0]=20; matriz1[1,1]=50; matriz1[1,2]=80;
            /*[2]*/ matriz1[2,0]=30; matriz1[2,1]=60; matriz1[2,2]=90;

            int[,] matriz2=new int[3,2]{{10,85},{11,858},{25,99}}; //Declarando uma matriz já passando os valores de suas posições

            int[,] matriz3={{50,60,87},{15,89,62}}; //Declarando uma matriz já passando os valores de suas posições, porém o número de linhas e colunas é definido com base no que foi passado
            
            Console.WriteLine("     1    2    3  ");
            Console.WriteLine("1  [{0}] [{1}] [{2}]\n"+
                              "2  [{3}] [{4}] [{5}]\n"+
                              "3  [{6}] [{7}] [{8}]",
            matriz1[0,0],matriz1[0,1],matriz1[0,2],
            matriz1[1,0],matriz1[1,1],matriz1[1,2],
            matriz1[2,0],matriz1[2,1],matriz1[2,2]);
            break;
/*-------------------------------------------------------------------*/
            case 22:
            /* ----- Aula 22: Foreach ----- */   
            int[] num22 = new int[5]{20,25,87,63,74};

            foreach(int e in num22){ //Atribui a variável todos os elementos contidos no array (devem ser do mesmo tipo, a variável do foreach e a dos elementos)
                Console.WriteLine("num22: "+e);
            }
            break;
/*-------------------------------------------------------------------*/
            case 23:
            /* ----- Aula 23: Random e Métodos para Arrays ----- */   
            int[] vetor1_23=new int[5];
            int[] vetor2_23=new int[5];
            int[] vetor3_23=new int[5];
            int[] vetor4_23=new int[]{5,4,3,2,4};
            int[,] matriz_23=new int[2,5]{{1,2,3,4,5},{20,19,18,17,16}};

            Random random=new Random(); //Cria uma variável do tipo random
            for(int i=0;i<vetor1_23.Length;i++){
                vetor1_23[i]=random.Next(50); //Sorteia um número inteiro de 0-49.
                //vetor1_23[i]=random.Next(50,100); Esse aqui é passado um valor mínimo(50) e um máximo(100) para o sorteio
                //vetor1_23[i]=random.Next(); Sem nada ele retorna um número inteiro qualquer
            }

            Console.WriteLine("Elementos do Vetor1");
            foreach(int n in vetor1_23){
                Console.Write(n+"-");
            }
            Console.WriteLine("_____________________________________________________");
            /*Métodos para Arrays*/

            //public static int BinarySearch(array,valor);
            Console.WriteLine("< BinarySearch >");
            int procurando=33;
            int posicao=Array.BinarySearch(vetor1_23,procurando); //Procura no vetor especificado, o valor passado
            Console.WriteLine("Valor {0} está na posição {1}", procurando,posicao); //Se existir, irá retornar sua posição, se não retornará " -1 "
            Console.ReadKey();
            Console.WriteLine("_____________________________________________________");

            //public static void Copy(array_origem,array_destino,qtd_elementos);
            Console.WriteLine("< Copy >");
            Array.Copy(vetor1_23,vetor2_23,vetor1_23.Length); //Copia do vetor1 para o vetor2 a quantidade de dados especificada (no caso, todos)
            foreach(int n in vetor2_23){
                Console.Write(n+"-");
            }
            Console.ReadKey();
            Console.WriteLine("_____________________________________________________");

            //public static void CopyTo(array_destino,posicao_inicial);
            Console.WriteLine("< CopyTo >");
            vetor1_23.CopyTo(vetor3_23,0); //Copia os itens do vetor1 para o vetor3, a partir da posição passada (detalhe pra esse método que é chamado direto da variável, não da classe "Array")
            foreach(int n in vetor3_23){
                Console.Write(n+"-");
            }
            Console.ReadKey();
            Console.WriteLine("_____________________________________________________");

            //public long GetLongLength(dimensão);
            Console.WriteLine("< GetLongLength >");
            long qtd_elementos=vetor1_23.GetLongLength(0); //Retorna a quantidade de elementos de um vetor ou matriz, onde a dimensão 0=linha e 1=coluna (vetor só usa 0)
            Console.WriteLine("Quantidade de elementos: "+qtd_elementos);
            Console.ReadKey();
            Console.WriteLine("_____________________________________________________");
            
            //public int GetLowerBound(dimensão);
            Console.WriteLine("< GetLowerBound >");
            int menor_indice_linha=matriz_23.GetLowerBound(0); //Obtêm o menor índice da linha da matriz (mesma regra do GetLongLenght, 0=linha e 1=coluna (vetor só usa 0))
            int menor_indice_coluna=matriz_23.GetLowerBound(1); //Obtêm o menor índice da coluna da matriz
            Console.WriteLine("Menor índice da linha: {0} - coluna: {1}", menor_indice_linha, menor_indice_coluna);
            Console.ReadKey();
            Console.WriteLine("_____________________________________________________");

            //public int GetUpperBound(dimensão);
            Console.WriteLine("< GetUpperBound >");
            int maior_indice_linha=matriz_23.GetLowerBound(0); //Obtêm o maior índice da linha da matriz
            int maior_indice_coluna=matriz_23.GetLowerBound(1); //Obtêm o maior índice da linha da matriz
            Console.WriteLine("Maior índice da linha: {0} - coluna: {1}", maior_indice_linha, maior_indice_coluna);
            Console.ReadKey();
            Console.WriteLine("_____________________________________________________");

            //public object GetValue(long índice);   <-- É object porque o array pode ser int, string, bool, ou mesmo um object, por isso dela retornar um object
            Console.WriteLine("< GetValue >");
            int valor_vetor=(int)vetor1_23.GetValue(3); //Retorna o valor do vetor contido na posição passada (como o método retorna um object, tivemos que converter pra int)
            int valor_matriz=(int)matriz_23.GetValue(1,3); //Mesma coisa, porém com uma matriz
            Console.WriteLine("Vetor: {0} - Matriz: {1}", valor_vetor, valor_matriz);
            Console.ReadKey();
            Console.WriteLine("_____________________________________________________");

            //public static int IndexOf(array,valor);
            Console.WriteLine("< IndexOf >");
            int indice_primeiro_valor=Array.IndexOf(vetor4_23,4); //Retorna o primeiro índice do valor encontrado no vetor (ou seja, se tiver {5,5,3} e você procurar o 5, irá retornar 0 porque foi a primeira posição encontrada com o numero 5)
            Console.WriteLine("Primeiro índice com o valor 4: "+indice_primeiro_valor);
            Console.ReadKey();
            Console.WriteLine("_____________________________________________________");

            //public static int LastIndexOf(array,valor);
            Console.WriteLine("< LastIndexOf >");
            int indice_ultimo_valor=Array.LastIndexOf(vetor4_23,4); //Retorna o último índice do valor encontrado no vetor (ou seja, se tiver {5,5,3} e você procurar o 5, irá retornar 1 porque foi a última posição encontrada com o numero 5)
            Console.WriteLine("Último índice com o valor 4: "+indice_ultimo_valor);
            Console.ReadKey();
            Console.WriteLine("_____________________________________________________");

            //public static void Reverse(array);
            Console.WriteLine("< Reverse >");
            Array.Reverse(vetor1_23); //Inverte a ordem dos elementos (1, 2, 3 vira 3, 2, 1)
            foreach(int n in vetor1_23){
                Console.WriteLine(n);
            }
            Console.ReadKey();
            Console.WriteLine("_____________________________________________________");

            //public void SetValue(object valor, long pos);
            Console.WriteLine("< Set Value >");
            vetor2_23.SetValue(99,0); //Seta um valor na posição passada do vetor
            for(int i=0;i<vetor2_23.Length;i++){
                vetor2_23.SetValue(0,i);
            }
            Console.WriteLine("Vetor 2");
            foreach(int n in vetor2_23){
                Console.WriteLine(n);
            }
            Console.ReadKey();
            Console.WriteLine("_____________________________________________________");

            //public static void Sort(array);
            Console.WriteLine("< Sort >");
            Array.Sort(vetor1_23); //Ordena elementos do vetor
            Array.Sort(vetor2_23);
            Array.Sort(vetor3_23);
            Console.WriteLine("\nVetor 1");
            foreach(int n in vetor1_23){
                Console.WriteLine(n);
            }
            Console.WriteLine("\nVetor 2");
            foreach(int n in vetor2_23){
                Console.WriteLine(n);
            }
            Console.WriteLine("\nVetor 3");
            foreach(int n in vetor3_23){
                Console.WriteLine(n);
            }
            Console.ReadKey();
            Console.WriteLine("_____________________________________________________");

            break;
/*-------------------------------------------------------------------*/
            default:
            Console.WriteLine("Digita aí uma aula que exista né jou...");
            Console.ReadKey();
            Console.Clear();
            Main();
            break;                        
        }
        Console.ReadKey();
        Console.Clear();
    }
}