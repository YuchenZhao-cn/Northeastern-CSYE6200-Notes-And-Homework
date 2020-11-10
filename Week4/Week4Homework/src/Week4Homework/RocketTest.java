package Week4Homework;


public class RocketTest {
	Rocket rocketList[];
	
	public RocketTest() {
		rocketList = new Rocket[10];
		loadSampleRockets();
	}
	//use the ¡®new¡¯ operation with your  Rocket  constructor to generate five instances of a Rocket
	public void loadSampleRockets() {
		rocketList[0] = new Rocket();
		rocketList[1] = new Rocket("Yuchen No.1", "Yuchen.Zhao", 131, 2000, 50, 0, 34000000);
		rocketList[2] = new Rocket("Yuchen No.2", "Yuchen.Zhao", 121, 2100, 48, 0, 35000000);
		rocketList[3] = new Rocket("Yuchen No.3", "Yuchen.Zhao", 111, 2200, 46, 0, 36000000);
		rocketList[4] = new Rocket("Yuchen No.4", "Yuchen.Zhao", 101, 2300, 44, 0, 37000000);
		rocketList[5] = new Rocket("Yuchen No.5", "Yuchen.Zhao",  91, 2400, 42, 0, 38000000);
		
	}
	
	//Add a method to print an attractive display of the  Rocket  information
	public void Print() {
		System.out.println("        Name Manufacturer   Weight/t     Fuel/t  Payload/t TotalWeight/t   Thrust/N");
		System.out.println("------------ ------------ ---------- ---------- ---------- ------------- ----------");
		for ( int i = 1; i < 6; i++) {
			Rocket roc = rocketList[i];
			System.out.println(roc.toFormattedString());
		}
		 
	}
	
	//Add a method to print an attractive display of the  Rocket  information
	public void Print1() {
		Rocket rock = rocketList[0];
		System.out.println(rock.toString());
	}
	
	// Have your  test code print  details about all of the Rockets
	public static void main(String[] args) {
		RocketTest RocketTest = new RocketTest();
		RocketTest.Print1();
		RocketTest.Print();

	}
}
