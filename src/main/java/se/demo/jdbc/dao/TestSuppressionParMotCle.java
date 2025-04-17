package se.demo.jdbc.dao;

import se.demo.jdbc.dao.util.Display;
import java.util.Scanner;

public class TestSuppressionParMotCle
{
    public static void main(String[] args)
    {
        FournisseurDao fournisseurDao = new FournisseurDaoJDBC();
        Scanner scanner = new Scanner(System.in);

        // display all
        Display.display(fournisseurDao);

        //method
        System.out.println("Delete by keyword: ");
        String scInput = scanner.next();
        fournisseurDao.deleteByKeyword(scInput);

        //display all
        Display.display(fournisseurDao);
    }
}