package com.learncodewithsankalp.chatapplication.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.broker.SimpleBrokerMessageHandler;
import org.springframework.stereotype.Controller;

import com.learncodewithsankalp.chatapplication.model.ChatMessage;

@Controller
public class WSController {
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage,SimpMessageHeaderAccessor headerAccesser) {
		headerAccesser.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
		
	}
}
