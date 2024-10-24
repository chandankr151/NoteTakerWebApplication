package com.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "User name should not be null")
	@NotBlank(message = "User name should not be Blank")
	@NotEmpty(message = "User name should not be Empty")
	@Column(name = "user_name")
	private String fullName;

	@NotNull(message = "User qualification should not be null")
	@NotBlank(message = "User qualification should not be Blank")
	@NotEmpty(message = "User qualification should not be Empty")
	@Column(name = "user_qualification")
	private String qualification;

	@NotNull(message = "User email should not be null")
	@NotBlank(message = "User email should not be Blank")
	@NotEmpty(message = "User email should not be Empty")
	@Column(name = "user_email")
	private String email;

	@NotNull(message = "User password should not be null")
	@NotBlank(message = "User password should not be Blank")
	@NotEmpty(message = "User password should not be Empty")
	@Column(name = "user_password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", qualification=" + qualification + ", email=" + email
				+ ", password=" + password + "]";
	}
}
