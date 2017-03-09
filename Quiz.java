import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.io.*;

public class Quiz {

	public static void main( String[] args) {

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
}