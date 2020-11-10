package edu.neu.csye6200.inherit2;

public abstract class MeterA {
	
	private double probeVal = 12.3;

	public MeterA() {
		
	}
	
	public double getProbeVal() {
		return probeVal;
	}


	public abstract double calcProbeMeasure();

}
