using System;
class Aula26{ //Argumento out (métodos)
    static void Main(){
        //out
        int num=9, result, rest;
        result=dividir(num,2,out rest); //O out funciona como o ref, porém o ref requere que a variável seja iniciada, o out não, já que ele é feito para guardar um retorno extra
        Console.WriteLine("Resultado 1: "+result+"\nResto 1: "+rest);

        /*/in
        int num2=97, num3=3, result2;
        result2=somar(in num2, in num3); //O in é igual o out e ref, porém ele não pode ser alterado dentro do método
        Console.WriteLine("Resultado 2: "+result2);*/
    }

    static int dividir(int divisor, int dividendo, out int resto){ //O out deve vir aqui também para ter um segundo "retorno"
        int quociente=divisor/dividendo;
        resto=divisor%dividendo;
        return quociente;
    }
    /* <- Não tá funcionando o método Deus sabe lá por que
    static int somar(in int soma1, in int soma2){ //O in deve vir aqui também, assim como o ref e out
        int r=soma1+soma2;
        return r;
    }*/
}