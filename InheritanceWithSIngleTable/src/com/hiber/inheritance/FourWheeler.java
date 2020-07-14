package com.hiber.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Car")
public class FourWheeler extends Vehicle {
	private String streeringWheel;

	public String getStreeringWheel() {
		return streeringWheel;
	}

	public void setStreeringWheel(String streeringWheel) {
		this.streeringWheel = streeringWheel;
	}

}
