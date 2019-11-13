package by.sam.apklimovich.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGE")
public class Message {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "chat")
    private long chatId;

    @Column(name = "sender")
    private int whoSend;

    @Column(name = "message")
    private String message;

    public int getWhoSend() {
        return whoSend;
    }

    public void setWhoSend(int who) {
        whoSend = who;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Message() {
    }

    public Message(String message, long chatId, int whoSend) {
        this.message = message;
        this.chatId = chatId;
        this.whoSend = whoSend;
    }
}
