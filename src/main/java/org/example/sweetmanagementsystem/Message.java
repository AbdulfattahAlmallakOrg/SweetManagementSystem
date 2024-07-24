package org.example.sweetmanagementsystem;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sender: ");
        sb.append(OwnerAndSupplier.getOwnerSupplier(senderId).getName());
        sb.append("\nReceiver: ");
        sb.append(OwnerAndSupplier.getOwnerSupplier(receiverId).getName());
        sb.append("\nTimestamp: ");
        sb.append(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(time));
        sb.append("\nMessage: ");
        sb.append(content);
        sb.append("\n");
        return sb.toString();
    }
}
