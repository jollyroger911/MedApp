package by.sam.apklimovich.repository;

import by.sam.apklimovich.entity.Chat;
import by.sam.apklimovich.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findByFirstUser(long participantId);

    Chat findByFirstUserAndSecondUser(long oneId, long twoId);
}
