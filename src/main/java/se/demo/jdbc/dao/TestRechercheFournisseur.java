package se.demo.jdbc.dao;

import se.demo.jdbc.entites.Fournisseur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestRechercheFournisseur
{
    public static void main(String[] args)
    {
        FournisseurDao fournisseurDao = new FournisseurDaoJDBC();
        List<Fournisseur> fournisseurs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Search by keyword: ");
        String scInput = scanner.next();

        fournisseurs = fournisseurDao.findByKeyword(scInput);

        for(Fournisseur f : fournisseurs){
            System.out.println("ID: " + f.getId() + " NOM: " + f.getNom());
        }
    }
}