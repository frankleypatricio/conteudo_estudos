using System;
using System.Collections.Generic; //Biblioteca do dictionary (ele é uma coleção genérica)
class Aula55{ //Dictionary
    static void Main(){
        Dictionary <int,string> pessoas=new Dictionary<int, string>(); //Declarando e construindo um novo dictionary (é tipo map de C++, a chave pode ser qualquer tipo de variável)
        pessoas.Add(0,"Lucas"); //Adicionando item
        Console.WriteLine("pessoas[0]: "+pessoas[0]); //Retornando valor de chave == 0
        pessoas.Clear(); //Limpando dictionary
        
        pessoas.Add(0,"Ana"); //Adicionando itens
        pessoas[1]="João"; //Também funciona
        pessoas.Add(2,"Julia");

        Console.WriteLine("Tamanho: "+pessoas.Count); //Retornando total de itens

        Console.Write("> ");
        int chave=int.Parse(Console.ReadLine());
        if(pessoas.ContainsKey(chave)) Console.WriteLine("Pessoa: "+pessoas[chave]); //Verifica se chave existe na coleção
        else Console.WriteLine("Essa chave não pertence a nenhum pessoa");

        Console.Write("> ");
        string valor=Console.ReadLine();
        if(pessoas.ContainsValue(valor)) Console.WriteLine("Essa pessoa contém uma chave"); //Verifica se valor existe na coleção
        else Console.WriteLine("Essa pessoa não contém nenhuma chave");

        foreach(KeyValuePair <int,string> v in pessoas){ //KeyValuePair é porque não tem como converter dictionary só para string porque a chave também é personalizada
            Console.WriteLine("Chave: {0} / Pessoa: {1}",v.Key,v.Value); //Tem que ser pair r o porque logo abaixo vvvvv
            //pessoas.Keys; - Retorna uma coleção de chaves (KeyCollection)
            //pessoas.Values; - Retorna uma coleção de valores (ValueCollection)
        }
        Console.WriteLine("---------------------------------------------------");
        //Outra forma de fazer a leitura de chaves e valores
        Dictionary <int,string>.KeyCollection chaves=pessoas.Keys; //Obetendo todas as keys
        Dictionary <int,string>.ValueCollection valores=pessoas.Values; //Obtendo todos os values
        foreach(int k in chaves){
            Console.WriteLine("Chave: {0}",k);
        }
        foreach(string v in valores){
            Console.WriteLine("Pessoa: {0}",v);
        }

        pessoas.Remove(0); //Removendo item de chave == 0
    }
}