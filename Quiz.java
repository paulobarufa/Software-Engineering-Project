import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.io.*;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.application.*;

public class Quiz extends Application {

	Label response;

	public static void main( String[] args) {

		launch(args);

		try {
			//Add filename as argument rather than having hard coded into Questions class
			Questions questions = new Questions();
			String selection;
			int[] stats = {0,0,0,0,0,0,0,0,0,0};
			int score = 0;
			int i = 0;

			//Create question and answer arrays
			String[] allQuestions = questions.question();
			String[][] allAnswers = questions.answers();

			Scanner user_input = new Scanner( System.in );

			//Loop for each question
			while ( i < 10 ) {

				//Mix up answers
				String correctAnswer = allAnswers[i][0];

				//Code adapted from [insert reference]
				int index;
				String temp;
     			Random random = new Random();
     			for (int j = allAnswers[i].length - 1; j > 0; j--) {
         			index = random.nextInt(j + 1);
         			temp = allAnswers[i][index];
         			allAnswers[i][index] = allAnswers[i][j];
         			allAnswers[i][j] = temp;
     			}

     			//Determine which is the correct answer
     			String correctLetter;

     			if (allAnswers[i][0].equals(correctAnswer)) {
     				correctLetter = "A";
     			} 
     			else if (allAnswers[i][1].equals(correctAnswer)) {
     				correctLetter = "B";
     			}
     			else if (allAnswers[i][2].equals(correctAnswer)) {
     				correctLetter = "C";
     			}
     			else {
     				correctLetter = "D";
     			}

     			//Display questions and answers
				System.out.println(allQuestions[i]);
			 	System.out.println("A: " + allAnswers[i][0] + ", B: " + allAnswers[i][1] + ", C: " + allAnswers[i][2] + ", D: " + allAnswers[i][3]);
			 	System.out.println("Please enter your selection:");
			 	//Get user's answer and convert to uppercase to allow for typing in lowercase
			 	selection = user_input.next( ).toUpperCase();
			 	//Check answer is correct
			 	if ( selection.equals(correctLetter) ) {
			 		System.out.println("Correct.");
			 		score++;
			 		stats[i] = 1;
			 	}
			 	else if ( selection.toUpperCase().equals("EXIT")) {
			 		i = 9;
			 	}
			 	else {
			 		System.out.println("Incorrect. The answer was " + correctAnswer + ".");
			 		stats[i] = 2;
			 	}

				i++;
			}

			System.out.println("Score: " + score +"/10");
			System.out.println(Arrays.toString(stats));
			//Save stats to file

			try {

            	FileWriter writer = new FileWriter("results.txt", true);
            	PrintWriter out = new PrintWriter( writer );

            	out.println( stats[0] + "," + stats[1] + "," + stats[2] + "," + stats[3] + "," + stats[4] + "," + stats[5] + "," + stats[6] + "," + stats[7] + "," + stats[8] + "," + stats[9] );

            	out.close();
        	}
        	catch ( Exception e ) {
            	System.out.println( e );
        }
		}
		catch( Exception e ) {
			//Do Nothing
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Quiz");

    	FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 10);
    	rootNode.setAlignment(Pos.CENTER_LEFT);
    	rootNode.setPadding(new Insets(100, 100, 100, 400));

    	Scene scene = new Scene(rootNode, 1500,900);

    	primaryStage.setScene(scene);

    	Label question = new Label("Question");
    	response = new Label;

    	RadioButton answer1 = new RadioButton("1");
    	RadioButton answer2 = new RadioButton("2");
    	RadioButton answer3 = new RadioButton("3");
    	RadioButton answer4 = new RadioButton("4");

    	ToggleGroup tg = new ToggleGroup();

    	answer1.setToggleGroup(tg);
    	answer2.setToggleGroup(tg);
    	answer3.setToggleGroup(tg);
    	answer4.setToggleGroup(tg);

    	answer1.setOnAction( new EventHandler<ActionEvent>() {
    		@Override
    			public void handle(ActionEvent ae) {
    				response.setText("A");
    			}
    	});

    	answer2.setOnAction( new EventHandler<ActionEvent>() {
    		@Override
    			public void handle(ActionEvent ae) {
    				response.setText("B");
    			}
    	});

    	answer3.setOnAction( new EventHandler<ActionEvent>() {
    		@Override
    			public void handle(ActionEvent ae) {
    				response.setText("C");
    			}
    	});

    	answer4.setOnAction( new EventHandler<ActionEvent>() {
    		@Override
    			public void handle(ActionEvent ae) {
    				response.setText("D");
    			}
    	});

    	answer1.fire();

    	rootNode.getChildren().addAll(question, answer1, answer2, answer3, answer4, response);

		primaryStage.show();
	}
}