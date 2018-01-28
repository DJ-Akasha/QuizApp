package com.example.android.quizapp;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Views are defined here so that they can then be initialised within onCreate method
    TextView question1;

    CheckBox question2a;
    CheckBox question2b;
    CheckBox question2c;
    CheckBox question2d;

    RadioButton question3;
    RadioGroup radioGroup3;
    RadioButton question4;
    RadioGroup radioGroup4;

    CheckBox question5a;
    CheckBox question5b;
    CheckBox question5c;
    CheckBox question5d;

    TextView question6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialise the views so findViewById is only used here and can be
        // called upon in other places within the code. Apparently this is better
        // use of resources/memory.
        question1 = findViewById(R.id.answer_q1);

        question2a = findViewById(R.id.answer_error);
        question2b = findViewById(R.id.answer_chat);
        question2c = findViewById(R.id.answer_warning);
        question2d = findViewById(R.id.answer_info);

        question3 = findViewById(R.id.void_correct);
        radioGroup3 = findViewById(R.id.radio_group_q3);

        question4 = findViewById(R.id.answer_true);
        radioGroup4 = findViewById(R.id.radio_group_q4);

        question5a = findViewById(R.id.answer_local);
        question5b = findViewById(R.id.answer_national);
        question5c = findViewById(R.id.answer_global);
        question5d = findViewById(R.id.answer_international);

        question6 = findViewById(R.id.answer_q6);
    }

    private int getTotalScore() {
        int score = 0;

        //Check the answer to Question 1
        String q1Answer = question1.getText().toString();
        if (q1Answer.equals("String") || q1Answer.equals("String ")) {
            score += 1;
        } else {
        }

        //Check the answer to Question 2
        if (question2a.isChecked() && !question2b.isChecked() && question2c.isChecked() && !question2d.isChecked()) {
            score += 1;
        }

        //Check the answer to Question 3
        if (question3.isChecked()) {
            score += 1;
        }

        //Check the answer to Question 4
        if (question4.isChecked()) {
            score += 1;
        }

        //Check the answer to Question 5
        if (question5a.isChecked() && !question5b.isChecked() && question5c.isChecked() && !question5d.isChecked()) {
            score += 1;
        }

        //Check the answer to Question 6.
        String q6Answer = question6.getText().toString();
        if (q6Answer.equals("onCreate") || q6Answer.equals("onCreate ")) {
            score += 1;
        } else {
        }

        return score;
    }

    // This method is called when the submitButton is clicked.
    // It produces a Toast message with the user's total score.
    public void submitButton(View view) {
        Toast.makeText(this, getString(R.string.toast_message) + getTotalScore(), Toast.LENGTH_LONG).show();
    }

    // This method is called when the resetButton is clicked.
    // It resets all answers to clear/blank.
    public void resetButton(View view) {
        question1.setText("");

        question2a.setChecked(false);
        question2b.setChecked(false);
        question2c.setChecked(false);
        question2d.setChecked(false);

        radioGroup3.clearCheck();

        radioGroup4.clearCheck();

        question5a.setChecked(false);
        question5b.setChecked(false);
        question5c.setChecked(false);
        question5d.setChecked(false);

        question6.setText("");
    }

    // This method hides the keyboard when the user clicks away from the EditText box
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
