package com.loan.losa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
	private String toEmail;
	private String fromEmail;
	private String subject;
	private String text;
}
