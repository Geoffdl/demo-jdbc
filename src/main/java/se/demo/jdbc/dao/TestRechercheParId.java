package se.demo.jdbc.dao;

import se.demo.jdbc.dao.util.Display;
import se.demo.jdbc.entites.Fournisseur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestRechercheParId
{
    public static void main(String[] args)
    {

        FournisseurDao fournisseurDao = new FournisseurDaoJDBC();
        Scanner scanner = new Scanner(System.in);

        Fournisseur fournisseur = null;

        //method
        System.out.println("Search by id: ");
        int scInput = scanner.nextInt();
        fournisseur = fournisseurDao.findById(scInput);

        System.out.println("ID: " + fournisseur.getId() + " NOM: " + fournisseur.getNom());

    }
}