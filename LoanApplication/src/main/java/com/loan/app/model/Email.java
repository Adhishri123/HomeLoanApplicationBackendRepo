package com.loan.app.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Email 
{
	private String toEmail;
	private String fromEmail;
	private String subject;
	private String text;
}
