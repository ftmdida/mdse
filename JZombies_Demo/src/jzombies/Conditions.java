package jzombies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Conditions {
	
	public boolean checkProtocol(Protocol protocol){
		boolean check=true;
		if(protocol.getStatusCode()!=Protocol.HTTP.getStatusCode()){
			check=false;
		}
		return check;
	}
	
	 public  boolean checkHttpRequestBody(String data) {
				boolean check=true;
				//data = new Scanner( new File("/Users/neda/Documents/Rworkspace/HttpRequest/src/data.txt") ).useDelimiter("\\A").next();
				if(data.contains("POST")){
					   check=checkForPostRequest(data);
				}
				else {
					  check=checkForGetRequest(data);
				}
				return check;
		}
	public static boolean checkForGetRequest(String text) {
		String[] arr = text.split("\n");
		  String[] body;
		  boolean check=true;
		    if (arr != null) {
		        body=arr[arr.length - 1].split("&");
		        
		        for (String string : body) {
		        	if(checkForSpecialCharacters(string)){
		        		System.out.println("Problem in Get Request");
		        		check = false;
		        	}
		        	
		        }      
		    }
		return check;
	}
	
	public static boolean checkForPostRequest(String text) {
		String[] arr = text.split("\n");
		  String[] body;
		  boolean check=true;
		    if (arr != null) {
		        body=arr[arr.length - 1].split("&");
		        
		        for (String string : body) {
		        	if (checkForSpecialCharacters(string)==false | checkForLength(string)==false){
		        		check=false;
		        	}  	
		        }  
		    }
		    return check;
	}
	
	public static boolean checkForLength(String string) {
		boolean check=true;
		if(string.length()>20){
			System.out.println("Its length is greater than 20 characters");
			check = false;
		}
		return check;
		
	}
	
	public static boolean  checkForSpecialCharacters(String string) {
		String sCurrentLine;
		BufferedReader br = null;
		boolean check=true;
		try {
		
		br = new BufferedReader(new FileReader("/Users/neda/Documents/Rworkspace/HttpRequest/src/SQLInjectionCheatSheet.txt"));
		while ((sCurrentLine = br.readLine()) != null) {
			
			if(string.contains(sCurrentLine)){
				
				System.out.println("It has special characters");
				check=false;
			}
		}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return check;
	} 
}
