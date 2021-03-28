using System;

class Aula10{
    enum dificuldade{Fácil,Normal,Difícil,Muito_Difícil}; //Criando um enumerador, uma variável personalizada, que pode receber os valores pré-definidos
    static void Main(){
        dificuldade jogo1=dificuldade.Normal; //Atribuindo o valor "Fácil" à variável
        Console.WriteLine("Dificuldade do jogo1: "+jogo1);

        dificuldade jogo2=(dificuldade)0; //Atribuindo o valor da variável através do índice
        Console.WriteLine("Dificuldade do jogo2: "+jogo2);

        int indice = (int)(dificuldade)3; //Convertendo índice em int e atribuindo à variável
        Console.WriteLine("indice: "+indice);
        Console.WriteLine("(dificuldade)indice: "+(dificuldade)indice); //Exibindo a dificuldade através do índice salvo na variável
    }
}