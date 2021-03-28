using System;
class Aula25{ //Passagem por valor e por referência em métodos
    static void Main(){
        int num=10;
        Console.WriteLine("Valor de num antes: "+num);
        //dobrar(num); //Passagem por valor: ao executar a função, o valor de num vai para um endereço novo de memória
        dobrar(ref num); //Passagem por referência: usando o ref, ele fica referênte à posição na memoria do num (tipo ponteiros em c++) necessita que a var seja iniciada
        Console.WriteLine("Valor de num depois: "+num);
    }

    static void dobrar(ref int valor){ //Deve se usar o ref aqui também
        valor*=2;
    }
}

//Aparentemente não dá para criar método fora da classe