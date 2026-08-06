package aula31_java;
public class MaiorValor {
    static int maiorValor(int[] numeros) {
        int maior = numeros[0];
        for (int n : numeros) {
            if (n > maior) {
                maior = n;
            }
        }
        return maior;
    }
}