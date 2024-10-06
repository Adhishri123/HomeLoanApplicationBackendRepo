package com.loan.ad.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.loan.ad.model.EmployeeDetails;

public interface AdminService {

	public EmployeeDetails saveEmployee(String employeeDetails, MultipartFile profileImg);

	public EmployeeDetails updateEmployee(EmployeeDetails ed);

	public List<EmployeeDetails> getEmployeeData();

	public EmployeeDetails getEmployeeById(int employeeId);

	public void deleteEmployeeById(int n);

}
