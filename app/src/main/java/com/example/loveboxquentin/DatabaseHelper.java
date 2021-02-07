package com.example.loveboxquentin;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.BaseColumns;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    //version
    private static final int DATABASE_VERSION = 1;
    //nom database
    private static final String DATABASE_NAME = "LoveQuestions.db";

    //Noms des tables
    private static final String TABLE_QUESTION_NAME = "question";

    //Supprimer SQL
    private static final String SQL_DELETE_QUESTION = "DROP TABLE question ";
    //private static final String SQL_DELETE_MATCH = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    //Colonnes de la table
    public static class FeedEntry implements BaseColumns
    {
        public static final String COLUMN_QUESTION_ID = "id";
        public static final String COLUMN_MATCH_QUESTION= "question";
        public static final String COLUMN_MATCH_BOOL= "lu";

    }

    //Creation de la table (requete SQL)
    public static final String EQUIPE_QUESTION_CREATE =
            "CREATE TABLE " + TABLE_QUESTION_NAME + "(" +
                    FeedEntry.COLUMN_QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FeedEntry.COLUMN_MATCH_QUESTION + " TEXT, " +
                    FeedEntry.COLUMN_MATCH_BOOL + " INTEGER) ";


    //Insertion dans la table question
    public boolean insertDataMatch(String question)
    {
        int booleanQuestion = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_MATCH_QUESTION, question);
        values.put(FeedEntry.COLUMN_MATCH_BOOL, booleanQuestion);

        long result = db.insert(TABLE_QUESTION_NAME, null, values);

        if(result == -1) { return false; }
        else { return true; }

    }

    //Récupération de toutes les données
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_QUESTION_NAME, null);
        return result;
    }

    //Récupération de toutes les questions
    public Cursor getAllQuestion()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT " + FeedEntry.COLUMN_MATCH_QUESTION + " FROM " + TABLE_QUESTION_NAME, null);
        return result;
    }


    //Récupération des 5 derniers matchs pour MainActivity
    //A REMPLIR !!!
    /*public List<MatchC> getQuestionsNonLues()
    {
        List<MatchC> matchs = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT " + FeedEntry.COLUMN_MATCH_ID + ", " +
                FeedEntry.COLUMN_MATCH_EQUIPE1 + ", " +
                FeedEntry.COLUMN_MATCH_EQUIPE2 + ", " +
                FeedEntry.COLUMN_MATCH_DATE + " FROM " + TABLE_EQUIPE_NAME +
                " ORDER BY " + FeedEntry.COLUMN_MATCH_DATE + " DESC LIMIT 5", null);

        return matchs;
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EQUIPE_QUESTION_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_QUESTION);
        onCreate(db);
    }
}