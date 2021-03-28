using System;
class Aula31{ //Classes static
    static void Main(){
        //Entrega entrega=new Entrega(); <- Classes static não podem ser instanciadas
        Entrega.set(); //Apenas chamadas pela própria classe, onde seu valor é único na memória, tendo apenas 1
        Carrinho carrinho=new Carrinho("Memoria Ram Hyper X",279.90,1);
        Entrega.qtde++;
        carrinho.show();
        Entrega.show();
        Carrinho.emitido=true; //Alterando o static da classe Carrinho
        Entrega.entrega=true;
        carrinho.show();
        Entrega.show();
    }
}
public class Carrinho{
    public string produto;
    public double valor;
    public int qtde;
    static public bool emitido; //Um membro static só pode ser alterado chamando a classe em si, nunca em um objeto instanciado
    public Carrinho(string produto, double valor, int qtde){
        this.produto=produto;
        this.valor=valor;
        this.qtde=qtde;
        emitido=false;
    }
    public void show(){
        Console.WriteLine("< Produtos >");
        Console.WriteLine("Produto: "+produto);
        Console.WriteLine("Valor: "+valor);
        Console.WriteLine("Quantidade: "+qtde);
        Console.WriteLine("Emitido?: "+emitido);
    }
}
static public class Entrega{ //É necessário colocar public depois de static, se não fica protegido o acesso em outras classes...
    static public int qtde;
    static public bool entrega;
    static public void set(){
        qtde=0;
        entrega=false;
    }
    static public void show(){
        Console.WriteLine("< Entregas >");
        Console.WriteLine("Quantidade: "+qtde);
        Console.WriteLine("Saiu para entrega?: "+entrega);
    }
}