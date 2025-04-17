package se.demo.jdbc.dao;

import se.demo.jdbc.dao.extra.FournisseurIdNotFound;
import se.demo.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJDBC implements FournisseurDao
{
    private final ResourceBundle config = ResourceBundle.getBundle("database");
    private final String URL = config.getString("database.url");
    private final String USER = config.getString("database.user");
    private final String PWD = config.getString("database.password");

    @Override
    public List<Fournisseur> extraire()
    {
        List<Fournisseur> fournisseurList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PWD);
             Statement statement = connection.createStatement();
             ResultSet cursor = statement.executeQuery("SELECT * FROM FOURNISSEUR"))
        {
            while (cursor.next())
            {
                fournisseurList.add(new Fournisseur(cursor.getInt("id"), cursor.getString("nom")));
//                fournisseurList.add(new Fournisseur( cursor.getString("nom")));
            }

        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return fournisseurList;
    }

    @Override
    public void insert(Fournisseur fournisseur)
    {
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD))
        {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO FOURNISSEUR VALUES (?,?)");
            statement.setInt(1, fournisseur.getId());
            statement.setString(2, fournisseur.getNom());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    @Override
    public int update(String ancienNom, String nouveauNom)
    {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD))
        {
            PreparedStatement statement = connection.prepareStatement("UPDATE FOURNISSEUR SET NOM = ? WHERE NOM = ?");

            statement.setString(1, ancienNom);
            statement.setString(2, nouveauNom);

            result = statement.executeUpdate();
            statement.close();

        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return result;
    }

    @Override
    public boolean delete(Fournisseur fournisseur)
    {
        int result = 0;

        try (Connection connection = DriverManager.getConnection(URL, USER, PWD))
        {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM FOURNISSEUR WHERE ID = ?");
            statement.setInt(1, fournisseur.getId());

            result = statement.executeUpdate();

            statement.close();

        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        if (result > 0)
        {
            return true;
        } else
            return false;
    }

    @Override
    public List<Fournisseur> findByKeyword(String keyword)
    {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FOURNISSEUR WHERE NOM LIKE ?"))
        {
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                fournisseurs.add(new Fournisseur(resultSet.getInt("id"),
                        resultSet.getString("nom")));
            }
            resultSet.close();
        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return fournisseurs;
    }

    @Override
    public int deleteByKeyword(String keyword)
    {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM FOURNISSEUR WHERE NOM LIKE ?"))
        {
            preparedStatement.setString(1, "%" + keyword + "%");
            result = preparedStatement.executeUpdate();

        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return result;
    }

    @Override
    public Fournisseur findById(int id) throws FournisseurIdNotFound
    {
        Fournisseur fournisseur = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FOURNISSEUR WHERE ID = ?"))
        {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    fournisseur = new Fournisseur(resultSet.getInt("id"), resultSet.getString("nom"));

                } else
                {
                    throw new FournisseurIdNotFound("No matching id found for id: " + id);
                }
            }

        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return fournisseur;
    }
}