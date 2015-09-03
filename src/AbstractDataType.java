
public class AbstractDataType {

	void run() {
		startKWIC();

	}

	private static void startKWIC() {
		Input inputHandler = new Input();
		inputHandler.run();

		Characters charHandler = new Characters(inputHandler);
		charHandler.run();

		CircularShift shiftHandler = new CircularShift(charHandler);
		shiftHandler.run();

		Alphabetizer alphaHandler = new Alphabetizer(shiftHandler);
		alphaHandler.run();

		Output outputHandler = new Output(alphaHandler);
		outputHandler.run();
	}

}
