import java.util.Collections;
import java.util.List;

public class Alphabetizer {

	private List<String> rearrangedWords;

	Alphabetizer(CircularShift shiftHandler) {
		rearrangedWords = shiftHandler.getRearrangedWords();
	}

	// Accessed by Master Control
	void run() {
		alphabetize();
		capitalize();
	}

	private void alphabetize() {
		Collections.sort(rearrangedWords);
	}

	private void capitalize() {
		for (int i = 0; i < rearrangedWords.size(); i++) {
			StringBuilder output = new StringBuilder();
			String temp = rearrangedWords.get(i);
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) == ' ') {
					output.append(temp.substring(0, j).toUpperCase());
					output.append(' ');
					output.append(temp.substring(j + 1, temp.length()));
					rearrangedWords.set(i, output.toString());
					break;
				}
			}
		}
	}

	List<String> getRearrangedWords() {
		return rearrangedWords;
	}

}
