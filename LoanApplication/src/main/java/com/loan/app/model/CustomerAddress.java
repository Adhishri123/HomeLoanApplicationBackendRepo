package com.loan.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	private int localHouseNumber;
	private String localStreetName;
	private String localAreaName;
	private String localCityName;
	private String localDistrict;
	private String localState;
	private int localPincode;
	private int permanentHouseNumber;
	private String permanentStreetName;
	private String permanentAreaName;
	private String permanentCityName;
	private String permanentDistrict;
	private String permanentState;
	private int permanentPincode;
}
