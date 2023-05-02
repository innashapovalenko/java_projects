public class TranslationTest {

	private static int testsFailed = 0;

	public static void main(String[] args) {
		// create translator
		Translator translator = new Translator("dictionary.txt");
		
		// load translator
		translator.addTranslation("one", "ichii");
		translator.addTranslation("two", "ni");
		translator.addTranslation("three", "san");
		translator.addTranslation("four", "shi");
		translator.addTranslation("five", "go");
		translator.addTranslation("six", "roku");
		translator.addTranslation("seven", "sebun");
		translator.addTranslation("eight", "hachi");
		translator.addTranslation("nine", "kyu");
		translator.addTranslation("ten", "ju");

		// 

		translator.addTranslation("eleven", "ju ichii");
		translator.addTranslation("twelve", "ju ni");
		translator.addTranslation("thirteen", "juzo");
		translator.addTranslation("fourteen", "juyon");
		translator.addTranslation("fifteen", "jugo");
		translator.addTranslation("sixteen", "juroku");
		translator.addTranslation("seventeen", "sebuntin");
		translator.addTranslation("eighteen", "juhachi");
		translator.addTranslation("nineteen ", "jukyu");

		//
		translator.addTranslation("twenty", "ni juu");
		translator.addTranslation("thirty", "san ju no");
		translator.addTranslation("forty", "yoto");
		translator.addTranslation("fifty", "goji-tsu");
		translator.addTranslation("sixty", "rokuju-tsu");
		translator.addTranslation("seventy", "shichijuu");
		translator.addTranslation("eighty", "wa chi ju");
		translator.addTranslation("ninety", "kuju");

		//
		translator.addTranslation("hundred", "hyaku");
		
		
		// test translator
		// tests just one word added by directly calling addTranslation
		testTranslation(1, translator, "one", "ichii");
		// tests just words added by directly calling addTranslation
		testTranslation(2, translator, "four", "shi");
		// tests just words added by directly calling addTranslation
		testTranslation(3, translator, "one hundred twenty three", "ichii hyaku ni juu san");
		// tests words added through dictionary.txt and addTranslation
		testTranslation(4, translator, "one hundred twenty four", "ichii hyaku ni juu shi");
		
		if (testsFailed == 0) {
			System.out.println("ALL TESTS PASSED!!");
		} else {
			System.out.println("At least one test failed.");
		}
	
	}
	
	private static void testTranslation(int testId, Translator t, String input, String expectedOutput) {
		System.out.println("Test " + testId);
		String actualOutput = t.translate(input);
		assertEquals(expectedOutput, actualOutput);
	}
	
	private static void assertEquals(Object expected, Object actual) {
		if (expected.equals(actual)) {
			//System.out.println("PASSED");
		} else {
			testsFailed++;
			System.out.println("FAILED: " + expected + " was expected, but " + 
				actual + " was found.");
		}
	}
}
