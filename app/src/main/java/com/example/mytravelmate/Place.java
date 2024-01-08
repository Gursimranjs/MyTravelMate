package com.example.mytravelmate;

public class Place {


     String name;
     int img;

    public Place(String name, int image) {
        this.name = name;
        this.img = image;
    }

    public String getName() {
        return name;
    }


    public int getImageResourceId() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setImageResourceId(int imageResourceId) {
        this.img = imageResourceId;
    }
}
