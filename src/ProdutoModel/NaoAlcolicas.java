package ProdutoModel;

public class NaoAlcolicas extends Bebidas {

    public NaoAlcolicas(){

    }
    public NaoAlcolicas(String nome, int numero, float quant, float preco) {
        super(nome, numero, quant, preco);
    }


    public void visualizar() {
        super.visualizar();
        System.out.print("Sem alcool");
    }
}
