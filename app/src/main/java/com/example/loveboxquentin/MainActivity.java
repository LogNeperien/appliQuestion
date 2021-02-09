package com.example.loveboxquentin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonQuestion;
    TextView question1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonQuestion = (Button) findViewById(R.id.buttonQuestion);
        question1 = findViewById(R.id.textView);

        buttonQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

    }


    public void openNewActivity() {
        Intent i = new Intent(this, Question.class);
        startActivity(i);
    }

}