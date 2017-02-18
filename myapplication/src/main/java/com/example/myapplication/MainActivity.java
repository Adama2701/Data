package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.VectorEnabledTintResources;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {
    Button btnRed;
    Button btnBlue;
    Button btnYellow;
    Button btnVisual;
    int arrayIndex = 0;
    int arrayLength = 50;
    boolean guess = false;
    String choice = "";

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
                showColors(v, "r");
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showColors(v, "b");
            }
        });

        btnYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showColors(v, "y");
            }
        });

        btnVisual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showColors(view, "");

            }
        });
    }
    private void showColors(View view, String input){
        Handler handler = new Handler();
        final String stringer = randomcolor.get(arrayIndex);

        if (arrayIndex < arrayLength && !guess) {
            choice = "";

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
                handler.postDelayed(run, 1000 * i);

            }
            guess = true;
        }
        else if (arrayIndex < arrayLength && guess) {
            if (choice.length() < stringer.length()) {
                choice = choice + input + "w";
                showColors(view, input);
            }
        }
            else if(choice.equals(stringer)){
               arrayIndex ++;
                guess = false;
            }
            else{
                System.out.println("WRONG");
            }

    }
}