using System;

namespace Aula04
{
    class Program
    {
        static int global=90; //Variável global estática
        static void Main(string[] args)
        {
            int local=9; //Variável local do método (função)
            Console.WriteLine(global+", "+local);
        }
    }
}
