package com.loan.ad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	private String employeeName;
	@Column(unique = true)
	private String employeeEmail;
	@Column(unique = true)
	private long employeeContactNo;
	private String emplyeeDesignation;
	@Lob
	@Column(length=999999999)
	private byte[] employeeProfileImage;
//	{
//		"employeeName":"Adhishri Deshmukh",
//		"employeeEmail":"s1@gmail.com",
//		"employeeContactNo":9325396144,
//		"emplyeeDesignation":"IT",
//		
//	}
	
}
