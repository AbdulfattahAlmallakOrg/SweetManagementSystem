package com.example.sweetsystem.clasess;

public class Comment {
    private String WriterName;
    private String Message;

public Comment(String person,String message){
    this.WriterName=person;
    this.Message=message;
}
    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getWriterName() {
        return WriterName;
    }

    public void setWriterName(String writerName) {
        WriterName = writerName;
    }
}
