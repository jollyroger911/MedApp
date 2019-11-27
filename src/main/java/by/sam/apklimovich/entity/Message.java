package by.sam.apklimovich.entity;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGE")
public class Message {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "chatId")
    private long chatId;

    @Column(name = "senderLogin")
    private String senderLogin;

    @Column(name = "receiverId")
    private long receiverId;

    @Column(name = "message")
    private String message;

    public String getSenderLogin() {
        return senderLogin;
    }

    public void setSenderLogin(String senderLogin) {
        this.senderLogin = senderLogin;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
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

    public Message(String message, long chatId, String senderLogin) {
        this.message = message;
        this.chatId = chatId;
        this.senderLogin = senderLogin;
    }

    public Message(String message) {
        this.message = message;
        Logger logger = LoggerFactory.getLogger(Message.class);
        logger.info(message);
    }
}
