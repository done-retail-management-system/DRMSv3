package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Shelf_Dash extends AppCompatActivity implements View.OnClickListener{

    private CardView instock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelf__dash);
        //Define Cards
        instock = (CardView) findViewById(R.id.instock);

        //Add Click Listner to Card
        instock.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;
        
    }
}
