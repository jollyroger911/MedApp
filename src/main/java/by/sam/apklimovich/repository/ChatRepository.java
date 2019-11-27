package by.sam.apklimovich.repository;

import by.sam.apklimovich.entity.Chat;
import by.sam.apklimovich.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    //@Query("SELECT m FROM message m WHERE LOWER(m.chatId) = LOWER(:chatId)")
   // public ArrayList<Message> find(@Param("chatId") long chatId);
    public Chat findByLogins(String sender, String receiver);
}
