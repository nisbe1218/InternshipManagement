package org.example.gestiondeprojet.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String sector;
    private String city;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonbTransient
    private List<Internship> internships = new ArrayList<>();

    public Company() {}

    public Company(String name, String sector, String city) {
        this.name = name;
        this.sector = sector;
        this.city = city;
    }

    // Getters & setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public List<Internship> getInternships() { return internships; }
    public void setInternships(List<Internship> internships) { this.internships = internships; }

    // Helper methods
    public void addInternship(Internship internship) {
        internships.add(internship);
        internship.setCompany(this);
    }

    public void removeInternship(Internship internship) {
        internships.remove(internship);
        internship.setCompany(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sector='" + sector + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
// Lowercase duplicate file kept as placeholder to avoid case-insensitive filesystem conflicts.
// The canonical entity implementation is in `Company.java` (PascalCase).




