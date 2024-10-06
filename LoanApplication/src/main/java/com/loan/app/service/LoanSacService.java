package com.loan.app.service;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import com.loan.app.model.CustomerDetails;


public interface LoanSacService {

	Optional<CustomerDetails> findById(int cusid);

	 public CustomerDetails savesactiondata(CustomerDetails customerDetails);

	ByteArrayInputStream generateapplicationpdf(int customerApplicationId);

	public List<CustomerDetails> getCustomerData();
	
}