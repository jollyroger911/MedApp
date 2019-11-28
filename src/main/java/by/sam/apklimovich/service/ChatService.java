package by.sam.apklimovich.service;

import antlr.debug.MessageAdapter;
import by.sam.apklimovich.entity.Chat;
import by.sam.apklimovich.entity.Message;
import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.repository.ChatRepository;
import by.sam.apklimovich.repository.MessageRepository;
import by.sam.apklimovich.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
//    public long findChatByReceiverAndSender(){
//
//    }

    public List<Chat> findAllChatsByFisrtUserId(long id){
        return chatRepository.findByFirstUser(id);
    }

    public Chat findByFIrstUserAndSecondUser(long oneId, long twoId){
        return chatRepository.findByFirstUserAndSecondUser(oneId, twoId);
    }

    public void createChat(ChatDto chat, PersonDto personDto) {
        Logger logger = LoggerFactory.getLogger(ChatService.class);
        logger.info("Chat Service object created ");
        if(findByFIrstUserAndSecondUser(chat.getSenderId(), chat.getRecieverId()) == null) {
            //  long size = chatRepository.findAll().size();
            chatRepository.findAll();
            chatRepository.save(new Chat(chat.getSenderId(), chat.getRecieverId()));
            chatRepository.flush();
        }
        else{
            chat.setChatId(findByFIrstUserAndSecondUser(chat.getSenderId(), chat.getRecieverId()).getId());
            chat.setCurrentMessages(messageRepository.findByChatId(chat.getChatId()));
        }
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
        messageRepository.save(new Message(message.getContent(), chat.getChatId(), message.getSender()));
        messageRepository.flush();
        //chat.addToMessages(message);
        logger.info(message.getContent());
    }
//    public ArrayList<Message> getAllMessagesFromChat (ChatDto chat){
//        return chatRepository.find(chat.getChatId());
//    }


}
