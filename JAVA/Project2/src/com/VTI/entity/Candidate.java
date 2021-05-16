package com.VTI.entity;

public abstract class Candidate {
	private int id;
	private String FirstName;
	private String LastName;
	private String PhoneNumber;
	private String Email;
	private String Password;
	
	public Candidate() {
	}
	
	
	public Candidate(int id, String firstName, String lastName, String phoneNumber, String email, String password) {
		super();
		this.id = id;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.PhoneNumber = phoneNumber;
		this.Email = email;
		this.Password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", PhoneNumber="
				+ PhoneNumber + ", Email=" + Email + ", Password=" + Password + "]";
	}
	
}
