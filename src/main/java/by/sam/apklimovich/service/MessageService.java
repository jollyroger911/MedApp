package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Message;
import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.ChatMessage;
import by.sam.apklimovich.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    PersonService personService;


    public void createMessage() {
        Logger logger = LoggerFactory.getLogger(MessageService.class);
        logger.info("Message Service object created ");
        messageRepository.findAll();
        messageRepository.save(new Message());
        messageRepository.flush();
    }

    public ArrayList<ChatMessage> findMessagesByChatId(ChatDto chat) {
        ArrayList<Message> messages = messageRepository.findByChatId(chat.getChatId());
        ArrayList<ChatMessage> messagesAL = new ArrayList<>();
        String user1 = personService.getPersonsNameById(chat.getSenderId());
        String user2 = personService.getPersonsNameById(chat.getRecieverId());
        for (Message message:messages
             ) {
            ChatMessage cm = new ChatMessage();
            cm.setContent(message.getMessage());
            cm.setSender(personService.getPersonsNameById(message.getSenderId()));

            messagesAL.add(cm);
        }
        if(messagesAL == null)
            messagesAL.add(new ChatMessage());
        return messagesAL;
    }
}
