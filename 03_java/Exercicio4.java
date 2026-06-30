
public class Exercicio4 {

    public static void main(String[] args) {
        System.out.println(maiorValor(new int[]{3, 9, 5})); // 9
        System.out.println(maiorValor(12, 7));              // 12
        System.out.println(maiorValor(new int[]{4, 4, 4})); // 4
    }

    public static int maiorValor(int[] valores) {
        if (valores == null || valores.length == 0) {
            return Integer.MIN_VALUE; // Validação de robustez exigida para o Conceito A
        }
        
        int maior = valores[0];
        for (int valor : valores) {
            if (valor > maior) {
                maior = valor;
            }
        }
        return maior;
    }

    public static int maiorValor(int a, int b) {
        return (a > b) ? a : b;
    }
}