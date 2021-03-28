using System;
namespace Galaxia1{ //Criando um namespace para deixar o código mais organizado
    class Aula54{ //Namespaces
        static void Main(){
            Planeta planeta1=new Planeta(); //Por estar neste namespace, não precisa especificá-lo
            Galaxia2.Planeta planeta2=new Galaxia2.Planeta(); //É preciso especificar o namespace da classe
            
            Sol.tamanho(); //Por estar neste namespace, não precisa especificá-lo
            Galaxia2.Sol.tamanho(); //É preciso especificar o namespace da classe
        }
    }

    static class Sol{ //Pode se criar classes de mesmo nome desde que estejam em namespaces diferentes
        static public void tamanho(){
            Console.WriteLine("Tamanho do Sol da Galáxia 1: Grande pra caramba");
        }
    }
    class Planeta{ //Pode se criar classes de mesmo nome desde que estejam em namespaces diferentes
        public Planeta(){
            Console.WriteLine("Planeta criado na Galáxia 1");
        }
    }
}

namespace Galaxia2{ //Criando um namespace para deixar o código mais organizado
    static public class Sol{ //Pode se criar classes de mesmo nome desde que estejam em namespaces diferentes
        static public void tamanho(){
            Console.WriteLine("Tamanho do Sol da Galáxia 2: Grande pra cacete");
        }
    }
    class Planeta{ //Pode se criar classes de mesmo nome desde que estejam em namespaces diferentes
        public Planeta(){
            Console.WriteLine("Planeta criado na Galáxia 2");
        }
    }
}