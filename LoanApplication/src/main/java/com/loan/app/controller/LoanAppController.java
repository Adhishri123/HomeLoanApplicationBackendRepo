package com.loan.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
//import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.loan.app.exception.CustomerNotFound;

//import com.loan.app.exception_rest.CustomerExceptionHandler;
import com.loan.app.model.CustomerDetails;
import com.loan.app.service.LoanAppService;
@CrossOrigin("*")
@RestController
public class LoanAppController
{
    @Autowired
    private LoanAppService loanappservice;
    
	@PostMapping("/Add_Customer_Details")
	   public ResponseEntity<String> addCustomerData(@RequestPart ("customer") String customerDetails,
			                                         @RequestPart ("pan") MultipartFile pancard,
			                                         @RequestPart ("income") MultipartFile incomeCertificate,
			                                         @RequestPart ("adhar") MultipartFile adharcard,
			                                         @RequestPart ("Profilephoto") MultipartFile pphoto,
			                                         @RequestPart ("sign") MultipartFile ssign,
			                                         @RequestPart ("passbook") MultipartFile bankpassbook)
	   {
		   CustomerDetails ccd = loanappservice.saveCustomer(customerDetails,pancard,incomeCertificate,adharcard,pphoto,ssign,bankpassbook);
		   return new ResponseEntity<String>("Customer Details Added Successfully",HttpStatus.CREATED);
	   }
	
	 @GetMapping("/get_Customer")
	   public ResponseEntity<List<CustomerDetails>> getCusomer()
	   {
		   List<CustomerDetails> emp = loanappservice.getCustomerData();
		   return new ResponseEntity<List<CustomerDetails>>(emp,HttpStatus.OK);
	   }
	 
	 @PutMapping("/edit_customer/{customerApplicationId}")//simple edit customer
	 public ResponseEntity<CustomerDetails> editCustomerData(@PathVariable("customerApplicationId") int cid, @RequestBody CustomerDetails cd)
	 {
			CustomerDetails cmpd = loanappservice.updateCustomerById(cd);
			
			return new ResponseEntity<CustomerDetails>(cmpd,HttpStatus.OK);
	 }
	 
	 @GetMapping("/getsingleCutomer/{customerApplicationId}") //get single customer by id
	 public ResponseEntity<CustomerDetails> getSingleCustomer(@PathVariable("customerApplicationId") int cid) 
	 {
//		CustomerDetails ccd = loanappservice.getByIdCustomer(cid);
////		 CustomerDetails customerDetails=ccd.get();
//		if(ccd!=null)
//		{
//		 return new ResponseEntity<CustomerDetails>(ccd, HttpStatus.OK);
//		}
//		else {
//			throw new CustomerNotFound("Customer Not Found");
//		}

		 CustomerDetails ccd = loanappservice.getByIdCustomer(cid);
		 if(ccd!=null)
		 {
			 return new ResponseEntity<CustomerDetails>(ccd, HttpStatus.OK);
		 }
		 else
		 {
			 throw new CustomerNotFound("Customer Not Found");
		 }

	 }
	 
	 @DeleteMapping("/delete_customer/{customerApplicationId}")//delete Customer
	 public ResponseEntity<String> deleteCustomer(@PathVariable("customerApplicationId") int csid)
	 {
		 loanappservice.deleteCustomerById(csid);
		 return new ResponseEntity<String>("Delete customer data successfully",HttpStatus.OK);
	 }

	 @PutMapping("/updateCustomer/{customerApplicationId}")	//update customer by loan status for document verification
		public ResponseEntity<CustomerDetails> updateCustomer(@RequestBody String customerDocDetails,
				                                              @PathVariable("customerApplicationId") Integer cid) throws IOException
		{
		    
			CustomerDetails customerdetails = loanappservice.getByIdCustomer(cid);

//			CustomerDetails customerDetails2 = customerdetails.get();

			System.out.println(customerDocDetails.contains("Approved"));
			if (customerDocDetails.contains("Approved"))
			{
				customerdetails.setCustomerdocstatus("Approved");
				loanappservice.updateCustomer(customerdetails);
			}
			
			else if (customerDocDetails.contains("Rejected"))
			{
				customerdetails.setCustomerdocstatus("Rejected");
				loanappservice.updateCustomer(customerdetails);
			}
			
			else
			{
				return null;
			}
			return new ResponseEntity<CustomerDetails>(customerdetails, HttpStatus.OK);	
		
		}
	 
	 @PutMapping("/updateCustomerLoanst/{customerApplicationId}")	//update customer by loan status for document verification
		public ResponseEntity<CustomerDetails> updateCustomerLoanStatus(@RequestBody String customerLoanDetails,
				                                              @PathVariable("customerApplicationId") Integer cid) throws IOException
		{
		    
			CustomerDetails customerdetails = loanappservice.getByIdCustomer(cid);

//			CustomerDetails customerDetails2 = customerdetails.get();

			System.out.println(customerLoanDetails.contains("Approved"));
			if (customerLoanDetails.contains("Approved"))
			{
				customerdetails.setCustomerLoanStatus("Approved");
				loanappservice.updateCustomer(customerdetails);
			}
			
			else if (customerLoanDetails.contains("Rejected"))
			{
				customerdetails.setCustomerLoanStatus("Rejected");
				loanappservice.updateCustomer(customerdetails);
			}
			
			else
			{
				return null;
			}
			return new ResponseEntity<CustomerDetails>(customerdetails, HttpStatus.OK);	
		
		}
	  
//	 @GetMapping("/getapprovedDocCustomer") //method to iterate approved Document Customer
//	   public List<CustomerDetails> getApprovedDocumentCustomer()
//	   {
//		   List<CustomerDetails> ced = loanappservice.getCustomerData();
//		   List<CustomerDetails> approveddoc = new ArrayList<>(); //dummy list
//
//		   for(CustomerDetails cusomerdetailes:ced) {
//			   
//			if(cusomerdetailes.getCustomerdocstatus().equalsIgnoreCase("Approved"))
//	       {
//				approveddoc.add(cusomerdetailes);
//
//	       }
//		   }
//		   return approveddoc;
//			
//	   }
	 
//	 @GetMapping("/getRejectedDocCustomer") //method to iterate rejected Document Customer
//	   public List<CustomerDetails> getRejectedDocumentCustomer()
//	   {
//		   List<CustomerDetails> ced = loanappservice.getCustomerData();
//		   List<CustomerDetails> rejectdoc = new ArrayList<>(); //dummy list
//
//		   for(CustomerDetails cusomerdetailes:ced) {
//			   
//			if(cusomerdetailes.getCustomerdocstatus().equalsIgnoreCase("Rejected"))
//	       {
//				rejectdoc.add(cusomerdetailes);
//
//	       }
//		   }
//		   return rejectdoc;
//			
//	   }
	 
	 @GetMapping("/getApprovedLoanCustomer") //method to iterate approved Document Customer
	   public List<CustomerDetails> getApprovedDocumentCustomer()
	   {
		   List<CustomerDetails> ced = loanappservice.getCustomerData();
		   List<CustomerDetails> approvedloan = new ArrayList<>(); //dummy list

		   for(CustomerDetails cusomerdetailes:ced) {
			   
			if(cusomerdetailes.getCustomerLoanStatus().equalsIgnoreCase("Approved"))
	       {
				approvedloan.add(cusomerdetailes);

	       }
		   }
		   return approvedloan;
			
	   }
	   
	   @GetMapping("/getRejectedLoanCustomer") //method to iterate rejected Document Customer
	   public List<CustomerDetails> getRejectedDocumentCustomer()
	   {
		   List<CustomerDetails> ced = loanappservice.getCustomerData();
		   List<CustomerDetails> rejectloan = new ArrayList<>(); //dummy list

		   for(CustomerDetails cusomerdetailes:ced) {
			   
			if(cusomerdetailes.getCustomerLoanStatus().equalsIgnoreCase("Rejected"))
	       {
				rejectloan.add(cusomerdetailes);

	       }
		   }
		   return rejectloan;
			
	   }


}
