package by.sam.apklimovich.repository;

import by.sam.apklimovich.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface MessageRepository extends JpaRepository<Message, Long> {
    ArrayList<Message> findByChatId(long chatId);
}
