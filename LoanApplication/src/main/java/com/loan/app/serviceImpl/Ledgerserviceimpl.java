package com.loan.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.app.model.CustomerDetails;
import com.loan.app.repository.LedgerRepository;
import com.loan.app.service.Ledgerservice;
@Service
public class Ledgerserviceimpl implements Ledgerservice {
@Autowired LedgerRepository lr;
	@Override
	public Optional<CustomerDetails> findById(int cusid) {
		Optional<CustomerDetails> customer=lr.findById(cusid);
		return customer;
	}

	@Override
	public CustomerDetails savecustomerledger(CustomerDetails customerDetails) {
		CustomerDetails savecustomerDetails=lr.save(customerDetails);
		return savecustomerDetails;
	}

	
	
	
}
