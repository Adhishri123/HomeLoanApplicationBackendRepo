package com.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.model.CustomerEnquiryDetails;
import com.loan.model.Email;
import com.loan.service.EmailService;
import com.loan.service.EnquiryService;

@CrossOrigin("*")
@RestController
public class EmailController
{
	@Autowired
	private Email email;
	
	@Autowired
	private EmailService emailservise;
	
	@Autowired
	private EnquiryService enquiryservise;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@PostMapping("/sendmail")
	public ResponseEntity<CustomerEnquiryDetails> sendMail(@RequestBody CustomerEnquiryDetails enq)
	{
		System.out.println("cibil status "+enq.getCibil().getCstatus());
		if(enq.getCibil().getCstatus().equals("Approved"))
		{
		email.setFromEmail(fromEmail);
        email.setToEmail(enq.getCustomerEmailId());
		email.setSubject("Regarding Home Loan For Documentation of Applicant name: "+ enq.getCustomerFirstName() +" "+ enq.getCustomerLastName());
		email.setText("your cibil is Approved and You are Eligible\n"
      		+ "For Further Process."
      		+ "\n We are happy to inform you that your Home Loan request has been approved and is cureently being processed.\n"
      		+ "Further, we inform you that we have sent an email containing attached documents.\n"
      		+ "Also we have sent you the terms and conditions of the loans sanctioned. \n"
      		+ "We would like to schedule your meeting with the finance officer of the company for any further information and clarifications that you might wish to know. \n\n"
      		+ "We are happy to be doing business with you. \n\n"
      		+ "List of Documents Required :- \n\n"
      		+ "1.Aadhar Card \n"
      		+ "2.Pan Card \n"
      		+ "3.Income Tax Return of Last Two Years \n"
      		+ "4.Salary Slips of Last Three Months \n"
      		+ "5.Passport Size Photograph \n"
      		+ "6.Bank Passbook Copy \n"
      		+ "\n \n Thanking You. \n"
      		+ "Mr.Rushikesh Kirtkar\n"
      		+ "Branch Manager \n"
      		+ "Home Finance Ltd. \n Karvenagar \n"
      		+ "Pune, Maharashtra \n India-411052\n"
      		+ "\n"
      		+"Fill This form for next Registration Process()\n"
      		+ "Thank You For Banking With Us \n\n"
      		+ "Home Finance Ltd.....!!!!");
		emailservise.sendMail(email);
      
		}
		else if(enq.getCibil().getCstatus().equals("Rejected"))
		{
			email.setFromEmail(fromEmail);
	        email.setToEmail(enq.getCustomerEmailId());
			email.setSubject("Regarding Car Loan For Documentation of Applicant name: "+ enq.getCustomerFirstName() +" "+ enq.getCustomerLastName());
			email.setText("your cibil is Rejected and You are Not Eligible\n"
	        		+ "For Further Process."
	        		+ "\n We are Not Happy to inform you that your Home Loan request has been Rejected and is currently being Not Processed.\n"
	        		+ "\n \n Thanking You. \n"
	        		+ "Mr.Rushikesh Kirtkar \n"
	        		+ "Branch Manager \n"
	        		+ "Home Finance Ltd. \n Karvenagar \n"
	        		+ "Pune, Maharashtra \n India-411052\n"
	        		+ "\n"
	        		+ "Thank You For Banking With Us \n\n"
	        		+ "H Finance Ltd.....!!!!");
			emailservise.sendMail(email);
	       		}
		 CustomerEnquiryDetails baseResponse = new CustomerEnquiryDetails();
	        return new ResponseEntity<CustomerEnquiryDetails>(baseResponse,HttpStatus.OK);

	}
}
