package com.loan.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEnquiryDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerEnquiryId;
    private String customerFirstName;
    private String  customerLastName;
    private String customerPanCard;
    private long customerAadharNumber;
//    @Column(unique = true)
    private String customerEmailId;
    private String customerPassword;
    @Column(unique = true)
    private long customerMobileNumber;
    @OneToOne(cascade = CascadeType.ALL)
	private Cibil cibil;
    

}
