package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class aisles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aisles);
    }
    public void checkIn(View view) {
        Intent breakfast_intent  = new Intent(this, list_Items.class);
        startActivity(breakfast_intent);
    }

    public void orders(View view) {
        Intent cooldrink_intent  = new Intent(this, list_Items.class);
        startActivity(cooldrink_intent);
    }

    public void stock(View view) {
        Intent toys_intent  = new Intent(this, list_Items.class);
        startActivity(toys_intent);
    }

}
