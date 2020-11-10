package edu.neu.csye6200.inherit;

import java.util.ArrayList;

public class Kennel {
	
	//private ArrayList<PetAnimal> petList;
	private ArrayList<PetAnimal> petList = new ArrayList<PetAnimal>();

	public Kennel() {
		//petList = new ArrayList<PetAnimal>();
	}
	
	// Do work here
	public void run() {
		/*Dog d1 = new Dog("Thor");
		Dog d2 = new Dog("Fenja");
		Dog d3 = new Dog("Fido");
		
		petList.add(d1);
		petList.add(d2);
		petList.add(d3);
		*/
		
		add(new Dog ("Thor"));
		add(new Dog ("Fenja"));
		add(new Dog ("Fido"));
		
		list();
		
		petList.remove(1);
		list();
		
	}
	
	public void add(PetAnimal pAnimal) {
		petList.add(pAnimal);
	}
	/*
	 * List all of the pets to the console
	 */
	public void list() {
		System.out.println("----Pet List----");
		for (PetAnimal pet : petList) {
			System.out.println("Pet: " + pet);
		}
	}

}
