package edu.neu.csye6200.serial;

import java.io.Serializable;

public class CarData implements Serializable, Comparable<CarData> {
	
	private int iValue = 0;
	private double dValue = 0;
	private String name;

	public CarData(int iValue, double dValue, String name) {
		this.iValue = iValue;
		this.dValue = dValue;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int compareTo(CarData cd) {
		return name.compareTo(cd.name);
//		return cd.name.compareTo(name);
	}
	
	
	

}
