package se.demo.jdbc.dao.extra;


import se.demo.jdbc.dao.FournisseurDao;
import se.demo.jdbc.dao.FournisseurDaoJDBC;
import se.demo.jdbc.entites.Fournisseur;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestRechercheParId
{
    public static void main(String[] args)
    {

        FournisseurDao fournisseurDao = new FournisseurDaoJDBC();
        Scanner scanner = new Scanner(System.in);

        Fournisseur fournisseur = null;

        //method
        while (true)
        {
            try
            {
                System.out.println("Search by id: ");
                int scInput = scanner.nextInt();
                fournisseur = fournisseurDao.findById(scInput);
                break;
            } catch (FournisseurIdNotFound e)
            {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e)
            {
                System.out.println("Veuillez entrer un nombre valide");
            }
        }
        scanner.close();

        System.out.println("ID: " + fournisseur.getId() + " NOM: " + fournisseur.getNom());

    }
}