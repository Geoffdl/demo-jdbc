package se.demo.jdbc.extra;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TestInteractiveInsert
{
    public static void main(String[] args)
    {
        ResourceBundle config = ResourceBundle.getBundle("database");
        String url = config.getString("database.url");
        String user = config.getString("database.user");
        String pwd = config.getString("database.password");


        try (Connection connection = DriverManager.getConnection(url, user, pwd))
        {
            Scanner sc = new Scanner(System.in);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FOURNISSEUR (NOM) VALUES (?)");

            System.out.print("How many fournisseur do you want to insert ? :");
            int choice = sc.nextInt();
            sc.nextLine();

            while (choice > 0)
            {
                System.out.print("\nPlease input a name for the fournisseur: ");
                String newFournisseur = sc.nextLine();
                preparedStatement.setString(1, newFournisseur);
                preparedStatement.executeQuery();
                System.out.println("\nAdded :" + newFournisseur);

                choice--;
            }


            preparedStatement.close();
            sc.close();

        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}