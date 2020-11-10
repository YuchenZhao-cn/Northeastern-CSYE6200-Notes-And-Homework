package edu.neu.csye6200.obs;

import java.util.Observable;
import java.util.Observer;

public class EventSubscriber implements Observer{

	public EventSubscriber() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable o, Object msg) {
		
		System.out.println("ES received update from: " + o);
		System.out.println("                message: " + msg);
		
	}

}
