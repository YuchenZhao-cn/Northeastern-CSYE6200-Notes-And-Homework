package Week5Homework;

import java.util.ArrayList;

public class LaunchScheduler {
	
	private ArrayList<LaunchEvent> RocketList = new ArrayList<LaunchEvent>();

	public LaunchScheduler() {
	}
	
	public void add(LaunchEvent lEvent) {
		RocketList.add(lEvent);
	}
	
	public void list() {
		System.out.println("\n------Launch Event List------");
		for (LaunchEvent rocket : RocketList) {
			System.out.println("Rocket: " + rocket);
		}
	}
	
	public void run() {
		add(new RocketTest());
		add(new RocketTest("Code Blue", "01/10/1997"));
		add(new RocketTest("Code Black", "04/01/1997"));
		add(new RocketTest("Code Green", "03/15/1997"));
		add(new RocketTest("Code Pink", "11/13/1996"));
		add(new RocketTest("Code Yellow", "05/01/1997"));
		list();
		
		RocketList.remove(2);
		list();
	}

}
