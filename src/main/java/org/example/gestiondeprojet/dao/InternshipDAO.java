package org.example.gestiondeprojet.dao;



import org.example.gestiondeprojet.entity.Internship;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import java.util.List;

@ApplicationScoped
public class InternshipDAO {
    @PersistenceContext
    private EntityManager em;

    public void create(Internship i) { em.persist(i); }
    
    public Internship find(Long id) {
        return em.find(Internship.class, id);
    }
    
    public List<Internship> findAll() {
        return em.createQuery("SELECT i FROM Internship i", Internship.class).getResultList();
    }
    
    public void delete(Long id) { 
        Internship i = em.find(Internship.class, id); 
        if (i != null) em.remove(i); 
    }
}
