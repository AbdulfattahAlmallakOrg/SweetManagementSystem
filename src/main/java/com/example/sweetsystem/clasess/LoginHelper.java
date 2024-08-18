package com.example.sweetsystem.clasess;

public class LoginHelper {

    private boolean login;

    public String getMessage() {
        return message;
    }

    private String message;

    public boolean allFieldIsFill(String userName, String password) {
        return !userName.isEmpty() && !password.isEmpty();
    }

    public boolean theUserCanGo(String userName, String password) {
        if (allFieldIsFill(userName, password)) {
            int index = UsersList.search(userName);
            if (index != -1) {
                User user = UsersList.users.get(index);
                if (user.getPassword().equals(password)) {
                    UsersList.currentUser = user;
                    login = true;
                    message="success";
                    if (UsersList.currentUser.getType().equals("Client")) {
                        System.out.println("Client login sucsess !");
                    } else if (UsersList.currentUser.getType().equals("Admin")) {
                        System.out.println("Admin login sucsess !");

                    } else {
                        System.out.println("Owner login sucsess !");
                    }
                } else {
                    login = false;
                    System.out.println("the password is wrong !");
                    message="wrong password";
                }
            } else {
                login=false;
                System.out.println("the account is not in the system");
                message="account not register";
            }



        }
        return login;
    }
}