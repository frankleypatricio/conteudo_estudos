package Hierarquia_de_exceções;

//Criando uma classe de exceção personalizada por meio da herança
public class MyException extends RuntimeException{
    public MyException(String msg){
        super(msg);
    }
}
