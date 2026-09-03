public import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Tarefa 3: Método main() enxuto focado na navegação do menu
    public static void main(String[] args) {
        int opcao = -1;

        do {
            System.out.println("\n=== SISTEMA DE GERENCIAMENTO DE PRODUTOS ===");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Alterar Preço");
            System.out.println("4 - Remover Produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpeza de buffer
            } else {
                System.out.println("Opção inválida! Digite um número.");
                scanner.nextLine(); // Limpeza de buffer
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    alterarPreco();
                    break;
                case 4:
                    remover();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    // Tarefa 3 e 6: Cadastro de produto com validação de código duplicado
    static void cadastrar() {
        System.out.println("\n--- Cadastrar Produto ---");
        System.out.print("Digite o código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        // Tarefa 6: Impede produtos com mesmo código
        if (buscarPorCodigo(codigo) != null) {
            System.out.println("Erro: Já existe um produto cadastrado com o código " + codigo + "!");
            return;
        }

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        Produto novoProduto = new Produto(codigo, nome, preco);
        produtos.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    // Tarefa 3 e 4: Listagem utilizando System.out.println(p) via toString()
    static void listar() {
        System.out.println("\n--- Lista de Produtos ---");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p); // Executa o toString() sobrescrito
        }
    }

    // Tarefa 2: Método único de busca centralizado
    static Produto buscarPorCodigo(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    // Tarefa 3 e 5: Alteração de preço com uso da busca e sobrecarga
    static void alterarPreco() {
        System.out.println("\n--- Alterar Preço ---");
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Produto p = buscarPorCodigo(codigo);

        // Tarefa 6: Validação de produto não encontrado
        if (p == null) {
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.println("Produto encontrado: " + p.getNome());
        System.out.print("Digite o novo preço base: ");
        double novoPreco = scanner.nextDouble();

        System.out.print("Deseja aplicar um desconto percentual? (1-Sim / 2-Não): ");
        int aplicarDesconto = scanner.nextInt();
        scanner.nextLine();

        if (aplicarDesconto == 1) {
            System.out.print("Digite a porcentagem de desconto (ex: 10 para 10%): ");
            double desconto = scanner.nextDouble();
            scanner.nextLine();
            
            p.alterarPreco(novoPreco, desconto); // Usa a versão com sobrecarga
        } else {
            p.alterarPreco(novoPreco); // Usa a versão simples
        }

        System.out.println("Preço atualizado com sucesso!");
    }

    // Tarefa 3 e 6: Remoção segura sem erros de execução
    static void remover() {
        System.out.println("\n--- Remover Produto ---");
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Produto p = buscarPorCodigo(codigo);

        // Tarefa 6: Não apresenta erro ao tentar remover inexistente
        if (p == null) {
            System.out.println("Produto não encontrado! Nenhuma alteração foi feita.");
            return;
        }

        produtos.remove(p);
        System.out.println("Produto " + p.getNome() + " removido com sucesso!");
    }
} {
    
}
