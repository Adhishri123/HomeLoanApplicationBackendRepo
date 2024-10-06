package com.loan.ad.exception_rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.loan.ad.dto.BaseResponse;
import com.loan.ad.enums.ErrorInfo;
import com.loan.ad.exception.EmployeeNotFound;
import com.loan.ad.exception.NotValidEmailIdForEmployee;
import com.loan.ad.exception.NotValidMobileNumberForEmployee;

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(NotValidEmailIdForEmployee.class)
	public ResponseEntity<BaseResponse> handleCustomerEmailId()
	{
		return new ResponseEntity<BaseResponse>(new BaseResponse(ErrorInfo.Email_Id_Already_Exists.toString(), new Date()),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<BaseResponse> handleEmployeeNotFound()
	{
		return new ResponseEntity<BaseResponse>(new BaseResponse(ErrorInfo.Employee_Is_Not_Available.toString(),new Date()),HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(NotValidMobileNumberForEmployee.class)
//	public ResponseEntity<BaseResponse> handleCustomerMobNo()
//	{
//		return new ResponseEntity<BaseResponse>(new BaseResponse(ErrorInfo.Mobile_Number_Already_Exists.toString(), new Date()),HttpStatus.NOT_ACCEPTABLE);
//	}
}
