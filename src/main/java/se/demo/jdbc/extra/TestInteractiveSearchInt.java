package se.demo.jdbc.extra;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TestInteractiveSearchInt
{
    public static void main(String[] args)
    {
        ResourceBundle config = ResourceBundle.getBundle("database");
        String url = config.getString("database.url");
        String user = config.getString("database.user");
        String pwd = config.getString("database.password");

        try (Connection connection = DriverManager.getConnection(url, user, pwd);
             Statement stmt = connection.createStatement())
        {
            /*
            stmt.executeUpdate("INSERT INTO compta.FOURNISSEUR (ID, NOM) VALUES " +
                    "(5,'La Maison de la Peinture')," +
                    "(2,'Le fournisseur de trucs')," +
                    "(3,'La francaises des objets')"); */

            Scanner sc = new Scanner(System.in);

            System.out.println("Select by id which fournisseur you want to see the info for");
            int queryParam = sc.nextInt();

            PreparedStatement userQuery = connection.prepareStatement("SELECT * FROM FOURNISSEUR WHERE id = ?");
            userQuery.setInt(1, queryParam);
            ResultSet queryResult = userQuery.executeQuery();

            if (queryResult.next())
            {
                while (queryResult.next())
                {
                    System.out.println("fournisseur correspondant: " + "id - " + queryResult.getInt("id") + ", nom - " + queryResult.getString("nom"));
                }
            } else
            {
                System.out.println("Aucun fournisseur trouvé");
            }

            queryResult.close();
            userQuery.close();
            sc.close();

        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}