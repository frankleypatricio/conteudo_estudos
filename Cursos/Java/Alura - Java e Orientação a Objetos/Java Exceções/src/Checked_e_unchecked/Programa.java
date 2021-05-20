package Checked_e_unchecked;

class Programa {
    //Caso achame a exceção de um método, também deve-se assiná-la da declaração do método
    public static void main(String[] args) throws MyException{
        bar();
    }

    /* Deve se assinar a exceção na declaração do método (chama-se checked, unchecked se não tiver a assinatura), caso essa
       exceção esteja herdando diretamente a classe Exception

       Esse checked meio que obriga a tratar a exceção, já avisando que pode ter uma exceção no método
    */
    private static void bar() throws MyException{
        throw new MyException("Erro");
    }

    private static void fool(){
        //Não é preciso assinar caso a exceção esteja sendo tratada
        try {
            bar();
        }catch (MyException ex){
            System.out.println(ex.getMessage());
        }
    }
}
