package com.example.gamestore.model;

public class OwnedGames {

    private String title;

    public OwnedGames() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;

    }
}
