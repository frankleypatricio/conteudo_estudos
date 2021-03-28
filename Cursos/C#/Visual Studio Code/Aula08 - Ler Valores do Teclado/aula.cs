using System;
class Aula08{
    static void Main(string[] args){
        int n1,n2;
        string nome;

        Console.Write("Digite um nome: ");
        nome=Console.ReadLine(); //Lê valores digitados no teclado e salva na variável
        Console.WriteLine("Nome digitado: "+nome);

        Console.Write("Digite um número: ");
        n1=int.Parse(Console.ReadLine()); //Converte o texto pra int antes de salvar na variável
        Console.Write("Digite outro número: ");
        n2=Convert.ToInt32(Console.ReadLine()); //Outra maneira de converter
        Console.WriteLine("Números digitados: {0}, {1}",n1,n2);
    }
}