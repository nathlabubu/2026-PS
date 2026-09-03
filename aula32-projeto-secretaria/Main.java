/*
* Disciplina: 2026-PS
* Esdudante : Nathaly Vitória de Ananias Fernandes 
* Data      : 2026.08.11
* Projeto   : aula32-projeto-secretaria
* Arquivo   : Main.java
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Aluno> gaveteiro = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        do {
            // Nível C: Identidade visível e personalização do sistema
            System.out.println("==================================================");
            System.out.println("  SISTEMA DE SECRETARIA - CAMPUS NATHALY");
            System.out.println("==================================================");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Listar Todos os Alunos");
            System.out.println("3 - Buscar Aluno por Matrícula");
            System.out.println("4 - Buscar Aluno por Nome (Melhoria A)");
            System.out.println("5 - Atualizar Dados do Aluno");
            System.out.println("6 - Remover Aluno");
            System.out.println("7 - Relatório por Curso");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(" Opção inválida! Digite apenas um número do menu.");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscarPorMatriculaMenu();
                    break;
                case 4:
                    buscarPorNome();
                    break;
                case 5:
                    atualizar();
                    break;
                case 6:
                    remover();
                    break;
                case 7:
                    gerarRelatorio();
                    break;
                case 0:
                    System.out.println("Encerando o sistema da secretaria... Até logo!");
                    break;
                default:
                    System.out.println(" Opção inexistente. Tente novamente.");
            }

        } while (opcao != 0);
    }

    // Nível C, B e A: Cadastrar com validação de duplicidade e validação de campo vazio (Melhoria Nível A)
    private static void cadastrar() {
        System.out.println("--- [ NOVO CADASTRO DE ALUNO ] ---");

        int matricula = lerInteiroValido("Digite a matrícula: ");

        // Nível B: Matrícula única
        if (buscarPorMatricula(matricula) != null) {
            System.out.println(" Erro: Já existe um aluno cadastrado com a matrícula " + matricula + "!");
            return;
        }

        // Nível A (Melhoria): Impedir texto vazio
        String nome = lerTextoNaoVazio("Digite o nome completo: ");
        String curso = lerTextoNaoVazio("Digite o curso do aluno: ");
        double ira = lerDoubleValido("Digite o IRA (0.0 a 10.0): ", 0.0, 10.0);

        Aluno aluno = new Aluno(matricula, nome, curso, ira);
        gaveteiro.add(aluno);

        System.out.println(" Aluno " + nome + " cadastrado com sucesso!");
    }

    // Nível C e A: Listar enxuto utilizando toString()
    private static void listar() {
        System.out.println("--- [ LISTAGEM DE ALUNOS ] ---");
        if (gaveteiro.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado no momento.");
            return;
        }

        for (Aluno a : gaveteiro) {
            System.out.println(a); // Executa o toString() de Aluno
        }
    }

    // Nível B: Método de busca que retorna referência do objeto ou null
    private static Aluno buscarPorMatricula(int matricula) {
        for (Aluno a : gaveteiro) {
            if (a.getMatricula() == matricula) {
                return a;
            }
        }
        return null;
    }

    // Submenu auxiliar para exibição da busca
    private static void buscarPorMatriculaMenu() {
        System.out.println("--- [ BUSCA POR MATRÍCULA ] ---");
        int mat = lerInteiroValido("Digite a matrícula para consulta: ");
        Aluno aluno = buscarPorMatricula(mat);

        if (aluno != null) {
            System.out.println(" Aluno localizado:");
            System.out.println(aluno);
        } else {
            System.out.println(" Aluno com matrícula " + mat + " não foi encontrado no sistema.");
        }
    }

    // Nível A (Melhoria): Busca complementar por nome
    private static void buscarPorNome() {
        System.out.println("--- [ BUSCA POR NOME ] ---");
        String termo = lerTextoNaoVazio("Digite o nome ou parte do nome: ").toLowerCase();
        boolean encontrado = false;

        for (Aluno a : gaveteiro) {
            if (a.getNome().toLowerCase().contains(termo)) {
                System.out.println(a);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println(" Nenhum aluno encontrado contendo '" + termo + "'.");
        }
    }

    // Nível B: Atualização reutilizando a busca
    private static void atualizar() {
        System.out.println("--- [ ATUALIZAR CADASTRO ] ---");
        int mat = lerInteiroValido("Digite a matrícula do aluno a atualizar: ");
        Aluno aluno = buscarPorMatricula(mat);

        if (aluno == null) {
            System.out.println(" Aluno não localizado. Atualização cancelada.");
            return;
        }

        System.out.println("Aluno encontrado: " + aluno.getNome());
        String novoNome = lerTextoNaoVazio("Novo nome: ");
        String novoCurso = lerTextoNaoVazio("Novo curso: ");
        double novoIra = lerDoubleValido("Novo IRA (0.0 a 10.0): ", 0.0, 10.0);

        // Altera o objeto diretamente na memória
        aluno.setNome(novoNome);
        aluno.setCurso(novoCurso);
        aluno.setIra(novoIra);

        System.out.println(" Cadastro atualizado com sucesso!");
    }

    // Nível B: Remoção reutilizando a busca e com confirmação prévia
    private static void remover() {
        System.out.println("--- [ REMOVER ALUNO ] ---");
        int mat = lerInteiroValido("Digite a matrícula do aluno a remover: ");
        Aluno aluno = buscarPorMatricula(mat);

        if (aluno == null) {
            System.out.println(" Aluno não localizado. Nenhuma exclusão efetuada.");
            return;
        }

        System.out.println("Tem certeza que deseja remover o aluno " + aluno.getNome() + "? (S/N): ");
        String confirmacao = scanner.nextLine().trim();

        if (confirmacao.equalsIgnoreCase("S")) {
            gaveteiro.remove(aluno);
            System.out.println("Ficha do aluno removida com sucesso!");
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    // Nível A: Relatório com contagem por curso informado em tempo de execução
    private static void gerarRelatorio() {
        System.out.println("--- [ RELATÓRIO GERAL ] ---");
        System.out.println("Total de alunos cadastrados: " + gaveteiro.size());

        if (gaveteiro.isEmpty()) {
            return;
        }

        String cursoAlvo = lerTextoNaoVazio("Digite o nome do curso para filtrar o relatório: ");
        int contagem = 0;

        for (Aluno a : gaveteiro) {
            if (a.getCurso().equalsIgnoreCase(cursoAlvo.trim())) {
                contagem++;
            }
        }

        System.out.println("Total de alunos matriculados no curso de '" + cursoAlvo + "': " + contagem);
    }

    // Métodos Auxiliares para Validação de Entrada
    private static String lerTextoNaoVazio(String mensagem) {
        String texto = "";
        while (texto.trim().isEmpty()) {
            System.out.print(mensagem);
            texto = scanner.nextLine();
            if (texto.trim().isEmpty()) {
                System.out.println(" O campo não pode ficar em branco. Digite novamente.");
            }
        }
        return texto.trim();
    }

    private static int lerInteiroValido(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(" Valor numérico inválido. Digite um número inteiro.");
            }
        }
    }

    private static double lerDoubleValido(String mensagem, double min, double max) {
        while (true) {
            System.out.print(mensagem);
            try {
                double val = Double.parseDouble(scanner.nextLine().trim());
                if (val >= min && val <= max) {
                    return val;
                }
                System.out.println(" Digite um valor numérico entre " + min + " e " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println(" Valor numérico inválido. Digite um número decimal válido (ex: 8.5).");
            }
        }
    }
}