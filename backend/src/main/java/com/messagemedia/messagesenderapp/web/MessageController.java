package com.messagemedia.messagesenderapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.messagemedia.messagesenderapp.service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.messagemedia.messagesenderapp.model.Message;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {
	@Autowired
	private MessageService messageService;

	@GetMapping("/history")
	@ResponseBody
	public Iterable<Message> getAllMessages() {
		return messageService.getAllMessages();
	}

	@PostMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestBody String messageDetails)
			throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		Message newMessage = objectMapper.readValue(messageDetails, Message.class);
		Message messageAdd = messageService.addMessage(newMessage);
		if (messageAdd != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Message Status: " + messageAdd.getStatus());
		} else {
			return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		}
	}
}
