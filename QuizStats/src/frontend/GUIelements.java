package frontend;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jxl.Workbook;
import jxl.write.DateFormat;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import backend.ReadCSV;
import backend.SaveSession;
import backend.StartSession;
import frontend.GenericBackground;
import javafx.beans.binding.DoubleBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GUIelements extends Application{
	    public static void main(String[] args) {
	        launch(args);
	    }
	    	
	    //String to contain all the event details
	    static String[] sessionDetails = new String[4];	
			
		
	    //Method to retrieve event details with GUI
	    static void SessionDetailsGUI(Stage PrimaryStage){
				
						
			Scene scene = GenericBackground.createBackground("?");
			Group root = new Group();
			
			Rectangle background = new Rectangle(650,550);
			background.setX(400);
			background.setY(250);
			background.setArcHeight(15);
			background.setArcWidth(15);
			background.setFill(Color.rgb(0, 30, 60, .2));
			
	
			
	        Font labelFont = new Font(16);
	        labelFont.font("sanSerif", FontWeight.BOLD, 20);
						
			final Button button = new Button ("Save Details");
			button.setFont(labelFont);
		    final Label notification = new Label ();
		    final TextField schoolName = new TextField("");
		    final TextField date = new TextField("");
		    final TextArea text = new TextArea ("");
		    

		        
		    final ComboBox quizList = new ComboBox();
		    quizList.getItems().addAll(
		       "Computer Science",
		       "Quiz 2",
		       "Quiz 3",
		       "Quiz 4",
		       "Quiz 5"  
		    );
		        
		    quizList.setValue("Please select:");
		        
		     final ComboBox yearGroup = new ComboBox();
		     yearGroup.getItems().addAll(
		        "7",
		        "8",
		        "9",
		        "11",
		        "12",
		        "13"
		      );   

		        yearGroup.setValue("Please select:");
		        
		        
		        Label SchoolLabel = new Label("School Name / Event Name: ");
		        SchoolLabel.setFont(labelFont);
		        Label YrGroupLabel = new Label("Year Group: ");
		        YrGroupLabel.setFont(labelFont);
		        Label QuizLabel = new Label("Quiz: ");		        
		        QuizLabel.setFont(labelFont);
		        
		        GridPane grid = new GridPane();
		        grid.setGridLinesVisible(false);
		        grid.setVgap(20);
		        grid.setHgap(10);
		        grid.setPadding(new Insets(400, 250, 250, 450));


		        grid.add((SchoolLabel), 0, 1);
		        grid.setHalignment(SchoolLabel, HPos.RIGHT);
		        grid.add(schoolName, 1, 1);
		        grid.add((YrGroupLabel), 0, 2);
		        grid.setHalignment(YrGroupLabel, HPos.RIGHT);
		        grid.add(yearGroup, 1, 2);
		        grid.add((QuizLabel), 0, 3);            
		        grid.setHalignment(QuizLabel, HPos.RIGHT);
		        grid.add(quizList, 1, 3, 4, 1);
		        grid.add(button, 1, 8);
		        grid.add (notification, 1, 3, 3, 1); 
		        
		        
		        button.setOnAction(new EventHandler<ActionEvent>(){
		        
		            public void handle (ActionEvent event){
		            	
		        		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		        		Date date = new Date();
		        		String sessionDate = dateFormat.format(date);
		            	
		            	GUIelements.sessionDetails[0] = sessionDate;
		            	GUIelements.sessionDetails[1] = schoolName.getText();
		            	GUIelements.sessionDetails[2] = (String) yearGroup.getValue();
		            	GUIelements.sessionDetails[3] = (String) quizList.getValue();          			            	

		            	try {
							ReadCSV.writeToCSV(GUIelements.sessionDetails);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		            
		        });
		        
		        		
		        ((Group) scene.getRoot()).getChildren().addAll(background,grid);
			 	GenericBackground.drawBackground(PrimaryStage, scene);
				
			 	
			 	
			}
	    
	    
	    
	    
		@Override
		public void start(Stage primaryStage) throws Exception {
			SessionDetailsGUI(primaryStage);
			//SaveSession.endSession (primaryStage);
			
		}}
			
		
			