package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    Button btnProceed;
    public static EditText nameField;
    Button clearData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        final DBArgument data = new DBArgument(this);

        btnProceed = (Button) findViewById(R.id.proceedTest);

        nameField = (EditText) findViewById(R.id.editName);

        clearData = (Button) findViewById(R.id.button4);

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fp=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(fp);

            }
        });

        clearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.DeleteAll();

            }
        });
    }

}
