package com.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Student_Details")
public class StudentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stid;
	private String sname;
	private Date joinedDate;
	

	
//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name="State", column=@Column(name="Home_State_Name")),
//		@AttributeOverride(name="City",column=@Column(name="Home_City_Name")),
//		@AttributeOverride(name="pincode",column=@Column(name="Home_Pincode_Name"))})
//	private Address home_Address;
//	
//	@Embedded
//	private Address office_Address;
	
	
//********************using Collections***********************************
	@ElementCollection
	@JoinTable(name="Student_Address",joinColumns=@JoinColumn(name="Stid"))
	@GenericGenerator(name="hilo-gen",strategy = "increment")
	@CollectionId(columns = @Column(name="Addr_id"),type = @Type(type = "long"), generator = "hilo-gen")
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
	

	
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	
	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

//	public StudentDetails(int stid, String sname, Date joinedDate, Vehicle vehicle) {
//		super();
//		this.stid = stid;
//		this.sname = sname;
//		this.joinedDate = joinedDate;
//		this.vehicle = vehicle;
//	}

//	public Address getHome_Address() {
//		return home_Address;
//	}
//
//	public void setHome_Address(Address home_Address) {
//		this.home_Address = home_Address;
//	}
//
//	public Address getOffice_Address() {
//		return office_Address;
//	}
//
//	public void setOffice_Address(Address office_Address) {
//		this.office_Address = office_Address;
//	}

	

}
