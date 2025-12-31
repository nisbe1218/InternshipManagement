package org.example.gestiondeprojet.service;



import org.example.gestiondeprojet.dao.CompanyDAO;
import org.example.gestiondeprojet.entity.Company;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class CompanyService {

    @Inject
    CompanyDAO dao;

    public void add(Company c) {
        dao.create(c);
    }

    public List<Company> list() {
        return dao.findAll();
    }

    public Company get(Long id) {
        return dao.find(id);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}

