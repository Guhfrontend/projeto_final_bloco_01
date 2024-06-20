import ProdutoController.ProdutoController;
import ProdutoModel.Alcolicas;
import ProdutoModel.Bebidas;
import ProdutoModel.NaoAlcolicas;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        Integer opcao, tipo, numero;
        String nome;
        float quant, preco, porcAlc;

        ProdutoController bebida = new ProdutoController();

        while (true) {
            System.out.println("""
                    *****************************************************

                                Adega do Gustavin
                                
                    *****************************************************

                                1 - Cadastrar Produto
                                2 - Listar Produtos da loja
                                3 - Buscar Produto por ID
                                4 - Atualizar Produto
                                5 - Apagar Produto
                                6 - Sair da adega do Gustavin
                                 """);
            System.out.println("Digite uma ação: ");

            try {
                opcao = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                scan.nextLine();
                opcao = 0;
            }
            if (opcao == 6) {
                System.out.println("\nAdega do Gustavin é boa dimai");
                System.exit(0);
            }
            switch (opcao) {
                case 1:
                    System.out.println("Criando produto");
                    System.out.print("Digite o nome da bebida: ");
                    scan.skip("\\R?");
                    nome = scan.next();

                        System.out.print("Digite o ID do produto: ");
                        numero = scan.nextInt();
                    

                    System.out.print("Quantidade(ml): ");
                    quant = scan.nextFloat();

                    System.out.print("Preço para venda: ");
                    preco = scan.nextFloat();

                    do {
                        System.out.println("1- Bebida alcolica ou 2- não alcolica: ");
                        tipo = scan.nextInt();
                    } while (tipo < 1 || tipo > 2);

                    if (tipo == 1){
                        System.out.println("Qual a porcentagem do alcool: ");
                        porcAlc = scan.nextFloat();
                        bebida.cadastrar(new Alcolicas(nome,numero,quant,preco,porcAlc) {
                        });
                    }if (tipo == 2){
                        bebida.cadastrar(new NaoAlcolicas(nome,numero,quant,preco));
                    }
                    break;

                case 2 :
                    System.out.println("Todos os itens cadastrados: ");
                    bebida.listarTodas();
                    break;

                case 3 :
                    System.out.println("Qual id do produto: ");
                    numero = scan.nextInt();
                    bebida.procurar(numero);
                    break;

                case 4 :
                    System.out.println("Digite o id do produto: ");
                    numero = scan.nextInt();
                    var buscarProd = bebida.buscarNaCollection(numero);

                    if (buscarProd != null){
                        numero = buscarProd.getNumero();
                        System.out.println("Digite o nome: ");
                        nome = scan.nextLine();
                        System.out.println("Quantidade: ");
                        quant = scan.nextFloat();
                        System.out.println("Preço: ");
                        preco = scan.nextFloat();


                        if (numero == 1){
                            System.out.println("Qual a nova porcentagem de alcool: ");
                            porcAlc = scan.nextFloat();
                            bebida.atualizar(new Alcolicas(nome,numero,quant,preco,porcAlc));
                            System.out.println("Atualizado");

                        }if (numero == 2){
                            bebida.atualizar(new NaoAlcolicas(nome,numero,quant,preco));
                            System.out.println("Atualizado");
                        }

                    }else {
                        System.out.println("A conta não foi encontrada!");
                    }



                case 5:
                    System.out.println("Qual o id do produto: ");



            }
        }
    }

}
