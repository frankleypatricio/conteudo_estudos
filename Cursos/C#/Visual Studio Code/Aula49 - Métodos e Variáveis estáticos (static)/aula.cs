using System;
class Aula49{ //Métodos e Variáveis estáticos (static)
    static void Main(){
        Console.WriteLine("Dobro de pi é "+Matt.dobrar(Matt.pi)); //Acessando métodos e variáveis static
    }
}
class Matt{
    public static double pi=3.19; //A classe não é static, mas os métodos e variáveis são
    public static double dobrar(double num){
        return num*2;
    }
}