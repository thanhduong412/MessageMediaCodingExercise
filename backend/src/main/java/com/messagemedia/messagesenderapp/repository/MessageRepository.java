package com.messagemedia.messagesenderapp.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.messagemedia.messagesenderapp.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, String> {

}
