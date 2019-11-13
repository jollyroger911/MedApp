package by.sam.apklimovich.repository;

import by.sam.apklimovich.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
