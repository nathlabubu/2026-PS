/*
* Disciplina: 2026-PS
* Esdudante : Nathaly Vitória de Ananias Fernandes 
* Data      : 2026.09.03
* Projeto   : aula35-clinica
* Arquivo   : Aluno.java
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Produto> listaProdutos = new ArrayList<>();
    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int opcaoSelecionada;

        do {
            exibirMenu();
            opcaoSelecionada = lerInteiro("Digite a opção desejada: ");

            switch (opcaoSelecionada) {
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
                case 5:
                    System.out.println("Finalizando aplicação...");
                    break;
                default:
                    System.out.println("Aviso: Opção inválida. Tente novamente.");
            }
        } while (opcaoSelecionada != 5);
    }

    private static void exibirMenu() {
        System.out.println("\n---------------------------------");
        System.out.println("   PAINEL DE CONTROLE - PRODUTOS");
        System.out.println("---------------------------------");
        System.out.println("1) Novo Cadastro");
        System.out.println("2) Exibir Registros");
        System.out.println("3) Atualizar Preço");
        System.out.println("4) Excluir Registro");
        System.out.println("5) Encerrar");
    }

    // Tarefa 2: Método de busca obrigatório
    static Produto buscarPorCodigo(int codigo) {
        for (Produto item : listaProdutos) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    // Tarefa 3 e 6: Cadastro com checagem de duplicidade
    static void cadastrar() {
        System.out.println("\n>>> CADASTRO DE NOVO PRODUTO <<<");
        int cod = lerInteiro("Informe o código identificador: ");

        if (buscarPorCodigo(cod) != null) {
            System.out.println("Falha: O código [" + cod + "] já pertence a um produto cadastrado!");
            return;
        }

        System.out.print("Informe o nome do produto: ");
        String nome = entrada.nextLine().trim();

        double precoInicial = lerDecimal("Informe o preço base (R$): ");

        Produto novoItem = new Produto(cod, nome, precoInicial);
        listaProdutos.add(novoItem);
        System.out.println("Sucesso: Produto cadastrado com sucesso!");
    }

    // Tarefa 3 e 4: Listagem usando System.out.println(p)
    static void listar() {
        System.out.println("\n>>> RELAÇÃO DE PRODUTOS <<<");
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum item cadastrado até o momento.");
            return;
        }

        for (Produto item : listaProdutos) {
            System.out.println(item);
        }
    }

    // Tarefa 3 e 5: Alteração com sobrecarga de métodos
    static void alterarPreco() {
        System.out.println("\n>>> ATUALIZAÇÃO DE PREÇO <<<");
        int cod = lerInteiro("Código do produto a ser modificado: ");

        Produto itemEncontrado = buscarPorCodigo(cod);

        if (itemEncontrado == null) {
            System.out.println("Erro: Produto sob o código [" + cod + "] não foi localizado.");
            return;
        }

        System.out.println("Produto localizado: " + itemEncontrado.getNome());
        System.out.println("1 - Definir novo preço direto");
        System.out.println("2 - Aplicar taxa de desconto (%)");
        int modo = lerInteiro("Escolha a modalidade: ");

        if (modo == 1) {
            double novoValor = lerDecimal("Novo valor (R$): ");
            itemEncontrado.alterarPreco(novoValor);
            System.out.println("Sucesso: Valor atualizado!");
        } else if (modo == 2) {
            double valorBase = lerDecimal("Valor de referência (R$): ");
            double pctDesconto = lerDecimal("Percentual de desconto (%): ");
            itemEncontrado.alterarPreco(valorBase, pctDesconto);
            System.out.println("Sucesso: Valor com desconto aplicado com sucesso!");
        } else {
            System.out.println("Aviso: Modalidade inválida. Operação cancelada.");
        }
    }

    // Tarefa 3 e 6: Remoção sem erros
    static void remover() {
        System.out.println("\n>>> REMOÇÃO DE REGISTRO <<<");
        int cod = lerInteiro("Código do produto que deseja excluir: ");

        Produto itemEncontrado = buscarPorCodigo(cod);

        if (itemEncontrado != null) {
            listaProdutos.remove(itemEncontrado);
            System.out.println("Sucesso: Registro removido com sucesso.");
        } else {
            System.out.println("Erro: Não foi possível remover. Código [" + cod + "] não encontrado.");
        }
    }

    // Métodos auxiliares para evitar que o Scanner trave ao ler números
    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada incorreta. Por favor, insira um número inteiro.");
            }
        }
    }

    private static double lerDecimal(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(entrada.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada incorreta. Por favor, insira um valor numérico válido.");
            }
        }
    }
}