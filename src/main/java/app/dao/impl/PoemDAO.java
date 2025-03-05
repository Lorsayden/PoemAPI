package app.dao.impl;

import app.dao.IDAO;
import app.entities.Author;
import app.entities.Poem;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class PoemDAO implements IDAO<Poem,Integer>
{
    private static EntityManagerFactory emf;
    private static PoemDAO instance;

    public PoemDAO()
    {
    }

    public static PoemDAO getInstance(EntityManagerFactory _emf)
    {
        if (emf == null)
        {
            emf = _emf;
            instance = new PoemDAO();
        }
        return instance;
    }



    @Override
    public Poem create(Poem poem)
    {
        return null;
    }

    @Override
    public Poem read(Integer i)
    {
        return null;
    }

    @Override
    public List<Poem> readAll()
    {
        return List.of();
    }

    @Override
    public Poem update(Poem type)
    {
        return null;
    }

    @Override
    public void delete(Integer i)
    {

    }
}
