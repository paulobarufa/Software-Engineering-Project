import java.util.Scanner;

public class Quiz {

	public static void main( String[] args) {

		String question = "Which is the odd one out?";
		String[] answers = {"Eagle", "Dragon", "Unicorn", "Lion"};
		String selection;
		int correct = 0;
		int i = 0;

		Scanner user_input = new Scanner( System.in );

		while ( i < 10 ) {

			System.out.println(question);
			System.out.println("A: " + answers[0] + ", B: " + answers[1] + ", C: " + answers[2] + ", D: " + answers[3]);
			System.out.println("Please enter your selection:");
			selection = user_input.next( );

			if ( selection.equals("A") ) {
				System.out.println("Correct. All the others are national animals of Great Britain.");
				correct++;
			}
			else {
				System.out.println("Incorrect. The eagle is the only one that is not a national animal of Great Britain.");
			}

			i++;
		}

		System.out.println("Score: " + correct +"/10");
	}
}