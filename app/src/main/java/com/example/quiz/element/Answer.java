package com.example.quiz.element;

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

    public double getAnswerPoints() {
        if (correspondingButton == null) {
            return 0.0d;
        }

        if (!correspondingButton.isChecked()) {
            return 0.0d;
        } else {
            if (isCorrect) {
                return 1.0d;
            } else {
                return -0.5d;
            }
        }
    }
}
