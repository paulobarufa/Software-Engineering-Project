package backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import frontend.GUIelements;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class SaveSession {
	

	
	//Check for existing file before creating new one
	
	public static boolean checkForFile(String fileName){
		
		try{
			BufferedReader in = new BufferedReader(new FileReader(fileName));
		}
		catch (FileNotFoundException e){
			return false;
			
		}
		catch(IOException e){
			System.out.println("IOE exeption");
			
		}
		
		return true;	
	}

	
	//Write the file and close it

	
	public static void closeFile(WritableWorkbook wb) throws IOException, WriteException{
		wb.write();
		wb.close();
	}

	
	public static void endSession (Stage stage, String fileName){
		stage.setOnCloseRequest(e ->{
			
			Alert saveAlert = new Alert((AlertType.CONFIRMATION));
			saveAlert.setHeaderText("Save before exit");
			saveAlert.setContentText("Click 'ok' to save your session or 'cancel' to exit without saving");
			saveAlert.getDialogPane().setPrefSize(480, 150);
			saveAlert.showAndWait().ifPresent(response -> {
			     if (response == ButtonType.OK) {
			    	 try {
			    		 String[] thisSession = ReadCSV.readSessionDetails(fileName);
			    		 String date = thisSession[0];
			    		 String event = thisSession[1];
			    		 String yrGroup = thisSession[2];
			    		 String quizName = thisSession[3];
			    		 
			    		 int i = 1;
			    		 String excelFile = "savedSessions/"+ date + "_"+ i + ".xls"; 
			    		 while (checkForFile(excelFile) == true){
			    			 excelFile = "savedSessions/"+ date + "_"+ i++ + ".xls";
			    			 
			    			 
			    		 }
			    			 
			    			 
			    		 
			    		 
			    		 
			    		 WritableWorkbook wb = StartSession.createFile(excelFile);
			    		 WritableSheet sheet = StartSession.writeSessionDetails(wb, date, event, yrGroup, quizName);
			    		 StartSession.writeSessionResults(sheet, fileName);
			    		 closeFile(wb);
			    		 
			    		 Alert confirmSave = new Alert((AlertType.INFORMATION));
			    		 confirmSave.setHeaderText("Save Successful");
			    		 confirmSave.setContentText("Your session has been successfully saved");
			    		 confirmSave.showAndWait().ifPresent(response1 -> {
						     if (response1 == ButtonType.OK) {
						    	 Platform.exit();
						     }});
			    		 
			    		 
			    	 }catch (WriteException e1) {
						Alert error = new Alert((AlertType.ERROR));
						error.setHeaderText("Save was unsuccessful");
						error.setContentText("An error has occurred. Unable to write session details to file ");
						error.getDialogPane().setPrefSize(480, 150);
						error.showAndWait().ifPresent(response1 -> {
						     if (response1 == ButtonType.OK) {
						    	 Platform.exit();
						     }});
						} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			         Platform.exit();
			     }
			 });
			
			
			Platform.exit();
		});
		
		}
	
	
	
	
	
	
	
}
