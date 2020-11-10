package Week5Homework;

import java.util.HashMap;

public class HashTest {
	
	private HashMap<Integer, LaunchEvent> myMap = new HashMap<Integer, LaunchEvent>();

	public HashTest() {
		
		LaunchEvent.idCounter = 1;
		
		LaunchEvent mission0 = new RocketTest();
		LaunchEvent mission1 = new RocketTest("Code Blue", "01/10/1997");
		LaunchEvent mission2 = new RocketTest("Code Black", "04/01/1997");
		LaunchEvent mission3 = new RocketTest("Code Green", "03/15/1997");
		LaunchEvent mission4 = new RocketTest("Code Pink", "11/13/1996");
		LaunchEvent mission5 = new RocketTest("Code Yellow", "05/01/1997");
		
		myMap.put(mission0.getID(), mission0);
		myMap.put(mission1.getID(), mission1);
		myMap.put(mission2.getID(), mission2);
		myMap.put(mission3.getID(), mission3);
		myMap.put(mission4.getID(), mission4);
		myMap.put(mission5.getID(), mission5);
		
		if (myMap.containsKey(1))
			System.out.println("We found 1: " + myMap.get(1));
		
		if (myMap.containsKey(2)) 
			System.out.println("We found 2: " + myMap.get(2));
		
		if (myMap.containsKey(3)) 
			System.out.println("We found 3: " + myMap.get(3));
		
		if (myMap.containsKey(4)) 
			System.out.println("We found 4: " + myMap.get(4));
		
		if (myMap.containsKey(5)) 
			System.out.println("We found 5: " + myMap.get(5));
		
		if (myMap.containsKey(6)) 
			System.out.println("We found 6: " + myMap.get(6));
	}

	public static void main(String[] args) {
		new HashTest();
	}

}
