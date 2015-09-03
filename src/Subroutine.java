import java.io.IOException;

public class Subroutine {

	void run() throws IOException {
		
		Repo repoObj = new Repo();
		KWIC kwicObject = new KWIC(repoObj);
		kwicObject.input();
		kwicObject.shift();
		kwicObject.alphabetize();
		kwicObject.output();
	}

}

