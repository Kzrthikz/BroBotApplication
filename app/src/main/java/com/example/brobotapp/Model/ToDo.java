package com.example.brobotapp.Model;

public class ToDo {
    private String id, title, description;

    public ToDo() {
    }

    public ToDo(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {return description; }


}

