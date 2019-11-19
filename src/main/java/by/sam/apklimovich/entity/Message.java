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

    @Column(name = "senderId")
    private long senderId;

    @Column(name = "recieverId")
    private long recieverId;

    @Column(name = "message")
    private String message;

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(long recieverId) {
        this.recieverId = recieverId;
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

    public Message(String message, long chatId, long senderId, long recieverId) {
        this.message = message;
        this.chatId = chatId;
        this.senderId = senderId;
        this.recieverId = recieverId;
    }

    public Message(String message) {
        this.message = message;
        Logger logger = LoggerFactory.getLogger(Message.class);
        logger.info(message);
    }
}
