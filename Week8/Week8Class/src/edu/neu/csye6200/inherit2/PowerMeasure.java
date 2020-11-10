package edu.neu.csye6200.inherit2;

public class PowerMeasure extends MeterA implements MeterI{
	
	protected double current = 1.0; // 1 ampere
	protected double voltage = 12.0; // 12 volts

	public PowerMeasure() {
		System.out.println("PowerMeasure constructor called");
	}
	
	public double getResistivity() { // V = IR
		return voltage / current;
	}

	@Override
	public double measure() {
		return voltage * current;
	}

	@Override
	public double calcProbeMeasure() {
		double pv = getProbeVal();
		return current * pv;
	}
	

}
