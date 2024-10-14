package com.alanyu.sprintbootmall.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chatRooms")
public class ChatRoom {

	@Id
	@Getter
	@Setter
	private String id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private List<String> participants; // List of user IDs

	public ChatRoom() {
	}

	public ChatRoom(String name, List<String> participants) {
		this.name = name;
		this.participants = participants;
	}

}
