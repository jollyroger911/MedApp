package by.sam.apklimovich.service;

import antlr.debug.MessageAdapter;
import by.sam.apklimovich.entity.Chat;
import by.sam.apklimovich.entity.Message;
import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.repository.ChatRepository;
import by.sam.apklimovich.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class ChatService {
    @Autowired
    ChatRepository chatRepository;

    @Autowired
    MessageRepository messageRepository;

    public void createChat() {
        Logger logger = LoggerFactory.getLogger(ChatService.class);
        logger.info("Chat Service object created ");
        chatRepository.findAll();
        chatRepository.save(new Chat());
        chatRepository.flush();
    }

//    public void startChat(ChatDto chat){
//        ArrayList<Chat> arm = getAllMessagesFromChat(chat);
//        if(arm == null && arm.contains()){
//            createChat();
//        }
//        else{
//
//        }
//    }
//    public Chat resumeChat(ChatDto chat){
//
//    }

    public void createChat(ChatDto chat) {
        Logger logger = LoggerFactory.getLogger(ChatService.class);
        logger.info("Chat Service object created ");
        Chat newChat = new Chat();
        chat.setChatId(newChat.getId());
      //  long size = chatRepository.findAll().size();
        chatRepository.findAll();
        chatRepository.save(newChat);
        chatRepository.flush();
        //chat.incrementChatId();
    }

    public long getChatId(Chat c){
        //long all = chatRepository.findAll().size();
        return c.getId();
    }

    public void addMessageToChat(MessageDto message, ChatDto chat){
        Logger logger = LoggerFactory.getLogger(ChatService.class);
        logger.info("Chat Service object created ");
        messageRepository.findAll();
        messageRepository.save(new Message(message.getContent(), chat.getChatId(), message.getSenderLogin()));
        messageRepository.flush();
        chat.addToMessages(message);
        logger.info(message.getContent());
    }
//    public ArrayList<Message> getAllMessagesFromChat (ChatDto chat){
//        return chatRepository.find(chat.getChatId());
//    }


}
