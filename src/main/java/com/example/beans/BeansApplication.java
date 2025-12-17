package com.example.beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeansApplication {

    public static void main(String[] args) {
        // Стартуємо Spring Boot
        ApplicationContext context = SpringApplication.run(BeansApplication.class, args);

        // Отримуємо бін з контексту
        University university = context.getBean(University.class);
        System.out.println(university);

        // Можна отримувати і інші біни
        Department department = context.getBean(Department.class);
        System.out.println(department);
    }
}