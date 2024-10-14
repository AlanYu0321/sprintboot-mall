package com.alanyu.sprintbootmall.sevice;

import com.alanyu.sprintbootmall.model.ChatRoom;
import java.util.List;

public interface ChatRoomService {

	// Create a new chatroom
	public ChatRoom createChatRoom(String name, List<String> participants) ;

	// Get all chatrooms
	public List<ChatRoom> getAllChatRooms() ;

	// Find a chatroom by its ID
	public ChatRoom getChatRoomById(String chatRoomId) ;
}
