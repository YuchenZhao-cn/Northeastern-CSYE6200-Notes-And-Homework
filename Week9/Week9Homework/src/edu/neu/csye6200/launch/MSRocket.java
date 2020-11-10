package edu.neu.csye6200.launch;
	
public class MSRocket extends Rocket {
	
	RocketTest rocketTest;
	
	public MSRocket() {
		this.rocketTest = new RocketTest();
		AddStages(0,2,0);
		AddStages(1,3,0);
		AddStages(2,4,0);
		AddStages(3,5,0);
		AddStages(4,6,0);
		AddStages(5,7,0);
		
		for (int i = 0; i < 6; i++) {
			RocketTest.rocketList[i].TotalWeight = RocketTest.rocketList[i].WeightOnLaunchPad();
		}
	}
	
	public void AddStages(int number, int Stages, int TotalWeight) {
		TotalWeight = super.WeightOnLaunchPad();
		RocketTest.rocketList[number].Stages = Stages;
		RocketTest.rocketList[number].TotalWeight = TotalWeight;
	}
	
	public void run3() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("Name: " + RocketTest.rocketList[i].Name + "; Stages: " + RocketTest.rocketList[i].Stages + "; TotalWeight: " + RocketTest.rocketList[i].TotalWeight);
		}
	}
	
	public static void main(String[] args) {
		MSRocket msRocket = new MSRocket();
		msRocket.run3();
	}

}
