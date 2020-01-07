package by.sam.apklimovich.model;

import by.sam.apklimovich.entity.Message;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.util.ArrayList;


public class ChatDto {
    private MessageType type;
    @Size(min = 1)
    private String content;
    private long senderId;
    private long receiverId;
    private long chatId;
    private String topic;
    public ArrayList<Message> currentMessages;

    public ArrayList<Message> getCurrentMessages() {
        return currentMessages;
    }

    public void setCurrentMessages(ArrayList<Message> currentMessages) {
        this.currentMessages = currentMessages;
    }

    public ChatDto() {
        currentMessages = new ArrayList<>();

    }

    public ChatDto(String topic) {
        this.topic = topic;
        currentMessages = new ArrayList<>();
    }


    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public void incrementChatId() {
        this.chatId++;
    }

    public long getChatId() {
        return chatId;
    }

    public void addToMessages(Message messageDto) {
        currentMessages.add(messageDto);
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getRecieverId() {
        return senderId;
    }

    public void setRecieverId(long receiverId) {
        this.receiverId = receiverId;
    }
}