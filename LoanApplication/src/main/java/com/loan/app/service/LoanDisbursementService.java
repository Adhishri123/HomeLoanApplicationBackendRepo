package com.loan.app.service;

import java.util.Optional;

import com.loan.app.model.CustomerDetails;

public interface LoanDisbursementService {

	public Optional<CustomerDetails> findById(int customerApplicationId);

	public CustomerDetails updateloanDisbursement(CustomerDetails details);
}
