import java.util.Scanner;
import java.util.Random;

public class CardapioEletronico {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        // Variáveis acumuladoras do carrinho (Inspirado em Steven Universe)
        int qtdBiscoitoGatinho = 0, qtdBatataFrita = 0, qtdRosquinha = 0, qtdChaChapeu = 0, qtdSuperSanduiche = 0;
        double totalPedido = 0.0;

        boolean finalizando = false;

        // --- LOOP PRINCIPAL DO CARDÁPIO ---
        while (!finalizando) {
            System.out.println("=================================");
            System.out.println("     🌟 BIG ROSQUINHA TOTEM 🌟   ");
            System.out.println("=================================");
            System.out.println("1 - Biscoito Gatinho ..... R$ 6,00");
            System.out.println("2 - Batata Frita (Peedee)  R$ 12,00");
            System.out.println("3 - Rosquinha de Leão .... R$ 5,50");
            System.out.println("4 - Chá de Chapéu ........ R$ 4,00");
            System.out.println("5 - Super Sanduíche ...... R$ 25,00");
            System.out.println("6 - Finalizar Pedido");
            System.out.println("=================================");
            System.out.println();

            System.out.print("Escolha seu item: ");
            int opcao = entrada.nextInt();

            // Opção 6: Finalizar Pedido direto no menu
            if (opcao == 6) {
                if (totalPedido == 0) {
                    System.out.println("\nSeu carrinho está vazio! Escolha uma comida antes de ir.\n");
                    continue;
                }
                break; // Sai do loop para exibir o resumo final
            }

            // Trata opção inválida do cardápio
            if (opcao < 1 || opcao > 5) {
                System.out.println("\nOpção inválida! As Gems quebraram o sistema, tente novamente.\n");
                continue;
            }

            System.out.print("\nQuantidade: ");
            int quantidade = entrada.nextInt();

            if (quantidade <= 0) {
                System.out.println("Quantidade inválida! Steven não consegue comer menos que zero.\n");
                continue;
            }

            // --- SWITCH COM O CARDÁPIO DE BEACH CITY ---
            switch (opcao) {
                case 1:
                    System.out.println("\nItem selecionado: Biscoito Gatinho! (R$ 6,00) - Ele morde de volta!");
                    qtdBiscoitoGatinho += quantidade;
                    totalPedido += 6.00 * quantidade;
                    break;
                case 2:
                    System.out.println("\nItem selecionado: Batata Frita do Beach City Fries! (R$ 12,00)");
                    qtdBatataFrita += quantidade;
                    totalPedido += 12.00 * quantidade;
                    break;
                case 3:
                    System.out.println("\nItem selecionado: Rosquinha de Leão! (R$ 5,50)");
                    qtdRosquinha += quantidade;
                    totalPedido += 5.50 * quantidade;
                    break;
                case 4:
                    System.out.println("\nItem selecionado: Chá de Chapéu! (R$ 4,00)");
                    qtdChaChapeu += quantidade;
                    totalPedido += 4.00 * quantidade;
                    break;
                case 5:
                    System.out.println("\nItem selecionado: Super Sanduíche da união das Gems! (R$ 25,00)");
                    qtdSuperSanduiche += quantidade;
                    totalPedido += 25.00 * quantidade;
                    break;
            }

            System.out.println("Item adicionado ao pedido!");

            // Pergunta de fluxo para continuar ou pagar
            System.out.println("\nDeseja continuar comprando?");
            System.out.println("1 - Sim (Ficar na Big Rosquinha)");
            System.out.println("2 - Finalizar (Chamar o Lars para pagar)");
            System.out.println();
            System.out.print("Escolha: ");
            int resposta = entrada.nextInt();

            if (resposta == 2) {
                finalizando = true; 
            }
            System.out.println();
        }

        // --- TELA DE RESUMO COMPLETO ---
        System.out.println("=================================");
        System.out.println("        SACOLA DO STEVEN         ");
        System.out.println("=================================");
        
        if (qtdBiscoitoGatinho > 0) System.out.printf("%dx Biscoito Gatinho .... R$ %.2f\n", qtdBiscoitoGatinho, (qtdBiscoitoGatinho * 6.00));
        if (qtdBatataFrita > 0) System.out.printf("%dx Batata Frita ........ R$ %.2f\n", qtdBatataFrita, (qtdBatataFrita * 12.00));
        if (qtdRosquinha > 0) System.out.printf("%dx Rosquinha de Leão ... R$ %.2f\n", qtdRosquinha, (qtdRosquinha * 5.50));
        if (qtdChaChapeu > 0) System.out.printf("%dx Chá de Chapéu ....... R$ %.2f\n", qtdChaChapeu, (qtdChaChapeu * 4.00));
        if (qtdSuperSanduiche > 0) System.out.printf("%dx Super Sanduíche ..... R$ %.2f\n", qtdSuperSanduiche, (qtdSuperSanduiche * 25.00));
        
        System.out.println();
        System.out.printf("TOTAL DA COMPRA: R$ %.2f\n", totalPedido);
        System.out.println("=================================");

        // --- ETAPA DE PAGAMENTO ---
        System.out.println("\nForma de pagamento:");
        System.out.println("1 - Dinheiro (Dólares de Beach City)");
        System.out.println("2 - Cartão do Greg Universe");
        System.out.println("3 - PIX Crystal Gem");
        System.out.println();
        System.out.print("Escolha como pagar: ");
        int formaPagamento = entrada.nextInt();

        if (formaPagamento >= 1 && formaPagamento <= 3) {
            System.out.println("\nPagamento realizado com sucesso! Sadie já carimbou sua nota.");
        } else {
            System.out.println("\nForma de pagamento inválida. Cebola roubou seu dinheiro?");
        }

        // --- EMISSÃO DA SENHA DO PEDIDO ---
        int numeroPedido = random.nextInt(900) + 100;

        System.out.println("\nPedido Nº " + numeroPedido);
        System.out.println("Aguarde na praia pela chamada do seu pedido. Acredite no Steven!");

        entrada.close();
    }
}