package game;

import java.util.ArrayList;

public class Game {

  private String wordToGuess;
  private Integer remainingAttempts;
  public ArrayList<Character> guessedLetters = new ArrayList<Character>();

  public Game(WordChooser wordChooser) {
    this.wordToGuess = wordChooser.getRandomWordFromDictionary();
    this.remainingAttempts = 10;
  }

  public String getWordToGuess() {
    StringBuilder hiddenWord = new StringBuilder();
    hiddenWord.append(wordToGuess.charAt(0));
    for (int i = 1; i < wordToGuess.length(); i++) {
      if (this.guessedLetters.contains(wordToGuess.charAt(i))) {
        hiddenWord.append(wordToGuess.charAt(i));
      }
      else {
        hiddenWord.append("_");
      }
    }
    return hiddenWord.toString();
  }

  public Integer getRemainingAttempts() {
    return remainingAttempts;
  }

  public boolean guessLetter(char guess) {
    if (wordToGuess.contains(Character.toString(guess))) {
      this.guessedLetters.add(guess);
      return true;
    }
    else {
      this.remainingAttempts--;
      return false;
    }

  }

  public boolean isGameLost() {
    if (this.getRemainingAttempts() <= Integer.valueOf(0)) {
      return true;
    }
    else {
      return false;
    }
    
  }

  public boolean isGameWon() {
    if (this.getWordToGuess().equals(wordToGuess)) {
      return true;
    }
    else {
      return false;
    }
  }

}
