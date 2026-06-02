import java.util.Scanner;

public class CardapioRestaurante {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("    RESTAURANTE  SAD FOOD ");
        System.out.println("=================================");
        System.out.println("1 - X-Burguer .......... R$ 18,00");
        System.out.println("2 - Pizza .............. R$ 35,00");
        System.out.println("3 - Suco Natural ....... R$ 8,00");
        System.out.println("4 - Café ............... R$ 5,00");
        System.out.println("5 - Bolo de chocolate... R$ 10,00");
        System.out.println("=================================");

        System.out.print("Escolha uma opção: ");
        int opcao = entrada.nextInt();

        if (opcao == 1) {
            System.out.println("Você escolheu X-Burguer valor: R$ 18,00.");
        } else if (opcao == 2) {
            System.out.println("Você escolheu Pizza valor: R$ 35,00 .");
        } else if (opcao == 3) {
            System.out.println("Você escolheu Suco Natural valor: R$ 8,00.");
        } else if (opcao == 4) {
            System.out.println("Você escolheu Café valor: 5,00.");
        } else if (opcao == 5) {
            System.out.println("Você escolheu Bolo de chocolate valor: R$ 10,00.");
        } else {
            System.out.println("Opção inválida.");
        }

        entrada.close();
    }
}