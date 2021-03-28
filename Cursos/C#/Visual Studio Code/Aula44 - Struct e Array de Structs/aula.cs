using System;
class Aula44{ //Struct e Array de Structs
    static void Main(){
        //Estrutura
        Game dmc5=new Game("Devil May Cry 5",2019,89.99);
        Console.WriteLine("Nome: "+dmc5.nome);
        Console.WriteLine("Ano: "+dmc5.ano);
        Console.WriteLine("Valor: "+dmc5.valor);
        dmc5.desconto(10.99);
        Console.WriteLine("Valor Pós Desconto: "+dmc5.valor);
        Console.WriteLine("----------------------------------------------");

        //Array de estruturas
        Game[] dmc= new Game[5]; //Mesma coisa das variiáveis primitivas
        dmc[0]=new Game("Devil May Cry",2001,9.99);
        Console.WriteLine("Nome: "+dmc[0].nome);
        Console.WriteLine("Ano: "+dmc[0].ano);
        Console.WriteLine("Valor: "+dmc[0].valor);
    }
}
struct Game{ //Struct é tipo uma classe, porém mais básica (tipo, não suporta herança). Bom pra criar um tipo variável nova
    public string nome;
    public int ano;
    public double valor;

    public Game(string nome, int ano, double valor){
        this.nome=nome;
        this.ano=ano;
        this.valor=valor;
    }
    public void desconto(double desc){
        valor-=desc;
    }
}