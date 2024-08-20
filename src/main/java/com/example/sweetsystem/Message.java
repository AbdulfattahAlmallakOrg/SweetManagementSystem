package com.example.sweetsystem;

import com.example.sweetsystem.clasess.OwnerAndSupplier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    int senderId;
    int receiverId;
    LocalDateTime time;
    String content;
    public Message(int senderId, int receiverId, String content) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.time = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Sender: " +
                OwnerAndSupplier.getOwnerSupplier(senderId).getUserName() +
                "\nReceiver: " +
                OwnerAndSupplier.getOwnerSupplier(receiverId).getUserName() +
                "\nTimestamp: " +
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(time) +
                "\nMessage: " +
                content +
                "\n";
    }
}
