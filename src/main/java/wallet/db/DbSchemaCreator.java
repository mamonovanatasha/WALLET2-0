package wallet.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbSchemaCreator {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        String sql = "";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "12gjldbujd");
            stmt = c.createStatement();
            sql = "CREATE SCHEMA IF NOT EXISTS  swallet_schema ";
            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
        System.out.println("Schema is created successfully");
    }
}
