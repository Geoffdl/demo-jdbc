package se.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate
{
    public static void main(String[] args)
    {
        ResourceBundle config = ResourceBundle.getBundle("database");
        String url = config.getString("database.url");
        String user = config.getString("database.user");
        String pwd = config.getString("database.password");


        Statement stmt = null;


        try (Connection connection = DriverManager.getConnection(url, user, pwd))
        {

            stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE FOURNISSEUR SET NOM = 'La Maison des Peintures' WHERE NOM = 'La Maison de la Peinture'");

        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally
        {


            if (stmt != null)
            {
                try
                {
                    stmt.close();
                } catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}