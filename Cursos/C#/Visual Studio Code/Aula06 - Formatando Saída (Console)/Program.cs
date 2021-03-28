using System;

namespace Aula06
{
    class Program
    {
        static void Main(string[] args)
        {
            /* Índices no Write */
            int n1=10,n2=20,n3=30;

            Console.WriteLine("n1={0}\nn2={1}\nn3={2}\n",n1,n2,n3); //Criar uma string "{}" e acessa as variáveis informadas no final por meio de índices, iniciando do 0

            /* Outros Atributos que pode se usar no índice */
            double compra=5.50;
            double venda;
            double lucro=0.1;
            string produto="Pastel de Frango";

            venda=compra+(compra*lucro);


            Console.WriteLine("teste={0,5}\n"+"teste2={1,15:c}", compra,venda);
            Console.WriteLine("teste3={0,5:c}\n", venda); //Aqui o espaçamento funciona, diferente do de baixo vvvv

            Console.WriteLine(
                "Produto.......:{0,5}\n"+ //O "0" é o índice e o "5" é o valor do espaçamento entre o texto e o índice (ou pelo menos deveria...)
                "Val.Compra....:{1,5:c}\n"+ //":c" declara que é uma moeda, assim colocando o "R$" no valor
                "Lucro.........:{2,5:p}\n"+ //":p" declara que é porcentagem, convertendo o 0.1 para 10.00
                "Val.Venda.....:{3,5:c}",
                produto,compra,lucro,venda
            );
        }
    }
}
