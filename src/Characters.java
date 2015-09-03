
import java.util.ArrayList;
import java.util.List;

public class Characters {

	private List<String> listOfTitles;
	private List<String> ignoredWords;
	private String[] titleArray;
	private String[] ignoredWordArray;

	Characters(Input inputHandler) {
		listOfTitles = new ArrayList<String>();
		ignoredWords = new ArrayList<String>();
		titleArray = inputHandler.getTitleArray();
		ignoredWordArray = inputHandler.getIgnoredArray();
	}
	
	//accessed by Master Control
	void run() {
		convertToList();
		trimWords();
	}

	private void convertToList() {
		listOfTitles = getListFromArray(titleArray);
		ignoredWords = getListFromArray(ignoredWordArray);

	}

	private List<String> getListFromArray(String[] array) {
		List<String> tempList = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			tempList.add(array[i]);
		}
		return tempList;
	}

	private void trimWords() {
		for (int i = 0; i < listOfTitles.size(); i++) {
			listOfTitles.set(i, listOfTitles.get(i).trim());
		}
		for (int i = 0; i < ignoredWords.size(); i++) {
			ignoredWords.set(i, ignoredWords.get(i).trim());
		}
	}

	List<String> getListOfTitles() {
		return listOfTitles;
	}

	List<String> getIgnoredWords() {
		return ignoredWords;
	}
}

