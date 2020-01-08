package by.sam.apklimovich.model;

public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    private String dest;
    private Long senderId;
    private Long destId;



    private String FirstLetter;


    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
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

    public String getDest() {
        return dest;
    }


    public Long getDestId() {
        return destId;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public void setDestId(Long destId) {
        this.destId = destId;
    }
    public String getFirstLetter() {
        return FirstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        FirstLetter = firstLetter;
    }
}