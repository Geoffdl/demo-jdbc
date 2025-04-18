package se.demo;

import java.sql.*;
import java.util.ResourceBundle;


public class TestConnexionJDBC
{
    public static void main(String[] args)
    {

        ResourceBundle config = ResourceBundle.getBundle("database");
        String url = config.getString("database.url");
        String user = config.getString("database.user");
        String pwd = config.getString("database.password");


        Statement stmt = null;
        ResultSet curseur = null;

        try (Connection connection = DriverManager.getConnection(url, user, pwd))
        {

            System.out.println("Connected on :" + connection);

            stmt = connection.createStatement();

            //insert

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS compte(Id int PRIMARY KEY auto_increment, Nom varchar(25))");
            stmt.executeUpdate("INSERT INTO compte (nom) value ('Geoff')");

            //update
            stmt.executeUpdate("UPDATE compte SET nom=UPPER(nom) WHERE nom = 'Geoff'");

            //delete
            stmt.executeUpdate("DELETE FROM compte WHERE nom = 'bob'");


            //read
            curseur = stmt.executeQuery("SELECT * FROM compte");

            while (curseur.next())
            {
                System.out.println(curseur.getInt("id") + " - " + curseur.getString("nom"));
            }


        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally
        {

            if (curseur != null)
            {
                try
                {
                    curseur.close();
                } catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
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