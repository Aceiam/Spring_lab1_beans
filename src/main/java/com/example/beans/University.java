package com.example.beans;

public class University {
    private Faculty faculty;

    public University(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "University{faculty=" + faculty + "}";
    }
}
