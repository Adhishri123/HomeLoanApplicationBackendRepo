package com.loan.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.app.exception.CustomerNotFound;
import com.loan.app.exception.NotValidMobileNo;
import com.loan.app.model.CustomerDetails;
import com.loan.app.repository.LoanAppRepository;
import com.loan.app.service.LoanAppService;

@Service
public class LoanAppServiceImpl implements LoanAppService
{
     @Autowired
     private LoanAppRepository loanapprepository;
     
	 @Override
	 public CustomerDetails saveCustomer(String customerDetails, MultipartFile pancard, MultipartFile incomeCertificate,
			                            MultipartFile adharcard, MultipartFile pphoto, MultipartFile ssign, MultipartFile bankpassbook) 
	  {
		
		ObjectMapper mapper = new ObjectMapper();
		try
		{
		   CustomerDetails cd = mapper.readValue(customerDetails,CustomerDetails.class);
		   cd.getCustomerAllDocuments().setPanCard(pancard.getBytes());
		   cd.getCustomerAllDocuments().setIncomeProof(incomeCertificate.getBytes());
		   cd.getCustomerAllDocuments().setAadharCard(adharcard.getBytes());
		   cd.getCustomerAllDocuments().setPhoto(pphoto.getBytes());
		   cd.getCustomerAllDocuments().setSignature(ssign.getBytes());
		   cd.getCustomerAllDocuments().setBankPassBook(bankpassbook.getBytes());
		   loanapprepository.save(cd);
		}
		catch(Exception e)
		{
		//	throw new NotValidMobileNo();
		e.printStackTrace();
//			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CustomerDetails> getCustomerData() {
		List<CustomerDetails> cd = loanapprepository.findAll();
		return cd;
	}

	@Override
	public void deleteCustomerById(int csid) {
		loanapprepository.deleteById(csid);
		
	}

	@Override
	public CustomerDetails updateCustomerById(CustomerDetails cd) {
		CustomerDetails emd = loanapprepository.save(cd);
		return emd;
	}


	@Override
	public CustomerDetails getByIdCustomer(int cid) {
		Optional<CustomerDetails> oc = loanapprepository.findByCustomerApplicationId(cid);
		if(oc.isPresent())
		{
			CustomerDetails cd = oc.get();
			return cd;

		}
		else 
		{
			throw new CustomerNotFound(cid+"Customer is not available");
		}
	}

	@Override
	public CustomerDetails updateCustomer(CustomerDetails customerDetails2) {
		return loanapprepository.save(customerDetails2);
		
	}

}
