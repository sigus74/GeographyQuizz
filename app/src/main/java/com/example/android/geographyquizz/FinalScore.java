package com.example.android.geographyquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FinalScore extends AppCompatActivity {

    private int score;
    private TextView correctAnswerEnumTxtView;
    private TextView correctAnswer1TxtView;
    private TextView correctAnswer2TxtView;
    private TextView correctAnswer3TxtView;
    private TextView correctAnswer4TxtView;
    private TextView correctAnswer5TxtView;
    private TextView correctAnswer6TxtView;
    private TextView correctAnswer7TxtView;
    private Button submitMyAnswersButton;
    private Button tryAgainButton;

    private static final String ANSWERS_ENUM="correct_answer_enum";
    private CharSequence answerEnum;
    private static final String ANSWER1="correct_answer_1";
    private CharSequence answer1;
    private static final String ANSWER2="correct_answer_2";
    private CharSequence answer2;
    private static final String ANSWER3="correct_answer_3";
    private CharSequence answer3;
    private static final String ANSWER4="correct_answer_4";
    private CharSequence answer4;
    private static final String ANSWER5="correct_answer_5";
    private CharSequence answer5;
    private static final String ANSWER6="correct_answer_6";
    private CharSequence answer6;
    private static final String ANSWER7="correct_answer_7";
    private CharSequence answer7;

    private static final String SUBMIT_ENABLE_STATUS = "submit_enable_status";
    private Boolean submitButtonEnableStatus;
    private static final String SUBMIT_VISIBILITY_STATUS = "submit_visibility_status";
    private Integer submitButtonVisibilityStatus;

    private static final String TRY_ENABLE_STATUS = "try_enable_status";
    private Boolean tryButtonEnableStatus;
    private static final String TRY_VISIBILITY_STATUS = "try_visibility_status";
    private Integer tryButtonVisibilityStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        correctAnswerEnumTxtView = (TextView) findViewById(R.id.correct_answer_enum_text_view);
        correctAnswer1TxtView = (TextView) findViewById(R.id.correct_answer1_text_view);
        correctAnswer2TxtView = (TextView) findViewById(R.id.correct_answer2_text_view);
        correctAnswer3TxtView = (TextView) findViewById(R.id.correct_answer3_text_view);
        correctAnswer4TxtView = (TextView) findViewById(R.id.correct_answer4_text_view);
        correctAnswer5TxtView = (TextView) findViewById(R.id.correct_answer5_text_view);
        correctAnswer6TxtView = (TextView) findViewById(R.id.correct_answer6_text_view);
        correctAnswer7TxtView = (TextView) findViewById(R.id.correct_answer7_text_view);

        submitMyAnswersButton = (Button) findViewById(R.id.submit_button);
        tryAgainButton = (Button) findViewById(R.id.try_again_button);

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        if(savedInstanceState!=null)
        {
            answerEnum = savedInstanceState.getCharSequence(ANSWERS_ENUM,"");
            correctAnswerEnumTxtView.setText(answerEnum);
            answer1 = savedInstanceState.getCharSequence(ANSWER1,"");
            correctAnswer1TxtView.setText(answer1);
            answer2 = savedInstanceState.getCharSequence(ANSWER2,"");
            correctAnswer2TxtView.setText(answer2);
            answer3 = savedInstanceState.getCharSequence(ANSWER3,"");
            correctAnswer3TxtView.setText(answer3);
            answer4 = savedInstanceState.getCharSequence(ANSWER4,"");
            correctAnswer4TxtView.setText(answer4);
            answer5 = savedInstanceState.getCharSequence(ANSWER5,"");
            correctAnswer5TxtView.setText(answer5);
            answer6 = savedInstanceState.getCharSequence(ANSWER6,"");
            correctAnswer6TxtView.setText(answer6);
            answer7 = savedInstanceState.getCharSequence(ANSWER7,"");
            correctAnswer7TxtView.setText(answer7);

            submitButtonEnableStatus = savedInstanceState.getBoolean(SUBMIT_ENABLE_STATUS);
            submitMyAnswersButton.setEnabled(submitButtonEnableStatus);
            submitButtonVisibilityStatus = savedInstanceState.getInt(SUBMIT_VISIBILITY_STATUS);
            submitMyAnswersButton.setVisibility(submitButtonVisibilityStatus);
            tryButtonEnableStatus = savedInstanceState.getBoolean(TRY_ENABLE_STATUS);
            tryAgainButton.setEnabled(tryButtonEnableStatus);
            tryButtonVisibilityStatus = savedInstanceState.getInt(TRY_VISIBILITY_STATUS);
            tryAgainButton.setVisibility(tryButtonVisibilityStatus);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        answerEnum = correctAnswerEnumTxtView.getText();
        outState.putCharSequence(ANSWERS_ENUM, answerEnum);
        answer1 = correctAnswer1TxtView.getText();
        outState.putCharSequence(ANSWER1, answer1);
        answer2 = correctAnswer2TxtView.getText();
        outState.putCharSequence(ANSWER2, answer2);
        answer3 = correctAnswer3TxtView.getText();
        outState.putCharSequence(ANSWER3, answer3);
        answer4 = correctAnswer4TxtView.getText();
        outState.putCharSequence(ANSWER4, answer4);
        answer5 = correctAnswer5TxtView.getText();
        outState.putCharSequence(ANSWER5, answer5);
        answer6 = correctAnswer6TxtView.getText();
        outState.putCharSequence(ANSWER6, answer6);
        answer7 = correctAnswer7TxtView.getText();
        outState.putCharSequence(ANSWER7, answer7);

        submitButtonEnableStatus = submitMyAnswersButton.isEnabled();
        outState.putBoolean(SUBMIT_ENABLE_STATUS, submitButtonEnableStatus);
        submitButtonVisibilityStatus = submitMyAnswersButton.getVisibility();
        outState.putInt(SUBMIT_VISIBILITY_STATUS,submitButtonVisibilityStatus);
        tryButtonEnableStatus = tryAgainButton.isEnabled();
        outState.putBoolean(TRY_ENABLE_STATUS,tryButtonEnableStatus);
        tryButtonVisibilityStatus = tryAgainButton.getVisibility();
        outState.putInt(TRY_VISIBILITY_STATUS, tryButtonVisibilityStatus);
    }

    public void onSubmitClicked(View view)
    {
        correctAnswerEnumTxtView.setText(R.string.correct_answer_enum_text_view_message);
        correctAnswer1TxtView.setText(R.string.correct_answer1_text_view_message);
        correctAnswer2TxtView.setText(R.string.correct_answer2_text_view_message);
        correctAnswer3TxtView.setText(R.string.correct_answer3_text_view_message);
        correctAnswer4TxtView.setText(R.string.correct_answer4_text_view_message);
        correctAnswer5TxtView.setText(R.string.correct_answer5_text_view_message);
        correctAnswer6TxtView.setText(R.string.correct_answer6_text_view_message);
        correctAnswer7TxtView.setText(R.string.correct_answer7_text_view_message);

        Toast.makeText(FinalScore.this,"Your score is "+score+"/7", Toast.LENGTH_LONG).show();
        tryAgainButton.setVisibility(View.VISIBLE);
        tryAgainButton.setEnabled(true);
        submitMyAnswersButton.setVisibility((View.INVISIBLE));
        submitMyAnswersButton.setEnabled(false);
    }

    public void onTryAgainClicked(View view)
    {
        Intent intentMainActivity = new Intent(this, MainActivity.class);
        startActivity(intentMainActivity);
    }

    @Override
    public void onBackPressed() {
    }
}
