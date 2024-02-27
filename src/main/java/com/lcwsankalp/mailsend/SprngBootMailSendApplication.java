package com.lcwsankalp.mailsend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.lcwsankalp.mailsend.service.HomeService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class SprngBootMailSendApplication {
	
	@Autowired
	HomeService homeService;

	public static void main(String[] args) {
		SpringApplication.run(SprngBootMailSendApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
//		homeService.sendSimpleMail("sankalpdevadiga9@gmail.com",
//				"This is test body of learn Code With Sankalp",
//				"This is test subject for Learn Code With Sankalp");
		
		homeService.sendMailWithAtchment("sankalpdevadiga9@gmail.com",
				"This is test body of learn Code With Sankalp",
				"This is test subject for Learn Code With Sankalp", "F:\\download.jfif");
	}

}
