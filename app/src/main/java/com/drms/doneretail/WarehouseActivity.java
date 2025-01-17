package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.Console;
import java.text.DateFormat;
import java.util.Calendar;

public class WarehouseActivity extends AppCompatActivity {



    private ImageButton button;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getSupportActionBar().hide();

        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                //WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_warehouse);

        Calendar calendar =  Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        mediaPlayer = MediaPlayer.create(this, R.raw.sample);
        //TextView textViewDate = findViewById(R.id.date);
        //textViewDate.setText(currentDate);
        //button = button.findViewById(R.id.btn_stock);

        button = (ImageButton) findViewById(R.id.imageButton1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStockActivity();

                //mediaPlayer.start();
            }
        });

        button = (ImageButton) findViewById(R.id.imageButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrdersActivity();
                //mediaPlayer.start();
            }
        });

        button = (ImageButton) findViewById(R.id.imageButton3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSupplierActivity();
                //mediaPlayer.start();
            }
        });

        button = (ImageButton) findViewById(R.id.imageButton4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShopsActivity();
                //mediaPlayer.start();
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStockActivity();
                openOrdersActivity();
                openSupplierActivity();
                openShopsActivity();

            }
        });

    }


    //Methods to open  each activity
    public void openStockActivity(){
        Intent intent = new Intent(this, StockActivity.class);
        startActivity(intent);

    }

    public void openOrdersActivity(){
        Intent intent = new Intent(this, OrdersActivity.class);
        startActivity(intent);

    }

    public void openSupplierActivity(){
        Intent intent = new Intent(this, SuppliersActivity.class);
        startActivity(intent);

    }

    public void openShopsActivity(){
        Intent intent = new Intent(this, ShopsActivity.class);
        startActivity(intent);

    }
}
