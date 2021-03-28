using System;
using System.Collections.Generic; //Biblioteca de coleções genéricas (pra list)
class Aula57{ //Coleção List
    //Substituta pro array comum, mais dinâmina com métodos
    static void Main(){
        Console.WriteLine("-------------------- Parte 1 da Aula --------------------");

        List <string> notas1= new List<string>();
        List <string> notas2= new List<string>();
        notas1.Add("DÓ"); //Adiciona um item na lista
        notas1.Add("RÉ");
        notas1.Add("MI");
        notas1.Add("FÁ");
        notas1.Add("SOL");
        notas1.Add("LÁ");
        notas1.Add("SI");
        foreach(string v in notas1){
            Console.WriteLine("Notas1: "+v);
        }
        Console.WriteLine("----------------------------------------------");

        notas2.AddRange(notas1); //Adiciona os itens de uma lista pra outra
        foreach(string v in notas2){
            Console.WriteLine("Notas2: "+v);
        }
        notas2.Clear(); //Limpa a lista
        Console.WriteLine("----------------------------------------------");

        if(notas1.Contains("DÓ")) Console.WriteLine("DÓ está na lista");
        else Console.WriteLine("DÓ não está na lista");
        Console.WriteLine("----------------------------------------------");

        string[] notas3=new string[10];
        notas1.CopyTo(notas3); //Copia notas1 pra notas3
        foreach(string v in notas3){
            Console.WriteLine("Notas3(1): "+v);
        }
        notas3=new string[10];
        Console.WriteLine("----------------------------------------------");

        notas1.CopyTo(notas3,2); //Copia notas1 pra notas3 a partir da posição 2
        foreach(string v in notas3){
            Console.WriteLine("Notas3(2): "+v);
        }
        Console.WriteLine("----------------------------------------------");
        
        Console.WriteLine("Posição de SOL: "+notas1.IndexOf("SOL")); //Retorna posição do elemento passado
        Console.WriteLine("----------------------------------------------");

        Console.WriteLine("-------------------- Parte 2 da Aula --------------------");
        Console.ReadKey(); //Tipo o system("pause");
        Console.Clear(); // Limpando console
        notas1= new List<string>();
        notas2= new List<string>();
        
        notas1.Insert(0,"DÓ"); //Insere um valor na posição passada
        notas1.Insert(1,"DÓ");
        notas1.Add("SOL");
        notas1.Add("RÉ");

        Console.WriteLine("1° ocorrência de DÓ: "+notas1.IndexOf("DÓ")); //Retorna a 1° posição do elemento passado
        Console.WriteLine("Última ocorrência de DÓ: "+notas1.LastIndexOf("DÓ")); //Retorna a última posição do elemento passado
        foreach(string v in notas1){
            Console.WriteLine(v);
        }

        notas1.Remove("DÓ"); //Remove o primeiro valor passado
        notas1.RemoveAt(1); //Remove o valor da index passada
        foreach(string v in notas1){
            Console.WriteLine(v);
        }

        notas1.Reverse(); //Inverte a lista
        foreach(string v in notas1){
            Console.WriteLine(v);
        }

        notas1.Sort(); //Ordena a lista
        foreach(string v in notas1){
            Console.WriteLine(v);
        }

        Console.WriteLine("Tamanho da lista: "+notas1.Count); //Retorna o tamanho da lista
        notas1.Capacity=20; //Determinando a capacidade da lista
        Console.WriteLine("Capacidade da lista: "+notas1.Capacity); //Retorna a capacidade da lista
    }
}