package com.alanyu.sprintbootmall.sevice;

import com.alanyu.sprintbootmall.model.Message;
import java.util.List;

public interface MessageService {

	// Send a message to a chatroom
	public Message sendMessage(String chatRoomId, String sender, String content);

	// Get all messages for a specific chatroom
	public List<Message> getMessagesByChatRoomId(String chatRoomId);

}
