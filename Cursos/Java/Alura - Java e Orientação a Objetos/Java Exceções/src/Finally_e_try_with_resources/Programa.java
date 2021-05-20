package Finally_e_try_with_resources;

public class Programa {
    public static void main(String[] args) throws Exception {
        /*Conexao conn = null;
        try{
            conn = new Conexao();
            conn.leDados();
        }catch (IllegalStateException ex){
            System.err.println("Exceção gerada");
            System.err.println(ex.getMessage());
        }finally {
            conn.fecha();
        }*/

        //Abre e fecha a conexão, como se fosse o using de C# (precisou da assinatura no main)
        try (Conexao conexao = new Conexao()){
            conexao.leDados();
        }catch (IllegalStateException ex){
            System.err.println("Exceção gerada");
        }
    }
}
