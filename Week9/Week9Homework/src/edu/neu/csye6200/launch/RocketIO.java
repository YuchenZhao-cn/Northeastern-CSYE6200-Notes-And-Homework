package edu.neu.csye6200.launch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.*;



public class RocketIO {
	
	public static File Rocket;
	public static File Rockets;

	private static Logger log = Logger.getLogger(RocketIO.class.getName());

	public RocketIO() throws SecurityException, IOException {
		log.info("Constructing a RocketIO instance");
    	Handler handler = new FileHandler("info.log");
    	Logger.getLogger("").addHandler(handler);
	}
	
	private void save(Rocket rocket, File file) throws IOException {
        try {
    		log.info("Constructing a Save instance");
    		File Rocket = new File("A Rocket.txt");
            Rocket.createNewFile(); 
            FileWriter writer = new FileWriter(Rocket);
            writer.write(rocket.toString() + " Stages: " + RocketTest.rocketList[0].Stages + " TotalWeight: " + RocketTest.rocketList[0].TotalWeight + "]");
            writer.close();
        } catch (FileNotFoundException e) {
        	log.severe("FileNotFoundException");
        	Handler handler = new FileHandler("server.log");
        	Logger.getLogger("").addHandler(handler);
			e.printStackTrace();
		} catch (IOException e) {
        	log.severe("IOException");
        	Handler handler = new FileHandler("server.log");
        	Logger.getLogger("").addHandler(handler);
			e.printStackTrace();
		}
    }
	
	public void save(Rocket[] rocketList, File file) throws IOException {
		try {
    		log.info("Constructing a Save instance");
			File Rockets = new File("Rockets.txt");
			Rockets.createNewFile();
			FileWriter writer = new FileWriter(Rockets);
			for (int i = 0 ; i < 6; i++) {
				writer.write(rocketList[i].toString() + " Stages: " + rocketList[i].Stages + " TotalWeight: " + rocketList[i].TotalWeight + "]\n");
			}
	        writer.close();
        } catch (FileNotFoundException e) {
        	log.severe("FileNotFoundException");
        	Handler handler = new FileHandler("server.log");
        	Logger.getLogger("").addHandler(handler);
			e.printStackTrace();
		} catch (IOException e) {
        	log.severe("IOException");
        	Handler handler = new FileHandler("server.log");
        	Logger.getLogger("").addHandler(handler);
			e.printStackTrace();
		}
		
	}
	
	public void load(String file) throws IOException {
		try {
    		log.info("Constructing a Load instance");
			FileReader reader = new FileReader(file);
			File file1 = new File(file);
			char[] a = new char[(int) file1.length()];
			reader.read(a);
			for (char c : a)
				System.out.print(c);
			reader.close();
        } catch (FileNotFoundException e) {
        	log.severe("FileNotFoundException");
        	Handler handler = new FileHandler("server.log");
        	Logger.getLogger("").addHandler(handler);
			e.printStackTrace();
		} catch (IOException e) {
        	log.severe("IOException");
        	Handler handler = new FileHandler("server.log");
        	Logger.getLogger("").addHandler(handler);
			e.printStackTrace();
		}
		
	}
	
	public static void tractor(int n) throws IOException{
        Tractor tractor = new Tractor(n);
        tractor.load();
        for (Rocket rocket : tractor.getRockets()) {
            System.out.println(rocket.toString());
        }
    }
	
	public static void main(String[] args) throws IOException {
		new RocketTest();
		new MSRocket();
		RocketIO demo = new RocketIO();
		Rocket rocket = new Rocket();
		demo.save(rocket, Rocket);
		System.out.println("A Single Rocket:");
		demo.load("A Rocket.txt");
 		System.out.println("\n");
		demo.save(RocketTest.rocketList, Rockets);
		System.out.println("------------------------------------------------");
		System.out.println("Rockets:");
		demo.load("Rockets.txt");
		System.out.println("");
		System.out.println("------------------------------------------------");
		System.out.println("Tractor:");
		tractor(0);
	}

}
