package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "StudentDetails.byId",query = "from StudentDetails where stid = ?")
//@NamedNativeQuery(name = "StudentDetails.byname",query = "select * from Student_Details where sname = ?")
//@Table(name = "Student_Details")
public class StudentDetails {
	@Id @GeneratedValue
	private int stid;
	private String sname;
	private String scity;

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

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

	@Override
	public String toString() {
		return "StudentDetails [stid=" + stid + ", sname=" + sname + ", scity=" + scity + "]";
	}
	

}
