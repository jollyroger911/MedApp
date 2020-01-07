package by.sam.apklimovich.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "CHAT")
public class Chat {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "first_user")
    private long firstUser;

    @Column(name = "second_user")
    private long secondUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(long firstUser) {
        this.firstUser = firstUser;
    }

    public long getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(long secondUser) {
        this.secondUser = secondUser;
    }

    public Chat(){}
    public Chat(long chatId){
        this.id = chatId;
    }
    public Chat(long firstUser, long secondUser){
        this.firstUser = firstUser;
        this.secondUser = secondUser;
    }
}
