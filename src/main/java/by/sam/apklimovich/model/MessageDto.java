package by.sam.apklimovich.model;

public class MessageDto {
    private String content;
    private String sender;
    private String reciever;

    public MessageDto() {
    }

    public MessageDto(String content) {
        this.content = content;
    }

    public MessageDto(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }

    public MessageDto(String content, String sender, String reciever) {
        this.content = content;
        this.sender = sender;
        this.reciever = reciever;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

}
