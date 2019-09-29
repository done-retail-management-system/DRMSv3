package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddNewStock extends AppCompatActivity {

    public static TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_stock);

        textView = (TextView)findViewById(R.id.textViewBar);
        button = (Button)findViewById(R.id.buttonBarScan);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNewStock.this, ScanActivity.class);
                startActivity(intent);
            }


        });
    }
}
