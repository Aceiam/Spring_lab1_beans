package com.example.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Dean {
    @Value("${dean.name}")
    private String name;
    @Value("${dean.email}")
    private String email;

    @PostConstruct
    public void init() {
        System.out.println("Dean init: " + name + " " + email);
    }
    @PreDestroy
    public void destroy() {
        System.out.println("Dean destroy: " + name);
    }

    @Override
    public String toString() {
        return "\nDean{name='" + name + "', email='" + email + "'}";
    }
}