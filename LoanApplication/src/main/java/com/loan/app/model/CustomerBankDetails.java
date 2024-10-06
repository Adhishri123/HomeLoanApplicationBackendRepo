package com.loan.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerBankDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerBankDetailsId;
	private long customerBankAccountNumber;
	private String customerBankName;
	private String customerBankBranchName;
	private String customerBankIfscNumber;
}
