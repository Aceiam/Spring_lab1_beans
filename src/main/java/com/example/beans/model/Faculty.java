package com.example.beans.model;

import com.example.beans.repository.DeanRepository;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    // Один факультет має багато департаментів
    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Department> departments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private University university;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dean_id")
    private Dean dean;

    public Faculty() {}

    public Faculty(String title, Dean dean) {
        this.title = title;
        this.dean = dean;
    }

    // Геттери та сеттери
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Dean getDean() { return dean; }
    public void setDean(Dean dean) { this.dean = dean; }

    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }

    public University getUniversity() { return university; }
    public void setUniversity(University university) { this.university = university; }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", departments=" + (departments != null ? departments.size() : 0) +
                ", university=" + (university != null ? university.getTitle() : "null") +
                '}';
    }
}
