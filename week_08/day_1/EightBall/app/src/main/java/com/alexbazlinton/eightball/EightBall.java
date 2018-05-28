package com.alexbazlinton.eightball;

/**
 * Created by allymcgilloway on 12/12/2017.
 */

public class EightBall {
    AnswerProvider answerProvider;

    public EightBall(AnswerProvider answerProvider){
        this.answerProvider = answerProvider;
    }

    public String randomAnswer(){
        return answerProvider.getRandomAnswer();

    }

}
