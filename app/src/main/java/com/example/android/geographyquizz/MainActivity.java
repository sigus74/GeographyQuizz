package com.example.android.geographyquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openQuest1(View view)
    {
        score = 0;
        Intent intentQuest1 = new Intent(this, Quest1.class);
        intentQuest1.putExtra("score", score);
        startActivity(intentQuest1);
    }
}
