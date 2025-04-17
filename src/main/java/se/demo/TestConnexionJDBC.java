package se.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionJDBC
{
    public static void main(String[] args)
    {

        ResourceBundle config = ResourceBundle.getBundle("database");
        String url = config.getString("database.url");
        String user = config.getString("database.user");
        String password = config.getString("database.password");

        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(url, user, password);

            System.out.println(conn);

            conn.close();

        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}