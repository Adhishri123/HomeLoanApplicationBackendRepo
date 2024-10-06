package com.loan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.loan.model.Email;
import com.loan.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService
{
	@Autowired
	private JavaMailSender sender;


	@Override
	public void sendMail(Email email) {
		
		try
		{
			SimpleMailMessage message=new SimpleMailMessage();
			      message.setTo(email.getToEmail());
			      message.setFrom(email.getFromEmail());
			      message.setSubject(email.getSubject());
			      message.setText(email.getText());
			      
			      sender.send(message);
		} 
		catch (Exception e1) 
		{
			System.out.println("Email Failed to send");
			e1.printStackTrace();
		} 
		
	}
	
}
