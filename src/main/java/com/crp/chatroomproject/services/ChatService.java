package com.crp.chatroomproject.services;
import com.crp.chatroomproject.models.Message;
import com.crp.chatroomproject.models.MessageRequest;
import com.crp.chatroomproject.models.User;
import com.crp.chatroomproject.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ChatService {

    ChatRepository chatRepository;
    private UserService userService;
    @Autowired
    public ChatService(ChatRepository chatRepository, UserService userService) {
        this.chatRepository = chatRepository;
        this.userService = userService;
    }

    public ArrayList<Message> getMessages() {
        return (ArrayList<Message>) chatRepository.findAll();
    }

    public ArrayList<Message> getMessagesBySender() {
        return (ArrayList<Message>) chatRepository.findAll();
    }
    public ArrayList<Message> getMessagesByReceiver() {
        return (ArrayList<Message>) chatRepository.findAll();
    }
    public ArrayList<Message> getMessagesBySenderAndReceiver() {
        return (ArrayList<Message>) chatRepository.findAll();
    }
    public void createMessage(MessageRequest messageRequest) throws Exception{
        User user = userService.getUserById(messageRequest.getUserId());
        Message message = new Message(user,
                messageRequest.getReceiver(),
                messageRequest.getMessage());
        chatRepository.save(message);
    }
}
