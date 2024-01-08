package com.example.mytravelmate;

public class mostvisited_Places {
    String mvName;
    int mvimg;

    public mostvisited_Places(String mvName, int mvimg) {
        this.mvName = mvName;
        this.mvimg = mvimg;
    }


    public String getMvName() {
        return mvName;
    }

    public void setMvName(String mvName) {
        this.mvName = mvName;
    }

    public int getImg() {
        return mvimg;
    }

    public void setImg(int img) {
        this.mvimg = img;
    }
}
