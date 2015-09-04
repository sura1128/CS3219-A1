import java.io.*;

public class Main {

	private final static String SUBROUTINE = "SUBROUTINE ARCHITECTURE";
	private final static String ADT = "ABSTRACT DATA TYPE ARCHITECTURE";
	private final static String EXIT_MESSAGE = "SYSTEM IS EXITING.";
	private final static String SUBROUTINE_CHOICE = "1";
	private final static String ADT_CHOICE = "2";
	private final static String EXIT_CHOICE = "0";
	private final static String ERROR_MESSAGE = "The number you have chosen is not in the list of architectures.";

	public static void main(String args[]) throws IOException {
		display("CS3219 Assignment 1 implements 2 types of Logical Architecture.");
		display("1. " + SUBROUTINE);
		display("2. " + ADT);
		display("0. Exit System.");
		display("Type 1 to access Subroutine, 2 to access ADT and 0 to Exit.");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String choiceOfArchi = EXIT_CHOICE; // default set to 0 for Exit
		Subroutine subroutineHandler = new Subroutine();
		AbstractDataType adtHandler = new AbstractDataType();

		while (true) {
			choiceOfArchi = br.readLine();
			if (choiceOfArchi.equals(SUBROUTINE_CHOICE)) {
				display(SUBROUTINE);
				subroutineHandler.run();
			} else if (choiceOfArchi.equals(ADT_CHOICE)) {
				display(ADT);
				adtHandler.run();
			} else if (choiceOfArchi.equals(EXIT_CHOICE)) {
				display(EXIT_MESSAGE);
				break;
			} else {
				display(ERROR_MESSAGE);
			}
			display("Please choose another Architecture. Or type 0 to Exit.");
		}

	}

	private static void display(String sentence) {
		System.out.println(sentence);
		System.out.println();
	}
}
