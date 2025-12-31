package org.example.gestiondeprojet.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String firstName;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String lastName;

    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(length = 50)
    private String promotion;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonbTransient
    private List<Internship> internships = new ArrayList<>();

    public Student() {}

    public Student(String firstName, String lastName, String email, String promotion) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.promotion = promotion;
    }

    // Getters & setters
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPromotion() { return promotion; }
    public void setPromotion(String promotion) { this.promotion = promotion; }
    public List<Internship> getInternships() { return internships; }
    public void setInternships(List<Internship> internships) { this.internships = internships; }

    // Helper methods to manage bidirectional relationship
    public void addInternship(Internship internship) {
        internships.add(internship);
        internship.setStudent(this);
    }

    public void removeInternship(Internship internship) {
        internships.remove(internship);
        internship.setStudent(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", promotion='" + promotion + '\'' +
                '}';
    }
}
// Lowercase duplicate file kept as placeholder to avoid case-insensitive filesystem conflicts.
// The canonical entity implementation is in `Student.java` (PascalCase).




