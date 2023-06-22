package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerTrailTable")
public class Customertrail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private Long id;

	@Column(name = "cust_title")
	private String title;

	@Column(name = "cust_type")
	private String type;

	@Column(name = "cust_caddress")
	private String currentAddress;

	@Column(name = "cust_capincode")
	private String currentPINCode;

	@Column(name = "cust_dob")
	private String dateOfBirth;

	@Column(name = "cust_mobile1")
	private String mobile1;

	@Column(name = "cust_mobile2")
	private String mobile2;

	@Column(name = "cust_rphone")
	private String residencePhone;

	@Column(name = "cust_raddress")
	private String residenceAddress;

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setcust_id(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setcustTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setcust_type(String type) {
		this.type = type;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setcust_caddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getCurrentPINCode() {
		return currentPINCode;
	}

	public void setcust_capincode(String currentPINCode) {
		this.currentPINCode = currentPINCode;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setcust_dob(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setcust_mobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setcust_mobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getResidencePhone() {
		return residencePhone;
	}

	public void setcust_rphone(String residencePhone) {
		this.residencePhone = residencePhone;
	}

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setcust_raddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}
}
