package com.example.quiz;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quiz.elements.Question;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize questions
        List<Question> questions = getExemplaryQuestions();

        // initialize answers checkboxes/radiobuttons
        List<CompoundButton> answersButtons = getAnswersButtons();
        connectAnswersWithButtons(questions, answersButtons);
        initializeButtonTexts(questions);

        // initialize questions labels
        List<TextView> questionsTexts = getQuestionTexts();
        initializeQuestionsLabels(questions, questionsTexts);

        // setup buttons
        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(view -> clearAllAnswers(answersButtons));

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(view -> checkTheAnswers(answersButtons));

        // disable buttons until switch state is changed
        clearButton.setEnabled(false);
        submitButton.setEnabled(false);

        // connect switches with adequate buttons
        Switch enableClearSwitch = findViewById(R.id.enableClear);
        connectSwitchWithButtonState(enableClearSwitch, clearButton);

        Switch enableSubmitSwitch = findViewById(R.id.enableSubmit);
        connectSwitchWithButtonState(enableSubmitSwitch, submitButton);
    }

    private void connectSwitchWithButtonState(Switch theSwitch, Button button) {
        theSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> button.setEnabled(isChecked));
    }

    private void clearAllAnswers(List<CompoundButton> answers) {
        answers.forEach(a -> a.setSelected(false));
    }

    private void checkTheAnswers(List<CompoundButton> answers) {

    }

    private List<CompoundButton> getAnswersButtons() {
        CheckBox q1a1 = findViewById(R.id.q1_a1);
        CheckBox q1a2 = findViewById(R.id.q1_a2);
        CheckBox q1a3 = findViewById(R.id.q1_a3);
        CheckBox q2a1 = findViewById(R.id.q2_a1);
        CheckBox q2a2 = findViewById(R.id.q2_a2);
        CheckBox q2a3 = findViewById(R.id.q2_a3);
        RadioButton q3a1 = findViewById(R.id.q3_a1);
        RadioButton q3a2 = findViewById(R.id.q3_a2);
        RadioButton q3a3 = findViewById(R.id.q3_a3);
        RadioButton q4a1 = findViewById(R.id.q4_a1);
        RadioButton q4a2 = findViewById(R.id.q4_a2);
        RadioButton q4a3 = findViewById(R.id.q4_a3);
        return Arrays.asList(q1a1, q1a2, q1a3, q2a1, q2a2, q2a3, q3a1, q3a2, q3a3, q4a1, q4a2, q4a3);
    }

    private List<TextView> getQuestionTexts() {
        TextView q1 = findViewById(R.id.q1);
        TextView q2 = findViewById(R.id.q2);
        TextView q3 = findViewById(R.id.q3);
        TextView q4 = findViewById(R.id.q4);
        return Arrays.asList(q1, q2, q3, q4);
    }

    private List<Question> getExemplaryQuestions() {
        Question q1 = new Question("Which of the following are dividers of 10?");
        q1.addAnswer("2", true);
        q1.addAnswer("5", true);
        q1.addAnswer("6", false);

        Question q2 = new Question("Which of the following are greater than 7?");
        q2.addAnswer("3", false);
        q2.addAnswer("6", false);
        q2.addAnswer("9", true);

        Question q3 = new Question("What is the value of 2+2?");
        q3.addAnswer("2", false);
        q3.addAnswer("4", true);
        q3.addAnswer("8", false);

        Question q4 = new Question("What is the value of 11*3?");
        q4.addAnswer("14", false);
        q4.addAnswer("30", false);
        q4.addAnswer("33", true);

        return Arrays.asList(q1, q2, q3, q4);
    }

    private void initializeQuestionsLabels(List<Question> questions, List<TextView> questionsTexts) {
        for(int i=0; i<questionsTexts.size(); i++){
            questionsTexts.get(i).setText(questions.get(i).getQuestionText());
        }
    }

    private void connectAnswersWithButtons(List<Question> questions, List<CompoundButton> answersButtons) {
        int questionNumber = 0;
        int answerNumber = 0;
        for (CompoundButton button : answersButtons) {
            questions.get(questionNumber).getAnswers().get(answerNumber % 3).setCorrespondingButton(button);
            answerNumber++;
            questionNumber = answerNumber / 3;
        }
    }

    private void initializeButtonTexts(List<Question> questions) {
        questions.forEach(q -> q.getAnswers().forEach(a -> a.getCorrespondingButton().setText(a.getAnswerText())));
    }
}