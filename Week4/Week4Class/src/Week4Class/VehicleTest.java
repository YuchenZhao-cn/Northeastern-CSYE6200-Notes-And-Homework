/**
 * 
 */
package Week4Class;

/**
 * @author Acpto
 *
 */
public class VehicleTest{
	Vehicle carList[];

	/**
	 * test code
	 */
	public VehicleTest() {
		carList = new Vehicle[10];
		loadSampleCars();
		
	}
	
	public void loadSampleCars() {
		carList[5] = new Vehicle();
		carList[0] = new Vehicle(2019, "Ford", "Edge", 4, 20.0, 40);
		carList[1] = new Vehicle(2018, "Audo", "A9", 4, 20.0, 40);
		carList[2] = new Vehicle(2015, "Chevy", "Traverse", 4, 20.0, 40);
		carList[3] = new Vehicle(2010, "Volvo", "S80", 4, 20.0, 40);
		carList[4] = new Vehicle(2012, "Jeep", "Cherokee", 4, 20.0, 40);
	}
		
	public void printCarList() {
		System.out.println("Year       Make        Model");
		System.out.println("---- ---------- ------------");
		for ( int i = 0; i < 5; i++) {
			Vehicle veh = carList[i];
			System.out.println(veh.toFormattedString());
		}
	}
	
	public void printCarListShort() {
		System.out.println("Year       Make        Model");
		System.out.println("---- ---------- ------------");
		for ( Vehicle veh : carList) {
			System.out.println(veh.toFormattedString());
		}
	}
	public void runTests() {
		//int passengers, double kpl, int fuelCap
		Vehicle car1 = new Vehicle(2019, "Ford", "F150", 4, 20.0, 40);
		Vehicle car2 = new Vehicle(2010, "Volvo", "XC70", 5, 22.0, 30);
		
		System.out.println("Car1 is " + car1);
		System.out.println("Car2 is " + car2);
		
		car1.fuelCap = 21;
		//car1 = car2;
		
		//System.out.println("Car1 is " + car1.toFormattedString());
		//System.out.println("Car2 is " + car2.toFormattedString());
		
		//a list that is 10 items long
		Vehicle carList[] = new Vehicle[5];
		}
	
	public void runStrTests() {
		//String quote = "The universe is full of stars";
		String quote = "The universe is FULL";
		
		int len = quote.length();
		int starIndex = quote.indexOf("star");
		
		if (quote.equalsIgnoreCase("The universe is full"))
			System.out.println("No room in the solar system");
		
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VehicleTest VehicleTest = new VehicleTest();
		VehicleTest.runTests();
		VehicleTest.printCarList();
		//VehicleTest.printCarListShort();
		VehicleTest.runStrTests();

	}

}
