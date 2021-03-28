using System;
class Aula40{ //Classe Sealed
    static void Main(){
        Herdeira herdeira= new Herdeira();
        herdeira.show();
    }
}
sealed class Selada{ //Sealed não pode ser herdada
    public int S;
    public Selada(){
        S=10;
    }
}
class Liberada{
    public int L;
    public Liberada(){
        L=20;
    }
}
//class Herdeira:Selada{ <- Não pode herdar uma classe sealed
class Herdeira:Liberada{
    public int H;
    public Herdeira(){
        H=30;
    }
    public void show(){
        //Console.WriteLine("S: "+S); //Classe selada
        Console.WriteLine("L: "+L);
        Console.WriteLine("H: "+H);
    }
}