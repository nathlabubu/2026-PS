
public class Exercicio1 {
    public static void main(String[] args) {
        System.out.println(calcularMedia(new double[]{7.0, 8.0, 9.0}));       
        System.out.println(calcularMedia(new double[]{6.0, 6.0, 6.0, 6.0})); 
        System.out.println(calcularMedia(new double[]{5.0, 10.0}));          
    }

    public static double calcularMedia(double[] notas) {
        if (notas == null || notas.length == 0) return 0.0;
        
        double soma = 0;
        for (double nota : notas) {
            soma += nota; 
        }
        
        return soma / notas.length; 
    }
}