using System;
using System.Collections.Generic; //Biblioteca de coleções genéricas (pra queue)
class Aula59{ //Coleção Queue (fila)
    static void Main(){
        string[] proto={"Fogo","Água","Terra","Ar"}; //Queue pode receber um array no construtor
        Queue <string> elementos=new Queue<string>(proto); //Declarando e instanciando uma fila

        elementos.Enqueue("Luz"); //Adiciona um elemento na fila (em c++ é push)
        elementos.Enqueue("Raio");

        Console.WriteLine("Tamanho da fila:"+elementos.Count); //Retorna tamanho da fila

        if(elementos.Contains("Gelo")) Console.WriteLine("Fila contém esse elemento");
        else Console.WriteLine("Fila Não contém esse elemento");

        Console.WriteLine("Elemento "+elementos.Dequeue()+" removido da fila"); //Retorna e romove o 1° elemento da fila
        Console.WriteLine("1° Elemento da fila: "+elementos.Peek()); //Retorna o 1° elemento da fila

        foreach(string v in elementos){ //Lê todos os elementos da fila por meio do foreach
            Console.WriteLine("Elemento "+v);
        }



        elementos.Clear(); //Limpa fila
    }
}