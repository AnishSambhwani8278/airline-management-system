import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection conn;
    Statement stmt;
    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "12345678");
            stmt = conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}