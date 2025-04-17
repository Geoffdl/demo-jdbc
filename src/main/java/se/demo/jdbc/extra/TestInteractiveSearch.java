package se.demo.jdbc.extra;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TestInteractiveSearch
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

            Scanner sc = new Scanner(System.in);

            System.out.println("Select by name which fournisseur you want to see the info for");
            String queryParam = sc.next();

            PreparedStatement userQuery = connection.prepareStatement("SELECT * FROM FOURNISSEUR WHERE NOM LIKE ?");
            userQuery.setString(1, "%" + queryParam + "%");
            ResultSet queryResult = userQuery.executeQuery();

            while (queryResult.next())
            {
                System.out.println("fournisseur correspondant: " + "id - " + queryResult.getInt("id") + ", nom - " + queryResult.getString("nom"));
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