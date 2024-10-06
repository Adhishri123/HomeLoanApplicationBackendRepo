package com.loan.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.app.model.CustomerDetails;
@Repository
public interface LoanDisbursementRepository extends JpaRepository<CustomerDetails, Integer>{

	public CustomerDetails findByCustomerApplicationId(int cid);

	public Optional<CustomerDetails> findBycustomerApplicationId(int customerApplicationId);


}
