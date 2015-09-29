package com.luke.dto5;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table (name="USER_Details")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride (name="city",column=@Column(name="HOME_CITY")),
			@AttributeOverride (name="po",column=@Column(name="HOME_PO"))
	})
	private Address homeAddr;
	@Embedded
	private Address officeAddr;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Address getHomeAddr() {
		return homeAddr;
	}
	public void setHomeAddr(Address homeAddr) {
		this.homeAddr = homeAddr;
	}
	public Address getOfficeAddr() {
		return officeAddr;
	}
	public void setOfficeAddr(Address officeAddr) {
		this.officeAddr = officeAddr;
	}
	
}
