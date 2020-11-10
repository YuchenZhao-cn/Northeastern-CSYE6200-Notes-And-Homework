package edu.neu.csye6200.inherit;

import java.util.HashMap;

public class HashTest {
	
	private HashMap<String, PetAnimal> myMap = new HashMap<String, PetAnimal>();

	public HashTest() {
		
		Dog pet1 = new Dog("Thor");
		Dog pet2 = new Dog("Fenja");
		
		myMap.put(pet1.getName(), pet1);
		myMap.put(pet2.getName(), pet2);
		
		if (myMap.containsKey("Fenja")) 
			System.out.println("We found Fenja: " + myMap.get("Fenja"));
	}

	public static void main(String[] args) {
		new HashTest();
		// TODO Auto-generated method stub

	}

}
