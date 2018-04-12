package com.example.model;

public class Idea {
    private String title;
    private String description;
    private String name;

    public Idea(String title, String description, String name){
        this.title = title;
        this.description = description;
        this.name = name;
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
