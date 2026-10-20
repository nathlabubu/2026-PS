public class TesteLivroDAO {
    public static void main(String[] args) {
        LivroDAO dao = new LivroDAO();

    
        boolean status1 = dao.adicionarLivro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943);
        System.out.println("O Pequeno Príncipe cadastrado: " + status1);

      
        boolean status2 = dao.adicionarLivro("A canção de Aquiles", "Madeline Miller", 2011);
        System.out.println("A canção de Aquiles cadastrado: " + status2);
    }
}