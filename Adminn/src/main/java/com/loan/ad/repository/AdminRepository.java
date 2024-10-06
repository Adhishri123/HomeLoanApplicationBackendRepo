package com.loan.ad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.ad.model.EmployeeDetails;

@Repository
public interface AdminRepository extends JpaRepository<EmployeeDetails, Integer> {

//	Optional<EmployeeDetails> findByEmployeeName(String employeeName);
	
}
