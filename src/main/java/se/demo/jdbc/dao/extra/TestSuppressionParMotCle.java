package se.demo.jdbc.dao.extra;

import se.demo.jdbc.dao.FournisseurDao;
import se.demo.jdbc.dao.FournisseurDaoJDBC;
import se.demo.jdbc.dao.util.UtilFouDaoDisplay;
import java.util.Scanner;

public class TestSuppressionParMotCle
{
    public static void main(String[] args)
    {
        FournisseurDao fournisseurDao = new FournisseurDaoJDBC();
        Scanner scanner = new Scanner(System.in);

        // display all
        UtilFouDaoDisplay.display(fournisseurDao);

        //method
        System.out.println("Delete by keyword: ");
        String scInput = scanner.next();
        fournisseurDao.deleteByKeyword(scInput);

        //display all
        UtilFouDaoDisplay.display(fournisseurDao);
    }
}