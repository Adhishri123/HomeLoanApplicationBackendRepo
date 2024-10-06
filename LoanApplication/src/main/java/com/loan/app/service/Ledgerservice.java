package com.loan.app.service;

import java.util.Optional;

import com.loan.app.model.CustomerDetails;

public interface Ledgerservice {

	 public Optional<CustomerDetails> findById(int cusid);

	public CustomerDetails savecustomerledger(CustomerDetails customerDetails);

}
