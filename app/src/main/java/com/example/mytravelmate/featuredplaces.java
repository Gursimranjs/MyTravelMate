package com.example.mytravelmate;

public class featuredplaces {
    String featuredname;
    int featuredimage;

    public featuredplaces(String featuredname, int featuredimage) {
        this.featuredname = featuredname;
        this.featuredimage = featuredimage;
    }

    public String getFeaturedname() {
        return featuredname;
    }

    public void setFeaturedname(String featuredname) {
        this.featuredname = featuredname;
    }

    public int getFeaturedimage() {
        return featuredimage;
    }

    public void setFeaturedimage(int featuredimage) {
        this.featuredimage = featuredimage;
    }
}
