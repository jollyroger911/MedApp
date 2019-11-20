package by.sam.apklimovich.model;

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
    private ArrayList<MessageDto> currentMessages;

    public ChatDto() {
        currentMessages = new ArrayList<>();
        this.chatId = 0;
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

    public void addToMessages(MessageDto messageDto) {
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

    public void setRecieverId(long senderId) {
        this.senderId = senderId;
    }
}