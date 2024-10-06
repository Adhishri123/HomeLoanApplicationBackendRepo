package com.loan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.app.model.CustomerDetails;

@Repository
public interface LedgerRepository  extends JpaRepository<CustomerDetails, Integer>{

}
