package game;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class GameTest {
  @Test public void testGetsWordToGuess() {
    WordChooser mockedChooser = mock(WordChooser.class);
    when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
    Game game = new Game(mockedChooser);
    assertEquals("hides the letters in the word", "M_____", game.getWordToGuess());
  }

  @Test public void testGetRemainingAttempts() {
    WordChooser wordChooser = new WordChooser();
    Game game = new Game(wordChooser);
    assertEquals("initializes with 10 remaining attempts", Integer.valueOf(10), game.getRemainingAttempts());
  }

  @Test public void testGuessLetterRightGuess() {
    WordChooser mockedChooser = mock(WordChooser.class);
    when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
    Game game = new Game(mockedChooser);
    assertEquals("confirms a correct guess", true, game.guessLetter('K'));
    assertEquals("stores the correct guesses", true, game.guessedLetters.contains('K'));
    assertEquals("displays correctly guessed letters", "M_K___", game.getWordToGuess());
  }

  @Test public void testGuessLetterWrongGuess() {
    WordChooser mockedChooser = mock(WordChooser.class);
    when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
    Game game = new Game(mockedChooser);
    assertEquals("confirms an incorrect guess", false, game.guessLetter('Z'));
    assertEquals("deducts a life", game.getRemainingAttempts(), Integer.valueOf(9));
  }

  @Test public void testIsGameLost() {
    WordChooser mockedChooser = mock(WordChooser.class);
    when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
    Game game = new Game(mockedChooser);
    for (int i = 1; i < 10; i ++) {
      game.guessLetter('P');
    }
    assertEquals("checks if games is lost", false, game.isGameLost());
    game.guessLetter('Q');
    assertEquals("checks if games is lost", true, game.isGameLost());
  }

  @Test public void testIsGameWon() {
    WordChooser mockedChooser = mock(WordChooser.class);
    when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
    Game game = new Game(mockedChooser);
    game.guessLetter('A');
    game.guessLetter('K');
    game.guessLetter('E');
    game.guessLetter('R');
    game.guessLetter('S');
    assertEquals("checks if game is won", true, game.isGameWon());
  }
}
