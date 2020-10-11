package com.example.quiz.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quiz.R;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> finish());

        displayScore();
        displayCorrectAnswers();
    }

    private void displayScore() {
        Bundle extras = getIntent().getExtras();
        double score = 0.0d;
        if (extras != null) {
            score = extras.getDouble("score");
        }

        TextView resultsText = findViewById(R.id.results_text);
        resultsText.setText("Your final score is: " + score);
    }

    private void displayCorrectAnswers() {
        StringBuilder correctAnswers = new StringBuilder();
        correctAnswers.append("The correct answers were: \n\n");
        MainActivity.getQuestions().forEach(q -> {
            correctAnswers.append(" Q: " + q.getQuestionText() + ":\n");
            q.getAnswers().forEach(a -> {
                if(a.isCorrect()) {
                    correctAnswers.append("  - " + a.getAnswerText() + "\n");
                }
            });
            correctAnswers.append("\n");
        });

        TextView correctAnswersText = findViewById(R.id.correct_answers);
        correctAnswersText.setText(correctAnswers.toString());
    }
}
