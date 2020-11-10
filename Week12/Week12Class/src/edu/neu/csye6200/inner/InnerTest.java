package edu.neu.csye6200.inner;

public class InnerTest {
	
	private int key =20;
	
	public class InnerProc{
		public String encode(String input) {
			StringBuffer sb = new StringBuffer();
			
			for( char c : input.toCharArray()) {
				char c2 = (char) (c ^ key); // XOR
				sb.append(c2);
			}
			
			return sb.toString();
		}
	}

	public InnerTest(int key) {
		this.key = key;
		
		InnerProc iproc = new InnerProc();
		String str0 = "My super secret message 123";
		System.out.println("Str0: " + str0);
		
		String str1 = iproc.encode(str0);
		System.out.println("Str1: " + str1);
		
		String str2 = iproc.encode(str1);
		System.out.println("Str1: " + str2);
		
	}
	
	public static void main (String[] args) {
		InnerTest inTest = new InnerTest(30);
		
	}

}
