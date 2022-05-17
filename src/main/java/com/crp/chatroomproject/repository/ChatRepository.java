package com.crp.chatroomproject.repository;

import com.crp.chatroomproject.models.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatRepository extends CrudRepository<Message, Long> {

List<Message> findBySenderAndReceiver(Long senderId, Long receiverId);
List<Message> findBySender(Long send);
List<Message> findByReceiver(String receiver);
}
