package com.luke.dto8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

@Entity
@Table (name="USER_Details")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@ElementCollection
	@JoinTable(name="USER_ADDRESS",
		joinColumns=@JoinColumn(name="USER_ID")
	) //join table is mandatory.change table name and primary key
	@CollectionId(columns = { @Column }, generator = "", type = @Type) //not jpa specific but hibernate specific
	private Collection<Address> lOfAddresses = new ArrayList<Address>(); //why interface, lazy and eager loading
	
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
	public Collection<Address> getlOfAddresses() {
		return lOfAddresses;
	}
	public void setlOfAddresses(Collection<Address> lOfAddresses) {
		this.lOfAddresses = lOfAddresses;
	}
		
}
