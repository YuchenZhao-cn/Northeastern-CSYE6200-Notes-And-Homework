package edu.neu.csye6200.launch;

public class Rocket {
	
	
	//Add  Strings for the rocket name and manufacturer
	String Name;
	String Manufacturer;
	
	//Add  values  for  rocket weight (i.e. mass), fuel weight, and payload weight
	int Weight;
	int FuelWeight;
	int PayloadWeight;
	
	//Add a value for the engine thrust in  Newtons
	int EngineThrust;
	
	int WeightOnLaunchPad;
	public int Stages;
	public int TotalWeight;
	
	
	//Add a constructor that sets the  name and  other major values
	public Rocket() {
		Name = "Yuchen No.0";
		Manufacturer = "Yuchen.Zhao";
		Weight = 141;
		FuelWeight = 1900;
		PayloadWeight = 52;
		EngineThrust = 33000000;
	}
	
	// Add a method  to calculate  the total rocket weight on the launch pad
	public int WeightOnLaunchPad() {
		return this.Weight + this.FuelWeight + this.PayloadWeight;
	}
	
	public Rocket(String Name, String Manufacturer, int Weight, int FuelWeight, int PayloadWeight, int WeightOnLaunchPad, int EngineThrust) {
		this.Name = Name;
		this.Manufacturer = Manufacturer;
		this.Weight = Weight;
		this.FuelWeight = FuelWeight;
		this.PayloadWeight = PayloadWeight;
		this.WeightOnLaunchPad = WeightOnLaunchPad();
		this.EngineThrust = EngineThrust;
	}
	
	//Add getter and setter methods for major Rocket variables
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getManufacturer() {
		return Manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}

	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	public int getFuelWeight() {
		return FuelWeight;
	}

	public void setFuelWeight(int fuelWeight) {
		FuelWeight = fuelWeight;
	}

	public int getPayloadWeight() {
		return PayloadWeight;
	}

	public void setPayloadWeight(int payloadWeight) {
		PayloadWeight = payloadWeight;
	}

	public int getEngineThrust() {
		return EngineThrust;
	}

	public void setEngineThrust(int engineThrust) {
		EngineThrust = engineThrust;
	}

	public String toFormattedString() {
		return String.format("%1$12s %2$12s %3$10d %4$10d %5$10d %6$13d %7$10d", Name, Manufacturer, Weight, FuelWeight, PayloadWeight, WeightOnLaunchPad(), EngineThrust);
	}
	
	public String toString() {
		return String.format("Rocket[Name: %1$11s, Manufacturer: %2$11s, Weight: %3$3d/t, FuelWeight: %4$-4d/t, PayloadWeight: %5$-2d/t, TotalWeight: %6$4s/t, EngineThrust: %7$8d/N", Name, Manufacturer, Weight, FuelWeight, PayloadWeight, WeightOnLaunchPad(), EngineThrust);
	}
}
