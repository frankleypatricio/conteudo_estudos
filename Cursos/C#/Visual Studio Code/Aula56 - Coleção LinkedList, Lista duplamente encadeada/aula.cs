using System;
using System.Collections.Generic; //Biblioteca de coleções genéricas (pra list)

class Aula56{ //Coleção LinkedList / Lista duplamente encadeada
    static void Main(){
        LinkedList <string> cores=new LinkedList<string>(); //Declara e instancia a lista

        cores.AddFirst("Azul"); //Adiciona no início da lista
        cores.AddLast("Vermelho"); //Adiciona no fim da lista
        
        LinkedListNode <string> no;//=new LinkedListNode<string>("value"); //Não funciona pro Add porque esse nó criado não pertence à lista
        no=cores.Find("Azul"); //Encontra o 1° elemento com o valor passado
        cores.AddAfter(no,"Verde"); //Adiciona após o elemento determinado no LinkedListNode

        no=cores.FindLast("Vermelho"); //Encontra o último elemento com o valor passado
        cores.AddBefore(no,"Amarelo"); //Adiciona antes do elemento determinado no LinkedListNode



        foreach(string v in cores){
            Console.WriteLine(v);
        }
        cores.Remove("Amarelo"); //Remove o elemento passado
        cores.RemoveFirst(); //Remove o primeiro elemento
        cores.RemoveLast(); //Remove o último elemento

        if(cores.Find("Amarelo")==null) Console.WriteLine("Esta cor não está na lista");
        else Console.WriteLine("Esta cor está na lista");

        no=cores.FindLast("Verde").Next; //Next: Aponta para o próximo elemento do passado
        no=cores.FindLast("Verde").Previous; //Previous: Aponta para o elemento anterior do passado
        string manga=cores.FindLast("Verde").Value; //Value: Retorna o valor do elemento passado

        cores.Clear(); //Limpa lista
    }
}