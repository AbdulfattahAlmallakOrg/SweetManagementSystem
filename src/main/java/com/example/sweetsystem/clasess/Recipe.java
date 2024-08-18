package com.example.sweetsystem.clasess;

import java.util.ArrayList;

public class Recipe {

    private int id;
    public static int count=0;
    private String Name;
    private String Image;
    private String Description;
    private ArrayList<Comment> Comments=new ArrayList<Comment>();

    private ArrayList<String> allergy=new ArrayList<String>(3);

    public Recipe(String name,String url,String description,String needs,String allergy){
        this.Name=name;
        this.Image=url;
        fillId();
        fillAllergy(allergy);
        this.Description=description+"\n The needs:"+needs;
    }

    private void fillId() {
        count ++;
        id=count;
    }

    private void fillAllergy(String a) {
        String []arr=a.split(",");
        if(1==arr.length){
            this.allergy.add(arr[0]);

        }
        else if(2==arr.length){
            this.allergy.add(arr[0]);
            this.allergy.add(arr[1]);

        }
        else if(3==arr.length) {
            this.allergy.add(arr[0]);
            this.allergy.add(arr[1]);
            this.allergy.add(arr[2]);
        }
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

    public ArrayList<String> getAllergy() {
        return allergy;
    }

    public void setAllergy(ArrayList<String> allergy) {
        this.allergy = allergy;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
    public boolean findAllerge(String a){
        for(int i=0;i<allergy.size();i++){
            if(allergy.get(i).equals(a)){
                return true;
            }
        }
        return false;
    }
}
