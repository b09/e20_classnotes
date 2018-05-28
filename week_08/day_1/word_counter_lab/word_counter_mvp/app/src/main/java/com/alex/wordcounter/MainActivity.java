package com.alex.wordcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private TextView showCountsTextView;
  private EditText wordsToCountEditText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    showCountsTextView = findViewById(R.id.main_showCounts);
    wordsToCountEditText = findViewById(R.id.main_enterText);
  }

  public void countWordsButtonClicked(View view){
    String enterTextWords = wordsToCountEditText.getText().toString();
    WordCounter wordCounter = new WordCounter(enterTextWords);
    String wordCount = "Word Count: " + String.valueOf(wordCounter.getWordCount());
    showCountsTextView.setText(wordCount);
  }



}
