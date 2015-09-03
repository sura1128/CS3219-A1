import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

	private static String[] titleArray;
	private static String[] ignoredWordArray;

	//accessed by Master Control
	void run() {
		try {
			readDataFromUser();
		} catch (IOException e) {
			display("User Input has encountered an exception.");
			e.printStackTrace();
		}
	}

	private void readDataFromUser() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		display("Enter the titles separated by comma: ");
		titleArray = br.readLine().split(",");
		
		display("Enter the words to be ignored separated by comma: ");
		ignoredWordArray = br.readLine().split(",");
		
	}
	

	private void display(String sentence) {
		System.out.println(sentence);
		System.out.println();
	}
	
	String[] getTitleArray() {
		return titleArray;
	}
	
	String[] getIgnoredArray() {
		return ignoredWordArray;
	}

	

}
