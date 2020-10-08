package com.example.quiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox q1a1 = findViewById(R.id.q1_a1);

        Button clearButton = findViewById(R.id.clearButton);
        Button submitButton = findViewById(R.id.submitButton);

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
}