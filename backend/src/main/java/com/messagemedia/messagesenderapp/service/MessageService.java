package com.messagemedia.messagesenderapp.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messagemedia.messagesenderapp.model.Message;
import com.messagemedia.messagesenderapp.repository.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepo;

	public Iterable<Message> getAllMessages() {
		return messageRepo.findAll();
	}

	public Message addMessage(Message newMessage) {
		newMessage.setStatus("Success");
		return messageRepo.save(newMessage);
	}
}
