package com.alanyu.sprintbootmall.controller;

import com.alanyu.sprintbootmall.model.ChatRoom;
import com.alanyu.sprintbootmall.sevice.ChatRoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/chatrooms")
public class ChatroomController {
	@Autowired
	private ChatRoomService chatRoomService;

	// Create a new chatroom
	@PostMapping
	public ChatRoom createChatRoom(@RequestBody ChatRoom chatRoom) {
		return chatRoomService.createChatRoom(chatRoom.getName(), chatRoom.getParticipants());
	}

	// Get all chatrooms
	@GetMapping
	public List<ChatRoom> getAllChatRooms() {
		return chatRoomService.getAllChatRooms();
	}

	// Get a specific chatroom by ID
	@GetMapping("/{chatRoomId}")
	public ChatRoom getChatRoomById(@PathVariable String chatRoomId) {
		return chatRoomService.getChatRoomById(chatRoomId);
	}
}
