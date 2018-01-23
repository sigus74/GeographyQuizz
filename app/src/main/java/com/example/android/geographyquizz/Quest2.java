package com.example.android.geographyquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.content.Intent;

public class Quest2 extends AppCompatActivity
{

    private RadioGroup answerRadioGroup;
    private RadioButton correctRadioButton2;
    private Button nextButton;
    private int score;
    private int checkedIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest2);
        answerRadioGroup = (RadioGroup) findViewById(R.id.answer_radio_group2);
        correctRadioButton2 = (RadioButton) findViewById(R.id.quest2_correctAnswer);
        nextButton = (Button) findViewById(R.id.next_button_2);

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
        int correctIndex= correctRadioButton2.getId();
        int checkedIndex=answerRadioGroup.getCheckedRadioButtonId();
        if (checkedIndex==correctIndex)
        {
            score=score+1;
        }

        Intent intentQuest3 = new Intent(this, Quest3.class);
        intentQuest3.putExtra("score", score);
        startActivity(intentQuest3);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(Quest2.this, "Your test is not finished yet", Toast.LENGTH_SHORT).show();
    }
}

