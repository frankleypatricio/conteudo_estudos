using System;
class Aula34{ //Herança & Construtor da classe base
    static void Main(){
        Pessoa pessoa=new Pessoa("Joãoquim",22,"Parajú","Floresta",15);
        pessoa.showPessoa();
        pessoa.showEndereco();
    }
}
//Obs: As classes herdadas são construidas sempre da base pras derivadas (no caso, com os construtores básicos padrões ao construir a classe principal)
class Endereco{ //Classe base
    protected string rua, bairro; //Membros protegidos só podem ser acessado pela classe e seus filhos
    protected int num;
    public Endereco(string rua, string bairro, int num){ //Construtor da classe base
        this.rua=rua;
        this.bairro=bairro;
        this.num=num;
    }
    public void showEndereco(){
        Console.WriteLine("Rua: "+rua);
        Console.WriteLine("Bairro: "+bairro);
        Console.WriteLine("Número: "+num);
    }
}
class Pessoa:Endereco{ //Class Pessoa herdando Class Endereco (Classe derivada)
    private string nome;
    private int idade;
    public Pessoa(string nome, int idade, string rua, string bairro, int num):base(rua, bairro, num){ //base() -> Referente ao construtor da classe Endereco
        this.nome=nome;
        this.idade=idade;
        this.num=num;
    }
    public void showPessoa(){
        Console.WriteLine("Nome: "+nome);
        Console.WriteLine("Idade: "+idade);
    }
}