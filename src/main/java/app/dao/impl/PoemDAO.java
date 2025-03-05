package app.dao.impl;

import app.dao.IDAO;
import app.entities.Author;
import app.entities.Poem;
import jakarta.persistence.*;

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
        EntityManager em = emf.createEntityManager();

        if (poem.getAuthor() != null && poem.getAuthor().getId() == null) {
            em.persist(poem.getAuthor());  // Save the Author first
        } else if (poem.getAuthor() != null) {
            poem.setAuthor(em.find(Author.class, poem.getAuthor().getId())); // Attach an existing Author
        }

        try {
            em.getTransaction().begin();
            em.persist(poem);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return poem;
    }

    @Override
    public Poem read(Integer id)
    {
        EntityManager em = emf.createEntityManager();
        Poem poem = null;
        try {
            Query query = em.createQuery("SELECT p FROM Poem p WHERE p.id = :id");
            query.setParameter("id", id);
            return (Poem) query.getSingleResult();
        } catch (NoResultException e){
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Poem> readAll()
    {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Poem> query = em.createQuery("SELECT p FROM Poem p", Poem.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Poem update(Poem poem) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query query = em.createQuery("UPDATE Poem p SET p.title = :title, p.style = :style, p.author = :author, p.poem = :poem WHERE p.id = :id");
            query.setParameter("title", poem.getTitle());
            query.setParameter("style", poem.getStyle());
            query.setParameter("author", poem.getAuthor());
            query.setParameter("poem", poem.getPoem());
            query.setParameter("id", poem.getId());

            query.executeUpdate();

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return poem;
    }


    @Override
    public void delete(Integer id)
    {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query query = em.createQuery("DELETE FROM Poem p WHERE p.id = :id");
            query.setParameter("id", id);

            query.executeUpdate();

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
