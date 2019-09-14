package com.uee.riyasewana.model;

public class Part {
    private int imageDrawable;
    private int imageWideDrawable;
    private String name;
    private String price;
    private String location;
    private String description;
    private String email;
    private String telephone;

    public Part(int imageDrawable, int imageWideDrawable, String name, String price, String location, String description, String email, String telephone) {
        this.imageDrawable = imageDrawable;
        this.imageWideDrawable = imageWideDrawable;
        this.name = name;
        this.price = price;
        this.location = location;
        this.description = description;
        this.email = email;
        this.telephone = telephone;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(int imageDrawable) {
        this.imageDrawable = imageDrawable;
    }

    public int getImageWideDrawable() {
        return imageWideDrawable;
    }

    public void setImageWideDrawable(int imageWideDrawable) {
        this.imageWideDrawable = imageWideDrawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
