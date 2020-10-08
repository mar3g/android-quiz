package com.example.quiz.elements;

import android.widget.CompoundButton;

public class Answer {

    private final String answerText;
    private final boolean isCorrect;
    private CompoundButton correspondingButton;

    public Answer(String answerText, boolean isCorrect) {
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrespondingButton(CompoundButton correspondingButton) {
        this.correspondingButton = correspondingButton;
    }

    public CompoundButton getCorrespondingButton() {
        return correspondingButton;
    }
}
