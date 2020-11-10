package edu.neu.csye6200.lambda;

public class LambdaTest2 {
	
	public interface MyParamValue {
		public double getVal(double v);
	}

	public LambdaTest2() {
		
		MyParamValue mpv2 = new MyParamValue() {
			@Override
			public double getVal(double v) {
				return 30 * v;
			}
		};
		
		System.out.println("The anonymous inner value is " + mpv2.getVal(2.0));
		
		MyParamValue mpv = (n) -> 98.6 * n;
		
		System.out.println("The Lambda value is " + mpv.getVal(2.0));
		
		mpv = (n) -> { return 20.0 * n; };
		
		System.out.println("The Lambda value is " + mpv.getVal(2.0));
		
		mpv = (n) -> 100;
	}
	
	public static void main(String[] args) {
		new LambdaTest2();
	}

}
