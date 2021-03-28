using System;
class Aula43{ //Interfaces
    static void Main(){
        Carro carro=new Carro();
        carro.ligar();
        carro.desligar();
    }
}
interface Motor{ //Uma interface é tipo um contrato dos métodos que a classe deve ter, assim sendo obrigatório implementá-los
    //public bool ligado; <- Interfaces não pode ter propriedades
    void ligar();
    void desligar();
}
class Carro:Motor{
    private bool ligado;
    public Carro(){
        ligado=false;
    }
    public void ligar(){
        ligado=true;
        Console.WriteLine("Carro ligado");
    }
    public void desligar(){
        ligado=false;
        Console.WriteLine("Carro desligado");
    }
}