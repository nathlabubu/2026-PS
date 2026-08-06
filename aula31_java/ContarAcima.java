package aula31_java;
public class ContarAcima {
public static int contarAcima(int[] valores, int limite) {
int qtd= 0;
for (int v : valores) {
if (v > limite) {
qtd++;
}
}
return qtd;
}
}