package com.project.beans;

public class RegisteredUser {
	private String fullname;
	private String username;
	private String password;
	private String usertype;
	private String email;
	private String contact;
	
	public RegisteredUser() {
		// TODO Auto-generated constructor stub
	}

	public RegisteredUser(String fullname, String username, String password, String usertype,
			String email, String contact) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.email = email;
		this.contact = contact;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
}
