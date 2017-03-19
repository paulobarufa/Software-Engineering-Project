package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadCSV {
	
	
	//http://stackoverflow.com/questions/18033750/read-one-line-of-a-csv-file-in-java
	//https://www.youtube.com/watch?v=3_40oiUdLG8
	
	public static void main(String[] args){
		
		readResultsCSV("data.csv",7);
		readTopicCSV("questions.csv");
		readSessionDetails("data.csv");
		
		
	}
		
	//read CSV and return a list of strings
	
		public static int[] readResultsCSV(String filename, int qnNumber){
		
			int[] returnList = new int[4];
			String qnString = null;
			File file = new File(filename);
			
			//variables to create a new array of correct, incorrect and not attempted for PieChart
			int correct = 0;
			int incorrect = 0;
			int notAttempted = 0;
			
	
			try {
				Scanner scanner = new Scanner(file);
				scanner.nextLine();
				while (scanner.hasNextLine()){
					String data = scanner.nextLine();
					String [] results = data.split(",");
					
					
					switch (qnNumber){					
					case 1: qnString = results[0]; break;
					case 2: qnString = results[1]; break;
					case 3: qnString = results[2]; break;					
					case 4: qnString = results[3]; break;		
					case 5: qnString = results[4]; break;
					case 6: qnString = results[5]; break;
					case 7: qnString = results[6]; break;
					case 8: qnString = results[7]; break;
					case 9: qnString = results[8]; break;
					case 10: qnString = results[9]; break;
					default: System.out.println("that is not a valid question number"); break;
					}
				    
				    switch (qnString){
				    case "0": notAttempted +=1; break;
				    case "1": correct +=1; break;
				    case "2": incorrect +=1; break;
				    
				    }
	
				}
				  
				  returnList[0] = correct;
				  returnList[1] = incorrect;
				  returnList[2] = notAttempted;
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return returnList;}



		//Method to get overview of session results
		public static int[] readOverallResultsCSV(String filename){
			
			int[] returnList = new int[4];
			String qnString = null;
			File file = new File(filename);
			
			//variables to create a new array of correct, incorrect and not attempted for PieChart
			int correct = 0;
			int incorrect = 0;
			int notAttempted = 0;
			
	
			try {
				Scanner scanner = new Scanner(file);
				scanner.nextLine();
				while (scanner.hasNextLine()){
					String data = scanner.nextLine();
					String [] results = data.split(",");
					
					for (int i = 0; i<results.length; i++ ){
						String result = results[i];
						
					    switch (result){
					    case "0": notAttempted +=1; break;
					    case "1": correct +=1; break;
					    case "2": incorrect +=1; break;
					    
					    }
					}
					 
				}
				 
				returnList[0] = correct;
				returnList[1] = incorrect;
				returnList[2] = notAttempted;
					
			
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return returnList;}
			
			
		//Method to read session details
		public static String[] readSessionDetails(String fileName){
			
			int[] returnList = new int[4];
			String qnString = null;
			File file = new File(fileName);
					
	
			try {
				Scanner scanner = new Scanner(file);
				String data = scanner.nextLine();
				String [] results = data.split(",");
				   
					    	
				return results;
				
				}catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return null;
					
				
		}

			
		
		
		
		
	//read CSV and return a list of strings ---- Still needs work 
	
			public static String readTopicCSV(String filename){
			
				int[] returnList;
				String topicString = null;
				File file = new File(filename);
				
			
				try {
					Scanner scanner = new Scanner(file);
					while (scanner.hasNextLine()){
						String data = scanner.nextLine();
						String [] results = data.split(",");	
					
					topicString = results[0];
					System.out.println(topicString);	
					
						}
							
					  				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return topicString;
				
			}
			
			
			public static void writeToCSV(String[] sessionDetails) throws IOException{
				
				FileWriter fw = new FileWriter("newData.csv");
				BufferedWriter bw = new BufferedWriter(fw);
				

				String writableString = "";
				
				for (String item: sessionDetails){
					writableString += item +",";
				}

			
				writableString = writableString.substring(0, writableString.length() -1);
			
				bw.write(writableString);
				bw.close();
			}
		}
					
			
		

