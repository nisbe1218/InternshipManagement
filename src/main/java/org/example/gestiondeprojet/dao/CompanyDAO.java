package org.example.gestiondeprojet.dao;



import org.example.gestiondeprojet.entity.Company;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import java.util.List;

@ApplicationScoped
public class CompanyDAO {
    @PersistenceContext
    private EntityManager em;
    
    public void create(Company c) { em.persist(c); }
    public Company find(Long id) { return em.find(Company.class, id); }
    public List<Company> findAll() { return em.createQuery("SELECT c FROM Company c", Company.class).getResultList(); }
    public void delete(Long id) { Company c = em.find(Company.class, id); if (c != null) em.remove(c); }
}
