package org.example.sweetmanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OwnerAndSupplier {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String email;
    private String accountDetails;
    private static HashMap<Integer, OwnerAndSupplier> map = new HashMap<>();
    private List<Message> sentMessages;
    private List<Message> readMessages;
    private List<Message> unreadMessages;

    public OwnerAndSupplier(String name, String email, String accountDetails) {
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.email = email;
        this.accountDetails = accountDetails;
        map.put(id, this);
        sentMessages = new ArrayList<>();
        readMessages = new ArrayList<>();
        unreadMessages = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountDetails() {
        return this.accountDetails;
    }

    public void setAccountDetails(String accountDetails) {
        this.accountDetails = accountDetails;
    }

    //still not implemented
    public int sendMessage(String content, int receiverId) {
        Message message = new Message(this.id, receiverId, content);
        OwnerAndSupplier receiver = getOwnerSupplier(receiverId);
        if(receiver == null) {
            return 1;
        }
        sentMessages.add(message);
        receiver.receiveMessage(message);
        return 0;
    }



    public void receiveMessage(Message message) {
        unreadMessages.add(message);
    }

    public void readUnreadMessages() {
        while(!unreadMessages.isEmpty()) {
            Message message = unreadMessages.get(unreadMessages.size() - 1);
            System.out.println(message);
            unreadMessages.remove(unreadMessages.size() - 1);
            readMessages.add(message);
        }
    }

    static OwnerAndSupplier getOwnerSupplier(int id) {
        return map.getOrDefault(id, null);
    }
}

