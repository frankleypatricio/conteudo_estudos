using System;
class Aula43e44{ //Exceções - Try Catch Finally
    static void Main(){
        int n1,n2,result;
        result=n1=n2=0;

        try{
            Console.Write("N1: ");
            n1=int.Parse(Console.ReadLine());
            Console.Write("Dividido para N2: ");
            n2=int.Parse(Console.ReadLine());

            if(n1<n2)throw new Exception("N1 deve ser maior que N2"); //Criando uma nova excessão caso n1 < n2

            result=n1/n2;
            Console.WriteLine("{0}/{1}={2}",n1,n2,result);
        }catch(Exception ex){ //Funciona só com " }catch{ " também, só não captura o erro
            Console.WriteLine("Erro: {0}",ex.Message);
        }finally{
            Console.WriteLine("< Fim do tratamento de erros >");
        }
    }
}