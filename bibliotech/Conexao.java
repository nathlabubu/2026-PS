import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/bibliotech?useSSL=false&allowPublicKeyRetrieval=true";

    public static Connection getConexao() throws SQLException {
        String usuario = System.getenv("DB_USER");
        String senha = System.getenv("DB_PASSWORD");

        if (usuario == null) {
            usuario = "root";
        }
        if (senha == null) {
            senha = "";
        }

        return DriverManager.getConnection(URL, usuario, senha);
    }
}