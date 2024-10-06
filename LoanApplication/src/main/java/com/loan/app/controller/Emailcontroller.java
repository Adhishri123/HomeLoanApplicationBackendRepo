package com.loan.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.app.model.CustomerDetails;
import com.loan.app.model.Email;
import com.loan.app.service.EmailServise;

@CrossOrigin("*")
@RestController
public class Emailcontroller 

{
	@Autowired
	private Email email;
	
	@Autowired
	private EmailServise emailservise;

	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@PostMapping("/senddocmail")
	public ResponseEntity<CustomerDetails> sendDocMail(@RequestBody CustomerDetails enq)
	{
		System.out.println("Documen Verification"+enq.getCustomerdocstatus());
		if(enq.getCustomerdocstatus().equals("Approved"))
		{
		email.setFromEmail(fromEmail);
        email.setToEmail(enq.getCustomerEmail());
		email.setSubject("Regarding Home Loan For Documentation of Applicant name: "+ enq.getCustomerFirstName() +" "+ enq.getCustomerLastName());
		email.setText("your Documents is Approved and You are Eligible\n"
      		+ "For Further Process."
      		+ "Also we have sent you the terms and conditions of the loans sanctioned. \n"
      		+ "We would like to schedule your meeting with the finance officer of the company for any further information and clarifications that you might wish to know. \n\n"
      		+ "We are happy to be doing business with you. \n\n"
      		+ "\n \n Thanking You. \n"
      		+ ""
      		+ "Prachi Waykar\n"
      		+ "Branch Manager \n"
      		+ "SecureShelter Loans. \n Karvenagar \n"
      		+ "Pune, Maharashtra \n India-411052\n"
      		+ "\n"
      		+"Fill This form for next Registration Process()\n"
      		+ "Thank You For Banking With Us \n\n"
      		+ "SecureShelter Loans.....!!!!");
		emailservise.sendMail(email);
      
		}
		else if(enq.getCustomerdocstatus().equals("Rejected"))
		{
			email.setFromEmail(fromEmail);
	        email.setToEmail(enq.getCustomerEmail());
			email.setSubject("Regarding Car Loan For Documentation of Applicant name: "+ enq.getCustomerFirstName() +" "+ enq.getCustomerLastName());
			email.setText("your Documents is Rejected and You are Not Eligible\n"
	        		+ "For Further Process."
	        		+ "\n We are Not Happy to inform you that your Home Loan request has been Rejected and is currently being Not Processed.\n"
	        		+ "\n \n Thanking You. \n"
	        		+ "Prachi Waykar \n"
	        		+ "Branch Manager \n"
	        		+ "Home Finance Ltd. \n Karvenagar \n"
	        		+ "Pune, Maharashtra \n India-411052\n"
	        		+ "\n"
	        		+ "Thank You For Banking With Us \n\n"
	        		+ "SecureShelter Loans.....!!!!");
	        emailservise.sendMail(email);
	       		}
		    CustomerDetails baseResponse = new CustomerDetails();
	        return new ResponseEntity<CustomerDetails>(baseResponse,HttpStatus.OK);

	}
}
