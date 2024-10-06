package com.loan.app.controller;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.loan.app.model.CustomerDetails;
import com.loan.app.service.LoanSacService;

@CrossOrigin("*")
@RestController
public class LoanSacController {

	@Autowired
	LoanSacService ls;

	@PutMapping("/sanctionUpdate/{customerApplicationId}")
	public ResponseEntity<CustomerDetails> sanctionUpdate(@PathVariable("customerApplicationId") int cusid,
			@RequestBody CustomerDetails customerDetails) {
		Optional<CustomerDetails> findById = ls.findById(cusid);
		CustomerDetails customer = findById.get();
		if (findById.isPresent()) {
			if (customer.getCustomerLoanStatus().equals("Approved")) {
				customer.getSanction().setLoanAmountSanctioned(customerDetails.getSanction().getLoanAmountSanctioned());
				customer.getSanction().setLoanTenure(customerDetails.getSanction().getLoanTenure());
				customer.getSanction().setMonthlyEmiAmount(customerDetails.getSanction().getMonthlyEmiAmount());
				customer.getSanction().setSanctionDate(customerDetails.getSanction().getSanctionDate());
				customer.getSanction().setRateOfInterest(customerDetails.getSanction().getRateOfInterest());
				customer.getSanction().setSanctionId(customerDetails.getSanction().getSanctionId());
				customer.getSanction().setSanctionLetter(customerDetails.getSanction().getSanctionLetter());

			}
		}
		CustomerDetails cust = ls.savesactiondata(customerDetails);
		return new ResponseEntity<CustomerDetails>(cust, HttpStatus.OK);
	}

	@GetMapping("/applicationPDF/{customerApplicationId}")
	public ResponseEntity<InputStreamResource> generationApplicationpdf(@PathVariable int customerApplicationId) {
		ByteArrayInputStream byteArrayInputStream = ls.generateapplicationpdf(customerApplicationId);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("content-disposition", "inline;filename=HomeLoan.pdf");
		return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(byteArrayInputStream));
	}

	@GetMapping("/getApprovedLoanCustomers") // method to iterate approved Document Customer
	public List<CustomerDetails> getApprovedDocumentCustomer() {
		List<CustomerDetails> ced = ls.getCustomerData();
		List<CustomerDetails> approvedloan = new ArrayList<>(); // dummy list

		for (CustomerDetails cusomerdetailes : ced) {

			if (cusomerdetailes.getCustomerLoanStatus().equalsIgnoreCase("Approved")) {
				approvedloan.add(cusomerdetailes);

			}
		}
		return approvedloan;

	}
}