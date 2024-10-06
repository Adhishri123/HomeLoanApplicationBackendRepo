package com.loan.losa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import com.loan.losa.service.LoanSacService;


@RestController
public class LoanSacController {

	@Autowired LoanSacService ls;
	
//	@Autowired
//	SanctionService ss;
//	
//	@Value("${spring.mail.username}")
	@Value("${spring.mail.username}")
	private String fromEmail;
	
//	private String fromEmail;
	
//	@GetMapping("/getCustomer/{custloanstatus}")	//get customer by loan status
//	public ResponseEntity<BaseResponse<Iterable<CustomerDetails>>> getCustomerByStatus(
//			@PathVariable("custloanstatus") String custloanstatus) {
//		CustomerDetails cstd = null;
//		Iterable<CustomerDetails> cst = ss.getCustomerbyStatus(custloanstatus);
//		for (CustomerDetails cstds : cst) {
//			if (cstds != null) {
//				cstd = cstds;
//			}
//		}
//		if (cstd != null) {
//			BaseResponse<Iterable<CustomerDetails>> br = new BaseResponse<>(200, "All Data Successfully get..", cst);
//			return new ResponseEntity<BaseResponse<Iterable<CustomerDetails>>>(br, HttpStatus.OK);
//		} else {
//			throw new CustomerNotFound();
//		}
//	}
//
//	
////	@PutMapping(value = "/updateCustomer/{cstid}")	//update customer by id
////	public ResponseEntity<BaseResponse<CustomerDetails>> updateCustomer(@PathVariable Integer cstid,
////			@RequestPart("allData") String allData) throws IOException {
////		ObjectMapper om = new ObjectMapper();
////		if(allData.isEmpty()) {
////			throw new CustomerNotFound();
////		}else {
////			CustomerDetails csd = om.readValue(allData, CustomerDetails.class);
////
////			csd.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.SanctionLetterGenerated));
////			CustomerDetails customerdetails = ss.updateCustomer(cstid, csd);
////			BaseResponse br = new BaseResponse<>(201, "Data Successfully Updated..", customerdetails);
////			return new ResponseEntity<BaseResponse<CustomerDetails>>(br, HttpStatus.ACCEPTED);
////		}
////	}
//	
	
//	@PutMapping("/generatePdf/{customerid}")
//	public ResponseEntity<BaseResponse<CustomerDetails>> updateSactionLetter(@PathVariable("customerid") Integer customerid, @RequestBody SanctionLetter sanctionLetter)throws PdfNotGenerated {
////		Email email = new Email();
//		CustomerDetails customerdetail = new CustomerDetails();
////			email.setFromEmail(fromEmail);
//			CustomerDetails customerdetails = ss.generateSactionId(customerid, sanctionLetter);
//			
//			BaseResponse br = new BaseResponse<>(200,"Sanction Letter Generated", customerdetails);
//			return new ResponseEntity<BaseResponse<CustomerDetails>>(br, HttpStatus.OK);
//
//	}
//	
//	 @PutMapping("/sanctionUpdate/{cusid}")
//	  public ResponseEntity<BaseResponse<CustomerDetails>> sanctionUpdate(@PathVariable("cusid") Integer cusid,@RequestBody String loanStatus){
//		Optional<CustomerDetails> findById = ss.findById(cusid);
//		CustomerDetails customerDetails = findById.get();
//		
//		if(findById.isPresent()) {
//			if(loanStatus.equals("Accepted")) {
//				customerDetails.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.SanctionLetterApproved));
//			}
//			else if(loanStatus.equals("Rejected")) 
//			{
//				customerDetails.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.SanctionLetterRejected));
//			}
//			  
//		}
//		else 
//		{
//			throw new CustomerNotFound();
//		}
//		CustomerDetails customerData = ss.changeStatus(customerDetails);
//		BaseResponse baseResponse=new BaseResponse(200,"Sanction Letter status Updated",customerData);
//		return new ResponseEntity<BaseResponse<CustomerDetails>>(baseResponse,HttpStatus.OK);
//	}
//	
//	@GetMapping("/sanctionLetterStatus/{loanStatus}")
//	public ResponseEntity<BaseResponse<Iterable<CustomerDetails>>> sanctionletterstatus(@PathVariable("loanStatus") String loanStatus)
//	{
//		Iterable<CustomerDetails> findByLoanStatus = ss.findByLoanStatus(loanStatus);
//		BaseResponse baseResponse=new BaseResponse<>(200,"All Data",findByLoanStatus);
//		return new ResponseEntity<BaseResponse<Iterable<CustomerDetails>>>(baseResponse,HttpStatus.OK);
//	}
}
