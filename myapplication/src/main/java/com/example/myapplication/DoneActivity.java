package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoneActivity extends AppCompatActivity {


    Button retry;
    TextView amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);


        retry = (Button) findViewById(R.id.return_button);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(intent);
            }
        });

        amount = (TextView) findViewById(R.id.amount);
        String result = getIntent().getStringExtra("Data");
        System.out.println(result);
        amount.setText(result);

    }
}