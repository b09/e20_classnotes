package com.alexbazlinton.eightball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EightBallActivity extends AppCompatActivity {

  private EditText questionEditText;
  private TextView answerTextView;
  private Button shakeButton;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_eight_ball);

    questionEditText = findViewById(R.id.questionEditText);
    answerTextView = findViewById(R.id.answerTextView);
    shakeButton = findViewById(R.id.shakeButton);
    answerTextView.setText("The answer will go here");

  }

  public void onShakeButtonClicked(View button){

    AnswerProvider answerProvider = new AnswerProvider();
    EightBall eightBall = new EightBall(answerProvider);
    String randomAnswer = eightBall.randomAnswer();
    answerTextView.setText(randomAnswer);

    String question = questionEditText.getText().toString();
    Log.d(getClass().toString(), "The question asked was" + question);
  }



}
