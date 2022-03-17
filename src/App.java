
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // Variable para la conexion 
        String connectionUrl = "jdbc:sqlserver://IDEAPAD-GAMING-:1433;databaseName=AdventureWorks2019;user=sa;password=cacas;";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM Person.Contact";
            ResultSet rs = stmt.executeQuery(SQL);

            // Solucion para iterar y mostrar los resultados del query.
            while (rs.next()) {
                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
            }
        }
        // Handler para errores.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
