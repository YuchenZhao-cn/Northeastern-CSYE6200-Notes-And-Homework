package edu.neu.csye6200.launch;

import java.io.IOException;

public class RocketTest extends LaunchEvent{
	static Rocket rocketList[];
	
	public int Stages;
	
	public RocketTest (String name, String launchDate) {
		setMissionName(name);
		setLaunchDate(launchDate);
	}
	
	public RocketTest() {
		rocketList = new Rocket[10];
		loadSampleRockets();
	}
	
	
	//use the ¡®new¡¯ operation with your  Rocket  constructor to generate five instances of a Rocket
	public void loadSampleRockets() {
		rocketList[0] = new Rocket();
		rocketList[1] = new Rocket("Yuchen No.1", "Yuchen.Zhao", 131, 2000, 50, 0, 10);
		rocketList[2] = new Rocket("Yuchen No.2", "Yuchen.Zhao", 121, 2100, 48, 0, 5000000);
		rocketList[3] = new Rocket("Yuchen No.3", "Yuchen.Zhao", 111, 2200, 46, 0, 36000000);
		rocketList[4] = new Rocket("Yuchen No.4", "Yuchen.Zhao", 101, 2300, 44, 0, 37000000);
		rocketList[5] = new Rocket("Yuchen No.5", "Yuchen.Zhao",  91, 2400, 42, 0, 38000000);
		
	}
	
	//Add a method to print an attractive display of the  Rocket  information
	public void Print() {
		System.out.println("        Name Manufacturer   Weight/t     Fuel/t  Payload/t TotalWeight/t   Thrust/N");
		System.out.println("------------ ------------ ---------- ---------- ---------- ------------- ----------");
		for ( int i = 0; i < 6; i++) {
			Rocket roc = rocketList[i];
			System.out.println(roc.toFormattedString());
		}
	}
	
	//Add a method to print an attractive display of the  Rocket  information
	public void Print1() {
		Rocket rock = rocketList[0];
		System.out.println(rock.toString());
	}
	
	public static void run() {
		RocketTest rocketTest = new RocketTest();
		rocketTest.Print1();
		rocketTest.Print();
	}

	// Have your  test code print  details about all of the Rockets
	public static void main(String[] args) throws SecurityException, IOException {
		RocketTest.run();
		LaunchScheduler launchscheduler = LaunchScheduler.instance();
		launchscheduler.run();
		System.out.println("\n------Out of Order------");
	    LaunchScheduler.RocketList = LaunchScheduler.randomList(LaunchScheduler.RocketList);
	    for(int i = 0; i < 10; i++) {
	    	System.out.println(LaunchScheduler.RocketList.get(i));
	    }
	    LaunchScheduler.quickSort(LaunchScheduler.RocketList);
		System.out.println("\n------After Sorting------");
	    for(int i = 0; i < 10; i++) {
	    	System.out.println(LaunchScheduler.RocketList.get(i));
	    }
		System.out.println("\n------Calculating the Height for the Rockets(dt=1sec)------");
	    for (int i = 0; i < 6; i++)
	    	System.out.println(String.format("Height for Rocket \"Yuchen No.%1$1d\":%2$10.2f km", i, launchscheduler.simulation(i)/1000));
	    System.out.println("*The second one is the one that can never launch and the third one is the one that stays on the launchpad at first.");
	}
}
