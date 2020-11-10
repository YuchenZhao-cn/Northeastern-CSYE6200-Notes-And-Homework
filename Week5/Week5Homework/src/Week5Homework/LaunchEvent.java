package Week5Homework;

public class LaunchEvent {
	
	private int ID;
	private String MissionName;
	private String LaunchDate;
	public static int idCounter;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}
	
	public String getMissionName() {
		return MissionName;
	}

	public void setMissionName(String missionName) {
		this.MissionName = missionName;
	}

	public String getLaunchDate() {
		return LaunchDate;
	}

	public void setLaunchDate(String launchDate) {
		this.LaunchDate = launchDate;
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		LaunchEvent.idCounter = idCounter;
	}
	
	public LaunchEvent() {
		MissionName = "Code Red";
		LaunchDate = "10/08/1996";
		ID = idCounter++;
	}
	
	static {
		System.out.println("Setting idCounter");
		idCounter = 0;
	}
	
	public String toString() {
		return String.format("MissionName: %1$-12s LaunchDate: %2$-12s ID: %3$-4d", getMissionName(), getLaunchDate(), getID());
	}
	

}
