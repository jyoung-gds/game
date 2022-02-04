package game;

import java.util.ArrayList;

public class Masker {
  
  public static String getWordToGuess(String wordToGuess, ArrayList<Character> guessedLetters) {
    StringBuilder hiddenWord = new StringBuilder();
    hiddenWord.append(wordToGuess.charAt(0));
    for (int i = 1; i < wordToGuess.length(); i++) {
      if (guessedLetters.contains(wordToGuess.charAt(i))) {
        hiddenWord.append(wordToGuess.charAt(i));
      }
      else {
        hiddenWord.append("_");
      }
    }
    return hiddenWord.toString();
  }
}
