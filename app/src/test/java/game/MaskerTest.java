package game;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;

public class MaskerTest {

  @Test public void testGetsWordToGuess() {
    ArrayList<Character> guessedWords = new ArrayList<Character>();
    guessedWords.add('A');
    guessedWords.add('R');
    assertEquals("hides the letters in the word", "MA__R_", Masker.getWordToGuess("MAKERS", guessedWords));
  }
  
}
