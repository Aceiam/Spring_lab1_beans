package com.example.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class University {
    private Faculty faculty;
    @Value("${university.title}")
    private String title;
    @Value("${university.address}")
    private String address;

    public University(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "\nUniversity {title: "+ title + ", address: " + address + "}\n { faculty=" + faculty + "}";
    }
}
