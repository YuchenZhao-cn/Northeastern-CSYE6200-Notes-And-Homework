package edu.neu.csye6200.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HTTPUrlConnectTest {
	
	private URL url = null;
	private HttpURLConnection con = null;

	public HTTPUrlConnectTest(String urlStr) {
		
		try {
			url = new URL(urlStr);
			con = (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int sendGetRequest() throws IOException {
		con.setRequestMethod("Get");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		System.out.println("Sending get to url " + url);
		
		return con.getResponseCode();
	}
	
	// From an open GET connection, read the response
	public String getResponse() throws IOException {
		BufferedReader inBuf = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String inLine;
		StringBuffer sb = new StringBuffer();
		
		// Loop around reading string input
		while( (inLine = inBuf.readLine()) != null);{
			sb.append(inLine);// add it to the buffer
		}
		inBuf.close();// We're done, so close the buffer
		
		return sb.toString();
	}
	
	public static void main (String[] args) throws IOException {
		HTTPUrlConnectTest httpCon = new HTTPUrlConnectTest("http://www.google.com/search?q=dog");
		
		int respCode = httpCon.sendGetRequest();
		System.out.println(">>> GET Response Code is " + respCode);
		System.out.println(">>> Response string is: ");
		String resp = httpCon.getResponse();
		System.out.println(resp);
	}

}
