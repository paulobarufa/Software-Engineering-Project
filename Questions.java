import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class Questions {

	//public String[] toString() {
	public String[] question() throws Exception {

		File fileIn = new File("SampleQuestions.txt");

		try {

			Scanner in = new Scanner(fileIn);
			String[] allQuestions = new String[10];

			while(in.hasNextLine()) {
				String line = in.nextLine();

				String[] parts = line.split(",");
				int questionNumber = Integer.parseInt(parts[0]);
				String question = parts[1];

				allQuestions[questionNumber - 1] = question;

			}

			return allQuestions;
		}
		catch( Exception e ) {
			System.out.println("Problem reading file");
			throw e;
		}

	}

	public String[][] answers() throws Exception {


		File fileIn = new File("SampleQuestions.txt");

		try {

			Scanner in = new Scanner(fileIn);
			String[][] allAnswers = new String[10][4];

			while(in.hasNextLine()) {
				String line = in.nextLine();

				String[] parts = line.split(",");
				int questionNumber = Integer.parseInt(parts[0]);
				String[] answers = new String[4];
				answers[0] = parts[2];
				answers[1] = parts[3];
				answers[2] = parts[4];
				answers[3] = parts[5];

				allAnswers[questionNumber - 1] = answers;

			}

			return allAnswers;
		}
		catch( Exception e ) {
			System.out.println("Problem reading file");
			throw e;
		}
	}
}