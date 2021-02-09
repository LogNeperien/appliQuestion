package com.example.loveboxquentin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonQuestion;
    DatabaseHelper db;
    TextView question1, question2, question3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonQuestion = (Button) findViewById(R.id.buttonQuestion);
        question1 = findViewById(R.id.textView);
        question2 = findViewById(R.id.question2);
        question3 = findViewById(R.id.question3);
        //BDD
        db = new DatabaseHelper(this);
        int nombreQuestion = 3;

        buttonQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        Cursor data = db.getAllQuestion();
        StringBuffer buffer = new StringBuffer();
        if(data.getCount() == 0)
        {
            Toast.makeText(MainActivity.this,"Error, No Data Found !!",Toast.LENGTH_LONG).show();
            boolean isInserted1 = db.insertDataMatch("Je chausse du combien ?");
            boolean isInserted2 = db.insertDataMatch("La remarque qui revenait tout le temp sur mes bulletins scolaire  ?");
            boolean isInserted3 = db.insertDataMatch("Quel est le mot ou l'expression que j'utilise tout le temps ?");
        }

        data = db.getAllQuestion();

        if(data.getCount() == nombreQuestion )
        {
            String[] listeQuestion;
            listeQuestion = new String[data.getCount()];
            int i = 0;

            while(data.moveToNext())
            {
                listeQuestion[i] = data.getString(0);
                i++;
            }
            question1.setText(listeQuestion[0]);
            question2.setText(listeQuestion[1]);
            question3.setText(listeQuestion[2]);
        }
        else
        {
            buffer.append("il y a " + data.	getCount() + "données");
            Toast.makeText(MainActivity.this, buffer.toString(), Toast.LENGTH_LONG).show();
        }

    }


    public void openNewActivity() {
        Intent i = new Intent(this, Question.class);
        startActivity(i);
    }

    /*public void affichageDB(View view)
    {
        Cursor data = db.getAllData();
        if(data.getCount() == 0)
        {
            Toast.makeText(MainActivity.this,"Error, No Data Found !!",Toast.LENGTH_LONG).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();

        while(data.moveToNext())
        {
            buffer.append("question : " + data.getString(1));
        }
        Toast.makeText(MainActivity.this, buffer.toString(), Toast.LENGTH_LONG).show();
    }*/



}