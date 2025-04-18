package se.demo.jdbc.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.demo.jdbc.entites.Fournisseur;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FournisseurDaoJDBCTest
{
    FournisseurDao fournisseurQueriesObject = new FournisseurDaoJDBC();
    List<Fournisseur> mockList = new ArrayList<>(List.of(new Fournisseur(93,"Fournisseur de test"), new Fournisseur(85, "Freelance dot com")));


    @BeforeEach
    void beginTransaction(){}
    @AfterEach
    void rollbackTransaction(){}

    @Test
    void mustInsertMultiple()
    {
        int result = fournisseurQueriesObject.insertAll(mockList);
        assertEquals(2,result);

    }
}