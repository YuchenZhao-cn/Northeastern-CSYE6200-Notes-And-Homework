package edu.neu.csye6200.obs;

import java.util.Observable;

public class EventPublisher extends Observable{
	
	private int ctr = 0;
	private boolean done = false; //set to true to stop the run method

	public EventPublisher() {
		System.out.println("EventPublisher - we are here");
	}
	
	public void doAction() {
		setChanged();//Something happened
		notifyObservers(new String("A message" + ctr++));
	}
	
	public void run() {
		while(!done) {
			doAction();
			if(ctr > 10)
				done = true;
		}
	}
	
	public static void main(String[] args) {
		EventPublisher ep = new EventPublisher();
		EventSubscriber sub1 = new EventSubscriber();
		ep.addObserver(sub1); // make the subscription
		ep.run();
	}

}
