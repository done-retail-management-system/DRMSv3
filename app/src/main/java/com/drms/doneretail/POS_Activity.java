package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class POS_Activity extends AppCompatActivity{

    public static String barcode;
    ListView item_cart;
    FloatingActionButton scan_item;
    SimpleAdapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_pos_);

        item_cart = findViewById(R.id.list_Cart);
        scan_item = findViewById(R.id.btnScan);
        scan_item.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), ScannerBarcode.class));
               /* List<Map<String,String>> data = null;
                CheckItem getData = new CheckItem();
                data = getData.doInBackground();

                String[] retrieve_From = {"Sales Number", "Date", "Total Price"};
                int[] viewLocation = new int[]{R.id.txtID, R.id.txtdate, R.id.txtTotal};
                adapt = new SimpleAdapter(POS_Activity.this,data,R.layout.listview,retrieve_From,viewLocation);

                item_cart.setAdapter(adapt);*/
            }
        });



    }

}
