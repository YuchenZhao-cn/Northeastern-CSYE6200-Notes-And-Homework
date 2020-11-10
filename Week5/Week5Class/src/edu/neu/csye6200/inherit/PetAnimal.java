package edu.neu.csye6200.inherit;

public class PetAnimal {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		PetAnimal.idCounter = idCounter;
	}

	private static int idCounter = 0;// a static counter
	private int age = 1;
	private String name;
	
	//static code block
	static {
		System.out.println("Setting idCounter");
		idCounter = 10;
	}
	
	public PetAnimal() {
		name = "unknown";
		id = idCounter++;// assign and advance by 1
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getage() {
		return age;
	}
	
	public void setAge(String str) {
		age = Integer.valueOf(str);
	}
	
	public String toString() {
		return ("Pet name:" + getName() + " ID:" + getId());
	}
	
	public void bark() {
		System.out.println("Bark");
	}
	
	public void walk() {
		System.out.println("we are walking");
	}

}
