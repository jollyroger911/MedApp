package by.sam.apklimovich.model;

import javax.validation.constraints.Size;
import java.util.ArrayList;

public class ChatDto {
    private MessageType type;
    @Size(min = 1)
    private String content;
    private String sender;
    private String topic;
    private ArrayList<MessageDto> currentMessages;
    public ChatDto(){
        currentMessages = new ArrayList<>();
    }
    public ChatDto(String topic){
        this.topic = topic;
        currentMessages = new ArrayList<>();
    }


    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public void addToMessages(MessageDto messageDto){
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}