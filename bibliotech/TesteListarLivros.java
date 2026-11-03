import java.util.List;

public class TesteListarLivros {

    public static void main(String[] args) {

        LivroDAO dao = new LivroDAO();
        List<Livro> livros = dao.listarLivros();

        System.out.println("=== LIVROS CADASTRADOS (A partir de 2000) ===");

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            for (Livro livro : livros) {
                // Desafio Prático: filtrar livros com ano >= 2000
                if (livro.getAno() >= 2000) {
                    System.out.println(
                        livro.getId() + " - " +
                        livro.getTitulo() + " - " +
                        livro.getAutor() + " (" +
                        livro.getAno() + ")"
                    );
                }
            }
        }
    }
}