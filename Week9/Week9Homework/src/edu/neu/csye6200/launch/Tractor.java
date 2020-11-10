package edu.neu.csye6200.launch;

import java.io.IOException;

public class Tractor {

	private Rocket[] rockets;

    Tractor(int n){
        this.rockets = new Rocket[n];
    }

    public void load() throws IOException{
        RocketIO rocketIO = new RocketIO();
        rocketIO.load("Rockets.txt");
    }

    public Rocket[] getRockets() {
        return rockets;
    }

}
