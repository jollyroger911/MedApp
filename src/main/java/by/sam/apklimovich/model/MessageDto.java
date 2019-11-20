package by.sam.apklimovich.model;

public class MessageDto {
    private String content;
    private long sender;
    private long receiver;

    public MessageDto() {
    }

    public MessageDto(String content) {
        this.content = content;
    }

    public MessageDto(String content, long sender) {
        this.content = content;
        this.sender = sender;
    }

    public MessageDto(String content, long sender, long receiver) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSender(long sender) {
        this.sender = sender;
    }

    public long getSender() {
        return sender;
    }

    public long getReceiver() {
        return receiver;
    }

    public void setReceiver(long receiver) {
        this.receiver = receiver;
    }

}
