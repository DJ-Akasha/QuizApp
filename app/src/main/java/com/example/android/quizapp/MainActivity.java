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

    // Views are defined here so that they can then be initialised within onCreate method.
    // Found on stackOverflow - https://stackoverflow.com/questions/32159239/android-what-is-best-practice-for-declaring-view-components-in-an-activity
    // author Hussein El Feky, date 22 August 2015.
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

    RadioButton question7;
    RadioGroup radioGroup7;

    CheckBox question8a;
    CheckBox question8b;
    CheckBox question8c;
    CheckBox question8d;

    TextView question9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialise the views so findViewById is only used here and can be
        // called upon in other places within the code. Apparently this is better
        // use of resources/memory. Found on stackOverflow - https://stackoverflow.com/questions/32159239/android-what-is-best-practice-for-declaring-view-components-in-an-activity
        // author Hussein El Feky, date 22 August 2015.
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

        question7 = findViewById(R.id.concotenation_correct);
        radioGroup7 = findViewById(R.id.radio_group_q7);

        question8a = findViewById(R.id.answer_else);
        question8b = findViewById(R.id.answer_native);
        question8c = findViewById(R.id.answer_int);
        question8d = findViewById(R.id.answer_return);

        question9 = findViewById(R.id.answer_q9);
    }

    private int getTotalScore() {
        int score = 0;

        //Check the answer to Question 1 - found on stackOverflow - https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
        // author Aaron Maenpaa, date last edit 11 December 2017.
        String q1Answer = question1.getText().toString();
        if (q1Answer.equals("String") || q1Answer.equals("String ")) {
            score += 1;
        } else {
        }

        //Check the answer to Question 2 - found on stackOverflow and dotNetPerls - https://stackoverflow.com/questions/18336151/how-to-check-if-android-checkbox-is-checked-within-its-onclick-method-declared/31448205
        // author Anand, date 20 August 2013.
        // - https://www.dotnetperls.com/if-java
        // author Unknown, date Unknown. Learned about how to use && and || and learned that ! is important so I looked it up and found that it could be used here.
        if (question2a.isChecked() && !question2b.isChecked() && question2c.isChecked() && !question2d.isChecked()) {
            score += 1;
        }

        //Check the answer to Question 3 - found on stackOverflow - https://stackoverflow.com/questions/11050074/how-to-check-if-radiobutton-is-checked
        // author FabianCook, date 15 June 2012.
        if (question3.isChecked()) {
            score += 1;
        }

        //Check the answer to Question 4 - found on stackOverflow - https://stackoverflow.com/questions/11050074/how-to-check-if-radiobutton-is-checked
        // author FabianCook, date 15 June 2012.
        if (question4.isChecked()) {
            score += 1;
        }

        //Check the answer to Question 5 - found on stackOverflow and dotNetPerls - https://stackoverflow.com/questions/18336151/how-to-check-if-android-checkbox-is-checked-within-its-onclick-method-declared/31448205
        // author Anand, date 20 August 2013.
        // - https://www.dotnetperls.com/if-java
        // author Unknown, date Unknown. Learned about how to use && and || and learned that ! is important so I looked it up and found that it could be used here.
        if (question5a.isChecked() && !question5b.isChecked() && question5c.isChecked() && !question5d.isChecked()) {
            score += 1;
        }

        //Check the answer to Question 6 - found on stackOverflow - https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
        // author Aaron Maenpaa, date last edit 11 December 2017.
        String q6Answer = question6.getText().toString();
        if (q6Answer.equals("onCreate") || q6Answer.equals("onCreate ")) {
            score += 1;
        } else {
        }

        //Check the answer to Question 7 - found on stackOverflow - https://stackoverflow.com/questions/11050074/how-to-check-if-radiobutton-is-checked
        // author FabianCook, date 15 June 2012.
        if (question7.isChecked()) {
            score += 1;
        }

        //Check the answer to Question 8 - found on stackOverflow and dotNetPerls - https://stackoverflow.com/questions/18336151/how-to-check-if-android-checkbox-is-checked-within-its-onclick-method-declared/31448205
        // author Anand, date 20 August 2013.
        // - https://www.dotnetperls.com/if-java
        // author Unknown, date Unknown. Learned about how to use && and || and learned that ! is important so I looked it up and found that it could be used here.
        if (question8a.isChecked() && question8b.isChecked() && question8c.isChecked() && question8d.isChecked()) {
            score += 1;
        }

        //Check the answer to Question 9 - found on stackOverflow - https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
        // author Aaron Maenpaa, date last edit 11 December 2017.
        String q9Answer = question9.getText().toString();
        if (q9Answer.equals("!=") || q9Answer.equals("!= ") || q9Answer.equals("! =") || q9Answer.equals("! = ")) {
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

    // This method is called when the resetButton is clicked. - found on stackOverflow
    // It resets all answers to clear/blank.
    public void resetButton(View view) {
        // Found on stackOverflow - https://stackoverflow.com/questions/11102114/how-to-clear-a-string
        // author Stephen C, date 19 June 2012.
        question1.setText("");

        // Found on stackOverflow - https://stackoverflow.com/questions/37410145/how-to-unchecked-the-checked-checkbox
        // author Malith Lakshan, date 24 May 2016.
        question2a.setChecked(false);
        question2b.setChecked(false);
        question2c.setChecked(false);
        question2d.setChecked(false);

        // Found on stackOverflow - https://stackoverflow.com/questions/15836789/android-radio-button-uncheck
        // author spaaarky21, date 7 March 2014
        radioGroup3.clearCheck();

        // Found on stackOverflow - https://stackoverflow.com/questions/15836789/android-radio-button-uncheck
        // author spaaarky21, date 7 March 2014
        radioGroup4.clearCheck();

        // Found on stackOverflow - https://stackoverflow.com/questions/37410145/how-to-unchecked-the-checked-checkbox
        // author Malith Lakshan, date 24 May 2016.
        question5a.setChecked(false);
        question5b.setChecked(false);
        question5c.setChecked(false);
        question5d.setChecked(false);

        // Found on stackOverflow - https://stackoverflow.com/questions/11102114/how-to-clear-a-string
        // author Stephen C, date 19 June 2012.
        question6.setText("");

        // Found on stackOverflow - https://stackoverflow.com/questions/15836789/android-radio-button-uncheck
        // author spaaarky21, date 7 March 2014
        radioGroup7.clearCheck();

        // Found on stackOverflow - https://stackoverflow.com/questions/37410145/how-to-unchecked-the-checked-checkbox
        // author Malith Lakshan, date 24 May 2016.
        question8a.setChecked(false);
        question8b.setChecked(false);
        question8c.setChecked(false);
        question8d.setChecked(false);

        // Found on stackOverflow - https://stackoverflow.com/questions/11102114/how-to-clear-a-string
        // author Stephen C, date 19 June 2012.
        question9.setText("");
    }

    // This method hides the keyboard when the user clicks away from the EditText box
    // Found on stackOverflow - https://stackoverflow.com/questions/4165414/how-to-hide-soft-keyboard-on-android-after-clicking-outside-edittext/16176277#16176277
    // author Hoang Trinh, date 27 July 2014.
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
