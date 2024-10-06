package com.loan.ad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.loan.ad.exception.NotValidEmailIdForEmployee;
import com.loan.ad.exception.NotValidMobileNumberForEmployee;
import com.loan.ad.model.EmployeeDetails;
import com.loan.ad.service.AdminService;

@RestController
@CrossOrigin("*")
public class AdminController 
{
	 @Autowired private AdminService adminservice;
	   
	   @PostMapping("/Add_Employees")
	   public ResponseEntity<String> addEmployees(@RequestPart ("employees") String employeeDetails,
			                                      @RequestPart ("profile") MultipartFile profileImg)
	   {
		   EmployeeDetails emp = adminservice.saveEmployee(employeeDetails,profileImg);
		   return new ResponseEntity<String>("Employee Data Added Successfully",HttpStatus.CREATED); 

	   }
	   
	   
	   @GetMapping("/get_employee_details")
	   public ResponseEntity<List<EmployeeDetails>> getAllEmployeeDetails()
	   {
		   List<EmployeeDetails> el = adminservice.getEmployeeData();
		   return new ResponseEntity<List<EmployeeDetails>>(el,HttpStatus.ACCEPTED);
	   }
	   
	   @PutMapping("/edit_employeedetails/{employeeId}")
		public ResponseEntity<EmployeeDetails> editEmployeeData(@PathVariable("employeeId") int id, @RequestBody EmployeeDetails ed)
		{
			EmployeeDetails empd = adminservice.updateEmployee(ed);
			
			return new ResponseEntity<EmployeeDetails>(empd,HttpStatus.OK);
		}

	 //get Single Admin Record By using employeeID
	   @GetMapping("/getEmployeeById/{employeeId}")
	   public ResponseEntity<EmployeeDetails> getEmployeeById(@PathVariable("employeeId") int employeeId ){
		   EmployeeDetails response =adminservice.getEmployeeById(employeeId);
		   return new ResponseEntity<EmployeeDetails>(response,HttpStatus.OK);
	   }


	   @DeleteMapping("/deleteemp/{employeeId}")
		public  ResponseEntity<String>  deleteEmployee(@PathVariable("employeeId") int n) {
			   adminservice.deleteEmployeeById(n);
			return new ResponseEntity<String>("Delete Employee Sucessfully..!!",HttpStatus.OK);
		} 

}
