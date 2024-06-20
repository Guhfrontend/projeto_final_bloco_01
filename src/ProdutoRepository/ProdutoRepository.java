package ProdutoRepository;

import ProdutoModel.Bebidas;

public interface ProdutoRepository {

    public void cadastrar(Bebidas bebidas);
    public void listarTodas();
    public void procurar(int numero);
    public void atualizar(Bebidas bebidas);
    public void deletar(int numero);

}
