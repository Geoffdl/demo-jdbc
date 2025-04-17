package se.demo.jdbc.extra;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TestInteractiveDelete
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

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM FOURNISSEUR WHERE NOM LIKE ?");

            System.out.print("Delete by keyword: ");
            String choice = sc.next();

            preparedStatement.setString(1, "%"+choice+"%");
            preparedStatement.executeQuery();

            ResultSet cursor = connection.createStatement().executeQuery("SELECT * FROM FOURNISSEUR");
            while(cursor.next()){
                System.out.println("id: "+cursor.getInt("id") +", nom : " + cursor.getString("nom"));
            }


            cursor.close();
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