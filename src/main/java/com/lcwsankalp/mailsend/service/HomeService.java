package com.lcwsankalp.mailsend.service;

import java.io.File;
import java.nio.file.FileSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class HomeService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public void sendSimpleMail(String toMail,
			                   String body,
			                   String subject) {
		SimpleMailMessage message=new SimpleMailMessage();
		
        message.setFrom("devadigasankalp8@gmail.com");
        message.setTo(toMail);
        message.setText(body);
        message.setSubject(subject);
        
        javaMailSender.send(message);
        
        System.out.println("Simple message is sent to mail id : "+ toMail);
		
	}
	
	public void sendMailWithAtchment(String toMail,
            String body,
            String subject,
            String Attachment) throws MessagingException {
		
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
		
		mimeMessageHelper.setFrom("devadigasankalp8@gmail.com");
		mimeMessageHelper.setTo(toMail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystem=new FileSystemResource(new File(Attachment));
		
		mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);
		
		javaMailSender.send(mimeMessage);
		System.out.println("Mail sent aith attachment to mail addresss: "+toMail);
		
		
	}
	}

