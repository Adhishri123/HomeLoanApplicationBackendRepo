package com.loan.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.app.model.CustomerDetails;
import com.loan.app.model.Ledger;
import com.loan.app.service.Ledgerservice;

@CrossOrigin("*")
@RequestMapping("/ledger")
@RestController
public class Ledgercontoller {

	@Autowired
	Ledgerservice ls;

	@PutMapping("/updateledger/{customerApplicationId}")
	public ResponseEntity<CustomerDetails> updateledger(@PathVariable("customerApplicationId") int cusid,
			@RequestBody Ledger ledger) {
		Optional<CustomerDetails> ledgerbyid = ls.findById(cusid);
		CustomerDetails customerDetails = ledgerbyid.get();
		if (ledgerbyid.isPresent()) {
			customerDetails.getCustomerldger().setLedgerId(ledger.getLedgerId());
			customerDetails.getCustomerldger().setTotalPrincipalAmount(ledger.getTotalPrincipalAmount());
			customerDetails.getCustomerldger().setMonthlyEMI(ledger.getMonthlyEMI());
			customerDetails.getCustomerldger().setTenure(ledger.getTenure());
			customerDetails.getCustomerldger().setLedgerCreatedDate(ledger.getLedgerCreatedDate());
			customerDetails.getCustomerldger().setNextEmiStartDate(ledger.getNextEmiStartDate());
			customerDetails.getCustomerldger().setNextEmiEndDate(ledger.getNextEmiEndDate());
			customerDetails.getCustomerldger().setPreviousEmiStatus(ledger.getPreviousEmiStatus());
			customerDetails.getCustomerldger().setCurrentMonthEmiStatus(ledger.getCurrentMonthEmiStatus());
			customerDetails.getCustomerldger().setLoanStatus(ledger.getLoanStatus());
			customerDetails.getCustomerldger().setRemainingAmount(ledger.getRemainingAmount());
			customerDetails.getCustomerldger().setAmountPaidtillDate(ledger.getAmountPaidtillDate());
			customerDetails.getCustomerldger().setPayableAmountwithInterest(ledger.getPayableAmountwithInterest());
			customerDetails.getCustomerldger().setLoanEndDate(ledger.getLoanEndDate());
		}
		CustomerDetails savelegder = ls.savecustomerledger(customerDetails);
		return new ResponseEntity<CustomerDetails>(savelegder, HttpStatus.OK);
	}
}
