package se.demo.jdbc.dao;

import se.demo.jdbc.dao.extra.FournisseurIdNotFound;
import se.demo.jdbc.entites.Fournisseur;

import java.util.List;

public interface FournisseurDao
{
    List<Fournisseur> extraire();

    void insert(Fournisseur fournisseur);

    int update(String ancienNom, String nouveauNom);

    boolean delete(Fournisseur fournisseur);

    /* extra 1*/
    List<Fournisseur> findByKeyword(String keyword);
    int deleteByKeyword(String keyword);
    Fournisseur findById(int id) throws FournisseurIdNotFound;

    /* extra 2*/
    void insertIfNotExists(Fournisseur fournisseur);
    List<Fournisseur> findAllSorted(String orderBy, boolean ascending);
    int updateByKeywordAndAddSuffix(String keyword, String suffix);
    int insertAll(List<Fournisseur> fournisseurs);



}