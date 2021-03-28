using System;
/* Modelo: 
[Modificador] class [nome]{
    //Variáveis, chamada de propriedades em poo (chamados as variáveis de uma class de membros)
    [Especificador de acesso] [tipo] [nome];

    //Métodos
    [Especificador de acesso] [retorno] [nome]([argumentos]){ };
}
< Modificadores de classes >
- public: sem restrição de visualização (se não usar nenhum modificador fica como public)
- abstract: usada como base para outras classes. Não é possível instanciá-la
- sealed: não pode ser herdada
- static: não permite instanciar objetos e seus membros devem ser static (instanciar == new)

< Especificadores de acesso >
- public: sem restrições de acesso
- private: só pode ser acessado pela classe
- protected: só pode ser acessado pela classe e filhos
- abstract: métodos não tem implementação, só os cabeçalhos (sem o código executado pelo método, esses ficarão nas classes herdadas)
- sealed: o método não pode ser redefinido
- virtual: o método pode ser redefinido em uma classe filha
- static: o método pode ser chamado mesmo sem a instanciação de um objeto (instanciar == new)
*/
class Aulas28e29{ //28- Classes e Objetos / 29- Contrutores e Destrutores
    static void Main(){
        Mercadoria tenis=new Mercadoria(); //New reserva espaço na memória para esse novo objeto e retorna seu endereço
        tenis.marca="Adidas";
        tenis.modelo="Urban 5";
        tenis.cor="Preto/Vermelho";
        tenis.numeracao=41;
        tenis.codigo=15678;
        Console.WriteLine("Marca: {0} / Modelo: {1} / Cor: {2}\nNumeração: {3} / Código: {4}\n",
                            tenis.marca,tenis.modelo,tenis.cor,tenis.numeracao,tenis.codigo);

        Mercadoria sapato=new Mercadoria("Ferracini","Forland","Preto",43,15306);
        Console.WriteLine("Marca: {0} / Modelo: {1} / Cor: {2}\nNumeração: {3} / Código: {4}",
                            sapato.marca,sapato.modelo,tenis.cor,sapato.numeracao,sapato.codigo);
                            
        //No final do programa, as classes com destrutores definidos são destruidas (não dá pra chamar destrutor com delete ;-;)
    }
}
class Mercadoria{ //O mesmo que usar "public class"
    //Membros
    public string marca, modelo, cor; //Precisa do public para acessar fora da class
    public int numeracao, codigo;

    //Construtores e Destrutor
    //(C# cria um construtor básico automaticamente, não precisa criar)
    public Mercadoria(){} //Precisa do public para acessar
    public Mercadoria(string marca, string modelo, string cor, int numeracao, int codigo){
        this.marca=marca;
        this.modelo=modelo;
        this.cor=cor;
        this.numeracao=numeracao;
        this.codigo=codigo;
    }
    ~Mercadoria(){ //Destrutor
        Console.WriteLine("Mercadoria '"+this.marca+"' eliminada com sucesso!");
    }
    
    //Métodos

}