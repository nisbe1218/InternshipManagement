package org.example.gestiondeprojet.service;


import org.example.gestiondeprojet.dao.InternshipDAO;
import org.example.gestiondeprojet.dao.StudentDAO;
import org.example.gestiondeprojet.dao.CompanyDAO;
import org.example.gestiondeprojet.entity.Internship;
import org.example.gestiondeprojet.entity.Student;
import org.example.gestiondeprojet.entity.Company;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
@Transactional
public class InternshipService {

    @Inject
    InternshipDAO dao;
    
    @Inject
    StudentDAO studentDAO;
    
    @Inject
    CompanyDAO companyDAO;

    public Internship add(org.example.gestiondeprojet.rest.InternshipDTO dto) {
        System.out.println("=== InternshipService.add() ===");
        
        Internship internship = new Internship();
        internship.setTitle(dto.getTitle());
        internship.setDescription(dto.getDescription());
        
        // Conversion des dates String -> LocalDate
        if (dto.getStartDate() != null && !dto.getStartDate().isEmpty()) {
            internship.setStartDate(LocalDate.parse(dto.getStartDate()));
        }
        if (dto.getEndDate() != null && !dto.getEndDate().isEmpty()) {
            internship.setEndDate(LocalDate.parse(dto.getEndDate()));
        }
        
        // Résoudre les entités Student et Company depuis la BDD par leurs IDs
        if (dto.getStudentId() != null) {
            System.out.println("Recherche Student ID: " + dto.getStudentId());
            Student student = studentDAO.find(dto.getStudentId());
            if (student != null) {
                System.out.println("Student trouvé: " + student.getFirstName() + " " + student.getLastName());
                internship.setStudent(student);
            } else {
                System.err.println("ERREUR: Student avec ID " + dto.getStudentId() + " introuvable!");
            }
        }
        
        if (dto.getCompanyId() != null) {
            System.out.println("Recherche Company ID: " + dto.getCompanyId());
            Company company = companyDAO.find(dto.getCompanyId());
            if (company != null) {
                System.out.println("Company trouvée: " + company.getName());
                internship.setCompany(company);
            } else {
                System.err.println("ERREUR: Company avec ID " + dto.getCompanyId() + " introuvable!");
            }
        }
        
        System.out.println("Appel dao.create()...");
        dao.create(internship);
        System.out.println("dao.create() terminé - ID: " + internship.getId());
        
        return internship;
    }

    public List<Internship> list() {
        return dao.findAll();
    }

    public Internship get(Long id) {
        return dao.find(id);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}

