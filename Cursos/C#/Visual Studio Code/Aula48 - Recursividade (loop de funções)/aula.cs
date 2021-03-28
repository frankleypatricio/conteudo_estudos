using System;
class Aula48{ //Recursividade (loop de funções)
    static void Main(){
        Console.Write("> ");
        int num=int.Parse(Console.ReadLine());
        int result=fatorial(num);
        Console.WriteLine("Fatorial de {0} é {1}",num,result);
    }

    static public int fatorial(int num){
        int result=0;
        if(num<=1) result=1;
        else result=num*fatorial(--num); //A função é chamada dentro dela mesma, gerando um loop
        return result;
    }
}