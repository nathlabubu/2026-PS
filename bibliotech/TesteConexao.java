import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {
        try (Connection conn = Conexao.getConexao()) {
            if (conn != null) {
                System.out.println("Conexao com o banco de dados estabelecida com sucesso!");
            }
        } catch (Exception e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}