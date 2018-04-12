package com.example.model;

public class Idea {
    private String name;
    private String description;
    private String author;

    public Idea(String name, String description, String author){
        this.name = name;
        this.description = description;
        this.author = author;
    }

    public String getName() {

        return name;
    }

    public String getDescription() {

        return description;
    }

    public String getAuthor() {

        return author;
    }
}
