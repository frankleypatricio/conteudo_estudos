using System;
delegate int Op(params int[]n); //Criando um delegate para apontar e encapsular um método (é tipo um ponteiro de C). Deve conter os mesmos parâmetros dos métodos a serem encapsulados
class Aula50{ //Delegates
    static void Main(){
        Op op=new Op(Matt.somar); //Instanciando um delegate encapsulando o método somar da class static Matt
        int result=op(2,68,4); //Chamando o delegate como se fosse a própria função (meio que anônimamente)
        Console.WriteLine("Soma: "+result);

        op=new Op(Matt.subtrair);
        result=op(200,8,12);
        Console.WriteLine("Subtração: "+result);
    }
}
static class Matt{
    public static int somar(params int[]n){
        int result=0;
        if(n.Length > 1){
            for(int i=0;i<n.Length;i++){
                result+=n[i];
            }
        }
        return result;
    }
    public static int subtrair(params int[]n){
        int result=0;
        if(n.Length > 1){
            result=n[0];
            for(int i=1;i<n.Length;i++){
                result-=n[i];
            }
        }
        return result;
    }
}