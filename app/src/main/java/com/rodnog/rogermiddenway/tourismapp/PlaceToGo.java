package com.rodnog.rogermiddenway.tourismapp;

public class PlaceToGo {
    int id, image;
    private String title, description;

    public PlaceToGo(int id, int image, String title, String description) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        int maxLength = 40;
        if(description.length() < maxLength) return description;
        else return description.substring(0, 60) + "...";
    }
}
