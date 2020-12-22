package com.mahdirahmani8.myapplication.Model;

public class Novel {
    public Novel() {
    }

    private int id;
    private String name;
    private String disc;
    private String isone;
    private String image;
    private int fav;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getIsone() {
        return isone;
    }

    public void setIsone(String isone) {
        this.isone = isone;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }
}
