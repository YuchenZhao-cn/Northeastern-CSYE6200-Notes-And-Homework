package edu.neu.csye6200.iofile;

import java.io.File;

public class FileTest {

	public FileTest() {
	}
	
	public void run() {
		File baseDir = new File(".");
		if (!baseDir.exists())
			baseDir.mkdirs();
		listDir(baseDir);
	}
	
	public void listDir(File dirFile) {
		if(!dirFile.isDirectory()) return;
		System.out.println("Dir: " + dirFile.getAbsolutePath());
		
		for(File file : dirFile.listFiles()) {
			if(file.isDirectory()) continue;
			String fTxt = String.format("%1$32s %2$10d", file.getName(), file.length());
			System.out.println(fTxt);
		}
		
		for (File file : dirFile.listFiles()) {
			if (file.isDirectory())
				listDir(file);//Recursive call to this the
		}
		
	}
	
	public static void main(String[] args) {
		FileTest fileTest = new FileTest();
		fileTest.run();
	}

}
