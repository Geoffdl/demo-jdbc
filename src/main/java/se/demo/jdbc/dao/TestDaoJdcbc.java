package se.demo.jdbc.dao;

import se.demo.jdbc.entites.Fournisseur;

import java.util.ArrayList;
import java.util.List;

public class TestDaoJdcbc
{
    public static void main(String[] args)
    {

        FournisseurDao fournisseurDao = new FournisseurDaoJDBC();
        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurs = fournisseurDao.extraire();

        //insert 1
        fournisseurDao.insert(new Fournisseur(14,"France des matériaux"));

        //display
        display(fournisseurDao);
        /*
        List<Fournisseur> fournisseurs = fournisseurDao.extraire();
        System.out.println("List des fournisseurs: ");
        for (Fournisseur f : fournisseurs)
        {
            System.out.println("ID: " + f.getId() + ", Nom : " + f.getNom());
        }*/

        //update
        fournisseurDao.update("France des matériaux","France matériaux");

        display(fournisseurDao);

        //delete
        fournisseurDao.delete(fournisseurs.getLast());
        display(fournisseurDao);

        //special case insert « L’Espace Création ».
        fournisseurDao.insert(new Fournisseur(18, "L''espace Création"));
        fournisseurDao.insert(new Fournisseur(19, "L'espace Création"));

        display(fournisseurDao);

    }

    public static void display(FournisseurDao fournisseurDao){
        List<Fournisseur> fournisseurs = fournisseurDao.extraire();
        System.out.println("List des fournisseurs: ");
        for (Fournisseur f : fournisseurs)
        {
            System.out.println("ID: " + f.getId() + ", Nom : " + f.getNom());
        }
    }
}