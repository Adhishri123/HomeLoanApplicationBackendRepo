package com.loan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.loan.model.CustomerEnquiryDetails;
import com.loan.service.EnquiryService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@CrossOrigin("*")
public class EnquiryController {
	
	@Autowired
	EnquiryService enquiryservice;
	
	@PostMapping("/Add_customer_Enquiry")
	public ResponseEntity<CustomerEnquiryDetails> addCustomerenquiry(@RequestBody CustomerEnquiryDetails ced)
	{
		 ced = enquiryservice.saveEnquiryDetails(ced);
		return new ResponseEntity<CustomerEnquiryDetails>(ced,HttpStatus.CREATED); 
	}
	
	@GetMapping("/getEnquiry")
	public ResponseEntity< List<CustomerEnquiryDetails>>  getAllEnquiryDetails()
	{
		
		List<CustomerEnquiryDetails> ced=enquiryservice.getEnquiryDetailsss();
				return new ResponseEntity<List<CustomerEnquiryDetails>>(ced,HttpStatus.ACCEPTED) ;
	}
	
	@GetMapping("/getEnquiryByName/{customerFirstName}")
	public ResponseEntity<CustomerEnquiryDetails> getEnquiryByName(@PathVariable String customerFirstName){
		CustomerEnquiryDetails response = enquiryservice.getEnquiryByName(customerFirstName);
		return new ResponseEntity<CustomerEnquiryDetails>(response,HttpStatus.FOUND);
	}
	@PutMapping("/updatecibilscore/{customerEnquiryId}")
	   public ResponseEntity<CustomerEnquiryDetails> cibilcheck(@PathVariable ("customerEnquiryId") int customerEnquiryId,@RequestBody CustomerEnquiryDetails customerEnquiryDetails)
	   {
		 int  min=550,max=950;
			int cibil=ThreadLocalRandom.current().nextInt(min,max+1);
			customerEnquiryDetails.getCibil().setCscore(cibil);
			if(cibil>=650 && cibil<=900)
			{
				customerEnquiryDetails.getCibil().setCstatus("Approved");
			}
			else
			{
				customerEnquiryDetails.getCibil().setCstatus("Rejected");
			}
	
			enquiryservice.saveCibil(customerEnquiryDetails);
		return new ResponseEntity<CustomerEnquiryDetails>(customerEnquiryDetails,HttpStatus.OK);
	   }
	@GetMapping("/getapprovedEnquries")
	   public List<CustomerEnquiryDetails> getApprovedEnquiry()
	   {
		   List<CustomerEnquiryDetails> ced = enquiryservice.getEnquiryDetailsss();
		   List<CustomerEnquiryDetails> approvedEnquiries = new ArrayList<>(); //dummy list

		   for(CustomerEnquiryDetails cusomerdetailes:ced) {
			   
			if(cusomerdetailes.getCibil().getCstatus().equalsIgnoreCase("Approved"))
	       {
		     approvedEnquiries.add(cusomerdetailes);

	       }
		   }
		   return approvedEnquiries;
			
	   }
	
	@GetMapping("/getrejectedEnquries")
	   public List<CustomerEnquiryDetails> getrejectEnquiry()
	   {
		   List<CustomerEnquiryDetails> ced = enquiryservice.getEnquiryDetailsss();
		   List<CustomerEnquiryDetails> approvedRejected = new ArrayList<>(); //dummy list

		   for(CustomerEnquiryDetails cusomerdetailes:ced) {
			   
			if(cusomerdetailes.getCibil().getCstatus().equalsIgnoreCase("Rejected"))
	       {
				approvedRejected.add(cusomerdetailes);

	       }
		   }
		   return approvedRejected;
			
	   }
}
