package com.loan.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.exception.CustomerNotFound;
import com.loan.exception.NotValidDetails;
import com.loan.model.CustomerEnquiryDetails;
import com.loan.repository.EnquiryRepository;
import com.loan.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	EnquiryRepository enquiryrepo;

	@Override
	public CustomerEnquiryDetails saveEnquiryDetails(CustomerEnquiryDetails ced) {
		try {
			return enquiryrepo.save(ced);
		} catch (Exception e) {
			throw new NotValidDetails();
		}
	}

	@Override
	public List<CustomerEnquiryDetails> getEnquiryDetailsss() {
		List<CustomerEnquiryDetails> li = enquiryrepo.findAll();
		return li;
	}

	@Override
	public CustomerEnquiryDetails getEnquiryByName(String customerFirstName) {
		Optional<CustomerEnquiryDetails> oc = enquiryrepo.findByCustomerFirstName(customerFirstName);
		if (oc.isPresent()) {
			return oc.get();
		} else {
			throw new CustomerNotFound(customerFirstName+"Customer is not available");
		}
	}

	@Override
	public void saveCibil(CustomerEnquiryDetails customerEnquiryDetails) {
		enquiryrepo.save(customerEnquiryDetails);

	}

//	@Override
//	public CustomerEnquiryDetails getEnquiryByName(String customerFirstName) {
//		CustomerEnquiryDetails response=enquiryrepo.findByCustomerFirstName(customerFirstName);
//		
//		if(response!=null) {
//			return response;
//		}
//		else {
//			return null;
//		}
//	}

}
