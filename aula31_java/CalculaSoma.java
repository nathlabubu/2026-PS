package aula31_java;
public class CalculaSoma {
    static int calculaSoma(int[] numeros) {
        int soma = 0;
        for (int n : numeros) {
            soma += n;
        }
        return soma;
    }
}