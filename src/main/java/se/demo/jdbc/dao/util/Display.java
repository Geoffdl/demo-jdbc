package se.demo.jdbc.dao.util;

import se.demo.jdbc.dao.FournisseurDao;
import se.demo.jdbc.entites.Fournisseur;

import java.util.List;

public class Display
{
    public static void display(FournisseurDao fournisseurDao){
        List<Fournisseur> fournisseurs = fournisseurDao.extraire();
        System.out.println("List des fournisseurs: ");
        for (Fournisseur f : fournisseurs)
        {
            System.out.println("ID: " + f.getId() + ", Nom : " + f.getNom());
        }
    }
}