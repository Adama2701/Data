package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Adama on 2/19/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "guessInfo";
    // Contacts table name
    private static final String TABLE_GUESS = "guessTable";
    // Guess Table Columns names
    private static final String KEY_ID ="id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SCORE = "score";



    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_GUESS_TABLE = "CREATE TABLE" + TABLE_GUESS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_SCORE + " TEXT " + ")";

        db.execSQL(CREATE_GUESS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop old table if it exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GUESS );

        //creates new table
        onCreate(db);
    }
}
