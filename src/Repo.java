import java.util.ArrayList;
import java.util.List;

public class Repo {

	private List<String> listOfTitles;
	private List<String> ignoredWords;
	private List<String> rearrangedWords;
	
	Repo() {
		listOfTitles = new ArrayList<String>();
		ignoredWords = new ArrayList<String>();
		rearrangedWords = new ArrayList<String>();
	}

	void setlistOfTitles(List<String> listOfTitles) {
		this.listOfTitles = listOfTitles;
	}

	void setignoredWords(List<String> ignoredWords) {
		this.ignoredWords = ignoredWords;
	}

	void setrearrangedWords(List<String> rearrangedWords) {
		this.rearrangedWords = rearrangedWords;
	}

	List<String> getListOfTitles() {
		return listOfTitles;
	}

	List<String> getIgnoredWords() {
		return ignoredWords;
	}

	List<String> getRearrangedWords() {
		return rearrangedWords;
	}

}
