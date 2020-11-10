package edu.neu.csye6200.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public FileWriterTest() {
	}
	
	public void run() {
		String base = "src/edu/neu/csye6200/io/";
		try {
			FileReader reader = new FileReader(base + "FileWriterTest.java");
			FileWriter writer = new FileWriter(base + "FWDuplicate.txt");
			
			int inVal = reader.read();
			while(inVal >= 0) {
				System.out.print(" ");
				System.out.print( (char) inVal);
				writer.write(" " + (char) inVal);
				inVal = reader.read();
			}
			reader.close();
			writer.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FileWriterTest demo = new FileWriterTest();
		demo.run();
	}

}
