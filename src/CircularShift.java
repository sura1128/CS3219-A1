import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CircularShift {
	
	private List<String> listOfTitles;
	private List<String> ignoredWords;
	private List<String> rearrangedWords;
	
	CircularShift(Characters charHandler) {
		listOfTitles = charHandler.getListOfTitles();
		ignoredWords = charHandler.getIgnoredWords();
		rearrangedWords = new ArrayList<String>();
	}
	
	//Accessed by Master Control
	void run() {
		rearrange();
	}
	

	private void rearrange() {
		String temp;
		LinkedList<String> title = new LinkedList<String>();

		for (int j = 0; j < listOfTitles.size(); j++) {
			title = getListFromString(listOfTitles.get(j).split(" "));

			for (int i = 0; i < title.size(); i++) {
				temp = title.peek();
				if (Arrays.asList(ignoredWords.toArray()).contains(temp.toLowerCase())) {
					title.poll();
					title.addLast(temp);
				} else {
					getStringFromList(title);
					title.poll();
					title.addLast(temp);
				}
			}
		}
	}

	
	private LinkedList<String> getListFromString(String[] title) {
		LinkedList<String> q = new LinkedList<String>();
		for (int i = 0; i < title.length; i++) {
			q.addLast(title[i]);
		}
		return q;
	}
	
	private void getStringFromList(LinkedList<String> title) {
		StringBuilder t = new StringBuilder();
		Iterator<String> i = title.iterator();
		while (i.hasNext()) {
			t.append(i.next());
			if (i.hasNext())
				t.append(" ");
		}
		rearrangedWords.add(t.toString());
	}
	
	List<String> getRearrangedWords() {
		return rearrangedWords;
	}

}

