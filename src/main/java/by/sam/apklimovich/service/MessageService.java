package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Message;
import by.sam.apklimovich.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public void createMessage() {
        Logger logger = LoggerFactory.getLogger(MessageService.class);
        logger.info("Message Service object created ");
        messageRepository.findAll();
        messageRepository.save(new Message());
        messageRepository.flush();
    }

    public ArrayList<Message> findMessagesByChatId(long chatId){
        return messageRepository.findByChatId(chatId);
    }


}
