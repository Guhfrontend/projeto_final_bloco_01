package ProdutoModel;

public class Alcolicas extends Bebidas {

    private float porcAlc;

    public Alcolicas(){

    }

    public Alcolicas(String nome, int numero, float quant, float preco, float porcAlc) {
        super(nome, numero, quant, preco);
        this.porcAlc = porcAlc;
    }

    public float getPorcAlc() {
        return porcAlc;
    }

    public void setPorcAlc(float porcAlc) {
        this.porcAlc = porcAlc;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.print("porcentagem de Álcool: " + this.porcAlc + "%\n");
    }
}
