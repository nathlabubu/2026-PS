/*
* Disciplina: 2026-PS
* Esdudante : Nathaly Vitória de Ananias Fernandes 
* Data      : 2026.08.11
* Projeto   : aula32-projeto-secretaria
* Arquivo   : Main.java
*/
import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        ArrayList<Aluno> lista = new ArrayList<Aluno>();

        while (true){
            System.out.println("=========================================");
            System.out.println("           SECRETARIA DA NATHALY         ");
            System.out.println("=========================================");
            System.out.println("[1] Cadastrar aluno");
            System.out.println("[2] Listar aluno");
            System.out.println("[3] Buscar por matricula");
            System.out.println("[4] Atualizar curso");
            System.out.println("[0] Sair");
            System.out.println("Sua escola: ");
            String opcao = teclado.nextLine().trim(); 

            if (opcao.equals("0")){
                System.out.println("Secretaria fechada. Ate a proxima!");
                break;
            }else if (opcao.equals("1")){
                cadastrar(lista, teclado);
            }else if (opcao.equals("2"));{
                listar(lista);
            }else if (opcao.equals("3")){
                buscar(lista, teclado);
            }else if(opcao.equals("4")){
                atualizar(lista, teclado);
            }else{
                System.out.println("Opcao invalida! Vale 0, 1, 2, 3 ou 4.");
            }
        }
    }
    static void cadastrar(ArrayList<Aluno> lista, Scanner teclado){
        System.out.print("Nome: ");
        String nome = teclado.nextLine().trim();
        System.out.print("Matricula: ");
        String matricula = teclado.nextLine().trim();
        System.out.print("Curso: ");
        String curso = teclado.nextLine().trim();
        Aluno novoAluno = new Aluno (nome, matricula, curso);
        lista.add (novoAluno);
        System.out.print("Ficha de:" + novo.getNome() +"arquivada!");

        static void listar(ArrayList<Aluno> lista){
            if(lista.size() == 0){
                System.out.println("Nenhuma ficha no gaveteiro ainda.");
                return;
            }
            System.out.println("---FICHAS NO GAVETEIRO: " + lista.size() +"---");
            for (int i = 0; i < lista.size(); i++){
                Aluno a = lista.get(i;
                    System.out.println(a.getMatricula() + "|" + a.getNome() + "|" + a.getCurso());

                )
            }

        }
        static Aluno buscarPorMatricula(ArrayList<Aluno> lista, String matricula){
            for (int i = 0; i < lista.size(); i++){
                Aluno a = lista.get(i);
                if (a.getMatricula().equals(matricula)){
                    return a;
                }
            }
        }
        return null;
    }
}