package edu.neu.csye6200.inherit;

public class Dog extends PetAnimal {

	// Constructor
	public Dog() {
	}
	
	public Dog(String name) {
		setName(name);
	}
	
	public void bark() {
		System.out.println("Bark");
	}
	
	public String toString() {
		return ("Dog name:" + getName() + " ID: " + getId());
	}
	
	
	public static void main(String[] args) {
		
		Dog dog = new Dog("Thor");
		System.out.println("dog");
		System.out.println("dog's name is:" + dog.getName());
		
		dog.walk();
		dog.bark();
		System.out.println("My dog's Age is:" + dog.getAge());
		
		PetAnimal pet = new PetAnimal();
		pet.setAge("9");
		pet.walk();
		System.out.println(pet);
		
		Kennel kennel = new Kennel();
		kennel.run();
		//System.out.println("Dog name:" + dog.getName());
		//dog.name = "Scott";
	}
	
	
}
