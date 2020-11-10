package edu.neu.csye6200.command;

public class CmdTest {
	
	private StringBuffer textDoc = new StringBuffer();

	public CmdTest() {
		
		textDoc.append("Initial String");
		
		insertTxtCmd itc = new insertTxtCmd(textDoc, "ABC123", 8);
		
		System.out.println("Before insert textDoc: " + textDoc.toString());
		itc.execute();
		itc.execute();
		System.out.println("After insert textDoc: " + textDoc.toString());
		
		itc.undo();
		System.out.println("After undo1 textDoc: " + textDoc.toString());
		itc.undo();
		System.out.println("After undo2 textDoc: " + textDoc.toString());
		
	}
	
	public static void main(String[] args) {
		CmdTest cmdTest = new CmdTest();
	}

}
