package com.loan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.app.model.CustomerDetails;

public interface ScantionRepository extends JpaRepository<CustomerDetails, Integer> {

}
