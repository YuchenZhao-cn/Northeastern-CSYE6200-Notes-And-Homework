package Week4Class;

public class Vehicle {
	
	int passengers;
	double kpl;//kilometers per liter
	int fuelCap;//size of fuel tank in liters
	
	String make;//Volvo,BMW,etc.
	String model;//500, 5000
	int year;
	
	/**
	 * Constructor (default)
	 */
	public Vehicle() {
		make = "Unk.";
		model = "-7-";
		passengers = 4;
		kpl = 20.5;
		fuelCap = 30;
		year = 2019;
		
	}
	
	/*
	use the ? operator form
	var = (condition) ? expression1 : expression2
    maxLen = (lookFoward < 5) ? 12 : minLength-1;
	
	type array-name[] = new type[size];
	for(type itr-val : collection) statement;
	int nums[] = { 1,2,3,4,5,6,7,8,9,10 };
	int sum = 0;
	for (int x : nums)
	sum += x; //same as 'sum = sum + x;'

	
	*/
	public Vehicle(int year, String make, String model, int passengers, double kpl, int fuelCap)
	{
		this.passengers = passengers;
		this.kpl = kpl;
		this.fuelCap = fuelCap;
		this.make = make;
		this.model = model;
		this.year = year;
		
	}
	
	public String toFormattedString() {
		//String myName = "Mark";
		// year 4 digits, String 10 digits, String 12 chars
		return String.format("%1$04d %2$10s %3$12s", year, make, model);
	}
	
	public String toString() {
		return ("Vehicle[make=" + make + 
				"£¬ model=" + model + 
				"£¬ fuelCap=" + fuelCap + 
				"£¬ kpl=" + kpl + 
				"£¬ fuelCap=" + fuelCap + 
				"£¬ passengers=" + passengers + "]");
	}
	
}
