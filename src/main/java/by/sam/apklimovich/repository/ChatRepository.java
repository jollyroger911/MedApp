package by.sam.apklimovich.repository;

import by.sam.apklimovich.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {

}
