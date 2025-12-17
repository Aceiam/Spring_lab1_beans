package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Faculty {
    private final Department department;
    private final Dean dean;

    @Autowired
    public Faculty(Department department, Dean dean) {
        this.department = department;
        this.dean = dean;
    }

    @Override
    public String toString() {
        return "\nFaculty{" + dean + ", " + department + "}";
    }
}