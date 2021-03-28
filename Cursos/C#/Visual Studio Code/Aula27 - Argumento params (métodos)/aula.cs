using System;
class Aula27{ //Argumento params (métodos)
    static void Main(){
        soma();
        soma(10);
        soma(10,20);
        soma(1,12,7,9);
    }
    static void soma(params int[]n){ //Params faz com que seja possível passar 0 ou mais parâmetros salvos num array
        int result=0; //É bom iniciarlizar as variáveis, todo programador bom deveria fazer isso pra evitar erros... By Fessô Bruno
        if(n.Length<1){
            Console.WriteLine("Nenhum valor foi passado.");
        }else if(n.Length<2){
            Console.WriteLine("Valores insuficientes para realizar a soma.");
        }else{
            for(int i=0;i<n.Length;i++){
                result+=n[i];
            }
            Console.WriteLine("Resultado: "+result);
        }
    }
}