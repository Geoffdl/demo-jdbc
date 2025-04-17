package se.demo.jdbc.entites;

public class Fournisseur
{
    int id;
    String nom;

    public Fournisseur(int id, String nom)
    {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Fournisseur{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}