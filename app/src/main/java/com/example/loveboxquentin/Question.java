package com.example.loveboxquentin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.database.Cursor;
import android.widget.Toast;


public class Question extends AppCompatActivity {

    TextView Question;
    //ImageView photoHaut, photoBas;
    DatabaseHelper db;
    TextView question1, question2, question3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();

        question1 = findViewById(R.id.question1);
        question2 = findViewById(R.id.question2);
        question3 = findViewById(R.id.question3);
        //photoHaut = findViewById(R.id.photoHaut);
        //photoBas = findViewById(R.id.photoBas);

        //BDD
        db = new DatabaseHelper(this);
        int nombreQuestion = 3;




        Cursor data = db.getAllQuestion();
        StringBuffer buffer = new StringBuffer();
        if(data.getCount() == 0)
        {
            Toast.makeText(Question.this,"Error, No Data Found !!",Toast.LENGTH_LONG).show();
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
            Toast.makeText(Question.this, buffer.toString(), Toast.LENGTH_LONG).show();
        }

    }
}