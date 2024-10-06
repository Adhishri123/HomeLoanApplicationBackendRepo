package com.loan.losa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanId;
    private double maximumLoanGrant;
    private double interestRate;
    private int tenure;
    private double loanAmount;
    private  double monthlypayment;
    private String startDate;
    private String endDate;
    private String isApproved;
    private String status;

}
