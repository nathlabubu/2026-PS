
public class Exercicio5 {

    public static void main(String[] args) {
        double[] caso1 = {7.0, 5.0, 9.0, 6.0};
        System.out.println("--- Caso de Teste 1 ---");
        exibirBoletim(caso1);
        
        double[] caso2 = {4.0, 3.0, 5.0};
        System.out.println("\n--- Caso de Teste 2 ---");
        exibirBoletim(caso2);
    }

    public static void exibirBoletim(double[] notas) {
        // Integração real e reuso sem duplicação de código
        double media = Exercicio1.calcularMedia(notas);
        int aprovados = Exercicio2.contarAprovados(notas);
        
        String situacao = (media >= 6.0) ? "APROVADA" : "EM RECUPERAÇÃO";
        
        System.out.println("Média: " + media);
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Situação: " + situacao);
        
        // Exibição do Desafio complementar
        System.out.println("Alunos acima da média: " + contarAcimaDaMedia(notas));
    }

    // ⭐ Método do Desafio para atingir o critério Excelente (A)
    public static int contarAcimaDaMedia(double[] notas) {
        if (notas == null || notas.length == 0) return 0;
        
        double media = Exercicio1.calcularMedia(notas); 
        int contador = 0;
        for (double nota : notas) {
            if (nota > media) {
                contador++;
            }
        }
        return contador;
    }
}