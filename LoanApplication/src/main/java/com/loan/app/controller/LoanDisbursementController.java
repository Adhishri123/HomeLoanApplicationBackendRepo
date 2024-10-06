package com.loan.app.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.app.enums.CustomerLoanStatus;
import com.loan.app.exception.CustomerNotFound;
import com.loan.app.model.CustomerDetails;
import com.loan.app.model.LoanDisbursement;
import com.loan.app.response.BaseResponse;
import com.loan.app.service.LoanDisbursementService;

@RestController
@CrossOrigin("*")
public class LoanDisbursementController {

	@Autowired
	private LoanDisbursementService loandisburseservice;
	
	@PutMapping("/updateloanDisbursement/{customerApplicationId}")
	public ResponseEntity<BaseResponse<CustomerDetails>> updateLoan(@RequestBody LoanDisbursement loandisbursement,@PathVariable int customerApplicationId)throws IOException{
		Optional<CustomerDetails> customer=loandisburseservice.findById(customerApplicationId);
		CustomerDetails details = customer.get();
		if(customer.isEmpty()) {
			throw new CustomerNotFound("If Id isn't present then it will throw an Exception");	
		}
		else {
			details.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.LoanDisbursed));
			details.getCustomerloandisbursement().setAmountPaidDate(loandisbursement.getAmountPaidDate());
			details.getCustomerloandisbursement().setTotalLoanSanctionedAmount(loandisbursement.getTotalLoanSanctionedAmount());
			details.getCustomerloandisbursement().setTransferedAmount(loandisbursement.getTransferedAmount());
			details.getCustomerloandisbursement().setPaymentStatus(loandisbursement.getPaymentStatus());
			details.getCustomerloandisbursement().setDealerBankAccountNumber(loandisbursement.getDealerBankAccountNumber());
			details.getCustomerloandisbursement().setDealerBankIfscNumber(loandisbursement.getDealerBankIfscNumber());
			details.getCustomerloandisbursement().setDealerBankName(loandisbursement.getDealerBankName());	
			CustomerDetails responsedata = loandisburseservice.updateloanDisbursement(details);
			BaseResponse br= new BaseResponse<>(200,"Loan Disbursed successfully !!!!",responsedata);
			return new ResponseEntity<BaseResponse<CustomerDetails>>(br,HttpStatus.OK);
		}
	}

}
