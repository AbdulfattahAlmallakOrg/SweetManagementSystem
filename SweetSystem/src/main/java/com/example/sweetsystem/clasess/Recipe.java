package com.example.sweetsystem.clasess;

import java.util.ArrayList;

public class Recipe {

    private int id;
    private String Name;
    private String Image;
    private ArrayList<String> Needs=new ArrayList<String>();
    private ArrayList<Comment> Comments=new ArrayList<Comment>();

    public Recipe(String name,String url){
        this.Name=name;
        this.Image=url;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public ArrayList<String> getNeeds() {
        return Needs;
    }

    public void setNeeds(ArrayList<String> needs) {
        Needs = needs;
    }

    public ArrayList<Comment> getComments() {
        return Comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        Comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
