import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KWIC {

	private String[] titleArray;
	private String[] ignoredWordArray;
	private Repo repoObj;

	KWIC(Repo repoObj) {
		this.repoObj = repoObj;
	}

	// -------------- INPUT OPERATION -----------------//

	void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		display("Enter the titles separated by comma: ");
		titleArray = br.readLine().split(",");
		display("Enter the words to be ignored separated by comma: ");
		ignoredWordArray = br.readLine().split(",");
		trimWords();

		List<String> tempTitles = new ArrayList<String>();
		List<String> tempIgnored = new ArrayList<String>();
		tempTitles = getListFromArray(titleArray);
		tempIgnored = getListFromArray(ignoredWordArray);

		writeInputToRepo(tempTitles, tempIgnored);

	}

	// ----------------- HELPER FUNCTIONS FOR INPUT -------------//

	private void trimWords() {
		for (int i = 0; i < titleArray.length; i++) {
			titleArray[i] = titleArray[i].trim();
		}

		for (int j = 0; j < ignoredWordArray.length; j++) {
			ignoredWordArray[j] = ignoredWordArray[j].trim();
		}
	}

	private List<String> getListFromArray(String[] array) {
		List<String> tempList = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			tempList.add(array[i]);
		}
		return tempList;
	}

	private void writeInputToRepo(List<String> tempTitles, List<String> tempIgnored) {
		repoObj.setlistOfTitles(tempTitles);
		repoObj.setignoredWords(tempIgnored);

	}

	// ------------------SHIFT OPERATION ----------------------//
	void shift() {
		String temp, output;
		LinkedList<String> title = new LinkedList<String>();

		// Read input from Repo
		List<String> tempTitles = new ArrayList<String>();
		tempTitles = repoObj.getListOfTitles();
		List<String> tempIgnored = new ArrayList<String>();
		tempIgnored = repoObj.getIgnoredWords();

		List<String> tempRearranged = new ArrayList<String>();

		for (int j = 0; j < tempTitles.size(); j++) {
			title = getListFromString(tempTitles.get(j).split(" "));

			for (int i = 0; i < title.size(); i++) {
				temp = title.peek();
				if (Arrays.asList(tempIgnored.toArray()).contains(temp)) {
					title.poll();
					title.addLast(temp);
				} else {
					output = getStringFromList(title);
					tempRearranged.add(output);
					title.poll();
					title.addLast(temp);
				}
			}
		}
		// Write shifted data to Repo
		repoObj.setrearrangedWords(tempRearranged);

	}

	// ----------------- HELPER FUNCTIONS FOR SHIFT -------------//

	private LinkedList<String> getListFromString(String[] title) {
		LinkedList<String> q = new LinkedList<String>();
		for (int i = 0; i < title.length; i++) {
			q.addLast(title[i]);
		}
		return q;
	}

	private String getStringFromList(LinkedList<String> title) {

		StringBuilder t = new StringBuilder();
		Iterator<String> i = title.iterator();
		while (i.hasNext()) {
			t.append(i.next());
			if (i.hasNext())
				t.append(" ");
		}
		return t.toString();
	}

	// -------------------ALPHABET SORTING--------------------//

	void alphabetize() {
		List<String> tempRearranged = new ArrayList<String>();
		tempRearranged = repoObj.getRearrangedWords(); // Read alphabetically
														// sorted data from Repo
		Collections.sort(tempRearranged);

		// Capitalizing the first key word
		for (int i = 0; i < tempRearranged.size(); i++) {
			StringBuilder output = new StringBuilder();
			String temp = tempRearranged.get(i);
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) == ' ') {
					output.append(temp.substring(0, j).toUpperCase());
					output.append(" ");
					output.append(temp.substring(j + 1, temp.length()));
					tempRearranged.set(i, output.toString());
					break;
				}
			}

		}
		repoObj.setrearrangedWords(tempRearranged);
	}

	// -----------------OUTPUT OPERATION---------------------//
	void output() {
		List<String> tempRearranged = new ArrayList<String>();
		tempRearranged = repoObj.getRearrangedWords(); // Read alphabetically
														// sorted data from Repo
		display("KWIC Output: ");
		for (int i = 0; i < tempRearranged.size(); i++) {
			display(tempRearranged.get(i));
		}
	}

	// ----------------- DISPLAY FUNCTIONS -------------//

	private void display(String sentence) {
		System.out.println(sentence);
		System.out.println();
	}

}
