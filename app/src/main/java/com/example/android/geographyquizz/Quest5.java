package com.example.android.geographyquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.content.Intent;

public class Quest5 extends AppCompatActivity
{

    private RadioGroup answerRadioGroup;
    private RadioButton correctRadioButton5;
    private Button nextButton;
    private int score;
    private int checkedIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest5);
        answerRadioGroup = (RadioGroup) findViewById(R.id.answer_radio_group5);
        correctRadioButton5 = (RadioButton) findViewById(R.id.quest5_correctAnswer);
        nextButton = (Button) findViewById(R.id.next_button_5);

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        addListenerOnRadioButton();
    }

    private void addListenerOnRadioButton() {
        answerRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                checkedIndex = answerRadioGroup.getCheckedRadioButtonId();
                if (checkedIndex != -1) {
                    nextButton.setEnabled(true);
                }
            }
        });

    }

    public void onNextButtonClicked(View view)
    {
        int correctIndex= correctRadioButton5.getId();
        int checkedIndex=answerRadioGroup.getCheckedRadioButtonId();
        if (checkedIndex==correctIndex)
        {
            score=score+1;
        }

        Intent intentQuest6 = new Intent(this, Quest6.class);
        intentQuest6.putExtra("score", score);
        startActivity(intentQuest6);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(Quest5.this, "Your test is not finished yet", Toast.LENGTH_SHORT).show();
    }
}

