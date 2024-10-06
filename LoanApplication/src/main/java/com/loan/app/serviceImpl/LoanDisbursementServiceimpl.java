package com.loan.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.app.model.CustomerDetails;
import com.loan.app.repository.LoanDisbursementRepository;
import com.loan.app.service.LoanDisbursementService;

@Service
public class LoanDisbursementServiceimpl implements LoanDisbursementService{

	@Autowired
	private LoanDisbursementRepository loandisburserepository;

	@Override
	public Optional<CustomerDetails> findById(int customerApplicationId) {
		Optional<CustomerDetails> data = loandisburserepository.findBycustomerApplicationId(customerApplicationId);
		return data;
	}

	@Override
	public CustomerDetails updateloanDisbursement(CustomerDetails details) {
		CustomerDetails savedata=loandisburserepository.save(details);
		return savedata;
	}
	

}
