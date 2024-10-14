package com.alanyu.sprintbootmall.Repository;

import com.alanyu.sprintbootmall.model.ChatRoom;
import com.alanyu.sprintbootmall.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {

}
