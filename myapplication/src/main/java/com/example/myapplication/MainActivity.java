package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        randomcolor = logic.colorSequence(3);

        btnVisual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler handler = new Handler();

                if (arrayIndex < 3) {
                    final String stringer = randomcolor.get(arrayIndex);
                    for (int i = 0; i < stringer.length(); i++) {

                        final int finali = i;
                        final Runnable run = new Runnable() {
                            @Override
                            public void run() {
                                if (String.valueOf(stringer.charAt(finali)).equals("r")) {
                                    btnVisual.setBackgroundColor(Color.RED);
                                } else if (String.valueOf(stringer.charAt(finali)).equals("b")) {
                                    btnVisual.setBackgroundColor(Color.BLUE);

                                } else if (String.valueOf(stringer.charAt(finali)).equals("y")) {
                                    btnVisual.setBackgroundColor(Color.YELLOW);

                                }
                            }
                        };
                        handler.postDelayed(run, 1000 * i);

                    }
                    arrayIndex++;
                }

            }
        });
    }
}