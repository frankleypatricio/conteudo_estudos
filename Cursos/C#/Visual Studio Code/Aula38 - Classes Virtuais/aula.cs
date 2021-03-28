using System;
class Aula38{ //Classes Virtuais
    static void Main(){
        Derivada1 derivada1=new Derivada1();
        Derivada2 derivada2=new Derivada2();
        derivada2.info(); //Isso só pega o info() da Derivada2

        Base Ref; //Class Pai para referenciar suas classes filhas (precisa ser Ref com R maiúsculo)
        Ref=derivada1;
        Ref.info(); //Isso pegará a info() da Derivada1
        Ref=derivada2;
        Ref.info(); //Isso pegará a info() da Derivada2
     }
}
class Base{
    public Base(){
        Console.WriteLine("Classe Base construída");
    }
    virtual public void info(){ //Virtual diz que esse método pode ser sobreposto em classes filhas
        Console.WriteLine("class Base{} - Construtores: 1 / Métodos: 1");
    }
}
class Derivada1:Base{
    public Derivada1(){
        Console.WriteLine("Classe Derivada1 construída");
    }
    override public void info(){ //Override diz que esse método é uma sobreposição
        Console.WriteLine("class Derivada:Base{} - Construtores: 1 / Métodos: 1");
    }
}
class Derivada2:Derivada1{
    public Derivada2(){
        Console.WriteLine("Classe Derivada2 construída");
    }
    override public void info(){ //Override diz que esse método é uma sobreposição
        Console.WriteLine("class Derivada2:Derivada1{} - Construtores: 1 / Métodos: 1");
    }
}