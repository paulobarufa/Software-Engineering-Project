package frontend;


import java.io.IOException;
import java.util.ArrayList;

import backend.ReadCSV;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class DisplayStats {
			
		public static void makePie(int[] data, int questionNumber, Scene scene) throws IOException{
			
			int[] stats = data;			
			 int correct = data[0];
			 int incorrect = data[1];
			 int notAttempted = data[2];
			 			
 
			 
			  ObservableList<PieChart.Data> pieChartData =  
		    			FXCollections.observableArrayList(
		                new PieChart.Data("Answered Incorrectly", incorrect),
		                new PieChart.Data("Not Attempted", notAttempted),
		                new PieChart.Data("Answered Correctly", correct)); 
			  

			  Rectangle background = new Rectangle(520, 500);
			  background.setX(520);
			  background.setY(300);
			  background.setFill(Color.WHITE);
			  
			  final PieChart chart = new PieChart(pieChartData);
			  chart.setTitle("Question"+questionNumber);
			  chart.setLabelLineLength(10);
			  chart.setLayoutX(520);
			  chart.setLayoutY(300);
			  ((Group) scene.getRoot()).getChildren().addAll(background, chart);
		}
		
public static void makePie(int[] data, Scene scene) throws IOException{
			
			int[] stats = data;
			//System.out.println(data.toString());
			
			 int correct = data[0];
			 int incorrect = data[1];
			 int notAttempted = data[2];
			 			
 
			 
			  ObservableList<PieChart.Data> pieChartData =  
		    			FXCollections.observableArrayList(
		                new PieChart.Data("Answered Incorrectly", incorrect),
		                new PieChart.Data("Not Attempted", notAttempted),
		                new PieChart.Data("Answered Correctly", correct)); 
			  

			  Rectangle background = new Rectangle(520, 500);
			  background.setX(520);
			  background.setY(300);
			  background.setFill(Color.WHITE);
			  
			  final PieChart chart = new PieChart(pieChartData);
			  chart.setTitle("Session Overview");
			  chart.setLabelLineLength(10);
			  chart.setLayoutX(520);
			  chart.setLayoutY(300);
			  ((Group) scene.getRoot()).getChildren().addAll(background, chart);
		}

	

 		public static void makeMenu (String fileName, Scene scene){
 			
 			Button overview = new Button("Quiz Overview");
 			Button qn1 = new Button("    Question 1  ");
 			Button qn2 = new Button("    Question 2  ");
 			Button qn3 = new Button("    Question 3  ");
 			Button qn4 = new Button("    Question 4  ");
 			Button qn5 = new Button("    Question 5  ");
 			Button qn6 = new Button("    Question 6  ");
 			Button qn7 = new Button("    Question 7  ");
 			Button qn8 = new Button("    Question 8  ");
 			Button qn9 = new Button("    Question 9  ");
 			Button qn10 = new Button("   Question 10  ");
 			
 			Label instructions = new Label("Please select a question number \nto view your quiz statistics");
 			Font labelFont = new Font(20);
 	        labelFont.font("sanSerif", FontWeight.BOLD,16);
 	        instructions.setFont(labelFont);
 	       // instructions2.setFont(labelFont);
 			
 			GridPane grid = new GridPane();
		    grid.setGridLinesVisible(false);
		    grid.setVgap(5);
		    grid.setHgap(10);
		    grid.setPadding(new Insets(300, 50, 300, 100));
		    grid.add(overview, 0, 0);
		    grid.add(qn1, 0, 1);
		    grid.add(qn2, 0, 2);
		    grid.add(qn3, 0, 3);
		    grid.add(qn4, 0, 4);
		    grid.add(qn5, 0, 5);
		    grid.add(qn6, 0, 6);
		    grid.add(qn7, 0, 7);
		    grid.add(qn8, 0, 8);
		    grid.add(qn9, 0, 9);
		    grid.add(qn10, 0, 10);
		    
		    grid.add(instructions, 40, 4,1, 2);
		    
		    ((Group) scene.getRoot()).getChildren().add(grid);
		    
		    
		    overview.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle (ActionEvent event){
	            	int[] data = ReadCSV.readOverallResultsCSV(fileName);
	    			try {
	    				
	    				DisplayStats.makePie(data, scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            
		        }});
		    

		    
		    
		    qn1.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle (ActionEvent event){
	            	int[] data = ReadCSV.readResultsCSV(fileName, 1);
	    			try {
	    				
	    				DisplayStats.makePie(data, 1, scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            
		        }});
		    
		    qn2.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle (ActionEvent event){
	            	int[] data = ReadCSV.readResultsCSV(fileName, 2);
	    			try {
	    				
	    				DisplayStats.makePie(data, 2, scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            
		        }});
		    
		    qn3.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle (ActionEvent event){
	           
	            	int[] data = ReadCSV.readResultsCSV(fileName, 3);
	    			try {
						DisplayStats.makePie(data, 3, scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            
		        }});
		    
		    qn4.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle (ActionEvent event){
	           
	            	int[] data = ReadCSV.readResultsCSV(fileName, 4);
	    			try {
						DisplayStats.makePie(data, 4, scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            
		        }});
		    
		    qn5.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle (ActionEvent event){
	            	int[] data = ReadCSV.readResultsCSV(fileName, 5);
	    			try {
						DisplayStats.makePie(data, 5, scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            
		        }});
		    
		    qn6.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle (ActionEvent event){
	            	int[] data = ReadCSV.readResultsCSV(fileName, 6);
	    			try {
						DisplayStats.makePie(data, 6, scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            
		        }});
		    
		    qn7.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle (ActionEvent event){
	            	int[] data = ReadCSV.readResultsCSV(fileName, 7);
	    			try {
						DisplayStats.makePie(data, 7, scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            
		        }});
		    
		    qn8.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle (ActionEvent event){
	            	int[] data = ReadCSV.readResultsCSV(fileName, 8);
	    			try {
						DisplayStats.makePie(data, 8, scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            
		        }});
		    
		    qn9.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle (ActionEvent event){
	            	int[] data = ReadCSV.readResultsCSV(fileName, 9);
	    			try {
						DisplayStats.makePie(data, 9, scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            
		        }});
		    
		    qn10.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle (ActionEvent event){
	            	int[] data = ReadCSV.readResultsCSV(fileName, 10);
	    			try {
						DisplayStats.makePie(data, 10, scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            
		        }});
		    }
 		

 		
 		
			}
		            	
		    
		    
		    
		    
		        

		        
		        
		             		

 			
 		
	


