package com.example.quiz.element;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private final String questionText;
    private final List<Answer> answers;

    public Question(String questionText) {
        this.questionText = questionText;
        this.answers = new ArrayList<>();
    }

    public void addAnswer(String answerText, boolean isCorrect) {
        answers.add(new Answer(answerText, isCorrect));
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
