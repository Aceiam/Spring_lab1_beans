package com.example.beans;

public class Faculty {
    private Dean dean;

    public Faculty() {}

    public void setDean(Dean dean) {
        this.dean = dean;
    }

    @Override
    public String toString() {
        return "Faculty{dean=" + dean + "}";
    }
}