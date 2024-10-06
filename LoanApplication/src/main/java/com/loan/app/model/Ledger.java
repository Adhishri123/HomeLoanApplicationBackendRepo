package com.loan.app.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ledger {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int ledgerId;

	@Temporal(TemporalType.DATE)
	private String ledgerCreatedDate;
	
	private double totalPrincipalAmount;
	private double payableAmountwithInterest;
	private int tenure;
	private double monthlyEMI;
	private double amountPaidtillDate;
	private double remainingAmount;
	
	private String nextEmiStartDate;
	private String nextEmiEndDate;
	
	private String previousEmiStatus;
	private String currentMonthEmiStatus;
	private String loanEndDate;
	private String loanStatus;
	

}

//
//totalPrincipalAmount;
//payableAmountwithInterest;
//tenure;
//monthlyEMI;
//amountPaidtillDate;
//remainingAmount;
//nextEmiStartDate;
//nextEmiEndDate;
//previousEmiStatus;
//currentMonthEmiStatus;
//loanEndDate;
//loanStatus;
