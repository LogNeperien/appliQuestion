package com.example.loveboxquentin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonQuestion = findViewById(R.id.buttonQuestion);
    }


    public void launchSecondActivity(View view) {
        switch (view.getId()) {

            case R.id.buttonQuestion:
                Intent i = new Intent(this, Question.class);
                startActivity(i);
                break;

            default:
                //Envoyer l'id du match dans un extra en fonction du bouton cliqué
        }
    }
}