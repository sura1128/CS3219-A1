import java.util.List;

public class Output {

	private List<String> rearrangedWords;

	Output(Alphabetizer alphaHandler) {
		rearrangedWords = alphaHandler.getRearrangedWords();
	}

	// Accessed by Master Control
	void run() {
		displayOutput();
	}

	private void displayOutput() {
		display("KWIC Output: ");
		for (int i = 0; i < rearrangedWords.size(); i++) {
			display(rearrangedWords.get(i));
		}
	}

	private void display(String sentence) {
		System.out.println(sentence);
		System.out.println();
	}

}
