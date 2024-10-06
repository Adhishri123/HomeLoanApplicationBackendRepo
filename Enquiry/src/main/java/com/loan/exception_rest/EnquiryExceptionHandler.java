package com.loan.exception_rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.loan.dto.BaseResponse;
import com.loan.enums.ErrorInfo;
import com.loan.exception.CustomerNotFound;
import com.loan.exception.NotValidDetails;

@RestControllerAdvice
public class EnquiryExceptionHandler {

//	@ExceptionHandler(NotValidDetails.class)
//	public ResponseEntity<BaseResponse> handleDuplicateEntry()
//	{
//		return new ResponseEntity<BaseResponse>(new BaseResponse(ErrorInfo.Email_Id_Already_Exists.toString(),new Date()),HttpStatus.NOT_ACCEPTABLE);
//	}
	
	@ExceptionHandler(NotValidDetails.class)
	public ResponseEntity<BaseResponse> handleDuplicateEntries()
	{
		return new ResponseEntity<BaseResponse>(new BaseResponse(ErrorInfo.Mobile_Number_Already_Exists.toString(),new Date()),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<BaseResponse> handleCustomerNotFound()
	{
		return new ResponseEntity<BaseResponse>(new BaseResponse(ErrorInfo.Customer_Is_Not_Available.toString(),new Date()),HttpStatus.NOT_FOUND);
	}
}
