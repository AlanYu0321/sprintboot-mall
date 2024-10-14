package com.alanyu.sprintbootmall.sevice.impl;

import com.alanyu.sprintbootmall.Repository.MessageRepository;
import com.alanyu.sprintbootmall.model.Message;
import com.alanyu.sprintbootmall.sevice.ChatRoomService;
import com.alanyu.sprintbootmall.sevice.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesssageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private ChatRoomService chatRoomService;

	// Send a message to a chatroom
	public Message sendMessage(String chatRoomId, String sender, String content) {
		// Verify if the chatroom exists before sending the message
		chatRoomService.getChatRoomById(chatRoomId);

		Message message = new Message(chatRoomId, sender, content);
		return messageRepository.save(message);
	}

	// Get all messages for a specific chatroom
	public List<Message> getMessagesByChatRoomId(String chatRoomId) {
		return messageRepository.findByChatRoomId(chatRoomId);
	}


}
