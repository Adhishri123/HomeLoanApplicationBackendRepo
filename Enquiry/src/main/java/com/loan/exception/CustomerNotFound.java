package com.loan.exception;

public class CustomerNotFound extends RuntimeException{

	public CustomerNotFound(String message)
	{
		super(message);
	}
}
