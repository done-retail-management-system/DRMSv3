package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WarehouseActivity extends AppCompatActivity {


    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse);

        //button = button.findViewById(R.id.btn_stock);

        button = (Button) findViewById(R.id.btn_stock);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStockActivity();
            }
        });

        button = (Button) findViewById(R.id.btn_order);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrdersActivity();
            }
        });

        button = (Button) findViewById(R.id.btn_supplier);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSupplierActivity();
            }
        });

        button = (Button) findViewById(R.id.btn_shops);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShopActivity();
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStockActivity();
                openOrdersActivity();
                openSupplierActivity();
                openShopActivity();
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

    public void openShopActivity(){
        Intent intent = new Intent(this, ShopsActivity.class);
        startActivity(intent);

    }
}
