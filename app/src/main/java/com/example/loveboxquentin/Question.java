package com.example.loveboxquentin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class Question extends AppCompatActivity {

    TextView Question;
    //ImageView photoHaut, photoBas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();


        Question = findViewById(R.id.QuestionString);
        //photoHaut = findViewById(R.id.photoHaut);
        //photoBas = findViewById(R.id.photoBas);
    }
}