package model;

import java.util.Date;

public class Message {
    private Date date;

    private String sender;

    private String recipient;

    private String message;

    public Message() {
    }

    public Message(Date date, String sender, String recipient, String message) {
        this.date = date;
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
