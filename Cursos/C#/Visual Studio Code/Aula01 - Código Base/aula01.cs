using System; //inclue a biblioteca System que contem os comandos básicos de entrada e saída

/* Como compilar:
    > csc arquivo.cs
*/
class Principal{
    static void Main(){
        Console.WriteLine("Olá Mundo...");
        float wifht=1280, height=720;
        float x=wifht/height;
        float y=0;
        do{
            y+=x;
            Console.WriteLine("Valor: {0} / Resto: {1}", y, y%1);
            if(y >= 16) break;
        }while(y%1!=0);
    }
}