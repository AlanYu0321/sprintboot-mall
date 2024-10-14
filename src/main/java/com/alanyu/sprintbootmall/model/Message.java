package com.alanyu.sprintbootmall.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "messages")
public class Message {

	@Id
	@Getter
	@Setter
	private String id;
	@Getter
	@Setter
	private String chatRoomId;  // The chatroom where the message belongs
	@Getter
	@Setter
	private String sender;      // Sender's username or user ID
	@Getter
	@Setter
	private String content;
	@Getter
	@Setter
	private LocalDateTime timestamp;


	public Message() {
	}

	public Message(String chatRoomId, String sender, String content) {
		this.chatRoomId = chatRoomId;
		this.sender = sender;
		this.content = content;
		this.timestamp = LocalDateTime.now();
	}

}
