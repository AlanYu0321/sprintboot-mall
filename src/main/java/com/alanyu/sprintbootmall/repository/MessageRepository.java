package com.alanyu.sprintbootmall.repository;

import com.alanyu.sprintbootmall.model.Message;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
	List<Message> findByChatRoomId(String chatRoomId); // Find messages by chatroom ID
}