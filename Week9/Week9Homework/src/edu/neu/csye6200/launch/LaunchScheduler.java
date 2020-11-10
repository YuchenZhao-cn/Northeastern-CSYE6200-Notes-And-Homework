package edu.neu.csye6200.launch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.*;

public class LaunchScheduler {
	
	private static LaunchScheduler instance = null;
	
	static ArrayList<LaunchEvent> RocketList = new ArrayList<LaunchEvent>();
	
	private static Logger log = Logger.getLogger(LaunchScheduler.class.getName());

	public LaunchScheduler() throws SecurityException, IOException {
		log.info("Constructing a LaunchScheduler instance");
    	Handler handler = new FileHandler("info.log");
    	Logger.getLogger("").addHandler(handler);
	}
	
	public static LaunchScheduler instance() throws SecurityException, IOException {
		if (instance == null) instance = new LaunchScheduler();
		return (instance);
	}
	
	public void add(LaunchEvent lEvent) {
		RocketList.add(lEvent);
	}
	
	public void list() {
		System.out.println("\n------Launch Event List------");
		for (LaunchEvent rocket : RocketList) {
			System.out.println(rocket);
		}
	}
	
	public void run() {
		add(new RocketTest());
		add(new RocketTest("Code Blue", "01/10/1997"));
		add(new RocketTest("Code Green", "03/15/1997"));
		add(new RocketTest("Code Pink", "11/13/1996"));
		add(new RocketTest("Code Yellow", "05/01/1997"));
		add(new RocketTest("Code Brown", "06/22/1995"));
		add(new RocketTest("Code Orange", "11/02/1996"));
		add(new RocketTest("Code Purple", "12/15/1998"));
		add(new RocketTest("Code Black", "04/01/1997"));
		add(new RocketTest("Code Grey", "10/07/1996"));
		list();
		
//		RocketList.remove(8);
//		list();
	}
	
	public static <V> boolean isEmpty(ArrayList<V> sourceList) {
        return (sourceList == null || sourceList.size() == 0);
    }
	
    public static <V> ArrayList<V> randomList(ArrayList<V> sourceList){
    	if (isEmpty(sourceList)) {
            return sourceList;
        }
    	
    	ArrayList<V> randomList = new ArrayList<V>(sourceList.size());
    	do{
    		int randomIndex = Math.abs(new Random().nextInt(sourceList.size()));
        	randomList.add(sourceList.remove(randomIndex));
    	}while(sourceList.size() > 0);
    	return randomList;
    }
    
    public static <V> void quickSort(ArrayList<V> n) {
    	if (isEmpty(n)) 
    		return;
    	quickSort(n, 0, n.size() - 1);
    }
    
    public static <V> void quickSort(ArrayList<V> n, int l, int h) {
    	if (isEmpty(n))
    		return;
    	if (l < h) {
    		int pivot = partion(n, l, h);
    		quickSort(n, l, pivot - 1);
    		quickSort(n, pivot + 1, h);
    	}
    }
    
    private static <V> int partion(ArrayList<V> n, int start, int end) {
    	ArrayList<LaunchEvent> tmp = new ArrayList<LaunchEvent>();
    	tmp.add(new RocketTest());
    	tmp.set(0, (LaunchEvent) n.get(start));
    	while(start < end) {
    		while (((LaunchEvent) n.get(end)).getID() >= ((LaunchEvent) tmp.get(0)).getID() && start < end)
    			end--;
    		if (start < end) {
    			n.set(start++, n.get(end));
    		}
    		while (((LaunchEvent) n.get(start)).getID() < ((LaunchEvent) tmp.get(0)).getID() && start < end)
    			start++;
    		if (start < end) {
    			n.set(end--, n.get(start));
    		}
    	}
    	n.set(start, (V) tmp.get(0));
    	return start;
    }
    
    public double simulation(int i) {
    	double M, m, dm, t, dt, g, a = 0, F, s = 0, v = 0, Totalm = 0;
    	M = RocketTest.rocketList[i].getWeight() * 1000 + RocketTest.rocketList[i].getPayloadWeight() * 1000;
    	m = RocketTest.rocketList[i].getFuelWeight() * 1000;
    	F = RocketTest.rocketList[i].getEngineThrust();
    	dt = 1;
    	dm = dt * 2000;
    	g = 9.8;
    	for (t = 0; t < dt * m / dm; t = t + dt) {
    		a = (F - M * g) / (M + m - Totalm) - g;
    		if (a > 0) {
    			v += a * dt;
    			s += v * dt;
    		}
    		Totalm += dm;
    	}
    	s += v * v / g - 1 / 2 * g * (v / g) * (v / g);
    	return s;
    }
    
    public static void main(String[] args) {
    	
    }
	
}
