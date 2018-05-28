package com.alex.wordcounter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alex on 22/01/2018.
 */

public class WordCounterTest {

  private WordCounter wordCounter;

  @Before
  public void before(){
    String words = "Two two three three three one";
    wordCounter = new WordCounter(words);
  }

  @Test
  public void canGetWordCount(){
    assertEquals(6, wordCounter.getWordCount());
  }
}
