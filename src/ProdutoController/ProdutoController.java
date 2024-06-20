package ProdutoController;

import ProdutoModel.Bebidas;
import ProdutoRepository.ProdutoRepository;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class ProdutoController implements ProdutoRepository {

    private int numero;
    private ArrayList<Bebidas> listaBebidas = new ArrayList<>();

    @Override
    public void cadastrar(Bebidas bebidas) {
        listaBebidas.add(bebidas);
        System.out.println("\nA Bebida com o ID: " + bebidas.getNumero() + " foi criada com sucesso!");
    }

    @Override
    public void listarTodas() {
        for (var Bebidas : listaBebidas){
            Bebidas.visualizar();
        }
    }

    @Override
    public void procurar(int numero) {
        var bebidas = buscarNaCollection(numero);
        if (bebidas != null) {
            bebidas.visualizar();
        }else
            System.out.println("\nA Bebida com o ID: " + numero + " não foi encontrada!");
    }

    @Override
    public void atualizar(Bebidas bebidas) {
        var buscarprod = buscarNaCollection(bebidas.getNumero());

        if (buscarprod != null){
           listaBebidas.set(listaBebidas.indexOf(buscarprod), bebidas);
            System.out.println("\nA Bebida com o ID: " + bebidas.getNumero() + " foi atualizada com sucesso!");
        }else
            System.out.println("\nA Bebida com o ID: " + bebidas.getNumero() + " não foi encontrada!");
    }

    @Override
    public void deletar(int numero) {
        var produto = buscarNaCollection(numero);

        if (produto != null){
            if (listaBebidas.remove(produto) == true) {
                System.out.println("\nA Bebida com o ID: " + numero + " foi deletada com sucesso!");
            }
        }else {
            System.out.println("\nA Bebida com o ID: " + numero + " não foi encontrada!");
        }
    }

    /*public int verificar(int numero){
        var buscarProduto = buscarNaCollection(listaBebidas.indexOf(numero));

        for (buscarProduto l : listaBebidas)
    }*/


    public Bebidas buscarNaCollection(int numero){
        for (var bebida : listaBebidas){
            if (bebida.getNumero() == numero){
                return bebida;
            }
        }
        return null;
    }
}
