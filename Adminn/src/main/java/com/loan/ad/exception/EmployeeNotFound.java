package com.loan.ad.exception;

public class EmployeeNotFound extends RuntimeException{

	public EmployeeNotFound(String message)
	{
		super(message);
	}

	public EmployeeNotFound() {
		
	}
}
