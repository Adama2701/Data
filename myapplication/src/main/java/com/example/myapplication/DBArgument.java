package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Adama on 2/19/2017.
 */

public class DBArgument {
    private DBHandler dbHandler;
    private SQLiteDatabase sqLiteDatabase;

    public DBArgument(Context context){
        dbHandler = new DBHandler(context);
        sqLiteDatabase = dbHandler.getWritableDatabase();
    }

    public long InsertTest(Test test){
        ContentValues content = new ContentValues();
        content.put(DBHandler.KEY_NAME,test.getName());
        content.put(DBHandler.KEY_SCORE,test.getScore());

        return sqLiteDatabase.insert(DBHandler.TABLE_GUESS,null,content);
    }
    public Cursor selectTest(){
        String[] columns = new String[] {DBHandler.KEY_ID, DBHandler.KEY_NAME, DBHandler.KEY_SCORE};

        Cursor cursor = sqLiteDatabase.query(true,DBHandler.TABLE_GUESS,columns,null,null,null,null,null,null);
        if(cursor !=null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public void DeleteAll(){
        sqLiteDatabase.delete(DBHandler.TABLE_GUESS,null,null);
        sqLiteDatabase.execSQL("delete from " + dbHandler.TABLE_GUESS);
        sqLiteDatabase.close();
    }

}
