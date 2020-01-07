package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Chat;
import by.sam.apklimovich.entity.Message;
import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.repository.ChatRepository;
import by.sam.apklimovich.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChatService {
    @Autowired
    ChatRepository chatRepository;

    @Autowired
    MessageRepository messageRepository;


    MessageService messageService;

    public void createChat() {
        Logger logger = LoggerFactory.getLogger(ChatService.class);
        logger.info("Chat Service object created ");
        chatRepository.findAll();
        chatRepository.save(new Chat());
        chatRepository.flush();
    }

    public Long findChatByUsersId(long idOne, long idTwo){
       Chat chat = new Chat();
       chat = findByFIrstUserAndSecondUser(idOne, idTwo);
       if(chat == null){
           chat = findByFIrstUserAndSecondUser(idTwo, idOne);
       }
       return chat.getId();
    }

    public List<Chat> findAllChatsByFisrtUserId(long id) {
        return chatRepository.findByFirstUser(id);
    }

    public Chat findByFIrstUserAndSecondUser(long oneId, long twoId) {
        return chatRepository.findByFirstUserAndSecondUser(oneId, twoId);
    }

    public void createChat(ChatDto chat, PersonDto personDto) {
        Logger logger = LoggerFactory.getLogger(ChatService.class);
        logger.info("Chat Service object created ");
        if (findByFIrstUserAndSecondUser(personDto.getId(), personDto.getDestId()) == null) {
            chatRepository.findAll();
            chatRepository.save(new Chat(personDto.getId(), personDto.getDestId()));
            chatRepository.flush();
            chat.setChatId(findByFIrstUserAndSecondUser(personDto.getId(), personDto.getDestId()).getId());
        } else {
            chat.setChatId(findByFIrstUserAndSecondUser(personDto.getId(), personDto.getDestId()).getId());
            chat.setSenderId(personDto.getId());
            chat.setRecieverId(personDto.getDestId());
            chat.setCurrentMessages(messageRepository.findByChatId(chat.getChatId()));
        }
    }

    public void addMessageToChat(String message, long chatId, long senderId) {
        Logger logger = LoggerFactory.getLogger(ChatService.class);
        logger.info("Chat Service object created ");
        messageRepository.findAll();
        messageRepository.save(new Message(message, chatId, senderId));
        messageRepository.flush();
//        chat.setCurrentMessages( messageService.findMessagesByChatId(chat.getChatId()));
        //chat.addToMessages(message);
        logger.info(message);
    }

}
