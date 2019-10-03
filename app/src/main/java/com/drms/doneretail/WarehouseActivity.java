package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class WarehouseActivity extends AppCompatActivity {


    private Button button;
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

        button = (Button) findViewById(R.id.btn_stock);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStockActivity();
                //mediaPlayer.start();
            }
        });

        button = (Button) findViewById(R.id.btn_order);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrdersActivity();
                //mediaPlayer.start();
            }
        });

        button = (Button) findViewById(R.id.btn_supplier);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSupplierActivity();
                //mediaPlayer.start();
            }
        });

        button = (Button) findViewById(R.id.btn_shops);
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
