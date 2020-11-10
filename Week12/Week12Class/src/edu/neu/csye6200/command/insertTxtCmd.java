package edu.neu.csye6200.command;

public class insertTxtCmd extends Command {
	
	private String inputTxt = "";
	private int insertIndex = 0;

	public insertTxtCmd(StringBuffer doc, String inputTxt, int insertIndex) {
		super(doc);
		
		this.inputTxt = inputTxt;
		this.insertIndex = insertIndex;
	}

	@Override
	public void execute() {
		doc.insert(insertIndex, inputTxt);

	}
	
	@Override
	public void undo() {
		if (inputTxt == null) return;
		int endIndex = insertIndex + inputTxt.length();
		doc.delete(insertIndex, endIndex);
	}

}
