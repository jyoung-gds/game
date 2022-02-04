package game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordChooserTest {
  
  @Test public void testGetsRandomWordFromDictionary() {
    WordChooser wordchooser = new WordChooser();
    assertEquals(wordchooser.getRandomWordFromDictionary().isEmpty(), false);
    assertEquals(wordchooser.getRandomWordFromDictionary().getClass(), String.class);
  }

}
