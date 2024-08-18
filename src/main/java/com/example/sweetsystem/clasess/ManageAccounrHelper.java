package com.example.sweetsystem.clasess;

public class ManageAccounrHelper {




    public static boolean checkAllEmpty(String text, String editPasswordText, String editEmailText){
        return text.isEmpty()&&editPasswordText.isEmpty()&&editEmailText.isEmpty();
    }
    public static boolean changeUserName(String text){
        return !text.equals(UsersList.currentUser.getUserName())&&UsersList.search(text)==-1;
    }

    public static boolean changeEmail(String text) {
        return !text.equals(UsersList.currentUser.getEmail());
    }

    public static boolean changePassword(String text) {
        return !text.equals(UsersList.currentUser.getPassword());
    }
    public static boolean ChangeAllCheck(String user, String pass, String Email){
        return changePassword(pass)&&changeEmail(Email)&&changeUserName(user);
    }
    public static boolean isTheSamePassword(String pass){
        return UsersList.currentUser.getPassword().equals(pass);
    }

    public static boolean isTheSameUserName(String Name){
        return UsersList.currentUser.getUserName().equals(Name);
    }

    public static boolean isTheSameEmail(String email){
        return UsersList.currentUser.getEmail().equals(email);
    }

}
