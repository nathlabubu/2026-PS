public class TesteLivroDAO {

    public static void main(String[] args) {
        LivroDAO dao = new LivroDAO();

        System.out.println("--- ETAPA 1: Insercao de 3 Livros ---");
        boolean l1 = dao.adicionarLivro("O Cortico", "Aluisio Azevedo", 1890);
        boolean l2 = dao.adicionarLivro("Iracema", "Jose de Alencar", 1865);
        boolean l3 = dao.adicionarLivro("Vidas Secas", "Graciliano Ramos", 1938);

        System.out.println("Livro 1 adicionado: " + l1);
        System.out.println("Livro 2 adicionado: " + l2);
        System.out.println("Livro 3 adicionado: " + l3);

        System.out.println("\n--- TESTE ADICIONAL: Registro Inexistente ---");
        boolean atualizouInexistente = dao.atualizarLivro(999999, "Livro Inexistente", "Autor Desconhecido", 2026);
        boolean excluiuInexistente = dao.excluirLivro(999999);

        System.out.println("Atualizacao: " + atualizouInexistente);
        System.out.println("Exclusao: " + excluiuInexistente);
    }
}