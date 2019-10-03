package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

public class AddNewStock extends AppCompatActivity {


    Spinner spinner;
    public static TextInputEditText textInput;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_stock);

        textInput = (TextInputEditText)findViewById(R.id.viewBar);
        button = (Button)findViewById(R.id.buttonBarScan);
        spinner =(Spinner)findViewById(R.id.spinnerCategory);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNewStock.this, ScanActivity.class);
                startActivity(intent);
            }


        });
    }
}
