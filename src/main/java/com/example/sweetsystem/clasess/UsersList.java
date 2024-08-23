package com.example.sweetsystem.clasess;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsersList {


    public static void fillData(){
        User u=new Adminn("ahmed","osama@gmail.com","ah123","Admin","nablus");
        User u2=new Client("osama","osama@gmail.com","1234","Client","nablus");
        User u3=new OwnerAndSupplier("smsm","osama@gmail.com","1234","Owner","nablus");
        User u4=new OwnerAndSupplier("abd","abd@gmail.com","1234","Owner","attil");


        if(search(u2.getUserName())==-1){
            UsersList.users.add(u2);
        }
        if(search(u.getUserName())==-1){
            UsersList.users.add(u);
        }
        if(search(u3.getUserName())==-1){
            UsersList.users.add(u3);
        }
        if(search(u4.getUserName())==-1){
            UsersList.users.add(u4);
        }
    }


    public static boolean CanMakeUserName;
    public static ArrayList<User>users=new ArrayList<User>();
    public static User currentUser;

    public String getUserCurrentPage() {
        return userCurrentPage;
    }

    public void setUserCurrentPage(String userCurrentPage) {
        this.userCurrentPage = userCurrentPage;
    }

    public  String userCurrentPage;

    public static int search(String username){
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user != null && username.equals(user.getUserName())) {
                return i;
            }
        }
        return -1;
    }
    public static void printAll(){
        System.out.println("***********************************************************");
        for(User user:users){
            System.out.println(user.getUserName()+" "+user.getPassword()+" "+user.getEmail()+" "+user.getId());
        }
        System.out.println("***********************************************************");
    }
    public static boolean checkAllInput(String userNamefText, String passwordfText, String emailfTextText, String locationfText, String rolefText){
            return !emailfTextText.isEmpty()&&!userNamefText.isEmpty()&&!passwordfText.isEmpty()&&!locationfText.isEmpty()&&!rolefText.isEmpty();

    }
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean isValidRole(String text) {
        if(text.equals("Client")||text.equals("Owner")){
            return true;
        }
        return false;
    }
    public static boolean makeUser(String text, String emailfText, String passwordfText, String locationfText, String rolefText){
        if(UsersList.search(text)==-1) {
            System.out.println("text");
            User user=null;
            if(rolefText.equals("Admin")){
                user=new Adminn(text, emailfText, passwordfText,rolefText,locationfText);
            }
            else if(rolefText.equals("Client")){
                user = new Client(text, emailfText, passwordfText,rolefText,locationfText);
            }

            UsersList.users.add(user);
            return true;

        }
        else
            return false;

    }

    public static void setCanMakeUserName(boolean b) {
        CanMakeUserName=b;
    }
    public static boolean getCanMakeUserName() {
        return CanMakeUserName;
    }
    public static void login(){
        currentUser=UsersList.users.get(0);
    }
}
