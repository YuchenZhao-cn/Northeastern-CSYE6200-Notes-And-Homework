package edu.neu.csye6200.enumW;

public class EnumTest {
	
	enum WeekDay{
		SUNDAY(0), MONDAY(10), TUESDAY(20), WEDNESDAY(30), THURSDAY(40), FRIDAY(50), SATURDAY(60);
		
		private int value;
		
		WeekDay(int n) {
			value = n;
		}
		
		public void setValue (int value ) { this.value = value; }
		public int getValue() {return value;}
	}
	
	
	
	private WeekDay currDay = WeekDay.SUNDAY;

	public EnumTest() {
		System.out.println("Current day is " + currDay + " ordinal " + currDay.ordinal());
		
		setCurrDay(WeekDay.FRIDAY);
		setCurrDay("SATURDAY");
		
		System.out.println("Day is " + currDay + " ordinal " + currDay.ordinal() + " value " + currDay.getValue());
		
		WeekDay days[] = WeekDay.values();
		for (WeekDay d : days) {
			System.out.println("Day is " + d + " ordinal " + d.ordinal() + " value " + d.getValue());
		}
	}
	
	
	
	public WeekDay getCurrDay() {
		return currDay;
	}



	public void setCurrDay(WeekDay currDay) {
		this.currDay = currDay;
		
		System.out.println("Day is " + currDay + " ordinal " + currDay.ordinal() + " value " + currDay.getValue());
	}
	
	public void setCurrDay(String currDay) {
		this.currDay = WeekDay.valueOf(currDay);

//		System.out.println("Day is " + currDay + " ordinal " + currDay.ordinal() + " value " + currDay.getValue());
	}



	public static void main(String[] args) {
		EnumTest et = new EnumTest();
	}

}
