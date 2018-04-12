package com.example.model;

public class Idea {
    private String title;
    private String description;
    private String name;

    public Idea(String title, String name, String description){
        this.title = title;
        this.name = name;
        this.description = description;
    }

    public String getTitle() {

        return title;
    }

    public String getDescription() {

        return description;
    }

    public String getName() {

        return name;
    }
}
