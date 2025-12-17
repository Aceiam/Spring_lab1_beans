package com.example.beans.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dean_id")
    private Dean dean;

    public Department() {}

    public Department(String name) {
        this.name = name;
    }

    // Геттери та сеттери
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Faculty getFaculty() { return faculty; }
    public void setFaculty(Faculty faculty) { this.faculty = faculty; }

    public Dean getDean() { return dean; }
    public void setDean(Dean dean) { this.dean = dean; }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty=" + (faculty != null ? faculty.getTitle() : "null") +
                ", dean=" + (dean != null ? dean.getFullName() : "null") +
                '}';
    }
}
