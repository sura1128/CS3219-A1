import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		display("Assignment 1 implements 2 types of Logical Architecture.");
		display("1. Shared repo/subroutine with shared data");
		display("2. Abstract Data Type");
		display("Type 1 to access Subroutine, and 2 to access ADT.");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String choiceOfArchi = br.readLine();
		if (choiceOfArchi.equals("1")) {
			Subroutine subroutineHandler = new Subroutine();
			subroutineHandler.run();
		} else if (choiceOfArchi.equals("2")) {
			AbstractDataType adtHandler = new AbstractDataType();
			adtHandler.run();
		} else {
			display("The number you have chosen is not in the list of architectures. Please try again.");
		}
	}

	private static void display(String sentence) {
		System.out.println(sentence);
		System.out.println();
	}
}
