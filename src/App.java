import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Comprobacion de conexion:");
        System.out.println("");
        //ins1();
        //ins2();
        mysqlconn();
        // Variable para la conexion 
    }    

    public static void ins1() throws Exception{
        System.out.println("Instancia 1: ");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;instanceName=IDEAPAD-GAMING-\\MSSQL1;databaseName=AdventureWorks2019;user=sa;password=cacas;encrypt=true;trustServerCertificate=true";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM Person.Person";
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
    public static void ins2() throws Exception{
        System.out.println("");
        System.out.println("Instancia 2: ");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;instanceName=IDEAPAD-GAMING-\\MSSQL2;databaseName=AdventureWorks2019;user=sa;password=cacas;encrypt=true;trustServerCertificate=true";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 5 * FROM Person.Person";
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

    public static void mysqlconn() throws Exception{
        String Usuario="root";
        String Pass="Cacas&89";
        System.out.println("Conexion MySQL:");        
        String NBD="adventureworks2019";
        String url="jdbc:mysql://localhost:3306/"+NBD;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection (url,Usuario,Pass);
            if (conexion !=null){
                System.out.println("Conexion exitosa a "+ NBD + " En MySQL");
                System.out.println("Query de prueba: ");
            } 
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery ("select *  from copiaproduct order by ProductID desc limit 1;");
            while (rs.next())
            {
                System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " );
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        } 
    }
}