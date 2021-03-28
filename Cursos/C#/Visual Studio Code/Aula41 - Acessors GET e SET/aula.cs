using System;
class Aula41{ //Acessors GET e SET
    static void Main(){
        Livro livro=new Livro("Passaro Contra a Vidraça","Drama",21.90,2012);
        Console.WriteLine("Gênero: "+livro.Genero);
        Console.Write("Novo gênero: ");
        manga.Genero=Console.ReadLine();
        Console.WriteLine("Nome: "+livro.Nome);
        Console.WriteLine("Gênero: "+livro.Genero);
        Console.WriteLine("Valor: "+livro.Valor);
        Console.WriteLine("Ano: "+livro.Ano);
    }
}
class Livro{
    string nome;
    string genero;
    double valor;
    int ano;

    public Manga(string nome,string genero,double valor,int ano){
        this.nome=nome;
        this.genero=genero;
        this.valor=valor;
        this.ano=ano;
    }
    //GETTERS E SETTERS
    public string Nome{ //Isso é uma propriedade, não tem parâmetros
        get{
            return nome;
        }
        set{ //na propriedade tem uma variável padrão chamada "value" que recebe dados pelo "="
            nome=value;
        }
    }
    public string Genero{ //Isso é uma propriedade, não tem parâmetros
        get{
            return genero;
        }
        set{ //na propriedade tem uma variável padrão chamada "value" que recebe dados pelo "="
            genero=value;
        }
    }
    public double Valor{ //Isso é uma propriedade, não tem parâmetros
        get{
            return valor;
        }
        set{ //na propriedade tem uma variável padrão chamada "value" que recebe dados pelo "="
            valor=value;
        }
    }
    public int Ano{ //Isso é uma propriedade, não tem parâmetros
        get{
            return ano;
        }
        set{ //na propriedade tem uma variável padrão chamada "value" que recebe dados pelo "="
            ano=value;
        }
    }
}