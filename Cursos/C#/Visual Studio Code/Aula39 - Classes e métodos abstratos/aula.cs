using System;
class Aula39{ //Classes e métodos abstratos
    static void Main(){
        Celta celtinha=new Celta();
        celtinha.ligar();
        celtinha.acelerar(int.Parse(Console.ReadLine()));
        celtinha.acelerar(int.Parse(Console.ReadLine()));
        celtinha.desligar();
    }
}
abstract class Veiculo{ //Abstract não pode ser instanciado, serve como base/referência para classes filhas
    protected int vel_max;
    protected int velocidade;
    protected bool ligado;
    public Veiculo(){
        velocidade=30;
        ligado=false;
    }
    public void ligar(){ //Só vai funcionar quando implementar a classe filha que estará herdando essa
        ligado=true;
        Console.WriteLine("Ligado");
    }
    public void desligar(){ //Só vai funcionar quando implementar a classe filha que estará herdando essa
        ligado=false;
        Console.WriteLine("Desligado");
    }
    abstract public void acelerar(int velocidade); //Tipo um protótipo em C++
}
class Celta:Veiculo{
    public Celta(){
        vel_max=320;
    }
    override public void acelerar(int velocidade){ //Precisa do override, porque está sobrescrevendo o método
        if(velocidade<=vel_max && velocidade>=0) this.velocidade=velocidade;
        else Console.WriteLine("Velocidade não permitida");
        Console.WriteLine("Velocidade atual: "+this.velocidade);
    }
}