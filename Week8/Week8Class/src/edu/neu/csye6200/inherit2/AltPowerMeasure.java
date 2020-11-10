package edu.neu.csye6200.inherit2;

public class AltPowerMeasure extends PowerMeasure {

	public AltPowerMeasure() {
		System.out.println("AltPowerMeasure constructor called");
	}
	
	public double getResistivity() { // V = IR
//		return (voltage / current) * 2;
		return (super.getResistivity()) * 2;
	}

}
