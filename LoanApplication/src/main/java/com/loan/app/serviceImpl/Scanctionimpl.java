package com.loan.app.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.app.enums.CustomerLoanStatus;
import com.loan.app.model.CustomerDetails;
import com.loan.app.model.Sanction;
import com.loan.app.repository.ScantionRepository;
import com.loan.app.service.LoanSacService;
import com.loan.utility.ApplicationPdf;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class Scanctionimpl implements LoanSacService {
	@Autowired
	ScantionRepository sr;
	Logger logger = LoggerFactory.getLogger(Scanctionimpl.class);

	@Override
	public Optional<CustomerDetails> findById(int cusid) {
		return sr.findById(cusid);

	}

	@Override
	public CustomerDetails savesactiondata(CustomerDetails customerDetails) {

		return sr.save(customerDetails);
	}

	@Override
	public ByteArrayInputStream generateapplicationpdf(int customerApplicationId) {
		Optional<CustomerDetails> findById = sr.findById(customerApplicationId);
		CustomerDetails customerDetails = new CustomerDetails();
		if (findById.isPresent()) {
			customerDetails = findById.get();
		}
		ByteArrayOutputStream byteArrayOutputStream = ApplicationPdf.getApplicationPdf(customerDetails);
		return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	}

	@Override
	public List<CustomerDetails> getCustomerData() {
		List<CustomerDetails> cd = sr.findAll();
		return cd;
	}

}