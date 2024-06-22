package game;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary {
	private String[] words;

	/**
	 * @precondition words is a non-empty, sorted array of strings
	 */
	public Dictionary(String[] words) {
		this.words = words;
	}

	/**
	 * Checks to see if word is present in the dictionary.
	 * 
	 * Implement using a binary search. Look back to CS Awesome 7.5 to see how to
	 * implement a binary search over strings.
	 */
	public boolean isValidWord(String word) {
		//setting up binary search indeces
		int left = 0;
		int right = words.length -1;
		while (left <= right) {
			int middle = (left + right) / 2;
			String middleWord = words[middle];

			int compare = 0;
			int minLength = Math.min(middleWord.length(), word.length());
			for(int i = 0; i < minLength; i++) {
				//using charAt here because its much easier than using substr
				if (middleWord.charAt(i) != word.charAt(i)){
					compare = middleWord.charAt(i) - word.charAt(i);
					//need to break out of for loop when compare condition is met
					break;
					
				}
			}
			if(compare == 0) {
				compare = middleWord.length() - word.length();
			}
			if (compare == 0) {
				return true;
			} else if (compare < 0) {
				left = middle + 1;
			} else {
				right = middle -1;
				
			}
		}
		return false;
	}

	/**
	 * Returns a word at random from the dictionary.
	 */
	public String getRandomWord() {
		Random random = new Random();
		int index = random.nextInt(words.length);
		return words[index];
	}

	/**
	 * Helper used to create a Dictionary from a text file of words
	 */
	public static Dictionary loadFromFile(String filepath) {
		try {
			File file = new File(filepath);

			BufferedReader br = new BufferedReader(new FileReader(file));

			ArrayList<String> lines = new ArrayList<String>();

			String line = br.readLine();
			while (line != null) {
				lines.add(line);
				line = br.readLine();
			}
			
			br.close();

			String[] words = new String[lines.size()];
			lines.toArray(words);
			return new Dictionary(words);
		} catch (Exception ex) {
			return null;
		}
	}
}
