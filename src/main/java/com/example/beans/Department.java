package com.example.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Department {
    @Value("${department.name}")
    private String name;
    @Value("${department.code}")
    private String code;

    private final Dean dean;

    public Department(Dean dean) {
        this.dean = dean;
    }

    public String getName() {
        return this.name;
    }
    @PostConstruct
    public void init() {
        System.out.println("Department init: " + name + " " + code);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Department destroy: " + name);
    }

    @Override
    public String toString() {
        return "\nDepartment{name: '" + name + "'" + ", code: " + code + ", dean=" + dean + "}";
    }
}
