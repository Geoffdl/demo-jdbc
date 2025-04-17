package se.demo.jdbc;

import se.demo.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelect
{
    public static void main(String[] args)
    {
        ResourceBundle config = ResourceBundle.getBundle("database");
        String url = config.getString("database.url");
        String user = config.getString("database.user");
        String pwd = config.getString("database.password");


        Statement stmt = null;

        ArrayList<Fournisseur> fournisseurData = new ArrayList<>();


        try (Connection connection = DriverManager.getConnection(url, user, pwd))
        {

            stmt = connection.createStatement();

            ResultSet curseur = stmt.executeQuery("SELECT * FROM FOURNISSEUR");

            while (curseur.next())
            {
                fournisseurData.add(new Fournisseur(curseur.getInt("id"), curseur.getString("nom")));
            }

            System.out.println(fournisseurData);

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