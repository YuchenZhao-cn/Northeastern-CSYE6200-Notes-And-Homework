package edu.neu.csye6200.inherit2;

public class InheritTest {

	public InheritTest() {
		PowerMeasure pm0 = new PowerMeasure();
		System.out.println("PowerMwasure resistivity" + pm0.getResistivity());
		
		displayMeasure(pm0);
		
		AltPowerMeasure apm0 = new AltPowerMeasure();
		System.out.println("AltPowerMwasure resistivity" + apm0.getResistivity());
		
		displayMeasure(apm0);
		
	    MeterManager meterMgr = MeterManager.instance();
	    System.out.println(meterMgr);
	    meterMgr.add(pm0);
	    meterMgr.add(apm0);
	    
	    MeterManager meterMgr2 = MeterManager.instance();
	    System.out.println(meterMgr2);
	    
	}
	
	public void displayMeasure(MeterI meter) {
		System.out.println("Measure is " + meter.measure());
	}
	
	public static void main(String[] args) {
		InheritTest iTest = new InheritTest();
		
	}

}
