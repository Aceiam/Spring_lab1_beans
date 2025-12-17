package com.example.beans.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "universities")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    // Один університет має багато факультетів
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Faculty> faculties;

    public University() {}

    public University(String title) {
        this.title = title;
    }

    // Геттери та сеттери
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public List<Faculty> getFaculties() { return faculties; }
    public void setFaculties(List<Faculty> faculties) { this.faculties = faculties; }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", faculties=" + (faculties != null ? faculties.size() : 0) +
                '}';
    }
}
