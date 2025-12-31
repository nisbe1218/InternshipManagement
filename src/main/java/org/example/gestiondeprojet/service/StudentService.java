package org.example.gestiondeprojet.service;


import org.example.gestiondeprojet.dao.StudentDAO;
import org.example.gestiondeprojet.entity.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class StudentService {
    @Inject
    StudentDAO dao;

    public void add(Student s) { dao.create(s); }
    public List<Student> list() { return dao.findAll(); }
    public Student get(Long id) { return dao.find(id); }
    public void delete(Long id) { dao.delete(id); }
}
