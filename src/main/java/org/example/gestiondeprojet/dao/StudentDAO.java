package org.example.gestiondeprojet.dao;

 
 
import org.example.gestiondeprojet.entity.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import java.util.List;

@ApplicationScoped
public class StudentDAO {
    @PersistenceContext
    private EntityManager em;

    public void create(Student s) { em.persist(s); }
    public Student find(Long id) { return em.find(Student.class, id); }
    public List<Student> findAll() { return em.createQuery("SELECT s FROM Student s", Student.class).getResultList(); }
    public void delete(Long id) { Student s = em.find(Student.class, id); if (s != null) em.remove(s); }
}
