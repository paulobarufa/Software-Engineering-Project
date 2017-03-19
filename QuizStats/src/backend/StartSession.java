package backend;

import jxl.Workbook;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StartSession {
	
	
	//method to create new workbook

		public static WritableWorkbook createFile(String fileName) throws IOException, WriteException{
			
			try {		
				
				WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
				
				return workbook;
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}



  // method to collect session details
	
	public static WritableSheet writeSessionDetails(WritableWorkbook wb, String date, String event, String yrGroup, String quizPlayed) throws RowsExceededException, WriteException{
		
			
		//Create sheet		
			WritableSheet sheet = wb.createSheet(date, 0);
			
		//create session information headings
			Label dateHeading = new Label(0,0,"Date"); 
			sheet.addCell(dateHeading);
			Label schoolHeading = new Label(1,0,"School"); 
			sheet.addCell(schoolHeading);
			Label yearGroupHeading = new Label(2,0,"Year Group"); 
			sheet.addCell(yearGroupHeading);
			Label quizName = new Label(3,0,"Quiz Name"); 
			sheet.addCell(quizName);
			
		//Creating question headings
			Label QnHeading = new Label(0,3,"Qn Number");
			sheet.addCell(QnHeading);	
			Number Qn1 = new Number(0,4,1); 
			sheet.addCell(Qn1);
			Number Qn2 = new Number(0,5,2); 
			sheet.addCell(Qn2);				
			Number Qn3 = new Number(0,6,3); 
			sheet.addCell(Qn3);	
			Number Qn4 = new Number(0,7,4); 
			sheet.addCell(Qn4);
			Number Qn5 = new Number(0,8,5); 
			sheet.addCell(Qn5);
			Number Qn6 = new Number(0,9,6); 
			sheet.addCell(Qn6);
			Number Qn7 = new Number(0,10,7); 
			sheet.addCell(Qn7);
			Number Qn8 = new Number(0,11,8); 
			sheet.addCell(Qn8);
			Number Qn9 = new Number(0,12,9); 
			sheet.addCell(Qn9);
			Number Qn10 = new Number(0,13,10); 
			sheet.addCell(Qn10);
			
		//Create results headings
			Label QnAttempted = new Label(1,3,"Not Attempted");
			sheet.addCell(QnAttempted);
			Label PercAttempted = new Label(2,3,"% Not Attempted");
			sheet.addCell(PercAttempted);
			Label QnCorrect = new Label(3,3, "Correct");
			sheet.addCell(QnCorrect);
			Label PercCorrect = new Label(4,3, "% Correct");
			sheet.addCell(PercCorrect);
			Label Incorrect = new Label(5,3, "Incorrect");
			sheet.addCell(Incorrect);
			Label PercIncorrect = new Label(6,3, "% Incorrect");
			sheet.addCell(PercIncorrect);
		

			
			Label currentDate = new Label(0,1, date);  
			sheet.addCell(currentDate);
			Label school = new Label(1,1, event);
			sheet.addCell(school);
			Label yearGroup = new Label(2,1, yrGroup); 
			sheet.addCell(yearGroup);
			Label quiz = new Label(3,1, quizPlayed);
			sheet.addCell(quiz);
			return sheet;
	}
	 
	     public static void writeSessionResults(WritableSheet sheet, String fileName) throws RowsExceededException, WriteException{
	    	 int[] Qn1Results = ReadCSV.readResultsCSV(fileName, 1);
	    	 int[] Qn2Results = ReadCSV.readResultsCSV(fileName, 2);
	    	 int[] Qn3Results = ReadCSV.readResultsCSV(fileName, 3);
	    	 int[] Qn4Results = ReadCSV.readResultsCSV(fileName, 4);
	    	 int[] Qn5Results = ReadCSV.readResultsCSV(fileName, 5);
	    	 int[] Qn6Results = ReadCSV.readResultsCSV(fileName, 6);
	    	 int[] Qn7Results = ReadCSV.readResultsCSV(fileName, 7);
	    	 int[] Qn8Results = ReadCSV.readResultsCSV(fileName, 8);
	    	 int[] Qn9Results = ReadCSV.readResultsCSV(fileName, 9);
	    	 int[] Qn10Results = ReadCSV.readResultsCSV(fileName, 10);
	    	 
	    	 
		    	 Number Qn1Correct = new Number(3,4, Qn1Results[0]);
				 sheet.addCell(Qn1Correct);
			     Number Qn2Correct = new Number(3,5, Qn2Results[0]);
				 sheet.addCell(Qn2Correct);				
				 Number Qn3Correct = new Number(3,6, Qn3Results[0]);
				 sheet.addCell(Qn3Correct);		   
				 Number Qn4Correct = new Number(3,7, Qn4Results[0]);
				 sheet.addCell(Qn4Correct);
				 Number Qn5Correct = new Number(3,8, Qn5Results[0]);
				 sheet.addCell(Qn5Correct);
				 Number Qn6Correct = new Number(3,9, Qn6Results[0]);
				 sheet.addCell(Qn6Correct);
				 Number Qn7Correct = new Number(3,10, Qn7Results[0]);
				 sheet.addCell(Qn7Correct);
				 Number Qn8Correct = new Number(3,11, Qn8Results[0]);
				 sheet.addCell(Qn8Correct);
				 Number Qn9Correct = new Number(3,12, Qn9Results[0]);
				 sheet.addCell(Qn9Correct);
				 Number Qn10Correct = new Number(3,13, Qn10Results[0]);
				 sheet.addCell(Qn10Correct);
				 
		    	 Number Qn1Incorrect = new Number(5,4, Qn1Results[1]);
				 sheet.addCell(Qn1Incorrect);
			     Number Qn2Incorrect = new Number(5,5, Qn2Results[1]);
				 sheet.addCell(Qn2Incorrect);				
				 Number Qn3Incorrect = new Number(5,6, Qn3Results[1]);
				 sheet.addCell(Qn3Incorrect);		   
				 Number Qn4Incorrect = new Number(5,7, Qn4Results[1]);
				 sheet.addCell(Qn4Incorrect);
				 Number Qn5Incorrect = new Number(5,8, Qn5Results[1]);
				 sheet.addCell(Qn5Incorrect);
				 Number Qn6Incorrect = new Number(5,9, Qn6Results[1]);
				 sheet.addCell(Qn6Incorrect);
				 Number Qn7Incorrect = new Number(5,10, Qn7Results[1]);
				 sheet.addCell(Qn7Incorrect);
				 Number Qn8Incorrect = new Number(5,11, Qn8Results[1]);
				 sheet.addCell(Qn8Incorrect);
				 Number Qn9Incorrect = new Number(5,12, Qn9Results[1]);
				 sheet.addCell(Qn9Incorrect);
				 Number Qn10Incorrect = new Number(5,13, Qn10Results[1]);
				 sheet.addCell(Qn10Incorrect);
				 
		    	 Number Qn1NotAttempted = new Number(1,4, Qn1Results[2]);
				 sheet.addCell(Qn1NotAttempted);
			     Number Qn2NotAttempted = new Number(1,5, Qn2Results[2]);
				 sheet.addCell(Qn2NotAttempted);				
				 Number Qn3NotAttempted = new Number(1,6, Qn3Results[2]);
				 sheet.addCell(Qn3NotAttempted);		   
				 Number Qn4NotAttempted = new Number(1,7, Qn4Results[2]);
				 sheet.addCell(Qn4NotAttempted);
				 Number Qn5NotAttempted = new Number(1,8, Qn5Results[2]);
				 sheet.addCell(Qn5NotAttempted);
				 Number Qn6NotAttempted = new Number(1,9, Qn6Results[2]);
				 sheet.addCell(Qn6NotAttempted);
				 Number Qn7NotAttempted = new Number(1,10, Qn7Results[2]);
				 sheet.addCell(Qn7NotAttempted);
				 Number Qn8NotAttempted = new Number(1,11, Qn8Results[2]);
				 sheet.addCell(Qn8NotAttempted);
				 Number Qn9NotAttempted = new Number(1,12, Qn9Results[2]);
				 sheet.addCell(Qn9NotAttempted);
				 Number Qn10NotAttempted = new Number(1,13, Qn10Results[2]);
				 sheet.addCell(Qn10NotAttempted);
				 
				 
				/* StringBuffer buf = new StringBuffer();
				 
				 // %not attempted
	                buf.append("=(B5/(B5+D5+F5))*100");
	                Formula f = new Formula(2, 4, buf.toString());
	                sheet.addCell(f);
		            buf.append("=(B6/(B6+D6+F6))*100");
		            Formula f1 = new Formula(2, 5, buf.toString());
		            sheet.addCell(f1);
		            buf.append("=(B7/(B7+D7+F7))*100");
		            Formula f2 = new Formula(2, 6, buf.toString());
		            sheet.addCell(f2);
		            buf.append("=(B8/(B8+D8+F8))*100");
		            Formula f3 = new Formula(2, 7, buf.toString());
		            sheet.addCell(f3);
		            buf.append("=(B9/(B9+D9+F9))*100");
		            Formula f4 = new Formula(2, 8, buf.toString());
		            sheet.addCell(f4);
		            buf.append("=(B10/(B10+D10+F10))*100");
		            Formula f5 = new Formula(2, 9, buf.toString());
		            sheet.addCell(f5);
		            buf.append("=(B11/(B11+D11+F11))*100");
		            Formula f6 = new Formula(2, 10, buf.toString());
		            sheet.addCell(f6);
		            buf.append("=(B12/(B12+D12+F12))*100");
		            Formula f7 = new Formula(2, 11, buf.toString());
		            sheet.addCell(f7);
		            buf.append("=(B13/(B13+D13+F13))*100");
		            Formula f8 = new Formula(2, 12, buf.toString());
		            sheet.addCell(f8);
		            buf.append("=(B14/(B14+D14+F14))*100");
		            Formula f9 = new Formula(2, 13, buf.toString());
		            sheet.addCell(f9);*/

				 // %Correct
	               /* buf.append("=(D5/(B5+D5+F5))*100");
	                Formula correct = new Formula(4, 4, buf.toString());
	                sheet.addCell(correct);
		            buf.append("=(D6/(B6+D6+F6))*100");
		            Formula correct1 = new Formula(4, 5, buf.toString());
		            sheet.addCell(correct1);
		            buf.append("=(D7/(B7+D7+F7))*100");
		            Formula correct2 = new Formula(4, 6, buf.toString());
		            sheet.addCell(correct2);
		            buf.append("=(D8/(B8+D8+F8))*100");
		            Formula correct3 = new Formula(4, 7, buf.toString());
		            sheet.addCell(correct3);
		            buf.append("=(D9/(B9+D9+F9))*100");
		            Formula correct4 = new Formula(4, 8, buf.toString());
		            sheet.addCell(correct4);
		            buf.append("=(D10/(B10+D10+F10))*100");
		            Formula correct5 = new Formula(4, 9, buf.toString());
		            sheet.addCell(correct5);
		            buf.append("=(D11/(B11+D11+F11))*100");
		            Formula correct6 = new Formula(4, 10, buf.toString());
		            sheet.addCell(correct6);
		            buf.append("=(D12/(B12+D12+F12))*100");
		            Formula correct7 = new Formula(4, 11, buf.toString());
		            sheet.addCell(correct7);
		            buf.append("=(D13/(B13+D13+F13))*100");
		            Formula correct8 = new Formula(4, 12, buf.toString());
		            sheet.addCell(correct8);
		            buf.append("=(D14/(B14+D14+F14))*100");
		            Formula correct9 = new Formula(4, 13, buf.toString());
		            sheet.addCell(correct9);
		            
		            */
		   		 // %Incorrect
	               /* buf.append("=(F5/(B5+D5+F5))*100");
	                Formula incorrect = new Formula(6, 4, buf.toString());
	                sheet.addCell(incorrect);
		            buf.append("=(F6/(B6+D6+F6))*100");
		            Formula incorrect1 = new Formula(6, 5, buf.toString());
		            sheet.addCell(incorrect1);
		            buf.append("=(F7/(B7+D7+F7))*100");
		            Formula incorrect2 = new Formula(6, 6, buf.toString());
		            sheet.addCell(incorrect2);
		            buf.append("=(F8/(B8+D8+F8))*100");
		            Formula incorrect3 = new Formula(6, 7, buf.toString());
		            sheet.addCell(incorrect3);
		            buf.append("=(F9/(B9+D9+F9))*100");
		            Formula incorrect4 = new Formula(6, 8, buf.toString());
		            sheet.addCell(incorrect4);
		            buf.append("=(F10/(B10+D10+F10))*100");
		            Formula incorrect5 = new Formula(6, 9, buf.toString());
		            sheet.addCell(incorrect5);
		            buf.append("=(F11/(B11+D11+F11))*100");
		            Formula incorrect6 = new Formula(6, 10, buf.toString());
		            sheet.addCell(incorrect6);
		            buf.append("=(F12/(B12+D12+F12))*100");
		            Formula incorrect7 = new Formula(6, 11, buf.toString());
		            sheet.addCell(incorrect7);
		            buf.append("=(F13/(B13+D13+F13))*100");
		            Formula incorrect8 = new Formula(6, 12, buf.toString());
		            sheet.addCell(incorrect8);
		            buf.append("=(F14/(B14+D14+F14))*100");
		            Formula incorrect9 = new Formula(6, 13, buf.toString());
		            sheet.addCell(incorrect9);
	    		    	 
	    	 
*/
	     }

}
