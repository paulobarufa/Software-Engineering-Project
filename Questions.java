import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class Questions {
	int i;

	//public String[] toString() {
	public String[] question(String fileName) throws Exception {

		File fileIn = new File(fileName);

		try {

			Scanner in = new Scanner(fileIn);
			String[] allQuestions = new String[10];

			String topic = in.nextLine();
			i = 0;

			while(in.hasNextLine()) {
				String line = in.nextLine();

				String[] parts = line.split(",");
				String question = parts[0];

				allQuestions[i] = question;

				i++;

			}

			return allQuestions;
		}
		catch( Exception e ) {
			System.out.println("Problem reading file");
			throw e;
		}

	}

	public String[][] answers(String fileName) throws Exception {


		File fileIn = new File(fileName);

		try {

			Scanner in = new Scanner(fileIn);
			String[][] allAnswers = new String[10][4];

			String topic = in.nextLine();
			i = 0;

			while(in.hasNextLine()) {
				String line = in.nextLine();

				String[] parts = line.split(",");
				String[] answers = new String[4];
				answers[0] = parts[1];
				answers[1] = parts[2];
				answers[2] = parts[3];
				answers[3] = parts[4];

				allAnswers[i] = answers;

				i++;

			}

			return allAnswers;
		}
		catch( Exception e ) {
			System.out.println("Problem reading file");
			throw e;
		}
	}
}