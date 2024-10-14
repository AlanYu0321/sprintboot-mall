package com.alanyu.sprintbootmall.sevice.impl;

import com.alanyu.sprintbootmall.Repository.ChatRoomRepository;
import com.alanyu.sprintbootmall.model.ChatRoom;
import com.alanyu.sprintbootmall.sevice.ChatRoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

	@Autowired
	private ChatRoomRepository chatRoomRepository;

	// Create a new chatroom
	public ChatRoom createChatRoom(String name, List<String> participants) {
		ChatRoom chatRoom = new ChatRoom(name, participants);
		return chatRoomRepository.save(chatRoom);
	}

	// Get all chatrooms
	public List<ChatRoom> getAllChatRooms() {
		return chatRoomRepository.findAll();
	}

	// Find a chatroom by its ID
	public ChatRoom getChatRoomById(String chatRoomId) {
		return chatRoomRepository.findById(chatRoomId).orElseThrow(() ->
				new RuntimeException("ChatRoom not found with id: " + chatRoomId));
	}
}
