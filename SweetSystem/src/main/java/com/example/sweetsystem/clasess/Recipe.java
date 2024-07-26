package com.example.sweetsystem.clasess;

import java.util.ArrayList;

public class Recipe {

    public static int id;
    private String Name;
    private String Image;
    private ArrayList<String> Needs=new ArrayList<String>();
    private ArrayList<Comment> Comments=new ArrayList<Comment>();

    private ArrayList<String> allergy=new ArrayList<String>(3);

    public Recipe(String name,String url,String Needs){
        this.Name=name;
        this.Image=url;
        id++;
        fillNeeds();
    }

    private void fillNeeds() {
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
    public Comment getComment(int x){
        return Comments.get(x);
    }
    public void addComment(Comment c){
        Comments.add(c);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
