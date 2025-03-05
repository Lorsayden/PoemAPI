package app.dao.impl;

import app.dao.IDAO;
import app.entities.Author;
import jakarta.persistence.*;

import java.util.List;

public class AuthorDAO implements IDAO<Author, Integer>
{

    private static EntityManagerFactory emf;
    private static AuthorDAO instance;

    public static AuthorDAO getInstance(EntityManagerFactory _emf)
    {
        if (emf == null)
        {
            emf = _emf;
            instance = new AuthorDAO();
        }
        return instance;
    }

    @Override
    public Author create(Author author)
    {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return author;
    }

    @Override
    public Author read(Integer id)
    {
        EntityManager em = emf.createEntityManager();
        Author author = null;
        try {
            Query query = em.createQuery("SELECT p FROM Author p WHERE p.id = :id");
            query.setParameter("id", id);
            return (Author) query.getSingleResult();
        } catch (NoResultException e){
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Author> readAll()
    {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Author> query = em.createQuery("SELECT p FROM Author p", Author.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Author update(Author author)
    {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query query = em.createQuery("UPDATE Author a SET a.name = :name WHERE a.id = :id");
            query.setParameter("name", author.getName());
            query.setParameter("id", author.getId());

            query.executeUpdate();

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return author;
    }

    @Override
    public void delete(Integer id)
    {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query query = em.createQuery("DELETE FROM Author p WHERE p.id = :id");
            query.setParameter("id", id);

            query.executeUpdate();

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
