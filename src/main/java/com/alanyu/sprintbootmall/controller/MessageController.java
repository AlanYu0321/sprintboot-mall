package com.alanyu.sprintbootmall.controller;

import com.alanyu.sprintbootmall.model.Message;
import com.alanyu.sprintbootmall.sevice.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

	@Autowired
	private MessageService messageService;

	// Send a message to a specific chatroom
	@PostMapping("/{chatRoomId}")
	public Message sendMessage(@PathVariable String chatRoomId, @RequestBody Message message) {
		return messageService.sendMessage(chatRoomId, message.getSender(), message.getContent());
	}

	// Get all messages for a specific chatroom
	@GetMapping("/chatroom/{chatRoomId}")
	public List<Message> getMessages(@PathVariable String chatRoomId) {
		return messageService.getMessagesByChatRoomId(chatRoomId);
	}
}
