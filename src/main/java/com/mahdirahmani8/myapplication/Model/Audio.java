package com.mahdirahmani8.myapplication.Model;

public class Audio {
    public Audio() {
    }

    private int id;
    private String isone;
    private String name;
    private String disc;
    private int fav;
    private int part;
    private String lan;


    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsone() {
        return isone;
    }

    public void setIsone(String isone) {
        this.isone = isone;
    }

    public String getName() {
        return name;
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

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }
}
