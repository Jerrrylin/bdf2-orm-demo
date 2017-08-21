package com.bstek.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name = "DEMO_USER")
public class DemoUser {
	@Id
	@Column(name = "USERNAME_", length = 60)
	private String username;

	@Column(name = "MALE_", nullable = false)
	private boolean male = true;

	@Column(name = "BIRTHDAY_")
	private Date birthday;

	@Column(name = "MOBILE_", length = 20)
	private String mobile;

	@Column(name = "ADDRESS_", length = 120)
	private String address;

	@Column(name = "EMAIL_", length = 60)
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
