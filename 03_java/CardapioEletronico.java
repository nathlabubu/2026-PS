import java.util.Scanner;
import java.util.Random;

public class CardapioEletronico {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        // Variáveis acumuladoras do carrinho
        int qtdXBurguer = 0, qtdPizza = 0, qtdBatata = 0, qtdRefrigerante = 0, qtdSorvete = 0;
        double totalPedido = 0.0;

        boolean finalizando = false;

        // --- LOOP PRINCIPAL DO CARDÁPIO ---
        while (!finalizando) {
            System.out.println("===========================");
            System.out.println("FAST FOOD IFPR");
            System.out.println("===========================");
            System.out.println("1 - X-Burguer .......... R$ 18,00");
            System.out.println("2 - Pizza .............. R$ 35,00");
            System.out.println("3 - Batata Frita ....... R$ 12,00");
            System.out.println("4 - Refrigerante ....... R$ 8,00");
            System.out.println("5 - Sorvete ............ R$ 10,00");
            System.out.println("6 - Finalizar Pedido");
            System.out.println("===========================");
            System.out.println();

            System.out.print("Escolha: ");
            int opcao = entrada.nextInt();

            // Se escolher a opção 6 (Finalizar Pedido) direto no menu
            if (opcao == 6) {
                if (totalPedido == 0) {
                    System.out.println("\nSeu carrinho está vazio! Selecione um item antes.\n");
                    continue;
                }
                break; // Sai do loop para exibir o resumo final
            }

            // Trata opção inválida do cardápio
            if (opcao < 1 || opcao > 5) {
                System.out.println("\nOpção inválida. Tente novamente.\n");
                continue;
            }

            System.out.print("\nQuantidade: ");
            int quantidade = entrada.nextInt();

            if (quantidade <= 0) {
                System.out.println("Quantidade inválida!\n");
                continue;
            }

            // --- SWITCH: PROCESSA O ITEM E MOSTRA O NOME/VALOR SELECIONADO ---
            switch (opcao) {
                case 1:
                    System.out.println("\nItem selecionado: X-Burguer (R$ 18,00)");
                    qtdXBurguer += quantidade;
                    totalPedido += 18.00 * quantidade;
                    break;
                case 2:
                    System.out.println("\nItem selecionado: Pizza (R$ 35,00)");
                    qtdPizza += quantidade;
                    totalPedido += 35.00 * quantidade;
                    break;
                case 3:
                    System.out.println("\nItem selecionado: Batata Frita (R$ 12,00)");
                    qtdBatata += quantidade;
                    totalPedido += 12.00 * quantidade;
                    break;
                case 4:
                    System.out.println("\nItem selecionado: Refrigerante (R$ 8,00)");
                    qtdRefrigerante += quantidade;
                    totalPedido += 8.00 * quantidade;
                    break;
                case 5:
                    System.out.println("\nItem selecionado: Sorvete (R$ 10,00)");
                    qtdSorvete += quantidade;
                    totalPedido += 10.00 * quantidade;
                    break;
            }

            System.out.println("Item adicionado ao pedido!");

            // --- PERGUNTA DE FLUXO (PERMITE CONTINUAR OU IR DE FATO PRO PAGAMENTO) ---
            System.out.println("\nDeseja continuar comprando?");
            System.out.println("1 - Sim (Voltar ao Cardápio)");
            System.out.println("2 - Finalizar (Ir para o Pagamento)");
            System.out.println();
            System.out.print("Escolha: ");
            int resposta = entrada.nextInt();

            if (resposta == 2) {
                finalizando = true; // Quebra o while e vai para o final do código
            }
            System.out.println();
        }

        // --- TELA DE RESUMO COMPLETO ---
        System.out.println("===========================");
        System.out.println("RESUMO DO PEDIDO");
        System.out.println("===========================");
        
        if (qtdXBurguer > 0) System.out.printf("%dx X-Burguer ........ R$ %.2f\n", qtdXBurguer, (qtdXBurguer * 18.00));
        if (qtdPizza > 0) System.out.printf("%dx Pizza ............ R$ %.2f\n", qtdPizza, (qtdPizza * 35.00));
        if (qtdBatata > 0) System.out.printf("%dx Batata Frita ..... R$ %.2f\n", qtdBatata, (qtdBatata * 12.00));
        if (qtdRefrigerante > 0) System.out.printf("%dx Refrigerante ..... R$ %.2f\n", qtdRefrigerante, (qtdRefrigerante * 8.00));
        if (qtdSorvete > 0) System.out.printf("%dx Sorvete .......... R$ %.2f\n", qtdSorvete, (qtdSorvete * 10.00));
        
        System.out.println();
        System.out.printf("TOTAL: R$ %.2f\n", totalPedido);
        System.out.println("===========================");

        // --- ETAPA DE PAGAMENTO ---
        System.out.println("\nForma de pagamento:");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão");
        System.out.println("3 - PIX");
        System.out.println();
        System.out.print("Escolha: ");
        int formaPagamento = entrada.nextInt();

        if (formaPagamento >= 1 && formaPagamento <= 3) {
            System.out.println("\nPagamento realizado com sucesso!");
        } else {
            System.out.println("\nForma de pagamento inválida. Processando com padrão.");
        }

        // --- EMISSÃO DA SENHA DO PEDIDO ---
        int numeroPedido = random.nextInt(900) + 100;

        System.out.println("\nPedido Nº " + numeroPedido);
        System.out.println("Aguarde a chamada do seu pedido.");

        entrada.close();
    }
}