using System;
class Aula42{
    static void Main(){ //Indexadores de Classes
        Processadores processador=new Processadores();
        processador[0]="Ryzen 5 3400G"; //Passando valor pelo indexador (até rimo, datebayo)
        processador[1]="Intel i5 9400F";
        Console.WriteLine("1: "+processador[0]); //Pegando valor pelo indexador (até rimo de novo)
        Console.WriteLine("2: "+processador[1]);
    }
}
class Processadores{
    public string[] gen=new string[5];
    public string this[int i]{ //O this indica que é um indexador
        get{
            return gen[i];
        }
        set{
            gen[i]=value;
        }
    }
}