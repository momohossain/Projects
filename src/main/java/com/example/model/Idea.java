package com.example.model;

public class Idea {
    private String name;
    private String description;

    public Idea(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
