package com.example.beans.model;

import jakarta.persistence.*;

@Entity
@Table(name = "deans")
public class Dean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // Один декан відповідає за один факультет
    @OneToOne(mappedBy = "dean", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Faculty faculty;

    public Dean() {}

    public Dean(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    // Геттери та сеттери
    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Faculty getFaculty() { return faculty; }
    public void setFaculty(Faculty faculty) { this.faculty = faculty; }

    @Override
    public String toString() {
        return "Dean{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", faculty=" + (faculty != null ? faculty.getTitle() : "null") +
                '}';
    }
}
