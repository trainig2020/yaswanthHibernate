package com.hiber.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {
	private String streeringHandle;

	public String getStreeringHandle() {
		return streeringHandle;
	}

	public void setStreeringHandle(String streeringHandle) {
		this.streeringHandle = streeringHandle;
	}

}
