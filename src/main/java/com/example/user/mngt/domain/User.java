package com.example.user.mngt.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.example.user.mngt.util.CustomDateDeserilizer;
import com.example.user.mngt.util.CustomDateSerilizer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class User {

	private int id;
	@NotNull
	private String fName;
	@NotNull
	private String lName;
	@NotNull
	private String email;
	private int pinCode;
	@JsonSerialize(using = CustomDateSerilizer.class)
	@JsonDeserialize(using = CustomDateDeserilizer.class)
	@Past
	private Date birthDate;
	private boolean isActive;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", pinCode=" + pinCode
				+ ", birthDate=" + birthDate + ", isActive=" + isActive + "]";
	}

}
