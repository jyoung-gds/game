package game;

import java.util.Random;

public class WordChooser {

  private static final String[] DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

  public String getRandomWordFromDictionary() {
    Random randomIndex = new Random();
    return DICTIONARY[randomIndex.nextInt(DICTIONARY.length)];
  }
  
}
