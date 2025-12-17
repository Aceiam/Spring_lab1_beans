package com.example.beans;

public class Dean {
    private String name;
    private String email;

    public Dean() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Dean{name='" + name + "', email='" + email + "'}";
    }
}