package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
	// Class constants
	public static final int WORD_LENGTH = 5;
	public static final int NUM_GUESSES_ALLOWED = 6;

	// Colors used by getTileLetterColor() and getKeyboardLetterColor()
	public static final Color CORRECT_COLOR = new Color(106, 170, 100); //green
	public static final Color PRESENT_COLOR = new Color(201, 180, 88); //yellow
	public static final Color ABSENT_COLOR = new Color(120, 124, 126); //dark gray
	public static final Color DEFAULT_COLOR = Color.LIGHT_GRAY; //light gray

	// Add any instance variables you need here
	private Dictionary allowedGuesses;
	private Dictionary answers;
	private String answer;
	private String guessAttempt;
	private ArrayList<String> acceptedGuesses;

	/**
	 * Constructor for a new game object and sets it up for play
	 * 
	 * @param answers        Dictionary of possible answer words.
	 * @param allowedGuesses Dictionary of words that are allowed as guesses but not
	 *                       possible answers.
	 */
	public Game(Dictionary answers, Dictionary allowedGuesses) {
		this.answers = answers;
		this.allowedGuesses = allowedGuesses;
		this.acceptedGuesses = new ArrayList<>();
		reset();
	}

	/**
	 * Whether the current game is over, meaning either won or lost
	 */
	public boolean isOver() {
		return isWon() || acceptedGuesses.size() >= NUM_GUESSES_ALLOWED;
	}

	/**
	 * Whether the current game is won
	 */
	public boolean isWon() {
		return !acceptedGuesses.isEmpty() && acceptedGuesses.get(acceptedGuesses.size()-1).equals(answer);
	}

	/**
	 * Returns the answer word
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * Returns the user's current guess attempt, as set by setGuessAttempt
	 */
	public String getGuessAttempt() {
		return guessAttempt;
	}

	/**
	 * Sets the user's guess attempt
	 */
	public void setGuessAttempt(String guessAttempt) {
		this.guessAttempt = guessAttempt;
	}

	/**
	 * Looks at the user's guess attempt. If the guess attempt is a valid word,
	 * accepts it as a valid guess and clears the guess attempt.
	 */
	public void submitGuess() {
		if(guessAttempt.length() == WORD_LENGTH && (answers.isValidWord(guessAttempt) || allowedGuesses.isValidWord(guessAttempt))) {
			acceptedGuesses.add(guessAttempt); 
			guessAttempt = "";
			
		}
	}

	/**
	 * Returns an ArrayList of accepted guesses
	 */
	public ArrayList<String> getAcceptedGuesses() {
		return new ArrayList<>(acceptedGuesses);
	}

	/**
	 * Resets the game to a starting state. This allows the game object to be used
	 * for another game after the game is over.
	 */
	public void reset() {
		this.answer = answers.getRandomWord();
		this.guessAttempt = "";
		this.acceptedGuesses.clear();
	}

	/**
	 * Takes an accepted guess and returns the appropriate color of each letter in a
	 * 5-element array.
	 * 
	 * @precondition guess is a string of length WORD_LENGTH (5)
	 * @return
	 */
	//also advancing it further to implement logic to hand if there are two lrtters necesary and one is guessed to properly show that there may be two of the letters and that the second one may be elsewhere
	
	public Color[] getGuessColors(String guess) { //advanced
		Color[] colors = new Color[WORD_LENGTH];
		boolean[] answerMarked = new boolean[WORD_LENGTH];
		boolean[] guessMarked = new boolean[WORD_LENGTH];
		//essentially to implement the advanced guesses method I just had each condition in its own for loop

		for(int i = 0; i < WORD_LENGTH; i++) {
			if(guess.charAt(i) == answer.charAt(i)) {
				colors[i] = CORRECT_COLOR; //set to green
				answerMarked[i] = true; //mark position in the answer
				guessMarked[i] = true; //mark position in the guess
			}
		}
		for(int i = 0; i < WORD_LENGTH; i++) {
			if(!guessMarked[i]) {
				for(int j = 0; j < WORD_LENGTH; j++) {
					if (!answerMarked[j] && guess.charAt(i) == answer.charAt(j)) {
						colors[i] = PRESENT_COLOR; //set to yellow
						answerMarked[j] = true; //mark position in the answer
						guessMarked[i] = true; //mark position in the guess
						break;
						
					}
				}
			}
		}
		for(int i = 0; i < WORD_LENGTH; i++) {
			if(!guessMarked[i]) { //if no match for letter
				colors[i] = ABSENT_COLOR; //set to dark gray
			}
		}
		return colors;
	}

	/**
	 * Based off the accepted guesses, returns a color corresponding to whether the
	 * given letter has been found in the correct position (CORRECT_COLOR), has been
	 * found in the incorrect position (PRESENT_COLOR), is absent from the answer
	 * (ABSENT_COLOR) or hasn't been guessed yet (DEFAULT_COLOR)
	 * 
	 * @precondition letter is a string of length 1
	 */
	public Color getKeyboardLetterColor(String letter) {
		char first = letter.charAt(0);
		Color color = DEFAULT_COLOR;

		for(String guess : acceptedGuesses) {
			for(int i = 0; i < WORD_LENGTH; i++) { //sequential search through each guess in the accepted guesses
				if(guess.charAt(i) == first) {
					if(answer.charAt(i) == first) { //green case
						return CORRECT_COLOR;
					} else if (answer.indexOf(first) != -1) {
						color = PRESENT_COLOR; //yellow case
					} else {
						color = ABSENT_COLOR; //grey case
					}
				}
			}
		}
		return color; //lastly return the color with has been modified appropiately 
	}
}

