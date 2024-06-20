package ProdutoModel;

public abstract class Bebidas {

    private String nome;
    private int numero;
    private float quant, preco;

    public Bebidas(){
    }

    public Bebidas(String nome, int numero, float quant, float preco) {
        this.nome = nome;
        this.numero = numero;
        this.quant = quant;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getQuant() {
        return quant;
    }

    public void setQuant(float quant) {
        this.quant = quant;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void visualizar() {
        System.out.println("Informações da bebida: \n" + "nome: " + this.nome + "\nID: " + this.numero + "\nquantidade(ml): " + this.quant + "\npreço: " + this.preco);
    }
}

