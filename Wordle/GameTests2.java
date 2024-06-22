package game;

import static org.junit.Assert.*;

import java.awt.Color;

import static game.TestData.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * These are the tests for Activity 3. You shouldn't modify this file, but you might want to
 * look to see why tests are failing.
 */
public class GameTests2 {

	@Test
	public void getGuessColorsReturnsCorrectValues() {
		Game game = new Game(SINGLE_ANSWER_DICTIONARY, SHORT_DICTIONARY);

		assertArrayEquals(new Color[] { Game.CORRECT_COLOR, Game.ABSENT_COLOR, Game.ABSENT_COLOR,
				Game.PRESENT_COLOR, Game.PRESENT_COLOR }, game.getGuessColors("abhor"));
	}

	@Test
	public void getKeyboardLetterReturnsDefaultWithNoGuesses() {
		Game game = new Game(SINGLE_ANSWER_DICTIONARY, SHORT_DICTIONARY);

		assertEquals(Game.DEFAULT_COLOR, game.getKeyboardLetterColor("a"));
		assertEquals(Game.DEFAULT_COLOR, game.getKeyboardLetterColor("b"));
	}

	@Test
	public void getKeyboardLetterAfterGuess() {
		Game game = new Game(SINGLE_ANSWER_DICTIONARY, SHORT_DICTIONARY);
		game.setGuessAttempt("abhor");
		game.submitGuess();

		assertEquals(Game.CORRECT_COLOR, game.getKeyboardLetterColor("a"));
		assertEquals(Game.ABSENT_COLOR, game.getKeyboardLetterColor("b"));
		assertEquals(Game.ABSENT_COLOR, game.getKeyboardLetterColor("h"));
		assertEquals(Game.PRESENT_COLOR, game.getKeyboardLetterColor("o"));
		assertEquals(Game.PRESENT_COLOR, game.getKeyboardLetterColor("r"));
		assertEquals(Game.DEFAULT_COLOR, game.getKeyboardLetterColor("j"));
		assertEquals(Game.DEFAULT_COLOR, game.getKeyboardLetterColor("c"));
	}

	@Test //(I DID EXTRA CREDIT)
	public void getKeyboardLetterAfterGuesses() {
		Game game = new Game(SINGLE_ANSWER_DICTIONARY, SHORT_DICTIONARY);
		game.setGuessAttempt("abhor");
		game.submitGuess();

		game.setGuessAttempt("abode");
		game.submitGuess();

		assertEquals(Game.CORRECT_COLOR, game.getKeyboardLetterColor("o"));
		assertEquals(Game.PRESENT_COLOR, game.getKeyboardLetterColor("r"));
		assertEquals(Game.ABSENT_COLOR, game.getKeyboardLetterColor("e"));
	}

	// This test is only used for extra credit
	@Test
	public void advancedGetGuessColorsReturnsCorrectValues() {
		Game game = new Game(new Dictionary(new String[] {"parry"}), new Dictionary(new String[] {}));
		
		assertArrayEquals(new Color[] { Game.ABSENT_COLOR, Game.PRESENT_COLOR, Game.CORRECT_COLOR,
				Game.ABSENT_COLOR, Game.ABSENT_COLOR }, game.getGuessColors("error"));
		
		game = new Game(new Dictionary(new String[] {"tardy"}), new Dictionary(new String[] {}));
		
		assertArrayEquals(new Color[] { Game.ABSENT_COLOR, Game.ABSENT_COLOR, Game.CORRECT_COLOR,
				Game.ABSENT_COLOR, Game.ABSENT_COLOR }, game.getGuessColors("error"));
	}
}
