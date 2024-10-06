package com.loan.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerApplicationId;
	private String customerFirstName;
	private String customerMiddleName;
	private String customerLastName;
	@Column(unique = true)
	private long customerMobileNumber;
	private long customerAdditionalMobileNumber;
	private String customerPanCardNumber;
	private long customerAadharCard;
	private String customerDateOfBirth;
	private String customerEmail;
	private String customerPassword;
	private String customerGender;
	private String customerQualification;
	private String customerLoanStatus;
	private double customerLoanAmountRequired;
	private String customerdocstatus;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress customerAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerProfession customerProfession;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerBankDetails customerBankDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAllDocuments customerAllDocuments;
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDisbursement customerloandisbursement;
	@OneToOne(cascade = CascadeType.ALL)
	private Ledger customerldger; 
	@OneToOne(cascade = CascadeType.ALL)
	private Sanction sanction;
	

	
}
