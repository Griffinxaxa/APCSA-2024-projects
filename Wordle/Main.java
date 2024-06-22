//GRADE: 100/100
public class Main {

	public static void main(String[] args) {
		// For each activity, remove the "//" in order to run the tests for that
		// section. For the last activity, you'll also want to play the game by removing
		// the "//" for WordleGui

		// UNCOMMENT THIS FOR ACTIVITY 1
		// runTests(DictionaryTests.class);

		// UNCOMMENT THIS FOR ACTIVITY 2
		// runTests(GameTests1.class);

		// UNCOMMENT THIS FOR ACTIVITY 3
		// runTests(GameTests2.class);

		// UNCOMMENT THIS FOR RUNNING THE GUI IN ACTIVITY 3
		WordleGui.main(args);
	}

	// Don't modify anything below
	public static void runTests(Class<?> testClass) {
		System.out.println("Running tests for " + testClass.getSimpleName());
		Result result = JUnitCore.runClasses(testClass);

		if (result.wasSuccessful()) {
			System.out.println("🎉\t\033[32mSuccess! All tests passed\033[m");
			return;
		}

		int failureCount = result.getFailureCount();

		System.out.println("\033[31m 🙁\t" + failureCount + " Test Failure"
				+ (failureCount > 1 ? "s" : "") + "\033[m\n");

		int i = 0;
		for (Failure failure : result.getFailures()) {
			// Tidy up stack trace
			ArrayList<String> traces = new ArrayList<String>(Arrays.asList(failure.getTrace().split("\n")));
			int j = 0;
			
			while (j < traces.size() - 1) {
				// For every consecutive group of junit assert stack traces, remove all except the last trace
				if (traces.get(j).contains("junit.Assert") && traces.get(j + 1).contains("junit.Assert")) {
					traces.remove(j);
				} else {
					j++;
				}
			}
			
			// Remove internal junit and java frames
			traces.removeIf(trace -> trace.contains("junit.runner") || trace.contains("junit.internal") || trace.contains("java.base"));
			
			// Print out failure information and tidied stack trace
			System.out.println("\033[31m(" + ++i + "/" + (failureCount) + ")\033[m "
					+ failure.getTestHeader());
			System.out.println(String.join("\n", traces) + "\n");
		}
	}
}
