package com.rubber.band.facebookX.model;

public class AuthenticationDB {
	String emailId;
	String password;
	String id;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Authentication Profile : " + this.getEmailId() + " " + this.getPassword() + " " + this.getId();
	}

}
