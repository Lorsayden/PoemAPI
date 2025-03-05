package app.dao.impl;

import app.dao.IDAO;
import app.entities.Author;

import java.util.List;

public class AuthorDAO implements IDAO<Author, Integer>
{
    @Override
    public Author create(Author type)
    {
        return null;
    }

    @Override
    public Author read(Integer integer)
    {
        return null;
    }

    @Override
    public List<Author> readAll()
    {
        return List.of();
    }

    @Override
    public Author update(Author type)
    {
        return null;
    }

    @Override
    public void delete(Integer integer)
    {

    }
}
