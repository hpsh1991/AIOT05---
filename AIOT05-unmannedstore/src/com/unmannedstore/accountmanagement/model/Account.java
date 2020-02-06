package com.unmannedstore.accountmanagement.model;

import java.sql.Date;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class Account {
	protected int id;
	protected String name;
	protected String password;
	protected String email;
	protected String phone;
	protected String birthday;
	protected String memberimg;
	protected String membercode;
	protected int memberrank;
	protected int memberpoints;
	
	public Account() {
		super();
	}

	public Account(int id, String name, String password, String email, String phone, String birthday, String memberimg,
			String membercode, int memberrank, int memberpoints) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.memberimg = memberimg;
		this.membercode = membercode;
		this.memberrank = memberrank;
		this.memberpoints = memberpoints;
	}

	public Account(String name, String password, String email, String phone, String birthday, String memberimg,
			String membercode, int memberrank, int memberpoints) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.memberimg = memberimg;
		this.membercode = membercode;
		this.memberrank = memberrank;
		this.memberpoints = memberpoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMemberimg() {
		return memberimg;
	}

	public void setMemberimg(String memberimg) {
		this.memberimg = memberimg;
	}

	public String getMembercode() {
		return membercode;
	}

	public void setMembercode(String membercode) {
		this.membercode = membercode;
	}

	public int getMemberrank() {
		return memberrank;
	}

	public void setMemberrank(int memberrank) {
		this.memberrank = memberrank;
	}

	public int getMemberpoints() {
		return memberpoints;
	}

	public void setMemberpoints(int memberpoints) {
		this.memberpoints = memberpoints;
	}
	
	
	
	





}
