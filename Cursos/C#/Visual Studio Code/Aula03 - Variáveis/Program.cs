using System;

namespace Aula03
{
    class Program
    {
        static void Main(string[] args)
        {
            byte num_byte=3; //Recebe entre 0 e 200
            int num=-5;
            char letra='k';
            float flutuante_4bytes=9.6f; //Tem que ter esse sufixo "f" no final. Apenas double não usa letra no final
            double flutuante_8bytes=6.9; //Não precisa de letra no final
            string cadeia_chars="cadeia";
            var auxiliar=letra; //Variável com tipo não especificado(definido na compilação dependendo do valor recebido)


            //Ler variáveis
            Console.Write("Variável: "+letra+".");

        }
    }
}
