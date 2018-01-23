package com.example.android.geographyquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class Quest6 extends AppCompatActivity
{
    private CheckBox checkBox1Answer6;
    private CheckBox checkBox2Answer6;
    private CheckBox checkBox3Answer6;
    private CheckBox checkBox4Answer6;
    private EditText editTextAnswer6;
    private boolean isChecked1 = false;
    private boolean isChecked2 = false;
    private boolean isChecked3 = false;
    private boolean isChecked4 = false;
    private String yearString = "";
    private Integer yearInt;
    private Button nextButton;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest6);
        checkBox1Answer6 = (CheckBox) findViewById(R.id.quest6_check_box_1);
        checkBox2Answer6 = (CheckBox) findViewById(R.id.quest6_check_box_2);
        checkBox3Answer6 = (CheckBox) findViewById(R.id.quest6_check_box_3);
        checkBox4Answer6 = (CheckBox) findViewById(R.id.quest6_check_box_4);
        editTextAnswer6 = (EditText) findViewById(R.id.edit_txt_id);
        nextButton = (Button) findViewById(R.id.next_button_6);

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        addListenerOnCheckBox1();
        addListenerOnCheckBox2();
        addListenerOnCheckBox3();
        addListenerOnCheckBox4();
        addListenerOnEditText();
    }

    private void addListenerOnCheckBox1() {
        checkBox1Answer6.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                setNextButtonStatus();
            }
        });
    }

    private void addListenerOnCheckBox2() {
        checkBox2Answer6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextButtonStatus();
            }
        });
    }

    private void addListenerOnCheckBox3() {
        checkBox3Answer6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextButtonStatus();
            }
        });
    }

    private void addListenerOnCheckBox4() {
        checkBox4Answer6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextButtonStatus();
            }
        });
    }

    private void addListenerOnEditText()
    {
        editTextAnswer6.addTextChangedListener(new TextWatcher()
                                               {
                                                   @Override
                                                   public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
                                                   {
                                                   }

                                                   @Override
                                                   public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
                                                   {
                                                   }

                                                   @Override
                                                   public void afterTextChanged(Editable editable)
                                                   {
                                                           setNextButtonStatus();
                                                   }
                                               });
    }

    private void setNextButtonStatus()
    {
        isChecked1 = checkBox1Answer6.isChecked();
        isChecked2 = checkBox2Answer6.isChecked();
        isChecked3 = checkBox3Answer6.isChecked();
        isChecked4 = checkBox4Answer6.isChecked();
        yearString = editTextAnswer6.getText().toString();


        if((isChecked1||isChecked2||isChecked3||isChecked4)&&!yearString.equals(""))
        {

            nextButton.setEnabled(true);
        }
        else
        {
            nextButton.setEnabled(false);
        }
    }

    public void onNextButtonClicked(View view)
    {
       yearInt = Integer.parseInt(yearString);
       if (isChecked1&&!isChecked2&&isChecked3&&isChecked4)
        {
            score=score+1;
        }
        if(yearInt==1993)
        {
            score=score+1;
        }
        Intent intentFinalScore = new Intent(this, FinalScore.class);
        intentFinalScore.putExtra("score", score);
        startActivity(intentFinalScore);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(Quest6.this, "Your Test is not finished yet", Toast.LENGTH_SHORT).show();
    }

}


