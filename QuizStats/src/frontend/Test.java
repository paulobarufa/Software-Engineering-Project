package frontend;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.DataFormat;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

import backend.ReadCSV;
import backend.SaveSession;

	public class Test extends Application{
		public static void main(String[] args){
			launch (args);
			}
		
		


		@Override
		public void start(Stage primaryStage) throws Exception {
			
			String fileName = "data.csv";
			
			Scene scene = GenericBackground.createBackground("%");
			DisplayStats.makeMenu (fileName, scene);
			GenericBackground.drawBackground(primaryStage, scene);
			SaveSession.endSession (primaryStage, fileName);
			

			

			
		}	
	}
			

