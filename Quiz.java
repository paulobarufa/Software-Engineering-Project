import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.io.*;
import javafx.application.*;
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

	int score;
	int i;

	String[] allQuestions;
	String[][] allAnswers;
	int[] stats;


	public static void main( String[] args) {

		launch(args);
	}

	//n is question number to show
	public void showQuestion(int i, Stage primaryStage){

		Group root = new Group();
		Scene scene = new Scene(root, 1500,900);
		Random rand = new Random(System.currentTimeMillis());
		
		int red = 0;
		int blue = 0;
		int green = 0;	
		int rot = 0;
		
		
		for (int j=0; j<500; j++){
			int x = rand.nextInt((int) scene.getWidth());
			int y = rand.nextInt(200);
			red = rand.nextInt(100);
			green = rand.nextInt(200);
			blue = rand.nextInt(200);	
			rot = rand.nextInt(360);
			
			Text text = new Text(x,y, "quiz");
			Font serifSmall = new Font ("Serif", 18);
			text.setFont(serifSmall);
			text.setFill(Color.rgb(red, blue, green, .4));
			text.setRotate(rot);
			root.getChildren().add(text);
			
		}
		

		Text text2 = new Text(570,120,"Quiz");
		text2.setFont(Font.font("Serif", FontWeight.BOLD, 80));		
		root.getChildren().add(text2);

		FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 10);
    	rootNode.setAlignment(Pos.CENTER_LEFT);
    	rootNode.setPadding(new Insets(300, 0, 0, 500));
		
		//Scene scene = new Scene(rootNode, 1500,900);

		primaryStage.setScene(scene);

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
			Label correctLetter = new Label("");

			if (allAnswers[i][0].equals(correctAnswer)) {
				correctLetter.setText("A");
			} 
			else if (allAnswers[i][1].equals(correctAnswer)) {
				correctLetter.setText("B");
			}
			else if (allAnswers[i][2].equals(correctAnswer)) {
				correctLetter.setText("C");
			}
			else {
				correctLetter.setText("D");
			}

			//Display questions and answers
		Label question = new Label(allQuestions[i]);
		Label result = new Label("");
		Label response = new Label("");
		
    	RadioButton answer1 = new RadioButton(allAnswers[i][0]);
    	RadioButton answer2 = new RadioButton(allAnswers[i][1]);
    	RadioButton answer3 = new RadioButton(allAnswers[i][2]);
    	RadioButton answer4 = new RadioButton(allAnswers[i][3]);

    	ToggleGroup tg = new ToggleGroup();

    	answer1.setToggleGroup(tg);
    	answer2.setToggleGroup(tg);
    	answer3.setToggleGroup(tg);
    	answer4.setToggleGroup(tg);

    	Button select = new Button("Select");
    	select.setPrefWidth(60);

    	Button nextBtn = new Button("Next");
    	nextBtn.setPrefWidth(60);
    	nextBtn.setDisable(true);

    	Button exit = new Button("Exit");
    	exit.setPrefWidth(60);

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

    	select.setOnAction( new EventHandler<ActionEvent>() {
    		@Override
    			public void handle(ActionEvent ae) {
    				if (response.getText().equals(correctLetter.getText())) {
    					result.setText("Correct");
    					score++;
			 	 		stats[i] = 1;
    				} else {
    					result.setText("Incorrect. The answer was " + correctAnswer + ".");
    					stats[i] = 2;
    				}
    				select.setDisable(true);
    				nextBtn.setDisable(false);
    			}
    	});

    	nextBtn.setOnAction( new EventHandler<ActionEvent>() {
    		@Override
    			public void handle(ActionEvent ae) {
    				if(i < allQuestions.length-1){
    					showQuestion(i+1, primaryStage);
    				}else{
    					System.out.println("We have reached the last question.");
    					System.out.println("Score: " + score + "/10");
    					primaryStage.close();

    					try {

			             	FileWriter writer = new FileWriter("data.csv", true);
			             	PrintWriter out = new PrintWriter( writer );

			             	out.println( stats[0] + "," + stats[1] + "," + stats[2] + "," + stats[3] + "," + stats[4] + "," + stats[5] + "," + stats[6] + "," + stats[7] + "," + stats[8] + "," + stats[9] );

			             	out.close();
			         	}
			         	catch ( Exception e ) {
			             	System.out.println( e );
			 	        }
    				}
    			}
    	});

    	exit.setOnAction( new EventHandler<ActionEvent>() {
    		@Override
    			public void handle(ActionEvent ae) {
					System.out.println("We have exited before the last question.");
					System.out.println("Score: " + score + "/10");
					primaryStage.close();

					try {

		             	FileWriter writer = new FileWriter("data.csv", true);
		             	PrintWriter out = new PrintWriter( writer );

		             	out.println( stats[0] + "," + stats[1] + "," + stats[2] + "," + stats[3] + "," + stats[4] + "," + stats[5] + "," + stats[6] + "," + stats[7] + "," + stats[8] + "," + stats[9] );

		             	out.close();
		         	}
		         	catch ( Exception e ) {
		             	System.out.println( e );
		 	        }
    				
    			}
    	});

    	answer1.fire();

    	rootNode.getChildren().addAll(question, answer1, answer2, answer3, answer4, select, result, nextBtn, exit);
    	root.getChildren().add(rootNode);
    	primaryStage.setScene(scene);
    	primaryStage.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

    	try {
			//Add filename as argument rather than having hard coded into Questions class
			Questions questions = new Questions();
			String selection;
			stats = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			i = 0;
			score = 0;

			File fileIn = new File("data.csv");

			String topic;

			try {

				Scanner in = new Scanner(fileIn);
				String line = in.nextLine();

				String[] parts = line.split(",");
				topic = parts[4];

			}
			catch( Exception e ) {
				System.out.println("Problem reading file");
				throw e;
			}

			String fileName = topic + ".csv";

			//Create question and answer arrays
			allQuestions = questions.question(fileName);
			allAnswers = questions.answers(fileName);

			primaryStage.setTitle("Quiz");

			showQuestion(0, primaryStage);

		}
		catch( Exception e ) {
			//Do Nothing
		}

	}
}