
public class Exercicio2 {

    public static void main(String[] args) {
        System.out.println(contarAprovados(new double[]{7.0, 4.0, 9.0, 6.0})); // 3
        System.out.println(contarAprovados(new double[]{2.0, 3.0, 5.0}));      // 0
        System.out.println(contarAprovados(new double[]{10.0, 8.0, 6.0}));     // 3
    }

    public static int contarAprovados(double[] notas) {
        if (notas == null) return 0;
        
        int aprovados = 0;
        for (double nota : notas) {
            if (nota >= 6.0) {
                aprovados++;
            }
        }
        return aprovados;
    }
}