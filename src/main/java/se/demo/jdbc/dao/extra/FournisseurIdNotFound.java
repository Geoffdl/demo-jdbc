package se.demo.jdbc.dao.extra;

public class FournisseurIdNotFound extends RuntimeException
{
    public FournisseurIdNotFound(String message)
    {
        super(message);
    }
}