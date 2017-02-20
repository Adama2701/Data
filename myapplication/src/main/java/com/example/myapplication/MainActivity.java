package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button btnRed;
    Button btnBlue;
    Button btnYellow;
    Button btnVisual;
    EditText nameField;
    int score;
    int arrayIndex = 0;
    int arrayLength = 50;
    boolean guess = false;
    String choice = "";
    String stringer;
    String sut;

    ArrayList<String> randomcolor;
    Logic logic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button3 is red-button
        btnRed = (Button) findViewById(R.id.button3);
        //button2 is yellow-button
        btnBlue = (Button) findViewById(R.id.button2);
        //button is blue-button
        btnYellow = (Button) findViewById(R.id.button);
        //button5 is visual-button
        btnVisual = (Button) findViewById(R.id.button5);


        logic = new Logic();
        randomcolor = logic.colorSequence(arrayLength);
        System.out.println(randomcolor);

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guess){
                    choice = choice + "r" + "w";
                    checkInput();
                }
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guess){
                    choice = choice + "b" + "w";
                    checkInput();
                }
            }
        });

        btnYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guess){
                    choice = choice + "y" + "w";
                    checkInput();
                }
            }
        });

        btnVisual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showColors();

            }
        });



        DBArgument data = new DBArgument(this);
        Cursor cursor = data.selectTest();


        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            System.out.println(cursor.getColumnName(0)+": "+cursor.getInt(0)+ " | "+ cursor.getColumnName(1)+ ": "+ cursor.getString(1)+" | "+cursor.getColumnName(2)+
                    ": "+cursor.getInt(2));
            cursor.moveToNext();
        }

    }
    private void showColors(){
        Handler handler = new Handler();
        stringer = randomcolor.get(arrayIndex);

        btnBlue.setEnabled(false);
        btnRed.setEnabled(false);
        btnYellow.setEnabled(false);

        if (arrayIndex < arrayLength && !guess) {

            for (int i = 0; i < stringer.length(); i++) {

                final int finali = i;
                final Runnable run = new Runnable() {
                    @Override
                    public void run() {
                        btnVisual.setVisibility(View.VISIBLE);
                        if (String.valueOf(stringer.charAt(finali)).equals("r")) {
                            btnVisual.setBackgroundColor(Color.RED);
                        } else if (String.valueOf(stringer.charAt(finali)).equals("b")) {
                            btnVisual.setBackgroundColor(Color.BLUE);

                        } else if (String.valueOf(stringer.charAt(finali)).equals("y")) {
                            btnVisual.setBackgroundColor(Color.YELLOW);

                        }
                        else if (String.valueOf(stringer.charAt(finali)).equals("w")){
                            btnVisual.setVisibility(View.INVISIBLE);
                        }
                    }
                };
                handler.postDelayed(run, 750 * i);

            }
            choice = "";
            guess = true;
            btnBlue.setEnabled(true);
            btnRed.setEnabled(true);
            btnYellow.setEnabled(true);

        }

    }

    private void checkInput(){

        if(choice.equals(stringer)){
            arrayIndex ++;
            guess = false;
            showColors();
        }else if (choice.length() == stringer.length()){
            Intent intent = new Intent(getBaseContext(), DoneActivity.class);
            String temp = (stringer.length()/2)-1 + "";
            score = Integer.parseInt(temp);
            intent.putExtra("Data", temp);

            DBArgument data = new DBArgument(this);

            EditText kat = (EditText) NameActivity.nameField.findViewById(R.id.editName);
            String string = kat.getText().toString();
            Test foo = new Test(score,string);
            data.InsertTest(foo);
            startActivity(intent);

        }
    }



}