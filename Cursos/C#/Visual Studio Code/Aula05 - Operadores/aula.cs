using System;
class Aula{
    static void Main(string[] args){
        /* Variável bool recebe uma operação e retorna True ou False */

        bool res=10<5; //Verificará a operação e atribuirá se é True ou False (no caso, False)
        bool res2=10>5; //Esse já é True

        Console.WriteLine("res: "+res+", res2: "+res2);

        bool res3=(10<5)&(20<9); //Também funciona com múltiplos operadores, aí só retornará True se todas as operações forem True
        bool res4=(10>5)&(20>9); //Como os dois são True, o resultado será True
        Console.WriteLine("res3: "+res3+", res4: "+res4);

        /* Formas de incrementar uma variável */

        int num=1;
        Console.WriteLine("num=1: "+num);

        num=num+1;
        Console.WriteLine("num=num+1: "+num);

        num+=1; //Pode se usar com as 4 operações básicas (+ - * /)
        Console.WriteLine("num+=1: "+num);

        num++; //Só funciona pra incrementar +1
        Console.WriteLine("num++: "+num);


    }
}